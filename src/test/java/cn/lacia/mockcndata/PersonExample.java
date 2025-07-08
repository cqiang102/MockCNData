package cn.lacia.mockcndata;

import cn.lacia.mockcndata.model.Person;

/**
 * @author caoq
 * @since 2025-07-08 11:34
 */
public class PersonExample {
    public static void main(String[] args) {
        MockCNData generator = new MockCNData();

        // 生成单个数据项
        System.out.println("随机姓名: " + generator.generateChineseName());
        System.out.println("随机身份证: " + generator.generateIDCard());
        System.out.println("随机地址: " + generator.generateAddress());

        // 生成完整个人信息
        Person person = generator.generatePerson();
        System.out.println("\n完整个人信息:");
        System.out.println(person);

        // 批量生成10个个人信息
        System.out.println("\n批量生成的个人信息:");
        generator.generatePersons(10).forEach(System.out::println);
    }
}
