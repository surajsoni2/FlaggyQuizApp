package com.example.flaggyquiz

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS: String = "correct_answers"

    fun getQuestions():ArrayList<Question>{
        val questionsList = ArrayList<Question>()
        //1
        val que1 = Question(
            1, "What country does this flag belong to?",
            R.drawable.india,
            "India", "Russia", "China", "Japan",
            1
        )
        questionsList.add(que1)

        //2
        val que2= Question(
            1, "What country does this flag belong to?",
            R.drawable.australia,
            "India", "Russia", "Australia", "Japan",
            3
        )
        questionsList.add(que2)

        //3
        val que3= Question(
            1, "What country does this flag belong to?",
            R.drawable.bangladesh,
            "India", "Bangladesh", "China", "Japan",
            2
        )
        questionsList.add(que3)

        //4
        val que4 = Question(
            1, "What country does this flag belong to?",
            R.drawable.srilanka,
            "India", "Sri Lanka", "China", "Japan",
            2
        )
        questionsList.add(que4)

        //5
        val que5= Question(
            1, "What country does this flag belong to?",
            R.drawable.china,
            "India", "Russia", "China", "Japan",
            3
        )
        questionsList.add(que5)

        //6
        val que6= Question(
            1, "What country does this flag belong to?",
            R.drawable.japan,
            "India", "Russia", "China", "Japan",
            4
        )
        questionsList.add(que6)

        //7
        val que7= Question(
            1, "What country does this flag belong to?",
            R.drawable.south_korea,
            "South Korea", "Russia", "China", "Japan",
            1
        )
        questionsList.add(que7)

        //8
        val que8= Question(
            1, "What country does this flag belong to?",
            R.drawable.usa,
            "USA", "Russia", "China", "Japan",
            1
        )
        questionsList.add(que8)
        //9
        val que9= Question(
            1, "What country does this flag belong to?",
            R.drawable.russia,
            "Australia", "Russia", "China", "NewZealand",
            2
        )
        questionsList.add(que9)

        //10
        val que10= Question(
            1, "What country does this flag belong to?",
            R.drawable.nepal,
            "Australia", "Bhutan", "China", "Nepal",
            4
        )
        questionsList.add(que10)

        return questionsList
    }
}