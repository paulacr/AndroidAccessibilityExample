package net.paulacr.acessibilidade;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class TutorialPagerAdapter extends FragmentStatePagerAdapter {

    public TutorialPagerAdapter(FragmentManager manager) {
        super(manager);
    }

    @Override
    public Fragment getItem(int position) {
        return TutorialFragment.newInstance(position);
    }

    @Override
    public int getCount() {
        return 3;
    }
}
