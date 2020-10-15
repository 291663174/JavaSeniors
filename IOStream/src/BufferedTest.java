import org.junit.Test;

import java.io.*;

/**
 * @author Wuhen
 * @Description 处理流之一：缓冲流的使用
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 * 2.作用：提供流的读取、写入的速度
 * 提高读写速度的原因：内部提供了一个缓冲区
 * @date 2020-10-09 19:34
 **/
class Before{

    /**
     * 实现非文本文件的复制
     **/
    @Test
    public void BufferedStreamTest() {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1.造文件
            File srcFile = new File("E:\\ideaxiangmu\\IOStream\\1.jpg");
            File destFile = new File("E:\\ideaxiangmu\\IOStream\\22.jpg");
            //2.造流
            //2.1 造节点流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.复制的细节：读取、导入
            byte[] bytes = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求1：先关闭外层的流，再关闭内层的流
            if (bufferedOutputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭，关于内层流的关闭，我们可以省略
//            fileOutputStream.close();
//            fileInputStream.close();
        }
    }


    /**
     * 实现文件复制的方法
     **/
    @Test
    public void copyFileWithBuffered(String srcPath, String destPath) {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        BufferedInputStream bufferedInputStream = null;
        BufferedOutputStream bufferedOutputStream = null;

        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);
            //2.造流
            //2.1 造节点流
            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bufferedInputStream = new BufferedInputStream(fileInputStream);
            bufferedOutputStream = new BufferedOutputStream(fileOutputStream);
            //3.复制的细节：读取、导入
            byte[] bytes = new byte[10];
            int len;
            while ((len = bufferedInputStream.read(bytes)) != -1) {
                bufferedOutputStream.write(bytes, 0, len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4.资源关闭
            //要求1：先关闭外层的流，再关闭内层的流
            if (bufferedOutputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            //说明：关闭外层流的同时，内层流也会自动的进行关闭，关于内层流的关闭，我们可以省略
//            fileOutputStream.close();
//            fileInputStream.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered() {
        long start = System.currentTimeMillis();
        String srcPath = "E:\\ideaxiangmu\\IOStream\\333.mp4";
        String destPath = "E:\\ideaxiangmu\\IOStream\\555.mp4";

        copyFileWithBuffered(srcPath, destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));
    }
}

public class BufferedTest {

    BufferedReader bufferedReader = null;
    BufferedWriter bufferedWriter = null;

    /**
     * 使用BufferedReader和BufferedWrtiter实现文本文件的复制
     **/
    @Test
    public void testBufferedWriter() {

        BufferedReader bufferedReader = null;
        BufferedWriter bufferedWriter = null;

        try {
            //创建文件和相应的流
            bufferedReader = new BufferedReader(new FileReader(new File("hello.txt")));
            bufferedWriter = new BufferedWriter(new FileWriter(new File("hello4.txt")));

            //读写操作
            //方式一：使用char[]数组
//            char[] chars = new char[1024];
//            int len;
//            while ((len = bufferedReader.read(chars)) != -1) {
//                bufferedWriter.write(chars, 0, len);
////                bufferedWriter.flush();
//            }
            //方式二：使用String
            String data;
            while ((data =  bufferedReader.readLine()) != null){
                //方法一：
                //data中不包含换行符
//                bufferedWriter.write(data + "\n");
                //方法二：
                bufferedWriter.write(data);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedReader != null) {
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

}
