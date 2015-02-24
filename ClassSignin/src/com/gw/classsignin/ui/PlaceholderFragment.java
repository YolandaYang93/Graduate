package com.gw.classsignin.ui;

import java.util.ArrayList;

import com.gw.classsignin.R;
import com.gw.classsignin.model.Course;
import com.gw.classsignin.widget.CurriculumView;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A placeholder fragment containing a simple view.
 */
public class PlaceholderFragment extends Fragment {

	private View view;
	private CurriculumView curriculumView;
	
	public PlaceholderFragment() {
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.frag_main, container,
				false);
		this.view = rootView;
		initView();
		return rootView;
	}
	
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		initData();
	}
	

	@Override
	public void onResume() {
		super.onResume();
		Log.i("fragment", "resume");
	}

	private void initView(){
		curriculumView = (CurriculumView)view.findViewById(R.id.curriculum_view);
	}
	
	private void initData(){
		ArrayList<Course> courseList = new ArrayList<Course>();
		courseList.add(new Course("1", "马克思", "1", "尹川东", 1, 3, 5));
		courseList.add(new Course("2", "马克思", "1", "尹川东", 2, 1, 2));
		courseList.add(new Course("3", "马克思", "1", "尹川东", 4, 6, 7));
		curriculumView.setCourseList(courseList);
	}
}