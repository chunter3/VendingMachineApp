// State design pattern (start)

package states;

import mda.MDA;
import outputprocessor.OutputProcessor;

public abstract class State<T extends Number> {
    protected MDA<T> mda;
    protected OutputProcessor<T> op;

    public State(MDA<T> mda, OutputProcessor<T> op) {
        this.mda = mda;
        this.op = op;
    }

    public abstract void create();
    public abstract void insert_cups(int n);
    public abstract void coin();
    public abstract void card();
    public abstract void cancel();
    public abstract void set_price();
    public abstract void dispose_drink(int drinkID);
    public abstract void additive(int additiveID);
    public abstract int getStateId();
}