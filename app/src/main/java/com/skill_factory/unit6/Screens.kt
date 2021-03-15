package com.skill_factory.unit6

import android.app.Application
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class MyApp : Application() {
    companion object {
        private var flowComponent: FlowComponent? = null
    }

    fun getFlowComponent(): FlowComponent {
        return flowComponent ?: DaggerFlowComponent.factory().create(this).also {
            flowComponent = it
        }
    }

    fun releaseFlow() {
        flowComponent = null
    }

}

class Screen1 : AppCompatActivity() {
    @Inject
    lateinit var screen1Presenter: Screen1Presenter
    val app = application as MyApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val screen1Component = app.getFlowComponent().screen1Component
                .activity(this)
                .bottomButtonConfiguration(BottomButtonConfiguration(R.id.button, R.id.header)).build()

        setContentView(R.layout.screen)

        screen1Component.getActivityDelegates().forEach { delegate ->
            delegate.onCreate()
        }
        screen1Component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        screen1Presenter.attachView()

    }

    override fun onPause() {
        super.onPause()
        screen1Presenter.detachView()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        app.releaseFlow()
    }
}


class Screen2 : AppCompatActivity() {

    @Inject
    lateinit var screen2Presenter: Screen2Presenter
    val app = application as MyApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val screen2Component = app.getFlowComponent().screen2Component
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

