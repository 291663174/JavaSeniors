import org.junit.Test;

/**
 * @author Wuhen
 * @Description
 * @date 2020-09-23 10:43
 **/
public class StringDemo {
    /**
     *    将一个字符串进行反转。将字符串中指定部分进行反转，比如“abcdeffg”反转为“abfedcg”
     *    //方式一：转换为char[]
     **/
    public String reverse1(String str,int startIndex,int endIndex){
        if (str != null){
            char[] arr = str.toCharArray();
            for (int x = startIndex , y = endIndex; x < y; x++, y--){
                char temp = arr[x];
                arr[x] = arr[y];
                arr[y] = temp;
            }
            return new String(arr);
        }
        return null;
    }

    //方式二：使用String的拼接
    public String reverse2(String str,int startIndex,int endIndex) {
        if (str != null){
            //第1部分
            String reverseStr = str.substring(0,startIndex);
            //第2部分
            for (int i = endIndex; i >= startIndex ;i--){
                reverseStr += str.charAt(i);
            }
            //第3部分
            reverseStr += str.substring(endIndex+1);

            return reverseStr;
        }
        return null;
    }

    //方式三：使用StringBuffer/StringBuilder替换String
    public String reverse3(String str,int startIndex,int endIndex){
        if (str != null){
            StringBuilder stringBuilder = new StringBuilder(str.length());
            //第1部分
            stringBuilder.append(str.substring(0,startIndex));
            //第2部分
            for (int i = endIndex;i >= startIndex;i--){
                stringBuilder.append(str.charAt(i));
            }
            //第3部分
            stringBuilder.append(str.substring(endIndex + 1));
            return stringBuilder.toString();
        }
        return null;
    }

    @Test
    public void testReverse(){
        String str = "abcdefg";
        String reverse3 = reverse3(str, 2, 5);
        System.out.println(reverse3);
    }

}