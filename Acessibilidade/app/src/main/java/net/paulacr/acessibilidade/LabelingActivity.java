package net.paulacr.acessibilidade;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by paularosa on 7/30/16.
 */
public class LabelingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labeling_layout);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LabelingActivity.class);
    }
}
