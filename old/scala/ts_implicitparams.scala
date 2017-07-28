// http://daily-scala.blogspot.in/2010/04/implicit-parameter-resolution.html

// implicit parameter scope is decided by the call site location, and precedence rules.
// FROM the point where call is made check :
// 1. local scope
// 2. enclosing class
// 3. parent class
// 4. companion object

class X(val i:Int)

// companion object of X
object X {
  implicit def xx = new X(1)
}

class Y(val i:Int)

class Method {
  def x(implicit x:X)=println(x.i)
  def y(implicit y:Y)=println(y.i)
}
trait M { 
  self : Method =>
  implicit def x1 = new X(10)
  implicit def y1 = new Y(100)
  def testy = y
  def testx = x
}
trait SM extends M {
  self : Method =>
  implicit def x2 = new X(20)
  implicit def y2 = new Y(200)
  
  def testy2 = y  
}


// implicit resolved from companion object of X
// same as new Method().x(new X(1))
// prints 1
new Method().x

// explicit applied so that value is used
// prints 3
new Method().x(new X(3))

// implicit resolved from companion object of X
// NOT from M.  This is because the call site of x 
// is not within M therefore does not use the implicits in M
// for resolution.
// Still prints 1 from companion object
(new Method with M).x

// now with local override of companion object
// local scope overrides companion object implicit
implicit def x = new X(30)
new Method().x
// explicit applied so that value is used
new Method().x(new X(3))
// local scope overrides companion object implicit
(new Method with M).x
// testy is defined within M so the implicits within M
(new Method with M).testy
// testx is defined within M so the implicit within M
// overrides the companion object implicit
(new Method with M).testx
// testy is within M (not SM) so the implicit within M
// is used
(new Method with SM).testy
// testy2 is within SM so the implicit within SM 
// overrides the implicit in M and the companion object
(new Method with SM).testy2
