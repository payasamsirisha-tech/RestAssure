package panCardMocking;

import org.mockito.Mockito;

class PACard{
	public  String isvalid(String panCard) {
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) {
			return "is valid pancard";

		}else {
			return "is invalid pancard";
		}
     }
	public static  PACard getMockObject() {
		PACard mockobj=Mockito.mock(PACard.class);
		                 Mockito.when(mockobj.isvalid("ABCDE1234A")).thenReturn("Valid Pan Card");
		                 Mockito.when(mockobj.isvalid("ABCDE1234B")).thenReturn("Valid Pan Card");
		                 Mockito.when(mockobj.isvalid("ABCDE1234C")).thenReturn("In-Valid Pan Card");
						 return mockobj;
		               
	}
		
 }
public class MockingTestWithMackito {
	public static void main(String[] args) {
		PACard obj = PACard.getMockObject();
		System.out.println(obj.isvalid("ABCE1234C"));
		
	}

}
