package cn.lacia.mockcndata.generators;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * @author caoq
 * @since 2025-07-08 10:41
 */
public class IDCardGeneratorTest {

    @Test
    public void testGenerateIDCard() {
        IDCardGenerator generator = new IDCardGenerator();
        String idCard = generator.generate();

        // 验证长度
        assertEquals(18, idCard.length());

        // 验证校验位
        char actualCheckDigit = idCard.charAt(17);
        char expectedCheckDigit = generator.calculateCheckCode(idCard.substring(0, 17));
        assertEquals(expectedCheckDigit, actualCheckDigit);

        // 验证出生日期部分
        String birthDate = idCard.substring(6, 14);
        assertDoesNotThrow(() -> {
            LocalDate.parse(birthDate, java.time.format.DateTimeFormatter.BASIC_ISO_DATE);
        });
    }

    @Test
    public void testExtractGender() {
        IDCardGenerator generator = new IDCardGenerator();

        // 测试男性身份证
        String maleIdCard = "110101199001011234"; // 最后一位为4，偶数应为女，但校验位不对
        // 构造有效的男性身份证
        maleIdCard = "11010119900101123X".substring(0, 16) + "1"; // 奇数位
        maleIdCard = maleIdCard.substring(0, 17) + generator.calculateCheckCode(maleIdCard.substring(0, 17));
        assertEquals("男", generator.extractGender(maleIdCard));

        // 测试女性身份证
        String femaleIdCard = "11010119900101123X".substring(0, 16) + "2"; // 偶数位
        femaleIdCard = femaleIdCard.substring(0, 17) + generator.calculateCheckCode(femaleIdCard.substring(0, 17));
        assertEquals("女", generator.extractGender(femaleIdCard));
    }
}