package com.atomicscala.exercise19

class Cell {
  var entry = ' '

  def set(e: Char): String = {
    if (entry == ' ' && (e == 'X' || e == 'O')) {
      entry = e
      "successful move"
    } else
      "invalid move"
  }
}

class Grid {
  val cells = Vector(
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell),
    Vector(new Cell, new Cell, new Cell)
  )

  def play(e: Char, x: Int, y: Int): String = {
    if (x < 0 || x > 2 || y < 0 || y > 2)
      displayGrid("invalid move")
    else
      displayGrid(cells(x)(y).set(e))
  }

  def displayGrid(msg: String): String = {
    for (row <- cells) {
      for (cell <- row) {
        print(if (cell.entry == ' ') "_ " else cell.entry + " ")
      }
      println()
    }
    message(msg)
  }

  def message(msg: String): String = {
    val lines = linesSummary()
    def xWins(lines: Vector[(Char, Boolean)]): Boolean = {
      for (line <- lines) {
        if (line._1 == 'X') return true
      }
      false
    }
    def oWins(lines: Vector[(Char, Boolean)]): Boolean = {
      for (line <- lines) {
        if (line._1 == 'O') return true
      }
      false
    }
    def draw(lines: Vector[(Char, Boolean)]): Boolean = {
      var count = 0
      for (line <- lines) {
        if (line._2) count += 1
      }
      count == 8
    }

    if (xWins(lines)) {
      "X wins"
    } else if (oWins(lines)) {
      "O wins"
    } else if (draw(lines)) {
      "Draw"
    } else {
      msg
    }
  }

  def linesSummary(): Vector[(Char, Boolean)] = {
    Vector(lineSummary(1), lineSummary(2), lineSummary(3), lineSummary(4), lineSummary(5), lineSummary(6), lineSummary(7), lineSummary(8))
  }

  def lineSummary(lineNumber:Int): (Char, Boolean) = {
    val l = lineCounts(lineNumber)
    def xWins(line: Vector[Int]): Boolean = {
      line.head == 3
    }
    def oWins(line: Vector[Int]): Boolean = {
      line(1) == 3
    }
    def draw(line: Vector[Int]): Boolean = {
      l.head > 0 && l(1) > 0
    }
    (if (xWins(l)) 'X' else if (oWins(l)) 'O' else ' ', draw(l))
  }

  def lineCounts(lineNumber: Int): Vector[Int] = {
    val lineEntries = line(lineNumber)
    Vector(lineEntries.count(_ == 'X'), lineEntries.count(_ == 'O'), lineEntries.count(_ == ' '))
  }

  def line(line: Int): Vector[Int] = {
    if (line == 1) {
      lineRow(0)
    } else if (line == 2) {
      lineRow(1)
    } else if (line == 3) {
      lineRow(2)
    } else if (line == 4) {
      lineCol(0)
    } else if (line == 5) {
      lineCol(1)
    } else if (line == 6) {
      lineCol(2)
    } else if (line == 7) {
      lineDiagLtoR()
    } else {
      lineDiagRtoL()
    }
  }

  def lineRow(row: Int): Vector[Int] = {
    Vector(cells(row).head.entry, cells(row)(1).entry, cells(row)(2).entry)
  }

  def lineCol(col: Int): Vector[Int] = {
    Vector(cells.head(col).entry, cells(1)(col).entry, cells(2)(col).entry)
  }

  def lineDiagLtoR(): Vector[Int] = {
    Vector(cells.head.head.entry, cells(1)(1).entry, cells(2)(2).entry)
  }

  def lineDiagRtoL(): Vector[Int] = {
    Vector(cells.head(2).entry, cells(1)(1).entry, cells(2).head.entry)
  }
}
