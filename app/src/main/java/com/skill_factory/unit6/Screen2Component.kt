package com.skill_factory.unit6

import dagger.Binds
import dagger.Module
import dagger.Subcomponent
import javax.inject.Inject

@ActivityScope
@Subcomponent(modules = [Screen2Module::class, BottomButtonModule::class])
interface Screen2Component : BaseActivityComponent {
    fun inject(activity: Screen2)

    @Subcomponent.Builder
    interface Builder : BottomButtonBuilder<Builder> {
        fun build(): Screen2Component
    }
}

@Module
internal abstract class Screen2Module {

    @Binds
    @ActivityScope
    abstract fun bindPresenter(presenter: Screen2Presenter) : BasePresenter

}

class Screen2Presenter @Inject constructor(private val bottomButton: BottomButtonView) : BasePresenter {

    override fun attachView() {
        bottomButton.setLabelText("BottomButton2")
        bottomButton.setButtonText("Lock")
    }

    override fun detachView() {

    }
}