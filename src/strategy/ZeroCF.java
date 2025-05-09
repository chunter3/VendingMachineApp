package strategy;

import datastore.DataStore;

public abstract class ZeroCF<T extends Number> {
    public abstract void zeroCF(DataStore<T> ds);
}