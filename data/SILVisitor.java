// Generated from SIL.g4 by ANTLR 4.7
package compiler;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link SILParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface SILVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link SILParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(SILParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(SILParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(SILParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(SILParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#subexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSubexpr(SILParser.SubexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#value}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValue(SILParser.ValueContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#ifstatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfstatement(SILParser.IfstatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#compexpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompexpr(SILParser.CompexprContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#whilestatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhilestatement(SILParser.WhilestatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link SILParser#print}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrint(SILParser.PrintContext ctx);
}