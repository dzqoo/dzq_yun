package com.neu.yun.servlet;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class YunProgressListener  implements  ProgressListener{
	
	private HttpSession session;
	public YunProgressListener(HttpSession session){
		this.session = session;
	}
	
/**
 * @param readBytes �Ѿ���ȡ�Ĵ�С
 * @param totalBytes �ļ����ܴ�С
 * @param pItem ��ǰ�ϴ��ļ������к�
 */
	@Override
	public void update(long readBytes, long totalBytes, int pItem) {
		String value = "var obj={read:"+readBytes+",total:"+totalBytes+",item:"+pItem+"}";
		session.setAttribute("progress", value);
	}

}
