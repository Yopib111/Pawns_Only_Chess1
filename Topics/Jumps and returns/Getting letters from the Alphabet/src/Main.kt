fun main() {
    val a = readln()
    for (i in 'a'..'z') {
        if (i.toString() == a.toString()) break
        print(i)
    }
}