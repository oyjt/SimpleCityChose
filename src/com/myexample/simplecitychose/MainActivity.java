package com.myexample.simplecitychose;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.view.View.OnTouchListener;
import android.widget.EditText;

public class MainActivity extends Activity{

	private EditText etCity;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		etCity = (EditText)findViewById(R.id.etCity);
		etCity.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				//所在地
		        ProvincesDialogFragment provincesDialogFragment = new ProvincesDialogFragment();
		        Bundle provincesBundle = new Bundle();
		        provincesBundle.putString(ProvincesPickerDialog.LOCATION, "福建");
		        provincesBundle.putString(ProvincesPickerDialog.TITLE, "选择所在地");
		        provincesDialogFragment.setArguments(provincesBundle);
		        provincesDialogFragment.setCallBack(new ProvincesPickerDialog.OnDateSetListener() {
		            @Override
		            public void onDateSet(String provinceStr) {
		                if (!etCity.getText().toString().trim().equals(provinceStr)) {
		                	etCity.setText(provinceStr);
		                }
		            }
		        });
		        //provincesDialogFragment.setCancelable(true);
		        provincesDialogFragment.show(getFragmentManager(), "provincesPicker");
		        getFragmentManager().executePendingTransactions();
			}
		});
	}

}
