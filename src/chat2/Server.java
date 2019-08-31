package chat2;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
public class Server {

    public  static   List<Mychannel> mychannels =new ArrayList<>();
    public static void main(String[] args)throws IOException {
        ServerSocket serverSocket=new ServerSocket(666);
//       用来接收客户端发送的socket请求
//        亲测如果 Socket socket = serverSocket.accept();写在循环体之外的话，会报错
//       所以，应该是 Socket socket = serverSocket.accept();会为每次连接请求创建一个socket
          while (true) {
              Socket socket = serverSocket.accept();
              Mychannel mychannel =new Mychannel(socket);
              mychannels.add(mychannel);
              Thread thread =new Thread(mychannel);
              thread.start();
          }
    }
}
