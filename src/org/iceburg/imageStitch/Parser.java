package org.iceburg.imageStitch;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;


public class Parser {

	
	public static ArrayList<GridSquare> readDirectory(String directory, String fileType){
		ArrayList<GridSquare> squares = new ArrayList<GridSquare>();
		if (directory == null){
			return squares;
		}
		File folder = new File(directory);
		if (!folder.exists()){
			return squares;
		}
		File[] listOfFiles = folder.listFiles();
		for (int i = 0; i < listOfFiles.length; i++) {
			File file = listOfFiles[i];
			if (file.isFile() && file.getName().endsWith(fileType)) {
				System.out.println("File: " + file.getName());
				
				BufferedImage img = null;
				try {
					img = ImageIO.read(file);
				} 
				catch (IOException e){
					e.printStackTrace();
				}
				if (img != null){
					GridSquare square = new GridSquare(file.getName(), img);
					squares.add(square);
				}
			}
		}
		
		return squares;
	}

	public static void saveImage(String directory, Tapestry tapestry) {
		if (tapestry == null || tapestry.getName() == null || tapestry.getMainImage() == null){
			return;
		}
		File outputfile = new File(directory + "\\" + tapestry.getName() + ".png");
		try {
			ImageIO.write(tapestry.getMainImage(), "png", outputfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
}
