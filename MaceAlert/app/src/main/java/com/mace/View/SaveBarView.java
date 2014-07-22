package com.mace.View;

import android.app.Service;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nineoldandroids.view.ViewPropertyAnimator;
import com.ayla.service.lang.f;
import com.mace.maceAlert.R;
import com.mace.util.ProgressBarAnimation;
import com.nineoldandroids.animation.Animator;
import com.nineoldandroids.view.ViewHelper;

/**
 * Created by IntelliJ IDEA.
 * User: billy
 * Date: 2014/6/3
 * Time: 下午 03:03
 */
public class SaveBarView extends LinearLayout implements View.OnClickListener, Animation.AnimationListener {

    Button button_cancel, button_save;
    TextView textView_msg;
    LinearLayout linear_action,linear_updating;
    ProgressBar progressBar;
    private static final int TIME_1 =10*1000;
    private static final int TIME_2 =3*100;
    ImageView imageView_bin;

    ProgressBarAnimation anim;


    public void setQuickactionListener(QuickactionListener quickactionListener) {
        this.quickactionListener = quickactionListener;
    }

    QuickactionListener quickactionListener;

    public SaveBarView(Context context) {
        super(context);
        init();
    }

    public SaveBarView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs);
        init();

    }

    public SaveBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    //    done Weexcel : save bar view


    /**
     * @return a cabllback function for the client slide to involve after finish loading
     * Client code would be something like
     * final f fx=SaveBarView.showLoading();
     * rpc.submitChange(someChange,new f(){
     * fx.run();
     * });
     */

    public f showLoading() {
        return new f() {

            @Override
            public void run() {
                finishLoading();
            }
        };
    }

    private void finishLoading() {
        progressBar.clearAnimation();
        progressBar.setProgress(100);
    }

    private void init() {
//        if (isInEditMode())
//            return;

        LayoutInflater li = (LayoutInflater) getContext().getSystemService(Service.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.quick_actions, this, false);
        linear_action=(LinearLayout)view.findViewById(R.id.linear_action);
        linear_updating=(LinearLayout)view.findViewById(R.id.linear_updating);
        button_save = (Button) view.findViewById(R.id.button_save);
        textView_msg = (TextView) view.findViewById(R.id.textView_msg);
        button_cancel = (Button) view.findViewById(R.id.button_cancel);
        progressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        imageView_bin=(ImageView)view.findViewById(R.id.imageView_bin);

        anim = new ProgressBarAnimation(progressBar, 0, 100);
        anim.setDuration(TIME_1);
        anim.setAnimationListener(this);
        button_save.setOnClickListener(this);
        button_cancel.setOnClickListener(this);
        imageView_bin.setOnClickListener(this);
        addView(view);
    }

    @Override
    public void onClick(View view) {

        if (view == button_save) {
            OnactionHide();
            progressBar.startAnimation(anim);

            if(quickactionListener!=null)
            {
                quickactionListener.onActionSave(view);
            }
        } else if (view == button_cancel) {
            if(quickactionListener!=null)
            {
                quickactionListener.onActionCancel(view);
            }
        }else if (view==imageView_bin)
        {
            if(quickactionListener!=null)
            {
                quickactionListener.onActionBin(view);
            }
        }
    }

    private void OnactionHide() {

//        linear_action.setVisibility(View.GONE);
//        linear_updating.setVisibility(View.VISIBLE);
        crossfade(linear_action,linear_updating);
    }

    @Override
    public void onAnimationStart(Animation animation) {
        textView_msg.setText("Updating...");
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        getHandler().postDelayed(new Runnable() {
            @Override
            public void run() {
                OnActionshow();
            }
        },3000);
        textView_msg.setText("Update Success");
    }

    private void OnActionshow() {
//        linear_action.setVisibility(View.VISIBLE);
//        linear_updating.setVisibility(View.GONE);
        crossfade(linear_updating,linear_action);

    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }


    private void crossfade(final View goneView, final View visibView) {

        ViewHelper.setAlpha(visibView, 0f);
        visibView.setVisibility(View.VISIBLE);
        ViewPropertyAnimator.animate(visibView).alpha(1f).setDuration(300).setListener(null);
        ViewPropertyAnimator.animate(goneView).alpha(0f).setDuration(300)
                .setListener(new Animator.AnimatorListener() {

                    @Override
                    public void onAnimationStart(
                            com.nineoldandroids.animation.Animator arg0) {

                    }

                    @Override
                    public void onAnimationRepeat(
                            com.nineoldandroids.animation.Animator arg0) {

                    }

                    @Override
                    public void onAnimationEnd(
                            com.nineoldandroids.animation.Animator arg0) {
                        goneView.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationCancel(
                            com.nineoldandroids.animation.Animator arg0) {

                    }
                });
    }

    /**
     * Implement to get cancel and save actions
     */
    public interface QuickactionListener
    {
        void onActionCancel(View v);
        void onActionSave(View v);
        void onActionBin(View v);
    }

        public void hideBin()
        {
            imageView_bin.setVisibility(View.GONE);
        }

}
