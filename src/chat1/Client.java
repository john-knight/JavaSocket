package chat1;
import java.io.*;
// DataInputStream 的学习代码部分
//public class Client{
//    public static void main(String args[])throws IOException{
//
//        DataInputStream in = new DataInputStream(new FileInputStream("test.txt"));
//        DataOutputStream out = new DataOutputStream(new  FileOutputStream("test1.txt"));
//        BufferedReader d  = new BufferedReader(new InputStreamReader(in));
//
//        String count;
//        while((count = d.readLine()) != null){
//            String u = count.toUpperCase();
//            System.out.println(u);
//            out.writeBytes(u + "  ,");
//        }
//        d.close();
//        out.close();
//    }
//}
import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
public class Client {
    public static void main(String[] args) throws IOException {
//        创建socket对象
//        主机名字lcoalhost代表本机，端口号是 服务器 提供socket服务的端口
        Socket client=new Socket("localhost",9999);
//        从键盘获取数据，和scanner差不多
//        数据输入流：允许应用程序以与机器无关方式从底层输入流中读取基本 Java 数据类型。
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(System.in));
        String string = bufferedReader.readLine();
//        发送数据的流
        DataOutputStream out = new DataOutputStream(client.getOutputStream());
//        输入数据的流
        DataInputStream in = new DataInputStream(client.getInputStream());
//        输出
        out.writeUTF(string);
//        输入
        System.out.println(in.readUTF());
    }
}
