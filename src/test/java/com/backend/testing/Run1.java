package com.backend.testing;

import org.testng.annotations.Test;
//import com.backend.testing.A;
import static com.backend.testing.A.*;

public class Run1 {
	@Test
	
	
	public void sampleTest() {
		//this is without static import
		//	A.given();
		//	A.then();
		//	A.when();
		
		
		/*we already done Static import so no need to use calss name...this functionality is 
		 * avalibale only for JDK 1.5 above version*/
		given();
		when();
		then();

	}

}
