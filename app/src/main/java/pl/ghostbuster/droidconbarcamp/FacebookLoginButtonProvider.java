package pl.ghostbuster.droidconbarcamp;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

public interface FacebookLoginButtonProvider {

    void initSdk(Context context);

    void addToContainer(ViewGroup container, FacebookCallback<LoginResult> facebookCallback);

    void onActivityResult(int requestCode, int resultCode, Intent data);
}
