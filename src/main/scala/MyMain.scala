import java.io.File

import scala.io.Source

/**
  * Created by sinchan on 22/07/18.
  */
object MyMain {

  def main(args: Array[String]): Unit = {

    //println("Hello World")

    val emp = new Employee(1,"John")

    val file = Source.fromFile(new File("/Users/sinchan/Documents/Repositories/MyFirst/src/main/resources/data.csv")).mkString

    println(file)

    val lines = file.split("\n")

    println(lines.mkString(" || "))

    //lines - for, foreach, while , do while

    for(index <- 0 until 5){

      val empName = lines(index).split(",")(1)

      val hikeVal = empName match { //match case - type of variable and case values should match
        case "Vinay" =>"Big Hike"
        case "Khushboo" => "Very Big Hike"
        case "Sinchan" => "low hike"
        case _ => "no hike"
      }

      println(s"For ${empName}, hike status: ${hikeVal}")
    }

    for(index <- 0 until 5){

      val empId = lines(index).split(",")(0).toInt

      val hikeCategory = if(empId%2 == 0) "Big Hike" else "no hike"

      println(s"For employeeId ${empId}, Hike estimated: ${hikeCategory}")

    }


    for(index <- 0 until 5){
      println(tolowername(lines(index)))

    }

    for(line <- lines){ //another for construct

      val trimmed = transformName(x => x.trim)_ // example of lambda function 'x => x.trim'
      println(trimmed(line))

    }

    val upper = transformName(x => x.toUpperCase)_ //partially applied function
    val lowerNamedArr = lines.map(upper)

    lowerNamedArr.foreach(println)


    var count = 5
    while(count >0){ //while loop
    println(s"While Line no: ${count} = ${lines(count-1)}")
     count = count -1
   }

    count = 5
    do { //do while loop
      println(s"While Line no: ${count} = ${lines(count-1)}")
      count -= 1 //same as 'count = count -1' , similarly shorthand for 'count = count + 1'  can be written as 'count += 1'
    }while(count >0)

  }


  def tolowername(line1:String):String = transformName(x => x.toLowerCase)(line = line1) //named argument - 'line = line1'


  def transformName(func1:(String)=>String)(line:String):String ={ //functional programming - passing function as argument // currying
    val empName = line.split(",")(1)
    func1(empName)
  }




}
