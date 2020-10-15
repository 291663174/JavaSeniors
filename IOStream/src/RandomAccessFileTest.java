import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author Wuhen
 * @Description
 *  RandomAccessFile的使用
 *      1.RandomAccessFile直接继承于java,lang.Object类，实现了DataInput和DataOutput接口
 *      2.RandomAccessFile既可以作为一个输入流，又可以作为一个输出流
 *      3.如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *          如果写出到的文件存在，则会对原有文件内容进行覆盖（默认情况下，从头覆盖）
 *      4.可以通过相关的操作，实现RandomAccessFile“插入”数据的效果
 * @date 2020-10-11 20:38
 **/
public class RandomAccessFileTest {

    RandomAccessFile randomAccessFile1 = null;
    RandomAccessFile randomAccessFile2 = null;

    @Test
    public void test1() throws IOException {

        try {
            randomAccessFile1 = new RandomAccessFile(new File("1.jpg"),"r");
            randomAccessFile2 = new RandomAccessFile(new File("55.jpg"),"rw");

            byte[] bytes = new byte[1024];
            int len;
            while((len = randomAccessFile1.read()) != -1){
                randomAccessFile2.write(bytes,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (randomAccessFile1 != null){
                randomAccessFile1.close();
            }
            if (randomAccessFile2 != null){
                randomAccessFile2.close();
            }
        }
    }

    @Test
    public void test2() throws IOException {

        RandomAccessFile randomAccessFile3 = new RandomAccessFile("hello.txt", "rw");
        //将指针调到角标为3的位置
        randomAccessFile3.seek(3);
        randomAccessFile3.write("xyz".getBytes());
        randomAccessFile3.close();
    }

    /**
     *  使用RandomAccessFile实现数据的插入效果
     **/
    @Test
    public void test3() throws IOException {
        RandomAccessFile randomAccessFile4 = new RandomAccessFile("hello.txt", "rw");
        //将指针调到角标为3的位置
        randomAccessFile4.seek(3);
        //保存指针3后面的所有数据到stringBuilder中
        StringBuilder stringBuilder = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while ((len = randomAccessFile4.read(buffer)) != -1){
            stringBuilder.append(new String(buffer,0,len));
        }
        //调回指针，写入"xyz"
        randomAccessFile4.seek(3);
        randomAccessFile4.write("xyz".getBytes());
        //将stringBuilder中的数据写入到文件中
        randomAccessFile4.write(stringBuilder.toString().getBytes());
        randomAccessFile4.close();
    }
}
