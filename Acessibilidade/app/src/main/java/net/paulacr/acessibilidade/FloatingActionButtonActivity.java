package net.paulacr.acessibilidade;

import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import org.androidannotations.annotations.AfterViews;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by paularosa on 8/1/16.
 */
@EActivity(R.layout.floating_action_button_layout)
public class FloatingActionButtonActivity extends AppCompatActivity {

    @ViewById
    FloatingActionButton fab;

    @ViewById
    TextView textoEditarPerfilFab;

    /**
     * #Acessibilidade
     * Usado método setTranversalBefore(int id) pois o FAB deve ser lido antes
     * de outros elementos na tela
     */
    @AfterViews
    void aoIniciar() {
        if (Build.VERSION.SDK_INT >=
                Build.VERSION_CODES.LOLLIPOP_MR1) {

            fab.setAccessibilityTraversalBefore
                    (R.id.texto_editar_perfil_fab);
        }
    }
}
