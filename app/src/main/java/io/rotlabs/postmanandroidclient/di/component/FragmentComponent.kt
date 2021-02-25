package io.rotlabs.postmanandroidclient.di.component

import dagger.BindsInstance
import dagger.Component
import io.rotlabs.postmanandroidclient.di.modules.FragmentModule
import io.rotlabs.postmanandroidclient.ui.base.BaseFragment

@Component(
    dependencies = [ApplicationComponent::class],
    modules = [FragmentModule::class]
)
interface FragmentComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun fragment(fragment: BaseFragment<*, *>): Builder
        fun fragmentModule(fragmentModule: FragmentModule): Builder
        fun appComponent(applicationComponent: ApplicationComponent): Builder
        fun build(): FragmentComponent
    }
}