package strategy;

public class DisposeDrink2 extends DisposeDrink {
    @Override
    public void disposeDrink(int drinkID) {
        switch (drinkID) {
            case 1 -> System.out.print("\nHere's your cappuccino");
            case 2 -> System.out.print("\nHere's your hot chocolate");
            case 3 -> System.out.print("\nHere's your coffee");
            default -> System.out.print("\nDrink unavailable");
        }
    }
}