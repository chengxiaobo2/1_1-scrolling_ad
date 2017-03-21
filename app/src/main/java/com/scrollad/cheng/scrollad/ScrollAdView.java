package com.scrollad.cheng.scrollad;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;


/**
 * Created by cheng on 2017/3/21.
 */

public class ScrollAdView extends LinearLayout{

    private int height;
    private int flag=1;
    private List<String> stringList;
    private Activity activity;
    private LinearLayout linearLayoutContent;

    private View.OnClickListener listener=null;



    public ScrollAdView(Context context) {
        super(context);
    }

    public ScrollAdView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollAdView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setListener(OnClickListener listener) {
        this.listener = listener;
    }

    public void initData(List<String> adList,Activity activity)
    {
        height=this.getMeasuredHeight();
        linearLayoutContent=new LinearLayout(activity);
        linearLayoutContent.setOrientation(LinearLayout.VERTICAL);
        linearLayoutContent.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,height*2));  //!!! 必须设置height ，否则为AT_MOST

        stringList=adList;
        this.activity=activity;

        for(int i=0;i<2;i++)
        {
            TextView tv=new TextView(activity);
            tv.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT,height));
            tv.setText(stringList.get(i));
            tv.setTag(stringList.get(i));
            tv.setGravity(Gravity.CENTER_VERTICAL);

            tv.setOnClickListener(new View.OnClickListener()
            {

                @Override
                public void onClick(View v) {

                    if(listener!=null)
                    {
                        listener.onClick(v);
                    }
                }
            });

            linearLayoutContent.addView(tv);
        }

        this.addView(linearLayoutContent);

        initAnimation();

    }

    public void initAnimation()
    {

        //方法1====start====
//        Animation animation =new TranslateAnimation(0,0,0,-height);
//        animation.setDuration(2000);
//        animation.setRepeatMode(ValueAnimator.RESTART);
//        animation.setRepeatCount(ObjectAnimator.INFINITE);
//        animation.setInterpolator(new DecelerateInterpolator());
//
//        animation.setAnimationListener(new Animation.AnimationListener() {
//            @Override
//            public void onAnimationStart(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationEnd(Animation animation) {
//
//            }
//
//            @Override
//            public void onAnimationRepeat(Animation animation)
//            {
//                TextView tv=(TextView)linearLayoutContent.getChildAt(0);
//                linearLayoutContent.removeView(tv);
//                linearLayoutContent.addView(tv);
//
//                if(flag+1>=stringList.size())
//                {
//                    flag=0;
//                }else
//                {
//                    flag=flag+1;
//                }
//                tv.setText(stringList.get(flag));
//                tv.setTag(stringList.get(flag));
//                tv.setGravity(Gravity.CENTER_VERTICAL);
//            }
//        });
//        linearLayoutContent.startAnimation(animation);
        //方法1====end====

        //方法2===start====
        ObjectAnimator animator = ObjectAnimator.ofFloat(linearLayoutContent,"translationY",0,-height);
        animator.setDuration(2000);
        animator.setInterpolator(new DecelerateInterpolator());
        animator.setRepeatMode(ValueAnimator.RESTART);
        animator.setRepeatCount(ObjectAnimator.INFINITE);
        animator.start();

        animator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {


                TextView tv=(TextView)linearLayoutContent.getChildAt(0);
                linearLayoutContent.removeView(tv);
                linearLayoutContent.addView(tv);

                if(flag+1>=stringList.size())
                {
                    flag=0;
                }else
                {
                    flag=flag+1;
                }
                tv.setText(stringList.get(flag));
                tv.setTag(stringList.get(flag));
                tv.setGravity(Gravity.CENTER_VERTICAL);

            }
        });

      //方法2===end====

    }

}
