# MyTabs
漂亮的viewpage

使用场景：Activity 中需要添加三个fragment ,这个例子中可左右滑动,也可手动点击，各种属性都可以按自己的需求进行设置


效果：
![image](https://github.com/SelfImprCp/MyTabs/blob/master/img/eg.png)

用法：
1.引入：
 app/build.gradle 中添加

allprojects {
    repositories {

        maven { url "https://jitpack.io" }
    }
}

//注意,这里请设置最新版本 /n
compile 'com.github.SelfImprCp:MyTabs:0.0.1'

2.实现接口 IFragmentCreate:

具体使用方法参考app例子工程

 /**
     *
     */
    private void initViewPageSetting() {

        MyTabSetting myTabSetting = new MyTabSetting();
        //设置圆角大小
        myTabSetting.setmCorners(8);
        //设置边框宽度
        myTabSetting.setmStrokeWidth(2);
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





