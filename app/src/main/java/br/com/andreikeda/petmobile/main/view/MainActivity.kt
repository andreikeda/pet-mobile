package br.com.andreikeda.petmobile.main.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andreikeda.petmobile.R
import br.com.andreikeda.petmobile.main.contract.MainContract
import br.com.andreikeda.petmobile.main.presenter.MainPresenterImpl

class MainActivity : AppCompatActivity(), MainContract.View {

    private var mPresenter: MainContract.Presenter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mPresenter = MainPresenterImpl(this)
        mPresenter?.onActivityCreated()
    }

    override fun onStart() {
        super.onStart()

        mPresenter?.onActivityStarted()
    }

    override fun onResume() {
        super.onResume()

        mPresenter?.onActivityResumed()
    }

    override fun onPause() {
        mPresenter?.onActivityPaused()

        super.onPause()
    }

    override fun onStop() {
        mPresenter?.unregister()

        super.onStop()
    }

    override fun initUI() {
    }
}
