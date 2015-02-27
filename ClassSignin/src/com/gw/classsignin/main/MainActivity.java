package com.gw.classsignin.main;

import javax.security.auth.PrivateCredentialPermission;

import com.gw.classsignin.R;
import com.gw.classsignin.ui.PlaceholderFragment;

import android.app.Activity;
import android.app.ActionBar;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.os.Build;
import android.renderscript.Mesh.Primitive;
import android.support.v4.app.ActionBarDrawerToggle;

public class MainActivity extends Activity {

	private TextView lesson_list_btn;
	private TextView me_btn;
	private TextView sign_btn;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		if (savedInstanceState == null) {
			getFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
		initViews();
		initActionbar();
	}

	private void initViews() {
		lesson_list_btn = (TextView)findViewById(R.id.lesson_list_btn);
		sign_btn = (TextView)findViewById(R.id.sign_btn);
		me_btn = (TextView)findViewById(R.id.me_btn);

	}
	

	private void initActionbar(){
//		getActionBar().setIcon(R.drawable.drop_select);
//		drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.nav_white, R.string.app_name, R.string.app_name){
//			@Override
//			public void onDrawerClosed(View view){
//				super.onDrawerClosed(view);
////					getActionBar().setTitle("closed");
//			}
//			
//			@Override
//			public void onDrawerOpened(View drawerView){
//				super.onDrawerOpened(drawerView);
////					getActionBar().setTitle("opened");
//				//关闭软键盘，因为软键盘和listview有冲突
////					InputMethodManager inputManager = (InputMethodManager)searchTag.editTextView.getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
////					inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
//			}
//		};
//		
//		drawerLayout.setDrawerListener(drawerToggle);
//		getActionBar().setDisplayUseLogoEnabled(false);
//		getActionBar().setDisplayHomeAsUpEnabled(true);
//		getActionBar().setHomeButtonEnabled(true);
	}		
	
	
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_overflow) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
