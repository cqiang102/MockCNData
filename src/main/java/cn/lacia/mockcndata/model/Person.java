package cn.lacia.mockcndata.model;

import java.time.LocalDate;

/**
 * @author caoq
 * 个人信息模型（更新版）
 */
public class Person {
    // 基础信息
    private String name;
    private String idCard;
    private LocalDate birthDate;
    private String gender;
    private String ethnicGroup;

    // 联系信息
    private String address;
    private String phone;

    // 教育信息
    private String education;
    private String university;
    private String major;

    // 职业信息
    private String bankCard;
    private String department;
    private String jobTitle;
    private String professionalTitle;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getBankCard() {
        return bankCard;
    }

    public void setBankCard(String bankCard) {
        this.bankCard = bankCard;
    }

    // ... 其他getter/setter方法保持不变 ...

    public String getEthnicGroup() {
        return ethnicGroup;
    }

    public void setEthnicGroup(String ethnicGroup) {
        this.ethnicGroup = ethnicGroup;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getProfessionalTitle() {
        return professionalTitle;
    }

    public void setProfessionalTitle(String professionalTitle) {
        this.professionalTitle = professionalTitle;
    }

    @Override
    public String toString() {
        return String.format(
                "姓名: %s\n身份证: %s\n出生日期: %s\n性别: %s\n民族: %s\n" +
                        "学历: %s\n毕业院校: %s\n专业: %s\n地址: %s\n电话: %s\n" +
                        "部门: %s\n职务: %s\n职称: %s\n银行卡: %s",
                name, idCard, birthDate, gender, ethnicGroup,
                education, university, major, address, phone,
                department, jobTitle, professionalTitle, bankCard
        );
    }
}