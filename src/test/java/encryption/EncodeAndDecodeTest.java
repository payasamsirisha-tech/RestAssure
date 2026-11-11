package encryption;

import java.util.Base64;

import org.testng.annotations.Test;

public class EncodeAndDecodeTest {
	
@Test
public void sampleTest() {
	
	String endcodeData=new String(Base64.getEncoder().encode("ABC".getBytes()));
	System.out.println(endcodeData);
	
	
	String decodeDate=new String(Base64.getDecoder().decode(endcodeData.getBytes()));
	System.out.println(decodeDate);
	
}

}
