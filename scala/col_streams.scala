
import scala.math.BigInt

object fibs {
	// fibs. The tail function works because 2 items have been defined before usage.
	val fibs: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

	// check memoization - when called second time, println will not run for already accessed nodes.
	val fibs2: Stream[BigInt] = BigInt(0) #:: BigInt(1) #:: fibs.zip(
	fibs.tail).map(n => {
	  println("Adding %d and %d".format(n._1, n._2))
	  n._1 + n._2
	})

	// just a loop for testing functions below
	def printints(s: String, i: Int, iter: Iterator[Int]): Unit = {
	  // Stop after 200,000
	  if (i < 200001) {
	    if (i % 50000 == 0) println(s + i)
	    loop(s, iter.next, iter)
	  }
	}

	// a stream of ints, with a val. stream1 holds onto the head, which holds the tail. 
	// Memoization can take lot of memory
	val stream1: Stream[Int] = {
	  def loop(v: Int): Stream[Int] = v #:: loop(v + 1)
	  loop(0)
	}

	// a stream of ints, with a def - does not hold on to the head when an iterator is used. No memoization.
	def stream2: Stream[Int] = {
	  def loop(v: Int): Stream[Int] = v #:: loop(v + 1)
	  loop(0)
	}

	def main(args: Array[String]) {
		fibs.take(5).foreach(println)

		println("=== Memoization - 1st access ===")
		fibs2 take 5 foreach println
		println("=== Memoization - 2 access. No println upto 5th value ===")
		fibs2 take 6 foreach println

		// using val iterator
		val it1 = stream1.iterator
		printints("Iterator1: ", it1.next, it1)

		// using def iterator
		val it1 = stream2.iterator
		printints("Iterator1: ", it1.next, it1)

	}
}



