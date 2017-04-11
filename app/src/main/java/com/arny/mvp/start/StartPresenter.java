package com.arny.mvp.start;

class StartPresenter {
    private final StartView view;

    public StartPresenter(StartView view) {
        this.view = view;
    }

    public void onStartButtonClick() {
        view.startProgress();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        view.startLoginActivity();
    }
}