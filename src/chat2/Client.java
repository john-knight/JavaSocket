package chat2;

import java.io.IOException;
import java.net.Socket;

public class Client {
    public static void main (String[] args) throws IOException {
        Socket socket=new Socket("localhost", 666);
        Send send = new Send(socket);
        Thread threadsend=new Thread(send);
        Receive receive =new Receive(socket);
        Thread threadreceive=new Thread(receive);
        threadreceive.start();
        threadsend.start();
    }
}
