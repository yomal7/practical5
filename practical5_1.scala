def getProduntList(list : List[String]):List[String] = {
    val str = scala.io.StdIn.readLine().trim
    if(str.toLowerCase == "done") list
    else getProduntList(list :+ str)
}

def printProductList(list : List[String]) : Unit = {
    println("\nproducts Entered: ")
    list.foreach(item => println(s"${list.indexOf(item) + 1} ${item}"))
}

def getTotalProducts(list : List[String]): Int = list.length

@main def practical5_1() : Unit = {
    println("Enter List of products names. Enter 'done' to stop.")
    val list = getProduntList(List())
    printProductList(list)
    println("\nTotal numbet of products in the list : "+ getTotalProducts(list))
}