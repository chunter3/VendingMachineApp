package strategy;

import datastore.DataStore;

public class ZeroCF1 extends ZeroCF<Float> {
    @Override
    public void zeroCF(DataStore<Float> ds) {
        ds.setCf(0.0f);
    }
}