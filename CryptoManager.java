package jkyeiasare1;

public class CryptoManager {
    
    private static final char LOWER_BOUND = ' ';
    private static final char UPPER_BOUND = '_';
    private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

    /**
     * This method determines if a string is within the allowable bounds of ASCII codes 
     * according to the LOWER_BOUND and UPPER_BOUND characters
     * @param plainText a string to be encrypted, if it is within the allowable bounds
     * @return true if all characters are within the allowable bounds, false if any character is outside
     */
    public static boolean stringInBounds (String plainText) {
        boolean val = true;
        for(int i = 0; i < plainText.length(); i++) {
            if(plainText.charAt(i) > UPPER_BOUND ) {
                val = false;
            }
            else if(plainText.charAt(i) < LOWER_BOUND ) {
                val = false;
            }
        }
        return val;
    }

    /**
     * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in plainText is replaced by the character \"offset\" away from it 
     * @param plainText an uppercase string to be encrypted.
     * @param key an integer that specifies the offset of each character
     * @return the encrypted string
     */
    public static String encryptCaesar(String plainText, int key) {
    	boolean boundCheck = stringInBounds(plainText); //checks if string in bounds
		char firstChar; //var for firstChar
		char secondChar; //var for secondChar
    	String encText = ""; //var for encText
		int newKey; //newKey var
		
		if(boundCheck == false) { //if not in bounds
			return "The selected string is not in bounds, Try again."; //error message
		}else { //else if in bounds
			while(key > 95) //while key > 95 subtract 64
				key = key - 64;
			for(int i = 0; i < plainText.length(); i++) { //for loop to iterate through plaintext
				firstChar = (char)(plainText.charAt(i)); //set first character
				newKey = (int)firstChar + key; //set x
				while(newKey > 95) { //while x > 95 subtract until in range
					newKey = newKey - RANGE;
				}
				secondChar = (char)newKey; //set second char
				encText = encText + secondChar; //create encText
			}
			
			return encText; //return encrypted text
		}
    }
    
    /**
     * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
     * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
     * to correspond to the length of plainText
     * @param plainText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the encrypted string
     */
    public static String encryptBellaso(String plainText, String bellasoStr) {
//	        int encText = 0;
//	        char back2 = '0';
//	        String enc = "";
//	        if(bellasoStr.length() < plainText.length()) {
//	            for(int i = 0; i<plainText.length(); i++) {
//	                bellasoStr = bellasoStr.charAt(i) + bellasoStr;
//	            }
//	        }
//	        for(int i = 0; i<plainText.length(); i++) {
//	            encText = plainText.charAt(i) + bellasoStr.charAt(i);
//	            if (encText > 64) {
//	                encText = encText - 64;
//	            }
//	            back2 = (char) encText;
//	            enc = enc + back2;
//	        }
//	        return enc;
    	
    	boolean boundCheck = stringInBounds(plainText); //check if plainText in bounds
		String encText = ""; //var for encryptedText
		char firstChar; //var for firstChar
		char secondChar; //var for secondChar
		
		if(boundCheck == false) { //if string out of bounds 
			return "The selected string is not in bounds, Try again."; //error message
		}else {
			for(int i = 0; plainText.length() != bellasoStr.length() && plainText.length() > bellasoStr.length() ; i++) { //if plain text longer than bellaso
				bellasoStr += bellasoStr.charAt(i); //extend bellaso
			}
			for(int i = 0; i < plainText.length(); i++) { //for loop to iterate through plainText
				firstChar = (char)(plainText.charAt(i)); //set firstChar
				secondChar = (char)(firstChar + bellasoStr.charAt(i)); //set secondChar
				while(secondChar > 95) { //while out of range
					secondChar = (char) (secondChar - RANGE); //subtract until in range
				}
				encText = encText + secondChar; //set encText
			}
			return encText; //return encText
		}
    }
    
    /**
     * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
     * and each character in encryptedText is replaced by the character \"offset\" characters before it.
     * This is the inverse of the encryptCaesar method.
     * @param encryptedText an encrypted string to be decrypted.
     * @param key an integer that specifies the offset of each character
     * @return the plain text string
     */
    public static String decryptCaesar(String encryptedText, int key) {
    	boolean boundCheck = stringInBounds(encryptedText); //check if plainText in bounds
		String plainText = ""; //var for encryptedText
		char firstChar; //var for firstChar
		char secondChar; //var for secondChar
		int newKey; //var for newKey
		
		if(boundCheck == false) { //if out of bounds
			return "The selected string is not in bounds, Try again."; //erorr message
		}else {
			while(key > 95) //if key greater than 64 subtract 64 until its not
				key -= 64;
			for(int i = 0; i < encryptedText.length(); i++) { //for loop to iterate through encText
				firstChar = (char)(encryptedText.charAt(i)); //set firstChar
				newKey = (int)(firstChar - key);
				while(newKey < 65 && newKey != ' ') {
					newKey = newKey + RANGE; //add range to newKey
				}
				secondChar = (char)newKey; //set secondChar
				plainText += secondChar; //set plainText
			}
			return plainText; //return plainText
		}
    }
    
    /**
     * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
     * the character corresponding to the character in bellasoStr, which is repeated
     * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
     * @param encryptedText an uppercase string to be encrypted.
     * @param bellasoStr an uppercase string that specifies the offsets, character by character.
     * @return the decrypted string
     */
    public static String decryptBellaso(String encryptedText, String bellasoStr) {
    	boolean boundCheck = true; //var for boundCheck
		String plainText = ""; //var for plainText
		char firstChar; //var for firstChar
		char secondChar; //var for secondChar
		int newKey;
		int extend;
		
		if(boundCheck == false) { //check if in bounds
			return "The selected string is not in bounds, Try again.";
		}else {
			for(int i = 0; encryptedText.length() != bellasoStr.length() && encryptedText.length() > bellasoStr.length(); i++) {
				bellasoStr += bellasoStr.charAt(i); //extends bellaso
			}
			for(int t = 0; t < encryptedText.length(); t++) {
				firstChar = (encryptedText.charAt(t)); //set firstChar
				newKey = (int)bellasoStr.charAt(t); //set newKey
				extend = (int)(firstChar - newKey); //set extends
				while(extend < 65 && extend != 32) { 
					extend = extend + RANGE; //extend = extend + range
				}
				secondChar = (char)extend; //set secondChar
				plainText = plainText + secondChar; //set plainText
			}
			return plainText;
		}
	
    }
}
