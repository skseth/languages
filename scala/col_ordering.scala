// finding min in a list of tuples
// see - http://stackoverflow.com/questions/2190511/in-scala-how-to-use-orderingt-with-list-min-or-list-max-and-keep-code-readabl

val list = ("a", 5) :: ("b", 3) :: ("c", 2) :: Nil

val min = list min Ordering[Int].on[(_,Int)](_._2)

val min2 = list min Ordering.by((_: (_, Int))._2)

val min3 = list.min( new Ordering[Tuple2[String,Int]] { 
  def compare(x:Tuple2[String,Int],y:Tuple2[String,Int]): Int = x._2 compare y._2 
} )


println(min)
println(min2)
println(min3)


// from http://www.scala-lang.org/api/current/index.html#scala.math.Ordering
import scala.util.Sorting
val pairs = Array(("a", 5, 2), ("c", 3, 1), ("b", 1, 3),("d",8,2))

// sort by 2nd element
Sorting.quickSort(pairs)(Ordering.by[(String, Int, Int), Int](_._2))

// sort by the 3rd element, then 1st
Sorting.quickSort(pairs)(Ordering[(Int, String)].on(x => (x._3, x._1)))

println(pairs.deep.mkString("\n"))


case class Person(name:String, age:Int)
val people = Array(Person("bob", 30), Person("ann", 32), Person("carl", 19))

// sort by age
object AgeOrdering extends Ordering[Person] {
  def compare(a:Person, b:Person) = a.age compare b.age
}
Sorting.quickSort(people)(AgeOrdering)

println(people.deep.mkString("\n"))
