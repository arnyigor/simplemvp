package com.arny.mvp.start;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.arny.mvp.R;
import com.arny.mvp.login.LoginActivity;


/**
 * A simple {@link Fragment} subclass.
 */
public class StartFragment extends Fragment implements StartView {
    private Button mButtonEnter;
    private Context context;
    private StartPresenter mStartPresenter;
    private ProgressDialog progressBar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        this.context = container.getContext();
        mButtonEnter = (Button) view.findViewById(R.id.btnEnter);
        mButtonEnter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mStartPresenter.onEnter();
            }
        });
        progressBar = new ProgressDialog(context);
        progressBar.setCancelable(false);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mStartPresenter = new StartPresenter(this);
    }

    @Override
    public void setProgress() {
        progressBar.setTitle("Ожидание");
    }

    @Override
    public void startProgress() {
        progressBar.show();
        mButtonEnter.setVisibility(View.GONE);
    }

    @Override
    public void startLoginActivity() {
        Intent intent = new Intent(context, LoginActivity.class);
        startActivity(intent);
        getActivity().finish();
    }
}