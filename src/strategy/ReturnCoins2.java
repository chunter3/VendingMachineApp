package strategy;

import datastore.DataStore;

public class ReturnCoins2 extends ReturnCoins<Integer> {
    @Override
    public void returnCoins(DataStore<Integer> ds) {

        if (ds.getCf() > 0) {
            System.out.printf("Returning your $%d%n.", ds.getCf());
        }
        else {
            System.out.println();
        }
    }
}