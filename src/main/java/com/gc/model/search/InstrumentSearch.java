package com.gc.model.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.gc.file.FileIO;
import com.gc.model.selection.InstrumentSelectionCategoryNames;

public class InstrumentSearch
{		
	InstrumentSelectionCategoryNames instrumentSelectionCategoryNames;
	
	public InstrumentSearch(InstrumentSelectionCategoryNames instrumentSelectionCategoryNames)
	{
		this.instrumentSelectionCategoryNames = instrumentSelectionCategoryNames;
	}
	
//	public Optional<List<Instrument>> getList()
//	{
//		String fileName = null;		
//		
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
		
		//get file info
		//file(fileName)
		
		//pass it to
		
		//InstrumentDto.addItem
		

		//entries
//		FileIO file = new FileIO();
//		
//		//test file write so I can use an example
//		List<Instrument> instrumentList = new ArrayList<>();
//		instrumentList.add(new Instrument("Schecter 8-string", "guitarcenter.com"));
//		file.writeFile(fileName, instrumentList);
//		
//		
//		
//		List<Instrument> entries = file.readFile(fileName);
		
	
		//InstrumentDto.getList
		
		
		//return Optional.of(entries);		
	}
//}
