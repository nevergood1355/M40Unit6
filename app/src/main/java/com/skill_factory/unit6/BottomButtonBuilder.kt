package com.skill_factory.unit6

import android.app.Activity
import dagger.BindsInstance

interface BottomButtonBuilder<T> {

    @BindsInstance
    fun activity(activity: Activity): T

    @BindsInstance
    fun bottomButtonConfiguration(bottomButtonConfiguration: BottomButtonConfiguration): T

}