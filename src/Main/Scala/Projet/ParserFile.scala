/**
@author : Charlotte BARBEY & Lucas PRUTKI
@Year : 2021/2022
@School : Université Paris I Panthéon-Sorbonne M2 MoSEF
@Teacher : Mourad KAROUI
*/

package Projet

import Projet.Run.fileName
import scala.collection.mutable.ListBuffer
import scala.io.Source.fromResource


class ParserFile {

  /**
   * Analyzes the instruction file given to it as input.
   * @param filePath who it is define in the Run script
   * @return Return all instructions for each mower in different variables
   */


  // Read the instruction file and convert all to Upper case
  var data = fromResource(fileName).getLines.toList
  data = data.map(x => x.toUpperCase)

  // Garden boundaries
  var xMax = data(0).split(" ")(0).toInt
  var yMax = data(0).split(" ")(1).toInt

  // Unit test
  assert(xMax >= 0)
  assert(yMax >= 0)

  // Initialization of variables commands and location
  var commands = new ListBuffer[String]()
  var location = new ListBuffer[String]()

  // For each mower, addition of the movement instructions in the commands variable
  // and information on its position in the location variable
  for ((line, count) <- data.zipWithIndex) {
    if (count % 2 == 0 && count != 0) commands += line
    if (count % 2 != 0 && count != 0) location += line

  }
}

