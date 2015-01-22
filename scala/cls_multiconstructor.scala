object classtest {

	class Person(name:String, address:String) {
		def hi() = println(s"Hello ${name} - i live at ${address}")

		// necessary to call main contructor as first call.
		def this(name: String) = {
			this(name, "")
		}

		println("this will be executed")
	}

	def main(args:Array[String]) {

		val p = new Person("Samir", "BLR")

		val q = new Person("Samir")

		p.hi()

		q.hi()

	}
}
