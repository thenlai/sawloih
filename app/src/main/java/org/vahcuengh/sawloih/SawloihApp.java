package org.vahcuengh.sawloih;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.IBinder;
import android.view.inputmethod.InputMethodManager;

public class SawloihApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }

    public static void hideKeyboard(Activity activity) {
        InputMethodManager inputManager = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
        try {
            IBinder ib = activity.getCurrentFocus().getWindowToken();
            inputManager.hideSoftInputFromWindow(ib, InputMethodManager.HIDE_NOT_ALWAYS);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
