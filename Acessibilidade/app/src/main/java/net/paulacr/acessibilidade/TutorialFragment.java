package net.paulacr.acessibilidade;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class TutorialFragment extends Fragment {

    interface OnArrowClicked {
        void onClick();
    }

    private OnArrowClicked onArrowClicked;

    public static TutorialFragment newInstance(int currentPage) {

        Bundle args = new Bundle();
        args.putInt("page", currentPage);
        TutorialFragment fragment = new TutorialFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return (ViewGroup) inflater.inflate(R.layout.tutorial_fragment, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        assert getArguments() != null;
        int page = getArguments().getInt("page") +1;

        TextView currentPageText = view.findViewById(R.id.currentPage);
        currentPageText.setText(""+ page + " de 3");
        currentPageText.setContentDescription("página " + page + " de 3");

        TextView textoDescricao = view.findViewById(R.id.texto_descricao_pagina_tutorial);

        if(page == 1) {
            textoDescricao.setText("Use o aplicativo para receber suas notificações");
        } else if (page == 2) {
            textoDescricao.setText("Comece agora mesmo!!!!!");
        }

        view.findViewById(R.id.view_arrow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onArrowClicked.onClick();
            }
        });

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof OnArrowClicked) {
            onArrowClicked = (OnArrowClicked) context;
        } else {
            throw new ClassCastException("Class cast exception");
        }
    }
}
