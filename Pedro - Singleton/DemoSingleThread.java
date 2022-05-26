package singleton;

public class DemoSingleThread {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Singleton singleton = Singleton.getInstance("FOO");
        Singleton anotherSingleton = Singleton.getInstance("BAR");
        System.out.println(singleton.value);
        System.out.println(anotherSingleton.value);
	}

}
