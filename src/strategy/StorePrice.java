package strategy;

import datastore.DataStore;

public abstract class StorePrice<T extends Number> {
    public abstract void storePrice(DataStore<T> ds);
}