package com.skill_factory.unit6

import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoSet
import javax.inject.Qualifier


@Module
interface BottomButtonModule {

    @Binds
    @ActivityScope
    fun bindBottomButtonView(bottomButtonActivityDelegate: BottomButtonActivityDelegate): BottomButtonView



    @Binds
    @IntoSet
    @ActivityScope
    fun bindBottomButtonActivityDelegate(activityDelegate: BottomButtonActivityDelegate): ActivityDelegate

}