package pl.ghostbuster.droidconbarcamp;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookSdk;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLoginButtonProviderImpl implements FacebookLoginButtonProvider {

    private CallbackManager callbackManager;

    public void initSdk(Context context) {
        FacebookSdk.sdkInitialize(context);
    }

    public void addToContainer(ViewGroup container, FacebookCallback<LoginResult> facebookCallback) {
        callbackManager = CallbackManager.Factory.create();
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        LoginButton button = (LoginButton) inflater.inflate(R.layout.facebook_login_button, container, false);
        container.addView(button);
        button.registerCallback(callbackManager, facebookCallback);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
