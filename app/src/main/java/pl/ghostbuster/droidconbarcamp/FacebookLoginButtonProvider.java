package pl.ghostbuster.droidconbarcamp;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

public interface FacebookLoginButtonProvider {

    interface SuccessCallback {
        void onSuccess();
    }

    interface ErrorCallback {
        void onError();
    }

    void initSdk(Context context);

    FacebookCallback<LoginResult> createFacebookCallback(final SuccessCallback successCallback, final ErrorCallback errorCallback);

    void addToContainer(ViewGroup container, FacebookLoginButtonProvider.SuccessCallback successCallback, FacebookLoginButtonProvider.ErrorCallback errorCallback);

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
