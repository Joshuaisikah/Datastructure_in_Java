import java.io.*;
import java.net.Socket;
import java.util.ArrayList;

/*this  class implements the runnable interface and overrides the run method
it has a static arraylist of every client handler object that we have instantiated.
the main purpose of this arraylist is to keep track of our clients so that whenever a client sends a message we can loop through our arraylist \
of clients and sends the message to each client.
this is static because it needs to belong to the class not each object of the class.
bufferedReader and BufferedWriter is used to send and receive data specifically messages to our clients and this
will be messages that have been sent from other clients.\
then it is going to be broadcast with the help of the arraylist.
datainputstream and dataoutputstream are used as objects and it creates a new thread object */
public class ClientHandler  implements Runnable{

    public static ArrayList<ClientHandler>clientHandlers = new ArrayList<>();
    public Socket socket;
    private BufferedReader buffReader;
    private BufferedWriter buffWriter;
    private String name;

    public ClientHandler(Socket socket){
        // Constructors of all the private classes
        try{
            this.socket = socket;
            this.buffWriter = new BufferedWriter( new OutputStreamWriter(socket.getOutputStream()));
            this.buffReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.name = buffReader.readLine();
            clientHandlers.add(this);
            boradcastMessage("SERVER" + name + " has entered in the room");

        } catch(IOException e){
            closeAll(socket, buffReader, buffWriter);
        }
    }
    // run method override
    @Override
    public void run() {

        String messageFromClient;

        while(socket.isConnected()){
            try{
                messageFromClient = buffReader.readLine();
                boradcastMessage(messageFromClient);
            } catch(IOException e){
                closeAll(socket, buffReader,  buffWriter);
                break;
            }
        }
    }
    public void boradcastMessage(String messageToSend){
        for(ClientHandler clientHandler: clientHandlers){
            try{
                if(!clientHandler.name.equals(name)){
                    clientHandler.buffWriter.write(messageToSend);
                    clientHandler.buffWriter.newLine();
                    clientHandler.buffWriter.flush();
                }
            } catch(IOException e){
                closeAll(socket,buffReader, buffWriter);

            }
        }
    }
    // notify if the user left the chat
    public void removeClientHandler(){
        clientHandlers.remove(this);
        boradcastMessage("server " + name + " has gone");
    }

    public void closeAll(Socket socket, BufferedReader buffReader, BufferedWriter buffWriter){

        // handle the removeClient funciton
        removeClientHandler();
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