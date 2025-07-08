package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 电话号码生成器
 */
public class PhoneGenerator {

    // 手机号前缀
    private static final String[] MOBILE_PREFIXES = {
            "130", "131", "132", "133", "134", "135", "136", "137", "138", "139",
            "150", "151", "152", "153", "155", "156", "157", "158", "159",
            "170", "171", "172", "173", "174", "175", "176", "177", "178",
            "180", "181", "182", "183", "184", "185", "186", "187", "188", "189"
    };

    // 区号 (部分中国城市区号)
    private static final String[] AREA_CODES = {
            "010", "021", "022", "023", "024", "025", "027", "028", "029",
            "0311", "0351", "0371", "0411", "0431", "0451", "0512", "0531", "0571",
            "0591", "0731", "0755", "020", "0510", "0532", "0574", "0791", "0871"
    };

    /**
     * 生成随机手机号码
     */
    public String generateMobile() {
        String prefix = RandomUtils.randomElement(MOBILE_PREFIXES);
        String suffix = RandomUtils.randomNumeric(8);
        return prefix + suffix;
    }

    /**
     * 生成随机固定电话号码
     */
    public String generateLandline() {
        String areaCode = RandomUtils.randomElement(AREA_CODES);
        // 7位或8位号码
        int length = RandomUtils.randomInt(7, 8);
        String number = RandomUtils.randomNumeric(length);
        return areaCode + "-" + number;
    }

    /**
     * 生成电话号码 (80%概率手机号，20%概率固话)
     */
    public String generate() {
        if (RandomUtils.nextDouble() < 0.8) {
            return generateMobile();
        }
        return generateLandline();
    }
}
