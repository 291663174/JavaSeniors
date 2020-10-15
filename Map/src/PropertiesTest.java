import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author Wuhen
 * @Description
 * @date 2020-10-07 1:34
 **/
public class PropertiesTest {

    //Properties：常用来处理配置文件。key和value都是String类型
    public static void main(String[] args){

        FileInputStream fileInputStream = null;
        try {
            Properties properties = new Properties();
            fileInputStream = new FileInputStream("E:\\ideaxiangmu\\Map\\resourses\\jdbc.properties");
            //加载流对应的文件
            properties.load(fileInputStream);
            String name = properties.getProperty("name");
            String password = properties.getProperty("password");
            System.out.println("name = " + name + ", password = " + password);
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
        }

    }

}
