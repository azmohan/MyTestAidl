package droi.com.testaidlclient;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import com.azmohan.testaidl.IMyAidlInterface;
import com.azmohan.testaidl.Rectangle;
import com.azmohan.testaidl.TestCallback;

public class MainActivity extends AppCompatActivity {
    private IMyAidlInterface mRemoteServer;

    private TestCallback mCallback = new TestCallback.Stub() {
        @Override
        public void notifyDataChanged(Rect rect) throws RemoteException {
            Log.i("azmohan", "rect:" + rect.toShortString());
        }

        @Override
        public void notifyCustomDataChanged(Rectangle rect) throws RemoteException {
            Log.i("azmohan", "rectangle : " + rect.toString());
        }
    };

    private ServiceConnection mConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            Log.i("azmohan", "onServiceConnected");
            mRemoteServer = IMyAidlInterface.Stub.asInterface(iBinder);
            Log.i("azmohan", "onServiceConnected mRemoteServer:" + mRemoteServer);
            try {
                mRemoteServer.registerCallback(mCallback);
                mRemoteServer.basicTypes(1, 2, true, 3.0f, 4.0d, "azmohan");
            } catch (RemoteException e) {
                Log.i("azmohan", "RemoteException e:" + e.toString());
                e.printStackTrace();
            }
        }

        @Override
        public void onServiceDisconnected(ComponentName componentName) {
            try {
                mRemoteServer.unregisterCallback(mCallback);
            } catch (RemoteException e) {
                e.printStackTrace();
            }
            mRemoteServer = null;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent("com.azmohan.remoteserver");
                intent.setPackage("com.azmohan.testaidl");
                Log.i("azmohan", "bindService");
                bindService(intent, mConnection, Context.BIND_AUTO_CREATE);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
