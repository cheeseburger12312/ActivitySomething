package Pos;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String menuChoice;
        String selectedCategory;
        int selectedQuantity = 0;
        double totalPrice = 0;

        String selectedMainItem = "";
        String selectedDessertItem = "";
        String selectedDrinkItem = "";

        String orderSummary = "";
        String itemName = "";

        int itemPrice = 0;
        double itemTotal = itemPrice * selectedQuantity;

        boolean showOrderSummary = false;
        boolean isOrderingComplete = false;
        boolean stopOrdering = false;
        boolean wantsToGoBack = false;
        boolean isValidInput = false;
        boolean isUserChoiceNo = false;

        String mainMenu = """
            ╔═══════ FOOD STORE POS ═════════╗
            ║  [1][New Sale]                 ║
            ║  [2][Exit]                     ║
            ╚════════════════════════════════╝""";
        System.out.println(mainMenu);
        boolean isValidChoice = false;

        do {
            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                System.out.print("\n");
            }

            System.out.print("Enter your choice: ");
            menuChoice = scanner.nextLine().toLowerCase();
            if (menuChoice.equals("1") || menuChoice.equals("new sale")) {
                isValidChoice = true;
            } else if (menuChoice.equals("2") || menuChoice.equals("exit")) {
                isValidChoice = true;
                isOrderingComplete = true;
                showOrderSummary = false;
                stopOrdering = true;
            } else {
                System.out.println("Please input a valid value");
            }
        } while (!isValidChoice);

        selectedCategory = "";

        do {
            switch (menuChoice) {
                case "1":
                case "new sale":
                    do {
                        wantsToGoBack = false;
                        String orderMoreChoice;
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
                            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                System.out.print("\n");
                            }
                            System.out.print("Enter your choice: ");
                            selectedCategory = scanner.nextLine().toLowerCase();
                            if (selectedCategory.equals("1") || selectedCategory.equals("main")) {
                                isValidCategory = true;
                            } else if (selectedCategory.equals("2") || selectedCategory.equals("dessert")) {
                                isValidCategory = true;
                            } else if (selectedCategory.equals("3") || selectedCategory.equals("drinks")) {
                                isValidCategory = true;
                            } else if (selectedCategory.equals("4") || selectedCategory.equals("exit")) {
                                isValidCategory = true;
                            } else {
                                System.out.println("Please input right value");
                            }
                        } while (!isValidCategory);

                        switch (selectedCategory) {
                            case "1":
                            case "main":
                                boolean isValidMainChoice = false;
                                do {
                                    String mainMenuChoice = """
                                        ╔═════════ Select Category ═════════╗
                                        ║  [1][Cheeseburger][P25]           ║
                                        ║  [2][Fried Chicken][P30]          ║
                                        ║  [3][Back]                        ║
                                        ╚═══════════════════════════════════╝ """;
                                    System.out.println(mainMenuChoice);

                                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                        System.out.print("\n");
                                    }
                                    System.out.print("Enter your choice: ");
                                    selectedMainItem = scanner.nextLine().toLowerCase();

                                    switch (selectedMainItem) {
                                        case "1":
                                        case "cheeseburger":
                                            itemPrice = 25;
                                            itemName = "Cheeseburger";
                                            isValidMainChoice = true;
                                            break;

                                        case "2":
                                        case "fried chicken":
                                            itemPrice = 30;
                                            itemName = "Fried Chicken,";
                                            isValidMainChoice = true;
                                            break;

                                        case "3":
                                        case "back":
                                            wantsToGoBack = true;
                                            isValidMainChoice = true;
                                            break;
                                    }
                                } while (!isValidMainChoice);

                                if (!wantsToGoBack) {
                                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                        System.out.print("\n");
                                    }

                                    System.out.print("Enter quantity of " + itemName + ": ");

                                    isValidInput = false;
                                    do {
                                        try {
                                            selectedQuantity = scanner.nextInt();
                                            itemTotal = itemPrice * selectedQuantity;

                                            isValidInput = true;
                                            totalPrice += itemTotal;
                                            receiptItems += itemName + "\n";
                                            orderSummary += itemName + " P" + itemTotal + "\n";

                                            scanner.nextLine();
                                            System.out.println("");

                                            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                                System.out.print("\n");
                                            }

                                            isUserChoiceNo = false;
                                            do {
                                                System.out.print("Would you like to add another item? (Y/N): ");
                                                orderMoreChoice = scanner.nextLine().toLowerCase();

                                                if (orderMoreChoice.equals("n")) {
                                                    isUserChoiceNo = true;
                                                    isOrderingComplete = true;
                                                    showOrderSummary = true;
                                                } else if (orderMoreChoice.equals("y")) {
                                                    isUserChoiceNo = true;
                                                } else {
                                                    System.out.println("Please enter (Y/N) only");
                                                }
                                            } while (!isUserChoiceNo);

                                        } catch (InputMismatchException e) {
                                            System.out.print("Pls only enter a Number: ");
                                            scanner.nextLine();
                                        }
                                    } while (!isValidInput);
                                    break;
                                } else {
                                    break;
                                }

                            case "2":
                            case "dessert":
                                boolean isValidDessertChoice = false;
                                do {
                                    String dessertMenuChoice = """
                                        ╔═════════ Select Category ═════════╗
                                        ║  [1][Cookie][P15]                 ║
                                        ║  [2][Apple pie][P25]              ║
                                        ║  [3][Back]                        ║
                                        ╚═══════════════════════════════════╝ """;
                                    System.out.println(dessertMenuChoice);

                                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                        System.out.print("\n");
                                    }
                                    System.out.print("Enter your choice: ");
                                    selectedDessertItem = scanner.nextLine().toLowerCase();

                                    switch (selectedDessertItem) {
                                        case "1":
                                        case "cookie":
                                            itemPrice = 15;
                                            itemName = "Cookie";
                                            isValidDessertChoice = true;
                                            break;

                                        case "2":
                                        case "apple pie":
                                            itemPrice = 25;
                                            itemName = "Apple pie";
                                            isValidDessertChoice = true;
                                            break;

                                        case "3":
                                        case "back":
                                            wantsToGoBack = true;
                                            isValidDessertChoice = true;
                                            break;
                                    }
                                } while (!isValidDessertChoice);

                                if (!wantsToGoBack) {
                                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                        System.out.print("\n");
                                    }

                                    System.out.print("Enter quantity of " + itemName + ": ");

                                    isValidInput = false;
                                    do {
                                        try {
                                            selectedQuantity = scanner.nextInt();
                                            itemTotal = itemPrice * selectedQuantity;
                                            totalPrice += itemTotal;
                                            isValidInput = true;
                                            totalPrice += itemTotal;

                                            receiptItems += itemName + "\n";
                                            orderSummary += itemName + " P" + itemTotal + "\n";

                                            scanner.nextLine();
                                            System.out.println("");

                                            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                                System.out.print("\n");
                                            }

                                            isUserChoiceNo = false;
                                            do {
                                                System.out.print("Would you like to add another item? (Y/N): ");
                                                orderMoreChoice = scanner.nextLine().toLowerCase();

                                                if (orderMoreChoice.equals("n")) {
                                                    isUserChoiceNo = true;
                                                    isOrderingComplete = true;
                                                    showOrderSummary = true;
                                                } else if (orderMoreChoice.equals("y")) {
                                                    isUserChoiceNo = true;
                                                } else {
                                                    System.out.println("Please enter (Y/N) only");
                                                }
                                            } while (!isUserChoiceNo);

                                        } catch (InputMismatchException e) {
                                            System.out.println("Pls only enter a Number");
                                            scanner.nextLine();
                                        }
                                    } while (!isValidInput);
                                    break;
                                } else {
                                    break;
                                }

                            case "3":
                            case "drinks":
                                boolean isValidDrinkChoice = false;
                                do {
                                    String drinkMenuChoice = """
                                        ╔═════════ Select Category ═════════╗
                                        ║  [1][Coke][P10]                   ║
                                        ║  [2][Sprite][P10]                 ║
                                        ║  [3][Back]                        ║
                                        ╚═══════════════════════════════════╝ """;
                                    System.out.println(drinkMenuChoice);

                                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                        System.out.print("\n");
                                    }
                                    System.out.print("Enter your choice: ");
                                    selectedDrinkItem = scanner.nextLine().toLowerCase();

                                    switch (selectedDrinkItem) {
                                        case "1":
                                        case "coke":
                                            itemPrice = 10;
                                            itemName = "Coke";
                                            isValidDrinkChoice = true;
                                            break;

                                        case "2":
                                        case "sprite":
                                            itemPrice = 10;
                                            itemName = "Sprite";
                                            isValidDrinkChoice = true;
                                            break;

                                        case "3":
                                        case "back":
                                            wantsToGoBack = true;
                                            isValidDrinkChoice = true;
                                            break;
                                    }
                                } while (!isValidDrinkChoice);

                                if (!wantsToGoBack) {
                                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                        System.out.print("\n");
                                    }
                                    System.out.print("Enter quantity of " + itemName + ": ");

                                    isValidInput = false;
                                    do {
                                        try {
                                            selectedQuantity = scanner.nextInt();
                                            itemTotal = itemPrice * selectedQuantity;
                                            totalPrice += itemTotal;
                                            isValidInput = true;
                                            receiptItems += itemName + "\n";
                                            orderSummary += itemName + " P" + itemTotal + "\n";

                                            scanner.nextLine();
                                            System.out.println("");

                                            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                                                System.out.print("\n");
                                            }

                                            isUserChoiceNo = false;
                                            do {
                                                System.out.print("Would you like to add another item? (Y/N): ");
                                                orderMoreChoice = scanner.nextLine().toLowerCase();

                                                if (orderMoreChoice.equals("n")) {
                                                    isUserChoiceNo = true;
                                                    isOrderingComplete = true;
                                                    showOrderSummary = true;
                                                } else if (orderMoreChoice.equals("y")) {
                                                    isUserChoiceNo = true;
                                                } else {
                                                    System.out.println("Please enter (Y/N) only");
                                                }
                                            } while (!isUserChoiceNo);
                                            break;

                                        } catch (InputMismatchException e) {
                                            System.out.println("Pls only enter a Number");
                                            scanner.nextLine();
                                        }
                                    } while (!isValidInput);
                                    break;
                                } else {
                                    break;
                                }

                            case "4":
                            case "exit":
                                isOrderingComplete = true;
                                stopOrdering = true;
                                break;
                        }
                    } while (!isOrderingComplete);
                    break;

                case "2":
                case "exit":
                    stopOrdering = true;
                    break;

                default:
                    System.out.println("Please Enter a valid value");
            }

            if (showOrderSummary) {
                do {
                    for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                        System.out.print("\n");
                    }
                    System.out.println(orderSummary);
                    System.out.print("is this the right order? (Y/N): ");

                    String orderVerification = scanner.nextLine().toLowerCase();

                    if (orderVerification.equals("n")) {
                        isOrderingComplete = true;
                        showOrderSummary = false;
                        orderSummary = "";
                    } else if (orderVerification.equals("y")) {
                        stopOrdering = true;
                        showOrderSummary = false;
                    } else {
                        System.out.println("Please input (Y/N) only");
                    }
                } while (showOrderSummary);
            }
        } while (!stopOrdering);

        if (stopOrdering && !orderSummary.isEmpty()) {
            double cashEntered = 0;
            boolean isValidCash = false;

            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                System.out.print("\n");
            }
            System.out.println("================================");
            System.out.println("          FINAL RECEIPT         ");
            System.out.println("================================");
            System.out.println(orderSummary);
            System.out.println("--------------------------------");
            System.out.println("Total Amount Due: P" + totalPrice);

            do {
                try {
                    System.out.print("Enter cash amount: P");
                    cashEntered = scanner.nextDouble();

                    if (cashEntered >= totalPrice) {
                        isValidCash = true;
                    } else {
                        System.out.println("Insufficient cash. Please enter an amount greater than or equal to P" + totalPrice);
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Please enter a valid number for cash.");
                    scanner.nextLine(); // clear invalid input
                }
            } while (!isValidCash);

            double change = cashEntered - totalPrice;

            for (int blankLineIndex = 0; blankLineIndex < 2; blankLineIndex++) {
                System.out.print("\n");
            }
            System.out.println("================================");
            System.out.println("            CHANGE              ");
            System.out.println("================================");
            System.out.println("Cash Tendered : P" + cashEntered);
            System.out.println("Change Due    : P" + change);
            System.out.println("================================");
            System.out.println("   Thank you for your order!    ");
            System.out.println("================================");
        } else {
            System.out.println("\nTransaction cancelled or no items ordered.");
        }

        scanner.close();
    }
}