// MDA (start; incorporates State design pattern)

package mda;

import abstractfactory.AbstractFactory;
import java.util.Arrays;
import java.util.List;
import outputprocessor.OutputProcessor;
import states.CoinsInserted;
import states.Idle;
import states.NoCups;
import states.State; 

public class MDA<T extends Number>{

    public int k;
    public int[] A;
    private final List<State<T>> stateList;
    private State<T> currState;
    private final OutputProcessor<T> op;
    private final AbstractFactory<T> af;

    // MDA constructor
    public MDA(AbstractFactory<T> af){
        this.af = af;
        op = new OutputProcessor<>(this.af);
        stateList = List.of(
        new NoCups<>(this, op), 
        new Idle<>(this, op), 
        new CoinsInserted<>(this, op)
        );
        currState = stateList.get(0);
    }
    // Start VM application 
    public void create(){
        currState.create();
        switch(currState.getStateId()){
            case 1 ->{
                currState = stateList.get(0);
                break;
            }
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }  
    }
    // Insert cups to VM
    public void insert_cups(int n){
        currState.insert_cups(n);
        switch(currState.getStateId()){
            case 1 ->{
                currState = stateList.get(1); 
            }
            case 2 ->{break;}
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        } 
    }
    // Funds inserted for a drink (f = 1: sufficent; f = 0: insufficent)
    public void coin(int f){
        currState.coin();
        switch(currState.getStateId()){
            case 1 ->{break;}
            case 2 ->{
                if(f == 1){
                    currState = stateList.get(2);
                    Arrays.fill(A, 0);
                }
                break;
            }
            case 3 ->{break;}
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }
    }
    // Card (credit or debit) is swiped
    public void card(){
        currState.card();
        switch(currState.getStateId()){
            case 2 ->{
                currState = stateList.get(2);
                Arrays.fill(A, 0);
                break;
            }
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }
    }
    // Cancel drink selection
    public void cancel(){ 
        currState.cancel();
        switch(currState.getStateId()){
            case 3 ->{
                currState = stateList.get(1);
                break;
            }
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }
    }
    // Set price of a drink
    public void set_price(){ 
        currState.set_price();
        switch(currState.getStateId()){
            case 2 ->{break;}
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }
    }
    // Return a drink (w/ or w/out additives) to user
    public void dispose_drink(int d){ 
        currState.dispose_drink(d);
        switch(currState.getStateId()){
            case 3 ->{
                if(k >= 1){
                    currState = stateList.get(1);
                    break;
                }
                else{
                    currState = stateList.get(0);
                    break;
                }
            }
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }
    }
    // Add an additive (sugar or cream) to a drink
    public void additive(int a){ 
        currState.additive(a);
        switch(currState.getStateId()){
            case 3 ->{break;}
            default ->{
                System.out.println("Operation prohibited in current state.");
                break;
            }
        }
    }
    // returns current state of VM
    public State<T> getCurrState() {
        return currState;
    }
}
// MDA (end) 