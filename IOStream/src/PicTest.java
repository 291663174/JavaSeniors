import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author Wuhen
 * @Description
 *    图片的加密
 * @date 2020-10-10 10:08
 **/
public class PicTest {

    private FileInputStream fileInputStream;
    private FileOutputStream fileOutputStream;

    @Test
    public void test1(){

        try {
            fileInputStream = new FileInputStream(new File("1.jpg"));
            fileOutputStream = new FileOutputStream(new File("22.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                //字节数组进行修改
                for (int i = 0; i < len; i++){
                    // ^ 异或
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
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
        }
    }

    //图片的解密
    @Test
    public void test2(){

        try {
            fileInputStream = new FileInputStream(new File("22.jpg"));
            fileOutputStream = new FileOutputStream(new File("33.jpg"));

            byte[] buffer = new byte[20];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1){
                //字节数组进行修改
                for (int i = 0; i < len; i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }
                fileOutputStream.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null){
                try {
                    fileInputStream.close();
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
        }
    }
}
