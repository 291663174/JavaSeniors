import org.junit.Test;

/**
 * @author Wuhen
 * @Description
 * @date 2020-09-20 23:14
 **/
public class StringMethodTest {

    /**
     *  替换:String replace(char oldChar,char newChar):返回一个新的字符串，它是通过用newChar替换此字符串中
     *              出现的所有oldChar得到的
     *       String replace(CharSequence target,CharSequence replacement):使用指定的字面值替换序列替换
     *              此字符串所有匹配字面值目标序列的子字符串。
     *       String replaceALL(String regex,String replacement):使用给定的replacement替换此字符串所有匹配的
     *              正则表达式的子字符串。
     *       String replaceALL(String regex,String replacement):使用给定的replacement替换此字符串所有匹配的
     *              正则表达式的第一个子字符串。
     *       boolean matches(String regex)：告知此字符串是否匹配给定的正则表达式。
     *       String[] split(String regex)： ：根据给定正则表达式的匹配拆分此字符串。
     *       String[] split(String regex, int limit)： ：根据匹配给定的正则表达式来拆分此
     *                字符串，最多不超过limit个，如果超过了，剩下的全部都放到最后一个元素中。
     **/
    @Test
    public void test4(){
        String str1 = "北京市,北京市";
        String str2 = str1.replace("北", "南");
        System.out.println(str1);
        System.out.println(str2);
        System.out.println("************");

        String str3 = "123hello567world89java0mysql2333";
        //把字符串中的数字替换成，   如果结果中开头和结尾有，的话去掉
        //   \d+表示多个数字
        String string = str3.replaceAll("\\d+", ",").replaceAll("^,|,$","");
        System.out.println(string);

        String str = "12345";
        //判断str字符串中是否全部有数字组成，即有1-n个数字组成
        boolean matches = string.matches("\\d+");
        System.out.println(matches);

        String tel = "0591-4534323";
        //判断这是否是一个福州的固定电话
        boolean result = tel.matches("0591-\\d{7,8}");
        System.out.println(result);


    }

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("rld");
        System.out.println(b1);

        boolean b3 = str1.startsWith("11",2);
        System.out.println(b3);

        String str2 = "wor";
        System.out.println(str1.contains(str2));

        //最小是0，从0，1，2，...一直到找到  结果是3
        System.out.println(str1.indexOf("lo"));
        //找不到，也就是没有，就得取0前面的，返回-1
        System.out.println(str1.indexOf("lol"));

        //从5开始找，找不到，返回-1
        System.out.println(str1.indexOf("lo", 5));
        //还是得从前往后数，0，1，2，3找到了
        System.out.println(str1.lastIndexOf("low"));
        //从5，4，3，2，1，0开始找，到3找到了
        System.out.println(str1.lastIndexOf("low",5));
        //什么情况下，存在唯一的一个str,   情况二：不存在str
    }

    /**
     *  int length():返回字符串的长度: return value.length
     *  char charAt(int index):判断是否是空字符串 return value.length == 0;
     *  boolean isEmpty():判断是否是空字符串  return value.length == 0
     *  String toLowerCase():使用默认语言环境，将String中的所有字符转换为小写
     *  String toUpperCase():使用默认语言环境，将String中的所有字符转换为大写
     *  String trim():返回字符串的副本，忽略前导空白和尾部空白
     *  boolean equals(Object obj):比较字符串的内容是否相同
     *  boolean equalsIgnoreCase(String anotherString):与equals方法类似，忽略大小写
     *  String concat(String str):将指定字符串连接到此字符串的结尾。等价于用“+”
     *  int compareTo(String anotherString):比较两个字符串的大小
     *  String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex开始截取到最后的一个子字符串
     *  String substring(int beginIndex,int endIndex):返回一个新字符串，它是此字符串从beginIndex开始截取到endIndex（不包含）的一个子字符串
     **/

    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloworld";
        //false
        System.out.println(s1.equals(s2));
        //true
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abe");
        //c-e=-2  所以结果为-2   涉及到字符串排序
        System.out.println(s5.compareTo(s6));

        String s7 = "福建省福州市";
        String s8 = s7.substring(3);
        System.out.println(s7);
        System.out.println(s8);

        String s9 = s7.substring(3,6);
        System.out.println(s9);
    }

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));
        //System.out.println(s1.charAt(10));
        System.out.println(s1.isEmpty());

        //s1是不可变的，仍然为原来的字符串
        System.out.println(s1);
        //改成小写以后的字符串
        System.out.println(s1.toLowerCase());

        String s3 = "   he   llo   world    ";
        //实现注册账号格式修改，删除前后空格，中间空格不影响
        String s4 = s3.trim();
        System.out.println("-----" + s3 + "-----");
        System.out.println("-----" + s4 + "-----");

    }

}
