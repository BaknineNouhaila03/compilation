package parserANTLR

import java.io.InputStream
import ast.Exp

object AbstractParser :
  def analyze(in: InputStream): Exp =
    val concreteTree = ConcreteParser.analyze(in)
    val visitor = new ASTVisitor
    visitor.visit(concreteTree).asInstanceOf[Exp]
 
