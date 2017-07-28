
object testTraverables {

	def run() {
		val l:Traversable[Int] = List(1,2,5,34)

		println(l)

		{
			// foldLeft
			val totalL = l.foldLeft(0) {(total, n) => total + n}
			val totalstrL = l.foldLeft("foldl") {(total, n) => "(" + total + "," + n + ")"}
			val totalR = l.foldRight(0) {(total, n) => total + n}
			val totalstrR = l.foldRight("foldr") {(total, n) => "(" + total + "," + n + ")"}

			println(totalL, totalR)
			println(totalstrL)
			println(totalstrR)
		}	

		{
			// reduceLeft - needs at least one element of list
			val totalstr = (l map { x => x.toString }).reduceLeft {(total, n) => "(" + total + "," + n + ")"}
			println(totalstr)

			val lempty = List.empty
			val totalemp = (lempty map { x => x.toString }).reduceLeftOption {(total, n) => total + "," + n}
			println(totalemp)
		}
	}
}

testTraverables.run()