// TestCallback.aidl
package com.azmohan.testaidl;

// Declare any non-default types here with import statements
import android.graphics.Rect;
interface TestCallback {
    void notifyDataChanged(in Rect rect);
}
