// http://stackoverflow.com/questions/4344172/pattern-for-a-class-that-is-a-list-of-itself

object Main
{
	// a class that is a list of itself!
	case class Foo(bar: Int) extends FooList {
		val self: List[Foo] = this :: Nil
	}

	abstract class FooList { 
	  // refers to outer scope, in this case it will be Foo 
	  outer =>
	  val self: List[Foo]

	  def ~(that: Foo) = { 
	  	new FooList { val self = outer.self :+ that } 
	  }
	}

	def main(args: Array[String]): Unit = {
		val foo = Foo(1) ~ Foo(2) ~ Foo(3)
		println(foo.self)
		println(foo.self(1).self)
	}
}

