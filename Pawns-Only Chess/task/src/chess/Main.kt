package chess

val chList = mutableListOf(
    mutableListOf<String>(" ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf<String>("B", "B", "B", "B", "B", "B", "B", "B"),
    mutableListOf<String>(" ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf<String>(" ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf<String>(" ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf<String>(" ", " ", " ", " ", " ", " ", " ", " "),
    mutableListOf<String>("W", "W", "W", "W", "W", "W", "W", "W"),
    mutableListOf<String>(" ", " ", " ", " ", " ", " ", " ", " ")
)
var str1 = ""
var str2 = ""
var horizon = 0
var horizonSecond = 0
var vertical = 0
var verticalSecond = 0
var ok = 0

fun main() {
    val regex = Regex("[a-h][1-8][a-h][1-8]")
    println("Pawns-Only Chess")
    println("First Player's name:")
    val firstName = readln().toString()
    println("Second Player's name:")
    val secondName = readln().toString()
    println(
        """
  +---+---+---+---+---+---+---+---+
8 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
7 | B | B | B | B | B | B | B | B |
  +---+---+---+---+---+---+---+---+
6 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
5 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
4 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
3 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
2 | W | W | W | W | W | W | W | W |
  +---+---+---+---+---+---+---+---+
1 |   |   |   |   |   |   |   |   |
  +---+---+---+---+---+---+---+---+
    a   b   c   d   e   f   g   h
"""
    )

    do {
// ход первого игрока
        while (str1 != "exit" && ok != 1) {
            println("$firstName's turn:")
            str1 = readln().toString()
            if (regex.matches(str1)) {
                changeChessDataWhite(str1)
            } else if (str1 == "exit") {
                break
            } else println("Invalid Input")
        }
        if (ok == 1) {
            printChess()
            ok = 0
        }
        if (str1 == "exit") break

//    ход второго игрока
        while (str2 != "exit" && ok != 1) {
            println("$secondName's turn:")
            str2 = readln().toString()
            if (regex.matches(str2)) {
                changeChessDataBlack(str2)
            } else if (str2 == "exit") {
                break
            } else println("Invalid Input")
        }
        if (ok == 1) {
            printChess()
            ok = 0
        }
    } while (str2 != "exit")

    println("Bye!")
}

fun printChess() {
    println("  +---+---+---+---+---+---+---+---+")
    for (i in 1 until 9) {
        print("${9-i}")
        println(chList[i-1].joinToString(prefix = " | ", postfix = " | ", separator = " | "))
        println("  +---+---+---+---+---+---+---+---+")
    }
    println("    a   b   c   d   e   f   g   h")
}

fun changeChessDataWhite(input: String) {

    horizon = 8 - input[1].digitToInt()
    horizonSecond = 8 - input[3].digitToInt()

    if (input[0] == 'a') vertical = 0
    if (input[0] == 'b') vertical = 1
    if (input[0] == 'c') vertical = 2
    if (input[0] == 'd') vertical = 3
    if (input[0] == 'e') vertical = 4
    if (input[0] == 'f') vertical = 5
    if (input[0] == 'g') vertical = 6
    if (input[0] == 'h') vertical = 7

    if (input[2] == 'a') verticalSecond = 0
    if (input[2] == 'b') verticalSecond = 1
    if (input[2] == 'c') verticalSecond = 2
    if (input[2] == 'd') verticalSecond = 3
    if (input[2] == 'e') verticalSecond = 4
    if (input[2] == 'f') verticalSecond = 5
    if (input[2] == 'g') verticalSecond = 6
    if (input[2] == 'h') verticalSecond = 7

    if (chList[horizon][vertical] == "W") {
        if (chList[horizonSecond][verticalSecond] == " ") {
            if (horizon - horizonSecond == 1 && vertical == verticalSecond) {
                chList[horizonSecond][verticalSecond] = "W"
                chList[horizon][vertical] = " "
                ok = 1
            } else if (horizon - horizonSecond == 2 && horizon == 6 && vertical == verticalSecond) {
                if (chList[horizonSecond][verticalSecond] == " " && chList[horizonSecond+1][verticalSecond] == " ") {
                    chList[horizonSecond][verticalSecond] = "W"
                    chList[horizon][vertical] = " "
                    ok = 1
                } else println("Invalid Input")
            } else println("Invalid Input")
        } else println("Invalid Input")
    } else println("No white pawn at ${input[0]}${input[1]}")
}

fun changeChessDataBlack(input: String) {

    horizon = 8 - input[1].digitToInt()
    horizonSecond = 8 - input[3].digitToInt()

    if (input[0] == 'a') vertical = 0
    if (input[0] == 'b') vertical = 1
    if (input[0] == 'c') vertical = 2
    if (input[0] == 'd') vertical = 3
    if (input[0] == 'e') vertical = 4
    if (input[0] == 'f') vertical = 5
    if (input[0] == 'g') vertical = 6
    if (input[0] == 'h') vertical = 7

    if (input[2] == 'a') verticalSecond = 0
    if (input[2] == 'b') verticalSecond = 1
    if (input[2] == 'c') verticalSecond = 2
    if (input[2] == 'd') verticalSecond = 3
    if (input[2] == 'e') verticalSecond = 4
    if (input[2] == 'f') verticalSecond = 5
    if (input[2] == 'g') verticalSecond = 6
    if (input[2] == 'h') verticalSecond = 7

    if (chList[horizon][vertical] == "B") {
        if (chList[horizonSecond][verticalSecond] == " " && vertical == verticalSecond) {
            if (horizonSecond - horizon == 1) {
                chList[horizonSecond][verticalSecond] = "B"
                chList[horizon][vertical] = " "
                ok = 1
            } else if (horizonSecond - horizon == 2 && horizon == 1 && vertical == verticalSecond) {
                if (chList[horizonSecond][verticalSecond] == " " && chList[horizonSecond-1][verticalSecond] == " ") {
                    chList[horizonSecond][verticalSecond] = "B"
                    chList[horizon][vertical] = " "
                    ok = 1
                } else println("Invalid Input")
            } else println("Invalid Input")
        } else println("Invalid Input")
    } else println("No black pawn at ${input[0]}${input[1]}")
}