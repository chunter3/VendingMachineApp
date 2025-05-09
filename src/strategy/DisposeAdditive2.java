package strategy;

public class DisposeAdditive2 extends DisposeAdditive {
    @Override
    public void disposeAdditive(int[] additiveList) {

        if (additiveList[0] == 1 && additiveList[1] == 1){

            System.out.print(" with sugar and cream");
        }
        else if (additiveList[0] == 1){

            System.out.print(" with sugar");
        }
        else if (additiveList[1] == 1){

            System.out.print(" with cream");
        }
    }
}
