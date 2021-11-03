package com.example.paynavtask.adpaters;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.paynavtask.ui.ViewPagerFragment;
import com.google.android.material.tabs.TabLayout;

public class ViewPagerAdapter extends FragmentStateAdapter {

    private TabLayout tabLayout;

    public ViewPagerAdapter(@NonNull Fragment fragment) {
        super(fragment);

    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
            if (position==0) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));
                return new ViewPagerFragment("return");
            }
            if (position==1) {
//                tabLayout.selectTab(tabLayout.getTabAt(position));

                return new ViewPagerFragment("receive");
            }
            return new ViewPagerFragment("return");
        }

    @Override
    public int getItemCount() {
        return 2;
    }
}
