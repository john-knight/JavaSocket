package chat1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args)throws IOException {
       ServerSocket serverSocket=new ServerSocket(9999);
//       用来接收客户端发送的socket请求
       Socket socket=serverSocket.accept();
        DataOutputStream out = new DataOutputStream(socket.getOutputStream());
        DataInputStream in = new DataInputStream(socket.getInputStream());
        String string =in.readUTF();
        System.out.println("客户端输入的数据为：--》"+string);
        out.writeUTF("客户端收到了："+string);
    }
}
