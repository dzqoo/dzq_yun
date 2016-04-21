package com.neu.yun.servlet;

import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.ProgressListener;

public class YunProgressListener  implements  ProgressListener{
	
	private HttpSession session;
	public YunProgressListener(HttpSession session){
		this.session = session;
	}
	
/**
 * @param readBytes 已经读取的大小
 * @param totalBytes 文件的总大小
 * @param pItem 当前上传文件的序列号
 */
	@Override
	public void update(long readBytes, long totalBytes, int pItem) {
		String value = "var obj={read:"+readBytes+",total:"+totalBytes+",item:"+pItem+"}";
		session.setAttribute("progress", value);
	}

}
