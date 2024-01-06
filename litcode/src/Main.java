import java.util.Scanner;
public class Main {
    public static boolean findsqr(int c){

        int a=0;
        int b=0;
        while(a*a<c && b*b<c) {
            for(;b*b<c;b++) {
                if((a*a+b*b)==c) {
                    return true;
                }
            }
            b=a;
            a++;
        }
        return false;
    }
    public static void main(String[] args) {
        Scanner jose=new Scanner(System.in);
        System.out.println("Enter a number:");
        int c =jose.nextInt();
        boolean result =findsqr(c);
        System.out.println(result);

    }
}