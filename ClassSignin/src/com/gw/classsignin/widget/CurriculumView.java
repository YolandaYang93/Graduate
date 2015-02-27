package com.gw.classsignin.widget;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.gw.classsignin.R;
import com.gw.classsignin.model.Course;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
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
import android.view.Gravity;
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
	
	private OnCourseClickListener onCourseClickListener;
	
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
	}
	
	private void initParams(){
		courseNum = 13;
		this.headerGridWidth = (int)(getMeasuredWidth() * 0.08);
		this.headerGridHeight = (int)(getMeasuredHeight() * 0.08);
		this.gridWidth = (getWidth() - headerGridWidth) / headerRow.length;
		this.gridHeight = (getHeight() - headerGridHeight) / courseNum;
	}
	
	public void setOnCourseClickListener(OnCourseClickListener onCourseClickListener){
		this.onCourseClickListener = onCourseClickListener;
	}
	
	public void setCourseList(ArrayList<Course> courseList){
		this.courseList = courseList;
		for (int i = 0; i < courseList.size(); i++) {
			Course course = courseList.get(i);
            TextView text = new TextView(context);
            text.setId(i);
            text.setTextSize(12);
            text.setTextColor(Color.parseColor("#999999"));
            text.setText(course.getName());
            text.setGravity(Gravity.CENTER);
            text.setBackground(getResources().getDrawable(R.drawable.shape_curriculum));
            text.setOnClickListener(new CurriculumListener(i));
            this.addView(text);  
		}
	}
	
	/**
	 * 设置curriculum里面的监听器
	 *
	 */
	protected class CurriculumListener implements OnClickListener{
		
		private int courseId;
		public CurriculumListener(int courseId){
			this.courseId = courseId;
		}

		@Override
		public void onClick(View v) {
			if(onCourseClickListener != null){
				onCourseClickListener.onItemClick(courseId, v);
			}
		}
	}
	
	private void setPos(){
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
		setPos();
		//抗锯齿
		canvas.setDrawFilter(new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG|Paint.FILTER_BITMAP_FLAG)); 
		headerPaint.setAlpha(50);
		canvas.drawRect(0, 0, getWidth(), headerGridHeight, headerPaint);
		canvas.drawRect(0, headerGridHeight, headerGridWidth, getHeight(), headerPaint);
		
		textPaint.setColor(Color.WHITE);
		textPaint.setTypeface(Typeface.create("微软雅黑", Typeface.BOLD));
		
		sepPaint.setColor(Color.parseColor("#87979a"));
		
		//画每星期分割线
		for (int i = 0; i < headerRow.length; i++) {
			//draw number
			textPaint.setTextSize(18);
			canvas.drawText(String.valueOf(i + 1), headerGridWidth + gridWidth * i + gridWidth / 2 - 5, headerGridHeight / 2 - 10, textPaint);
			//draw weekday
			textPaint.setTextSize(16);
			canvas.drawText(headerRow[i], headerGridWidth + gridWidth * i + gridWidth / 2 - 20, headerGridHeight / 2 + 15, textPaint);
			//draw seprator
			canvas.drawLine(headerGridWidth + gridWidth * i, 0, headerGridWidth + gridWidth * i, headerGridHeight - 1, sepPaint);
		}
		
		//画课程分割线
		for (int i = 0; i < this.courseNum; i++) {
			canvas.drawText(String.valueOf(i+1), headerGridWidth / 2 - 5, headerGridHeight + gridHeight * i + gridHeight / 2, textPaint);
			canvas.drawLine(0, headerGridHeight + gridHeight * i, headerGridWidth - 1, headerGridHeight + gridHeight * i, sepPaint);
		}	
		
		//画每一个十字符号
		for(int i = 1; i < headerRow.length; i++){
			for(int j = 1; j < this.courseNum; j++){
				float x0 = headerGridWidth+gridWidth*i-4;
				float x1 = headerGridWidth+gridWidth*i+4;
				float y0 = headerGridHeight+gridHeight*j;
				float y1 = headerGridHeight+gridHeight*j;
				
				float y3 = headerGridHeight+gridHeight*j-4;
				float y4 = headerGridHeight+gridHeight*j+4;
				float x3 = headerGridWidth+gridWidth*i;
				float x4 = headerGridWidth+gridWidth*i;
				float[] pts = {x0,y0,x1,y1,x3,y3,x4,y4};
				canvas.drawLines(pts, sepPaint);;
			}
			
		}
		
	}
	
	/**
	 * 每一个课程item被点击时的监听器
	 *
	 */
	public interface OnCourseClickListener{
		public void onItemClick(int courseId, View view);
	}
		

}
