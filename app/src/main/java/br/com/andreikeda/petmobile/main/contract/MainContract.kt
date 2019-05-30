package br.com.andreikeda.petmobile.main.contract

import android.content.SharedPreferences
import br.com.andreikeda.petmobile.CommonContracts

/**
 * @author cin_alima
 * @since 14/05/19 16:06
 * @version $Revision: $<br/>
 *          $Id: $
 *
 */
interface MainContract {
    interface Interactor {
        fun initialize(pref: SharedPreferences)

        fun loadEnergy(pref: SharedPreferences)

        fun loadFun(pref: SharedPreferences)

        fun loadHunger(pref: SharedPreferences)

        fun loadHygiene(pref: SharedPreferences)

        fun unregister(pref: SharedPreferences)

        fun updateEnergy()

        fun updateFun()

        fun updateHunger()

        fun updateHygiene()

        fun updateLastTimeInMillis(timeInMillis: Long)
    }

    interface InteractorOutput {
        fun notifyViewLowEnergy()

        fun notifyViewLowFun()

        fun notifyViewLowHunger()

        fun notifyViewLowHygiene()

        fun onLoadEnergySuccess(value: Int)

        fun onLoadFunSuccess(value: Int)

        fun onLoadHungerSuccess(value: Int)

        fun onLoadHygieneSuccess(value: Int)
    }

    interface Presenter : CommonContracts.Presenter {
    }

    interface View : CommonContracts.View {
        fun setEnergyText(value: Int)

        fun setFunText(value: Int)

        fun setHungerText(value: Int)

        fun setHygieneText(value: Int)

        fun disposeTimer()

        fun startTimer()
    }
}