fun main(args: Array<String>) {
    val list:List<Int> = listOf(1,2,3,4,5)
    print(list)
    val list2:MutableList<Int> = mutableListOf(1,2,3,4,5,6)
    list2.set(3,10)
    list2.set(1,100)
    print(list2)
}