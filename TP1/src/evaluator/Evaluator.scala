package evaluator

import ast.{Exp, Op}
import Exp.*

object Evaluator :
  def eval(exp: Exp, env: Map[String, Int] = Map()): Int = exp match
    case Number(value) => value
    case Var(x) => env.getOrElse(x, throw new Exception(s"Unbound variable: $x"))
    case BinaryExpression(op, e1, e2) =>
      val a = eval(e1, env)
      val b = eval(e2, env)
      op match
        case Op.Plus => a + b
        case Op.Minus => a - b
        case Op.Multiply => a * b
        case Op.Divide =>
          if b == 0 then throw new Exception("Division by zero") else a / b
    case IfZ(t, a, b) => if eval(t, env) == 0 then eval(a, env) else eval(b, env)
    case Let(x, v, body) => eval(body, env + (x -> eval(v, env)))