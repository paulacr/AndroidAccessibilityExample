package net.paulacr.acessibilidade;

import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by paularosa on 8/1/16.
 */
@EActivity(R.layout.custom_view_layout)
public class CustomViewActivity extends AppCompatActivity{

    @ViewById
    CustomView viewArrow;

    @ViewById
    Button botaoMostrarCustomView;

    /**
     * #Acessibilidade
     * Quando a view fica visível precisamos que seja falada pelo talkback
     * entao na classe da view customizada (CustomView.java) chamamos o método
     * announceForAccessibility("texto")
     */
    @Click(R.id.botao_mostrar_custom_view) void aoClicarBotao() {
        if(viewArrow.getVisibility() == View.GONE) {
            viewArrow.setVisibility(View.VISIBLE);

        } else {
            viewArrow.setVisibility(View.GONE);
        }
    }
}
