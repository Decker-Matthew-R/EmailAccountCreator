package org.example;

import java.util.*;

public class Commander {

    private Employee eNew;
    private EmailAccount newEmail;


    public void buildMenu() {

        //Creates Scanner Object
        Scanner sc = new Scanner(System.in);

        //flag variable to allow repetition of menu during certain criteria
        boolean flag = true;
        int selection;
        do {
            //Intro to Menu
            System.out.println(" ");
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
                flag = true;
            } else {
                flag = false;
            }
        }
        while (flag) ;


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
                        System.out.println(" ");
                        System.out.println(newEmail.toString());

                    }
                    case 2 -> {
                        System.out.println(" ");
                        changePassword(newEmail);
                        System.out.println("New Password: " + newEmail.getPassword());
                    }
                    case 3 -> {
                        System.out.println(" ");
                        String password = retrievePassword(newEmail);
                        System.out.println("Password: " + password);
                    }
                    case 4 -> {
                        changeRecoveryEmail(newEmail);
                        System.out.println(newEmail.getRecoveryEmail());
                    }

                    case 5 -> {
                        System.out.println(" ");
                        System.out.println("Customer Information: ");
                        System.out.println(eNew.toString());
                        System.out.println(" ");
                        System.out.println(newEmail.toString());
                    }
                    case 6 -> {
                        System.out.println("Your are logged out.");
                        flag = false;
                        System.exit(0);
                    }
                }


            }

    //Alteration Methods

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

        System.out.println("Employee Creator");

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

    public void changePassword(EmailAccount newEmail) {

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        System.out.println("Password Creator");

//
        String userPW = " ";
        int attempts = 0;
        boolean flag = true;
        do {
            if (attempts > 0) {
                System.out.println("Incorrect Password. Try again.");
            }
            attempts++;
            //Take Admin Information for user password
            System.out.print("Please enter your current password: ");
            userPW = sc.nextLine();
            if (attempts > 3) {
                System.out.println("You have reached the maximum number of attempts");
            }
        }
        while (!newEmail.getPassword().equals(userPW));

        String newPW;
        do {
            System.out.print("Enter a new password (password must be 5 characters or greater): ");
            newPW = sc.nextLine();
            if (newPW.length() < 5) {
                System.out.println("Password must be 5 characters or greater.");
            } else {
                newEmail.setPassword(newPW);
            }
        }
            while (newPW.length() < 5) ;
    }

    public String retrievePassword(EmailAccount newEmail){
        String password = "";

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        //Password recovery
        System.out.println("Password Recovery");
        System.out.println(" ");
        System.out.print("Enter work email address: ");
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

    public void changeRecoveryEmail(EmailAccount newEmail){

        //Create scanner object
        Scanner sc = new Scanner(System.in);

        //Change Email
        System.out.println(" ");
        System.out.print("Enter the new alternate email address: ");
        String newRecoveryEmail = sc.nextLine();

        //Set method call
        newEmail.setRecoveryEmail(newRecoveryEmail);
    }

}
