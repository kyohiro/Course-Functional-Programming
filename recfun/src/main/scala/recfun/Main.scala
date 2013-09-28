package recfun
import common._

object Main {
  def main(args: Array[String]) {
    println("Pascal's Triangle")
    for (row <- 0 to 10) {
      for (col <- 0 to row)
        print(pascal(col, row) + " ")
      println()
    }
  }

  /**
   * Exercise 1
   */
  def pascal(c: Int, r: Int): Int = {
  	if (c == 0 || c == r) 1
  	else pascal(c - 1, r - 1) + pascal(c, r - 1)
  }

  /**
   * Exercise 2
   */
  def balance(chars: List[Char]): Boolean = {
  	def countIsBalance(cs: List[Char], count: Int): Boolean = {
  		cs match {
  		  case Nil => count == 0
  		  case '(' :: rest => countIsBalance(rest, count + 1)
  		  case ')' :: rest if (count > 0) => countIsBalance(rest, count - 1)
  		  case ')' :: rest if (count <= 0) => false
  		  case _ => countIsBalance(cs.tail, count) 
  		}
  	}
  	
  	countIsBalance(chars, 0)
  }

  /**
   * Exercise 3
   */
  def countChange(money: Int, coins: List[Int]): Int = {
    if (money == 0) 1
    else if (money < 0 || coins.isEmpty) 0
    else countChange(money - coins.head, coins) + countChange(money, coins.tail)
  }
}
