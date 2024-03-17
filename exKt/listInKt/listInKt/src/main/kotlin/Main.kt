import kotlin.random.Random

fun main(args: Array<String>) {
    //1.Khai báo 1 mutablelist
   /* var list1:MutableList<Int> = mutableListOf()
    println(list1::class.java.typeName)

    //2. List
    var list2:List<Int> = listOf()
    println(list2::class.java.typeName)

    //Khởi tạo
    var list3:List<Int> = listOf(1,2,3,4,5)
    println(list3.toString())

    var list4:MutableList<Int> = mutableListOf(4,5,6,7,8,9)
    println(list4.indices)

    for (i in list4.indices){
        print("${list4[i]} ")
    }

    list4.add(2,10)
    println(list4)

    list4.addAll(mutableListOf(1,2,3))
    println(list4)
    //thêm vào 1 vị trí nào đó
    list4.addAll(1, mutableListOf(1,2,3))
    println(list4)

    //xoá tại vị trí
    list4.removeAt(1)
    println(list4)

    //remove: Xoá pt đầu tiên trùng khớp
    list4.remove(2)
    println(list4)

    //sort
    list4.sort()
    list4.sortDescending()

    var list5 = list4.filter {x -> x > 5}
    println(list5)

    //contains()
    println(list5.contains(6))

    //clear
    println(list1.clear())*/

    var l:MutableList<Int> = mutableListOf()
    var rd = Random
    println("Nhap vao so pt cua list")
    var n:Int? = readln()?.toInt()
    if (n == null) return
    for(i in 1..n){
        l.add(rd.nextInt(101))
    }
    print("List: " + l)
}