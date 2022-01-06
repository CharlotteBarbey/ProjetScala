/**
@author : Charlotte BARBEY & Lucas PRUTKI
@Year : 2021/2022
@School : Université Paris I Panthéon-Sorbonne M2 MoSEF
@Teacher : Mourad KAROUI
*/
package Projet

import java.io.{FileNotFoundException, IOException}
import scala.io.Source.fromResource

object Run extends App {
  // Enter the file name
  val fileName = "consignes.txt"
  // Try to read the instruction file
  try {
    println("Above, the content of the instruction file : ")
    for (line <- fromResource(fileName).getLines) {
      println(line)
    }
  // Exception handling
  } catch {
    case fnfe: FileNotFoundException => println(s"Couldn't find that file : $fnfe")
    case ioe: IOException => println(s"Got an IOException! : $ioe")
    case _ : Exception => println("There is a mistake.")
  }

  // Call the ParserFile class
  var Parser = new ParserFile()
  println(" ")
  // Size of the garden
  println(s"The size of the garden is : ${Parser.xMax},${Parser.yMax}.")

  // Extraction of the mower position
  var start = Parser.location.toList
  //  Retrieve all actions
  var actions = Parser.commands.toList
  // Initialization of an iterator for the mower
  var count = 1

  for ((i,j) <- start zip actions) {
    println(" ")
    println(s"Mower : $count")

    // Calling the LawnMower function
    new LawnMower(x = i.split(" ")(0).toInt,
                  y = i.split(" ")(1).toInt,
                  orientation = i.split(" ")(2),
                  orders = j.split("").toList)
    // For the following mower, the iterator take 1
    count += 1
    println(" ")
  }
}

