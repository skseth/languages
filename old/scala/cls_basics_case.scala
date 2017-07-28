
package casetest
// outof the box methods for case classes
// creates case class Foo extends AnyRef with Product with Serializable ...
// generate code with scalac -print <filename> and see generated file

object CaseTest {
	case class Foo(a: String, b: Int);

	def main(args:Array[String]) {
		val f = new Foo("a", 20)
		println(f.productPrefix)
		println(f.productArity)
		println(f.productElement(0))
		println(f.productElement(1))
	}
}




