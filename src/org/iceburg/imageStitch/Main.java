package org.iceburg.imageStitch;

public class Main {
	
	
	public static void main(String[] args) {
		String directory = "G:\\Users\\Austin Kucera\\Downloads";
//		String directory = "B:\\Coding\\Workspace\\ImageStitch\\Sample Data";
		ImageStitch imageStitch = new ImageStitch(directory, ".jpg");
		imageStitch.createAndSaveImages();
		
	}
}
