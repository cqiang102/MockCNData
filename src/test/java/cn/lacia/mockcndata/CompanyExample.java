package cn.lacia.mockcndata;

import cn.lacia.mockcndata.model.Company;

/**
 * @author caoq
 * @since 2025-07-08 11:33
 */
public class CompanyExample {
    public static void main(String[] args) {
        MockCNData generator = new MockCNData();

        // 生成企业名称
        System.out.println("企业名称: " + generator.generateCompanyName());

        // 生成完整企业信息
        Company company = generator.generateCompany();
        System.out.println("\n完整企业信息:");
        System.out.println(company);

        // 批量生成5个企业信息
        System.out.println("\n批量生成的企业信息:");
        generator.generateCompanies(5).forEach(System.out::println);
    }
}
