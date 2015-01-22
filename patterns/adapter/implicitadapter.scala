// from : http://debasishg.blogspot.in/2010/06/scala-implicits-type-classes-here-i.html

// Comment by Tom above : A crucial distinction between type classes and interfaces is that for class A to be a 
// "member" of an interface it must declare so at the site of its own definition. 
// By contrast, any type can be added to a type class at any time, provided you can provide the required definitions, 
// and so the members of a type class at any given time are dependent on the current scope.

// Address class
case class Address(no: Int, street: String, city: String, 
  state: String, zip: String)


// we want Address to work as LabelMaker
trait LabelMaker[T] {
  def toLabel(value: T): String
}

object LabelMaker {
	implicit object AddressLabelMaker extends LabelMaker[Address] {
	  def toLabel(address: Address) = {
	    import address._
	    "%d %s, %s, %s - %s".format(no, street, city, state, zip)
	  }
	}	
}

object SpecialLabelMaker {
  implicit object AddressLabelMaker extends LabelMaker[Address] {
    def toLabel(address: Address): String = {
      import address._
      "[%d %s, %s, %s - %s]".format(no, street, city, state, zip)
    }
  }
}

// Scala 2.8 context bound syntax
def printLabel[T: LabelMaker](t: T) = implicitly[LabelMaker[T]].toLabel(t)
// old syntax - def printLabel[T](t: T)(implicit lm: LabelMaker[T]) = lm.toLabel(t)

println(printLabel(Address(100, "Monroe Street", "Denver", "CO", "80231")))

import SpecialLabelMaker._

println(printLabel(Address(100, "Monroe Street", "Denver", "CO", "80231")))

println(Address(100, "Monroe Street", "Denver", "CO", "80231"))
