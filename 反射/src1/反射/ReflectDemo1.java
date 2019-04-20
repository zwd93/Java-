package 反射;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectDemo1 {
	public static void main(String[] args) throws Exception {

		getParams();
	
	}
	
	//通过反射来操作类
	public static void getClassMessage() throws Exception {
		/*1.获取反射对象（反射入口）
		 * 三种方式：（1）：Class.forName(全类名：包名+类名);
		 *          （2）：类.class;
		 *          （3）：对象.getClass();
		 */
		
		//（1）.Class.forName(全类名：包名+类名);
		//Class<?>:泛型的通配符，表示perClass可以是任意的类型
		Class<?> perClass = Class.forName("反射.Person");
		System.out.println(perClass);
		
		//（2）.类.class;
		Class<?> perClass2 = Person.class;
		System.out.println(perClass2);
		
		//（3）.对象.getClass();
		Person p = new Person();
		Class<?> perClass3 = p.getClass();
		System.out.println(perClass3);
	}
	
	//获取方法
	public static void getClassMethod() {
		//获取反射对象
		Class c = Person.class;
		//获取所有的public方法:包括父类的方法
	    Method[] m1 = c.getMethods();
	    c.getDeclaredMethods();//获取该类的所有方法
	    for (Method method : m1) {
			System.out.println(method);
		}
	}
	
	//获取所有的接口
	public static void getInterface() {
		Class c = Person.class;
		Class[] interfaces = c.getInterfaces();
		for (Class class1 : interfaces) {
			System.out.println(class1);
		}
	}
	
	//获取所有父类
	public static void getFoo() {
		Class c = Person.class;
		Class cfoo = c.getSuperclass();
		System.out.println(cfoo);
	}
	
	//获取所有的构造函数
	public static void getContructor() {
		Class c = Person.class;
		Constructor[] cons = c.getConstructors();
		for (Constructor con : cons) {
			System.out.println(con);
		}
	}
	
	//获取所有的属性
	public static void getParams() {
		Class c = Person.class;
		Field[] fields = c.getFields();//获取所有的public属性
//		Field[] fields = c.getDeclaredFields();//获取所有的属性
		for (Field field : fields) {
			System.out.println(field);
		}
	}
	
	
}
