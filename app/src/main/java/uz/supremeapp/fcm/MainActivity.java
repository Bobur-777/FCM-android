package uz.supremeapp.fcm;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.iid.InstanceIdResult;

public class MainActivity extends Activity {
    private OnCompleteListener fcm_onCompleteListener;

    @Override
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.main);
        FirebaseApp.initializeApp(this);

        fcm_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
            @Override
            public void onComplete(Task<InstanceIdResult> task) {
                final boolean _success = task.isSuccessful();
                final String _token = task.getResult().getToken();
                final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";

            }
        };
    }

}
