package org.example;

public class EmailAccount {

    //Variables for class Email Account
    protected String emailAddress;
    protected String password;
    protected int emailCapacityGB;
    protected String recoveryEmail;
    protected Employee employee;

    //Constructor


    public EmailAccount(int length, int emailCapacityGB, String recoveryEmail, Employee employee) {
        this.emailAddress =employee.getFirstName().toLowerCase() + "." + employee.getLastName().toLowerCase() + "@" + employee.getDepartment().toLowerCase().replaceAll("\\s", "") + ".umbrellacorp.com";
        this.password = randomPasswordGenerator(length);
        this.emailCapacityGB = emailCapacityGB;
        this.recoveryEmail = recoveryEmail;
        this.employee = employee;
    }

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

    @Override
    public String toString() {
        return "EmailAccount:" + "\n" +
                "Email Address = " + emailAddress + "\n" +
                "Password = " + password + "\n" +
                "EmailCapacityGB= " + emailCapacityGB + " GB" + "\n" +
                "RecoveryEmail = " + recoveryEmail;
    }

    //Random Password Generator Method
    static String randomPasswordGenerator(int pwLength)
    {

        // choose a Character random from this String
        String AlphaNumericString = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
                + "0123456789"
                + "abcdefghijklmnopqrstuvxyz";

        // create StringBuffer size of AlphaNumericString
        StringBuilder sb = new StringBuilder(pwLength);

        for (int i = 0; i < pwLength; i++) {

            // generate a random number between
            // 0 to AlphaNumericString variable length
            int index
                    = (int)(AlphaNumericString.length()
                    * Math.random());

            // add Character one by one in end of sb
            sb.append(AlphaNumericString
                    .charAt(index));
        }

        return sb.toString();
    }

}
