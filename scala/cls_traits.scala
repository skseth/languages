object traittest {

	trait SimpleTrait {
		def traitFunc(x:Int) : Int
	}

	class SimpleClass extends SimpleTrait {
		def traitFunc(x:Int) : Int = x*2		
	}

	def main(args:Array[String]) {
		println((new SimpleClass().traitFunc(2)))
	}
}