fun main(args: Array<String>) {
    var n:Int? = readln()?.toInt()
    if (n == null) return
    var l:MutableList<Int> = mutableListOf()
    for(i in 1..n){
        println("Nhập pt $i của list: ")
        var input:Int? = readln()?.toInt()
        if(input == null) return
        //add ptu vào list
        l.add(input)
        println("List: "+ l)

    }
}