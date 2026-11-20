package pcf

import evaluator.Evaluator.eval
import parser.AbstractParser.analyze
import typer.Typer
import java.io.{FileInputStream, InputStream}

object pcf:
  def main(args: Array[String]): Unit =
    val in: InputStream =
      if args.isEmpty then
        System.in
      else
        FileInputStream(args(0))
    val exp = analyze(in)
    val typ = Typer.eval(exp, Map())
    println(s"==> ${eval(exp)}: $typ")


