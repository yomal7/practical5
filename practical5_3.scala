def fibonacci(n: Int): Int = n match{
    case 0 => 0
    case x if x == 1 => 1
    case _ => fibonacci(n-1) + fibonacci(n-2)
}

def fibonacciSeq(n: Int): Unit = {
    if(n>=0){
        fibonacciSeq(n-1)
        println(fibonacci(n))
    }
}

@main def practical5_3(): Unit = {
    println("Enter a number: ")
    val num = scala.io.StdIn.readInt()
    println(s"First ${num} fibonacci numbers : ")
    fibonacciSeq(num-1)
}