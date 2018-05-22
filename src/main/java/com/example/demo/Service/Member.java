package com.example.demo.Service;

import javax.validation.constraints.Min;
import java.util.List;

public class Member {


    private int ID;
    private String firstName;
    private String lastname;
    private String username;
    private String password;
    private int age;
    private String email;
    private String country;
    private String address;
    private String zipcode;
    private int role;
    /*private List<String> list = null;*/

    public Member(){}

    public Member(int ID, String firstname, String lastname, String username, String password, int age, String email, String country, String address, String zipcode, int role) {
        this.ID = ID;
        this.firstName = firstname;
        this.lastname = lastname;
        this.username = username;
        this.password = password;
        this.age = age;
        this.email = email;
        this.country = country;
        this.address = address;
        this.zipcode = zipcode;
        this.role = role;
    }

    public Member(int ID,String firstname,String lastname, String username, String country,String address){

        this.ID = ID;
        this.firstName = firstname;
        this.lastname = lastname;
        this.username = username;
        this.country = country;
        this.address = address;
    }

    public int getID() {
        return ID;
    }
    public void setID(int ID) {
        this.ID = ID;
    }
    public String getFirstname() {
        return firstName;
    }
    public void setFirstname(String firstname) {
        this.firstName = firstname;
    }
    public String getLastname() {
        return lastname;
    }
    public void setLastname(String lastname) {
        this.lastname = lastname;
    }
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public String getZipcode() {
        return zipcode;
    }
    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }
    public int getRole(){
        return role;
    }
    public void setRole(int role){
        this.role = role;
    }
    public String toString()
    {
        return "Firstname = " + firstName +  " Lastname = " +  lastname + " Age = " + age + " Email = " + email + " Country = " + country + " Zipcode = " + zipcode + " Role = "+ role + " Address = " + address;
    }

   /* public List<String> getList() { return list; }

    public void setList(final List<String> list) {
        this.list = list;
    }*/

    public String toStringUsername(){
        return "Username = " + username + " Password = " + password;
    }

    public String usernameToString()
    {
        return username;
    }

}
