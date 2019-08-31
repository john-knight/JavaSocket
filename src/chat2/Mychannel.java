package chat2;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Mychannel implements Runnable {
    Socket socket;
    DataInputStream in ;
    DataOutputStream out;
    boolean flag=true;
    public  String string="";
    public Mychannel(Socket socket){
        this.socket=socket;
    }
    public  void rec() {
        try {
         in =new DataInputStream(socket.getInputStream());
         this.string=in.readUTF();
        } catch (IOException e){
         flag=false;
     }
    }
    public void send(String string){
        try {
            out = new DataOutputStream(socket.getOutputStream());
            out.writeUTF(string);
        }
        catch (IOException e){
            flag=false;
            Server.mychannels.remove(this);
        }
    }
    public void  sendother()  {
        rec();
        for(Mychannel mychannel:Server.mychannels){
            if(mychannel==this){
                continue;
            }
            mychannel.send(string);
        }
    }
    public void run() {
       while (true)
           sendother();
    }
}
