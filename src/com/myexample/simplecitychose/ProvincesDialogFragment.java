package com.myexample.simplecitychose;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;

public class ProvincesDialogFragment extends DialogFragment implements ProvincesPickerDialog.OnDateSetListener {

	private ProvincesPickerDialog.OnDateSetListener mCallBack;

	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String title = getArguments().getString(ProvincesPickerDialog.TITLE);
		String location = getArguments().getString(ProvincesPickerDialog.LOCATION);
		return new ProvincesPickerDialog(getActivity(), this, title, location);
	}

	public void setCallBack(ProvincesPickerDialog.OnDateSetListener mCallBack) {
		this.mCallBack = mCallBack;
	}

	@Override
	public void onDateSet(String provinceStr) {
		if (mCallBack != null)
			mCallBack.onDateSet(provinceStr);
	}

}
