package org.iceburg.imageStitch;

import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;

public class Tapestry {
	private String name;
	private ArrayList<GridSquare> gridSquares;
	private BufferedImage mainImage;

	public Tapestry(String tapestryName) {
		this.name = tapestryName;
		this.gridSquares = new ArrayList<GridSquare>();
	}
	
	
	public void addSquare(GridSquare square){
		this.gridSquares.add(square);
	}
	
	public String getName(){
		return name;
	}


	private void createImage() {
		Point p = getMaxDimensions();
		int squareWidth = gridSquares.get(0).getImg().getWidth();
		int squareHeight = gridSquares.get(0).getImg().getHeight();
		
		mainImage = new BufferedImage(squareWidth*p.x, squareHeight*p.y, BufferedImage.TYPE_INT_RGB);
		Graphics2D g2d = mainImage.createGraphics();
		
		for (GridSquare square : gridSquares){
			g2d.drawImage(square.getImg(), square.getX()*squareWidth, square.getY()*squareHeight, null);
		}
		g2d.dispose();		
		
	}


	private Point getMaxDimensions() {
		int x = 0;
		int y = 0;
		for (GridSquare square : gridSquares){
			if (square.getX() > x){
				x = square.getX();
			}
			if (square.getY() > y){
				y = square.getY();
			}
		}
		
		return new Point(x+1,y+1);
	}


	public BufferedImage getMainImage() {
		if (mainImage == null){
			createImage();
		}
		return mainImage;
	}
}
