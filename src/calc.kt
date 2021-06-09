import kotlin.text.StringBuilder
import kotlin.math.roundToInt

fun main() {
    val list = mutableListOf<Pair<String, Int>>() // 과목 결과 리스트 만들기
    var toStop = false // 반복문 중단 불린
    val sb = StringBuilder() // 스트링 빌더 선언
    while (!toStop) { // 반복문
        val className = getThing("과목명") // 과목명 입력
        val learners = getThing("수강자 수").toInt() // 수강자 수 입력
        var placement = getThing("석차").toDouble() // 석차 입력
        val samePlaces = getThing("동석차 수").toInt() // 동석차 수 입력
        when (samePlaces != 0) {
            true -> placement += (samePlaces - 1).toDouble() / 2 // 동석차 수가 0이 아닐 경우 중간 순위 계산 공식 사용
        }
        val cutline = mutableListOf(4.0, 11.0, 23.0, 40.0, 60.0, 77.0, 89.0, 96.0) // 등급 커트라인 기준표
        for (i in cutline.indices) {
            cutline[i] = cutline[i] * learners / 100 // 커트라인 기준을 석차로 변경
            cutline[i].roundToInt() // 커트라인 반올림
        }
        val gradeClass = when {
            placement <= cutline[0] -> 1 // 1등급
            placement <= cutline[1] -> 2 // 2등급
            placement <= cutline[2] -> 3 // 3등급
            placement <= cutline[3] -> 4 // 4등급
            placement <= cutline[4] -> 5 // 5등급
            placement <= cutline[5] -> 6 // 6등급
            placement <= cutline[6] -> 7 // 7등급
            placement <= cutline[7] -> 8 // 8등급
            else -> 9 // 9등급
        }
        list.add(Pair(className, gradeClass)) // 과목명과 등급을 Pair 자료형을 리스트에 추가한다.
        print("멈추려면 Y를 입력해주세요 : ")
        when (readLine()!! == "Y") {
            true -> toStop = true // "Y"가 입력되면 toStop 변수를 true로 바꾸어 반복을 멈춘다.
        }
    } // 반복문 종료
    for (i in list.indices) { // 리스트 전체
        sb.append("${list[i].first} : ${list[i].second}등급") // "{과목명} : {등급 변수}등급" 스트링 빌더에 추가
        sb.append("\n") // 줄바꿈
    }
    print("\n") // 줄바꿈
    println(sb) // 스트링 빌더 출력
    print("Enter 키를 눌러주세요. ")
    readLine() // 프로그램 중단을 막음
}

fun getThing(input : String) : String { // 입력 함수, 파라미터 input을 넣어 출력 후 입력받은 값을 리턴한다.
    print("${input}을(를) 입력해주세요 : ") // 파라미터 input을 넣어 출력
    val thing = readLine()!! // 입력받기
    when (thing) {
        "" -> getThing(input) // 입력받은 값이 ""일 경우 다시 한다.
    }
    return thing // 입력값을 리턴한다.
}