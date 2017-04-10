package com.arny.mvp.login;

import com.arny.mvp.R;

/**
 * Created by i.sedoy on 10.04.17.
 */

class LoginPresenter {
    private final LoginContract.View view;
    private final LoginAPI loginAPI;

    public LoginPresenter(LoginContract.View view, LoginAPI loginAPI) {

        this.view = view;
        this.loginAPI = loginAPI;
    }

    public void onLoginButtonClick() {
        String login = view.getLogin();
        if (login.isEmpty()) {
            view.setErrorEmptyLoginMessage(R.string.empty_login);
            return;
        }

        String pass = view.getPassword();
        if (pass.isEmpty()) {
            view.setErrorEmptyPassMessage(R.string.empty_pass);
            return;
        }

        if (loginAPI.authSuccess(login, pass)) {
            view.startMainActivity();
            return;
        }
        view.showLoginFailError();
    }
}
