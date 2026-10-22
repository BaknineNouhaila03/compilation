package lexer

enum Token:
  case NUMBER(value: Int)
  case LPAR
  case RPAR
  case IFZ
  case PLUS
  case MINUS
  case MULTIPLY
  case DIVIDE
  case EOF
