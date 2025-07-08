package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:51
 * 民族生成器
 */
public class EthnicGroupGenerator {
    private static final String[] ETHNIC_GROUPS = ResourceLoader.loadArray("data/chinese_ethnic_groups.txt");
    private static final double[] ETHNIC_PROBABILITIES = new double[ETHNIC_GROUPS.length];

    static {
        // 设置概率分布（汉族占91.5%，其他民族共占8.5%）
        ETHNIC_PROBABILITIES[0] = 0.915; // 汉族
        double otherProb = 0.085 / (ETHNIC_GROUPS.length - 1);
        for (int i = 1; i < ETHNIC_GROUPS.length; i++) {
            ETHNIC_PROBABILITIES[i] = otherProb;
        }
    }

    /**
     * 生成随机民族
     */
    public String generate() {
        double rand = RandomUtils.nextDouble();
        double cumulative = 0.0;

        for (int i = 0; i < ETHNIC_GROUPS.length; i++) {
            cumulative += ETHNIC_PROBABILITIES[i];
            if (rand < cumulative) {
                return ETHNIC_GROUPS[i];
            }
        }

        return "汉族"; // 默认值
    }
}
