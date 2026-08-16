package Pos;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); 

        String userChoice = "";
        String userChoiceCategory = "";
        String userChoiceQuantityItem = "";
        double totalPrice = 0;

        //Main
        String userChoiceMainItem = "";

        //Desert
        String userChoiceItemDessert = "";

        String finalList = "";
        String finalListQuantity = "";

        String NumInString = "";

        int MainItemPrice = 0;
        int DessertItemPrice = 0;

        boolean showOrderSummary = false;
        boolean isDoneOrdering = false;
        

        // int userChoiceNum = 0;

        String mainMenu = """ 
            ╔═══════ FOOD STORE POS ═════════╗
            ║  [1][New Sale]                 ║
            ║  [2][Exit]                     ║
            ╚════════════════════════════════╝""";
        System.out.println(mainMenu);
        boolean isValidChoice = false;

        
        do {
            for (int i = 0; i < 1; i++) {
                System.out.print("\n");
            }

            System.out.println("Enter your choice: ");
            userChoice = scanner.nextLine().toLowerCase();
            if (userChoice.equals("1") || userChoice.equals("new sale")) {
                isValidChoice = true;    
            } else if (userChoice.equals("2") || userChoice.equals("exit")) {
                isValidChoice = true;
            } else {
                System.out.println("Please input right value");
            }

        } while (!isValidChoice);

        //menu
        isDoneOrdering = false;
        userChoiceCategory = "";
        switch (userChoice) { 
            case "1":
            case "new sale":
            do {
                String orderMoreChoice = " ";
                boolean isValidCategory = false;
                String categorySelection = """ 
                    ╔═════════ Select Category ═════════╗
                    ║  [1][Main]                        ║
                    ║  [2][Dessert]                     ║
                    ║  [3][Drinks]                      ║
                    ║  [4][Exit]                        ║
                    ╚═══════════════════════════════════╝ """;
                    System.out.println(categorySelection);

                do {
                    userChoiceCategory = scanner.nextLine().toLowerCase();
                    if (userChoiceCategory.equals("1") || userChoiceCategory.equals("main")) {
                        isValidCategory = true;
                    } else if (userChoiceCategory.equals("2") || userChoiceCategory.equals("dessert")) {
                        isValidCategory = true;
                    } else if (userChoiceCategory.equals("3") || userChoiceCategory.equals("drinks")) {
                        isValidCategory = true;
                    } else if (userChoiceCategory.equals("4") || userChoiceCategory.equals("exit")) {
                        isValidCategory = true;
                    } else {
                        System.out.println("Please input right value");
                    }
                } while (!isValidCategory);

                    switch (userChoiceCategory) {
                        case "1": 
                        case "main": 
                            boolean isValidChoiceMainCategory = false;
                            do { 
                                String ChoiceMain = """ 
                                    ╔═════════ Select Category ═════════╗
                                    ║  [1][Cheeseburger][P25]           ║
                                    ║  [2][Fried Chicken][P30]          ║
                                    ║  [3][Back]                        ║
                                    ╚═══════════════════════════════════╝ """;
                                System.out.println(ChoiceMain);

                                userChoiceMainItem = scanner.nextLine().toLowerCase();
                                    
                                switch (userChoiceMainItem) {

                                    case "1":
                                    case "cheeseburger": 
                                        NumInString = "Cheeseburger";
                                        MainItemPrice += 25; 
                                        isValidChoiceMainCategory = true; break;

                                    case "2":
                                    case "Fried Chicken": 
                                        NumInString = "Fried Chicken";
                                        MainItemPrice += 30; 
                                        isValidChoiceMainCategory = true; break;

                                    case "3":
                                    case "back": 
                                        isValidChoiceMainCategory = true; break;
                                    } 

                                } while (!isValidChoiceMainCategory);

                                System.out.println("Enter quantity of " + NumInString + ": ");

                                finalList += " " + NumInString;

                                userChoiceQuantityItem = scanner.nextLine();
                                
                                finalListQuantity += " " +  userChoiceQuantityItem;

                                int quantity = Integer.parseInt(userChoiceQuantityItem);
                                double itemTotal = MainItemPrice * quantity;
                                totalPrice += itemTotal;
                                
                                scanner = new Scanner(System.in);
                                System.out.println("");

                                System.err.println(userChoiceQuantityItem);

                                System.out.print("Would you like to add another item? (Y/N): ");
                                orderMoreChoice = scanner.nextLine().toLowerCase();
                                if (orderMoreChoice.equals("n")) {isDoneOrdering = true; showOrderSummary = true;}
                                break;


                            case "2": 
                            case "dessert":
                                boolean isValidChoiceDessertCategory = false;
                                do { 
                                    String ChoiceDessert = """ 
                                        ╔═════════ Select Category ═════════╗
                                        ║  [1][Cookie][P15]                 ║
                                        ║  [2][Apple pie][P25]              ║
                                        ║  [3][Back]                        ║
                                        ╚═══════════════════════════════════╝ """;
                                    System.out.println(ChoiceDessert);

                                    
                                    userChoiceItemDessert = scanner.nextLine().toLowerCase();
                                        
                                    switch (userChoiceItemDessert) {

                                        case "1":
                                        case "cookie": 
                                            NumInString = "Cookie";
                                            DessertItemPrice += 15;
                                            isValidChoiceDessertCategory = true; 
                                            break;

                                        case "2":
                                        case "apple pie": 
                                            NumInString = "Apple pie";
                                            DessertItemPrice += 25;
                                            isValidChoiceDessertCategory = true; 
                                            break;

                                        case "3":
                                        case "back": 
                                            isValidChoiceDessertCategory = true; 
                                            break;
                                        } 

                                    } while (!isValidChoiceDessertCategory);

                                    System.out.println("Enter quantity of " + NumInString + ": ");

                                    finalList += " " + NumInString;

                                    userChoiceQuantityItem = scanner.nextLine();
                                    finalListQuantity += " " +  userChoiceQuantityItem;

                                    int quantityDessert = Integer.parseInt(userChoiceQuantityItem);
                                    double itemTotalDessert = DessertItemPrice * quantityDessert;
                                    totalPrice += itemTotalDessert;

                                    scanner = new Scanner(System.in);
                                    System.out.println("");

                                    System.out.print("Would you like to add another item? (Y/N): ");
                                    orderMoreChoice = scanner.nextLine().toLowerCase();
                                    if (orderMoreChoice.equals("n")) {isDoneOrdering = true; showOrderSummary = true;}
                                    break;



                            case "3": 
                            case "drinks": System.out.println("test"); break;

                            case "4": 
                            case "exit": System.out.println("test"); break;
                        }

                } while (!isDoneOrdering);
                break;

                case "2":
                case "exit": System.out.println("Exit"); break;

                default: System.out.println("theres no shit");
        }

        //summary
        do {
            System.out.println("[" + finalList + "]" + " " + "[" + finalListQuantity + "]");
            System.out.print("is this the right order? (Y/N): ");
            String orderVerification = " ";
            orderVerification = scanner.nextLine().toLowerCase();
            if (orderVerification.equals("n")) {
                isDoneOrdering = true; 
                showOrderSummary = false; 
                finalList = "";
                finalListQuantity = "";
            } else if (orderVerification.equals("y")) {
                showOrderSummary = false; 
            } else {System.out.println("Please input (Y/N) only");}
            showOrderSummary = false;
        } while (showOrderSummary);

        //calculation
        System.out.println(totalPrice); //if print right price booyah fuck hell yeah




        System.out.println("printing this means it run successfully while passing others");




            scanner.close();
        
            
        


    }
}