// from : http://debasishg.blogspot.in/2010/06/scala-implicits-type-classes-here-i.html

import scala.reflect.runtime.{universe => ru}

def getTypeTag[T: ru.TypeTag](obj: T) = ru.typeTag[T]

case class Address(no: Int, street: String, city: String, 
  state: String, zip: String)


case class IndiaAddress(no: Int, street: String, city: String, district: String,
  state: String, pin: String)


// we want Address to work as LabelMaker
trait LabelMaking[T] {
  def toLabel(): String
}


object LabelMaker {
    implicit class AddressWithLabel(address: Address) extends LabelMaker {
      def toLabel(): String = {
        import address._
        "%d %s, %s, %s - %s".format(no, street, city, state, zip)
      }
    }

    implicit class IndiaAddressWithLabel(address: IndiaAddress) extends LabelMaker {
      def toLabel(): String = {
        import address._
        "%d %s, %s, %s, %s - %s".format(no, street, city, district, state, pin)
      }
    }

}

import LabelMaker._

def printLabel(l: LabelMaker):Unit = {
	println(l.toLabel())
} 

// implicit conversion happening here
val addresses = List[LabelMaker](
	Address(100, "Monroe Street", "Denver", "CO", "80231"),
	IndiaAddress(100, "1st Mn, 8th Cr", "Bangalore", "Bangalore", "KA", "560034")
)

addresses map {a => printLabel(a)}

//Main$$anon$1$LabelMaker$AddressWithLabel
//Main$$anon$1$LabelMaker$IndiaAddressWithLabel
addresses map {a => println(a.getClass())}
