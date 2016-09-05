package net.paulacr.acessibilidade;

import android.annotation.TargetApi;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by paularosa on 8/28/16.
 */
@EActivity(R.layout.views_expansiveis_layout)
public class ViewsExpansiveisActivity extends AppCompatActivity {

    @ViewById
    LinearLayout layoutTarefasDetalhe, layoutViewTarefas;
    @ViewById
    ImageView viewExpansivelIcone;
    @ViewById
    TextView tarefasTitulo;

    /**
     * #Acessibilidade
     * Além de modificar o atributo contentDescription quando a view muda de estado
     * também podemos anunciar para o talkback algum outro texto
     * mais explicativo, através do método announceForAccessibility(text)
     */
    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    @Click(R.id.layout_view_tarefas) void aoClicarEmTarefas() {
        String baseContentDescription = "tarefas para lembrar hoje";
        if(layoutTarefasDetalhe.getVisibility() == View.GONE) {
            expandeLayout();
            layoutViewTarefas.setContentDescription(baseContentDescription
                    .concat(" toque duas vezes para recolher"));
            layoutViewTarefas.announceForAccessibility("exibindo tarefas");
        } else {
            recolheLayout();
            layoutViewTarefas.setContentDescription(baseContentDescription.concat
                    (" toque duas vezes para expandir"));
        }
    }

    private void expandeLayout() {
        layoutTarefasDetalhe.setVisibility(View.VISIBLE);
        viewExpansivelIcone.setImageResource(R.drawable.up_arrow);
    }

    private void recolheLayout() {
        layoutTarefasDetalhe.setVisibility(View.GONE);
        viewExpansivelIcone.setImageResource(R.drawable.down_arrow);
    }
}
