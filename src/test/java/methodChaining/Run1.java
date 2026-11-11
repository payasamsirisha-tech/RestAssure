package methodChaining;

import org.testng.annotations.Test;

public class Run1 {
	@Test
	public void sampleTest() {
		
		//if we create static methods no need to do object just import
		A a1=new A();
		a1.a().b().c().d();
		
	}

}
