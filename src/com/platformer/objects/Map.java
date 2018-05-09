package com.platformer.objects;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.platformer.GameCanvas;

public class Map {

	private double x, y;

	// bounds
	private int xmin;
	private int ymin;
	private int xmax;
	private int ymax;

	// map data;
	private int width;
	private int height;
	int map[][];
	int startx, startyy;
	private String mapSprite = "mapPart.png";
	private BufferedImage mapImage;
	private BufferedImage [][] tilesImage;
	private Tile[][] tiles;

	// drawing
	private int rowOffset, colOffset, numberOfRowsToDraw, numOfColsToDraw;
	private int tileSize = 30;
	private double tween;
	private int numberOfTilesAcross;
	



	public Map(int width, int height, int startx, int starty, int map[][]) {
		this.setWidth(width);
		this.setHeight(height);
		this.map = map;
		setNumberOfRowsToDraw(GameCanvas.HEIGHT / tileSize + 2);
		setNumOfColsToDraw(GameCanvas.WIDTH / tileSize + 2);
		tween = 0.07;
		//setPositions(0,0);
	}

	public void loadAssets() {
		System.out.println("loading.....");
		try {
			File dir = new File(this.getClass().getResource("/res/maps/" + mapSprite).getFile());
			mapImage = ImageIO.read(dir);
		} catch (IOException e) {
			e.printStackTrace();
		}
		createSprites();
		tiles = new Tile[height][width];
		setTitleTypes();
	}


	public void createSprites() {
		System.out.println("creatiing spites");
		numberOfTilesAcross = mapImage.getWidth() / tileSize;
		tilesImage = new BufferedImage [2][numberOfTilesAcross];
		BufferedImage sumImage;
		for(int row = 0; row < 2; row++) {
		for (int col = 0; col < numberOfTilesAcross; col++) {
			sumImage = mapImage.getSubimage(col * tileSize, 0, tileSize, tileSize);
			tilesImage[row][col] = sumImage;
		}
		}

	}
	
	public void update() {
		for(int row = 0; row < height; row++) {
			for(int col=0 ; col<width; col++) {
				tiles[row][col].getTile().x = (int) this.x;
				tiles[row][col].getTile().y = (int) this.y;
			}
		}
	}
	
	public void setTitleTypes() {
		for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
            	tiles[row][col] = new Tile(x, y);
            	if(map[row][col]== 0) {
            		tiles[row][col].setType(0);
            		
            	}
            	else if(map[row][col]== 1) {
            		tiles[row][col].setType(1);
            		
              
            }
           
            }
		}
	}

	

	public void setPositions(double x, double y) {
		this.x += (x - this.x) * tween;
		this.y += (y - this.y) * tween;
		fixBounds();
		colOffset = (int) -this.x / tileSize;
		colOffset = (int) -this.y / tileSize;
	}

	private void fixBounds() {
		if (x < xmin)
			x = xmin;
		if (y < ymin)
			y = ymin;
		if (x > xmax)
			x = xmax;
		if (y > ymax)
			y = ymax;
	}

	public void mapDraw(Graphics2D g2) {
		for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
            	if(map[row][col]== 0) {
            		g2.setColor(Color.RED);
            		g2.drawRect(30,30, (int) tiles[row][col].getTile().x  + col * tileSize ,(int) tiles[row][col].getTile().y  + row * tileSize);
            		g2.drawImage(tilesImage[1][5], (int)x + col * tileSize, (int)y + row * tileSize,null);
            	}
             if(map[row][col]== 1) {
            	 g2.setColor(Color.BLUE);
            	 g2.drawRect(30,30, (int) tiles[row][col].getTile().x  + col * tileSize ,(int) tiles[row][col].getTile().y  + row * tileSize);
            	g2.drawImage(tilesImage[0][1], (int)x + col * tileSize, (int)y + row * tileSize,null);
              
            }
           
            }
		}
	}
	
	public int getTileSize() {
		return tileSize;
	}

	
	public int getTilteType(int row, int col) {
		int type = map[row][col];
		return type;
	}
	
	public Tile [][] getTiles(){
		return tiles;
	}

	public int [][] getMap(){
		return map;
	}
	
	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public double getX() {
		return x;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public int getRowOffset() {
		return rowOffset;
	}

	public void setRowOffset(int rowOffset) {
		this.rowOffset = rowOffset;
	}

	public int getColOffset() {
		return colOffset;
	}

	public void setColOffset(int colOffset) {
		this.colOffset = colOffset;
	}

	public int getNumberOfRowsToDraw() {
		return numberOfRowsToDraw;
	}

	public void setNumberOfRowsToDraw(int numberOfRowsToDraw) {
		this.numberOfRowsToDraw = numberOfRowsToDraw;
	}

	public int getNumOfColsToDraw() {
		return numOfColsToDraw;
	}

	public void setNumOfColsToDraw(int numOfColsToDraw) {
		this.numOfColsToDraw = numOfColsToDraw;
	}

	public int getXmin() {
		return xmin;
	}

	public void setXmin(int xmin) {
		this.xmin = xmin;
	}

	public int getYmin() {
		return ymin;
	}

	public void setYmin(int ymin) {
		this.ymin = ymin;
	}

	public int getXmax() {
		return xmax;
	}

	public void setXmax(int xmax) {
		this.xmax = xmax;
	}

	public int getYmax() {
		return ymax;
	}

	public void setYmax(int ymax) {
		this.ymax = ymax;
	}

}
