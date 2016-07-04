package fragment;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;

import com.cp.mytab.util.MyTabSetting;
import com.cp.viewtab.R;

import bean.HeaderBeanV2;


/**
 * @author Vance
 */
public class FragmentHeaderTab extends Fragment implements OnPageChangeListener, OnCheckedChangeListener {


      MyTabSetting myTabSetting = new MyTabSetting();


    public static FragmentHeaderTab newInstance(HeaderBeanV2... items) {
        FragmentHeaderTab f = new FragmentHeaderTab();
        f.setHeader(items);
        return f;
    }

    public static FragmentHeaderTab newInstance(int pageIndex, HeaderBeanV2... items) {
        FragmentHeaderTab f = new FragmentHeaderTab();
        Bundle b = new Bundle();
        b.putInt("index", pageIndex);
        f.setArguments(b);
        f.setHeader(items);
        return f;
    }

    protected View view;
    protected Activity context;
    protected ViewPager viewPager;
    protected int itemNums;
    protected HeaderBeanV2[] items;
    protected OnPagerSelectedListener mOnPagerSelectedListener;
    RadioGroup rg;
    private int curTab = 0;

    protected void setHeader(HeaderBeanV2... items) {
        this.items = items;
        itemNums = items.length;
    }

    public OnPagerSelectedListener getOnPagerSelectedListener() {
        return mOnPagerSelectedListener;
    }

    public void setOnPagerSelectedListener(
            OnPagerSelectedListener mOnPagerSelectedListener) {
        this.mOnPagerSelectedListener = mOnPagerSelectedListener;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        context = getActivity();
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        FragmentPagerAdapter mPagerAdapter = new MyFragmentPagerAdapter(getChildFragmentManager());

        viewPager.setAdapter(mPagerAdapter);

        int index = getDesIndex();
        if (index > 0) {
            if (rg != null) {
                RadioButton rbtn = (RadioButton) rg.getChildAt(index);
                if (rbtn != null) rbtn.setChecked(true);
            }
        } else {
            if (rg != null) {
                RadioButton rbtn = (RadioButton) rg.getChildAt(0);
                if (rbtn != null) rbtn.setChecked(true);
            }
        }
    }


    /**
     * 获取程序指定的tab
     *
     * @return
     */
    private int getDesIndex() {
        int index = 0;
        Bundle bundle = getArguments();
        if (bundle != null) {
            index = bundle.getInt("index", 0);
        } else {
            bundle = context.getIntent().getExtras();
            if (bundle != null) index = bundle.getInt("index", 0);
        }
        return index;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.f_header_tab, null);

        viewPager = (ViewPager) view.findViewById(R.id.viewpager);
        viewPager.setOnPageChangeListener(this);

        rg = (RadioGroup) view.findViewById(R.id.rg_01);
        rg.setOnCheckedChangeListener(this);

        for (int i = 0; i < itemNums; i++) {
            RadioGroup.LayoutParams params = new RadioGroup.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
            params.weight = 1;
            RadioButton rbtn = new RadioButton(context);
            rbtn.setLayoutParams(params);
            rbtn.setText(items[i].text);
            rbtn.setTextSize(14F);
            rbtn.setGravity(Gravity.CENTER);

            ColorStateList color = createColorStateList(myTabSetting.getmTextNormalColor(), myTabSetting.getmTextSelectColor(), myTabSetting.getmTextSelectColor());

            rbtn.setTextColor(color);


            rbtn.setButtonDrawable(new ColorDrawable(Color.TRANSPARENT));


            if (i == 0) {

                // 左边
                rbtn.setBackgroundDrawable
                        (addStateDrawable(getActivity(),
                                myTabSetting.getNormalDrableLeft(),
                                myTabSetting.getSelectDrableLeft(),
                                myTabSetting.getSelectDrableLeft()));
            } else if (i == itemNums - 1) {

                // 右边
                // rbtn.setBackgroundResource(R.drawable.slector_bg_btn_03);
                rbtn.setBackgroundDrawable
                        (addStateDrawable(getActivity(),
                                myTabSetting.getNormalDrableRight(),
                                myTabSetting.getSelectDrableRight(),
                                myTabSetting.getSelectDrableRight()));

            } else {

                // 中间
                rbtn.setBackgroundDrawable
                        (addStateDrawable(getActivity(),
                                myTabSetting.getNormalDrableCon(),
                                myTabSetting.getSelectDrableCon(),
                                myTabSetting.getSelectDrableCon()));
                // rbtn.setBackgroundResource(R.drawable.slector_bg_btn_02);
            }
            rg.addView(rbtn, i);
        }
        return view;
    }


    private StateListDrawable addStateDrawable(Context context, GradientDrawable normal, GradientDrawable pressed, GradientDrawable focus) {
        StateListDrawable sd = new StateListDrawable();


        //注意该处的顺序，只要有一个状态与之相配，背景就会被换掉
        //所以不要把大范围放在前面了，如果sd.addState(new[]{},normal)放在第一个的话，就没有什么效果了
        sd.addState(new int[]{android.R.attr.state_enabled, android.R.attr.state_checked}, focus);
        sd.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled}, pressed);
        sd.addState(new int[]{android.R.attr.state_checked}, focus);
        sd.addState(new int[]{android.R.attr.state_pressed}, pressed);
        sd.addState(new int[]{android.R.attr.state_enabled}, normal);
        sd.addState(new int[]{}, normal);
        return sd;
    }


    /**
     * 对TextView设置不同状态时其文字颜色。
     */
    private ColorStateList createColorStateList(String normal, String pressed, String checked) {

        int normalColor = Color.parseColor(normal);

        int pressColor = Color.parseColor(pressed);
        int checkedColor = Color.parseColor(checked);

        int[] colors = new int[]{pressColor, checkedColor, normalColor, checkedColor, normalColor};
        int[][] states = new int[5][];
        states[0] = new int[]{android.R.attr.state_pressed, android.R.attr.state_enabled};
        states[1] = new int[]{android.R.attr.state_enabled, android.R.attr.state_checked};
        states[2] = new int[]{android.R.attr.state_enabled};
        states[3] = new int[]{android.R.attr.state_checked};
//        states[4] = new int[] { android.R.attr.state_window_focused };
        states[4] = new int[]{};
        ColorStateList colorList = new ColorStateList(states, colors);
        return colorList;
    }

    /**
     * 跳转到某页
     *
     * @param pageIndex
     */
    public void setPageIndex(int pageIndex) {
        if (viewPager.getChildCount() >= pageIndex) {
            viewPager.setCurrentItem(pageIndex);
        }
    }

    private class My2FAdapter extends FragmentStatePagerAdapter {

        public My2FAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int arg0) {
            return null;
        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public int getItemPosition(Object object) {
            // TODO Auto-generated method stub
            return super.getItemPosition(object);
        }
    }


    private class MyFragmentPagerAdapter extends FragmentPagerAdapter {

        public MyFragmentPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return items[position].content;
        }

        @Override
        public int getCount() {
            return items == null ? 0 : items.length;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            return super.instantiateItem(container, position);
        }
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageSelected(int index) {
        RadioButton btn = (RadioButton) rg.getChildAt(index);
        btn.setChecked(true);
        doUmeng(index);
    }

    private void doUmeng(int position) {
        //preTab = curTab;
        curTab = position;
    }

    @Override
    public void onResume() {
        //	pageName = items[curTab].tag;
        super.onResume();
    }

    @Override
    public void onPause() {
        //	pageName = items[curTab].tag;
        super.onPause();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        for (HeaderBeanV2 item : items) {
            item.content.onActivityResult(requestCode, resultCode, data);
        }
    }


    @Override
    public void onPageScrollStateChanged(int arg0) {

    }


    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        for (int i = 0, len = rg.getChildCount(); i < len; i++) {
            if (checkedId == rg.getChildAt(i).getId()) {
                viewPager.setCurrentItem(i);
                if (mOnPagerSelectedListener != null)
                    mOnPagerSelectedListener.onPagerSelectedListener(i);
            }
        }

    }

    public interface OnPagerSelectedListener {
        public void onPagerSelectedListener(int id);
    }
}
