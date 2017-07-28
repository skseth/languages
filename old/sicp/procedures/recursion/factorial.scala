
object factorial {
	def lazyfactorial(n:Int):Int = if (n <= 1) { 1 } else {mul(n, lazyfactorial(n - 1))}

	def mul(a:Int, b: => Int):Int = {
		lazy val t = {
			val bval = b
			val retval = a * bval
			print(s"($a * $bval)")
			retval
		}
		t
	}

	def lazyttest():Int = {
		lazy val t = {
			println("evaluating ..")
			5
		}
		println("returning t")
		t
	}

	def main(args:Array[String]) {
		println(lazyfactorial(5))
	}
}