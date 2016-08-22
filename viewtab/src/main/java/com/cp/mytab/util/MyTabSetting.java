package com.cp.mytab.util;

import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;

/**
 * Created by Jerry on 2016/7/4.
 * 属性设置类
 */
public class MyTabSetting {


    // 圆角大小
    private static int mCorners = 8;
    // 边框宽度
    private static int mStrokeWidth = 1;
    //边框颜色
    private static String mStrokeColor = "#269edc";
    // 内部填充颜色
    private static String mSolidColor = "#269edc";
    //没有选中时内部的填充颜色
    private static String mNoSelectSolidColor = "#FFFFFF";

    //没有选中时文字的颜色
    private static String mTextNormalColor = "#269edc";

    //选择时文字 的颜色
    private static String mTextSelectColor = "#FFFFFF";


    /**
     * 返回正常的情况 左边
     */
    public GradientDrawable getNormalDrableLeft() {


        int strokeColor = Color.parseColor(getmStrokeColor());//边框颜色
        int fillColor = Color.parseColor(getmNoSelectSolidColor());//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);



        // 为左上，右上，右下，左下。
        float fon[] = {getmCorners(), getmCorners(), 0, 0, 0, 0, getmCorners(), getmCorners()};
        gd.setCornerRadii(fon);


        gd.setStroke(getmStrokeWidth(), strokeColor);


        return gd;
    }


    /**
     * 返回正常的情况 中间
     */
    public GradientDrawable getNormalDrableCon() {


        int strokeColor = Color.parseColor(getmStrokeColor());//边框颜色
        int fillColor = Color.parseColor(getmNoSelectSolidColor());//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);



        float fon[] = {0, 0, 0, 0, 0, 0, 0, 0};
        gd.setCornerRadii(fon);


        gd.setStroke(getmStrokeWidth(), strokeColor);


        return gd;
    }


    /**
     * 返回正常的情况 右边
     */
    public GradientDrawable getNormalDrableRight() {


        int strokeColor = Color.parseColor(getmStrokeColor());//边框颜色
        int fillColor = Color.parseColor(getmNoSelectSolidColor());//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);


        //  gd.setCornerRadius(getmCorners());
        float fon[] = {0, 0, getmCorners(), getmCorners(), getmCorners(), getmCorners(), 0, 0};
        gd.setCornerRadii(fon);


        gd.setStroke(getmStrokeWidth(), strokeColor);


        return gd;
    }


    /**
     * 返回选择的情况 左边
     */
    public GradientDrawable getSelectDrableLeft() {


        int strokeColor = Color.parseColor(getmStrokeColor());//边框颜色
        int fillColor = Color.parseColor(getmSolidColor());//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);


        float fon[] = {getmCorners(), getmCorners(), 0, 0, 0, 0, getmCorners(), getmCorners()};
        gd.setCornerRadii(fon);


        gd.setStroke(getmStrokeWidth(), strokeColor);


        return gd;
    }

    /**
     * 返回选择的情况 中间
     */
    public GradientDrawable getSelectDrableCon() {


        int strokeColor = Color.parseColor(getmStrokeColor());//边框颜色
        int fillColor = Color.parseColor(getmSolidColor());//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);


        float fon[] = {0, 0, 0, 0, 0, 0, 0, 0};
        gd.setCornerRadii(fon);


        gd.setStroke(getmStrokeWidth(), strokeColor);


        return gd;
    }


    /**
     * 返回选择的情况 右边
     */
    public GradientDrawable getSelectDrableRight() {


        int strokeColor = Color.parseColor(getmStrokeColor());//边框颜色
        int fillColor = Color.parseColor(getmSolidColor());//内部填充颜色

        GradientDrawable gd = new GradientDrawable();//创建drawable
        gd.setColor(fillColor);



        float fon[] = {0, 0, getmCorners(), getmCorners(), getmCorners(), getmCorners(), 0, 0};
        gd.setCornerRadii(fon);


        gd.setStroke(getmStrokeWidth(), strokeColor);


        return gd;
    }


    public String getmNoSelectSolidColor() {
        return mNoSelectSolidColor;
    }

    public void setmNoSelectSolidColor(String mNoSelectSolidColor) {
        this.mNoSelectSolidColor = mNoSelectSolidColor;
    }

    public void setmStrokeWidth(int mStrokeWidth) {
        this.mStrokeWidth = mStrokeWidth;
    }

    public int getmCorners() {
        return mCorners;
    }

    public void setmCorners(int mCorners) {
        this.mCorners = mCorners;
    }

    public int getmStrokeWidth() {
        return mStrokeWidth;
    }

    public String getmStrokeColor() {
        return mStrokeColor;
    }

    public void setmStrokeColor(String mStrokeColor) {
        this.mStrokeColor = mStrokeColor;
    }

    public String getmSolidColor() {
        return mSolidColor;
    }

    public void setmSolidColor(String mSolidColor) {
        this.mSolidColor = mSolidColor;
    }


    public String getmTextNormalColor() {
        return mTextNormalColor;
    }

    public void setmTextNormalColor(String mTextNormalColor) {
        this.mTextNormalColor = mTextNormalColor;
    }

    public String getmTextSelectColor() {
        return mTextSelectColor;
    }

    public void setmTextSelectColor(String mTextSelectColor) {
        this.mTextSelectColor = mTextSelectColor;
    }
}
