// Data Store for VM-2 (start)

package datastore;

public class DS_VM2 extends DataStore<Integer> {

    private int temp_p; 
    private int temp_v; 
    private int price;  
    private int cf;     

    @Override
    public Integer getTemp_p(){
        return temp_p;
    }

    @Override
    public void setTemp_p(Integer p){
        temp_p = p;
    }

    @Override
    public Integer getTemp_v(){
        return temp_v;
    }

    @Override
    public void setTemp_v(Integer v){
        temp_v = v;
    }

    @Override
    public Integer getPrice(){
        return price;
    }

    @Override
    public void setPrice(Integer price){
        this.price = price;
    }

    @Override
    public Integer getCf(){
        return cf;
    }

    @Override
    public void setCf(Integer cf){
        this.cf = cf;
    }
}
// Data Store for VM-2 (end)