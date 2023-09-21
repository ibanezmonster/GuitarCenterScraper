package com.gc.file;

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
		String fileName = "src/main/resources/scripts/GuitarCenterScraper/run/gc_run.py";
		
		return fileName;
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
