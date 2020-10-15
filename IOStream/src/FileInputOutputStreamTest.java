import org.junit.Test;

import java.io.*;

/**
 * @author Wuhen
 * @Description 测试FileInputStream和FileOutputStream的使用
 * 结论：
 * 1.对于文本文件（.txt,.java,.c,.cpp），使用字符流处理
 * 2.对于非文本文件(.jpg,.mp3,.mp4,.avi,.doc,.ppt,...)，使用字节流处理
 * @date 2020-10-09 11:09
 **/
public class FileInputOutputStreamTest {

    /**
     * 使用字节流FileInputStream处理文本文件，可能出现乱码。
     **/
    @Test
    public void testFileInputStream() {
        FileInputStream fileInputStream = null;

        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fileInputStream = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            //记录每次读取的字节的个数
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                //4.关闭资源
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 实现对图片的复制操作
     **/
    @Test
    public void testFileInputOutputStream() throws FileNotFoundException {

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File("1.jpg");
            File destFile = new File("11.jpg");

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[5];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fileOutputStream != null) {
                    fileInputStream.close();
                }
                if (fileInputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //指定路径下文件的复制
    public void copyFile(String srcPath,String destPath){

        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            fileInputStream = new FileInputStream(srcFile);
            fileOutputStream = new FileOutputStream(destFile);

            //复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while ((len = fileInputStream.read(buffer)) != -1) {
                fileOutputStream.write(buffer, 0, len);
            }
            System.out.println("复制成功！");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            try {
                if (fileOutputStream != null) {
                    fileInputStream.close();
                }
                if (fileInputStream != null) {
                    fileOutputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();

//        String srcPath = "E:\\ideaxiangmu\\IOStream\\333.mp4";
//        String destPath = "E:\\ideaxiangmu\\IOStream\\444.mp4";

        //可以复制，不能控制台输出
        String srcPath = "E:\\ideaxiangmu\\IOStream\\hello.txt";
        String destPath = "E:\\ideaxiangmu\\IOStream\\hello3.txt";

        copyFile(srcPath,destPath);

        long end = System.currentTimeMillis();

        System.out.println("复制操作花费的时间为：" + (end - start));
    }

}
