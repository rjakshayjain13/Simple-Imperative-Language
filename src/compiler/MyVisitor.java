package compiler;



import compiler.SILBaseVisitor;
import compiler.SILParser.AssignmentContext;
import compiler.SILParser.CompexprContext;
import compiler.SILParser.ExprContext;
import compiler.SILParser.IfstatementContext;
import compiler.SILParser.PrintContext;
import compiler.SILParser.ProgramContext;
import compiler.SILParser.StatementContext;
import compiler.SILParser.SubexprContext;
import compiler.SILParser.ValueContext;
import compiler.SILParser.WhilestatementContext;

public class MyVisitor extends SILBaseVisitor<String> {
	StringBuilder sb = new StringBuilder();
	
	
	Count count= new Count();
	
 
	
	@Override
	public String visitExpr(ExprContext ctx) {
			// This method is to generate intermediate code for mathematical operators
				
			if(ctx.getChildCount()==1)
			{
				return visitSubexpr(ctx.subexpr());
			}
			else
				
			{
				String result = "";
				
					result = "temp"+ count.count++;
				if(ctx.getChild(1).getText().equals("+"))
				{
					sb.append("ADD "+visit(ctx.children.get(0))+" "+visitSubexpr(ctx.subexpr())+" "+result+"\n");
					return result;
				}
				else
				{
					sb.append("SUB "+visit(ctx.children.get(0))+" "+visitSubexpr(ctx.subexpr())+" "+ result+"\n");
					return result;
				}
			}
	

		
	}


	@Override
	public String visitValue(ValueContext ctx) {
		// TODO Auto-generated method stub
	 
		
	    return ctx.getChild(0).getText();
		
		
	}
	@Override
	public String visitSubexpr(SubexprContext ctx) {
		// TODO Auto-generated method stub
		
		if(ctx.getChildCount()==1)
		{
			return visitValue(ctx.value())	;	}
		else
		{
			String result = "";
			result = "temp"+count.count++;
			if(ctx.getChild(1).getText().equals("*"))
			{
			
			
			sb.append("MUL "+visit(ctx.children.get(0))+" "+visitValue(ctx.value())+" "+ result+"\n");
			return result;
			}
			else
			{
				sb.append("DIV "+visit(ctx.children.get(0))+ " "+visitValue(ctx.value())+" "+result+"\n");
				return 	result;
			}
		}
	
	}
	@Override
	protected String aggregateResult(String aggregate, String nextResult) {
		// TODO Auto-generated method stub
		if(aggregate==null)
			return nextResult;
		if(nextResult==null)
			return aggregate;
		
		return aggregate+ "\n"+ nextResult;
	}
	
	public String toString()
	{
		return sb.toString();
	}
	
	
	@Override
	public String visitAssignment(AssignmentContext ctx) {
		// TODO Auto-generated method stub
		// This method is to generate intermediate code for variable initialization
			
			
			
		return "LOAD "+ ctx.getChild(0)+" "+ visitExpr(ctx.expr());
		
			
		
	}
	//@Override
	public String visitStatement(StatementContext ctx) {
		// TODO Auto-generated method stub
	
		sb.append(visit(ctx.getChild(0))+"\n");
		return "";
	}
	
	@Override
	public String visitPrint(PrintContext ctx) {
		// TODO Auto-generated method stub
		
		// This method is to generate intermediate code for print statement
		
		return "DISP "+ visitExpr(ctx.expr()) ;
	}
	@Override
	public String visitCompexpr(CompexprContext ctx) {
		// TODO Auto-generated method stub
		// This method is to generate intermediate code for Comparison Operators 
		
		if(ctx.getChildCount()==3)
		{
			
			
			if(ctx.getChild(1).getText().equals("=="))
			{
				return "EQL "+visit(ctx.getChild(0)) +" "+visit(ctx.getChild(2));
			}
			else if(ctx.getChild(1).getText().equals(">="))
			{
				return "GTE "+visit(ctx.getChild(0)) +" "+visit(ctx.getChild(2));
			}
			else if(ctx.getChild(1).getText().equals("<="))
			{
				return "LTE "+visit(ctx.getChild(0)) +" "+visit(ctx.getChild(2));
			}
			else if(ctx.getChild(1).getText().equals("<"))
			{
				return "LT "+visit(ctx.getChild(0)) +" "+visit(ctx.getChild(2));
			}
			else if(ctx.getChild(1).getText().equals(">"))
			{
				return "GT "+visit(ctx.getChild(0)) +" "+visit(ctx.getChild(2));
			}
			else if(ctx.getChild(1).getText().equals("~="))
			{
				return "NE "+visit(ctx.getChild(0)) +" "+visit(ctx.getChild(2));
			}
		}
		else if(ctx.getChildCount()==1)
		{
		
			return ctx.getChild(0).getText();
		}
		return "";
	
		
		
		
	}
	
	@Override
	public String visitIfstatement(IfstatementContext ctx) {
		// TODO Auto-generated method stub
		
		// This method is to generate intermediate code for if then else branching 
		
		for(int i =0; i< ctx.getChildCount(); i++)
		{
		
		if(ctx.getChild(i).getText().equals("if"))	
		  sb.append("CHECK \n");
		else if (ctx.getChild(i).getText().equals("else"))
		  sb.append("OR \n");
		else if (ctx.getChild(i).getText().equals("stop"))
			  sb.append("STOP");
		else if(!ctx.getChild(i).getText().equals(":"))
		{
			String str =visit(ctx.getChild(i));
			if(str.length()>0)
				sb.append(str+"\n");
		}
		}
		
		return "";
	}
	@Override
	public String visitProgram(ProgramContext ctx) {
		// TODO Auto-generated method stub
		for(int i=0; i< ctx.getChildCount();i++)
		    visit(ctx.getChild(i));
		return sb.toString();
	}
	
	@Override
	public String visitWhilestatement(WhilestatementContext ctx) {
		// TODO Auto-generated method stub
		
		//This method is to generate intermediate code for while loop
		
		for(int i =0; i< ctx.getChildCount(); i++)
		{
		
			if(ctx.getChild(i).getText().equals("while"))	
				sb.append("LOOP \n");
			else if (ctx.getChild(i).getText().equals("end"))
			  sb.append("LOOPEND ");
			else if(!ctx.getChild(i).getText().equals(":"))
			{
				String str =visit(ctx.getChild(i));
				if(str.length()>0)
					sb.append(str+"\n");
			}
		}
		
		
		return "";
	}
}
class Count
{
	int count;
	Count()
	{
		this.count=0;
	}
}