package cn.lacia.mockcndata.generators;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.core.ResourceLoader;

/**
 * @author caoq
 * @since 2025-07-08 10:38
 * 中文企业信息生成器
 */
public class CompanyGenerator {

    // 企业名称组成部分
    private static final String[] COMPANY_TYPES = ResourceLoader.loadArray("data/chinese_company_types.txt");
    private static final String[] COMPANY_SUFFIXES = ResourceLoader.loadArray("data/chinese_company_suffixes.txt");
    private static final String[] INDUSTRY_KEYWORDS = {
            "科技", "信息", "网络", "软件", "数据", "智能",
            "电子", "数码", "通信", "互联网", "云计算", "人工智能"
    };
    private static final String[] PRODUCT_KEYWORDS = {
            "创新", "未来", "智慧", "全球", "卓越", "领先",
            "先锋", "时代", "新纪元", "无限", "互联", "云端"
    };

    /**
     * 生成随机企业名称
     *
     * @return 企业名称
     */
    public String generateCompanyName() {
        // 选择公司类型
        String companyType = RandomUtils.randomElement(COMPANY_TYPES);

        // 生成核心名称部分
        String coreName = generateCoreName();

        // 添加后缀
        String suffix = RandomUtils.randomElement(COMPANY_SUFFIXES);

        return coreName + companyType + suffix;
    }

    /**
     * 生成企业核心名称 (行业+产品关键词)
     */
    private String generateCoreName() {
        String industry = RandomUtils.randomElement(INDUSTRY_KEYWORDS);
        String product = RandomUtils.randomElement(PRODUCT_KEYWORDS);

        // 20%概率添加城市前缀
        if (RandomUtils.nextDouble() < 0.2) {
            String[] cities = ResourceLoader.loadArray("data/chinese_cities.txt");
            String city = RandomUtils.randomElement(cities).split(" ")[1];
            return city + industry + product;
        }

        return industry + product;
    }
}
