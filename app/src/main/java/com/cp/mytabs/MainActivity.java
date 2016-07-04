package com.cp.mytabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;

import com.cp.mytab.util.MyTabSetting;
import com.cp.mytabs.fragment.Fragment1;
import com.cp.mytabs.fragment.Fragment2;
import com.cp.mytabs.fragment.Fragment3;

import bean.HeaderBeanV2;
import fragment.FragmentHeaderTab;
import infter.IFragmentCreate;

/**
 *  示例
 */

public class MainActivity extends FragmentActivity implements IFragmentCreate {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewPageSetting();

        Fragment fragment = initFragment();


        getSupportFragmentManager().beginTransaction().
                replace(R.id.fragment_container, fragment)
                .commit();

    }

    @Override
    public Fragment initFragment() {

        HeaderBeanV2 hSVip = new HeaderBeanV2("北京", "SVipFragment", new Fragment1());
        HeaderBeanV2 hVip = new HeaderBeanV2("上海", "VipFragment", new Fragment2());
        HeaderBeanV2 hCar = new HeaderBeanV2("广州", "CarFragment", new Fragment3());
        return FragmentHeaderTab.newInstance(hSVip, hVip, hCar);
    }


    /**
     *
     */
    private void initViewPageSetting() {

        MyTabSetting myTabSetting = new MyTabSetting();
        //设置圆角大小
        myTabSetting.setmCorners(18);
        //设置边框宽度
        myTabSetting.setmStrokeWidth(1);
        //设置边框颜色
        myTabSetting.setmStrokeColor("#ff7f00");
        // 设置选中时内部的填充颜色
        myTabSetting.setmSolidColor("#ff7f00");
        //设置没有选中时内部填充颜色
        myTabSetting.setmNoSelectSolidColor("#FFFFFF");
        //设置选中时文字的颜色
        myTabSetting.setmTextSelectColor("#FFFFFF");
        // 设置 没有选中时文字的颜色
        myTabSetting.setmTextNormalColor("#ff7f00");


    }

}
