import org.junit.Test;

import javax.print.DocFlavor;
import java.io.*;

/**
 * @author Wuhen
 * @Description 其他流的使用
 * 1.标准的输入/输出流
 * 2.打印流
 * 3.数据流
 * @date 2020-10-10 12:54
 **/
public class OtherStreamTest {
    /**
     * 1.标准的输入，输出流
     * 1.1 System.in:标准的输入流，默认从键盘输入
     * System.out:标准的输出流，默认从控制台输出
     * 1.2 System类idesetIn(InputStream is) / setOut(PrintStream ps)方式重新指定输入和输出的流。
     * 1.3 练习：从键盘输入字符串，要求将读取到的整行字符串转成大写输出，然后继续进行输入操作
     * 直至当输入“e”或者“exit”时，退出程序。
     * 方法一：使用Scanner实现：调用next（）返回一个字符串
     * 方法二：使用System.in实现    System.in--->  转换流  --->  BufferefReader的readLine()
     **/
    public static void main(String[] args) {

        BufferedReader bufferedReader = null;
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(System.in);
            bufferedReader = new BufferedReader(inputStreamReader);
            while (true) {
                System.out.println("请输入字符串：");
                String data = bufferedReader.readLine();
                if ("e".equalsIgnoreCase(data) || "exit".equalsIgnoreCase(data)) {
                    System.out.println("程序结束");
                    break;
                }
                String upperCase = data.toUpperCase();
                System.out.println(upperCase);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 2,打印流:PrintStream 和 PrintWriter
     * 2.1 提供了一系列重载的print() 和println()
     **/
    @Test
    public void test2() {
        PrintStream printStream = null;
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File("E:\\ideaxiangmu\\IOStream\\hello.txt"));
            printStream = new PrintStream(fileOutputStream,true);
            if (printStream != null){
                System.setOut(printStream);
            }
            /**
             *  输出ASCII字符
             **/
            for (int i = 0; i <= 255; i++) {
                System.out.print((char)i);
                /**
                 *  每50个数据一行
                 **/
                if (i % 50 == 0){
                    System.out.println();
                }
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }

    /**
     *  3.数据流
     *   3.1 DatatInputSteam 和 DataOutPutStream
     *   3.2 作用：用于读取或写出基本数据类型的变量或字符串
     *
     *   练习：将内存中的字符串、基本数据类型的变量写出到文件中。
     *   注意：处理异常的话，仍然应该使用try-catch-finnally
     **/
    @Test
    public void test3() throws IOException {
        DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream("data.txt"));
        dataOutputStream.writeUTF("张三四");
        //刷新操作，将内存中的数据写入文件
        dataOutputStream.flush();
        dataOutputStream.writeInt(24);
        dataOutputStream.flush();
        dataOutputStream.writeBoolean(true);
        dataOutputStream.flush();
        dataOutputStream.close();
    }

    /**
     *  将文件中存储的基本数据类型变量和字符串读取到内存中，保存在变量中
     *  注意点：读取不同类型的数据的顺序要与当初写入文件时，保存的数据的顺序一致！
     **/
    @Test
    public void test4() throws IOException {
        //1.
        DataInputStream dataInputStream = new DataInputStream(new FileInputStream("data.txt"));
        //2.
        String name = dataInputStream.readUTF();
        int age = dataInputStream.readInt();
        boolean isMale = dataInputStream.readBoolean();
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        System.out.println("isMale = " + isMale);
        //3.
        dataInputStream.close();
    }

}

