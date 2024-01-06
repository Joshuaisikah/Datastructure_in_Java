import java.util.Scanner;
public class Main {
    public static void movetowerofhanoi(int n,char source,char destination,char auxiliary){
        if(n < 1){
          return ;
        }
         moveTower(n,source,destination,auxiliary);
    }
    public static void moveTower(int n, char source, char destination, char auxiliary) {
        if (n == 1) {
            System.out.println("move disk 1 from" +" "+ source + " " + "to" + " " + destination);
            return ;//one move from a single disk
        }
        moveTower(n - 1, source, auxiliary, destination);
        //from source to auxiliary
        System.out.println("move disk " + n+ " from " + source + " to " + destination);
        moveTower(n - 1, auxiliary, destination, source);
        //recursively moving n-1 disks from auxiliary to desination
    }
    public static int calculatemoves(int disks){
        return (int)Math.pow(2,disks)-1;
    }


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.print("enter number of disks in the tower:");
        int disks=s.nextInt();
        movetowerofhanoi(disks,'A','B','C');
        int moves=calculatemoves(disks);
        System.out.println("total number of moves to solve: "+moves);
        s.close();


    }
}