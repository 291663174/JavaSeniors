import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Wuhen
 * @Description
 *  URL网络编程
 *    1.URL：统一资源定位符，对应着互联网的某一资源地址
 *    2.格式：http://localhost:8080/examples/1.jpg?username=Tom
 *      协议  主机名  端口号  资源地址    参数列表
 * @date 2020-10-12 19:03
 **/
public class URLTest {
    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/1.jpg?username=Tom");
            System.out.println(url.getProtocol());
            System.out.println(url.getHost());
            System.out.println(url.getPort());
            System.out.println(url.getPath());
            System.out.println(url.getFile());
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
