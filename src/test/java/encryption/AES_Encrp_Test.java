package encryption;

import org.testng.annotations.Test;

public class AES_Encrp_Test {

//symetric
	@Test
	public void sampleTest() {

		String privateKey="AcO3tEam@j!tu_#1";
		String data="{\"name\":\"siri\", \"id\":1}";  //json body

		EncryptionAndDecryptionUtility ed=new EncryptionAndDecryptionUtility();
		//System.out.println(ed.encrypt(data, privateKey));


		//System.out.println(ed.decrypt("75mzgdjydwdwidh",privateKey));	


	}

}
