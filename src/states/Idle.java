package states;

import mda.MDA;
import outputprocessor.OutputProcessor;

public class Idle<T extends Number> extends State<T> {

    public Idle(MDA<T> mda, OutputProcessor<T> op) {
        super(mda, op);
    }

    @Override
    public void insert_cups(int n) {
        mda.k += n;
        System.out.printf("Cups inserted. There are currently %d cups.", mda.k);
        System.out.println("\n");
    }

    @Override
    public void coin() {
        op.IncreaseCF();
        mda.A = new int[] {0,0};    // {sugar, cream}
        System.out.println();
    }

    @Override
    public void card() {
        op.ZeroCF();
        System.out.println("Card accepted. Proceeding to drink selection...");
        mda.A = new int[] {0,0};    // {sugar, cream}
    }

    @Override
    public void set_price() {
        op.StorePrice();
        System.out.println();
    }

    @Override
    public void create(){}

    @Override
    public void additive(int additiveID){}

    @Override
    public void cancel(){}

    @Override
    public void dispose_drink(int drinkID){}

    @Override
    public int getStateId() {
        return 2;   // Unique identifier for this state
    }
}