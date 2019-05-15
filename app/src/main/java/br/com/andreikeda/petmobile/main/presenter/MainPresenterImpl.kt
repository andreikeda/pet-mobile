package br.com.andreikeda.petmobile.main.presenter

import br.com.andreikeda.petmobile.main.contract.MainContract
import br.com.andreikeda.petmobile.main.interactor.MainInteractor
import java.util.Calendar

/**
 * @author cin_alima
 * @since 14/05/19 16:07
 * @version $Revision: $<br/>
 *          $Id: $
 *
 */
class MainPresenterImpl(var view: MainContract.View?) : MainContract.Presenter,
    MainContract.InteractorOutput {

    private var interactor: MainContract.Interactor? = MainInteractor(this)

    override fun notifyViewLowEnergy() {
        view?.apply { }
    }

    override fun notifyViewLowFun() {
        view?.apply { }
    }

    override fun notifyViewLowHunger() {
        view?.apply { }
    }

    override fun notifyViewLowHygiene() {
        view?.apply { }
    }

    override fun onLoadEnergySuccess(value: Int) {
        view?.apply {
            setEnergyText(value)
        }
    }

    override fun onLoadFunSuccess(value: Int) {
        view?.apply {
            setFunText(value)
        }
    }

    override fun onLoadHungerSuccess(value: Int) {
        view?.apply {
            setHungerText(value)
        }
    }

    override fun onLoadHygieneSuccess(value: Int) {
        view?.apply {
            setHygieneText(value)
        }
    }

    override fun onActivityCreated() {
        view?.apply {
            initUI()
        }
        view?.getSharedPrerences()?.let { sharedPreferences ->
            interactor?.apply {
                initialize(sharedPreferences)
            }
        }
    }

    override fun onActivityStarted() {
        view?.getSharedPrerences()?.let { sharedPreferences ->
            interactor?.apply {
                initialize(sharedPreferences)
                loadEnergy(sharedPreferences)
                loadFun(sharedPreferences)
                loadHunger(sharedPreferences)
                loadHygiene(sharedPreferences)
            }
        }
    }

    override fun onActivityResumed() {
        interactor?.apply {
            updateLastTimeInMillis(Calendar.getInstance().timeInMillis)
            updateEnergy()
            updateFun()
            updateHunger()
            updateHygiene()
        }
    }

    override fun onActivityPaused() {
    }

    override fun unregister() {
        view?.getSharedPrerences()?.let { pref ->
            interactor?.unregister(pref)
        }

        interactor = null
        view = null
    }
}