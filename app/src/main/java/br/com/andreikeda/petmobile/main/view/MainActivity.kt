package br.com.andreikeda.petmobile.main.view

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import br.com.andreikeda.petmobile.R
import br.com.andreikeda.petmobile.main.contract.MainContract
import br.com.andreikeda.petmobile.main.presenter.MainPresenterImpl
import kotlinx.android.synthetic.main.activity_main.*

private const val SHARED_PREFERENCES = "PET_MOBILE"

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

    override fun getSharedPrerences(): SharedPreferences {
        return getSharedPreferences(SHARED_PREFERENCES, Context.MODE_PRIVATE)
    }

    override fun initUI() {
        bottom_view.setBackgroundResource(R.color.colorPrimary)
    }

    override fun setEnergyText(value: Int) {
        energy_textview.text = getString(R.string.attr_energy_formatted, value)
    }

    override fun setFunText(value: Int) {
        fun_textview.text = getString(R.string.attr_fun_formatted, value)
    }

    override fun setHungerText(value: Int) {
        hunger_textview.text = getString(R.string.attr_hunger_formatted, value)
    }

    override fun setHygieneText(value: Int) {
        hygiene_textview.text = getString(R.string.attr_hygiene_formatted, value)
    }

    override fun sendNotificationLowEnergy() {
    }

    override fun sendNotificationLowFun() {
    }

    override fun sendNotificationLowHunger() {
    }

    override fun sendNotificationLowHygiene() {
    }
}
