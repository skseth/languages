
object app {
	object myobj {
		// a class 
		class MyClass private(val path : String) {
			def printPath = println(path)
		}

		// companion object of the a class 
		object MyClass {
		   def normalizePath(path:String) = "normalized: " + path
		   def apply(path : String) = new MyClass(normalizePath(path))
		}
	}

	import myobj._
	def main(args:Array[String]) = {
		val x = MyClass("/foo/bar")
		x.printPath
	}
}

