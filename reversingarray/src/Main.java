import java.util.Arrays;
import java.util.*;


public class Main {



    public static void main (String[]args){
        int[] numbers = {12,0, 4, 0,88,0,8,0,65, 67, 87, 98};
        Main mb1 = new Main();
        mb1.movezeros(numbers);
        System.out.println(Arrays.toString(numbers));
    }

}
