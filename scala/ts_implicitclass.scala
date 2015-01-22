import scala.collection;

object showimplicits {

	object Helpers {

	  // must be defined under another trait, class or object

	  implicit class IntWithTimes(x: Int) {
	    def times[A](f: => A): Unit = {
	      def loop(current: Int): Unit =
	        if(current > 0) {
	          f
	          loop(current - 1)
	        }
	      loop(x)
	    }
	  }
	}

	import Helpers._

	def main(args: Array[String]) {
		// implicit conv of int string
		5 times println("HI")
	}
}