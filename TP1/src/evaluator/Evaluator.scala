package evaluator

import ast.*
import ast.Exp.*
import Value.*

class InterpretationException(msg: String) extends Exception(msg)

object Evaluator :
  given int2Val: Conversion[Int, Value] = n => IntVal(n)

  given val2Int: Conversion[Value, Int] = {
    case IntVal(n) => n
    case _ => throw InterpretationException("Integer expected, got a function")

  }
  
  def eval(exp: Exp, env: Env = Map()): Value = exp match
    case Number(value) => value
    case Var(x) =>
      env.getOrElse(x, throw InterpretationException(s"Unbound variable: $x")) match
        case v: Value => v
        case IceCube(y, t, e) => eval(t, e + (y -> IceCube(y, t, e)))
    case BinaryExpression(op, e1, e2) =>
      val a = eval(e1, env)
      val b = eval(e2, env)
      op match
        case Op.Plus => a + b
        case Op.Minus => a - b
        case Op.Multiply => a * b
        case Op.Divide =>
          if b == IntVal(0) then throw new InterpretationException("Division by zero") else a / b
    case IfZ(t, a, b) => if eval(t, env) == IntVal(0) then eval(a, env) else eval(b, env)
    case Let(x, v, body) => eval(body, env + (x -> eval(v, env)))
    case Fun(x, body) =>
      Closure(x, body, env)

    case App(f, a) =>
      val arg = eval(a, env) 
      eval(f, env) match
        case Closure(p, body, cenv) => eval(body, cenv + (p -> arg))
        case _ => throw InterpretationException("Not a function")

    case Fix(x, t) =>
      eval(t, env + (x -> IceCube(x, t, env)))