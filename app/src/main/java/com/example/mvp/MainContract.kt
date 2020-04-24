package com.example.mvp

interface MainContract {
    interface MainView {
        fun showProgress()
        fun hideProgress()
        fun setQuote(string: String?)
    }

     interface GetQuoteInteractor {
        interface OnFinishedListener {
            fun onFinished(string: String?)
        }

        fun getNextQuote(onFinishedListener: OnFinishedListener?)
    }

     interface Presenter {
        fun onButtonClick()
        fun onDestroy()
    }
}