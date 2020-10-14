package com.example.intro;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private MyAdapter adapter;
    private List<Model> models;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        models= new ArrayList<>();
        ViewPager viewPager = findViewById(R.id.intro_view_pager);
        TabLayout indicator = findViewById(R.id.indicator);
        recyclerView = findViewById(R.id.slider_pager);

        setUpRecyclerView();

        viewPager.setAdapter(new IntroAdapter());
        indicator.setupWithViewPager(viewPager, true);

        PagerSnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                setUpRecyclerView();
                recyclerView.scrollToPosition(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setUpRecyclerView() {
        if (models.size() == 0){
            models.add(new Model(R.drawable.p1, R.drawable.p2, AnimationUtils.loadAnimation(this, R.anim.scale_in), AnimationUtils.loadAnimation(this, R.anim.scale_out)));
            models.add(new Model(R.drawable.p3, R.drawable.p4, AnimationUtils.loadAnimation(this, R.anim.come), AnimationUtils.loadAnimation(this, R.anim.go)));
            models.add(new Model(R.drawable.p5, R.drawable.p6, AnimationUtils.loadAnimation(this, R.anim.come), AnimationUtils.loadAnimation(this, R.anim.go2)));
            models.add(new Model(R.drawable.p7, R.drawable.p8, AnimationUtils.loadAnimation(this, R.anim.right_to_left), AnimationUtils.loadAnimation(this, R.anim.left_to_right)));
            adapter = new MyAdapter(MainActivity.this, models);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
            recyclerView.setLayoutManager(linearLayoutManager);
            recyclerView.setAdapter(adapter);
        }else {
            models.clear();

            models.add(new Model(R.drawable.p1, R.drawable.p2, AnimationUtils.loadAnimation(this, R.anim.scale_in), AnimationUtils.loadAnimation(this, R.anim.scale_out)));
            models.add(new Model(R.drawable.p3, R.drawable.p4, AnimationUtils.loadAnimation(this, R.anim.come), AnimationUtils.loadAnimation(this, R.anim.go)));
            models.add(new Model(R.drawable.p5, R.drawable.p6, AnimationUtils.loadAnimation(this, R.anim.come), AnimationUtils.loadAnimation(this, R.anim.go2)));
            models.add(new Model(R.drawable.p7, R.drawable.p8, AnimationUtils.loadAnimation(this, R.anim.right_to_left), AnimationUtils.loadAnimation(this, R.anim.left_to_right)));

            adapter.notifyDataSetChanged();
        }
    }

    private class IntroAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return models.size();
        }

        @Override
        public boolean isViewFromObject(View view, @NonNull Object object) {
            return view.equals(object);
        }

        @NonNull
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            // this is fake just for create viewpager
            View view = View.inflate(container.getContext(), R.layout.intro_view_layout, null);
            container.addView(view, 0);
            return view;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }
}
