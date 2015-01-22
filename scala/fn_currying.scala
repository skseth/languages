

// context-bound - same as
// def mul[T](x:T, y:T)(implicit n:Numeric[T]) = n.times(x,y)
def mul[T:Numeric](x:T, y:T) = implicitly[Numeric[T]].times(x,y)

// partial application
def mul3[T:Numeric](x:T) = mul[T](3,x)
//def mul_curried[T](x:Numeric[T])(y:Numeric[T]) = mul(x,y)

println(mul(3,5))
println(mul3(5))
