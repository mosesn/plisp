object Compiler {
  val IndentLength = 2

  def main(args: Array[String]) {
    val (input, output) = getIO(args)
    output(compile(input))
  }

  private[this] def compile(input: io.BufferedSource): String = {
    val tree = new Tree
    for (line <- input.getLines) {
      val (startingWhitespace, rest) = line.partition(_.isWhitespace)
      if (rest.length > 0) {
        tree.parseLine(startingWhitespace.length / IndentLength, rest)
      }
    }
    tree.toString
  }

  private[this] def getIO(args: Array[String]): Pair[io.BufferedSource, String => Unit] = {
    if (args.length > 2) {
      throw new IllegalArgumentException("Too many arguments")
    }
    val input = if (args.length >= 1) Some(args(0)) else None
    val output = if (args.length == 2) Some(args(1)) else None
    (getInputFile(input), getOutputter(output))
  }

  private[this] def getInputFile(input: Option[String]): io.BufferedSource = input match {
    case Some(filename) => if (filename.endsWith(".plisp")) {
      io.Source.fromFile(filename)
    }
    else {
      throw new IllegalArgumentException("You may only pass .plisp files as arguments")
    }
    case None => io.Source.stdin
  }

  private[this] def getOutputter(output: Option[String]): String => Unit = defaultPrint

  private[this] def defaultPrint(string: String): Unit = println(string)
}