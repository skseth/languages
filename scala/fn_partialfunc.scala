// http://www.scala-lang.org/api/current/index.html#scala.PartialFunction

{
	val sample = 1 to 10
	val isEven: PartialFunction[Int, String] = {
	  case x if x % 2 == 0 => x+" is even"
	}

	// the method collect can use isDefinedAt to select which members to collect
	val evenNumbers = sample collect isEven

	println(evenNumbers)

	val isOdd: PartialFunction[Int, String] = {
	  case x if x % 2 == 1 => x+" is odd"
	}

	// the method orElse allows chaining another partial function to handle
	// input outside the declared domain
	val numbers = sample map (isEven orElse isOdd)

	println(evenNumbers)
}

{
	//https://twitter.github.io/scala_school/pattern-matching-and-functional-composition.html

	val two: PartialFunction[Int, String] = { case 2 => "two" }
	val three: PartialFunction[Int, String] = { case 3 => "three" }
	val wildcard: PartialFunction[Int, String] = { case _ => "more" }

	val partial = two orElse three orElse wildcard

	println(partial(2))
	println(partial(3))
	println(partial(7))



}