// http://www.scala-lang.org/old/node/115.html
// Scala inner classes are bound to outer object, NOT enclosing class
// the type is "path-dependent"
import scala.reflect.runtime.{universe => ru}

object GraphTest {
	def getTypeTag[T: ru.TypeTag](obj: T) = ru.typeTag[T]

	class Graph {
	  class Node {
	    var connectedNodes: List[Node] = Nil
	    def connectTo(node: Node) {
	      if (connectedNodes.find(node.equals).isEmpty) {
	        connectedNodes = node :: connectedNodes
	      }
	    }
	  }
	  var nodes: List[Node] = Nil
	  def newNode: Node = {
	    val res = new Node
	    nodes = res :: nodes
	    res
	  }
	}

	class Graph2 {
	  class Node {
	    var connectedNodes: List[Graph2#Node] = Nil
	    def connectTo(node: Graph2#Node) {
	      if (connectedNodes.find(node.equals).isEmpty) {
	        connectedNodes = node :: connectedNodes
	      }
	    }
	  }
	  var nodes: List[Node] = Nil
	  def newNode: Node = {
	    val res = new Node
	    nodes = res :: nodes
	    res
	  }
	}

	def main(args: Array[String]) {
		val g = new Graph

		// we can explicitly refer to g.Node
		val n1 : g.Node = g.newNode

		// but it is also implicitly derived
		val n2 = g.newNode
		val n3 = g.newNode
		n1.connectTo(n2)
		n3.connectTo(n1)
		val h: Graph = new Graph
		val n4: h.Node = h.newNode

		// Both print Main$Graph$Node
		println("classof node n1 = " + n1.getClass())
		println("classof node n4 = " + n4.getClass())

		// fails - says : required g.Node, found h.Node
		// this is legal in Java
		// n2.connectTo(n4)

		// following works - connecting nodes across graphs
		// but one node still cannot be in 2 graphs
		val g2 = new Graph2
		val g2n1 = g2.newNode
		val h2 = new Graph2
		val h2n4 = h2.newNode
		g2n1.connectTo(h2n4)

	}
}