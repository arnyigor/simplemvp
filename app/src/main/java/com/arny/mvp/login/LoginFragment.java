package com.arny.mvp.login;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.arny.mvp.home.MainActivity;
import com.arny.mvp.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment implements View.OnClickListener,LoginContract.View {
    private EditText mEditLogin;
    private EditText mEditPassword;
    private Button mButtonLogin;
    private Context context;
    private LoginPresenter mLoginPresenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.context = container.getContext();
        mEditLogin = (EditText) view.findViewById(R.id.edtLogin);
        mEditPassword = (EditText) view.findViewById(R.id.edtPassword);
        mButtonLogin = (Button) view.findViewById(R.id.btnLogin);
        mButtonLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoginPresenter = new LoginPresenter(this, new LoginAPI());
    }

    @Override
    public void onClick(View v) {
        mLoginPresenter.onLoginButtonClick();

    }

    @Override
    public String getLogin() {
        return mEditLogin.getText().toString().trim();
    }

    @Override
    public void setErrorEmptyLoginMessage(@StringRes int resId) {
        mEditLogin.setError(getString(resId));
    }

    @Override
    public String getPassword() {
        return mEditPassword.getText().toString().trim();
    }

    @Override
    public void setErrorEmptyPassMessage(@StringRes int resId) {
        mEditPassword.setError(getString(resId));
    }

    @Override
    public void startMainActivity() {
        Intent intent = new Intent(context, MainActivity.class);
        startActivity(intent);
        getActivity().finish();
    }

    @Override
    public void showLoginFailError() {
        Toast.makeText(context, R.string.login_or_pass_incorrect, Toast.LENGTH_SHORT).show();
    }
}
