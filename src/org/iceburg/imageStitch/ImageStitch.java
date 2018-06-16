package org.iceburg.imageStitch;

import java.util.ArrayList;
import java.util.HashMap;

public class ImageStitch {
	private String directory;
	private HashMap<String, Tapestry> tapestries;
	
	public ImageStitch(String directory, String fileType) {
		this.directory = directory;
		ArrayList<GridSquare> squares = Parser.readDirectory(directory, fileType);
		tapestries = squaresToTapestries(squares);
	}

	private HashMap<String, Tapestry> squaresToTapestries(ArrayList<GridSquare> squares) {
		tapestries = new HashMap<String, Tapestry>();
		for (GridSquare square : squares){
			square.parseFileName();
			if (!square.isValid()){
				continue;
			}
			if (tapestries.containsKey(square.getTapestryName())){
				tapestries.get(square.getTapestryName()).addSquare(square);
			}else{
				Tapestry tapestry = new Tapestry(square.getTapestryName());
				tapestries.put(tapestry.getName(), tapestry);
				tapestry.addSquare(square);
			}
		}
		return tapestries;
	}

	public void createAndSaveImages() {
		for (Tapestry tapestry : tapestries.values()){
			Parser.saveImage(directory, tapestry);
		}
		
	}


}
