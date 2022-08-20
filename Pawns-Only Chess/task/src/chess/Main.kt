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
var doubleMoveWhite = "0000"
var doubleMoveBlack = "0000"
var stopGameCode = 0

fun main() {
    val regex = Regex("[a-h][1-8][a-h][1-8]")
    println("Pawns-Only Chess")
    println("First Player's name:")
    val firstName = readln()
    println("Second Player's name:")
    val secondName = readln()
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
            str1 = readln()
            if (regex.matches(str1)) {
                movingChessDataWhite(str1)
                when (checkEndGame()) {
                    1 -> {
                        printChess()
                        println("White Wins!")
                        str1 = "exit"
                        ok = 0
                    }
                    3 -> {
                        printChess()
                        println("White Wins!")
                        str1 = "exit"
                        ok = 0
                    }
                    5 -> {
                        printChess()
                        println("Stalemate!")
                        str1 = "exit"
                        ok = 0
                    }
                    6 -> {
                        printChess()
                        println("Stalemate!")
                        str1 = "exit"
                        ok = 0
                    }

                }
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
            str2 = readln()
            if (regex.matches(str2)) {
                movingChessDataBlack(str2)
                when (checkEndGame()) {
                    2 -> {
                        printChess()
                        println("Black Wins!")
                        str2 = "exit"
                        ok = 0
                    }
                    4 -> {
                        printChess()
                        println("Black Wins!")
                        str2 = "exit"
                        ok = 0
                    }
                    5 -> {
                        printChess()
                        println("Stalemate!")
                        str2 = "exit"
                        ok = 0
                    }
                    6 -> {
                        printChess()
                        println("Stalemate!")
                        str2 = "exit"
                        ok = 0
                    }
                }

            } else if (str2 == "exit") {
                break
            } else println("Invalid Input")
        }
        if (ok == 1) {
            printChess()
            ok = 0
        }
        if (str2 == "exit") break

    } while (str2 != "exit" || str1 != "exit")

    println("Bye!")


}

// функция по прорисовке поля
fun printChess() {
    println("  +---+---+---+---+---+---+---+---+")
    for (i in 1 until 9) {
        print("${9 - i}")
        println(chList[i - 1].joinToString(prefix = " | ", postfix = " | ", separator = " | "))
        println("  +---+---+---+---+---+---+---+---+")
    }
    println("    a   b   c   d   e   f   g   h")
}

// функция по обработке хода белых в массиве
fun movingChessDataWhite(input: String) {

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
                    doubleMoveWhite = "0000"
                } else if (horizon - horizonSecond == 2 && horizon == 6 && vertical == verticalSecond) {
                    if (chList[horizonSecond][verticalSecond] == " " && chList[horizonSecond + 1][verticalSecond] == " ") {
                        chList[horizonSecond][verticalSecond] = "W"
                        chList[horizon][vertical] = " "
                        ok = 1
                        doubleMoveWhite = str1
                    } else println("Invalid Input")
                } else if (horizon - horizonSecond == 1 && (vertical - verticalSecond == 1 || vertical - verticalSecond == -1)) {
                    if (input[2] == doubleMoveBlack[0] && input[2] == doubleMoveBlack[2] && (input[3].digitToInt() - doubleMoveBlack[3].digitToInt() == 1) && (doubleMoveBlack[1].digitToInt() - input[3].digitToInt() == 1)) {
                        chList[horizonSecond][verticalSecond] = "W"
                        chList[horizonSecond + 1][verticalSecond] = " "
                        chList[horizon][vertical] = " "
                        ok = 1
                        doubleMoveWhite = "0000"


                    } else println("Invalid Input")
                } else println("Invalid Input")
            } else if (chList[horizonSecond][verticalSecond] == "B") {
                if (horizon - horizonSecond == 1 && (vertical - verticalSecond == 1 || vertical - verticalSecond == -1)) {
                    chList[horizonSecond][verticalSecond] = "W"
                    chList[horizon][vertical] = " "
                    ok = 1
                    doubleMoveWhite = "0000"
                } else println("Invalid Input")
            } else println("Invalid Input")
        } else println("No white pawn at ${input.substring(0, 2)}")
    }


// функция по обработке хода черных в массиве
fun movingChessDataBlack(input: String) {

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
            if (chList[horizonSecond][verticalSecond] == " ") {
                if (horizonSecond - horizon == 1 && vertical == verticalSecond) {
                    chList[horizonSecond][verticalSecond] = "B"
                    chList[horizon][vertical] = " "
                    ok = 1
                    doubleMoveBlack = "0000"
                } else if (horizonSecond - horizon == 2 && horizon == 1 && vertical == verticalSecond) {
                    if (chList[horizonSecond][verticalSecond] == " " && chList[horizonSecond - 1][verticalSecond] == " ") {
                        chList[horizonSecond][verticalSecond] = "B"
                        chList[horizon][vertical] = " "
                        ok = 1
                        doubleMoveBlack = str2
                    } else println("Invalid Input")
                } else if (horizonSecond - horizon == 1 && (vertical - verticalSecond == 1 || vertical - verticalSecond == -1)) {
                    if (input[2] == doubleMoveWhite[0] && input[2] == doubleMoveWhite[2] && (input[3].digitToInt() - doubleMoveWhite[1].digitToInt() == 1) && (doubleMoveWhite[3].digitToInt() - input[3].digitToInt() == 1)) {
                        chList[horizonSecond][verticalSecond] = "B"
                        chList[horizonSecond - 1][verticalSecond] = " "
                        chList[horizon][vertical] = " "
                        ok = 1
                        doubleMoveBlack = "0000"
                    } else println("Invalid Input")
                } else println("Invalid Input")
            } else if (chList[horizonSecond][verticalSecond] == "W") {
                if (horizonSecond - horizon == 1 && (vertical - verticalSecond == 1 || vertical - verticalSecond == -1)) {
                    chList[horizonSecond][verticalSecond] = "B"
                    chList[horizon][vertical] = " "
                    ok = 1
                    doubleMoveBlack = "0000"
                } else println("Invalid Input")
            } else println("Invalid Input")
        } else println("No black pawn at ${input.substring(0, 2)}")
    }


// функция по проверки массива на окончание игры
fun checkEndGame(): Int {
    var whiteEatAllBlack: Boolean = true
    var blackEatAllWhite: Boolean = true

// проверяем что больше невозможно сделать ход белыми
    var checkAvailableMoveWhite = 0
    for (i in 1 .. 6) {
        for (j in 0 .. 7) {
            if (chList[i][j] == "W" && j == 0) {
                if (chList[i-1][j] == " " || chList[i-1][j+1] == "B") checkAvailableMoveWhite++
            } else if (chList[i][j] == "W" && j == 7) {
                if (chList[i-1][j] == " " || chList[i-1][j-1] == "B") checkAvailableMoveWhite++
            } else if (chList[i][j] == "W") {
                if (chList[i-1][j-1] == "B" || chList[i-1][j+1] == "B" || chList[i-1][j] == " ") checkAvailableMoveWhite++
            }
        }
    }
    if (checkAvailableMoveWhite == 0) stopGameCode = 5

// проверяем что больше невозможно сделать ход черными
    var checkAvailableMoveBlack = 0
    for (i in 1 .. 6) {
        for (j in 0 .. 7) {
            if (chList[i][j] == "B" && j == 0) {
                if (chList[i+1][j] == " " || chList[i+1][j+1] == "W") checkAvailableMoveBlack++
            } else if (chList[i][j] == "B" && j == 7) {
                if (chList[i+1][j] == " " || chList[i+1][j-1] == "W") checkAvailableMoveBlack++
            } else if (chList[i][j] == "B") {
                if (chList[i+1][j-1] == "W" || chList[i+1][j+1] == "W" || chList[i+1][j] == " ") checkAvailableMoveBlack++
            }
        }
    }
    if (checkAvailableMoveBlack == 0) stopGameCode = 6

// проверяем что белые выиграли - на поле не должно остаться элементов "В"
    for (j in 0 .. 7) {
        if ("B" in chList[j]) whiteEatAllBlack = false
    }
    if (whiteEatAllBlack) stopGameCode = 1

// проверяем что черные выиграли - на поле не должно остаться элементов "W"
    for (i in 0 .. 7) {
        if ("W" in chList[i]) blackEatAllWhite = false
    }
    if (blackEatAllWhite) stopGameCode = 2

// проверяем что белые достигли верхнего поля
    if ("W" in chList[0]) stopGameCode = 3

// проверяем что черные достигли нижнего поля
    if ("B" in chList[7]) stopGameCode = 4

    return stopGameCode
}