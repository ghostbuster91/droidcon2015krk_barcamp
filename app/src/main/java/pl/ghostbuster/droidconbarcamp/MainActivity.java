package pl.ghostbuster.droidconbarcamp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

public class MainActivity extends AppCompatActivity {

    static FacebookLoginButtonProvider provider = new FacebookLoginButtonProviderImpl();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        provider.initSdk(getApplicationContext());
        setContentView(R.layout.activity_main);

        final TextView loginResultsView = (TextView) findViewById(R.id.login_result_descritpion);
        final FrameLayout container = (FrameLayout) findViewById(R.id.facebook_button_container);
        provider.addToContainer(container, new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                loginResultsView.setText("Success :)");

            }

            @Override
            public void onCancel() {
                loginResultsView.setText("Canceled.");

            }

            @Override
            public void onError(FacebookException error) {
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
