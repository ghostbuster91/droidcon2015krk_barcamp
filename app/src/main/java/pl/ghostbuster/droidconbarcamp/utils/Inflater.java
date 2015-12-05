package pl.ghostbuster.droidconbarcamp.utils;

import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Inflater {

    static public View inflate(ViewGroup container, @LayoutRes int layoutRes) {
        LayoutInflater inflater = LayoutInflater.from(container.getContext());
        return inflater.inflate(layoutRes, container, false);
    }
}
