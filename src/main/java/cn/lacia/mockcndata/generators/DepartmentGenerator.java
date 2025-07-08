package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:50
 * 部门生成器
 */
public class DepartmentGenerator {
    private static final String[] DEPARTMENTS = ResourceLoader.loadArray("data/chinese_departments.txt");

    /**
     * 生成随机部门名称
     */
    public String generate() {
        return RandomUtils.randomElement(DEPARTMENTS);
    }
}
