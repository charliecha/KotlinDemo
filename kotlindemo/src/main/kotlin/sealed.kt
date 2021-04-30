fun main() {
    val sum = Sum(Const(1.0), Const(2.0))
    println(eval(sum))
}

sealed class Exp

data class Const(val number: Double) : Exp()

data class Sum(val e1: Const, val e2: Const) : Exp()

object NotANumber : Exp()

fun eval(exp: Exp): Double = when (exp) {
    is Const -> exp.number
    is Sum -> eval(exp.e1) + eval(exp.e2)
    NotANumber -> Double.NaN
}

