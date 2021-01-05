package com.wrappingwrappers

import android.content.Context
import android.widget.FrameLayout
import com.facebook.react.ReactActivity
import com.facebook.react.bridge.ReadableMap
import com.facebook.react.uimanager.ThemedReactContext

internal class NativeView(context: Context) : FrameLayout(context) {
    init {
        println("NativeView created")
    }

    private var fragment: ExampleFragment? = null
    var info: ReadableMap? = null
        set(value) {
            field = value
            reloadFragment()
        }

    private fun reloadFragment() {
        fragment?.text = info?.getString("title") ?: ""
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        println("NativeView attached to window")

        val context = this.context
        if (context is ThemedReactContext) {
            val activity = context.currentActivity
            if (activity !is ReactActivity) {
                println("no react activity to attach to: $activity")
                return
            }
            // init fragment
            val fragment = ExampleFragment()
            this.fragment = fragment
            reloadFragment()
            // Attach the Fragment to this view
            id = generateViewId()
            activity.supportFragmentManager.beginTransaction()
                    .add(id, fragment)
                    .commitNowAllowingStateLoss()
        }
    }
}