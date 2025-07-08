package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:51
 * 专业生成器
 */
public class MajorGenerator {
    private static final String[] MAJORS = ResourceLoader.loadArray("data/chinese_majors.txt");

    /**
     * 生成随机专业名称
     */
    public String generate() {
        return RandomUtils.randomElement(MAJORS);
    }
}
