package com.example.materialtest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class TowerViewObject extends View implements Runnable{

	private Paint mPaint;
	
	public TowerViewObject(Context context, int width) {
		super(context); 
		mPaint = new Paint();
		new Thread(this).start();  
	}
	
	@Override  
    protected void onDraw(Canvas canvas) {  
        super.onDraw(canvas);
        
        mPaint.setAntiAlias(true);  
        mPaint.setColor(Color.RED);  
        mPaint.setAlpha(220); 
        mPaint.setStyle(Paint.Style.FILL);  
        canvas.drawRect(0, 20, 40, 20 + 40, mPaint);  
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (!Thread.currentThread().isInterrupted()) {  
            try {  
                Thread.sleep(100);  
            } catch (Exception e) {  
                Thread.currentThread().interrupt();  
            }  
            postInvalidate();  
        }  
	}
}
