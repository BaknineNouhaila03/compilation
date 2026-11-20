package typer

import unify.{Atom, HTerm, Structure, TVar}

type Type = HTerm

object INT extends Atom("INT"):
  override def toString = "INT"

class FUNCTION(a: Type, b: Type) extends Structure("function", List(a, b)):
  override def toString = s"($a -> $b)"