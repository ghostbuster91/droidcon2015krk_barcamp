package pl.ghostbuster.droidconbarcamp;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;

public class FailingFacebookLoginButtonProvider extends EmptyFacebookLoginButtonProvider {
    @Override
    public void addToContainer(ViewGroup container, final FacebookCallback<LoginResult> facebookCallback) {
        Button button = new Button(container.getContext());
        button.setId(R.id.login_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                facebookCallback.onError(new FacebookException("Somethng wrong happened."));

            }
        });
        button.setText("facebook_login_button");
        container.addView(button);
    }
}
