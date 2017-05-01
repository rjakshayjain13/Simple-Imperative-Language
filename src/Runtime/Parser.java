package runtime;
import java.util.ArrayList;
import java.util.List;

import org.omg.SendingContext.RunTime;


public class Parser {
	static int  count = 0;
	public static void ProcessTokens(List<String> tokens) {
		
		
	    if("ADDSUBMULDIV".contains(tokens.get(0)))
	    {
	    	processMathematicalOperation(tokens);
	    }
	    else if("LOADDISP".contains(tokens.get(0)))
	    {
	        processLOADDISP(tokens);	
	    }
	    else
	    {
		switch (tokens.get(0)) {
	
		case "CHECK" :
			
			// This block handles if then else and nested if else branching
			
			 	List<String> tok=Runtime.getTokens(Runtime.scanner.nextLine()); 
			 	
			 	if(tok.size()==1)
			 	{
			 	   if(tok.get(0).equalsIgnoreCase("TRUE"))
			 	   {
			 		   Runtime.stack.push("OR");
			 		   Parser.ProcessTokens(Runtime.getTokens(Runtime.scanner.nextLine()));
			 	   }
			 	   else if(tok.get(0).equalsIgnoreCase("FALSE"))
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
			 	else if("NEGTLTLTEGTEEQL".contains(tok.get(0)))
			 	{
			 		
			 		handleComparisions(tok);
			 		
			 	}
			 	else
			 	{
			 		List<String> complex=tok;
			 		while(!"NEGTLTLTEGTEEQL".contains(complex.get(0)))
		 			   {
			 				
			 				Parser.ProcessTokens(complex);
			 				complex=Runtime.getTokens(Runtime.scanner.nextLine());
		 			   }
			 		
			 		   handleComparisions(complex);
			 	}
				
			break;
			
		case "OR" : 
			
					if(!Runtime.stack.isEmpty() && Runtime.stack.peek().equals("OR"))
					{
						while(!Runtime.getTokens(Runtime.scanner.nextLine()).get(0).equals("STOP"))
			 			   {
							
			 			   }
					Runtime.stack.pop();
					}
			break;
		case "STOP":
			
			
			
			       if(!Runtime.stack.isEmpty() && (Runtime.stack.peek().equals("STOP") || Runtime.stack.peek().equals("OR")))
			       {
			    	   Runtime.stack.pop();
			       }
			
			break;
			
		case "LOOP" : 
			
			// This block handles loop 
			
			List<String> condition = new ArrayList<String>();
			condition.add(Runtime.scanner.nextLine());
			String str = Runtime.scanner.nextLine();
			List<String> conditionTokens = Runtime.getTokens(condition.get(0));
			if(conditionTokens.size()!=1 && !"NEGTLTLTEGTEEQL".contains(conditionTokens.get(0)))
			{

				while("NEGTLTLTEGTEEQL".contains(Runtime.getTokens(str).get(0)))
				{
					condition.add(str);
					str = Runtime.scanner.nextLine();;
				}
			}
			//System.out.println(condition);
			//System.out.println(str);
			List<String> loopStatement = Runtime.getTokens(str);
			
			loopStatements = new ArrayList<List<String>>();
			loopStatements.add(new ArrayList<String>(loopStatement));
			
			while(!loopStatement.get(0).equals("LOOPEND"))
			{
				
				loopStatement = Runtime.getTokens(Runtime.scanner.nextLine());
				
				loopStatements.add(new ArrayList<String>(loopStatement));
			}
			
			loopStatements.remove(loopStatements.size()-1);
			//System.out.println(loopStatements);
			
			// This loop executes the actual statements within a loop
			while(processComplexExpForWhile(condition))
			{
				for(int i=0; i<loopStatements.size(); i++)
				{
					List<String> loopLine = loopStatements.get(i);
					
					if(loopLine.get(0).equalsIgnoreCase("CHECK"))
					{
							loopLine = loopStatements.get(++i);
						
							while(loopLine.size()!=1 && !"NEGTLTLTEGTEEQL".contains(loopLine.get(0)))
							{
								if("ADDSUBMULDIV".contains(loopLine.get(0)))
					 		    {
					 		    	processMathematicalOperation(loopLine);
					 		    }
					 		    else if("LOADDISP".contains(loopLine.get(0)))
					 		    {
					 		        processLOADDISP(loopLine);	
					 		    }
								loopLine = loopStatements.get(++i);
							}
					
							if((loopLine.size()==1 && loopLine.get(0).equalsIgnoreCase("true"))  || ProcessTokensComparisonTokens(loopLine))
							{
								
						 			Runtime.stack.push("OR");
						 			//loopLine = loopStatements.get(++i);
						 			while(!((loopLine = loopStatements.get(++i)).get(0).equals("OR")) && !loopLine.get(0).equals("STOP"))
						 			{
							 			if("ADDSUBMULDIV".contains(loopLine.get(0)))
							 		    {
							 		    	processMathematicalOperation(loopLine);
							 		    }
							 		    else if("LOADDISP".contains(loopLine.get(0)))
							 		    {
							 		        processLOADDISP(loopLine);	
							 		    }
						 			}
				 			
								 	if(Runtime.stack.peek().equals("OR"))
									{
										while(i<loopStatements.size()-1 && !(loopStatements.get(++i)).get(0).equals("STOP"))
							 			   {}
										Runtime.stack.pop();
									}
				 			
							}
							else
							{
									List<String> ifElseTokens = null;
									while((!(ifElseTokens=loopStatements.get(++i)).get(0).equals("OR") && !ifElseTokens.get(0).equals("STOP")))
									{
					 			      if(ifElseTokens.get(0).equals("CHECK"))
					 			      {
					 			    	 while((!(ifElseTokens=loopStatements.get(++i)).get(0).equals("STOP") ))
					 			    	 {}
					 			      }
									}
				 			 
					 				while(!((loopLine = loopStatements.get(++i)).get(0).equals("STOP")))
						 			{
							 			if("ADDSUBMULDIV".contains(loopLine.get(0)))
							 		    {
							 		    	processMathematicalOperation(loopLine);
							 		    }
							 		    else if("LOADDISP".contains(loopLine.get(0)))
							 		    {
							 		        processLOADDISP(loopLine);	
							 		    }
						 			}
				 			  
							}	
						
					}
					else
					{
						if("ADDSUBMULDIV".contains(loopLine.get(0)))
			 		    {
			 		    	processMathematicalOperation(loopLine);
			 		    }
			 		    else if("LOADDISP".contains(loopLine.get(0)))
			 		    {
			 		        processLOADDISP(loopLine);	
			 		    }
					}
				}
				
			}
			
			break;
	
		default : break;
		
	   }
	  }
	}
	
	//This method handles complex comparison expressions for while loop condition
	
	static boolean processComplexExpForWhile(List<String> tokens)
	{
		if(tokens.size()==1)
		{
			List<String> condTok =Runtime.getTokens(tokens.get(0));
			
			if(condTok.size()==1)
			{
				return condTok.get(0).equalsIgnoreCase("true")?true:false;
			}
			else
			return ProcessTokensComparisonTokens(condTok);
		}
		for(String tok: tokens)
		{
			List<String> toks = Runtime.getTokens(tok);
			if("ADDSUBMULDIV".contains(toks.get(0)))
			{
				processMathematicalOperation(toks);
			}
		}
		
		return ProcessTokensComparisonTokens(Runtime.getTokens(tokens.get(tokens.size()-1)));
	}
	
	//This method handles Load and Print statements
	static void processLOADDISP(List<String> tokens)
	{
		switch(tokens.get(0))
		{
		case "DISP" : 	
			String print = Runtime.table.containsKey(tokens.get(1))? String.valueOf(Runtime.table.get(tokens.get(1))):tokens.get(1);
			System.out.println(print);
			break;
			
		case "LOAD" :
			
			String var = tokens.get(1);
			int val = Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
			Runtime.table.put(var, val);
			break;
		}
	}
	
	// This method handles basic mathematical operations 
	static void processMathematicalOperation(List<String> tokens)
	{
		
	  int val1 , val2;
	  switch (tokens.get(0))
	  {
			
		case "ADD" : 	
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
			Runtime.table.put(tokens.get(3), val1+val2);
			break;
			
		case "SUB" :
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
	
			Runtime.table.put(tokens.get(3), val1-val2);
			break;
			
		case "MUL" : 		
		
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
			Runtime.table.put(tokens.get(3), val1*val2);
			break;
				
		case "DIV" : 		
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
	
			Runtime.table.put(tokens.get(3), val1/val2);
		
		
			break;
		}
	}
	static List<List<String>> loopStatements=null;
	//This method handles comparison statements which are used for while or if
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
	
	//This method handles all < , > <=< >=, ~=,==
	 
	public static boolean ProcessTokensComparisonTokens(List<String> tokens) 
	{
		
		
		boolean check = false;
		int val1=0 , val2;
		
		switch (tokens.get(0))
		{
		
		case "LT" : 	
			
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));

		
			if(val1<val2)
			 check = true;
		 
			break;
		case "GT" : 	
			
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));

		
			if(val1>val2)
			 check = true;
		 
			break;
		case "EQL" :
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
		
			if(val1==val2)
			 check = true;
		 
			break;
		case "NE" :
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
		
			if(val1!=val2)
			 check = true;
		 
			break;
		case "GTE" :
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
		
			if(val1>=val2)
			 check = true;
		 
			break;
		case "LTE" :
			val1= Runtime.table.containsKey(tokens.get(1))? Runtime.table.get(tokens.get(1)): Integer.parseInt(tokens.get(1));
			val2= Runtime.table.containsKey(tokens.get(2))? Runtime.table.get(tokens.get(2)): Integer.parseInt(tokens.get(2));
		
		
			if(val1 <= val2)
			 check = true;
		 
			break;
		
		
		default:
			break;
			
		
		}
		
	return check;
   }
}
