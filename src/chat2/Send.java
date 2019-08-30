package chat2;
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Send implements  Runnable{
    BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
    DataOutputStream out;
    boolean flag=true;
    public Send(Socket socket){
        try {
            out = new DataOutputStream(socket.getOutputStream());
        }catch (IOException e){
            System.out.println("okay");
        }
    }
    public void Send(){
       try {
           String string=bufferedReader.readLine();
           out.writeUTF(string);
       }
       catch (IOException e){
        flag=false;
       }
    }
    public void run(){
    while (flag==true){
        this.Send();
        }
    }
}
