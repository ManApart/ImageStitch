package org.iceburg.imageStitch;

import java.awt.image.BufferedImage;

public class GridSquare {
	private String fileName, tapestryName;
	private BufferedImage img;
	private int x,y;
	private boolean isValid;
	
	public GridSquare(String name, BufferedImage img) {
		this.fileName = name;
		this.img = img;
	}
	
	
	public void parseFileName(){
		isValid = true;
		if (fileName == null || fileName.isEmpty() || !fileName.contains(".")){
			isValid = false;
			return;
		}
		
		String name = fileName.substring(0,fileName.indexOf('.')); 
		if (name.isEmpty()){
			isValid = false;
			return;
		}
		String[] parts = name.split("-");
		if (parts.length != 3){
			isValid = false;
			return;
		}
		tapestryName = parts[0];
		
		try {
			x = Integer.parseInt(parts[1]);
			y = Integer.parseInt(parts[2]);
		} catch (NumberFormatException e){
//			e.printStackTrace();
			System.out.println("Error with image " + fileName +": " + e.getMessage());
			isValid = false;
		}
	}


	public String getTapestryName() {
		return tapestryName;
	}


	public BufferedImage getImg() {
		return img;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public boolean isValid() {
		return isValid;
	}

	
	
	
}
