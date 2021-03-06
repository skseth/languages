object ADTScala {

	// Note the +T => Tree is covariant
	sealed trait Tree[+T]

	// Note Nothing is bottom type - so works for all types, because we have defined Tree to be +T i.e. covariant
	// This implies a if Person is subclass of Animal, the Tree[Person] is subclass of Tree[Animal]
	// Here Tree[Nothing] is subclass of Tree[T] for any T
	case object Empty extends Tree[Nothing]
	case class  Leaf[T](value:T) extends Tree[T]
	case class  Branch[T](value: T, left: Tree[T], right: Tree[T]) extends Tree[T]


	def showTree[T](tree: Tree[T]):String = tree match {
	  case Empty    => s"-"
	  case Leaf(v)  => s"${v}"
	  case Branch(v, l, r) => s"$v<" +
	                                     s"${showTree(l)}|" +
	                                     s"${showTree(r)}>"
	}

	def treeFromList[T <% Ordered[T]](list:List[T]):Tree[T] = list match {
		case Nil 		=> Empty
		case x :: Nil 	=> Leaf[T](x)
		case x :: xs 	=> Branch[T](x, treeFromList[T](list.filter {i => i < x}), treeFromList[T](list.filter {i => i > x}) )
	}

	def main(args: Array[String]) {
		println(showTree(treeFromList(List(7,2,4,8))))
	}
}