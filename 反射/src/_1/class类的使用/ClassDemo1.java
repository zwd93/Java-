package _1.class类的使用;

public class ClassDemo1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		//Foo的实例对象如何标识
		Foo foo1 = new Foo();
		//Foo这个类也是一个实例对象，Class类对象的实例对象，如何表示
		//任何一个类都是Class的是咧对象，这个实例对象有三种表示方式
		
		//第一种表示方式--->实际在告诉我们任何一个类都有一个隐含的静态成员变量class
		Class c1 = Foo.class;
		System.out.println(c1.getName());
		
		//第二种表示方式--->已经知道该类的对象，通过getClass方法
		Class c2 = foo1.getClass();
		
		/*官网：c1,c2表示了Foo类的类类型（class type）
		 * 类也是对象，是Class类的实例对象
		 * 这个对象我们称为该类的类类型*/
		//不管c1 or c2 都代表了Foo类 的类类型，一个类只可能是Class类的一个实例对象
		System.out.println(c1==c2);
		
		//第三种表达方式
		//Class c3 = Class.forName("_1.class类的使用.Foo");
	
		//System.out.println(c2== c3);
		
		//我们完全可以通过类的类型创建该类的对象实例
		//Foo foo = (Foo)c1.newInstance();//创建Foo的类对象;前提需要有无参构造函数
	}
	
}

class Foo{
	public Foo(){		
	}
}
