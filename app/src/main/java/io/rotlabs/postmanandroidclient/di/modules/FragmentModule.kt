package io.rotlabs.postmanandroidclient.di.modules

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import io.rotlabs.postmanandroidclient.ui.makeRequest.params.ParamsViewModel
import io.rotlabs.postmanandroidclient.utils.ViewModelProviderFactory
import io.rotlabs.postmanandroidclient.utils.error.ErrorHelper
import io.rotlabs.postmanandroidclient.utils.network.ConnectivityChecker
import io.rotlabs.postmanandroidclient.utils.rx.SchedulerProvider

@Module
class FragmentModule {


    @Provides
    fun provideParamsViewModel(
        fragment: Fragment,
        schedulerProvider: SchedulerProvider,
        compositeDisposable: CompositeDisposable,
        errorHelper: ErrorHelper,
        connectivityChecker: ConnectivityChecker
    ): ParamsViewModel {
        return ViewModelProvider(fragment, ViewModelProviderFactory(ParamsViewModel::class) {
            ParamsViewModel(
                schedulerProvider,
                compositeDisposable,
                errorHelper,
                connectivityChecker
            )
        }).get(ParamsViewModel::class.java)
    }
}