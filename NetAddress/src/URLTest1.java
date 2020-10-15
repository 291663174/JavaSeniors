import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-12 19:09
 **/
public class URLTest1 {

    public static void main(String[] args){

        HttpURLConnection urlConnection = null;
        InputStream inputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            URL url = new URL("http://localhost:8080/1.jpg");
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            inputStream = urlConnection.getInputStream();
            fileOutputStream = new FileOutputStream("E:\\ideaxiangmu\\NetAddress\\444.jpg");
            byte[] bytes = new byte[1024];
            int len;
            while ((len = inputStream.read(bytes)) != -1){
                fileOutputStream.write(bytes,0,len);
            }
            System.out.println("下载完成！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (inputStream != null){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (urlConnection != null){
                urlConnection.disconnect();
            }
        }
    }

}
