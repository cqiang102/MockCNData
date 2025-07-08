package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:51
 * 学历生成器
 */
public class EducationGenerator {
    private static final String[] EDUCATION_LEVELS = ResourceLoader.loadArray("data/chinese_education_levels.txt");
    private static final double[] EDUCATION_PROBABILITIES = {0.05, 0.10, 0.15, 0.05, 0.15, 0.35, 0.10, 0.05};

    /**
     * 生成随机学历
     */
    public String generate() {
        double rand = RandomUtils.nextDouble();
        double cumulative = 0.0;

        for (int i = 0; i < EDUCATION_LEVELS.length; i++) {
            cumulative += EDUCATION_PROBABILITIES[i];
            if (rand < cumulative) {
                return EDUCATION_LEVELS[i];
            }
        }

        return "本科"; // 默认值
    }
}
