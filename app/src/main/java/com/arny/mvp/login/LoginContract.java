package com.arny.mvp.login;

import android.support.annotation.StringRes;

/**
 * Created by i.sedoy on 10.04.17.
 */

public class LoginContract {
    public interface View{
        String getLogin();

        void setErrorEmptyLoginMessage(@StringRes int resId);

        String getPassword();

        void setErrorEmptyPassMessage(@StringRes int resId);

        void startMainActivity();

        void showLoginFailError();
    }

}
