package test

import evaluator.{Evaluator, InterpretationException}
import evaluator.Value.IntVal
import parser.AbstractParser.analyze
import typer.{Typer, TypeError}
import java.io.ByteArrayInputStream

object Tests:
  private var failures = 0

  private def parse(src: String) =
    analyze(ByteArrayInputStream(src.getBytes("UTF-8")))

  private def report(passed: Boolean, src: String, detail: String): Unit =
    if !passed then failures += 1
    println(s"${if passed then "OK  " else "FAIL"} ${src.replace("\n", " ")}  -> $detail")

  // Typage puis évaluation, résultat entier attendu
  private def ok(src: String, expected: Int): Unit =
    try
      val exp = parse(src)
      Typer.eval(exp, Map())
      val v = Evaluator.eval(exp)
      report(v == IntVal(expected), src, s"$v (attendu IntVal($expected))")
    catch case e: Exception => report(false, src, s"exception inattendue : $e")

  // Le typage doit rejeter le programme
  private def typeError(src: String): Unit =
    try
      Typer.eval(parse(src), Map())
      report(false, src, "aurait dû lever TypeError")
    catch
      case e: TypeError => report(true, src, s"TypeError : ${e.getMessage}")
      case e: Exception => report(false, src, s"mauvaise exception : $e")

  // L'évaluateur seul (sans typage) doit lever une InterpretationException
  private def evalError(src: String): Unit =
    try
      Evaluator.eval(parse(src))
      report(false, src, "aurait dû lever InterpretationException")
    catch
      case e: InterpretationException => report(true, src, s"InterpretationException : ${e.getMessage}")
      case e: Exception => report(false, src, s"mauvaise exception : $e")

  private def hasType(src: String, expected: String): Unit =
    try
      val t = Typer.eval(parse(src), Map()).toString
      report(t == expected, src, s"$t (attendu $expected)")
    catch case e: Exception => report(false, src, s"exception inattendue : $e")

  def main(args: Array[String]): Unit =
    println("--- PCF vert (priorités, associativité, ifz) ---")
    ok("1 + 2 * 3", 7)
    ok("(1 + 2) * 3", 9)
    ok("10 - 3 - 2", 5)
    ok("ifz 0 then 1 else 2", 1)
    ok("ifz 4 - 2 then 3 - 2 * 2 else 1", 1)

    println("--- PCF bleu (let, masquage) ---")
    ok("let x = 1 in x + 1", 2)
    ok("let x = 1 in let y = 2 in x + y", 3)
    ok("let x = 1 in let x = 2 in x", 2)
    ok("let x = 1 in let x = x + 1 in x", 2)
    ok("let x = 1 in (let x = 2 in x) + x", 3)
    ok("let cond = ifz 4 - 2 then 3 - 2 * 2 else 1 in 2 / cond", 2)

    println("--- PCF rouge (fonctions, applications) ---")
    ok("(fun x -> x + 1) 1", 2)
    ok("(fun y -> let x = 1 in x + 1) 41", 2)
    ok("(fun x -> fun y -> x + y) 2 41", 43)
    ok("let minus = fun x -> fun y -> x - y in let g = minus 68 in g 2", 66)
    ok("let id = fun x -> x in let inc = fun x -> x + 1 in id (inc 76)", 77)

    println("--- PCF noir (fix) ---")
    ok("fix x 1", 1)
    ok("ifz 0 then 1 else (fix x x)", 1)
    ok("let count = fix f fun n -> ifz n then 0 else f (n - 1) in count 2", 0)
    ok("let fact = fix f fun n -> ifz n then 1 else n * f (n - 1) in fact 3", 6)
    ok("let multiply = fix m fun a -> fun b -> ifz a then 0 else b + m (a - 1) b in multiply 3 4", 12)

    println("--- Types ---")
    hasType("1 + 2", "INT")
    hasType("fun x -> x + 1", "(INT -> INT)")

    println("--- Programmes mal typés : doivent être rejetés par le typage ---")
    typeError("let x = 1 in y")
    typeError("1 2")
    typeError("(fun x -> 0) + 1")
    typeError("ifz 0 then 1 else (fun x -> x)")
    typeError("let id = fun x -> x in ifz (id 0) then id 1 else (id (fun y -> y))")  // le défi

    println("--- Erreurs d'exécution (évaluateur seul) ---")
    evalError("let x = 1 in y")
    evalError("(fun x -> 0) + 1")
    evalError("1 2")
    evalError("1 / 0")

    println(if failures == 0 then "\nTout est OK" else s"\n$failures test(s) en échec")