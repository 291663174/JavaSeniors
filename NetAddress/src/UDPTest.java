import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @author Wuhen
 * @Description
 *  UDP协议的网络编程
 * @date 2020-10-12 18:49
 **/
public class UDPTest {

    //发送端
    @Test
    public void sender() throws IOException {

        DatagramSocket datagramSocket = new DatagramSocket();
        String str = "我是UDP方式发送的导弹";
        byte[] bytes = str.getBytes();
        InetAddress inetAddress = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length,inetAddress,9090);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    //接收端
    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] bytes = new byte[100];
        DatagramPacket datagramPacket = new DatagramPacket(bytes,0,bytes.length );
        datagramSocket.receive(datagramPacket);
        System.out.println(new String(datagramPacket.getData(),0,datagramPacket.getLength()));
        datagramSocket.close();
    }

}
