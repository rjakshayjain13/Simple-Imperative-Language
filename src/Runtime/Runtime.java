package Runtime;


import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.HashMap;
public class Runtime {
	
	public static int LineNumber = 0;
	public static ArrayList<String> records = new ArrayList<String>();
	public static HashMap<String, Integer> table = new HashMap<String, Integer>();
	public static Stack<String> stack = new Stack<String>();
	static Scanner scanner = null;
	public static void main(String[] args) {
		
		
		String path = "C:\\Users\\ACE\\workspace\\Compiler\\src\\compiler\\intermediate.silc";
		
		try {
			scanner = new Scanner(Paths.get(path));
			while (scanner.hasNext()){
			//	System.out.println(scanner.nextLine());
				 List<String> tokens = getTokens(scanner.nextLine());
				 Parser.ProcessTokens(tokens); 
				// System.out.println(tokens);
			}
		
			
		}
			catch(Exception e)
			{
				
			}

	}


	
	public static List<String> getTokens(String str) {
		List<String> tokens = new ArrayList<String>();
		String regex = "\"([^\"]*)\"|(\\S+)";
		Matcher m = Pattern.compile(regex).matcher(str);
		while (m.find()) {
	        if (m.group(1) != null)
	            tokens.add( m.group(1));
	        else
	            tokens.add( m.group(2));
		}
		
		return tokens;		
	}
}
