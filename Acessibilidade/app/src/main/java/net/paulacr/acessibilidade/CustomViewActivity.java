package net.paulacr.acessibilidade;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by paularosa on 8/1/16.
 */
public class CustomViewActivity extends AppCompatActivity{

    CustomView viewArrow;
    Button botaoMostrarCustomView;
    TextView text;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.custom_view_layout);

        botaoMostrarCustomView = findViewById(R.id.botao_mostrar_custom_view);
        viewArrow = findViewById(R.id.view_arrow);
        text = findViewById(R.id.text);

        /**
         * #Acessibilidade
         * Quando a view fica visível precisamos que seja falada pelo talkback
         * entao na classe da view customizada (CustomView.java) chamamos o método
         * announceForAccessibility("texto")
         */
        botaoMostrarCustomView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(viewArrow.getVisibility() == View.GONE) {
                    viewArrow.setVisibility(View.VISIBLE);
                    text.setVisibility(View.VISIBLE);

                } else {
                    viewArrow.setVisibility(View.GONE);
                    text.setVisibility(View.GONE);
                }
            }
        });
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, CustomViewActivity.class);
    }
}
