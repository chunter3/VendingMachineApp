package strategy;

import datastore.DataStore;

public abstract class ReturnCoins<T extends Number> {
    public abstract void returnCoins(DataStore<T> ds);
}