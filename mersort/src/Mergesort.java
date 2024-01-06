import static java.util.Arrays.sort;
import  java.io.*;
import java.util.Arrays;
//mergesort is a recursive algorithm that continuously splits the array in half
//until it cannot be further divided i.e the array has  only one element left
// (an array with one element is always sorted)
//then the sorted sub-arrays are merged into one sorted array.
//time complexity =O(N log N)
//applications
//sorting large data sets, external sorting, custom sorting
//advantages of mergesort
//stability,Guaranteed worst case performance, parallelizable.
public class Mergesort {
    //merges two sub arrays of arr[]
    //first sub-array is arr[l....m]
    //second sub-array is arr[m+1...r]
     void merge(int arr[], int l, int m, int r) {
        //find the size of the two sub-arrays to be merged
        int n1 = m - l + 1;
        /*
        'm' is the midpoint index of the array(or sub-array)we are currently considering
        'l' is the starting index of the array (or sub-array).
        'm-l' gives the difference between the midpoint and the starting index.
        by adding '1' to this difference we are calculating the number of elements in the left sub-array('L')
        this is because the arrays are zero-indexed
         */
         int n2 = r - m;
         /*
         'r'  is the ending index of the array(or sub-array)we are currently looking at.
         subtracting 'm' from 'r' gives the number of elements in the right sub-array.
         note that we don't add '1' here because we are considering elements from 'm + 1' to 'r'
         do the length of this sub-array is 'm - r'.
          */

        //create temp arrays
        int L[] = new int[n1];
        int R[] = new int[n2];
        //copy data to the temp array
        for (int i = 0; i < n1; ++i)
            /*
            the difference between '++i' and 'i++' before its current value is used.
            Returns the incremented  value 'i'.
            '++i' (pre-increment):
            increments the value of 'i' before its current value is used.
            returns the incremented value of 'i'.
            'i++'(post-increment):
            uses the current value of 'i' before incrementing.
            returns the original value of 'i' before incrementing.
            */
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
        //merge the temp arrays
        //initial indices of the first and second sub-arrays
        int i = 0;
        int j = 0;
        //initial index of the merged sub-array
        int k = l;
        //'k' is a pointer for the main array[] and it starts at the left index 'l'.

         //'i' and 'j' are pointers for the 'L[]' and 'R[]' sub-arrays respectively.
        while (i < n1 && j < n2) {
            //this loop continues as long as both pointers have not reached the end of their respective sub-arrays.
            if (L[i] <= R[j]) {
                //comparison:if the element in 'L[]'(pointed by 'i') is less than or equal to the element in 'R[]'
                //(pointed by 'j')then the element from 'L[]' is placed in the main array.
                arr[k] = L[i];
                //if the current element in 'R[]' is smaller then the element from 'R[]' is placed in the main array.
                i++;
            } else {
                arr[k] = R[j];
                j++;
            //whichever sub-array provides the element its pointer 'i' or 'j' is incremented.
            }
            k++;
            //after placing an element from either 'R[]' or 'L[]' into the main array ('arr[]')
            //the pointer 'k' is incremented to move to the next position in the main array.
        }
        //copy the remaining elements of L[] if any
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
        //main function that sorts the arr using merge
    }
    void sort ( int arr[], int l, int r) {
        if (l < r) {

            int m = l + (r - l) / 2;
            sort(arr, l, m);
            sort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }
    static void printArray ( int[] arr){
        System.out.println(Arrays.toString(arr));
            }

        }









