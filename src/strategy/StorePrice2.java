package strategy;

import datastore.DataStore;

public class StorePrice2 extends StorePrice<Integer> {
    @Override
    public void storePrice(DataStore<Integer> ds) {
        ds.setPrice(ds.getTemp_p());
        System.out.printf("New price of drinks are now $%d.%n", ds.getPrice());
    }
}