package Runtime;
import java.util.ArrayList;
import java.util.List;

import org.omg.SendingContext.RunTime;
import org.stringtemplate.v4.compiler.CodeGenerator.list_return;

public class Parser {
	static int  count = 0;
	public static void ProcessTokens(List<String> tokens) {
		int val1 , val2;
		
	
		switch (tokens.get(0)) {
	
		case "DISP" : 		String print = Runtime.table.containsKey(tokens.get(1))? String.valueOf(Runtime.table.get(tokens.get(1))):tokens.get(1);
							System.out.println(print);
			break;
		case "LOAD" : 		
			String var = tokens.get(1);
			int val = Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
			
			Runtime.table.put(var, val);
			
			break;
	
		case "ADD" : 		 val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
							 val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
							//System.out.println(tokens.get(3)+"fdsfs");
							Runtime.table.put(tokens.get(3), val1+val2);
			break;
		case "SUB" : 		val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
							val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
							Runtime.table.put(tokens.get(3), val1-val2);
			break;
		case "MUL" : 		
							
							val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
							val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
							
							Runtime.table.put(tokens.get(3), val1*val2);
			break;
		case "DIV" : 		val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
							val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
							Runtime.table.put(tokens.get(3), val1/val2);
			break;
		case "GT" : 		val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
							val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
							Runtime.table.put(tokens.get(3), val1-val2);
			break;
		case "CHECK" : 		
			    
				
				{
			 	List<String> tok=Runtime.getTokens(Runtime.scanner.nextLine()); 
			 	
			 	if(tok.size()==1)
			 	{
			 	   if(tok.get(0).equalsIgnoreCase("TRUE"))
			 	   {
			 		   Runtime.stack.push("OR");
			 		   Parser.ProcessTokens(Runtime.getTokens(Runtime.scanner.nextLine()));
			 	   }
			 	   else if(tok.get(0).equalsIgnoreCase("FALSE"))
			 	   {/*
			 		  while(!Runtime.getTokens(Runtime.scanner.nextLine()).get(0).equals("OR"))
		 			   {
		 			   
		 			   }*/
			 		  List<String> ifElseTokens = null;
		 			  while((!(ifElseTokens=Runtime.getTokens(Runtime.scanner.nextLine())).get(0).equals("OR") && !ifElseTokens.get(0).equals("STOP")))
		 			   {
		 			      if(ifElseTokens.get(0).equals("CHECK"))
		 			      {
		 			    	 while((!(ifElseTokens=Runtime.getTokens(Runtime.scanner.nextLine())).get(0).equals("STOP") ))
		 			    	 {}
		 			      }
		 			   }
			 		  
		 			   Runtime.stack.push("STOP");
		 			   Parser.ProcessTokens(Runtime.getTokens(Runtime.scanner.nextLine()));
			 	   }
			 			   
			 	}
			 	else if(tok.get(0).equals("LT"))
			 	{
			 		
			 		handleComparisions(tok);
			 		
			 	}
			 	else
			 	{
			 		List<String> complex=tok;
			 		while(!complex.get(0).equals("LT"))
		 			   {
			 				
			 				Parser.ProcessTokens(complex);
			 				complex=Runtime.getTokens(Runtime.scanner.nextLine());
		 			   }
			 		
			 		handleComparisions(complex);
			 	}
				}
			break;
			
		case "OR" : 
			
					if(Runtime.stack.peek().equals("OR"))
					{
						//System.out.println(tokens);
						//System.out.println(Runtime.stack);
						//List<String> end = ;
						while(!Runtime.getTokens(Runtime.scanner.nextLine()).get(0).equals("STOP"))
			 			   {
			 			 //  System.out.println(Runtime.scanner.nextLine()+"bhjS");
							
			 			   }
						Runtime.stack.pop();
					}
			break;
		case "STOP":
			
			
			
			       if(Runtime.stack.peek().equals("STOP") || Runtime.stack.peek().equals("OR"))
			       {
			    	   Runtime.stack.pop();
			       }
			
			break;
		case "LOOP" : 
			
			List<String> condition = Runtime.getTokens(Runtime.scanner.nextLine());
			//System.out.println(condition);
			List<String> loopStatement = Runtime.getTokens(Runtime.scanner.nextLine());
			
			loopStatements = new ArrayList<List<String>>();
			loopStatements.add(new ArrayList<String>(loopStatement));
			
			while(!loopStatement.get(0).equals("END"))
			{
				
				loopStatement = Runtime.getTokens(Runtime.scanner.nextLine());
				
				loopStatements.add(new ArrayList<String>(loopStatement));
			}
			
			loopStatements.remove(loopStatements.size()-1);
			System.out.println(loopStatements);
			
			
			while(ProcessTokensComparisonTokens(condition))
			{
				for(List<String> loopLine:loopStatements)
				{
					System.out.println(loopLine);
					Parser.ProcessTokens(loopLine);
				}
			}
			break;
	
			default : break;
		}
	}
	static List<List<String>> loopStatements=null;
	public static void handleComparisions(List<String> tok)
	{
		
		if(ProcessTokensComparisonTokens(tok))
 		{
				
 			Runtime.stack.push("OR");
 			List<String> str = Runtime.getTokens(Runtime.scanner.nextLine());
 			
 			Parser.ProcessTokens(str);
 		}
 		else
 		{
 			  List<String> ifElseTokens = null;
 			  while((!(ifElseTokens=Runtime.getTokens(Runtime.scanner.nextLine())).get(0).equals("OR") && !ifElseTokens.get(0).equals("STOP")))
 			   {
 			      if(ifElseTokens.get(0).equals("CHECK"))
 			      {
 			    	 while((!(ifElseTokens=Runtime.getTokens(Runtime.scanner.nextLine())).get(0).equals("STOP") ))
 			    	 {}
 			      }
 			   }
 			   Runtime.stack.push("STOP");
 			   Parser.ProcessTokens(Runtime.getTokens(Runtime.scanner.nextLine()));
 		}
	}
	public static boolean ProcessTokensComparisonTokens(List<String> tokens) 
	{
		
		
		boolean check = false;
		int val1=0 , val2;
		
		switch (tokens.get(0)) {
		
		case "LT" : 	
			
		val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
		val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));

		
		 if(val1<val2)
			 check = true;
		 
		break;
		
		case "EQ" : 		 val1= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		 val2= Runtime.table.containsKey(tokens.get(3))? Runtime.table.get(tokens.get(3)): Integer.parseInt(tokens.get(3));
		
		
		 if(val1<val2)
			 check = true;
		 
		break;
		
		
		default:
			break;
			
		
		}
		
		return check;
	}
}
