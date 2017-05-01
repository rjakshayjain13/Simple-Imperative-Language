package compiler;



import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.antlr.v4.gui.TreeViewer;
import org.antlr.v4.runtime.ANTLRErrorStrategy;
import org.antlr.v4.runtime.ANTLRFileStream;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.w3c.dom.traversal.TreeWalker;


@SuppressWarnings("deprecation")
public class Compiler {
	
	public static void main(String[] args){
		// TODO Auto-generated method stub
	
		String inputFilePath = "";
		if(args.length==0)
		{
		System.out.println("Please Enter Path of source file");
		System.exit(0);
		}
		else
		{
			inputFilePath = args[0];
		}
		
		
		try{
			ANTLRFileStream input = new ANTLRFileStream(inputFilePath);
			
			SILLexer lexer = new SILLexer(input);

			CommonTokenStream tokens = new CommonTokenStream(lexer);
			
			SILParser parser = new SILParser(tokens);
			
			
			
			ParseTree tree = parser.program();
		
			MyVisitor my=new MyVisitor();
			
		    String intermediate= my.visit(tree);
		    
		    String inputFile[] = args[0].split("\\.");
		    // This is to write our intermediate code to file
		    PrintWriter intermediateCodeWriter = new PrintWriter(inputFile[0]+".silc");
			
			intermediateCodeWriter.println(intermediate);
			
			intermediateCodeWriter.close();
			System.out.println(intermediate);
			
			// This is to visualize the parse tree
			
			JFrame frame = new JFrame("Antlr AST");
	        JPanel panel = new JPanel();
	        TreeViewer viewr = new TreeViewer(Arrays.asList(parser.getRuleNames()),tree);
	        viewr.setScale(1.5);
	        panel.add(viewr);
	        frame.add(panel);
	        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame.setSize(100,100);
	        frame.setVisible(true);
	        JScrollPane jsp = new JScrollPane(panel);
	        frame.add(jsp);        
	  
			
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
			
	}

}
