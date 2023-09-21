package com.gc.requestPull;

import java.util.List;

import com.gc.file.FileIO;
import com.gc.model.search.Instrument;
import com.gc.model.selection.InstrumentSelection;
import com.gc.model.selection.InstrumentSelectionCategoryNames;

public class InstrumentWriter
{
	public InstrumentWriter()
	{
		
	}
	
	public void write(InstrumentSelection instrumentSelection, List<Instrument> instrumentList)
	{
//		FileIO file = new FileIO();
//		String fileName = "";								
//
//		//get file name
//		switch(instrumentSelectionCategoryNames)
//		{
//		case SEVEN_STRING_ELECTRIC_GUITAR: 
//			fileName = InstrumentSelectionCategoryNames.SEVEN_STRING_ELECTRIC_GUITAR.getDisplayName();
//			break;
//		case EIGHT_STRING_ELECTRIC_GUITAR: 
//			fileName = InstrumentSelectionCategoryNames.EIGHT_STRING_ELECTRIC_GUITAR.getDisplayName();
//			break;
//		case ACOUSTIC_GUITAR: 
//			fileName = InstrumentSelectionCategoryNames.ACOUSTIC_GUITAR.getDisplayName();
//			break;
//		}
//
//		//writing to file
//		file.writeFile(fileName, instrumentList);
	}
}
