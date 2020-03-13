package com.ruanko.web;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.struts2.ServletActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.ruanko.model.House;
import com.ruanko.model.User;
import com.ruanko.service.HouseService;

public class CreateHouseAction extends ActionSupport implements ModelDriven<Object>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 封装上传文件域的属性
	private File[] pic;
	// 封装上传文件类型的属性
	private String[] picContentType;
	// 封装上传文件名的属性
	private String[] picFileName;
	public File[] getPic() {
		return pic;
	}
	public void setPic(File[] pic) {
		this.pic = pic;
	}
	public String[] getPicContentType() {
		return picContentType;
	}
	public void setPicContentType(String[] picContentType) {
		this.picContentType = picContentType;
	}
	public String[] getPicFileName() {
		return picFileName;
	}
	public void setPicFileName(String[] picFileName) {
		this.picFileName = picFileName;
	}

	House house = new House();	
	HttpServletRequest request = ServletActionContext.getRequest();
	HttpSession session = request.getSession();	
	
	//实现缩略图的方法
	public static void toSmallImg(File file, String thumbPath) throws Exception{    
		String newurl =thumbPath;    
		java.awt.Image bigJpg = javax.imageio.ImageIO.read(file);
		float tagsize = 100;    
		int old_w = bigJpg.getWidth(null);    
		int old_h = bigJpg.getHeight(null);       
		int new_w = 0;    
		int new_h = 0;    
		float tempdouble;     
		tempdouble = old_w > old_h ? old_w/tagsize : old_h/tagsize;    
		new_w = Math.round(old_w/tempdouble);    
		new_h = Math.round(old_h/tempdouble);    
		java.awt.image.BufferedImage tag = new java.awt.image.BufferedImage(new_w,new_h,java.awt.image.BufferedImage.TYPE_INT_RGB);    
		tag.getGraphics().drawImage(bigJpg,0,0,new_w,new_h,null);    
		FileOutputStream newimage = new FileOutputStream(newurl);    
		com.sun.image.codec.jpeg.JPEGImageEncoder encoder = com.sun.image.codec.jpeg.JPEGCodec.createJPEGEncoder(newimage);           
		encoder.encode(tag);    
		newimage.close();    
	}   
	
	//保存图片的路径
	public boolean SavePic () throws Exception{
		//保存原图片的绝对路径
		Map<Integer, String> map = new HashMap<>();
		//保存缩略图的绝对路径
		Map<Integer, String> map1 = new HashMap<>();
		
		boolean flag = false;
		if (pic != null && pic.length > 0) {			
			for (int i = 0; i < pic.length; i ++) {
				if ((picContentType[i].equals("image/jpeg") || picContentType[i].equals("image/gif"))) {															
					Format format = new SimpleDateFormat("yyyyMMddhhmmss");
					String current = format.format(new Date());
					//String root = ServletActionContext.getServletContext().getRealPath("/upload/"+current+picFileName[i]);									 		   
					String root ="E://徐海峰/JAVA/Eclipse保存文档/ShortRent/WebContent/upload/"+current+picFileName[i];			
					String shotroot = "E://徐海峰/JAVA/Eclipse保存文档/ShortRent/WebContent/upload/"+current+"small"+picFileName[i];
					map.put(i, root);
					map1.put(i, shotroot);
					OutputStream out = new FileOutputStream(root);
					InputStream in = new FileInputStream(pic[i]);
					byte[] flush = new byte[1024];
					int len = 0;
					while ((len = in.read(flush)) != -1) {
						out.write(flush, 0, len);				
					}
					//调用实现缩略图的方法
					toSmallImg(pic[i], shotroot);
					in.close();
					out.close();
					flag = true;					
				} else {
					addFieldError(house.getName(), "图片类型错误，只能为GIF或JPG");				
				}				
			} 			
			//设置house的setPicture、setShotcut的值
			String pic1 = null;
			String pic2 = null;
			String pic3 = null;
			String shotpic1 = null;
			String shotpic2 = null;
			String shotpic3 = null;
			pic1 = map.get(0).substring(46);
			shotpic1 = map1.get(0).substring(46);
			house.setPicture1(pic1);
			house.setShotcut1(shotpic1);
			if (map.get(1) != null) {
				pic2 = map.get(1).substring(46);
				shotpic2 = map1.get(1).substring(46);
				house.setPicture2(pic2);
				house.setShotcut2(shotpic2);
			}
			if (map.get(2) != null) {
				pic3 = map.get(2).substring(46);
				shotpic3 = map1.get(2).substring(46);
				house.setPicture3(pic3);
				house.setShotcut3(shotpic3);
			}
										
		} else {
			addFieldError(house.getName(), "图片不能为空！");			
		}		
		return flag; 	
	} 
	
	@Override
	public String execute() throws Exception {
		
		System.out.println(house.getName());
		
		User user = (User) session.getAttribute("user");
		HouseService houseService = new HouseService();
		if (house == null) {
			System.out.println("house为空");			
			return "login";			
		}
		if (user == null) {
			System.out.println("user为空");
			return "login";
		}
		if (!SavePic()) {
			return "create";
		}
		if (houseService.createHouse(house)) {
			addFieldError(house.getName(), "创建房屋成功，现在可以继续创建！");
			return SUCCESS;
		} else {
			System.out.println("保存失败");
			addFieldError(house.getName(), "创建房屋失败！");
			return "create";
		}
				
	}

	@Override
	public Object getModel() {
		return house;
	}

	
	
}
