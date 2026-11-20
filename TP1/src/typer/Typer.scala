package typer

import ast.*
import ast.Exp.*
import unify.TVar

object Typer {
  type Env = Map[String, Type]
  private def unify(a: Type, b: Type, term: Exp): Unit =
    if !(a === b) then throw TypeError(s"Cannot unify $a and $b in $term")

  def eval(term: Exp, e: Env): Type = term match
    case Number(_) => INT

    case Var(x) =>
      e.getOrElse(x, throw TypeError(s"Unbound variable: $x"))

    case BinaryExpression(_, t1, t2) =>
      unify(eval(t1, e), INT, term)
      unify(eval(t2, e), INT, term)
      INT

    case IfZ(t1, t2, t3) =>
      unify(eval(t1, e), INT, term)
      val B = eval(t2, e)
      unify(B, eval(t3, e), term)
      B

    case Let(x, v, body) =>
      eval(body, e + (x -> eval(v, e)))

    case Fun(x, body) =>
      val a = TVar()
      FUNCTION(a, eval(body, e + (x -> a)))

    case App(f, arg) =>
      val r = TVar()
      unify(eval(f, e), FUNCTION(eval(arg, e), r), term)
      r

    case Fix(x, body) =>
      val a = TVar()
      val tb = eval(body, e + (x -> a))
      unify(a, tb, term)
      tb

}
