package strategy;

import datastore.DataStore;

public class IncreaseCF1 extends IncreaseCF<Float> {
    @Override
    public void increaseCF(DataStore<Float> ds) {

        ds.setCf(ds.getCf() + ds.getTemp_v());
        System.out.printf("Total amount inputted: $%.2f%n", ds.getCf());
        
    }
}