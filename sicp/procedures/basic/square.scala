
object sqrttest {

	import scala.math._
	import scala.annotation._
	def sqrt(x:Double) = {
		var guess:Double = 1

		def good_enough = abs(square(guess) - x) < 0.001
		def improve = guess = average(guess, x / guess)
		def average(x:Double, y:Double) = (x + y) / 2
		def square(x:Double) = x * x

		@tailrec
		def sqrt_iter():Double = 
			if (good_enough) guess else { improve ; sqrt_iter}

		sqrt_iter	
	}

	def main(args:Array[String]) {
		println(sqrt(10))
	}
}
