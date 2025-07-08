package cn.lacia.mockcndata.generators;

import java.time.LocalDate;
import java.util.Random;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 营业执照生成器
 */
public class BusinessLicenseGenerator {

    // 登记管理部门代码
    private static final char[] MANAGEMENT_CODES = {'1', '5', '9', 'Y'};

    // 机构类别代码
    private static final char[] ORGANIZATION_TYPES = {'1', '2', '3', '9'};

    // 校验码权重
    private static final int[] LICENSE_WEIGHT = {1, 3, 9, 27, 19, 26, 16, 17, 20, 29, 25, 13, 8, 24, 10, 30, 28};
    private static final char[] LICENSE_CHECK_CODES = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K',
            'L', 'M', 'N', 'P', 'Q', 'R', 'T', 'U', 'W', 'X', 'Y'
    };

    // 行政区划代码
    private static final String[] AREA_CODES = ResourceLoader.loadArray("data/chinese_area_codes.txt");

    /**
     * 生成营业执照号 (统一社会信用代码)
     */
    public String generate() {
        Random random = new Random();

        // 1. 登记管理部门代码
        char managementCode = MANAGEMENT_CODES[random.nextInt(MANAGEMENT_CODES.length)];

        // 2. 机构类别代码
        char orgType = ORGANIZATION_TYPES[random.nextInt(ORGANIZATION_TYPES.length)];

        // 3. 登记管理机关行政区划码 (6位)
        String areaCode = AREA_CODES[random.nextInt(AREA_CODES.length)];

        // 4. 主体标识码 (9位)
        StringBuilder entityCode = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            // 字母或数字
            if (random.nextDouble() < 0.3) {
                char c = (char) ('A' + random.nextInt(26));
                entityCode.append(c);
            } else {
                entityCode.append(random.nextInt(10));
            }
        }

        // 5. 组合前17位并计算校验位
        String prefix = "" + managementCode + orgType + areaCode + entityCode;
        char checkCode = calculateLicenseCheckCode(prefix);

        return prefix + checkCode;
    }

    private char calculateLicenseCheckCode(String prefix) {
        int sum = 0;
        for (int i = 0; i < 17; i++) {
            char c = prefix.charAt(i);
            int value = Character.isDigit(c) ? (c - '0') : (c - 'A' + 10);
            sum += value * LICENSE_WEIGHT[i];
        }
        int mod = 31 - (sum % 31);
        if (mod == 31) {
            mod = 0;
        }
        return LICENSE_CHECK_CODES[mod % 31];
    }

    /**
     * 生成成立日期 (过去1-20年)
     */
    /**
     * 生成成立日期 (过去1-20年) - Java 8 兼容
     */
    public LocalDate generateEstablishDate() {
        int currentYear = LocalDate.now().getYear();
        int year = currentYear - RandomUtils.randomInt(1, 20);
        int month = RandomUtils.randomInt(1, 12);

        // 确保日期有效，避免2月30日等问题
        int maxDay = LocalDate.of(year, month, 1).lengthOfMonth();
        int day = RandomUtils.randomInt(1, maxDay);

        return LocalDate.of(year, month, day);
    }
}
