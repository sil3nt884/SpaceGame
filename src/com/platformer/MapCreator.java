package com.platformer;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.platformer.config.GameConfig;
import com.platformer.objects.Map;

public class MapCreator {


	private int width, height, startx, starty;
	private static ArrayList<File> mapFiles = new ArrayList<File>();
	private ArrayList<Map> mapsArray = new ArrayList<Map>();
	private static String location = "maps";
	
	public void createMaps() throws IOException {
		System.out.println("creating maps");
		for (File mapFile : mapFiles) {
			URI mapURI = mapFile.toURI();
			Path path = Paths.get(mapURI);
			String firstLine = Files.lines(path).map(s -> s).findFirst().get();
			String[] firstSplit = firstLine.split(" ");
			height= Integer.parseInt(firstSplit[0]);
			width = Integer.parseInt(firstSplit[1]);
			String second = Files.lines(path).map(s -> s).skip(1).findFirst().get();
			String[] secondSplit = second.split(" ");
			startx = Integer.parseInt(secondSplit[0]);
			starty = Integer.parseInt(secondSplit[1]);
			int mapInt[][] = new int[height][width];
			List<String> mapsLines = Files.lines(path).map(s -> s).skip(2).map(line -> line.replace(" ", ","))
					.collect(Collectors.toList());
			for (int row = 0; row < height; row++) {
				String line = mapsLines.get(row);
					String[] tileValues = line.split(",");
					for (int col = 0; col < width; col++) {
						for(int i =0; i<tileValues.length; i++) {
							mapInt[row][col] = Integer.parseInt(tileValues[i]);
						}
					}
				}
				

			
			Map map = new Map(width, height, startx, starty, mapInt);
			mapsArray.add(map);
			System.out.println("map added.."+mapsArray.size());
			
		}
		

	}

	public void loadMaps(GameConfig config) {
		File maps = new File(config.getResources() + "/" + location);
		File mapsFiles[] = maps.listFiles();
		for (int i = 0; i < mapsFiles.length; i++) {
			if (mapsFiles[i].toString().endsWith(".txt")) {
				mapFiles.add(mapsFiles[i]);
			}
		}
		
	}
	
	public void loadMapArrays(GameConfig config) {
		for(int i=0; i<mapsArray.size(); i++) {
			System.out.println("running..");
			mapsArray.get(i).loadAssets();
		}
	}

	public Map getMap(int mapID) {
		return mapsArray.get(mapID);
	}
}
