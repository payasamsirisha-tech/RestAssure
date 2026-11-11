package panCardMocking;


//For this we can give any number or any character it will accept
//But Mocking menas developer will gve soe numbers so we need to use those only
//for that we are adding dependancy called Mockioto-core
class PANCard{
	public static String isvalid(String panCard) {
		if(panCard.matches("[A-Z]{5}[0-9]{4}[A-Z]")==true) {
			return "is valid pancard";

		}else {
			return "is invalid pancard";
		}
     }
   }
public class MockingTest {
	public static void main(String[] args) {
		System.out.println(PANCard.isvalid("ABCDE1234A"));
	}

}
