package com.example.demo.Common;

public class Common {
    private Integer InitialDeposit;
    private String Name;
    private String PanCard;
    private String UserName;
    private String Password;

    public Common() {}

    public Common(Integer initialDeposit, String name, String panCard, String userName, String password) {
        InitialDeposit = initialDeposit;
        Name = name;
        PanCard = panCard;
        UserName = userName;
        Password = password;
    }

    public Integer getInitialDeposit() {
        return InitialDeposit;
    }

    public void setInitialDeposit(Integer initialDeposit) {
        InitialDeposit = initialDeposit;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPanCard() {
        return PanCard;
    }

    public void setPanCard(String panCard) {
        PanCard = panCard;
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

    @Override
    public String toString() {
        return "Common{" +
                "InitialDeposit=" + InitialDeposit +
                ", Name='" + Name + '\'' +
                ", PanCard='" + PanCard + '\'' +
                ", UserName='" + UserName + '\'' +
                ", Password='" + Password + '\'' +
                '}';
    }
}
