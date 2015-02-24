package com.gw.classsignin.widget;

import android.R.integer;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;

public class CurriculumView2 extends View{
	
	public CurriculumView2(Context context) {
		super(context);
	}

	public CurriculumView2(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();
		paint.setColor(Color.RED);
		Drawable drawable = getBackground();
		
		if(!(drawable instanceof BitmapDrawable)){
			return;
		}
		
		Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
		
		int bwidth = bitmap.getWidth();
		int bheight = bitmap.getHeight();
		int cwidth = getWidth();
		int cheight = getHeight();
		
		int headerWidth = 10;
		
		Log.i("---", "---");
		
//		Bitmap bitmap = 
//		canvas.drawBitmap(bitmap, 0, 0, paint);
//		
	}

	
	

}
