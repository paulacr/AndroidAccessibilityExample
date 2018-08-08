package net.paulacr.acessibilidade;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paularosa on 7/29/16.
 */
public class LiveRegionActivity extends AppCompatActivity {

    Button botaoBuscarJogos, botaoBuscarJogosComErro;
    ListView listaJogos;
    LinearLayout llSistemaIndisponivel;
    TextView textoMensagemErro;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.live_region_layout);

        botaoBuscarJogos = findViewById(R.id.botao_buscar_jogos);
        botaoBuscarJogosComErro = findViewById(R.id.botao_buscar_jogos_com_erro);
        listaJogos = findViewById(R.id.lista_jogos);
        llSistemaIndisponivel = findViewById(R.id.ll_sistema_indisponivel);
        textoMensagemErro = findViewById(R.id.texto_mensagem_erro);

        botaoBuscarJogos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeDialog();
                buscaListaJogos();
            }
        });

        botaoBuscarJogosComErro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibeDialog();
                buscaListaJogosComErroServico();
            }
        });
    }

    private ProgressDialog dialog;

    private void buscaListaJogos() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostraListaJogos();
            }
        }, 1500);
    }

    private void buscaListaJogosComErroServico() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mostraErroConexao();
            }
        }, 1500);
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

    private void mostraListaJogos() {
        ArrayAdapter<String> jogosAdapter = new ArrayAdapter<>(
                        this,
                        android.R.layout.simple_list_item_1,
                        criaMockJogos());

        escondeDialog();

        listaJogos.setVisibility(View.VISIBLE);
        listaJogos.setAdapter(jogosAdapter);

        /**
         * #Acessibilidade
         * Live Region para fazer com que talkback fale
         * em tempo de execução as views que aparecem depois
         * da tela ter sido criada.
         * Modo polite = espera o talkback parar de falar
         */
        ViewCompat.setAccessibilityLiveRegion(listaJogos,
                ViewCompat.ACCESSIBILITY_LIVE_REGION_POLITE);
    }

    private void mostraErroConexao() {
        escondeDialog();
        listaJogos.setVisibility(View.GONE);
        llSistemaIndisponivel.setVisibility(View.VISIBLE);

        /**
         * #Acessibilidade
         * Live Region para fazer com que talkback fale
         * em tempo de execução as views que aparecem depois
         * da tela ter sido criada.
         * Modo polite = espera o talkback parar de falar
         */
        ViewCompat.setAccessibilityLiveRegion(llSistemaIndisponivel,
                ViewCompat.ACCESSIBILITY_LIVE_REGION_ASSERTIVE);

    }

    private List<String> criaMockJogos() {
        List<String> jogos = new ArrayList<>();
        jogos.add("The Witcher");
        jogos.add("The Elder scrolls");
        jogos.add("Tomb Raider");
        jogos.add("Valient hearts");
        jogos.add("Uncharted 4");
        jogos.add("Rayman");

        return jogos;
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, LiveRegionActivity.class);
    }
}
