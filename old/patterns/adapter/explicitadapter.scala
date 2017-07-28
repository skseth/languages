// from : http://debasishg.blogspot.in/2010/06/scala-implicits-type-classes-here-i.html

// address class
case class Address(no: Int, street: String, city: String, 
  state: String, zip: String)

// And we want to adapt this to the interface of a LabelMaker .. i.e. we would want to use Address as a LabelMaker ..
trait LabelMaker[T] {
  def toLabel(value: T): String
}

// the adapter that does the interface transformation ..
// adapter class
case class AddressLabelMaker() extends LabelMaker[Address] {
  def toLabel(address: Address) = {
    import address._
    "%d %s, %s, %s - %s".format(no, street, city, state, zip)
  }
}

// the adapter provides the interface of the LabelMaker on an Address
println(AddressLabelMaker().toLabel(Address(100, "Monroe Street", "Denver", "CO", "80231")))