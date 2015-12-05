package pl.ghostbuster.droidconbarcamp;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;

public class FacebookLoginButtonProvider {

    interface SuccessCallback {
        void onSuccess();
    }

    interface ErrorCallback {
        void onError();
    }

    private CallbackManager callbackManager;

    void addToContainer(ViewGroup container, SuccessCallback successCallback, ErrorCallback errorCallback) {
        callbackManager = CallbackManager.Factory.create();
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        LoginButton button = (LoginButton) inflater.inflate(R.layout.facebook_login_button, container, false);
        container.addView(button);
        button.registerCallback(callbackManager, createFacebookCallback(successCallback, errorCallback));
    }

    private FacebookCallback<LoginResult> createFacebookCallback(final SuccessCallback successCallback, final ErrorCallback errorCallback) {
        return new FacebookCallback<LoginResult>() {

            @Override
            public void onSuccess(LoginResult loginResult) {
                successCallback.onSuccess();
            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException e) {
                errorCallback.onError();
            }
        };
    }

    void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
    }
}
