package br.com.andreikeda.petmobile

import android.content.SharedPreferences

/**
 * @author cin_alima
 * @since 14/05/19 16:15
 * @version $Revision: $<br/>
 *          $Id: $
 *
 */
interface CommonContracts {
    interface Presenter {
        fun onActivityCreated()

        fun onActivityStarted()

        fun onActivityResumed()

        fun onActivityPaused()

        fun unregister()
    }

    interface View {
        fun getSharedPrerences(): SharedPreferences

        fun initUI()

        fun sendNotificationLowEnergy()

        fun sendNotificationLowFun()

        fun sendNotificationLowHunger()

        fun sendNotificationLowHygiene()
    }
}