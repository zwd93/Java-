package ����;

import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Properties;

public class ReflectDemo2 {
	public static void main(String[] args) throws Exception {
		Person person = new Person();
		demo7(person,"name","����");
		System.out.println(person.getName());
	}
	
	//��ȡ�����ʵ��������������
	public static void demo1() throws Exception{
		Class c = Person.class;
		
		Person person = (Person)c.newInstance();
		person.setName("����");
		System.out.println(person.getName());
	}
	
	//��������
	public static void demo2() throws Exception {
		Class c = Person.class;
		Person person = (Person)c.newInstance();
		
		//���ʵ���private���ε�name���������������˽�еģ��޷����ʣ���Ҫ�޸�Ȩ��
		Field name= c.getDeclaredField("name");
		//�޸����Եķ���Ȩ��;ʹ�÷���ʱ�������Ϊ�������η���������쳣������ͨ��Field/Method/Constructor.setAccessible(true)
		name.setAccessible(true);
		name.set(person, "����");		
		
		System.out.println(person.getName());
	}
	
	//��������
	public static void demo3() throws Exception{
		Class c = Person.class;
		Person person = (Person)c.newInstance();
		
		Method m = c.getDeclaredMethod("privateMethod");//private����
		m.setAccessible(true);//��ȡ����private�ķ���
		m.invoke(person);//person.privateMethod();
		
		//���ʴ�������private����
		Method m1 =c.getDeclaredMethod("privateMethod", String.class);
		m1.setAccessible(true);
		m1.invoke(person, "����");
	}
	
	//�������췽���������ù��췽���������
	public static void demo4() throws Exception {
		Class c = Class.forName("����.Person");
		Person person = (Person)c.newInstance();
		
		Constructor con = c.getDeclaredConstructor(int.class);//public���췽��
		System.out.println(con);
		Person psn = (Person)con.newInstance(12); //�ù��췽���������
		System.out.println(psn);
		
		Constructor con1 = c.getDeclaredConstructor(String.class);//private���췽��
		con1.setAccessible(true);
		Person psn1 = (Person)con1.newInstance("����");
		System.out.println(psn1);
	}
	
	//��̬������
	public static void demo5() throws Exception {
		Properties pro = new Properties();
	//	pro.load(new FileReader("src1//����//class.txt"));
		Reader reader = new InputStreamReader(
				new FileInputStream("src1//����//class.txt"),"GBK");
		pro.load(reader);
		
		FileInputStream in = new FileInputStream("src1//����//class.txt");//���룿
		//pro.load(in);
		
		String classname = pro.getProperty("classname");
		String method = pro.getProperty("method");
		
		Class c = Class.forName(classname);
		Method mtd = c.getMethod(method);
		mtd.invoke(c.newInstance());
	}
	
	/**
	 * ���÷���Խ�����ͼ��:��Ȼ����ͨ������Խ������Լ�����private���ε����Ժͷ��������ǻ���Ҫ������������
	 * @throws Exception
	 */
	public static void demo6() throws Exception {
		ArrayList<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		
		//��ȡ�������
		Class c = lists.getClass();
		//ͨ���������add����
		Method method = c.getMethod("add",Object.class);
		method.invoke(lists,"ABC");
		
		System.out.println(lists);
	}
	
	//ͨ����������Ը�ֵ����һ�����ܵ�set���Է���:person.setXxx(); private String name;
	public static void demo7(Object obj,String propertyName,Object value) throws Exception{
		//��ȡ��������
		Class c = obj.getClass();
		Field field = c.getDeclaredField(propertyName);//��ȡ����
		field.setAccessible(true);
		field.set(obj, value);
	}
}
