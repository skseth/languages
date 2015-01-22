// http://www.artima.com/pins1ed/implicit-conversions-and-parameters.html
// 21.6 View bounds - Note that when you use implicit on a parameter, 
// then not only will the compiler try to supply that parameter with an implicit value, 
// but the compiler will also use that parameter as an available implicit in the body of the method! 
// Thus, both uses of orderer within the body of the method can be left out.


def maxListImpParm[T](elements: List[T])
          (implicit orderer: T => Ordered[T]): T =  
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxListImpParm(rest)(orderer)
          if (orderer(x) > maxRest) x
          else maxRest
      }

def maxListImpParmConv[T](elements: List[T])
          (implicit orderer: T => Ordered[T]): T =
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxListImpParmConv(rest)  // (orderer) is implicit
          if (x > maxRest) x           // orderer(x) is implicitly used
          else maxRest
      }

// syntactic sugar for maxListImpParam2
def maxListVB[T <% Ordered[T]](elements: List[T]) : T =
      elements match {
        case List() => 
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxListVB(rest)  // (orderer) is implicit
          if (x > maxRest) x           // orderer(x) is implicitly used
          else maxRest
      }

// T is an Ordered[T] - no conversion needed.
// this method will work with fewer types - the ones which explicitly extend or implement Ordered[T]
def maxListUpBound[T <: Ordered[T]](elements: List[T]): T = 
      elements match {
        case List() =>
          throw new IllegalArgumentException("empty list!")
        case List(x) => x
        case x :: rest =>
          val maxRest = maxListUpBound(rest)
          if (x > maxRest) x
          else maxRest
      }

case class MyInt(i:Int) extends Ordered[MyInt] {
  def compare(that: MyInt) = {
  	this.i - that.i
  }
}

println(maxListImpParm(List(1,5,10,3)))
println(maxListImpParmConv(List(1,5,10,3)))
println(maxListVB(List(1,5,10,3)))
println(maxListUpBound(List(MyInt(1),MyInt(5),MyInt(10),MyInt(3))))
