package strategy;

import datastore.DataStore;

public class StorePrice1 extends StorePrice<Float> {
    @Override
    public void storePrice(DataStore<Float> ds) {
        ds.setPrice(ds.getTemp_p());
        System.out.printf("New price of drinks are now $%.2f.%n", ds.getPrice());
        
    }
}