import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Wuhen
 * @Description
 *  实现TCP的网络编程
 *      例题2：客户端发送文件给服务端，服务端将文件保存在本地
 * @date 2020-10-12 17:04
 **/
public class TCPTest2 {
    @Test
    public void client() throws IOException{
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"),9090);
        OutputStream outputStream = socket.getOutputStream();
        FileInputStream fileInputStream = new FileInputStream(new File("1.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1){
            outputStream.write(bytes,0,len);
        }
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException{

        ServerSocket serverSocket = new ServerSocket(9090);
        Socket socket = serverSocket.accept();
        InputStream inputStream = socket.getInputStream();
        FileOutputStream fileOutputStream = new FileOutputStream(new File("123.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1){
            fileOutputStream.write(bytes,0,len);
        }
        fileOutputStream.close();
        inputStream.close();
        socket.close();
    }
}
