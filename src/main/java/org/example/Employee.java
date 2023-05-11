package org.example;

public class Employee {

    //Variables for class Employee
    protected String firstName;
    protected String lastName;
    protected String department;


    //Constructor
    public Employee (String firstName, String lastName, String department){
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
    }

    //Setters and Getters for all variables
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee" + "\n" +
                "FirstName='" + firstName + "\n" +
                "LastName='" + lastName + "\n" +
                "Department='" + department;
    }
}
