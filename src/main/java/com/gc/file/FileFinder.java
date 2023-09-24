package com.gc.file;

import java.nio.file.Path;
import java.nio.file.Paths;

import com.gc.model.selection.InstrumentSelection;
import com.gc.model.selection.InstrumentSelectionCategoryNames;

public final class FileFinder
{
	public static String getPath(InstrumentSelection instrumentSelection, FileSearchType fileSearchType)
	{
		String fileName = "";
		
		if(fileSearchType == FileSearchType.DATA)
		{
			fileName = getDataFilePath(instrumentSelection, FileSearchType.DATA);
		}
		
		else if(fileSearchType == FileSearchType.SCRAPER)
		{
			fileName = getScraperPath(FileSearchType.DATA);
		}

		return fileName;
	}	
	
	
	private static String getScraperPath(FileSearchType fileSearchType)
	{				
		String fullPath = "";
		String fileNameRelative = "src/main/resources/scripts/GuitarCenterScraper/";
		
		Path path = Paths.get(fileNameRelative);
		Path absolutePath = path;
		
		if(!path.isAbsolute())
		{
			Path base = Paths.get("");
			absolutePath = base.resolve(path).toAbsolutePath();
		}
		
		fullPath = absolutePath.normalize().toString();		
		
		return fullPath;
	}
	
	private static String getDataFilePath(InstrumentSelection instrumentSelection, FileSearchType fileSearchType)
	{
		String fileName = "";
		final String homeDirectory = "saved";
		final String fileType = ".ser";
		StringBuilder sb  = new StringBuilder();
		
		sb.append(homeDirectory + "/");
		
		switch(instrumentSelection.getInstrumentSelection())
		{
		case SEVEN_STRING_ELECTRIC_GUITAR: 
			fileName = InstrumentSelectionCategoryNames.SEVEN_STRING_ELECTRIC_GUITAR.getDisplayName();
			break;
		case EIGHT_STRING_ELECTRIC_GUITAR: 
			fileName = InstrumentSelectionCategoryNames.EIGHT_STRING_ELECTRIC_GUITAR.getDisplayName();
			break;
		case ACOUSTIC_GUITAR: 
			fileName = InstrumentSelectionCategoryNames.ACOUSTIC_GUITAR.getDisplayName();
			break;
		}
		
		sb.append(fileName);		
		sb.append(fileType);
				
		fileName = sb.toString();		
		
		return fileName;
	}
}
