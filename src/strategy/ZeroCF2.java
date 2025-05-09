package strategy;

import datastore.DataStore;

public class ZeroCF2 extends ZeroCF<Integer> {
    @Override
    public void zeroCF(DataStore<Integer> ds) {
        ds.setCf(0);
    }
}
// Strategy design pattern (end)