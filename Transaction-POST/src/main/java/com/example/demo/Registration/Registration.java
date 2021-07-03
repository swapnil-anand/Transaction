package com.example.demo.Registration;


import com.example.demo.Account.Account;

import javax.persistence.*;

@Entity
@Table(name = "registration_table")
public class Registration {
    private @Id @GeneratedValue(strategy = GenerationType.IDENTITY) Integer RegistrationId;
    private String Name;
    private String UserName;
    private String Password;

    @OneToOne
    @JoinTable(
            name = "Account_Registration_ids",
            joinColumns = @JoinColumn(name = "RegistrationId"),
            inverseJoinColumns = @JoinColumn(name = "AccountNumber")
    )
    private Account Account;


    public Registration(){}

    public Registration(String name, String userName, String password) {
        Name = name;
        UserName = userName;
        Password = password;
    }

    public Integer getRegistrationId() {
        return RegistrationId;
    }

    public void setRegistrationId(Integer id) {
        RegistrationId = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

}
