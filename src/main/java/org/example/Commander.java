package org.example;

import java.util.*;

public class Commander {



    private int selection;
    public void buildMenu(){

        //Creates Scanner Object
        Scanner sc = new Scanner(System.in);

        //flag variable to allow repetition of menu during certain criteria
        boolean flag = false;
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

            //Menu Input
            System.out.print("Selection: ");
            selection = sc.nextInt();
            sc.nextLine();

            //If statement to alter flag variable based on certain conditions
            if(selection < 1 || selection > 5){
                flag = true;
            }
        }
        while (flag);

        switch (selection) {
            case 1 -> System.out.println("1");
            case 2 -> System.out.println("2");
            case 3 -> System.out.println("3");
            case 4 -> System.out.println("4");
            case 5 -> System.out.println("5");
        }


        //Message to repeat main menu
        System.out.print("Would you Like to return to the main menu? (Y/N): ");
        char isRepeat = Character.toLowerCase(sc.next().charAt(0));
        sc.nextLine();

        //If statement to repeat
        if (isRepeat == 'y'){
            buildMenu();
        }
        else {
            System.out.println("Thank you!");
            sc.close();
            System.exit(0);
        }


    }

    public void createEmployee(){
        //Create scanner object
        Scanner sc = new Scanner(System.in);



        System.out.println(" ");
        System.out.println("Employee Creator");

        //Take Employee Information
        System.out.print("Enter the Employee's first name: ");
        String firstName = sc.nextLine();
        System.out.print("Enter the Employee's last name: ");
        String lastName = sc.nextLine();
        System.out.print("Enter the Employee's department: ");
        String department = sc.nextLine();

        //Create employee object and use variables to call eNew constructor
        Employee eNew = new Employee(firstName, lastName, department);




    }

}
