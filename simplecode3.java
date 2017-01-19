
/**
 *
 * @author Sam Tell
 * @version 3
 * @since 2016-05-01
 */
import javax.swing.JOptionPane;
import java.io.*;
public class simplecode3
{
	/**
	* This code accepts a message and an integer in JOptionPane;
	* It will encode the message using a simple shifted alphabet substitution cipher, 
	* the integer as the number of spaces forward in the alphabet each letter will be shifted;
	* It will print the encoded message to a text file;
	* It lets you loop to the beginning and enter another message if you want.
        * @param args unused
	*/
	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException
	{
		String[] num = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25"};
                PrintWriter output = new PrintWriter("output.txt", "UTF-8");
		int cont = JOptionPane.YES_OPTION;
		while(cont == JOptionPane.YES_OPTION)
		{
			String s         = JOptionPane.showInputDialog("Text")	;	char[] c        = s.toCharArray()       ;
			String ns 	 = (String) JOptionPane.showInputDialog
                                                    (
							null, "Key", null,
							JOptionPane.QUESTION_MESSAGE,
							null, num, num[0]
                                                    )				;	int n           = Integer.parseInt(ns)	;
			for(int i = 0; i < c.length; i++)
				c[i]     = get(c[i], n)				;	String cs       = new String(c)		;
			char[] alpha1    = alpha.clone();
			for(int j = 0; j < alpha1.length; j++)
                                alpha1[j]= get(alpha1[j], n)			;	String alpha1s	= new String(alpha1)	;
											String alphas 	= new String(alpha)	;

			String out = "===================================\n"	+
                                     "\t"	+ alphas              + "\n"	+
				     "Crypt:\t" + alpha1s	      + "\n"	+
				     "-----------------------------------\n"	+
				     "\n"	+ cs  		      + "\n"	;
			output.println(out);

			cont = JOptionPane.showConfirmDialog(null, "Again?", null, JOptionPane.YES_NO_OPTION);
		}
                output.close();
	}
        
        /**
	* A char array of the alphabet.
	*/
	public static char[] alpha = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','o','p','q','r','s','t','u','v','w','x','y','z',' '};


	/**
	* Encodes one character with a simple shifted character substitution cipher.
	* @param c A character to be encoded.
	* @param n The number a spaces forward in the alphabet that c will be shifted.
	* @return  If c is not a letter in the standard English alphabet, c itself will be returned;
	*		   else, c shifted n spaces forward in the alphabet will be returned, preserving case.
	*/
	public static char get(char c, int n)
	{
		int i;
		for(i = 0; Character.toLowerCase(c) != alpha[i] && i != 26; i++);
		if(i == 26)
			return c;
		else
		{
			n = (n + i) % 26;
			return Character.isUpperCase(c)?
						Character.toUpperCase(alpha[n]):
						alpha[n];
		}
	}
}