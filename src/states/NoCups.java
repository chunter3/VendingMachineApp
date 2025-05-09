package states;

import mda.MDA;
import outputprocessor.OutputProcessor;

public class NoCups<T extends Number> extends State<T> {

    public NoCups(MDA<T> mda, OutputProcessor<T> op) {
        super(mda, op);
    }

    @Override
    public void create() {
        op.StorePrice();
        System.out.println();
    }

    @Override
    public void insert_cups(int n) {
        mda.k = n;
        op.ZeroCF();
        System.out.printf("Cups inserted. There are currently %d cups. Proceeding to main menu...%n", mda.k);
        System.out.println();
    }

    @Override
    public void coin() {
        // In NoCups state, user cannot insert any coins
        System.out.print("Insert cups before inserting coins. ");
        op.ReturnCoins();
    }

    @Override
    public void card(){}

    @Override
    public void additive(int additiveID){}

    @Override
    public void cancel(){}

    @Override
    public void set_price(){}

    @Override
    public void dispose_drink(int drinkID){}

    @Override
    public int getStateId() {
        return 1;   // Unique identifier for this state
    }
}