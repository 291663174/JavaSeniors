import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wuhen
 * @Description
 *  实现TCP的网络编程
 *      例题3：从客户端发送文件给服务端，服务端将保存到本地，并返回“发送成功”给客户端。并关闭相应的链接
 * @date 2020-10-12 17:31
 **/
public class TCPTest3 {

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("1.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }

        //关闭向服务端数据的传输
        socket.shutdownOutput();

        //接收来自于服务器端的数据，并显示到控制台上
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[20];
        int len1;
        while ((len1 = inputStream.read(bytes1)) != -1){
            byteArrayOutputStream.write(bytes1,0,len1);
        }
        System.out.println(byteArrayOutputStream.toString());

        fileInputStream.close();
        outputStream.close();
        socket.close();
        byteArrayOutputStream.close();
    }

    @Test
    public void server() throws IOException{

        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("333.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
        }

        System.out.println("图片传输完成");

        //服务器端给予客户端反馈
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("你好，照片我已收到！".getBytes());

        fileOutputStream.close();
        inputStream.close();
        socket.close();
        outputStream.close();
    }
}
