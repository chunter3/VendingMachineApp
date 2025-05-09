// Datastore abstract class

package datastore;
/*
 Since there are two different datatypes across the two VMs (i.e., float and int),
 I'll use the generic type parameter T to make the logic more flexible
 */
public abstract class DataStore<T extends Number> {

    public abstract T getTemp_p();
    public abstract void setTemp_p(T p);

    public abstract T getTemp_v();
    public abstract void setTemp_v(T v);

    public abstract T getPrice();
    public abstract void setPrice(T price);

    public abstract T getCf();
    public abstract void setCf(T cf);

}
