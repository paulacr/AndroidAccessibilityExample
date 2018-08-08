package net.paulacr.acessibilidade;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Click;

/**
 * Created by paularosa on 8/28/16.
 */
public class ViewsExpansiveisActivity extends AppCompatActivity {

    LinearLayout layoutTarefasDetalhe, layoutViewTarefas;
    ImageView viewExpansivelIcone;
    TextView tarefasTitulo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.views_expansiveis_layout);

        layoutTarefasDetalhe = findViewById(R.id.layout_tarefas_detalhe);
        layoutViewTarefas = findViewById(R.id.layout_view_tarefas);
        viewExpansivelIcone = findViewById(R.id.view_expansivel_icone);
        tarefasTitulo = findViewById(R.id.tarefas_titulo);

        /*
         * #Acessibilidade
         * Além de modificar o atributo contentDescription quando a view muda de estado
         * também podemos anunciar para o talkback algum outro texto
         * mais explicativo, através do método announceForAccessibility(text)
         */
        layoutViewTarefas.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {
                String baseContentDescription = "tarefas para lembrar hoje";
                if(layoutTarefasDetalhe.getVisibility() == View.GONE) {
                    expandeLayout();
                    layoutViewTarefas.sendAccessibilityEvent(
                            AccessibilityEvent.TYPE_VIEW_ACCESSIBILITY_FOCUSED);
                    layoutViewTarefas.setContentDescription(baseContentDescription
                            .concat(" toque duas vezes para recolher"));
                    layoutViewTarefas.announceForAccessibility("exibindo tarefas");
                } else {
                    recolheLayout();
                    layoutViewTarefas.setContentDescription(baseContentDescription.concat
                            (" toque duas vezes para expandir"));
                }
            }
        });

    }

    private void expandeLayout() {
        layoutTarefasDetalhe.setVisibility(View.VISIBLE);
        viewExpansivelIcone.setImageResource(R.drawable.up_arrow);
    }

    private void recolheLayout() {
        layoutTarefasDetalhe.setVisibility(View.GONE);
        viewExpansivelIcone.setImageResource(R.drawable.down_arrow);
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, ViewsExpansiveisActivity.class);
    }
}
