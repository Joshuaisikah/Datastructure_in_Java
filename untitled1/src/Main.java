import com.sun.security.ntlm.Server;

import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static char[] main(String[] args) throws Exception{

 ServerSocket s = new ServerSocket(2003);
 while(true){
 Socket socket= s.accept();
 Server server= new Server(socket);

        }
    }


}