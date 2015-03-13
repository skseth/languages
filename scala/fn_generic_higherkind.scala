import scala.collection.TraversableLike

def multiMinBy[A, B: Ordering](xs: Traversable[A])(f: A => B) = {
  val minVal = f(xs minBy f)
  xs filter (f(_) == minVal)
}

def multiMinBy2[A, B: Ordering, C <: Traversable[A]]
              (xs: C with TraversableLike[A, C])
              (f: A => B): C = {
  val minVal = f(xs minBy f)
  xs filter (f(_) == minVal)
}

def multiMinBy3[A, B: Ordering, C[_] <: TraversableLike[_ <: A, C[_]]]
              (xs: C[A])
              (f: A => B): C[A] = {
  val minVal = f(xs minBy f)
  xs
  //xs filter (f(_) == minVal)
}
