package com.wrappingwrappers;

import android.content.Context;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.annotations.ReactProp;

import androidx.annotation.Nullable;

class NativeView extends LinearLayout {
    public NativeView(Context context) {
        super(context);
        setBackgroundColor(0xFF00FF00);
        TextView tv = new TextView(context);
        tv.setText("Sigue asi!");
        addView(tv, 200, 80);
    }
}

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
        return new NativeView(context);//, Fresco.newDraweeControllerBuilder(), null, callerContext);
    }

//    @ReactProp(name = "src")
//    public void setSrc(NativeView view, @Nullable ReadableMap sources) {
//        view.setSource(sources);
//    }
}