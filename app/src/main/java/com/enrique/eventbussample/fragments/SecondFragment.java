package com.enrique.eventbussample.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.enrique.eventbussample.R;
import com.enrique.eventbussample.events.UpdateActionBarTitleEvent;
import com.enrique.eventbussample.events.UpdateTextEvent;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import de.greenrobot.event.EventBus;

public class SecondFragment extends BaseFragment {

    @InjectView(R.id.textViewSecondFragment)
    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment_layout, container, false);
        EventBus.getDefault().post(new UpdateActionBarTitleEvent(getString(R.string.second_fragment)));
        ButterKnife.inject(this, view);
        return view;
    }

    @Override
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    public void onEvent(UpdateTextEvent event) {
        textView.setText(event.getTitle());
    }

    @OnClick(R.id.second_button)
    public void secondButtonClick() {
        EventBus.getDefault().post(new UpdateTextEvent(getString(R.string.text_updated)));
    }
}
