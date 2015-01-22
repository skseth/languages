// http://stackoverflow.com/questions/7484928/what-does-a-lazy-val-do

object lazytest {
	class X { val x = { Thread.sleep(2000); 15 } }

	class Y { lazy val y = { Thread.sleep(2000); 13 } }

	new X

	new Y

}