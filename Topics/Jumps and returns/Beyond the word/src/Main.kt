fun main() {
    val a = readln()
    for (i in 'a'..'z') {
        if (i in a) continue
        print(i)
    }
}