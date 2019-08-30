package chat2;


import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class Receive implements Runnable{
    DataInputStream in ;
    boolean flag=true;
    public Receive(Socket socket) throws IOException {
        in = new DataInputStream(socket.getInputStream());
    }
    public void receive(){
        try {
            System.out.println(in.readUTF());
        }catch (IOException e)
        {
          flag=false;
        }
    }
    public void run(){
     while (flag) {
         receive();
     }
    }
}
