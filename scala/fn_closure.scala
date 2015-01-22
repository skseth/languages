
object app {

	def main(args:Array[String]) = {
		val l = List(1,2,3)
		var i = 0
		l.foreach{a => println(i + ": " + a); i = i + 1; }
		println("There are " + i + " elements in the list")
	}
}

