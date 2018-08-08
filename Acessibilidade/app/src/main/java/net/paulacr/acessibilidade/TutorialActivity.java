package net.paulacr.acessibilidade;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class TutorialActivity extends AppCompatActivity implements TutorialFragment.OnArrowClicked{

    ViewPager viewPager;
    PagerAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tutorial_correto_layout);

        viewPager =findViewById(R.id.pager);
        adapter = new TutorialPagerAdapter(getSupportFragmentManager());

        viewPager.setAdapter(adapter);
    }

    @Override
    public void onBackPressed() {
        if (viewPager.getCurrentItem() == 0) {
            super.onBackPressed();
        } else {
            viewPager.setCurrentItem(viewPager.getCurrentItem() - 1);
        }
    }

    public static Intent newIntent(Context context) {
        return new Intent(context, TutorialActivity.class);
    }

    @Override
    public void onClick() {
        if(viewPager.getCurrentItem() == adapter.getCount()) {
            return;
        }
        viewPager.setCurrentItem(viewPager.getCurrentItem() +1);
    }
}
