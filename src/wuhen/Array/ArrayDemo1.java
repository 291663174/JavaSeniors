/**   
* Description:   
* @author WuHen
* @date 2020年8月19日  
* @version 1.0  
*/  
package wuhen.Array;

import java.util.Scanner;

/**  
* Description: 
 * 	从键盘读入学生成绩，找出最高分，并输出学生成绩等级。
 * 			成绩>=最高分-10   等级为'A'
 * 			成绩>=最高分-20   等级为'B'
 * 			成绩>=最高分-30   等级为'C'
 * 			其余   等级为D'
 * 	提示：先读入学生人数，根据人数创建int数组，存放学生成绩。
* @author WuHen
* @date 2020年8月19日  
*/
public class ArrayDemo1 {

	public static void main(String[] args) {

		//1.使用Scanner，读取学生个数
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入学生人数：");
		int number = scanner.nextInt();
		
		//2.创建数组，存储学生成绩，动态初始化
		int[] scores = new int[number];
		
		//3.给数组中的元素赋值
		System.out.println("请输入" + number + "个学生成绩：");
		for (int i = 0; i < scores.length; i++) {
			scores[i] = scanner.nextInt();
		}
		
		//4.获取数组中的元素的最大值：最高分
		int maxScore = 0;
		for (int i = 0; i < scores.length; i++) {
			if (maxScore<scores[i]) {
				
			}
		}
		
		//5.根据每个学生成绩与最高分的差值，得到每个学生的登记，并输出等级和成绩
		
	}
	
}
