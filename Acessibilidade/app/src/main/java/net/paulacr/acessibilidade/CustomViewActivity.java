package net.paulacr.acessibilidade;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by paularosa on 8/1/16.
 */
@EActivity(R.layout.custom_view_layout)
public class CustomViewActivity extends AppCompatActivity{

    @ViewById
    CustomView arrowView;

    @AfterViews void aoIniciar() {

        arrowView.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(arrowView.isFocused()) {
                    arrowView.sendAccessibilityEvent(AccessibilityEvent.TYPE_VIEW_FOCUSED);
                }
            }
        });
    }


}
