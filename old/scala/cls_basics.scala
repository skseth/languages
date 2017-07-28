object classtest {

	/*
		desugared to :

		class packagename$Person extends Object {
			private[this] val name : String = _;
			private[this] val address : String = _;

			def <init>(...):packagename$Person = {
				... initialize vas
				super.<init>();
				body statements...
			}

		}

	*/
	class Person(name:String, address:String) {
		def hi() = println(s"Hello ${name} - i live at ${address}")

		println("this will be execute")
		//def changename(newname:String) = name = newname

	}

	def main(args:Array[String]) {

		val p = new Person("Samir", "BLR")

		val q = new Person("Samir", "BLR")

		p.hi()
		println(p.hashCode())

		println(p.equals(q))
		println(q.hashCode())

		//p.changename("Sam2")

		// hashcode stays same
		println(p.hashCode())
	}
}
