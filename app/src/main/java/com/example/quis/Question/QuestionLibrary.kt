package com.example.quis.Question

class QuestionLibrary {
    private val mQuestion = arrayOf(
        "Jaringan Komputer yang cakupannya lokal yaitu ...",
        "Pendiri Microsoft adalah .....",
        "Ibu Kota Indonesia yaitu ....",
        "Keadilan bagi seluruh rakyat indonesia adalah sila ke ...",
        "Indonesia berada di benua .....",
        "Presiden pertama indonesia adalah ....."
    )
    private val mChoice = arrayOf(
        arrayOf("LAN", "MAN", "WAN"),
        arrayOf("Bill Gates", "Larry Page", "Steve Jobs"),
        arrayOf("Bandung", "Jakarta", "Surabaya"),
        arrayOf("Sila ke 1", "Sila ke 4", "Sila ke 5"),
        arrayOf("Amerika", "Eropa", "Asia"),
        arrayOf("Soekarno", " BJ Habibie", "Soeharto")
    )
    private val mCorrectAnswer =
        arrayOf("LAN", "Bill Gates", "Jakarta", "Sila ke 5", "Asia", "Soekarno")

    fun getQuestion(a: Int): String {
        return mQuestion[a]
    }

    fun getChoice1(a: Int): String {
        return mChoice[a][0]
    }

    fun getChoice2(a: Int): String {
        return mChoice[a][1]
    }

    fun getChoice3(a: Int): String {
        return mChoice[a][2]
    }

    fun getCorrection(a: Int): String {
        return mCorrectAnswer[a]
    }

    fun getLength(): Int {
        return mQuestion.size
    }
}