package _2.�����ķ���;

import java.lang.reflect.Method;

public class MethodDemo1 {
	public static void main(String[] args) throws Exception {
		A a1 = new A();
		Class c1 = a1.getClass();
		
		//�����ķ������
		//a1.print(10,20);�����ķ����������m���������е��ú�a.print���õ�Ч��
		Method m1 = c1.getMethod("print",int.class,int.class);
		
		//�������û�з���ֵ�򷵻�null���з���ֵ���ؾ���ķ���ֵ
		//m1.invoke(a1,new Object[] {10,20});
		Object o = m1.invoke(a1,10,20);
		
		//��ȡ��������
		Method m2 = c1.getMethod("print",String.class,String.class);
		//�Է������з���
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
