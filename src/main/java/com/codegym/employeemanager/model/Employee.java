package com.codegym.employeemanager.model;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private boolean gender;
    private String phone;
    private String birthday;
    private String cmnd;
    private String email;
    private String address;
    @ManyToOne
    @JoinColumn(name = "group_id")
    private Group group;

    public Employee() {
    }

    public Employee(String name, boolean gender, String phone, String birthday, String cmnd, String email, String address, Group group) {
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.birthday = birthday;
        this.cmnd = cmnd;
        this.email = email;
        this.address = address;
        this.group = group;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getCmnd() {
        return cmnd;
    }

    public void setCmnd(String cmnd) {
        this.cmnd = cmnd;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", phone='" + phone + '\'' +
                ", birthday='" + birthday + '\'' +
                ", cmnd='" + cmnd + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", group=" + group +
                '}';
    }
}
