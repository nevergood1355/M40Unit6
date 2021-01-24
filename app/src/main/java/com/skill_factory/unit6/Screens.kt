package com.skill_factory.unit6

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MyApp : Application() {
    val flowComponent = DaggerFlowComponent.factory().create(this)
}

class Screen1 : AppCompatActivity() {

    @Inject
    lateinit var screen1Presenter: Screen1Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myApp = (application as MyApp)
        val screen1Component = myApp.flowComponent.screen1Component
                .activity(this)
                .bottomButtonConfiguration(BottomButtonConfiguration(R.id.button, R.id.header)).build()

        setContentView(R.layout.screen)

        screen1Component.getActivityDelegates().forEach { delegate ->
            delegate.onCreate()
        }
        screen1Component.inject(this)
        screen1Presenter.attachView()
    }

    override fun onResume() {
        super.onResume()
        screen1Presenter.attachView()
    }

    override fun onPause() {
        super.onPause()
        screen1Presenter.detachView()
    }
}


class Screen2 : AppCompatActivity() {

    @Inject
    lateinit var screen2Presenter: Screen2Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val myApp = (application as MyApp)
        val screen2Component = myApp.flowComponent.screen2Component
                .activity(this)
                .bottomButtonConfiguration(BottomButtonConfiguration(R.id.button, R.id.header)).build()

        setContentView(R.layout.screen)

        screen2Component.getActivityDelegates().forEach { delegate ->
            delegate.onCreate()
        }
        screen2Component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        screen2Presenter.attachView()
    }

    override fun onPause() {
        super.onPause()
        screen2Presenter.detachView()
    }

}