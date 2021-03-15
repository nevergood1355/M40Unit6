package com.skill_factory.unit6

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import javax.inject.Scope

@Scope
@Retention(AnnotationRetention.RUNTIME)
annotation class FlowScope

interface Screen1Injector {
    val screen1Component: Screen1Component.Builder

}

interface Screen2Injector {
    val screen2Component: Screen2Component.Builder
}


@FlowScope
@Component
interface FlowComponent : Screen1Injector, Screen2Injector {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: Application): FlowComponent
    }
}
