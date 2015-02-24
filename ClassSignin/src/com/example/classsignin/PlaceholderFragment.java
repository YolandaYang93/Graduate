package com.example.classsignin;

import com.example.classsignin.widget.CurriculumView;

import android.app.Fragment;
import android.os.Bundle;
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

	private void initView(){
		curriculumView = (CurriculumView)view.findViewById(R.id.curriculum_view);
	}
	
	private void initData(){
		
	}
}