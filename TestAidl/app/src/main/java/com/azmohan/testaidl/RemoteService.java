package com.azmohan.testaidl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by azmohan on 17-8-11.
 */

public class RemoteService extends Service {
    List<TestCallback> mCallbackList = new ArrayList<TestCallback>();

    private IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
            Log.i("azmohan", "anInt:" + anInt + ",aLong:" +
                    aLong + ",aBoolean:" + aBoolean + ",aFloat:" + aFloat + ",aDouble:" + aDouble + ",aString:" + aString);

            if (mCallbackList.size() > 0) {
                for (TestCallback callback : mCallbackList) {
                    if (callback != null) {
                        android.graphics.Rect rect = new android.graphics.Rect(1, 2, 3, 4);
                        Log.i("azmohan","notifyDataChanged");
                        callback.notifyDataChanged(rect);
                    }
                }
            }
        }

        @Override
        public void registerCallback(TestCallback callback) throws RemoteException {
            Log.i("azmohan","registerCallback callback:"+callback + ",isContains:"+mCallbackList.contains(callback));
            if (callback != null && !mCallbackList.contains(callback)) {
                Log.i("azmohan","registerCallback");
                mCallbackList.add(callback);
            }
        }

        @Override
        public void unregisterCallback(TestCallback callback) throws RemoteException {
            if (callback != null && mCallbackList.contains(callback)) {
                mCallbackList.remove(callback);
            }
        }
    };

    @Override
    public void onCreate() {
        super.onCreate();
        Log.i("azmohan", "RemoteService onCreate");
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.i("azmohan", "RemoteService onBind");
        return mBinder;
    }
}
