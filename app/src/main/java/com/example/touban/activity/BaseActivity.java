package com.example.touban.activity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.Window;
import android.widget.Toast;

import com.example.touban.controller.BaseController;
import com.example.touban.listener.IModeChangeListener;


public abstract class BaseActivity extends FragmentActivity implements
		IModeChangeListener {

	protected BaseController mController;
	protected Handler mHandler = new Handler() {

		public void handleMessage(Message msg) {
			handlerMessage(msg);
		}

	};

	/**
	 * 处理请求数据
	 * @param msg
     */
	protected void handlerMessage(Message msg) {
		// default Empty implementn
	}

	/**
	 * 初始化控制器
	 */
	protected void initController() {
		// default Empty implementn
	}

	protected abstract void initUI();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
	}


	/**
	 * 显示Toast
	 * @param tipStr Toast显示内容
     */
	public void tip(String tipStr) {
		Toast.makeText(this, tipStr, Toast.LENGTH_SHORT).show();
	}

	@Override
	public void onModeChanged(int action, Object... values) {
		mHandler.obtainMessage(action, values[0]).sendToTarget();
	}

	protected boolean ifValueWasEmpty(String... values) {
		for (String value : values) {
			if (TextUtils.isEmpty(value)) {
				return true;
			}
		}
		return false;
	}
}
