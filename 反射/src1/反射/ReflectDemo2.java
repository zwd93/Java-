package 反射;

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
		demo7(person,"name","张三");
		System.out.println(person.getName());
	}
	
	//获取对象的实例，并操作对象
	public static void demo1() throws Exception{
		Class c = Person.class;
		
		Person person = (Person)c.newInstance();
		person.setName("张三");
		System.out.println(person.getName());
	}
	
	//操作属性
	public static void demo2() throws Exception {
		Class c = Person.class;
		Person person = (Person)c.newInstance();
		
		//访问的是private修饰的name，但是这个属性是私有的，无法访问，需要修改权限
		Field name= c.getDeclaredField("name");
		//修改属性的访问权限;使用反射时，如果因为访问修饰符限制造成异常，可以通过Field/Method/Constructor.setAccessible(true)
		name.setAccessible(true);
		name.set(person, "李四");		
		
		System.out.println(person.getName());
	}
	
	//操作方法
	public static void demo3() throws Exception{
		Class c = Person.class;
		Person person = (Person)c.newInstance();
		
		Method m = c.getDeclaredMethod("privateMethod");//private方法
		m.setAccessible(true);//获取访问private的方法
		m.invoke(person);//person.privateMethod();
		
		//访问带参数的private方法
		Method m1 =c.getDeclaredMethod("privateMethod", String.class);
		m1.setAccessible(true);
		m1.invoke(person, "张三");
	}
	
	//操作构造方法：可以用构造方法构造对象
	public static void demo4() throws Exception {
		Class c = Class.forName("反射.Person");
		Person person = (Person)c.newInstance();
		
		Constructor con = c.getDeclaredConstructor(int.class);//public构造方法
		System.out.println(con);
		Person psn = (Person)con.newInstance(12); //用构造方法构造对象
		System.out.println(psn);
		
		Constructor con1 = c.getDeclaredConstructor(String.class);//private构造方法
		con1.setAccessible(true);
		Person psn1 = (Person)con1.newInstance("张三");
		System.out.println(psn1);
	}
	
	//动态加载类
	public static void demo5() throws Exception {
		Properties pro = new Properties();
	//	pro.load(new FileReader("src1//反射//class.txt"));
		Reader reader = new InputStreamReader(
				new FileInputStream("src1//反射//class.txt"),"GBK");
		pro.load(reader);
		
		FileInputStream in = new FileInputStream("src1//反射//class.txt");//乱码？
		//pro.load(in);
		
		String classname = pro.getProperty("classname");
		String method = pro.getProperty("method");
		
		Class c = Class.forName(classname);
		Method mtd = c.getMethod(method);
		mtd.invoke(c.newInstance());
	}
	
	/**
	 * 利用反射越过泛型检查:虽然可以通过反射越过检查以及访问private修饰的属性和方法，但是还是要避免这种做法
	 * @throws Exception
	 */
	public static void demo6() throws Exception {
		ArrayList<Integer> lists = new ArrayList<>();
		lists.add(1);
		lists.add(2);
		
		//获取反射对象
		Class c = lists.getClass();
		//通过反射调用add方法
		Method method = c.getMethod("add",Object.class);
		method.invoke(lists,"ABC");
		
		System.out.println(lists);
	}
	
	//通过反射给属性赋值，做一个万能的set属性方法:person.setXxx(); private String name;
	public static void demo7(Object obj,String propertyName,Object value) throws Exception{
		//获取反射的入口
		Class c = obj.getClass();
		Field field = c.getDeclaredField(propertyName);//获取属性
		field.setAccessible(true);
		field.set(obj, value);
	}
}
