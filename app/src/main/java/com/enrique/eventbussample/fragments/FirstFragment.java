package com.enrique.eventbussample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.enrique.eventbussample.R;
import com.enrique.eventbussample.events.ShowFragmentEvent;
import com.enrique.eventbussample.events.UpdateActionBarTitleEvent;

import butterknife.ButterKnife;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class FirstFragment extends BaseFragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment_layout, container, false);
		EventBus.getDefault().post(new UpdateActionBarTitleEvent(getString(R.string.first_fragment)));
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @OnClick(R.id.first_button)
    public void firstButtonClick() {
        EventBus.getDefault().post(new ShowFragmentEvent(new SecondFragment()));
    }
}
