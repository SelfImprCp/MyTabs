package com.cp.mytabs;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.cp.mytabs.fragment.Fragment1;
import com.cp.mytabs.fragment.Fragment2;
import com.cp.mytabs.fragment.Fragment3;

import bean.HeaderBeanV2;
import fragment.FragmentHeaderTab;
import infter.IFragmentCreate;

public class MainActivity extends FragmentActivity implements IFragmentCreate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Fragment fragment = initFragment();

//        getFragmentManager().beginTransaction()
//                .replace(R.id.fragment_container, fragment)
//                .commit();
//
//        getFragmentManager().beginTransaction().
//                replace(R.id.fragment_container,fragment)
//                .commit();

        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,fragment)
                .commit();

    }

    @Override
    public Fragment initFragment() {
        HeaderBeanV2 hSVip = new HeaderBeanV2("自定义收益率", "SVipFragment", new Fragment1());
        HeaderBeanV2 hVip = new HeaderBeanV2("个性推荐", "VipFragment", new Fragment2());
        HeaderBeanV2 hCar = new HeaderBeanV2("基金挑选", "CarFragment", new Fragment3());
        return FragmentHeaderTab.newInstance(hSVip, hVip, hCar);
    }
}
