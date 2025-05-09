// Output Processor (start; incorporates Strategy design pattern)

package outputprocessor;

import abstractfactory.AbstractFactory;
import datastore.DataStore;
import strategy.DisposeAdditive;
import strategy.DisposeDrink;
import strategy.IncreaseCF;
import strategy.ReturnCoins;
import strategy.StorePrice;
import strategy.ZeroCF;

public class OutputProcessor<T extends Number>{

    private final DataStore<T> ds;
    private final StorePrice<T> storePrice;
    private final ZeroCF<T> zeroCF;
    private final IncreaseCF<T> increaseCF;
    private final ReturnCoins<T> returnCoins;
    private final DisposeDrink disposeDrink;
    private final DisposeAdditive disposeAdditive;
    
    public OutputProcessor(AbstractFactory<T> af) {
        ds = af.getDataStore();
        storePrice = af.getStorePrice();
        zeroCF = af.getZeroCF();
        increaseCF = af.getIncreaseCF();
        returnCoins = af.getReturnCoins();
        disposeDrink = af.getDisposeDrink();
        disposeAdditive = af.getDisposeAdditive();
    }
    
    // Action methods
    public void StorePrice() {
        storePrice.storePrice(ds);
    }
    
    public void ZeroCF() {
        zeroCF.zeroCF(ds);
    }
    
    public void IncreaseCF() {
        increaseCF.increaseCF(ds);
    }
    
    public void ReturnCoins() {
        returnCoins.returnCoins(ds);
    }
    
    public void DisposeDrink(int drinkID) {
        disposeDrink.disposeDrink(drinkID);
    }
    
    public void DisposeAdditive(int[] additiveList) {
        disposeAdditive.disposeAdditive(additiveList);
    }
}
// Output Processor (end)