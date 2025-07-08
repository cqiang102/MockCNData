package cn.lacia.mockcndata.model;

import java.time.LocalDate;

/**
 * @author caoq
 * @since 2025-07-08 10:39
 * 企业信息模型
 */
public class Company {
    private String name;
    private String businessLicense;
    private LocalDate establishDate;
    private String address;
    private String phone;
    private String legalPerson;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusinessLicense() {
        return businessLicense;
    }

    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    public LocalDate getEstablishDate() {
        return establishDate;
    }

    public void setEstablishDate(LocalDate establishDate) {
        this.establishDate = establishDate;
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

    public String getLegalPerson() {
        return legalPerson;
    }

    public void setLegalPerson(String legalPerson) {
        this.legalPerson = legalPerson;
    }

    @Override
    public String toString() {
        return String.format(
                "公司名称: %s\n营业执照: %s\n成立日期: %s\n地址: %s\n电话: %s\n法人代表: %s",
                name, businessLicense, establishDate, address, phone, legalPerson
        );
    }
}