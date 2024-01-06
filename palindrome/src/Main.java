import javax.imageio.stream.ImageInputStream;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {
    public  boolean palindrrome(String word){
        char[] charArray =word.toLowerCase().toCharArray();

        int end = word.length()-1;
        for( int start=0;start<word.length()/2;start++){
            if(charArray[start]!=charArray[end]){
                return false;
            }
            end--;

        }
        return true;
    }
    public static void main(String[] args) {
        Main mb = new Main();
        Scanner s= new Scanner(System.in);
        System.out.print("enter the string:");
        String one=s.nextLine();
        s.close();
        String ttw=one.replaceAll("[^a-zA-Z0-9]","");
        System.out.println(mb.palindrrome(ttw));
    }
}