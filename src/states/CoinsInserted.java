package states;

import mda.MDA;
import outputprocessor.OutputProcessor;

public class CoinsInserted<T extends Number> extends State<T> {

    public CoinsInserted(MDA<T> mda, OutputProcessor<T> op) {
        super(mda, op);
    }

    @Override
    public void additive(int additiveID) {
        if (additiveID == 1) {
            mda.A[0] = 1;
            System.out.println("Adding sugar to your drink...");
        } else if (additiveID == 2) {
            mda.A[1] = 1;
            System.out.println("Adding cream to your drink...");
        }
    }

    @Override
    public void coin() {
         // In CoinsInserted state, user cannot insert any coins
        System.out.print("No more coins are necessary.");
        op.ReturnCoins();
    }

    @Override
    public void dispose_drink(int drinkID) {
        op.DisposeDrink(drinkID);
        op.DisposeAdditive(mda.A);
        if (mda.k > 1) {
            op.ZeroCF();
        }
        mda.k -= 1;
        System.out.println(". Enjoy!");
    }

    @Override
    public void cancel() {
        System.out.print("Selection cancelled. ");
        op.ReturnCoins();
        op.ZeroCF();
        System.out.println();
    }

    @Override
    public void create() {}

    @Override
    public void insert_cups(int k){}

    @Override
    public void card(){}

    @Override
    public void set_price(){}

    @Override
    public int getStateId() {
        return 3;   // Unique identifier for this state
    }
}
// State design pattern (end)