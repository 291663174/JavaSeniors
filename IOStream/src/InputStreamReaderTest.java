import org.junit.Test;

import java.io.*;

/**
 * @author Wuhen
 * @Description
 *      处理流之二：转换流的使用
 *      1.转换流：属于字符流
 *          InputStreamReader:将一个字节的输入流转换为字符的输入流
 *          OutputStreamWriter：将一个字符的输出流转换为字节的输出流
 *
 *      2.作用：提供字节流与字符流之间的转换
 *
 *      3.解码：字节、字节数组  --->字符数组、字符串
 *        编码：字符数组、字符串--->字节、字节数组
 *
 *      4.字符集
 *
 * @date 2020-10-10 11:49
 **/
public class InputStreamReaderTest {
    /**
     *  此时处理异常，正式写法仍然应该使用try-catch-finally
     *  以下仅仅为了方便。。
     **/
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("hello.txt");
        //使用系统默认得字符集
        //InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        //参数二指明了字符集,具体使用哪个字符集，取决于
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"UTF-8");
        char[] cbuf = new char[20];
        int len;
        while ((len = inputStreamReader.read(cbuf)) != -1){
            String str = new String(cbuf,0,len);
            System.out.println(str);
        }
        inputStreamReader.close();
    }

    /**
     *  综合使用InputStreamReader和OutputStreamWriter
     *  此时处理异常，正式写法仍然应该使用try-catch-finally
     *      以下仅仅为了方便。。
     **/
    @Test
    public void test2() throws IOException {
        //1.造文件，造流
        File file1 = new File("hello.txt");
        File file2 = new File("newhello.txt");

        FileInputStream fileInputStream = new FileInputStream(file1);
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream,"gbk");

        //2.读写过程
        char[] chars = new char[20];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1){
            outputStreamWriter.write(chars,0,len);
        }
        //3.关闭资源
        inputStreamReader.close();
        outputStreamWriter.close();

    }

}
