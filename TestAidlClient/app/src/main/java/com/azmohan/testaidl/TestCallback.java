/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/azmohan/multimedia/test/TestAidl/app/src/main/aidl/com/azmohan/testaidl/TestCallback.aidl
 */
package com.azmohan.testaidl;

public interface TestCallback extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements com.azmohan.testaidl.TestCallback {
        private static final java.lang.String DESCRIPTOR = "com.azmohan.testaidl.TestCallback";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.azmohan.testaidl.TestCallback interface,
         * generating a proxy if needed.
         */
        public static com.azmohan.testaidl.TestCallback asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.azmohan.testaidl.TestCallback))) {
                return ((com.azmohan.testaidl.TestCallback) iin);
            }
            return new com.azmohan.testaidl.TestCallback.Stub.Proxy(obj);
        }

        @Override
        public android.os.IBinder asBinder() {
            return this;
        }

        @Override
        public boolean onTransact(int code, android.os.Parcel data, android.os.Parcel reply, int flags) throws android.os.RemoteException {
            switch (code) {
                case INTERFACE_TRANSACTION: {
                    reply.writeString(DESCRIPTOR);
                    return true;
                }
                case TRANSACTION_notifyDataChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    android.graphics.Rect _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = android.graphics.Rect.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.notifyDataChanged(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_notifyCustomDataChanged: {
                    data.enforceInterface(DESCRIPTOR);
                    com.azmohan.testaidl.Rectangle _arg0;
                    if ((0 != data.readInt())) {
                        _arg0 = com.azmohan.testaidl.Rectangle.CREATOR.createFromParcel(data);
                    } else {
                        _arg0 = null;
                    }
                    this.notifyCustomDataChanged(_arg0);
                    reply.writeNoException();
                    if ((_arg0 != null)) {
                        reply.writeInt(1);
                        _arg0.writeToParcel(reply, android.os.Parcelable.PARCELABLE_WRITE_RETURN_VALUE);
                    } else {
                        reply.writeInt(0);
                    }
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.azmohan.testaidl.TestCallback {
            private android.os.IBinder mRemote;

            Proxy(android.os.IBinder remote) {
                mRemote = remote;
            }

            @Override
            public android.os.IBinder asBinder() {
                return mRemote;
            }

            public java.lang.String getInterfaceDescriptor() {
                return DESCRIPTOR;
            }

            @Override
            public void notifyDataChanged(android.graphics.Rect rect) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((rect != null)) {
                        _data.writeInt(1);
                        rect.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_notifyDataChanged, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void notifyCustomDataChanged(com.azmohan.testaidl.Rectangle rect) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    if ((rect != null)) {
                        _data.writeInt(1);
                        rect.writeToParcel(_data, 0);
                    } else {
                        _data.writeInt(0);
                    }
                    mRemote.transact(Stub.TRANSACTION_notifyCustomDataChanged, _data, _reply, 0);
                    _reply.readException();
                    if ((0 != _reply.readInt())) {
                        rect.readFromParcel(_reply);
                    }
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_notifyDataChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_notifyCustomDataChanged = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
    }

    public void notifyDataChanged(android.graphics.Rect rect) throws android.os.RemoteException;

    public void notifyCustomDataChanged(com.azmohan.testaidl.Rectangle rect) throws android.os.RemoteException;
}
