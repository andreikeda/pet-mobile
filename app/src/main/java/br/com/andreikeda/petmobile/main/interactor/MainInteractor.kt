package br.com.andreikeda.petmobile.main.interactor

import android.content.SharedPreferences
import br.com.andreikeda.petmobile.main.contract.MainContract
import java.util.Calendar

/**
 * @author cin_alima
 * @since 15/05/19 09:20
 * @version $Revision: $<br/>
 *          $Id: $
 *
 */
private const val SP_ENERGY = "PREF_ENERGY"
private const val SP_FUN = "PREF_FUN"
private const val SP_HUNGER = "PREF_HUNGER"
private const val SP_HYGIENE = "PREF_HYGIENE"
private const val SP_FIRST_TIME = "PREF_FIRST_TIME"
private const val SP_LAST_TIME = "PREF_LAST_TIME"

private const val AT_DEFAULT = 50

class MainInteractor(var output: MainContract.InteractorOutput?) : MainContract.Interactor {

    private var firstTimeInMillis = 0L
    private var lastTimeInMillis = 0L

    override fun initialize(pref: SharedPreferences) {
        firstTimeInMillis = pref.getLong(SP_FIRST_TIME, Calendar.getInstance().timeInMillis)
        lastTimeInMillis = pref.getLong(SP_LAST_TIME, firstTimeInMillis)
    }

    override fun loadEnergy(pref: SharedPreferences) {
        output?.onLoadEnergySuccess(
            pref
                .getInt(SP_ENERGY, AT_DEFAULT)
        )
    }

    override fun loadFun(pref: SharedPreferences) {
        output?.onLoadFunSuccess(
            pref
                .getInt(SP_FUN, AT_DEFAULT)
        )
    }

    override fun loadHunger(pref: SharedPreferences) {
        output?.onLoadHungerSuccess(
            pref
                .getInt(SP_HUNGER, AT_DEFAULT)
        )
    }

    override fun loadHygiene(pref: SharedPreferences) {
        output?.onLoadHygieneSuccess(
            pref
                .getInt(SP_HYGIENE, AT_DEFAULT)
        )
    }

    override fun updateEnergy() {
    }

    override fun updateFun() {
    }

    override fun updateHunger() {
    }

    override fun updateHygiene() {
    }

    override fun unregister(pref: SharedPreferences) {
        pref
            .edit()
            .putLong(SP_LAST_TIME, lastTimeInMillis)
            .apply()
    }

    override fun updateLastTimeInMillis(timeInMillis: Long) {
        lastTimeInMillis = timeInMillis
    }
}