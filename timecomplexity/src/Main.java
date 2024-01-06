/**
 * @author issah
 */ // Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
     double now=System.currentTimeMillis();
     long n=99999;
     Main demo = new Main();
     System.out.println(demo.findsum(n));
     System.out.println("time taken - " + (System.currentTimeMillis()- now)+ "millisecs.");
     }
   //  public  long findsum(long n) {
  //       return n * (n + 1) / 2;

     // this approach is very efficient because it performs the operation in constant time.
         //regardless of the value of n,it uses a direct mathematical formula to compute the sum.
     // }
       public long findsum(long n){
             long sum=0;
             for(long i=1;i<=n;i++) {
                 sum += i;

                 // this uses a loop to iterate from 1 to n adding each number to n.
                 // it is a linear-time operation,meaning it grows linearly with the value of n.
             }
             return  sum;

             }
        }
// in terms of results both methods will give you the same results however the mathematical formula
//approach is faster especially for larger values of n because it doesn't rely
//on iteration thorough each number from 1 to n.


