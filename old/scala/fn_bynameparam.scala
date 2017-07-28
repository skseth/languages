// see http://locrianmode.blogspot.in/2011/07/scala-by-name-parameter.html

object bynametest {
	def nano() = {
	    println("Getting nano")
	    System.nanoTime
	}
	 
	def delayed(t: => Long) = { // => indicates a by-name parameter
	    println("\n-----\nIn delayed method")
	    println("Param: "+t) // t called here
	    t 					 // .. and here!
	}

	def delayedOnce(t: => Long) = { // => indicates a by-name parameter
		lazy val tonce = t  // t is not evaluated here
	    println("\n------\nIn delayedOnce method")
	    println("Param: "+tonce) // ... but here!
	    tonce 					 // .. now just the local val is used
	}

	def main(args:Array[String]) {
		println(delayed(nano()))
		println(delayedOnce(nano()))
		println(delayed(4))
	}
}