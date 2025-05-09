// Abstract Factory design pattern (start)

package abstractfactory;
import datastore.DataStore;
import strategy.*;

// Defining abstract class for abstract factory implementation; helps invoke object to class
public abstract class AbstractFactory<T extends Number> {

    public abstract DataStore<T> getDataStore();

    public abstract StorePrice<T> getStorePrice();

    public abstract ZeroCF<T> getZeroCF();

    public abstract IncreaseCF<T> getIncreaseCF();

    public abstract ReturnCoins<T> getReturnCoins();

    public abstract DisposeDrink getDisposeDrink();

    public abstract DisposeAdditive getDisposeAdditive();
}