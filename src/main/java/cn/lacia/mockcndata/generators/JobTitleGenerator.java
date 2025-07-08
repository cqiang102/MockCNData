package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 11:50
 * 职务生成器
 */
public class JobTitleGenerator {
    private static final String[] JOB_TITLES = ResourceLoader.loadArray("data/chinese_job_titles.txt");

    /**
     * 生成随机职务名称
     */
    public String generate() {
        return RandomUtils.randomElement(JOB_TITLES);
    }

    /**
     * 根据部门生成相关职务
     */
    public String generateForDepartment(String department) {
        String baseTitle = RandomUtils.randomElement(JOB_TITLES);

        // 为特定部门定制职务
        if (department.contains("技术") || department.contains("研发")) {
            String[] techTitles = {"工程师", "架构师", "开发", "测试", "运维"};
            return baseTitle + RandomUtils.randomElement(techTitles);
        } else if (department.contains("销售") || department.contains("市场")) {
            String[] salesTitles = {"代表", "顾问", "专员", "经理"};
            return baseTitle + (baseTitle.endsWith("经理") ? "" : RandomUtils.randomElement(salesTitles));
        } else if (department.contains("财务")) {
            String[] financeTitles = {"会计", "出纳", "分析师", "专员"};
            return baseTitle + (baseTitle.endsWith("经理") ? "" : RandomUtils.randomElement(financeTitles));
        }

        return baseTitle;
    }
}
