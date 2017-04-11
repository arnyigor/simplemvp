package com.arny.mvp.start;

import android.os.AsyncTask;

public class StartPresenter {
    private final StartView startView;

    public StartPresenter(StartView startView) {
        this.startView = startView;
    }

    public void onEnter() {
        new AsyncTask<Void, Void, Void>(){
            @Override
            protected void onPreExecute() {
                startView.setProgress();
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
            }

            @Override
            protected Void doInBackground(Void... voids) {
                startView.startProgress();
                return null;
            }
        }.execute();
    }
}