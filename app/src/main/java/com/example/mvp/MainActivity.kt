package com.example.mvp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import butterknife.OnClick

class MainActivity : AppCompatActivity(), MainContract.MainView {

    @BindView(R.id.textView)
    lateinit var text: TextView
    @BindView(R.id.progressBar)
    lateinit var progressBar: ProgressBar
    //    private lateinit var button: Button
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        ButterKnife.bind(this)
        presenter = MainPresenterImpl(this, GetQuoteInteractorImpl())
//        button = findViewById(R.id.button)
//        button.setOnClickListener {
//            presenter.onButtonClick()
//        }
    }

    @OnClick(R.id.button)
    fun click() {
        presenter.onButtonClick()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun showProgress() {
        progressBar.visibility = View.VISIBLE
        text.visibility = View.INVISIBLE
    }

    override fun hideProgress() {
        progressBar.visibility = View.GONE
        text.visibility = View.VISIBLE
    }

    override fun setQuote(string: String?) {
        text.text = string
    }
}
