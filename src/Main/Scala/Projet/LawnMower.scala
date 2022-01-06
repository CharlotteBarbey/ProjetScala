/**
@author : Charlotte BARBEY & Lucas PRUTKI
@Year : 2021/2022
@School : Université Paris I Panthéon-Sorbonne M2 MoSEF
@Teacher : Mourad KAROUI
*/

package Projet


class LawnMower (private var x : Int, private var y : Int, private var orientation : String, private var orders : List[String]) extends ParserFile {

  /**
   * We define here a class that allows each mower to move on the field following the instructions given in the input file.
   * @param: x = coordinate on the abscissa position,
   *         y = coordinate on the ordinate position,
   *         orientation = letter which indicates the geographical orientation,
   *         orders = a list of letters that indicates the move of the mower
   *@return: the output of all function that are call in this class
   */

  // Define the letters accepted to orient the mower.
  def orientationSet: Set[String] = Set("N", "S", "O", "E")

  // Check that the letters designating the mower's orientation and the numbers designating its location are correct,
  // otherwise write an error message.
  require(x >= 0 && y >= 0, throw new IllegalArgumentException("Positions must be positive."))
  require(orientationSet.contains(orientation : String), throw new IllegalArgumentException("Invalid orientation. The orientation must be : N, S, O, E."))

  this.myLocation()
  this.RunCommands()

  def MoveForward() {
    /**
     * Go ahead
     * @param: orientation and xMax, yMax that are the garden boundaries
     * @return: new orientation
     */
    if ("N" == orientation && y < yMax) y += 1
    if ("S" == orientation && y > 0) y -= 1
    if ("W" == orientation && x > 0) x -= 1
    if ("E" == orientation && x < xMax) x += 1
    println(s"The mower goes straight ahead, his location is : ($x, $y, $orientation).")

  }

  def RightTurn() {
    /**
     * Rotate the mower 90° to the right
     * @param: orientation
     * @return: new orientation
     */
    orientation match {

      case "N" => orientation = "E"
      case "W" => orientation = "N"
      case "S" => orientation = "W"
      case "E" => orientation = "S"

    }
    println(s"The mower turns right, his location is : ($x, $y, $orientation).")

  }

  def LeftTurn() {
    /**
     * Rotate the mower 90° to the left
     * @param: orientation
     * @return: new orientation
     */
    orientation match {

      case "N" => orientation = "W"
      case "W" => orientation = "S"
      case "S" => orientation = "E"
      case "E" => orientation = "N"

    }
    println(s"The mower turns left, his location is : ($x, $y, $orientation).")

  }

  def myLocation() {
    /**
     * The initial position and orientation
     * @return: x, y and orientation
     */
    println("*" * 80)
    println("*" * 80)
    println(s"At the beginning, the location of the mower is : ($x,$y) and his direction is $orientation.")

  }

  def RunCommands() {
    /**
     * Executes the actions using the previously created functions
     * @param: orders
     * @return: the result of  previously functions when they are called,
     * i.e, the position and the orientation of the mower at each move
     */

    for (i <- orders) {

      // "A" means that the mower is moved one step in the direction it faces, and without changing its orientation.
      if (i == "A") this.MoveForward()
      // "D" and "G" rotate the mower 90 ° right or left respectively, without moving it.
      else if (i == "G") this.LeftTurn()
      else if (i == "D") this.RightTurn()
      //Exception handling
      else throw new IllegalArgumentException("Invalid action. The action must be A, G or D.")

    }

  }

}