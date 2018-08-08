package net.paulacr.acessibilidade;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.botao_labeling_views).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LabelingActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.botao_edittext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(EditTextActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.botao_groupviews).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(AgruparViewsActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.botao_liveregion).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(LiveRegionActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.botao_customview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(CustomViewActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.botao_floating_action_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(FloatingActionButtonActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.botao_view_expansivel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(ViewsExpansiveisActivity.newIntent(MainActivity.this));
            }
        });

        findViewById(R.id.tutorial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(TutorialActivity.newIntent(MainActivity.this));
            }
        });
    }
}
