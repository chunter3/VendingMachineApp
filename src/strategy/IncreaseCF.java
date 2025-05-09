package strategy;

import datastore.DataStore;

public abstract class IncreaseCF<T extends Number> {
    public abstract void increaseCF(DataStore<T> ds);
}