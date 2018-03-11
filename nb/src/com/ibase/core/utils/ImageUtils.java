package com.ibase.core.utils;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.UUID;

import javax.imageio.ImageIO;

import com.ibase.web.roadtest.domain.Image;

/*******************************************************************
 * 该JavaBean可以直接在其他Java应用程序中调用，实现屏幕的"拍照" This JavaBean is used to snapshot the
 * GUI in a Java application! You can embeded it in to your java application
 * source code, and us it to snapshot the right GUI of the application
 * 
 * @see javax.ImageIO
 * @author liluqun
 * @version 1.0
 *****************************************************/

public class ImageUtils {
	static Image image = new Image();

	/*
	 * public void Test() { Image image = new Image(); String defaultName =
	 * image.getDefaultName(); image.setFileName(defaultName); String
	 * defaultImageFormat = image.getDefaultImageFormat();
	 * image.setImageFormat(defaultImageFormat);
	 * 
	 * 
	 * }
	 */

	/****************************************************************
	 * @param s
	 *            the surname of the snapshot file
	 * @param format
	 *            the format of the image file, it can be "jpg" or "png"
	 *            本构造支持JPG和PNG文件的存储
	 ****************************************************************/
	public static Image Testimage(String s, String format) {

		image.setRti_name(s);
		image.setRti_formate(format);
		;

		return image;
	}

	/****************************************************************
	 * 对屏幕进行拍照 snapShot the Gui once
	 ****************************************************************/
	public static Image snapShot(long rtf_id,String target_name,String s, String format) {
		String photoId = UUID.randomUUID().toString().substring(0, 5);
		String fileName = s;
		String imageFormat = format;
		String name ="";
		String rti_name ="";
		Dimension d = image.getD();
		try {
			// 拷贝屏幕到一个BufferedImage对象screenshot
			BufferedImage screenshot = (new Robot())
					.createScreenCapture(new Rectangle((int) (d.getWidth()-1050)/2, (int) (d.getHeight()-450)/2, 1020, 500));
			// 根据文件前缀变量和文件格式变量，自动生成文件名
		    name = fileName +rtf_id+"_"+target_name+"_" +photoId + "." + imageFormat;
			File f = new File(name);
			System.out.print("Save File " + name);
			// 将screenshot对象写入图像文件
			ImageIO.write(screenshot, imageFormat, f);
			rti_name = rtf_id+"_"+target_name+"_"+ photoId +"."+ format;
			//封装image
			image.setRti_name(rti_name);
			image.setRti_address(name); 
			image.setRtf_id(rtf_id);
			image.setRti_formate(format);
			image.setTarget_name(target_name);
			
			System.out.print("..Finished!\n");
		} catch (Exception ex) {
			System.out.println(ex);
		}
		return image;
	}

}
