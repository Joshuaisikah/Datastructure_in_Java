import java.util.Arrays;

public class Main {
    public void movezeros(int[] arr) {
        //we are using two pointers one i and j
        //one focus on the zero elements while the other focuses on nonzero elements.
        int j = 0;
        //j focuses on the zero elements.
        for (int i = 0; i < arr.length; i++) {
            //this loop iterates over the elements of the array.
            if (arr[i] == 0 && arr[j] != 0) {
                //if both of these two conditions are true then these lines below will be executed.
                //otherwise we will simpy move ahead to another value of i and j.
                //this loop checks if the element is 0 or not
                int temp = arr[i];
                //we assign the current value of arr[i] to the temp variable
                arr[i] = arr[j];
                //we then assign the value of arr[j] which is at this case 0 to the arr[i] variable.
                arr[j] = temp;
                //we then assign the value of the temp variable to arr[j] which was the value of the arr[i]element originally.
                //we are moving the zeros to the end of the array.

            }
//        if one of the conditions above fails we increment j by 1.
            if (arr[j] == 0) {
                j++;
            }
        }

    }

    public static int findsecondmax_min(int[] arr) {
//        this method is used to find the second maximum or minimum value of the array.
        int max = arr[0];
//       it holds the value of the first element of the array.
        int max2;
        max2 = arr[0];
        //same as above
        for (int k : arr) {
//            this is saying that for each element of the array we compare it with the value
//            of the first element stored in the variable max.
            max = Math.max(max, k);
        }
        for (int j : arr) {
            if (j != max) {
                max2 = Math.max(max2, j);
            }
        }
        return max2;
    }

    public int find1(int[] arr) {
//        this method is used to find the missing value in an array that starts from 1---n;
        int n = arr.length + 1;
        // we are adding one to the length of the array to get the number that is missing.
        int sum1 = n * (n + 1) / 2;
//        the line below will be used to iterate over the array
//        it number is the element number of the array
//        this is simply saying that for every number in the array we need to subtract
//        it from the sum1.
        for (int num : arr) {
            sum1 = sum1 - num;
        }
        return sum1;
//        this method works for arrays that are sorted and are numbererd from a certain range.
    }

    public static int[] removeeven(int[] arr) {
        int count = 0;
        for (int j : arr) {
            //we are iterating through every element of the array
            if (j % 2 != 0) {
                //we check if the array element pointed by i is odd.
                count++;
                //we increment count
            }
        }
        int[] result = new int[count];
        int idx = 0;
        for (int j : arr) {
            if (j % 2 != 0) {
                result[idx] = j;
                idx++;
            }
        }
        return result;
    }

    public  static int[] sortedsqrarray(int[] arr) {
        //the array in this case is sorted in ascending order.
        //we have to  find the squares of the elements of the array and then sort the array again
        //we will use two pointer
        int n = arr.length;
        int[] result = new int[n];
        int j = n - 1;
        //j starts at the last index of the array

        int i = 0;
        //starts at the start of the array
        for(int k = n - 1; k >= 0; k--) {
            //here k starts at the last index of the array
            //basically the sorted array
            if (Math.abs(arr[i]) > Math.abs(arr[j])) {
                //here we are comparing the absolute value,and  then we make a decision
                //which one is bigger since the array is sorted in ascending order.
                //the array is sorted in place hence we only have one for loop

                result[k] = arr[i] * arr[i];
                i++;
            }
            else {
                result[k] = arr[j] * arr[j];
                j--;
            }
        }

        return result;
    }

    static void printArray(int[] arr) {
        System.out.println(Arrays.toString(arr));
    }

    public static void main(String[] args) {
        System.out.println("Hello world!");

        int[] arr = {-4,-2,1,3,6,8};
        printArray(arr);
        //printing the original array
        int[] result = removeeven(arr);
        //we pass the arr to the method so ast to remove the even elements of the array
        printArray(result);
        //we print the results.
    }
}
//comments to be added tomorrow.