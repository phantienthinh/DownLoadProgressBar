package com.example.downloadprogressbar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DownLoadProgressbar extends View {
    private Context mContext;
    private int padding;
    private Paint paintBackground;
    private Paint paintProgress;
    private int widthView, heightView;
    private int progressHeight;
    private int progressHeightBound;
    private int paddingBound;
    private float ratioWidthBorder = 10 / 15;
    private float ratioPaddingBound = 10 / 13;


    public DownLoadProgressbar(Context context) {
        this(context, null);
    }

    public DownLoadProgressbar(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public DownLoadProgressbar(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mContext = context;
        initView(attrs);
        initPaint();
    }

    private void initPaint() {
        paintBackground = new Paint(Paint.ANTI_ALIAS_FLAG);
        paintBackground.setColor(getResources().getColor(R.color.colorAccent));
        paintBackground.setStyle(Paint.Style.STROKE);
        paintBackground.setStrokeWidth(progressHeight);
        paintBackground.setAlpha(255);
    }

    private void initView(AttributeSet attrs) {
        TypedArray typedArray = mContext.getTheme().obtainStyledAttributes(attrs, R.styleable.DownLoadProgressbar, 0, 0);
        progressHeight = typedArray.getDimensionPixelSize(R.styleable.DownLoadProgressbar_progressHeight, Utils.convertDpToPixel(13, mContext));
        progressHeightBound = typedArray.getDimensionPixelSize(R.styleable.DownLoadProgressbar_progressHeightBound, Utils.convertDpToPixel(10, mContext));
        checkSizeHeight();
        paddingBound = (progressHeight - progressHeightBound) / 2;
        padding = Utils.convertDpToPixel(10, mContext) * 2;
    }

    private void checkSizeHeight() {
        if (progressHeight < progressHeightBound) {
            if (progressHeightBound > 0)
                progressHeight = progressHeightBound;
            else {
                progressHeightBound = Utils.convertDpToPixel(10, mContext);
                progressHeight = progressHeightBound;
            }
        }
        if (progressHeightBound <= 0) {
            progressHeightBound = Utils.convertDpToPixel(10, mContext);
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

        int widthMode = MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = MeasureSpec.getMode(heightMeasureSpec);
        int widthSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSize = MeasureSpec.getSize(heightMeasureSpec);

        setMeasuredDimension(getMeasuredWidthProgress(widthSize, widthMode),
                getMeasuredHeightProgress(heightSize, heightMode));


    }

    private int getMeasuredHeightProgress(int heightSize, int heightMode) {
        if (heightMode == MeasureSpec.EXACTLY) {
            heightView = heightSize;
        } else if (heightMode == MeasureSpec.AT_MOST) {
            heightView = Math.min(heightSize, progressHeight + padding);
        } else {
            heightView = progressHeight + padding;
        }
        return heightView;
    }

    private int getMeasuredWidthProgress(int widthSize, int widthMode) {
        if (widthMode == MeasureSpec.EXACTLY) {
            widthView = widthSize;
        } else if (widthMode == MeasureSpec.AT_MOST) {
            widthView = widthSize;
        } else {
            widthView = widthSize;
        }
        return widthView;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF();
        rectF.left = 0;
        rectF.right = 150;
        rectF.top = 300;
        rectF.bottom = 300;
//        canvas.drawRoundRect(0, paddingBound + progressHeight + padding >> 1, widthView, paddingBound + progressHeight + padding >> 1, paintBackground);
//        canvas.drawRoundRect(rectF,20,20,paintBackground);
        canvas.drawRoundRect(rectF,20,20,paintBackground);
    }
}
