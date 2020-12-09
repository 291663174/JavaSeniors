/**
 * @author Wuhen
 * @Description 一道面试题
 * @date 2020-09-20 22:51
 **/
public class StringTest {

    String str = new String("good");
    char[] chars = {'t','e','s','t'};

    public void change(String str,char ch[]){
        str = "test ok";
        ch[0] = 'b';
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        stringTest.change(stringTest.str, stringTest.chars);
        //good
        System.out.println(stringTest.str);
        //best
        System.out.println(stringTest.chars);
    }
}
