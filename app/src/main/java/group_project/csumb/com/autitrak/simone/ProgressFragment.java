package group_project.csumb.com.autitrak.simone;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import group_project.csumb.com.autitrak.R;

public class ProgressFragment extends Fragment{

    private View view;
    private Adapter adapter;
    private OverviewProgressFragment of;
    private TasksCompletedFragment tf;
    private String key;
    private TabLayout tabLayout;

    public ProgressFragment(){this.key=" ";}

    private void setupViewPager(ViewPager viewPager) {
        adapter = new Adapter(getChildFragmentManager());
        of = new OverviewProgressFragment();
        of.setKey(key);
        adapter.addFragment(of,"Overview");
        tf = new TasksCompletedFragment();
        tf.setKey(key);
        adapter.addFragment(tf,"Completed Task");
        viewPager.setAdapter(adapter);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_individual_progress, container, false);
        super.onCreate(savedInstanceState);

        final ViewPager viewPager = (ViewPager) view.findViewById(R.id.individual_viewpager);
        setupViewPager(viewPager);
        tabLayout = (TabLayout)view.findViewById(R.id.individual_tabs);
        tabLayout.setupWithViewPager(viewPager);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }


    static class Adapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragments = new ArrayList<>();
        private final List<String> mFragmentTitles = new ArrayList<>();

        public Adapter(android.support.v4.app.FragmentManager fm) {
            super(fm);
        }

        public void addFragment(Fragment fragment, String title) {
            mFragments.add(fragment);
            mFragmentTitles.add(title);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragments.get(position);
        }

        @Override
        public int getCount() {
            return mFragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitles.get(position);
        }
    }

    public void setKey(String key){this.key=key;}
}
