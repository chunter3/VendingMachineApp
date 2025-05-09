// Abstract factory for VM-2 (start)

package abstractfactory;

import datastore.*;
import strategy.*;

public class AF_VM2 extends AbstractFactory<Integer> {

    private final DS_VM2 ds2 = new DS_VM2();

    @Override
    public StorePrice<Integer> getStorePrice(){
        return new StorePrice2();
    }
    
    @Override
    public ZeroCF<Integer> getZeroCF(){
        return new ZeroCF2();
    }

    @Override
    public IncreaseCF<Integer> getIncreaseCF(){
        return new IncreaseCF2();
    }

    @Override
    public ReturnCoins<Integer> getReturnCoins(){
        return new ReturnCoins2();
    }

    @Override
    public DisposeDrink getDisposeDrink(){
        return new DisposeDrink2();
    }

    @Override
    public DisposeAdditive getDisposeAdditive(){
        return new DisposeAdditive2();
    }

    @Override
    public DataStore<Integer> getDataStore(){
        return ds2;
    }
}
// Abstract factory for VM-2 (end)
// Abstract Factory design pattern (end)