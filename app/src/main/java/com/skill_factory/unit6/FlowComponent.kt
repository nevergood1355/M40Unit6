package com.skill_factory.unit6

import android.app.Application
import dagger.BindsInstance
import dagger.Component

interface Screen1Injector {
    val screen1Component: Screen1Component.Builder

}

interface Screen2Injector {
    val screen2Component: Screen2Component.Builder
}

@Component
interface FlowComponent : Screen1Injector, Screen2Injector {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): FlowComponent
    }
}
