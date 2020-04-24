package com.example.mvp

import com.example.mvp.MainContract.GetQuoteInteractor
import com.example.mvp.MainContract.MainView

class MainPresenterImpl(
    mainView: MainContract.MainView,
    getQuoteInteractor: MainContract.GetQuoteInteractor
) : MainContract.Presenter, MainContract.GetQuoteInteractor.OnFinishedListener {

    private var mainView: MainView? = null
    private var getQuoteInteractor: GetQuoteInteractor? = null

    init {
        this.mainView = mainView
        this.getQuoteInteractor = getQuoteInteractor
    }

    override fun onFinished(string: String?) {
        if (mainView != null) {
            mainView!!.setQuote(string)
            mainView!!.hideProgress()
        }
    }

    override fun onButtonClick() {
        if (mainView != null) {
            mainView!!.showProgress()
        }
        getQuoteInteractor?.getNextQuote(this)
    }

    override fun onDestroy() {
        mainView = null
    }
}