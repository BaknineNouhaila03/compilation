package pfc

import pfc.PCFBaseVisitor
import pfc.PCFParser
import ast.*
import Exp.*
import scala.jdk.CollectionConverters.*


class ASTVisitor extends PCFBaseVisitor[Exp]:
  override def visitNumber(ctx: PCFParser.NumberContext): Exp =
    Number(ctx.getText.toInt)

  override def visitVar(ctx: PCFParser.VarContext): Exp =
    Var(ctx.getText)

  override def visitPar(ctx: PCFParser.ParContext): Exp =
    visit(ctx.term)

  override def visitBOp(ctx: PCFParser.BOpContext): Exp =
    val op = Op.parse(ctx.op.getText)
    val List(l, r) = ctx.term.asScala.toList.map(visit)
    BinaryExpression(op, l, r)

  override def visitIfZ(ctx: PCFParser.IfZContext): Exp =
    val List(t, a, b) = ctx.term.asScala.toList.map(visit)
    IfZ(t, a, b)

  override def visitLet(ctx: PCFParser.LetContext): Exp =
    val List(v, body) = ctx.term.asScala.toList.map(visit)
    Let(ctx.VAR.getText, v, body)