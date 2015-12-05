package pl.ghostbuster.droidconbarcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.FacebookSdk;

public class MainActivity extends AppCompatActivity {

    private FacebookLoginButtonProvider provider = new FacebookLoginButtonProvider();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FacebookSdk.sdkInitialize(getApplicationContext());
        setContentView(R.layout.activity_main);

        final TextView loginResultsView = (TextView) findViewById(R.id.login_result_descritpion);
        final FrameLayout container = (FrameLayout) findViewById(R.id.facebook_button_container);
        provider.addToContainer(container, new FacebookLoginButtonProvider.SuccessCallback() {
            @Override
            public void onSuccess() {
                loginResultsView.setText("Success :)");
            }
        }, new FacebookLoginButtonProvider.ErrorCallback() {
            @Override
            public void onError() {
                loginResultsView.setText("Error :(");
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        provider.onActivityResult(requestCode, resultCode, data);
    }
}
