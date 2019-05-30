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
private const val SP_IS_SICK = "PREF_IS_SICK"
private const val SP_FIRST_TIME = "PREF_FIRST_TIME"
private const val SP_LAST_TIME = "PREF_LAST_TIME"

private const val SICKNESS_DEFAULT = false
private const val AT_DEFAULT = 50
private const val MIN_NOTIFICATION_VALUE = 10

class MainInteractor(var output: MainContract.InteractorOutput?) : MainContract.Interactor {

    private var firstTimeInMillis = 0L
    private var lastTimeInMillis = 0L

    private var mEnergy = 0
    private var mFun = 0
    private var mHunger = 0
    private var mHygiene = 0
    private var mIsSick = false

    override fun initialize(pref: SharedPreferences) {
        firstTimeInMillis = pref.getLong(SP_FIRST_TIME, Calendar.getInstance().timeInMillis)
        lastTimeInMillis = pref.getLong(SP_LAST_TIME, firstTimeInMillis)
    }

    override fun loadEnergy(pref: SharedPreferences) {
        mEnergy = getEnergy(pref)
        output?.onLoadEnergySuccess(
            mEnergy
        )
    }

    override fun loadFun(pref: SharedPreferences) {
        mFun = getFun(pref)
        output?.onLoadFunSuccess(
            mFun
        )
    }

    override fun loadHunger(pref: SharedPreferences) {
        mHunger = getHunger(pref)
        output?.onLoadHungerSuccess(
            mHunger
        )
    }

    override fun loadHygiene(pref: SharedPreferences) {
        mHygiene = getHygiene(pref)
        output?.onLoadHygieneSuccess(
            mHygiene
        )
    }

    override fun updateEnergy() {
        val diff = ((Calendar.getInstance().timeInMillis - lastTimeInMillis) % 1000).toInt()
        mEnergy -= diff
        if (mEnergy <= MIN_NOTIFICATION_VALUE) {
            output?.notifyViewLowEnergy()

            if (!mIsSick) {

            }
        }
        output?.onLoadEnergySuccess(mEnergy)
    }

    override fun updateFun() {
        val diff = ((Calendar.getInstance().timeInMillis - lastTimeInMillis) % 1000).toInt()
        mFun -= diff
        if (mFun <= MIN_NOTIFICATION_VALUE) {
            output?.notifyViewLowFun()

            if (!mIsSick) {

            }
        }
        output?.onLoadFunSuccess(mFun)
    }

    override fun updateHunger() {
        val diff = ((Calendar.getInstance().timeInMillis - lastTimeInMillis) % 1000).toInt()
        mHunger -= diff
        if (mFun <= MIN_NOTIFICATION_VALUE) {
            output?.notifyViewLowHunger()

            if (!mIsSick) {

            }
        }
        output?.onLoadHungerSuccess(mHunger)
    }

    override fun updateHygiene() {
        val diff = ((Calendar.getInstance().timeInMillis - lastTimeInMillis) % 1000).toInt()
        mHygiene -= diff
        if (mHygiene <= MIN_NOTIFICATION_VALUE) {
            output?.notifyViewLowHygiene()

            if (!mIsSick) {

            }
        }
        output?.onLoadHygieneSuccess(mHygiene)
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

    private fun getEnergy(pref: SharedPreferences): Int {
        return pref
            .getInt(SP_ENERGY, AT_DEFAULT)
    }

    private fun getFun(pref: SharedPreferences): Int {
        return pref
            .getInt(SP_FUN, AT_DEFAULT)
    }

    private fun getHunger(pref: SharedPreferences): Int {
        return pref
            .getInt(SP_HUNGER, AT_DEFAULT)
    }

    private fun getHygiene(pref: SharedPreferences): Int {
        return pref
            .getInt(SP_HYGIENE, AT_DEFAULT)
    }

    private fun getIsSick(pref: SharedPreferences): Boolean {
        return pref
            .getBoolean(SP_IS_SICK, SICKNESS_DEFAULT)
    }
}