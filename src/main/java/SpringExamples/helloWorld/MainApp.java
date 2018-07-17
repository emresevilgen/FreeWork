package SpringExamples.helloWorld;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {
   public static void main(String[] args) {
	   AbstractApplicationContext context = new ClassPathXmlApplicationContext("BeansHelloWorld.xml");
	   	
	   HelloWorld objA = (HelloWorld) context.getBean("helloWorld");
	   objA.getMessage1();
	   objA.getMessage2();
	   
	   HelloTurkey objB = (HelloTurkey) context.getBean("helloTurkey");
	   objB.getMessage1();
	   objB.getMessage2();
	   objB.getMessage3();
   	}
}