package demo.zxhua.daggerdemo.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;

import demo.zxhua.daggerdemo.R;
import demo.zxhua.daggerdemo.utils.UiUtil;

/**
 * Created by Zxhua on 2017/12/26 0026.
 */

public class MenuButton {


    public class ButtonStyle {
        public static final int LEFT = 1;
        public static final int RIGHT = 0;
    }

    private Path path;

    private Paint buttonIconPaint;
    private float buttonIconDegress;
    private float buttonIconSize;
    private float buttonIconStrokeWidth;
    private int buttonIconColor;

    public int buttonStyle;
    public int buttonRadius;
    public float buttonTop;
    public float buttonBottom;

    public Point rightButtonCenter;
    public float rightButtonLeft;
    public float rightButtonRight;

    public Point leftButtonCenter;
    public float leftButtonLeft;
    public float leftButtonRight;

    private int groupHeight;
    private int groupWidth;


    public MenuButton(Context context) {

    }


    public void init(TypedArray typedArray) {
        buttonStyle = typedArray.getInteger(R.styleable.HorizontalExpandMenu_button_style, ButtonStyle.RIGHT);
        buttonIconDegress = 90;
        buttonIconSize = typedArray.getDimension(R.styleable.HorizontalExpandMenu_button_icon_size, UiUtil.dp2px(8));
        buttonIconColor = typedArray.getColor(R.styleable.HorizontalExpandMenu_button_icon_color, Color.GRAY);
        buttonIconStrokeWidth = typedArray.getDimension(R.styleable.HorizontalExpandMenu_button_icon_stroke_width, 6);

        buttonIconPaint = new Paint();
        leftButtonCenter = new Point();
        rightButtonCenter = new Point();

        path = new Path();

        buttonIconPaint.setStrokeWidth(buttonIconStrokeWidth);
        buttonIconPaint.setColor(buttonIconColor);
        buttonIconPaint.setStyle(Paint.Style.STROKE);
    }

    public void setButtonIconDegress(float degress) {
        this.buttonIconDegress = degress;
    }

    public boolean isLeftBtnScope(float x, float y) {

        return x >= leftButtonLeft && x <= leftButtonRight && y >= buttonTop && y <= buttonBottom;
    }

    public boolean isRightBtnScope(float x, float y) {
        return x >= rightButtonLeft && x <= rightButtonRight && y >= buttonTop && y <= buttonBottom;
    }

    public void onMeasure(int viewHeight, int viewWidth) {
        groupHeight = viewHeight;
        groupWidth = viewWidth;
        buttonRadius = groupHeight / 2;
        layoutRootButton();
    }

    public void onDraw(Canvas canvas) {
        layoutRootButton();
        if (buttonStyle == ButtonStyle.RIGHT) {
            drawRightIcon(canvas);
        } else {
            drawLeftIcon(canvas);
        }
    }

    private void drawLeftIcon(Canvas canvas) {
        path.reset();
        path.moveTo(leftButtonCenter.x - buttonIconSize, leftButtonCenter.y);
        path.lineTo(leftButtonCenter.x + buttonIconSize, leftButtonCenter.y);
        canvas.drawPath(path, buttonIconPaint);

        canvas.save();
        canvas.rotate(-buttonIconDegress, leftButtonCenter.x, leftButtonCenter.y);
        path.reset();
        path.moveTo(leftButtonCenter.x, leftButtonCenter.y - buttonIconSize);
        path.lineTo(leftButtonCenter.x, leftButtonCenter.y + buttonIconSize);
        canvas.drawPath(path, buttonIconPaint);
        canvas.restore();
    }

    private void drawRightIcon(Canvas canvas) {
        path.reset();
        path.moveTo(rightButtonCenter.x - buttonIconSize, rightButtonCenter.y);
        path.lineTo(rightButtonCenter.x + buttonIconSize, rightButtonCenter.y);
        canvas.drawPath(path, buttonIconPaint);

        canvas.save();
        canvas.rotate(-buttonIconDegress, rightButtonCenter.x, rightButtonCenter.y);
        path.reset();
        path.moveTo(rightButtonCenter.x, rightButtonCenter.y - buttonIconSize);
        path.lineTo(rightButtonCenter.x, rightButtonCenter.y + buttonIconSize);
        canvas.drawPath(path, buttonIconPaint);
        canvas.restore();
    }

    private void layoutRootButton() {
        buttonTop = 0;
        buttonBottom = groupHeight;

        rightButtonCenter.x = groupWidth - buttonRadius;
        rightButtonCenter.y = groupHeight / 2;
        rightButtonLeft = rightButtonCenter.x - buttonRadius;
        rightButtonRight = rightButtonCenter.x + buttonRadius;

        leftButtonCenter.x = buttonRadius;
        leftButtonCenter.y = groupHeight / 2;
        leftButtonLeft = leftButtonCenter.x - buttonRadius;
        leftButtonRight = leftButtonCenter.x + buttonRadius;
    }


}
