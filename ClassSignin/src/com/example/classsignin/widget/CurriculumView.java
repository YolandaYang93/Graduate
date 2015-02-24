package com.example.classsignin.widget;

import com.example.classsignin.R;

import android.annotation.SuppressLint;
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
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CurriculumView extends RelativeLayout{
	
	private Context context;
	
	public CurriculumView(Context context) {
		super(context);
		this.context = context;
		initView();
	}

	public CurriculumView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		initView();
	}


	@SuppressLint("NewApi")
	private void initView(){
		

		TextView[] buts = new TextView[2];
		for(int num=0;num<2;num++){
            RelativeLayout.LayoutParams oParams = new RelativeLayout.LayoutParams(100,60);
            buts[num] = new TextView(context);
            buts[num].setId(num+1);
            buts[num].setText("o");
            buts[num].setBackground(getResources().getDrawable(R.drawable.shape_curriculum));
            oParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            oParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            oParams.leftMargin = 100 * num;
            oParams.topMargin = 60;
            
            this.addView(buts[num],oParams);
        }
		
		
	}
	

}
