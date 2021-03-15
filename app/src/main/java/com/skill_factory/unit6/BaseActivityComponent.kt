package com.skill_factory.unit6

interface BaseActivityComponent {
    fun getActivityDelegates(): Set<ActivityDelegate>
}