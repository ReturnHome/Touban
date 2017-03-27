package com.example.touban.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.touban.R;
import com.example.touban.listener.IBottomBarClickListener;

public class MainActivity extends BaseActivity implements
		IBottomBarClickListener {

	private FragmentManager mFragmentManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mFragmentManager = getSupportFragmentManager();
		initUI();
	}

	@Override
	protected void initUI() {

	}

	@Override
	public void onItemClick(int action) {
		FragmentTransaction transaction = mFragmentManager.beginTransaction();
		switch (action) {


		}
		transaction.commit();
	}

}
