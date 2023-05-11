package org.example;

public class EmailAccount {

    //Variables for class Email Account
    protected String emailAddress;
    protected String password;
    protected int emailCapacityGB;
    protected String recoveryEmail;
    protected Employee employee;

    //Setters and Getters for class EmailAccount
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEmailCapacityGB() {
        return emailCapacityGB;
    }

    public void setEmailCapacityGB(int emailCapacityGB) {
        this.emailCapacityGB = emailCapacityGB;
    }

    public String getRecoveryEmail() {
        return recoveryEmail;
    }

    public void setRecoveryEmail(String recoveryEmail) {
        this.recoveryEmail = recoveryEmail;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }




}
