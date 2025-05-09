// Abstract factory for VM-1 (start)

package abstractfactory;

import datastore.*;
import strategy.*;

public class AF_VM1 extends AbstractFactory<Float> {

    private final DS_VM1 ds1 = new DS_VM1();

    @Override
    public StorePrice<Float> getStorePrice(){
        return new StorePrice1();
    }
    
    @Override
    public ZeroCF<Float> getZeroCF(){
        return new ZeroCF1();
    }

    @Override
    public IncreaseCF<Float> getIncreaseCF(){
        return new IncreaseCF1();
    }

    @Override
    public ReturnCoins<Float> getReturnCoins(){
        return new ReturnCoins1();
    }

    @Override
    public DisposeDrink getDisposeDrink(){
        return new DisposeDrink1();
    }

    @Override
    public DisposeAdditive getDisposeAdditive(){
        return new DisposeAdditive1();
    }

    @Override
    public DataStore<Float> getDataStore(){
        return ds1;
    }
}
// Abstract factory for VM-1 (end)