package cn.lacia.mockcndata.generators;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 身份证生成器
 */
public class IDCardGenerator {
    // 行政区划代码
    private static final String[] AREA_CODES = ResourceLoader.loadArray("data/chinese_area_codes.txt");
    private static final Random RANDOM = new Random();

    // 身份证校验码计算权重
    private static final int[] WEIGHT = {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2};
    private static final char[] CHECK_CODES = {'1', '0', 'X', '9', '8', '7', '6', '5', '4', '3', '2'};

    /**
     * 生成随机身份证号
     */
    public String generate() {
        // 1. 随机选择行政区划
        String areaCode = AREA_CODES[RANDOM.nextInt(AREA_CODES.length)];

        // 2. 生成出生日期 (18-65岁之间)
        int minYear = LocalDate.now().getYear() - 65;
        int maxYear = LocalDate.now().getYear() - 18;
        int year = minYear + RANDOM.nextInt(maxYear - minYear + 1);
        int month = 1 + RANDOM.nextInt(12);
        int day = 1 + RANDOM.nextInt(LocalDate.of(year, month, 1).lengthOfMonth());
        String birthDate = String.format("%04d%02d%02d", year, month, day);

        // 3. 生成顺序码 (3位)
        String sequence = String.format("%03d", RANDOM.nextInt(1000));

        // 4. 组合前17位并计算校验位
        String prefix = areaCode + birthDate + sequence;
        char checkCode = calculateCheckCode(prefix);

        return prefix + checkCode;
    }

    // 计算校验码
    char calculateCheckCode(String prefix) {
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            sum += (prefix.charAt(i) - '0') * WEIGHT[i];
        }
        return CHECK_CODES[sum % 11];
    }

    // 从身份证提取出生日期
    public LocalDate extractBirthDate(String idCard) {
        String birthDateStr = idCard.substring(6, 14);
        return LocalDate.parse(birthDateStr, DateTimeFormatter.BASIC_ISO_DATE);
    }

    // 从身份证提取性别
    public String extractGender(String idCard) {
        char genderCode = idCard.charAt(16);
        return (genderCode - '0') % 2 == 0 ? "女" : "男";
    }
}
