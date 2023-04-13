package jkyeiasare1;

//studentTest
public class CryptoManagerStudentTest {

	public static void main(String[] args) {
		
	
		String student1 = "KFGG";
		String student2 = "DOVGHSZ";
		String student3 = "ABCDEFG"; 
		String student4 = "JEFF";
		String bellasoStr = "CMSC";
		String student5 = "LGHH";
		String studen6 = "WU\\VR9F#N!RF88U-'HED";
	
		System.out.println("Caesar cipher of " +student4+ " should return KFGG: "   + CryptoManager.encryptCaesar(student4, 1));
		System.out.println("Bellaso cipher of " + student3 +  " should return DOVGHSZ:" + CryptoManager.encryptBellaso(student3, bellasoStr));
		System.out.println("Bellaso decryption of " +student2 +" should return ABCDEFG: "    + CryptoManager.decryptBellaso(student2, bellasoStr));
		System.out.println("Caesar decryption of " + student1 + " should return JEFF: "+ CryptoManager.decryptCaesar(student1, 1));
		System.out.println("Caesar cipher of " +student4+ " should return LGHH: "   + CryptoManager.encryptCaesar(student4, 66));
	}
}
