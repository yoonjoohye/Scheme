package a67yjh00.com.example.lg.scheme;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;

import a67yjh00.com.example.lg.scheme.Fragment.HomeFragment;
import a67yjh00.com.example.lg.scheme.Fragment.TtFragment;
import a67yjh00.com.example.lg.scheme.Fragment.TdFragment;
import a67yjh00.com.example.lg.scheme.Fragment.CalFragment;
import a67yjh00.com.example.lg.scheme.Fragment.MpFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView bottomNavigationView;

    private ViewPager viewPager;

    HomeFragment HomeFragment;
    TtFragment TtFragment;
    TdFragment TdFragment;
    CalFragment CalFragment;
    MpFragment MpFragment;

    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewPager = (ViewPager) findViewById(R.id.viewpager);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottom_navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.home:
                                viewPager.setCurrentItem(0);
                                break;
                            case R.id.tt:
                                viewPager.setCurrentItem(1);
                                break;
                            case R.id.td:
                                viewPager.setCurrentItem(2);
                                break;
                            case R.id.cal:
                                viewPager.setCurrentItem(3);
                                break;
                            case R.id.mp:
                                viewPager.setCurrentItem(4);
                                break;
                        }
                        return false;
                    }
                });

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNavigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNavigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNavigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        setupViewPager(viewPager);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        HomeFragment=new HomeFragment();
        TtFragment=new TtFragment();
        TdFragment=new TdFragment();
        CalFragment=new CalFragment();
        MpFragment=new MpFragment();

        adapter.addFragment(HomeFragment);
        adapter.addFragment(TtFragment);
        adapter.addFragment(TdFragment);
        adapter.addFragment(CalFragment);
        adapter.addFragment(MpFragment);

        viewPager.setAdapter(adapter);
    }
}
