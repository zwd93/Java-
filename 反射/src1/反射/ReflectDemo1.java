package ����;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo1 {
	public static void main(String[] args) throws Exception {

		getParams();
	
	}
	
	//ͨ��������������
	public static void getClassMessage() throws Exception {
		/*1.��ȡ������󣨷�����ڣ�
		 * ���ַ�ʽ����1����Class.forName(ȫ����������+����);
		 *          ��2������.class;
		 *          ��3��������.getClass();
		 */
		
		//��1��.Class.forName(ȫ����������+����);
		//Class<?>:���͵�ͨ�������ʾperClass���������������
		Class<?> perClass = Class.forName("����.Person");
		System.out.println(perClass);
		
		//��2��.��.class;
		Class<?> perClass2 = Person.class;
		System.out.println(perClass2);
		
		//��3��.����.getClass();
		Person p = new Person();
		Class<?> perClass3 = p.getClass();
		System.out.println(perClass3);
	}
	
	//��ȡ����
	public static void getClassMethod() {
		//��ȡ�������
		Class c = Person.class;
		//��ȡ���е�public����:��������ķ���
	    Method[] m1 = c.getMethods();
	    c.getDeclaredMethods();//��ȡ��������з���
	    for (Method method : m1) {
			System.out.println(method);
		}
	}
	
	//��ȡ���еĽӿ�
	public static void getInterface() {
		Class c = Person.class;
		Class[] interfaces = c.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1);
		}
	}
	
	//��ȡ���и���
	public static void getFoo() {
		Class c = Person.class;
		Class cfoo = c.getSuperclass();
		System.out.println(cfoo);
	}
	
	//��ȡ���еĹ��캯��
	public static void getContructor() {
		Class c = Person.class;
		Constructor[] cons = c.getConstructors();
		for (Constructor con : cons) {
			System.out.println(con);
		}
	}
	
	//��ȡ���е�����
	public static void getParams() {
		Class c = Person.class;
		Field[] fields = c.getFields();//��ȡ���е�public����
//		Field[] fields = c.getDeclaredFields();//��ȡ���е�����
		for (Field field : fields) {
			System.out.println(field);
		}
	}
	
	
}
