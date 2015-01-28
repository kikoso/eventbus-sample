package com.enrique.eventbussample;

import android.app.Activity;
import android.os.Bundle;
import com.enrique.eventbussample.events.ShowFragmentEvent;
import com.enrique.eventbussample.events.UpdateActionBarTitleEvent;
import com.enrique.eventbussample.fragments.FirstFragment;
import com.enrique.eventbussample.fragments.SecondFragment;

import de.greenrobot.event.EventBus;

public class MainActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        EventBus.getDefault().register(this);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction().add(R.id.container, new FirstFragment()).commit();
        }
    }

    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }

    public void onEvent(ShowFragmentEvent event) {
        getFragmentManager().beginTransaction().replace(R.id.container, event.getFragment()).addToBackStack(null).commit();
    }

    public void onEvent(UpdateActionBarTitleEvent e) {
        getActionBar().setTitle(e.getTitle());
    }
}
