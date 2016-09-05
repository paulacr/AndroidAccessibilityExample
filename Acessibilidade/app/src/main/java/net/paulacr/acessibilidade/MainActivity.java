package net.paulacr.acessibilidade;

import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {

    @Click(R.id.botao_labeling_views) void aoClicarEmLabeling() {
        LabelingActivity_.intent(this).start();
    }

    @Click(R.id.botao_edittext) void aoClicarEmEditText() {
        EditTextActivity_.intent(this).start();
    }

    @Click(R.id.botao_groupviews) void aoClicarEmGroupViews() {
        AgruparViewsActivity_.intent(this).start();
    }

    @Click(R.id.botao_liveregion) void aoClicarEmLiveRegion() {
        LiveRegionActivity_.intent(this).start();
    }

    @Click(R.id.botao_customview) void aoClicarEmCustomView() {
        CustomViewActivity_.intent(this).start();
    }

    @Click(R.id.botao_floating_action_button) void aoClicarEmFloatingActionButton() {
        FloatingActionButtonActivity_.intent(this).start();
    }

    @Click(R.id.botao_view_expansivel) void aoClicarViewsExpansiveis() {
        ViewsExpansiveisActivity_.intent(this).start();
    }
}
