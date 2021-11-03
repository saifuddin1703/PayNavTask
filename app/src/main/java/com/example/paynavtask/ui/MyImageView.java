package com.example.paynavtask.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.ViewOutlineProvider;

import com.example.paynavtask.R;

/**
 * TODO: document your custom view class.
 */
public class MyImageView extends androidx.appcompat.widget.AppCompatImageView {
    public MyImageView(Context context) {
        super(context);
        init(null, 0);
    }

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    private void init(AttributeSet attrs, int defStyle) {

        setBackgroundResource(R.drawable.imagebackground);
        setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        setClipToOutline(true);
//        invalidateTextPaintAndMeasurements();
    }

    private void invalidateTextPaintAndMeasurements() {

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        // Draw the text.

    }

    /**
     * Gets the example string attribute value.
     *
     * @return The example string attribute value.
     */
}
