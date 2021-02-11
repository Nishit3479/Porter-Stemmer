package ir.lab.assignment;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.tartarus.snowball.ext.PorterStemmer;

public class porter_stemmer 
{
	public static void main(String []args)
	{
		String data = ""; 
		try { 
			data = new String(Files.readAllBytes(Paths.get("test.txt")));
			} 	
		catch (IOException e) { 
			e.printStackTrace(); 
			} 
		System.out.println("The Entered Data : "+data);
		String str = data.toLowerCase();
		String St="";
		for(int i=0; i<str.length(); i++)
		{
			char p = str.charAt(i);
			if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
					p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
			{
				St +=" "+p;
			}
			else
			{
				St += p;
			}
		}
		String []token = St.split(" ");
		String []T = new String[token.length];
		for(int i = 0; i < token.length; i++)
		{
			try 
			{
				T[i] = PStemmer(token[i]);
			} 
			catch (IOException e) 
			{
				e.printStackTrace();
			}
		}
		String S = "";
		System.out.println("\nThe Stemmed Words : ");
		for(int i = 0; i < token.length; i++)
		{
			if(token[i].equals(T[i])==false)
			{
				S = S+" "+T[i];
				System.out.println(token[i]+" --> "+T[i]);
			}
			else
			{
				char p = T[i].charAt(0);
				if(p=='.' || p==',' || p=='/' || p=='!' || p=='@' || p=='-' || p=='=' || p==';' || p==':' || p=='?' || p=='_' || p=='#' || p=='%' || p=='&' || p=='$' || 
						p=='^' || p=='*' || p=='(' || p==')' || p=='+' || p=='{' || p=='[' || p=='}' || p==']' || p=='|' || p=='<' || p=='>' || p=='~' || p=='`')
				{
					S = S+p+" ";
				}
				else
				{
					S = S+" "+T[i];
				}
			}
		}
		System.out.println("\nThe document After Stemming : "+S);
	}
	public static String PStemmer(String input) throws IOException 
	{
        PorterStemmer stemmer = new PorterStemmer();
        stemmer.setCurrent(input);
        stemmer.stem();
        return stemmer.getCurrent();
    }
}
