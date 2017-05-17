package Entities;

import java.util.Date;


public class Student {
   private String name;
   private String fatherName;
   private String lastName;
   private int phone;
   private int curClass;
   private Date birthDate;
   private boolean gender;
   private String email;

    public Student(String name, String fatherName, String lastName, int phone, int curClass, Date birthDate, boolean gender, String email) {
        this.name = name;
        this.fatherName = fatherName;
        this.lastName = lastName;
        this.phone = phone;
        this.curClass = curClass;
        this.birthDate = birthDate;
        this.gender = gender;
        this.email = email;
    }
   
   public void setName(String Name){
       this.name= Name;
   }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public void setCurClass(int curClass) {
        this.curClass = curClass;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getPhone() {
        return phone;
    }

    public int getCurClass() {
        return curClass;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public boolean isGender() {
        return gender;
    }

    public String getEmail() {
        return email;
    }
    
    
}
