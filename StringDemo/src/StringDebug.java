import org.junit.Test;

/**
 * @author Wuhen
 * @Description
 * @date 2020-09-23 18:49
 **/
public class StringDebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(str);

        System.out.println(stringBuffer.length());//4

        System.out.println(stringBuffer);//"null"

        StringBuffer stringBuffer1 = new StringBuffer();
        System.out.println(stringBuffer1);//
    }
}
