package com.skill_factory.unit6

import android.app.Activity
import android.app.Application
import android.content.Intent
import dagger.*
import javax.inject.Inject
import javax.inject.Scope


@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class ActivityScope

@ActivityScope
@Subcomponent(modules = [Screen1Module::class, BottomButtonModule::class])
interface Screen1Component : BaseActivityComponent {
    fun inject(activity: Screen1)

    @Subcomponent.Builder
    interface Builder : BottomButtonBuilder<Builder> {
        fun build(): Screen1Component
    }
}

@Module
abstract class Screen1Module {

    @Binds
    @ActivityScope
    abstract fun bindPresenter(presenter: Screen1Presenter) : BasePresenter
}

class Screen1Presenter @Inject constructor(private val bottomButton: BottomButtonView, private val activity: Activity) : BasePresenter {

    override fun attachView() {
        bottomButton.setLabelText("BottomButton1")
        bottomButton.setButtonText("Next")
        bottomButton.setOnClickListener {
            activity.startActivity(Intent(activity, Screen2::class.java))
        }
    }



    override fun detachView() {

    }
}