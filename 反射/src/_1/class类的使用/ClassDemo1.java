package _1.class���ʹ��;

public class ClassDemo1 {

	@SuppressWarnings("deprecation")
	public static void main(String[] args) throws Exception {
		//Foo��ʵ��������α�ʶ
		Foo foo1 = new Foo();
		//Foo�����Ҳ��һ��ʵ������Class������ʵ��������α�ʾ
		//�κ�һ���඼��Class�����ֶ������ʵ�����������ֱ�ʾ��ʽ
		
		//��һ�ֱ�ʾ��ʽ--->ʵ���ڸ��������κ�һ���඼��һ�������ľ�̬��Ա����class
		Class c1 = Foo.class;
		System.out.println(c1.getName());
		
		//�ڶ��ֱ�ʾ��ʽ--->�Ѿ�֪������Ķ���ͨ��getClass����
		Class c2 = foo1.getClass();
		
		/*������c1,c2��ʾ��Foo��������ͣ�class type��
		 * ��Ҳ�Ƕ�����Class���ʵ������
		 * ����������ǳ�Ϊ�����������*/
		//����c1 or c2 ��������Foo�� �������ͣ�һ����ֻ������Class���һ��ʵ������
		System.out.println(c1==c2);
		
		//�����ֱ�﷽ʽ
		//Class c3 = Class.forName("_1.class���ʹ��.Foo");
	
		//System.out.println(c2== c3);
		
		//������ȫ����ͨ��������ʹ�������Ķ���ʵ��
		//Foo foo = (Foo)c1.newInstance();//����Foo�������;ǰ����Ҫ���޲ι��캯��
	}
	
}

class Foo{
	public Foo(){		
	}
}
