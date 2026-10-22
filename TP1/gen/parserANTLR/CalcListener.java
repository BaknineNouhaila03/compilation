// Generated from C:/Users/A D M I N/Downloads/TP1 (2)/TP1/src/parserANTLR/Calc.g4 by ANTLR 4.13.2
package parserANTLR;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CalcParser}.
 */
public interface CalcListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CalcParser#exp}.
	 * @param ctx the parse tree
	 */
	void enterExp(CalcParser.ExpContext ctx);
	/**
	 * Exit a parse tree produced by {@link CalcParser#exp}.
	 * @param ctx the parse tree
	 */
	void exitExp(CalcParser.ExpContext ctx);
}