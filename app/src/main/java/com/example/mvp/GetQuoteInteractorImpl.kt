package com.example.mvp

import android.os.Handler
import kotlin.random.Random


class GetQuoteInteractorImpl : MainContract.GetQuoteInteractor {

    private val arrayList = arrayListOf(
        "Be yourself. everyone else is already taken.",
        "Two things are infinite: the universe and human stupidity; and I'm not sure about the universe.",
        "A room without books is like a body without a soul.",
        "You only live once, but if you do it right, once is enough.",
        "Be who you are and say what you feel, because those who mind don't matter, and those who matter don't mind.",
        "If you tell the truth, you don't have to remember anything.",
        "Be the change that you wish to see in the world."

    )

    override fun getNextQuote(onFinishedListener: MainContract.GetQuoteInteractor.OnFinishedListener?) {
        Handler().postDelayed(Runnable { onFinishedListener?.onFinished(getRandomString()) }, 1500)
    }

    private fun getRandomString(): String? {
        val index: Int = Random.nextInt(arrayList.size)
        return arrayList[index]
    }
}