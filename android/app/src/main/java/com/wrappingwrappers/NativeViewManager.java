package com.wrappingwrappers;

import android.view.View;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import androidx.annotation.Nullable;

/// Fur die React!
public class NativeViewManager extends SimpleViewManager<NativeView> {

    public static final String REACT_CLASS = "NativeView";
    ReactApplicationContext callerContext;

    public NativeViewManager(ReactApplicationContext context) {
        callerContext = context;
    }

    @Override
    public String getName() {
        return REACT_CLASS;
    }

    @Override
    public NativeView createViewInstance(ThemedReactContext context) {
        return new NativeView(context);
    }

    @ReactProp(name = "params")
    public void setInfo(NativeView view, @Nullable ReadableMap info) {
        view.setInfo(info);
    }
}