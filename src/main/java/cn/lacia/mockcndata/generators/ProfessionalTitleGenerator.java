package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:50
 * 职称生成器
 */
public class ProfessionalTitleGenerator {
    private static final String[] PROFESSIONAL_TITLES = ResourceLoader.loadArray("data/chinese_professional_titles.txt");

    /**
     * 生成随机职称
     */
    public String generate() {
        return RandomUtils.randomElement(PROFESSIONAL_TITLES);
    }

    /**
     * 根据学历生成相关职称
     */
    public String generateForEducation(String education) {
        if ("博士".equals(education)) {
            String[] highTitles = {"研究员", "教授", "主任医师", "高级工程师"};
            return RandomUtils.randomElement(highTitles);
        } else if ("硕士".equals(education)) {
            String[] midTitles = {"副研究员", "副教授", "副主任医师", "工程师"};
            return RandomUtils.randomElement(midTitles);
        } else if ("本科".equals(education)) {
            String[] lowTitles = {"助理研究员", "讲师", "医师", "助理工程师"};
            return RandomUtils.randomElement(lowTitles);
        }
        return RandomUtils.randomElement(PROFESSIONAL_TITLES);
    }
}
