import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Wuhen
 * @Description
 *   一：说明：Java中的对象，正常情况下，只能进行比较：== 或 ！= 。 不能使用 > 或 < 的
 *            但是在开发场景中，我们需要对多个对象进行排序，言外之意，就需要比较对象的大小。
 *   二、Comparable与接Comparator的使用的对比：
 *		Comparable接口的方式一旦一定，保证Comparable接口实现类在任何位置都可以比较大小
 *  @date 2020-09-26 15:16
 **/
public class CompareTest {
    /**
	*  Compareable接口的使用实例：  自然排序
	*   1.像String，包装类等实例Conpareable接口，重写了Compareto（obj）方法，给出了比较两个对象大小的方式
	*   2.像String,包装类重写CompareTo（）方法以后，进行了从小到大的排列
	*   3.重写Compareto（）的规则：
	*      如果当前对象this大于形参对象obj，则返回正整数
	*      如果当前对象this小于形参对象obj，则返回负整数
	*      如果当前对象this等于形参对象obj,则返回0
	*   4.对于自定义类来说，如果需要排序，我们可以让自定义类实现Comparable,重写Compareto（obj）方法
	*   	  在Compareto（obj）方法中指明如何排序
	**/
    @Test
    public void test1(){
	   String[] arr = new String[]{"AA","BB","CC","DD","KK","MM"};
	   Arrays.sort(arr);
	   System.out.println(Arrays.toString(arr));
    }

    @Test
    public void test2(){
	   Goods[] arr = new Goods[4];
	   arr[0] = new Goods("联想鼠标",34);
	   arr[1] = new Goods("dell鼠标",45);
	   arr[2] = new Goods("小米鼠标",22);
	   arr[3] = new Goods("华为鼠标",65);
	   Arrays.sort(arr);
	   System.out.println(Arrays.toString(arr));
    }

    /**
     *	Comparator接口的使用，定制排序
	*	1.背景：
	*		当元素的类型没有实现java.lang.Comparable接口而又不方便修改代码。
	*		或者实现了java.lang.Comparable接口的排序规则不适合当前的操作。
	*	那么可以考虑使用Comparator的对象来排序
	*	2.重写Comparable（Object o1, Object o2）方法，比较o1和o2的大小：
	*		如果方法返回正整数，则表示o1大于o2
	*		如果方法返回负整数，则表示o1小于o2
     **/
     @Test
	public void test3(){
		String[] arr = new String[]{"AA","BB","CC","DD","KK","MM"};
     	Arrays.sort(arr,new Comparator(){
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof String && o2 instanceof String){
					String s1 = (String) o1;
					String s2 = (String) o2;
					return -s1.compareTo(s2);
				}
				//return 0;
				throw new RuntimeException("输入的数据类型不一致");
			}
		});
		System.out.println(Arrays.toString(arr));
	}

	@Test
	public void test4(){
		Goods[] arr = new Goods[5];
		arr[0] = new Goods("e  联想鼠标",34);
		arr[1] = new Goods("b  dell鼠标",45);
		arr[2] = new Goods("d  小米鼠标",22);
		arr[3] = new Goods("c  华为鼠标",65);
		arr[4] = new Goods("a  微软鼠标",55);
		Arrays.sort(arr, new Comparator() {
			/**
			 *  指明商品比较大小的方式:按照产品名称从低到高排序，再按照价格从高到低排序
			 **/
			@Override
			public int compare(Object o1, Object o2) {
				if (o1 instanceof Goods && o2 instanceof Goods){
					Goods g1 = (Goods) o1;
					Goods g2 = (Goods) o2;
					if (g1.getName().equals(g2.getName())){
						return -Double.compare(g1.getPrice(), g2.getPrice());
					}else {
						return g1.getName().compareTo(g2.getName());
					}
				}
				throw new RuntimeException("输入的数据类型不一致");
			}
		});
		System.out.println(Arrays.toString(arr));
	}
}
