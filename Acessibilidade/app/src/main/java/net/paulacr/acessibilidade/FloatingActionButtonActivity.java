package net.paulacr.acessibilidade;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by paularosa on 8/1/16.
 */
public class FloatingActionButtonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.floating_action_button_layout);

        FloatingActionButton fab = findViewById(R.id.fab);
//        TextView textoEditarPerfilFab = findViewById(R.id.texto_editar_perfil_fab);

        /**
         * #Acessibilidade
         * Usado método setTranversalBefore(int id) pois o FAB deve ser lido antes
         * de outros elementos na tela
         */
        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.LOLLIPOP_MR1) {
            fab.setAccessibilityTraversalBefore
                    (R.id.texto_editar_perfil_fab);
        }

    }

    public static Intent newIntent(Context context) {
        return new Intent(context, FloatingActionButtonActivity.class);
    }
}
