package model.models;


import java.io.Serializable;


public class Student implements Serializable{
    private String code;
    private String name;
    private String phone;
    private String email;
    private String mountainCode;
    private double tutionFee;
//    constructor
    public Student(){
    }

    public Student(String code, String name, String phone, String email, String mountainCode, double tutionFee) {
        this.code = code;
        this.name = name;
        this.phone = phone;
        this.email = email;
        this.mountainCode = mountainCode;
        this.tutionFee = tutionFee;
    }
//    setter getter

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getMountainCode() {
        return mountainCode;
    }

    public double getTutionFee() {
        return tutionFee;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setMountainCode(String mountainCode) {
        this.mountainCode = mountainCode;
    }

    public void setTutionFee(double tutionFee) {
        this.tutionFee = tutionFee;
    }
    
//    method object
//    @Override
//    public String toString(){
//        return String.format("%s, %s, %s, %s, %s, %5.2f",
//                             code, name, phone, email, mountainCode, tutionFee);
//    }
    @Override
    public String toString() {
        return String.format("%-10s | %-20s | %-10s | MT0%-8s | %.0f",
                code, name, phone, mountainCode, tutionFee);
    }
}
