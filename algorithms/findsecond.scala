
object findsecond {

  def second(n:List[Int]):Int = {

    def secondAcc(n:List[Int]):(Int,Int) = {
      if (n.length == 2) {
        if (n(0) > n(1)) {
          return (n(0), n(1))
        }
        else {
          return (n(1), n(0))
        }
      }

      val (l,r) = n splitAt (n.length / 2)

      val (f1, s1) = secondAcc(l)
      val (f2, s2) = secondAcc(r)

      if (f1 > f2) {
          if (s1 > f2) {
            return (f1,s1)
          }
          else {
            return (f1, f2)
          }
      }
      else {
        if (s2 > f1) {
          return (f2, s2)
        }
        else {
          return (f2, f1)
        }

      }

          return (f1,f2)
      if (f1 > f2) return (f1,f2)
      return (f2,f1)
    }

    val (f,s) = secondAcc(n)

    return s

  }

  def main(args:Array[String]) {
    println(second(List[Int](1,4,5,6,78,34,23,12)))
  }

}