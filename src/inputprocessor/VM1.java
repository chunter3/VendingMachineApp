// Input Processor for VM-1 (start)
package inputprocessor;

import abstractfactory.AF_VM1;
import abstractfactory.AbstractFactory;
import datastore.DataStore;
import java.util.Scanner;
import mda.MDA;

public class VM1 {

    private MDA<Float> mda;                 // points to MDA object
    private DataStore<Float> ds1;           // points to Datastore object for VM-1
    private AbstractFactory<Float> af_vm1;  // points to concrete factory for VM-1
    private Scanner vm1Scan;

    public void create(float p){
        af_vm1 = new AF_VM1();
        mda = new MDA<>(af_vm1);
        ds1 = af_vm1.getDataStore();
        vm1Scan = new Scanner(System.in);
        
        ds1.setTemp_p(p);
        mda.create();
        noCupsMenu();
    }

    public void coin(float v){
        ds1.setTemp_v(v);
        if(ds1.getCf() + v >= ds1.getPrice()){
          mda.coin(1);
          System.out.println("Coins accepted. Proceeding to drink selection...");
        }
        else{
          mda.coin(0);
        }
    }

    public void card(float x){
        if(x >= ds1.getPrice()){
          mda.card(); 
        }
        else {
            System.out.println("Insufficent funds on card.\n");
        }
    }

    public void sugar(){
        mda.additive(1);
    }

    public void cappuccino(){
        mda.dispose_drink(1);
    }

    public void chocolate(){
        mda.dispose_drink(2);
    }

    public void insert_cups(int n){
        mda.insert_cups(n);
    }

    public void set_price(float p){
        ds1.setTemp_p(p);
        mda.set_price();
    }

    public void cancel(){
        mda.cancel();
    }

    public void noCupsMenu(){
        int insertedCups = 0;
        boolean validCups = false;

        System.out.println("No cups inserted. At least one cup must be inserted to proceed.");
        do {
            System.out.print("Please insert cups: ");
            String cupInput = vm1Scan.nextLine();
            if (cupInput.matches("^[1-9][0-9]*$")) {
                insertedCups = Integer.parseInt(cupInput);
                validCups = true;
            }
            else {    
                System.out.println("Invalid input! You must enter a valid amount of cups (at least 1 cup).");       
            }
        } while (!validCups);
        insert_cups(insertedCups);
        preSelectionMenu(); 
    }

    public void preSelectionMenu(){
        int menuOption = 0;
        
        do {
            System.out.println("Choose from the following:");
            System.out.println("1. Pay via coins");
            System.out.println("2. Pay via card");
            System.out.println("3. Insert cups");
            System.out.println("4. Set price of drinks");
            System.out.println("5. Exit");
            System.out.print("Your choice: ");

            String userChoice = vm1Scan.nextLine();
            if (userChoice.matches("^[0-9]+$")) {
                menuOption = Integer.parseInt(userChoice);
                switch (menuOption) {
                    case 1 -> {
                        float insertedCoins = 0;
                        boolean validCoin = false;
                        System.out.println();
                        do {
                            System.out.print("Please insert coins: $");
                            String coinInput = vm1Scan.nextLine();

                            // The following regex ensures inputted coins is strictly non-negative
                            if (coinInput.matches("^(0|[1-9][0-9]*)(\\.[0-9]{1,2})?$|^\\.[0-9]{1,2}$")) {
                                insertedCoins = Float.parseFloat(coinInput);
                                validCoin = true;
                            } else {
                                System.out.println("Invalid amount. Please insert a valid amount of coins.");
                            }
                        } while (!validCoin);
                        coin(insertedCoins);
                        if (mda.getCurrState().getStateId() == 3) {
                            drinkSelectionMenu();
                        }
                    }
                    case 2 -> {
                        float cardAmount = 0;
                        boolean validCard = false;
                        System.out.println();
                        do {
                            System.out.print("Please insert card and amount: $");
                            String cardInput = vm1Scan.nextLine();
                            if (cardInput.matches("^(0|[1-9][0-9]*)(\\.[0-9]{1,2})?$|^\\.[0-9]{1,2}$")) {
                                cardAmount = Float.parseFloat(cardInput);
                                validCard = true;
                            } else {
                                System.out.println("Invalid amount! Card rejected. Please enter a valid amount.");
                            }
                        } while (!validCard);
                        card(cardAmount);
                        if (mda.getCurrState().getStateId() == 3) {
                            drinkSelectionMenu();
                        }
                    }
                    case 3 -> {
                        int insertedCups = 0;
                        boolean validCups = false;
                        System.out.println();
                        do {
                            System.out.print("Please insert cups: ");
                            String cupInput = vm1Scan.nextLine();
                            if (cupInput.matches("^[1-9][0-9]*$")) {
                                insertedCups = Integer.parseInt(cupInput);
                                validCups = true;
                            }
                            else {    
                                System.out.println("Invalid input! You must enter a valid amount of cups (at least 1 cup).");       
                            }
                        } while (!validCups);
                        insert_cups(insertedCups);
                    }
                    case 4 -> {
                        float newPrice = 0;
                        boolean validPrice = false;
                        System.out.println();
                        do {
                            System.out.print("New price of drinks: $");
                            String inputPrice = vm1Scan.nextLine();

                            if (inputPrice.matches("^((0\\.[0-9]{1,2})|([1-9][0-9]*)(\\.[0-9]{1,2})?|\\.[0-9]{1,2})$")) {
                                newPrice = Float.parseFloat(inputPrice);
                                validPrice = true;
                            } else {
                                System.out.println("Invalid price. Please enter a valid price.");
                            }
                        } while (!validPrice);
                        set_price(newPrice); 
                    }
                    case 5 -> {
                        System.out.println("Thank you! Please come again.");
                        vm1Scan.close();
                        System.exit(0);
                    }
                    default -> System.out.println("Invalid option! Please select 1-5.");
                }
            } else {
                System.out.println("Invalid input! You must enter 1-5.");
            }
        } while (menuOption != 5); 
    }

    public void drinkSelectionMenu(){
        String additiveChoice;
        int selectedDrink = 0;
        float change;

        do {     
            System.out.print("Would you like to add sugar to your drink? (y/n): ");       
            additiveChoice = vm1Scan.nextLine();
            switch (additiveChoice) {
                case "y" -> {
                    sugar();
                    System.out.println();
                }
                case "n" -> System.out.println();
                default -> {
                    System.out.println("Invalid input! Please enter 'y' or 'n'.");
                }
            }
        } while (!"y".equals(additiveChoice) && !"n".equals(additiveChoice));

        System.out.println("Here are the available drinks:");
        System.out.println("1. Cappuccino");
        System.out.println("2. Hot Chocolate");
        System.out.println("3. Cancel");
        do {
            System.out.print("Which drink would you like: ");
            String userChoice = vm1Scan.nextLine();
            if (userChoice.matches("^[0-9]+$")) {
                selectedDrink = Integer.parseInt(userChoice);
                switch (selectedDrink) {
                    case 1 -> {
                        change = ds1.getCf() - ds1.getPrice();
                        cappuccino();
                        if (change > 0) {
                            System.out.printf("Your change is $%.2f.", change);
                            System.out.println("\n");
                        }
                        else {
                            System.out.println();
                        }
                        if (mda.getCurrState().getStateId() == 2) {
                            return;
                        } else {
                            noCupsMenu();
                        }
                    }
                    case 2 -> {
                        change = ds1.getCf() - ds1.getPrice();
                        chocolate();
                        if (change > 0) {
                            System.out.printf("Your change is $%.2f.", change);
                            System.out.println("\n");
                        }
                        else {
                            System.out.println();
                        }
                        if (mda.getCurrState().getStateId() == 2) {
                            return;
                        } else {
                            noCupsMenu();
                        }
                    }
                    case 3 -> {
                        cancel();
                        return;
                    }
                    default -> System.out.println("Invalid choice! Please select an available drink.");
                }
            } else {
                System.out.println("Invalid input! Please enter either 1-3.");
            }
        } while (selectedDrink < 1 || selectedDrink > 3);   
    }
}
// Input Processor for VM-1 (end)