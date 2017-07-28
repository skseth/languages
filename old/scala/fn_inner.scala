// http://stackoverflow.com/questions/1159550/is-there-an-efficiency-penalty-when-using-scala-inner-functions-within-non-tail

object fninner {

	def sumDoubles(n: Int): Int = {
	  def dbl(a: Int) = 2 * a;
	  if(n > 0)
	    dbl(n) + sumDoubles(n - 1)
	  else
	    0               
	}

	// immutable var
	def foo(n: Int): Int = {
	  def dbl(a: Int) = a * n;
	    if(n > 0)
	      dbl(n) + foo(n - 1)
	    else
	      0               
	}

	// mutable var - boxing needed
	def bar(_n : Int) : Int = {
	   var n = _n
	   def subtract() = n = n - 1

	   if (n > 0) {
	      subtract
	      n
	   }
	   else
	      0
	}

	// first class function
	def sumWithFunction(n : Int, f : Int => Int) : Int = {
	  if(n > 0)
	    f(n) + sumWithFunction(n - 1, f)
	  else
	    0               
	}  

	def sumDoubles2(n: Int) : Int = {
	  def dbl(a: Int) = 2 * a
	  sumWithFunction(n, dbl)
	}


	def main(args:Array[String]) {
		println(sumDoubles(2))
		println(foo(2))
		println(bar(2))
		println(sumDoubles2(2))
	}

}