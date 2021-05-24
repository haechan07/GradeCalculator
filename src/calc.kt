import java.lang.StringBuilder

fun main() {
    val list = mutableListOf<Pair<String, Int>>()
    var toStop = false
    val sb = StringBuilder()
    while (!toStop) {
        val className = getThing("과목명")
        val learners = getThing("수강자 수").toInt()
        var placement = getThing("석차").toDouble()
        val samePlaces = getThing("동석차 수").toInt()
        when (samePlaces != 0) {
            true -> placement += (samePlaces - 1).toDouble() / 2 // 동석차가 0이 아닐 경우
        }
        val percent = (placement / learners * 100)
        var gradeClass: Int
        when (true) { // 등급 계산
            percent <= 4 -> gradeClass = 1
            percent <= 11 -> gradeClass = 2
            percent <= 23 -> gradeClass = 3
            percent <= 40 -> gradeClass = 4
            percent <= 60 -> gradeClass = 5
            percent <= 77 -> gradeClass = 6
            percent <= 89 -> gradeClass = 7
            percent <= 96 -> gradeClass = 8
            else -> gradeClass = 9
        }
        list.add(Pair(className, gradeClass))
        println("멈출까요? Y를 입력하고 멈추거나 다른걸 입력하세요.")
        when (readLine()!! == "Y") {
            true -> toStop = true
        }
    }
    for (i in list.indices) {
        sb.append("${list[i].first} : ${list[i].second}등급")
        sb.append("\n")
    }
    print(sb)
}

fun getThing(input : String) : String {
    print("${input}을(를) 입력해주세요 : ")
    val thing = readLine()!!
    when (thing) {
        "" -> getThing(input)
    }
    return thing
}