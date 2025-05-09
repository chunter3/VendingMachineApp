/*
 * CS586: Software Systems Architectures  
 * MDA - Vending Machine (VM) System
 * Christopher Hunter (#A20446456)
 */

// Driver Class for VM System (start)

package driver;

import inputprocessor.*;
import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        int selectedVM = -1;
        Scanner driverScan = new Scanner(System.in);
        System.out.println("\nPlease select an available vending machine (VM):");

        do {
            System.out.println("1. VM-1");
            System.out.println("2. VM-2");
            System.out.println("0. Exit");
            System.out.print("Selected VM: ");

            String userChoice = driverScan.nextLine();
            if(userChoice.matches("^[0-9]+$")) {
                selectedVM = Integer.parseInt(userChoice);
                switch (selectedVM) {
                    case 1 -> {
                        System.out.println("\nVM-1 selected");
                        float initPrice = 0;
                        boolean validPrice = false;
                        while (!validPrice) {
                            System.out.print("Enter initial drink price: $");
                            String inputPrice = driverScan.nextLine();
                        /*
                         The following regex ensures inputted initial price is strictly
                         positive (i.e., no negative prices and no $0 price (free drinks))
                         */
                            if (inputPrice.matches("^((0\\.[0-9]{1,2})|([1-9][0-9]*)(\\.[0-9]{1,2})?|\\.[0-9]{1,2})$")) {
                                initPrice = Float.parseFloat(inputPrice);
                                validPrice = true;
                            } else {
                                System.out.println("Invalid price. Please enter a valid price.");
                            }
                        }
                        VM1 vm1 = new VM1();
                        vm1.create(initPrice);
                    }
                    case 2 -> {
                        System.out.println("\nVM-2 selected");
                        int initPrice = 0;
                        boolean validPrice = false;
                        while (!validPrice) {
                            System.out.print("Enter initial drink price: $");
                            String inputPrice = driverScan.nextLine();
                        /*
                         * The following regex ensures inputted initial price is strictly
                         * positive whole numbers (i.e., no negative prices and no $0 price (free drinks))
                         */
                            if (inputPrice.matches("^[1-9][0-9]*$")) {
                                initPrice = Integer.parseInt(inputPrice);
                                validPrice = true;
                            } else {
                                System.out.println("Invalid price. Please enter a valid price.");
                            }
                        }
                        VM2 vm2 = new VM2();
                        vm2.CREATE(initPrice);
                    }
                    case 0 -> {
                        System.out.println("Thank you! Please come again");
                        driverScan.close();
                    }
                    default -> System.out.println("VM not found! Please select an available vending machine (VM):");
                }
            }
            else {
                System.out.println("Invalid input! Please select 0-2.");
            }
        } while (selectedVM < 0 || selectedVM > 2);
    }
}
// Driver Class for VM System (end)