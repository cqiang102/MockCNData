package cn.lacia.mockcndata.generators;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

/**
 * @author caoq
 * @since 2025-07-08 10:41
 */
public class ChineseNameGeneratorTest {

    @Test
    public void testGenerateName() {
        ChineseNameGenerator generator = new ChineseNameGenerator();
        String name = generator.generate();

        // 验证姓名不为空
        assertNotNull(name);
        assertFalse(name.isEmpty());

        // 验证姓名长度在2-4个字符之间
        assertTrue(name.length() >= 2 && name.length() <= 4);

        // 验证姓名只包含中文字符
        assertTrue(name.matches("[\\u4E00-\\u9FA5]+"));
    }

    @Test
    public void testDoubleSurname() {
        ChineseNameGenerator generator = new ChineseNameGenerator();
        int doubleSurnameCount = 0;
        int total = 10000;

        for (int i = 0; i < total; i++) {
            String name = generator.generate();
            if (name.length() > 2 &&
                    generator.getSurnames().contains(name.substring(0, 1)) &&
                    generator.getSurnames().contains(name.substring(1, 2))) {
                doubleSurnameCount++;
            }
        }

        // 验证双姓概率在4-6%之间 (理论5%)
        double probability = (double) doubleSurnameCount / total;
        assertTrue(probability > 0.04 && probability < 0.06,
                "双姓概率应在4-6%之间，实际为: " + (probability * 100) + "%");
    }
    
}
