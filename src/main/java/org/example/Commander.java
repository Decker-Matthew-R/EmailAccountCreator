package org.example;

import java.util.*;

public class Commander {

    private Employee eNew;
    private EmailAccount newEmail;


    public void buildMenu(){

        //Creates Scanner Object
        Scanner sc = new Scanner(System.in);

        //flag variable to allow repetition of menu during certain criteria
        boolean flag = false;
        int selection;
        do {
            //Intro to Menu
            System.out.println("Welcome");
            System.out.println(" ");
            System.out.println("Please Select From the Following Options: ");

            //Menu Options Build
            System.out.println("1. Create an Email Account");
            System.out.println("2. Change Password");
            System.out.println("3. Recover Password");
            System.out.println("4. Change Alternate Email");
            System.out.println("5. Display Employee Email Info");
            System.out.println("6. Log Out");

            //Menu Input
            System.out.print("Selection: ");
            selection = sc.nextInt();
            sc.nextLine();

            //If statement to alter flag variable based on certain conditions
            if (selection < 1 || selection > 6) {
                System.out.println("Invalid Option");
                System.exit(0);
            }


            switch (selection) {
                case 1 -> {
                    System.out.println(" ");
                    eNew = createNewEmployee();
                    System.out.println(" ");
                    newEmail = createNewEmployeeEmail(eNew);
                    System.out.println(" ");
                    System.out.println("New User Created");
                    System.out.println("New User Information:");
                    System.out.println(eNew.toString());
                    System.out.println(newEmail.toString());

                }
                case 2 -> {
                    changePassword(newEmail);
                    System.out.println(newEmail.getPassword());
                }
                case 3 -> {
                    String password = retrievePassword(newEmail);
                    System.out.println(password);
                }
                case 4 -> System.out.println("4");
                case 5 -> {
                    System.out.println(" ");
                    System.out.println("Customer Information: ");
                    System.out.println(eNew.toString());
                    System.out.println(" ");
                    System.out.println(newEmail.toString());
                }
                case 6 -> {
                    System.out.println("Your are logged out.");
                    System.exit(0);
                    }
            }


        }
        while (flag);
    }


    public Employee createNewEmployee() {
        //Create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("Employee Creator");

        //Take Employee Information
        System.out.print("Enter the Employee's first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter the Employee's last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter the Employee's department: ");
        String department = sc.nextLine();

        //create new Employee object
        return new Employee(firstName, lastName, department);
    }
    public  EmailAccount createNewEmployeeEmail(Employee eNew){

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        //Enter Email Account Admin Information
        System.out.print("Enter default password length: ");
        int pwLength = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter new user email capacity(GB): ");
        int emailCapacityGB = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter the recover email: ");
        String recoveryEmail = sc.nextLine();

        //Create employee object and use variables to call eNew constructor
        return new EmailAccount(pwLength, emailCapacityGB, recoveryEmail, eNew);
    }

    public void changePassword(EmailAccount newEmail){


        //Create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("Password Creator");

        int attempts = 0;
        boolean flag = false;
        do {
            //Take Admin Information for user password
            System.out.println(" ");
            System.out.println("Please enter your current password: ");
            String userPW = sc.nextLine();
            attempts++;
            if (attempts > 3){
                System.out.println("You have reached the maximum number of attempts");
            }

            String newPassword = "";
            do {
                if (newEmail.getPassword().equals(userPW)) {
                    System.out.println("Please enter a new password. The password must be at 5 or more characters/numbers");
                    newPassword = sc.nextLine();
                    newEmail.setPassword(newPassword);
                    if (newPassword.length() < 5){
                        System.out.println("Password must be 5 or more characters.");
                    }
                } else {
                    flag = true;
                }
            }
            while(newPassword.length() < 5);
        }
        while(flag);

    }

    public String retrievePassword(EmailAccount newEmail){
        String password = "";

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        //Password recovery
        System.out.println("Password Recovery");
        System.out.println(" ");
        System.out.println("Enter work email address: ");
        String workEmail = sc.nextLine();
        if (workEmail.equals(newEmail.getEmailAddress())){
            password = newEmail.getPassword();

        }
        else {
            System.out.println("Not a valid email.");
            System.exit(1);
        }

        return password;
    }

}
