package parser
import ast.Exp
import ast.Exp.IfZ
import ast.Op
import lexer.Lexer.nextToken
import lexer.{Lexer, Token}
import lexer.Token.*

object Parser:
  def parse(token: Token): Exp =
    token match
      case NUMBER(n) => Exp.Number(n)
      case LPAR => parseComposite(LPAR)
      case _ => throw new Exception(s"Unexpected token: $token")

  private def parseComposite(token: Token): Exp =
    token match {
      case NUMBER(n) => Exp.Number(n)

      case LPAR =>
        nextToken() match {
          case PLUS => binary(Op.Plus)
          case MINUS => binary(Op.Minus)
          case MULTIPLY => binary(Op.Multiply)
          case DIVIDE => binary(Op.Divide)

          case IFZ =>
            val t = parseComposite(nextToken())
            val e1 = parseComposite(nextToken())
            val e2 = parseComposite(nextToken())
            expect(RPAR)
            ast.Exp.IfZ(t, e1, e2)
          case _ =>
            throw new Exception(s"Unexpected token: $token")
        }
      case _ => throw new Exception(s"Unexpected token: $token")
    }

  private def binary(op: Op): Exp =
    val e1 = parseComposite(Lexer.nextToken())
    val e2 = parseComposite(Lexer.nextToken())
    expect(RPAR)
    Exp.BinaryExpression(op, e1, e2)

  private def expect(expected: Token): Unit =
    val actual = Lexer.nextToken()
    if actual != expected then
      throw new Exception(s"Expected $expected, got $actual")