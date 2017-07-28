
lazy val p:Int = p

// applicative works
def test(x:Int, y: => Int) = if (x == 0) 0 else y

// normal order fails 
// def test(x:Int, y:'Int) = if (x == 0) 0 else y


println(test(0, p))