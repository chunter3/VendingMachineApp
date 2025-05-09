// Data Store for VM-1 (start)

package datastore;

public class DS_VM1 extends DataStore<Float> {

    private float temp_p; // Temp price
    private float temp_v; // Temp coins
    private float price;  // Price of a drink
    private float cf;     // Cumulative fund

    @Override
    public Float getTemp_p(){
        return temp_p;
    }

    @Override
    public void setTemp_p(Float p){
        temp_p = p;
    }

    @Override
    public Float getTemp_v(){
        return temp_v;
    }

    @Override
    public void setTemp_v(Float v){
        temp_v = v;
    }

    @Override
    public Float getPrice(){
        return price;
    }

    @Override
    public void setPrice(Float price){
        this.price = price;
    }

    @Override
    public Float getCf(){
        return cf;
    }

    @Override
    public void setCf(Float cf){
        this.cf = cf;
    }
}
// Data Store for VM-1 (end)