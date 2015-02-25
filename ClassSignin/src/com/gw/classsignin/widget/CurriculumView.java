package com.gw.classsignin.widget;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.gw.classsignin.R;
import com.gw.classsignin.model.Course;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.style.TypefaceSpan;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class CurriculumView extends RelativeLayout{
	
	private Context context;
	
	private ArrayList<Course> courseList;
	private String[] headerRow = {"星期一","星期二","星期三","星期四","星期五","星期六","星期日"};
	private int courseNum;
	
	private int headerGridWidth;
	private int headerGridHeight;
	private int gridWidth;
	private int gridHeight;
	
	public CurriculumView(Context context) {
		super(context);
		this.context = context;
		init();
	}

	public CurriculumView(Context context, AttributeSet attrs) {
		super(context, attrs);
		this.context = context;
		init();
	}
	
	private void init(){
		initPaint();
//		initParams();
//		testView();
	}
	
	private void initParams(){
		courseNum = 13;
		this.headerGridWidth = (int)(getMeasuredWidth() * 0.08);
		this.headerGridHeight = (int)(getMeasuredHeight() * 0.08);
		this.gridWidth = (getWidth() - headerGridWidth) / headerRow.length;
		this.gridHeight = (getHeight() - headerGridHeight) / courseNum;
	}

	private void testView(){
		
		TextView[] buts = new TextView[2];
		for(int num=0;num<1;num++){
            RelativeLayout.LayoutParams oParams = new RelativeLayout.LayoutParams(100, 100);
            buts[num] = new TextView(context);
            buts[num].setId(num+1);
            buts[num].setText("o");
            buts[num].setBackground(getResources().getDrawable(R.drawable.shape_curriculum));
            oParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            oParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            oParams.leftMargin = 100 * (num + 1);
            oParams.topMargin = 100;
            
            this.addView(buts[num],oParams);
        }
	}
	
	
	public void setCourseList(ArrayList<Course> courseList){
		this.courseList = courseList;
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
            TextView text = new TextView(context);
            text.setId(i);
            text.setText(course.getName());
            text.setBackground(getResources().getDrawable(R.drawable.shape_curriculum));
            
            this.addView(text);
		}
	}
	
	private void resetPos(){
		if(courseList == null){
			return;
		}
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
			int cheight = (course.getEndSection() - course.getStartSection() + 1) * gridHeight;
            TextView text = (TextView) getChildAt(i);

			RelativeLayout.LayoutParams oParams = new RelativeLayout.LayoutParams(gridWidth, cheight);
            oParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT);
            oParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            oParams.leftMargin = course.getWeek() * gridWidth + headerGridWidth;
            oParams.topMargin = (course.getStartSection() - 1) * gridHeight + headerGridHeight;
            text.setLayoutParams(oParams);
		}
	}
	
	private void initPaint(){
		headerPaint = new Paint();
		textPaint = new Paint();
		sepPaint = new Paint();
	}
	
	private static Paint headerPaint;
	private static Paint textPaint;
	private static Paint sepPaint;
	
	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		initParams();
		resetPos();
		//抗锯齿
		canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG)); 
		headerPaint.setAlpha(50);
		canvas.drawRect(0, 0, getWidth(), headerGridHeight, headerPaint);
		canvas.drawRect(0, headerGridHeight, headerGridWidth, getHeight(), headerPaint);
		
		textPaint.setColor(Color.WHITE);
		textPaint.setTypeface(Typeface.create("微软雅黑", Typeface.BOLD));
		
		sepPaint.setColor(Color.GRAY);
		for (int i = 0; i < headerRow.length; i++) {
			//draw number
			textPaint.setTextSize(16);
			canvas.drawText(String.valueOf(i + 1), headerGridWidth + gridWidth * i + gridWidth / 2 - 5, headerGridHeight / 2 - 10, textPaint);
			//draw weekday
			textPaint.setTextSize(14);
			canvas.drawText(headerRow[i], headerGridWidth + gridWidth * i + gridWidth / 2 - 20, headerGridHeight / 2 + 15, textPaint);
			//draw seprator
			canvas.drawLine(headerGridWidth + gridWidth * i, 0, headerGridWidth + gridWidth * i, headerGridHeight - 1, sepPaint);
		}
		
		for (int i = 0; i < this.courseNum; i++) {
			canvas.drawText(String.valueOf(i+1), headerGridWidth / 2 - 5, headerGridHeight + gridHeight * i + gridHeight / 2, textPaint);
			canvas.drawLine(0, headerGridHeight + gridHeight * i, headerGridWidth - 1, headerGridHeight + gridHeight * i, sepPaint);
		}		
	}
}
