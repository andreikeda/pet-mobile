package br.com.andreikeda.petmobile.main

import br.com.andreikeda.petmobile.main.contract.MainContract
import br.com.andreikeda.petmobile.main.presenter.MainPresenterImpl
import org.junit.Before
import org.junit.runner.RunWith
import org.junit.runners.JUnit4
import org.mockito.Mock
import org.mockito.Mockito

/**
 * @author cin_alima
 * @since 15/05/19 10:49
 * @version $Revision: $<br/>
 *          $Id: $
 *
 */
@RunWith(JUnit4::class)
class MainUnitTest {

    @Mock
    private lateinit var mView: MainContract.View
    private lateinit var mPresenter: MainContract.Presenter

    @Before
    fun setup() {
        mView = Mockito.mock(MainContract.View::class.java)
        mPresenter = MainPresenterImpl(mView)
    }
}