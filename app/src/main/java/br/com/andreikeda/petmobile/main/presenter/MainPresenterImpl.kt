package br.com.andreikeda.petmobile.main.presenter

import br.com.andreikeda.petmobile.main.contract.MainContract

/**
 * @author cin_alima
 * @since 14/05/19 16:07
 * @version $Revision: $<br/>
 *          $Id: $
 *
 */
class MainPresenterImpl(var view: MainContract.View?) : MainContract.Presenter {
    override fun onActivityCreated() {
        view?.initUI()
    }

    override fun onActivityStarted() {
    }

    override fun onActivityResumed() {
    }

    override fun onActivityPaused() {
    }

    override fun unregister() {
        view = null
    }
}