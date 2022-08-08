fun main() {
    val a = readln().toString()
    loop@ for (i in a) {
        for (j in '0'..'9') {
            if (i == j) {
                println(j)
                break@loop
            }
        }
    }
}
