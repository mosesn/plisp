class Tree {
  private[this] val root = Node.empty(None)
  private[this] var cur = root
  private[this] var depth = -1

  def parseLine(indentDepth: Int, line: String) = {
    if (indentDepth > depth + 1) {
      throw new Exception("Indentation was too deep")
    }
    else {
      cur = cur.ancestor(depth - indentDepth + 1)
      makeNewNode(line)
    }
    depth = indentDepth
  }

  private[this] def makeNewNode(line: String) {
    val newNode = Node.childless(line, Some(cur))
    cur.addChild(newNode)
    cur = newNode
  }

  override def toString = root.children.reverse.mkString("\n")
}

private[this] case class Node(payload: String, var children: List[Node], parent: Option[Node]) {
  def addChild(node: Node) {
    children = node :: children
  }

  def ancestor(n: Int): Node = if (n == 0) this else {
    parent.get.ancestor(n - 1)
  }

  override def toString = children match {
    case Nil => payload
    case nonempty => "(" + payload + " " + nonempty.reverse.mkString(" ") + ")"
  }
}

private[this] object Node {
  def empty(parent: Option[Node]): Node = Node.childless("", parent)
  def childless(payload: String, parent: Option[Node]): Node = Node(payload, List(), parent)
}