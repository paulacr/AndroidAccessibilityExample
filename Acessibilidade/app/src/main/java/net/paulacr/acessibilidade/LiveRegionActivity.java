package net.paulacr.acessibilidade;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by paularosa on 7/29/16.
 */
@EActivity(R.layout.live_region_layout)
public class LiveRegionActivity extends AppCompatActivity {

    @ViewById
    Button botaoBuscarJogos, botaoBuscarJogosComErro;

    @ViewById
    ListView listaJogos;

    @ViewById
    LinearLayout llSistemaIndisponivel;

    @ViewById
    TextView textoMensagemErro;

    @Click(R.id.botao_buscar_jogos) void aoClicarEmBuscarJogos() {
        exibeDialog();
        buscaListaJogos();
    }

    @Click(R.id.botao_buscar_jogos_com_erro) void aoClicarEmBuscarJogosComErro() {
        exibeDialog();
        buscaListaJogosComErroServico();
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
         * Live Region
         */
        ViewCompat.setAccessibilityLiveRegion(listaJogos,
                ViewCompat.ACCESSIBILITY_LIVE_REGION_POLITE);
    }

    private void mostraErroConexao() {
        escondeDialog();
        listaJogos.setVisibility(View.GONE);
        llSistemaIndisponivel.setVisibility(View.VISIBLE);

        /**
         * Live Region
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
}
