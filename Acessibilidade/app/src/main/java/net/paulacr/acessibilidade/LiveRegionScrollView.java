package net.paulacr.acessibilidade;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by paularosa on 8/1/16.
 */
@EActivity(R.layout.live_region_scrollview_layout)
public class LiveRegionScrollView extends AppCompatActivity {

    @ViewById
    ScrollView scrollviewLembretesSemana;

    @ViewById
    LinearLayout layoutSegunda;


    private ProgressDialog dialog;

    @AfterViews void aoIniciar() {
        exibeDialog();
        buscaCompromissos();
    }

    private void exibeDialog() {
        //usar annotations no dialog
        if (dialog == null) {
            dialog = new ProgressDialog(this);
        }
        dialog.setMessage("aguarde");
        dialog.show();
    }

    private void escondeDialog() {
        dialog.dismiss();
    }

    private void buscaCompromissos() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                escondeDialog();
                scrollviewLembretesSemana.setVisibility(View.VISIBLE);
                /**
                 * Acessibilidade
                 */
                ViewCompat.setAccessibilityLiveRegion(
                        layoutSegunda,
                        ViewCompat.ACCESSIBILITY_LIVE_REGION_POLITE);
            }
        }, 1500);
    }
}
