package ast

enum Exp:
  case Number(value: Int)
  case App(function: Exp, arg: Exp)
  case BinaryExpression(op: Op, exp1: Exp, exp2: Exp)
  case Fun(param: String, body: Exp)
  case IfZ(test: Exp, exp1: Exp, exp2: Exp)
  case Var(name: String)
  case Let(name: String, value: Exp, body: Exp)

  
enum Op:
  case Plus, Minus, Multiply, Divide

enum Value :
  case intVal(value: Int)
  case closure (param: String, t: Exp, env: Map[String, Value])

object Op:
  def parse(op: String): Op = op match { 
    case "+" => Plus
    case "-" => Minus
    case "*" => Multiply
    case "/" => Divide
    case other => throw new IllegalArgumentException(s"Unknown operator: $other")
  }

