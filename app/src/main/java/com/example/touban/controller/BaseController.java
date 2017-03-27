package com.example.touban.controller;


import com.example.touban.listener.IModeChangeListener;

public abstract class BaseController {

	protected IModeChangeListener mListener;

	public void setIModeChangeListener(IModeChangeListener listener) {
		mListener=listener;
	}
	
	/**
	 * @param action  һ��ҳ������ж����������,����������Щ�����
	 * @param values ���������
	 */
	public void sendAsyncMessage(final int action,final Object... values){
		new Thread(){
			public void run() {
				handleMessage(action, values);
			}
		}.start();
	}
	
	/**
	 * ���ദ�����������ҵ�����
	 */
	protected abstract void handleMessage(int action,Object... values);
	

}
