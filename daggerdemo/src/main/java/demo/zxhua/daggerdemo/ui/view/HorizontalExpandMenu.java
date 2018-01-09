package demo.zxhua.daggerdemo.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.RelativeLayout;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.utils.UiUtil;

/**
 * Created by Zxhua on 2017/12/26 0026.
 */

public class HorizontalExpandMenu extends RelativeLayout {
    private Context mContext;
    private AttributeSet mAttrs;

    private int defaultWidth;
    private int defaultHeight;
    private int viewWidth;
    private int viewHeight;

    private int menuBackColor;
    private float menuStrokeSize;
    private int menuStorkeColor;
    private float menuCornerRadius;

    private float backPathWidth;
    private float maxBackPathWidth;
    private int menuLeft;
    private int menuRight;

    private boolean isFirstLayout;

    private boolean isExpand;
    private float downX = -1;
    private float downY = -1;
    private int expandAnimTime;
    private ExpandMenuAnim anim;

    private MenuButton menuButton;
    private boolean isAnimEnd;

    private View childView;


    public HorizontalExpandMenu(Context context) {
        super(context);
        this.mContext = context;
        init();
    }

    public HorizontalExpandMenu(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.mAttrs = attrs;
        init();
    }

    private void init() {
        TypedArray typedArray = mContext.obtainStyledAttributes(mAttrs, R.styleable.HorizontalExpandMenu);

        menuButton = new MenuButton(mContext);
        menuButton.init(typedArray);

        defaultHeight = UiUtil.dp2px(20);
        defaultWidth = UiUtil.dp2px(40);

        expandAnimTime = typedArray.getInteger(R.styleable.HorizontalExpandMenu_expand_time, 400);
        menuBackColor = typedArray.getColor(R.styleable.HorizontalExpandMenu_back_color, Color.WHITE);
        menuStrokeSize = typedArray.getDimension(R.styleable.HorizontalExpandMenu_stroke_size, 1);
        menuStorkeColor = typedArray.getColor(R.styleable.HorizontalExpandMenu_stroke_color, Color.GRAY);
        menuCornerRadius = typedArray.getDimension(R.styleable.HorizontalExpandMenu_corner_radius, UiUtil.dp2px(20));
        typedArray.recycle();
        isFirstLayout = true;
        isExpand = true;
        isAnimEnd = false;
        anim = new ExpandMenuAnim();
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                isAnimEnd = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int height = measureSize(defaultHeight, heightMeasureSpec);
        int width = measureSize(defaultWidth, widthMeasureSpec);
        viewHeight = height;
        viewWidth = width;
        setMeasuredDimension(viewWidth, viewHeight);

        menuButton.onMeasure(viewHeight, viewWidth);

        maxBackPathWidth = viewWidth - 2 * menuButton.buttonRadius;
        backPathWidth = maxBackPathWidth;

        if (getBackground() == null) {
            setMenuBackground();
        }
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        super.onLayout(changed, l, t, r, b);
        if (isFirstLayout) {
            menuLeft = getLeft();
            menuRight = getRight();
            isFirstLayout = false;
        }

        if (getChildCount() > 1) {
            throw new IllegalStateException("HorizontalExpandMenu can host only one direct child");
        }
        if (getChildCount() > 0) {
            childView = getChildAt(0);
            if (isExpand) {
                if (menuButton.buttonStyle == MenuButton.ButtonStyle.RIGHT) {
                    childView.layout(menuButton.leftButtonCenter.x, (int) menuButton.buttonTop, (int) menuButton.rightButtonLeft, (int) menuButton.buttonBottom);
                } else {
                    childView.layout((int) menuButton.leftButtonRight, (int) menuButton.buttonTop, menuButton.rightButtonCenter.x, (int) menuButton.buttonBottom);
                }
                @SuppressLint("DrawAllocation")
                RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(viewWidth, viewHeight);
                layoutParams.setMargins(0, 0, menuButton.buttonRadius * 3, 0);
                childView.setLayoutParams(layoutParams);
            }
        }
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        viewWidth = w;

        if (isAnimEnd) {
            if (menuButton.buttonStyle == MenuButton.ButtonStyle.RIGHT) {
                if (!isExpand) {
                    layout((int) (menuRight - menuButton.buttonRadius * 2), getTop(), menuRight, getBottom());
                }
            } else {
                if (!isExpand) {
                    layout(menuLeft, getTop(), (int) (menuLeft + menuButton.buttonRadius * 2), getBottom());
                }
            }
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        menuButton.onDraw(canvas);
        super.onDraw(canvas);
    }

    private int measureSize(int defaultSize, int measureSpec) {
        int result = defaultSize;
        int specMode = View.MeasureSpec.getMode(measureSpec);
        int specSzie = View.MeasureSpec.getSize(measureSpec);

        if (specMode == MeasureSpec.EXACTLY) {
            result = specSzie;
        } else if (specMode == MeasureSpec.AT_MOST) {
            result = Math.max(result, specSzie);
        }
        return result;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        super.onTouchEvent(event);
        float x = event.getX();
        float y = event.getY();
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                downY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                if (backPathWidth == maxBackPathWidth || backPathWidth == 0)
                    switch (menuButton.buttonStyle) {
                        case MenuButton.ButtonStyle.LEFT:
                            if (downX == x && downY == y && menuButton.isLeftBtnScope(x, y)) {
                                expandMenu(expandAnimTime);
                            }
                            break;
                        case MenuButton.ButtonStyle.RIGHT:
                            if (downX == x && downY == y && menuButton.isRightBtnScope(x, y)) {
                                expandMenu(expandAnimTime);
                            }
                            break;
                    }
                break;
        }
        return true;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    private void setMenuBackground() {
        GradientDrawable gd = new GradientDrawable();
        gd.setColor(menuBackColor);
        gd.setStroke((int) menuStrokeSize, menuStorkeColor);
        gd.setCornerRadius(menuCornerRadius);
        setBackground(gd);
    }

    private void expandMenu(int time) {
        anim.setDuration(time);
        isExpand = !isExpand;
        startAnimation(anim);
        isAnimEnd = false;
        childView.setVisibility(isExpand ? VISIBLE : GONE);
    }


    private class ExpandMenuAnim extends Animation {

        public ExpandMenuAnim() {
        }

        @Override
        protected void applyTransformation(float interpolatedTime, Transformation t) {
            super.applyTransformation(interpolatedTime, t);
            float left = menuRight - 2 * menuButton.buttonRadius;
            float right = +2 * menuButton.buttonRadius;

            if (isExpand) {
                menuButton.setButtonIconDegress(interpolatedTime * 90);
                backPathWidth = maxBackPathWidth * interpolatedTime;
                if (backPathWidth == maxBackPathWidth) {
                    childView.setVisibility(VISIBLE);
                }
            } else {
                menuButton.setButtonIconDegress(90 - interpolatedTime * 90);
                backPathWidth = maxBackPathWidth - maxBackPathWidth * interpolatedTime;
            }
            if (menuButton.buttonStyle == MenuButton.ButtonStyle.RIGHT) {
                layout((int) (left - backPathWidth), getTop(), menuRight, getBottom());
            } else {
                layout(menuLeft, getTop(), (int) (right + backPathWidth), getBottom());
            }
            postInvalidate();
        }
    }


}
