package evaluator

import ast.Exp

type Env = Map[String, Value | IceCube]

enum Value:
  case IntVal(value: Int)
  case Closure(param: String, body: Exp, env: Env)

case class IceCube(name: String, body: Exp, env: Env)