import java.io.*;

public class Calc {
    public static void main(String[] args) throws Exception {
        System.out.println("Enter an arithmetic expression:");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        ArithmeticParser parser = new ArithmeticParser(new ByteArrayInputStream(input.getBytes()));
//Here, you create an ArithmeticParser object named parser. 
//You pass the user's input as a byte array to ByteArrayInputStream to provide an input stream for the parser. 
//The parser is responsible for parsing the arithmetic expression.
        parser.Start();
//* This line calls the Start method of the ArithmeticParser. 
//The Start method is expected to initiate the parsing process and perform some action with the parsed data.
    }
}
