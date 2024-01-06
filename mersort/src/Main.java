import java.io.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int arr[]={12,16,3,23,4,6,89,100,98};
       System.out.println("the given array is:");
       Mergesort one = new Mergesort();
       one.printArray(arr);
       // Press Alt+Enter with your caret at the highlighted text to see how
        // IntelliJ IDEA suggests fixing it.
       one.sort(arr,0, arr.length-1);
       System.out.println("the sorted array is:");
       one.printArray( arr);
    }
}