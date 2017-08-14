// TestCallback.aidl
package com.azmohan.testaidl;

// Declare any non-default types here with import statements
import android.graphics.Rect;
import com.azmohan.testaidl.Rectangle;
interface TestCallback {
    void notifyDataChanged(in Rect rect);
    void notifyCustomDataChanged(inout Rectangle rect);
}
