package com.neu.yun.servlet;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/*
 * 文件上传后台处理类
 */
public class UpLoad extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// 设置请求域的编码
		try {
			request.setCharacterEncoding("utf-8");
			// 判断是不是文件上传
			boolean isMulitpart = ServletFileUpload.isMultipartContent(request);
			if (isMulitpart) {
				// 1、实例化磁盘工厂
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 2、创建文件上传对象
				ServletFileUpload upload = new ServletFileUpload(factory);
				// 3、获取文件上传对象
				try {
					List<FileItem> fileitems =upload.parseRequest(request);
					// 使用迭代器获取文件
					Iterator<FileItem> iter = fileitems.iterator();
					while (iter.hasNext()) {
						FileItem item = iter.next();
						// 只处理文件对象item
						if (!item.isFormField()) {
							// 判断文件是否选择，如果没有选择也会提交文件对象
							// 写入日志
							if (item.getName() != null
									&& !item.getName().equals(" ")) {	
								System.out.println("dzq_test");
								// 4、保存到服务器
								//创建临时文件
								File tmpFile = new File(item.getName());
								String  path = request.getServletContext().getRealPath("/");
								System.out.println(path);
								path = path+"files";
								File files = new File(path);
								files.mkdirs();
								System.out.println(path);
								//创建服务器文件夹
								//创建服务器文件
								File fileOnserver = new File(path,tmpFile.getName());
								//System.out.println(fileOnserver.getAbsolutePath());
								//写入文件内容
								item.write(fileOnserver);
								System.out.println("文件上传成功！");
							}
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else {
				// 写入日志
				System.out.println("不是文件上传的表单数据！");
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
