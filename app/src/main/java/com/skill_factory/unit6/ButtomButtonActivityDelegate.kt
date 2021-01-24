package com.skill_factory.unit6

import android.app.Activity
import android.content.Intent
import android.widget.Button
import android.widget.TextView
import javax.inject.Inject
import kotlin.reflect.KClass

interface BottomButtonView : ActivityDelegate {
    fun setLabelText(text: String)
    fun setButtonText(text: String)
    fun setTarget(target: Class<*>)
}

data class BottomButtonConfiguration(val bottomButtonId: Int?, val labelId: Int? = null)

@ActivityScope
class BottomButtonActivityDelegate @Inject constructor(private val bottomButtonConfiguration: BottomButtonConfiguration, private val activity: Activity) : BottomButtonView {
    private var button: Button? = null
    private var label: TextView? = null

    override fun onCreate() {
        button = bottomButtonConfiguration.bottomButtonId?.let { activity.findViewById(it) }
        label = bottomButtonConfiguration.labelId?.let(activity::findViewById)
    }

    override fun setLabelText(text: String) {
        label?.text = text
    }

    override fun setButtonText(text: String) {
        button?.text = text
    }

    override fun setTarget(target: Class<*>) {
        button?.setOnClickListener {
            activity.startActivity(Intent(activity, target))
        }
    }

}