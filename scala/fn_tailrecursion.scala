// scalac <thisfilename>.scala
// javap -c factorial
// javap -c factorial2
// not tail recursive because potentially subclasses can override and make non-tail recursive
import scala.annotation.tailrec

class factorial {
    def calculate(x: Int, y: Int=1): Int = {
            if(x==1) y else calculate(x-1,x*y)
    }
}

// now subclasses cannot override - private will achieve same effect
class factorial2 {
    final def calculate2(x: Int, y: Int=1): Int = {
            if(x==1) y else calculate2(x-1,x*y)
    }
}


class factorial3 {
	@tailrec
    private def calculate3(x: Int, y: Int=1): Int = {
            if(x==1) y else calculate3(x-2,x*y)
    }
}

println(new factorial2().calculate2(16))
