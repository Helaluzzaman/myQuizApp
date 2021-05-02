package com.learning.myquizapp

object QuestionsList{

    fun getQuestions(): ArrayList<question>{
        val questionsList = ArrayList<question>() // it is important to be here.
        val qt1 = question(
                id = 1,
                question = "What country does this flag belongs to?",
                image = R.drawable.fi,
                optionOne = "England",
                optionTwo = "Argentina",
                optionThree = "Finland",
                optionFour = "Honduras",
                answer = 3
        )
        questionsList.add(qt1)

        val qt2 = question(
                id = 2,
                question = "What country does this flag belongs to?",
                image = R.drawable.cn,
                optionOne = "England",
                optionTwo = "Turkey",
                optionThree = "China",
                optionFour = "Honduras",
                answer = 3
        )
        questionsList.add(qt2)

        val qt3 = question(
            id = 3,
            question = "What country does this flag belongs to?",
            image = R.drawable.bd,
            optionOne = "England",
            optionTwo = "Bangladesh",
            optionThree = "Japan",
            optionFour = "Bhutan",
                answer = 2
        )
        questionsList.add(qt3)

        val qt4 = question(
            id = 4,
            question = "What country does this flag belongs to?",
            image = R.drawable.tr,
            optionOne = "Turkey",
            optionTwo = "China",
            optionThree = "France",
            optionFour = "Chili",
            answer = 1
        )
        questionsList.add(qt4)

        val qt5 = question(
                id = 5,
                question = "What country does this flag belongs to?",
                image = R.drawable.mv,
                optionOne = "Bhutan",
                optionTwo = "Chad",
                optionThree = "Myanmar",
                optionFour = "Maldive",
                answer = 4
        )
        questionsList.add(qt5)

        val qt6 = question(
                id = 6,
                question = "What country does this flag belongs to?",
                image = R.drawable.jp,
                optionOne = "Chili",
                optionTwo = "Japan",
                optionThree = "Myanmar",
                optionFour = "England",
                answer = 2
        )
        questionsList.add(qt6)

        val qt7 = question(
                id = 7,
                question = "What country does this flag belongs to?",
                image = R.drawable.ar,
                optionOne = "Brazil",
                optionTwo = "Australia",
                optionThree = "Argentina",
                optionFour = "Austria",
                answer = 3
        )
        questionsList.add(qt7)

        val qt8 = question(
                id = 8,
                question = "What country does this flag belongs to?",
                image = R.drawable.ir,
                optionOne = "Iraq",
                optionTwo = "Iran",
                optionThree = "India",
                optionFour = "Italy",
                answer = 2
        )
        questionsList.add(qt8)

        val qt9 = question(
                id = 9,
                question = "What country does this flag belongs to?",
                image = R.drawable.ps,
                optionOne = "Lebanon",
                optionTwo = "South Africa",
                optionThree = "Palestine",
                optionFour = "Maldive",
                answer = 3
        )
        questionsList.add(qt9)

        val qt10 = question(
                id = 10,
                question = "What country does this flag belongs to?",
                image = R.drawable.ru,
                optionOne = "Austria",
                optionTwo = "France",
                optionThree = "Russia",
                optionFour = "Italy",
                answer = 3
        )
        questionsList.add(qt10)



        return questionsList
    }

}