package _2.方法的反射;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) throws Exception {
		A a1 = new A();
		Class c1 = a1.getClass();
		
		//方法的反射操作
		//a1.print(10,20);方法的反射操作是用m对象来进行调用和a.print调用的效果
		Method m1 = c1.getMethod("print",int.class,int.class);
		
		//方法如果没有返回值则返回null，有返回值返回具体的返回值
		//m1.invoke(a1,new Object[] {10,20});
		Object o = m1.invoke(a1,10,20);
		
		//获取方法对象
		Method m2 = c1.getMethod("print",String.class,String.class);
		//对方法进行反射
		o = m2.invoke(a1,"ABC","DEF");
		
		Method m3 = c1.getMethod("print");
		m3.invoke(a1);	
	}
}

class A{
	public void print(int a,int b) {
		System.out.println(a+b);
	}
	
	public void print(String a,String b) {
		System.out.println(a+b);
	}
	
	public void print() {
		System.out.println("helle word!");
	}
}
