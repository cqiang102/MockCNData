package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:51
 * 大学生成器
 */
public class UniversityGenerator {
    private static final String[] UNIVERSITIES = ResourceLoader.loadArray("data/chinese_universities.txt");

    /**
     * 生成随机大学名称
     */
    public String generate() {
        return RandomUtils.randomElement(UNIVERSITIES);
    }
}
