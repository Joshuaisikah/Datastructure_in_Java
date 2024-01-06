import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import  java.util.Scanner;


public class Client {
    // private classes for the clien
    private Socket socket;
    private BufferedReader buffReader;
    private BufferedWriter buffWriter;
    private String name;

    public Client(Socket socket, String name){
        try{
            // Constructors of all the private classes
            this.socket = socket;
            this.buffWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            this.buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.name = name;


        }catch (IOException e){
            closeAll(socket, buffReader, buffWriter);
        }
    }
    // method to send messages using thread
    public void sendMessage(){
        try{
            buffWriter.write(name);
            buffWriter.newLine();
            buffWriter.flush();

            Scanner sc = new Scanner(System.in);

            while(socket.isConnected()){
                String messageToSend = sc.nextLine();
                buffWriter.write(name + ": " + messageToSend);
                buffWriter.newLine();
                buffWriter.flush();

            }
        } catch(IOException e){
            closeAll(socket, buffReader, buffWriter);

        }
    }
    // method to read messages using thread
    public void readMessage(){
        new Thread( new Runnable() {

            @Override
            public void run() {
                String msfFromGroupChat;

                while(socket.isConnected()){
                    try{
                        msfFromGroupChat = buffReader.readLine();
                        System.out.println(msfFromGroupChat);
                    } catch (IOException e){
                        closeAll(socket, buffReader, buffWriter);
                    }

                }

            }

        }).start();
    }
    // method to close everything in the socket
    public void closeAll(Socket socket, BufferedReader buffReader, BufferedWriter buffWriter){
        try{
            if(buffReader!= null){
                buffReader.close();
            }
            if(buffWriter != null){
                buffWriter.close();
            }
            if(socket != null){
                socket.close();
            }
        } catch (IOException e){
            e.getStackTrace();
        }
    }


}
