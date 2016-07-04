package com.cp.mytabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.cp.mylibrary.utils.LogCp;
import com.cp.mytab.util.MyTabSetting;
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


        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container,fragment)
                .commit();

    }

    @Override
    public Fragment initFragment() {
        initViewPageSetting();

        HeaderBeanV2 hSVip = new HeaderBeanV2("北京", "SVipFragment", new Fragment1());
        HeaderBeanV2 hVip = new HeaderBeanV2("上海", "VipFragment", new Fragment2());
        HeaderBeanV2 hCar = new HeaderBeanV2("广州", "CarFragment", new Fragment3());
        return FragmentHeaderTab.newInstance(hSVip, hVip, hCar);
    }



    /**
     *
     */
    private void initViewPageSetting()
    {

        MyTabSetting myTabSetting = new MyTabSetting();

        //没有选中的填充颜色
        myTabSetting.setmNoSelectSolidColor("#8B4726");
        // 没有选中时文字 的颜色
        myTabSetting.setmTextNormalColor("#404040");


        LogCp.i(LogCp.CP,FragmentHeaderTab.class + "取到的颜色 " + myTabSetting.getmTextNormalColor());



    }

}
