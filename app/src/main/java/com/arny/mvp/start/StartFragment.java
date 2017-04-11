package com.arny.mvp.start;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import com.arny.mvp.home.MainActivity;
import com.arny.mvp.R;
import com.arny.mvp.login.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment implements View.OnClickListener,StartView {
    private Button mButtonLogin;
    private Context context;
    private StartPresenter mStartPresenter;
    private ProgressBar progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.context = container.getContext();
        mButtonLogin = (Button) view.findViewById(R.id.btnLogin);
        mButtonLogin.setOnClickListener(this);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStartPresenter = new StartPresenter(this);
    }

    @Override
    public void onClick(View v) {
        mStartPresenter.onStartButtonClick();
    }

    @Override
    public void startProgress() {
        progressBar.setVisibility(View.VISIBLE);
        mButtonLogin.setVisibility(View.GONE);
    }

    @Override
    public void startLoginActivity() {
        Intent intent = new Intent(context, LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}