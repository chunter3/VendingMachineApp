package strategy;

import datastore.DataStore;

public class IncreaseCF2 extends IncreaseCF<Integer> {
    @Override
    public void increaseCF(DataStore<Integer> ds) {
       
        ds.setCf(ds.getCf() + ds.getTemp_v());
        System.out.printf("Total amount inputted: $%d%n", ds.getCf());
    }
}