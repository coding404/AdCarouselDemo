package com.liushu.example.adcarouseldemo;

import android.content.Context;
import android.support.annotation.AnimRes;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.ViewFlipper;

import java.util.List;

/**
 * Created by liushu on 2017/8/16.
 */

public class AdCarouseView extends ViewFlipper {

    private int inAnimResId = R.anim.anim_marquee_in;
    private int outAnimResId = R.anim.anim_marquee_out;

    private List<String> notices;
    private int firstPosition;
    private int lastPosition;
    private boolean hasSetAnimDuration = true;
    private int animDuration = 1000;
    private OnClickListener mListener;

    private int interval = 3000;

    public void setListener(OnClickListener listener) {
        mListener = listener;
    }

    public void startWithList(List<String> notices) {
        startWithList(notices, inAnimResId, outAnimResId);
    }

    public AdCarouseView(Context context) {
        super(context);
    }

    public AdCarouseView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    /**
     * 根据字符串列表，启动翻页公告
     *
     * @param notices      字符串列表
     * @param inAnimResId  进入动画的resID
     * @param outAnimResID 离开动画的resID
     */
    private void startWithList(List<String> notices, @AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        if (notices.isEmpty()) {
            return;
        }
        setNotices(notices);
        start(inAnimResId, outAnimResID);
    }

    public void setNotices(List<String> notices) {
        this.notices = notices;
    }

    private boolean start(@AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        removeAllViews();
        clearAnimation();

        firstPosition = 0;
        if (notices.size() == 1) {
            lastPosition = 0;
        } else {
            lastPosition = 1;
        }
        addView(createView(firstPosition, lastPosition));
        if (notices.size() > 1) {
            setInAndOutAnimation(inAnimResId, outAnimResID);
            startFlipping();
        }


        /*if (notices.size() > 1) {
            setInAndOutAnimation(inAnimResId, outAnimResID);
            startFlipping();
        }*/

        getInAnimation().setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {

                firstPosition =firstPosition+ 2;
                lastPosition =lastPosition+ 2;
                if (firstPosition >= notices.size()) {
                    firstPosition = 0;
                }
                if (lastPosition >= notices.size()) {
                    if (notices.size() == 1) {
                        lastPosition = 0;
                    } else {
                        lastPosition = 1;
                    }
                }
                View view = createView(firstPosition, lastPosition);
                if (view.getParent() == null) {
                    addView(view);
                }
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        });
        return true;
    }

    private View createView(int firstPosition, int lastPosition) {
        Log.e("firstPosition","firstPosition:"+firstPosition);
        Log.e("lastPosition","lastPosition:"+lastPosition);
       // View view = getChildAt((getDisplayedChild() + 1) % 3);
        View view = getChildAt((getDisplayedChild() + 1) % 3);
        ViewHolder holder;
        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.item_view, null);
            holder = new ViewHolder();
            holder.mLl_first = (LinearLayout) view.findViewById(R.id.ll_first);
            holder.mLl_last = (LinearLayout) view.findViewById(R.id.ll_last);
            holder.mTv_first = (TextView) view.findViewById(R.id.tv_first);
            holder.mTv_last = (TextView) view.findViewById(R.id.tv_last);
            view.setTag(holder);
        }

        holder = (ViewHolder) view.getTag();
        holder.mTv_first.setText(notices.get(firstPosition));
        holder.mTv_last.setText(notices.get(lastPosition));
        holder.mLl_first.setTag(firstPosition);
        holder.mLl_first.setOnClickListener(mListener);
        holder.mLl_last.setTag(lastPosition);
        holder.mLl_last.setOnClickListener(mListener);
        return view;
    }

    private void setInAndOutAnimation(@AnimRes int inAnimResId, @AnimRes int outAnimResID) {
        Animation inAnim = AnimationUtils.loadAnimation(getContext(), inAnimResId);
        inAnim.setDuration(animDuration);
        setInAnimation(inAnim);

        Animation outAnim = AnimationUtils.loadAnimation(getContext(), outAnimResID);
        outAnim.setDuration(animDuration);
        setOutAnimation(outAnim);
    }

    private static class ViewHolder {
        private TextView mTv_first;
        private TextView mTv_last;
        private LinearLayout mLl_first;
        private LinearLayout mLl_last;

    }
}