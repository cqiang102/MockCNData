package cn.lacia.mockcndata;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import cn.lacia.mockcndata.core.RandomUtils;
import cn.lacia.mockcndata.generators.AddressGenerator;
import cn.lacia.mockcndata.generators.BankCardGenerator;
import cn.lacia.mockcndata.generators.BusinessLicenseGenerator;
import cn.lacia.mockcndata.generators.ChineseNameGenerator;
import cn.lacia.mockcndata.generators.CompanyGenerator;
import cn.lacia.mockcndata.generators.DepartmentGenerator;
import cn.lacia.mockcndata.generators.EducationGenerator;
import cn.lacia.mockcndata.generators.EthnicGroupGenerator;
import cn.lacia.mockcndata.generators.IDCardGenerator;
import cn.lacia.mockcndata.generators.JobTitleGenerator;
import cn.lacia.mockcndata.generators.MajorGenerator;
import cn.lacia.mockcndata.generators.PhoneGenerator;
import cn.lacia.mockcndata.generators.ProfessionalTitleGenerator;
import cn.lacia.mockcndata.generators.UniversityGenerator;
import cn.lacia.mockcndata.model.Company;
import cn.lacia.mockcndata.model.Employee;
import cn.lacia.mockcndata.model.Person;

/**
 * @author caoq
 * @since 2025-07-08 10:39
 * 中文测试数据生成主类（增强版）
 */
public class MockCNData {

    // 基础生成器
    private final ChineseNameGenerator nameGenerator = new ChineseNameGenerator();
    private final IDCardGenerator idCardGenerator = new IDCardGenerator();
    private final AddressGenerator addressGenerator = new AddressGenerator();
    private final PhoneGenerator phoneGenerator = new PhoneGenerator();
    private final BankCardGenerator bankCardGenerator = new BankCardGenerator();

    // 新增生成器
    private final EthnicGroupGenerator ethnicGroupGenerator = new EthnicGroupGenerator();
    private final EducationGenerator educationGenerator = new EducationGenerator();
    private final UniversityGenerator universityGenerator = new UniversityGenerator();
    private final MajorGenerator majorGenerator = new MajorGenerator();
    private final DepartmentGenerator departmentGenerator = new DepartmentGenerator();
    private final JobTitleGenerator jobTitleGenerator = new JobTitleGenerator();
    private final ProfessionalTitleGenerator professionalTitleGenerator = new ProfessionalTitleGenerator();

    // 个人信息生成

    /**
     * 生成完整个人信息
     */
    public Person generatePerson() {
        Person person = new Person();
        String idCard = idCardGenerator.generate();

        // 基础信息
        person.setName(nameGenerator.generate());
        person.setIdCard(idCard);
        person.setGender(idCardGenerator.extractGender(idCard));
        person.setBirthDate(idCardGenerator.extractBirthDate(idCard));
        person.setEthnicGroup(ethnicGroupGenerator.generate());

        // 联系信息
        person.setAddress(addressGenerator.generate());
        person.setPhone(phoneGenerator.generate());

        // 教育信息
        person.setEducation(educationGenerator.generate());
        person.setUniversity(universityGenerator.generate());
        person.setMajor(majorGenerator.generate());

        // 职业信息
        person.setBankCard(bankCardGenerator.generate());

        // 30%的概率生成职业信息
        if (new Random().nextDouble() < 0.3) {
            person.setDepartment(departmentGenerator.generate());
            person.setJobTitle(jobTitleGenerator.generate());
            person.setProfessionalTitle(professionalTitleGenerator.generate());
        }

        return person;
    }

    /**
     * 生成员工信息
     */
    public Employee generateEmployee() {
        Employee employee = new Employee();

        // 生成基础个人信息
        Person person = generatePerson();
        employee.setName(person.getName());
        employee.setIdCard(person.getIdCard());
        employee.setGender(person.getGender());
        employee.setBirthDate(person.getBirthDate());
        employee.setEthnicGroup(person.getEthnicGroup());
        employee.setAddress(person.getAddress());
        employee.setPhone(person.getPhone());
        employee.setEducation(person.getEducation());
        employee.setUniversity(person.getUniversity());
        employee.setMajor(person.getMajor());
        employee.setBankCard(person.getBankCard());

        // 员工专属信息
        employee.setDepartment(departmentGenerator.generate());
        employee.setJobTitle(jobTitleGenerator.generateForDepartment(employee.getDepartment()));
        employee.setProfessionalTitle(
                professionalTitleGenerator.generateForEducation(employee.getEducation())
        );

        // 生成员工ID
        employee.setEmployeeId("EMP" + RandomUtils.randomNumeric(6));

        // 入职日期（出生日期+18-25年）
        int hireAge = new Random().nextInt(8) + 18;
        employee.setHireDate(employee.getBirthDate().plusYears(hireAge));

        // 薪资生成（基于学历和职务）
        employee.setSalary(generateSalary(employee.getEducation(), employee.getJobTitle()));

        return employee;
    }

    /**
     * 根据学历和职务生成薪资
     */
    private double generateSalary(String education, String jobTitle) {
        double base = 0;

        // 学历基础薪资
        switch (education) {
            case "小学": base = 3000; break;
            case "初中": base = 4000; break;
            case "高中": base = 5000; break;
            case "中专": base = 5500; break;
            case "大专": base = 6000; break;
            case "本科": base = 8000; break;
            case "硕士": base = 12000; break;
            case "博士": base = 20000; break;
            default: base = 7000;
        }

        // 职务加成
        if (jobTitle.contains("经理")) {
            base *= 1.8;
        } else if (jobTitle.contains("总监")) {
            base *= 2.5;
        } else if (jobTitle.contains("总裁")) {
            base *= 4.0;
        } else if (jobTitle.contains("工程师")) {
            base *= 1.2;
        } else if (jobTitle.contains("教授") || jobTitle.contains("研究员")) {
            base *= 1.5;
        }

        // 随机浮动
        double variation = 0.2 * (new Random().nextDouble() - 0.5); // -10% 到 +10%
        return base * (1 + variation);
    }

    // 批量生成方法

    public List<Person> generatePersons(int count) {
        List<Person> persons = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            persons.add(generatePerson());
        }
        return persons;
    }

    public List<Employee> generateEmployees(int count) {
        List<Employee> employees = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            employees.add(generateEmployee());
        }
        return employees;
    }

    // 单个数据项生成方法（新增）

    public String generateEthnicGroup() {
        return ethnicGroupGenerator.generate();
    }

    public String generateEducationLevel() {
        return educationGenerator.generate();
    }

    public String generateUniversity() {
        return universityGenerator.generate();
    }

    public String generateMajor() {
        return majorGenerator.generate();
    }

    public String generateDepartment() {
        return departmentGenerator.generate();
    }

    public String generateJobTitle() {
        return jobTitleGenerator.generate();
    }

    public String generateProfessionalTitle() {
        return professionalTitleGenerator.generate();
    }

    public String generateChineseName() {
        return nameGenerator.generate();
    }

    public String generateIDCard() {
        return idCardGenerator.generate();
    }

    public String generateAddress() {
        return addressGenerator.generate();
    }

    public String generateCompanyName() {
        return new CompanyGenerator().generateCompanyName();
    }

    public Company generateCompany() {
        Company company = new Company();
        company.setName(new CompanyGenerator().generateCompanyName());
        company.setBusinessLicense(new BusinessLicenseGenerator().generate());
        return company;
    }

    public List<Company> generateCompanies(int count) {
        List<Company> companies = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            companies.add(generateCompany());
        }
        return companies;
    }

    // ... 原有单个数据项生成方法保持不变 ...
}