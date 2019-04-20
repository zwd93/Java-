package ∑¥…‰;

public class Person implements MyInterface{
	private int id;
	private String name;
	private int age;
	
	public Person() {
		super();
	}
	public Person(int id) {
		super();
		this.id = id;
	}
	private Person( String name) {
		super();
		this.name = name;
	}
	public Person(int id, String name, int age) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public static void staticMethod() {
		System.out.println("static Method......");
	}
	private static void privateMethod() {
		System.out.println("private Method......");
	}
	private static void privateMethod(String str) {
		System.out.println("private Method......" + str);
	}
	@Override
	public void interfaceMethod() {
		System.out.println("interfaceMethod......");
	}
}
