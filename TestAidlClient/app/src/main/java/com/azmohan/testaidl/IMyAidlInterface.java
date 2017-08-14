/*
 * This file is auto-generated.  DO NOT MODIFY.
 * Original file: /home/azmohan/multimedia/TestAidl/app/src/main/aidl/com/azmohan/testaidl/IMyAidlInterface.aidl
 */
package com.azmohan.testaidl;
// Declare any non-default types here with import statements

public interface IMyAidlInterface extends android.os.IInterface {
    /**
     * Local-side IPC implementation stub class.
     */
    public static abstract class Stub extends android.os.Binder implements com.azmohan.testaidl.IMyAidlInterface {
        private static final java.lang.String DESCRIPTOR = "com.azmohan.testaidl.IMyAidlInterface";

        /**
         * Construct the stub at attach it to the interface.
         */
        public Stub() {
            this.attachInterface(this, DESCRIPTOR);
        }

        /**
         * Cast an IBinder object into an com.azmohan.testaidl.IMyAidlInterface interface,
         * generating a proxy if needed.
         */
        public static com.azmohan.testaidl.IMyAidlInterface asInterface(android.os.IBinder obj) {
            if ((obj == null)) {
                return null;
            }
            android.os.IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
            if (((iin != null) && (iin instanceof com.azmohan.testaidl.IMyAidlInterface))) {
                return ((com.azmohan.testaidl.IMyAidlInterface) iin);
            }
            return new com.azmohan.testaidl.IMyAidlInterface.Stub.Proxy(obj);
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
                case TRANSACTION_basicTypes: {
                    data.enforceInterface(DESCRIPTOR);
                    int _arg0;
                    _arg0 = data.readInt();
                    long _arg1;
                    _arg1 = data.readLong();
                    boolean _arg2;
                    _arg2 = (0 != data.readInt());
                    float _arg3;
                    _arg3 = data.readFloat();
                    double _arg4;
                    _arg4 = data.readDouble();
                    java.lang.String _arg5;
                    _arg5 = data.readString();
                    this.basicTypes(_arg0, _arg1, _arg2, _arg3, _arg4, _arg5);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_registerCallback: {
                    data.enforceInterface(DESCRIPTOR);
                    com.azmohan.testaidl.TestCallback _arg0;
                    _arg0 = com.azmohan.testaidl.TestCallback.Stub.asInterface(data.readStrongBinder());
                    this.registerCallback(_arg0);
                    reply.writeNoException();
                    return true;
                }
                case TRANSACTION_unregisterCallback: {
                    data.enforceInterface(DESCRIPTOR);
                    com.azmohan.testaidl.TestCallback _arg0;
                    _arg0 = com.azmohan.testaidl.TestCallback.Stub.asInterface(data.readStrongBinder());
                    this.unregisterCallback(_arg0);
                    reply.writeNoException();
                    return true;
                }
            }
            return super.onTransact(code, data, reply, flags);
        }

        private static class Proxy implements com.azmohan.testaidl.IMyAidlInterface {
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

            /**
             * Demonstrates some basic types that you can use as parameters
             * and return values in AIDL.
             */
            @Override
            public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeInt(anInt);
                    _data.writeLong(aLong);
                    _data.writeInt(((aBoolean) ? (1) : (0)));
                    _data.writeFloat(aFloat);
                    _data.writeDouble(aDouble);
                    _data.writeString(aString);
                    mRemote.transact(Stub.TRANSACTION_basicTypes, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void registerCallback(com.azmohan.testaidl.TestCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((callback != null)) ? (callback.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_registerCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }

            @Override
            public void unregisterCallback(com.azmohan.testaidl.TestCallback callback) throws android.os.RemoteException {
                android.os.Parcel _data = android.os.Parcel.obtain();
                android.os.Parcel _reply = android.os.Parcel.obtain();
                try {
                    _data.writeInterfaceToken(DESCRIPTOR);
                    _data.writeStrongBinder((((callback != null)) ? (callback.asBinder()) : (null)));
                    mRemote.transact(Stub.TRANSACTION_unregisterCallback, _data, _reply, 0);
                    _reply.readException();
                } finally {
                    _reply.recycle();
                    _data.recycle();
                }
            }
        }

        static final int TRANSACTION_basicTypes = (android.os.IBinder.FIRST_CALL_TRANSACTION + 0);
        static final int TRANSACTION_registerCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 1);
        static final int TRANSACTION_unregisterCallback = (android.os.IBinder.FIRST_CALL_TRANSACTION + 2);
    }

    /**
     * Demonstrates some basic types that you can use as parameters
     * and return values in AIDL.
     */
    public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, java.lang.String aString) throws android.os.RemoteException;

    public void registerCallback(com.azmohan.testaidl.TestCallback callback) throws android.os.RemoteException;

    public void unregisterCallback(com.azmohan.testaidl.TestCallback callback) throws android.os.RemoteException;
}
