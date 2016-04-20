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
 * �ļ��ϴ���̨������
 */
public class UpLoad extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		// ����������ı���
		try {
			request.setCharacterEncoding("utf-8");
			// �ж��ǲ����ļ��ϴ�
			boolean isMulitpart = ServletFileUpload.isMultipartContent(request);
			System.out.println(isMulitpart);
			if (isMulitpart) {
				// 1��ʵ�������̹���
				DiskFileItemFactory factory = new DiskFileItemFactory();
				// 2�������ļ��ϴ�����
				ServletFileUpload upload = new ServletFileUpload();
				// 3����ȡ�ļ��ϴ�����
				try {
					List<FileItem> fileitems = upload.parseRequest(request);
					// ʹ�õ�������ȡ�ļ�
					Iterator<FileItem> iter = fileitems.iterator();
					while (iter.hasNext()) {
						FileItem item = iter.next();
						// ֻ�����ļ�����item
						if (!item.isFormField()) {
							// �ж��ļ��Ƿ�ѡ�����û��ѡ��Ҳ���ύ�ļ�����
							// д����־
							if (item.getName() != null
									&& item.getName().equals(" ")) {
								// 4�����浽������
								//������ʱ�ļ�
								File tmpFile = new File(item.getName());
								//�����������ļ�
								File fileOnserver = new File(this.getServletContext().getRealPath("/files"),tmpFile.getName());
								//д���ļ�����
								item.write(fileOnserver);
								System.out.println("�ļ��ϴ��ɹ���");
							}
						}
					}
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			
			} else {
				// д����־
				System.out.println("�����ļ��ϴ��ı������ݣ�");
			}

		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}