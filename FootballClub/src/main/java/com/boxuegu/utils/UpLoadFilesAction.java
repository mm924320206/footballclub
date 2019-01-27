package com.boxuegu.utils;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.convention.annotation.Namespace;
import org.apache.struts2.convention.annotation.ParentPackage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/*@Controller
@Scope("prototype")
@Namespace("/")
@ParentPackage("football")*/
//原本是为了照片上传部分的工具类，分开，后来没试成功
public class UpLoadFilesAction extends ActionSupport{
 /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
static private File photoaddress;
 static private String photoaddressContentType;
 static private String photoaddressFileName;

public static File getPhotoaddress() {
	return photoaddress;
}

public static void setPhotoaddress(File photoaddress) {
	UpLoadFilesAction.photoaddress = photoaddress;
}

public static String getPhotoaddressContentType() {
	return photoaddressContentType;
}

public static void setPhotoaddressContentType(String photoaddressContentType) {
	UpLoadFilesAction.photoaddressContentType = photoaddressContentType;
}



public static String getPhotoaddressFileName() {
	return photoaddressFileName;
}

public static void setPhotoaddressFileName(String photoaddressFileName) {
	UpLoadFilesAction.photoaddressFileName = photoaddressFileName;
}

static public void uploadFile() throws Exception
{
	String path=ServletActionContext.getServletContext().getRealPath("/");
	System.out.println(path);
	File destFile=new File(path, photoaddressFileName);
	FileUtils.copyFile(photoaddress, destFile);
	}
}

