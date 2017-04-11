package com.arny.mvp.start;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.arny.mvp.R;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new StartFragment())
                .commit();
    }

}
