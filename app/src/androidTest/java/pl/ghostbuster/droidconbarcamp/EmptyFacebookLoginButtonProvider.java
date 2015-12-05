package pl.ghostbuster.droidconbarcamp;

import android.content.Context;
import android.content.Intent;
import android.view.ViewGroup;

import com.facebook.FacebookCallback;
import com.facebook.login.LoginResult;

abstract class EmptyFacebookLoginButtonProvider implements FacebookLoginButtonProvider {
    @Override
    public void initSdk(Context context) {
    }

    @Override
    abstract public void addToContainer(ViewGroup container, FacebookCallback<LoginResult> facebookCallback);

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
    }
}
