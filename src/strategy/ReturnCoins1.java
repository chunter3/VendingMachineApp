package strategy;

import datastore.DataStore;

public class ReturnCoins1 extends ReturnCoins<Float> {
    @Override
    public void returnCoins(DataStore<Float> ds) {

        if (ds.getCf() > 0) {
            System.out.printf("Returning your $%.2f.%n", ds.getCf());
        }
        else {
            System.out.println();
        }
    }
}