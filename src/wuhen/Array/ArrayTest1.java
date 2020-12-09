/**   
* Description:   
* @author WuHen
* @date 2020年8月18日  
* @version 1.0  
*/
package wuhen.Array;

/**
 * Description: 
 * 	⑤ 数组元素的默认初始化值 
 *  			   数组元素是整型：0 
 *  				数组元素是浮点型：0.0 
 *  				数组元素是char型：0或'\u0000'   ,   而非‘0’ 数组元素是boolean型，false
 *     ⑥  数组的内存解析
 * @author WuHen
 * @date 2020年8月18日
 */
public class ArrayTest1 {

	public static void main(String[] args) {

		// 5.数组元素的默认初始化值
		int[] arr = new int[4];
		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
		System.out.println("***************");

		short[] arr1 = new short[4];
		for (int i = 0; i < arr1.length; i++) {
			System.out.println(arr1[i]);
		}
		System.out.println("***************");

		float[] arr2 = new float[4];
		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i]);
		}
		System.out.println("***************");

		char[] arr3 = new char[4];
		for (int i = 0; i < arr3.length; i++) {
			System.out.println("----" + arr3[i] + "****");
		}
		System.out.println("***************");

		boolean[] arr4 = new boolean[4];
		System.out.println(arr4[0] );

		System.out.println("***************");

		String[] arr5 = new String[4];
		System.out.println( arr5[0]);
		if (arr5[0] == null) {
			System.out.println("Hey boy!");
		}
		System.out.println("***************");


		int [][] nwb= new int[3][2];
		nwb[0][1] = 2;
	}

}
