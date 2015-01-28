package com.enrique.eventbussample.fragments;


import android.app.Fragment;

import de.greenrobot.event.EventBus;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onResume() {
        if (isStickyAvailable()) {
            EventBus.getDefault().registerSticky(this);
        } else {
            EventBus.getDefault().register(this);
        }
        super.onResume();
    }

    @Override
    public void onPause() {
        EventBus.getDefault().unregister(this);
        super.onPause();
    }

    protected boolean isStickyAvailable() {
        return false;
    }
}


