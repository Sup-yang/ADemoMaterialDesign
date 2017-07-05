package com.example.yang.ademomaterialdesign;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity  {

    RecyclerView recyclerView;
    String [] datas;
    Toolbar toolbar;
    FloatingActionButton floatingActionButton;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private LinearLayout linearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        drawerLayout= (DrawerLayout) findViewById(R.id.mydrawerLayout);
        viewPager= (ViewPager) findViewById(R.id.viewpager_main);
        //FAB button键 初始化数据以及点击事件处理
        floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);
        floatingActionButton.hide();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //类似于toast的效果，显示效果在状态栏底部
                Snackbar.make(v,"This is a SnackBar",Snackbar.LENGTH_SHORT).setAction("OK", new View.OnClickListener() {


                    @Override
                    public void onClick(View v) {

                    }
                }).show();
            }
        });
        tabLayout= (TabLayout) findViewById(R.id.tablayout_main);

        initViewPager();
        navigationView= (NavigationView) findViewById(R.id.navigation_view);
//        floatingActionButton= (FloatingActionButton) findViewById(R.id.fab);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawer(GravityCompat.START);
                switch (item.getItemId()){
                    case R.id.nav_blog:
                        Intent intent=new Intent(MainActivity.this,FloatActionBarActivity.class);
                        startActivity(intent);
                        break;
                    case R.id.nav_about:

                        break;
                    case R.id.nav_version:

                        break;
                    case R.id.nav_sub1:

                        break;

                    case R.id.nav_sub2:

                        break;


                }


                return true;
            }
        });

        //侧拉菜单的监听
        //头部控件id需要navigationview获取对象
        View view=navigationView.getHeaderView(0);//侧拉菜单位置类似与数组形式
        linearLayout= (LinearLayout)view.findViewById(R.id.nav_loginimg);
        linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,LoginActivity.class);
                startActivity(intent);
            }
        });
        ActionBarDrawerToggle actionBarDrawerToggle=new ActionBarDrawerToggle(this,
               drawerLayout,toolbar,R.string.drawer_open,R.string.drawer_close ){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

//        initRecyclerView();

    }

    private void initViewPager() {
        List<String> titles= new ArrayList<>();
        titles.add("tab1");
        titles.add("tab2");
        titles.add("tab3");

        //添加viewpager条目
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(0)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(1)));
        tabLayout.addTab(tabLayout.newTab().setText(titles.get(2)));

        List<Fragment> fragments=new ArrayList<>();
        fragments.add(new Main1Fragment());
        fragments.add(new Main2Fragment());
        fragments.add(new Main3Fragment());

        viewPager.setOffscreenPageLimit(2);

        FragmentAdapter fragmentAdapter=new FragmentAdapter(getSupportFragmentManager(),fragments,titles);

        viewPager.setAdapter(fragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.setTabsFromPagerAdapter(fragmentAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position==2){

                    floatingActionButton.show();
                }else {

                    floatingActionButton.hide();
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.option_1:
                Toast.makeText(MainActivity.this,"option_1",Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_2:
                Toast.makeText(MainActivity.this,"option_2",Toast.LENGTH_SHORT).show();
                break;
            case R.id.option_3:
                Toast.makeText(MainActivity.this,"option_3",Toast.LENGTH_SHORT).show();
                break;
        }

        return true;
    }

    //    private void initRecyclerView() {
//        recyclerView= (RecyclerView) findViewById(R.id.recyclerview);
//        recyclerView.setHasFixedSize(true);
//        recyclerView.setLayoutManager(new LinearLayoutManager(this));
//        datas=new String[]{"java","c","c++","swift","go","javascript","python","ruby","html","sql"};
//
//
//
//    }
}
