// from http://www.azavea.com/blogs/labs/2011/06/scalas-numeric-type-class-pt-1/

case class Alcohol(liters:Double)
case class Water(liters:Double)
 
case class Fire(heat:Double)
trait Flammable[A] {
  def burn(fuel:A): Fire
}
 
implicit object AlcoholIsFlammable extends Flammable[Alcohol] {
  def burn(fuel:Alcohol) = Fire(120.0)
}
 
def setFire[T](fuel:T)(implicit f:Flammable[T]) = f.burn(fuel)
 
println(setFire(Alcohol(1.0))) // ok
//setFire(Water(1.0)) // FAIL


{

	trait NumWithDigits[T] {
	  def fromInt(v:Int):T
	  def length(v:T):Int
	  def add(v1:T,v2:T):T
	  def mul(v1:T,v2:T):T
	  def splitAt(v:T, digit:Int):(T,T)
	}

	implicit object StringIsNumWithDigits extends NumWithDigits[String] {
	  def fromInt(v:Int) = v.toString
	  def length(v:String) = v.length
	  def add(v1:String,v2:String) = { (v1.toInt + v2.toInt).toString}
	  def mul(v1:String,v2:String) = { (v1.toInt * v2.toInt).toString}
	  def splitAt(v:String,digit:Int) = v splitAt digit
	}

 
	implicit object IntIsNumWithDigits extends NumWithDigits[Int] {
	  def fromInt(v:Int) = v
	  def length(v:Int) = {
	  	var n = if (v < 0) -v else v
	  	var len = 0
	  	while (n > 0) { n = n/10; len = len + 1 }
	  	len
	  }

	  def add(v1:Int, v2:Int) = v1 + v2
	  def mul(v1:Int, v2:Int) = v1*v2
	  def splitAt(v:Int, digit:Int) = {
	  	val (l,r) = v.toString splitAt digit
	  	(l.toInt, r.toInt)
	  }
	}

	def printLength[T](v:T)(implicit l:NumWithDigits[T]) = println(l.length(v))
	def addAndPrintLength[T](v:T)(implicit l:NumWithDigits[T]) = {
		val newv = l.add(v, l.fromInt(5))
		println(newv, l.length(newv))
	}
 
	addAndPrintLength("434")
	addAndPrintLength(434)
}


