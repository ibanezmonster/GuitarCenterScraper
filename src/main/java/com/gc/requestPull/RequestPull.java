package com.gc.requestPull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.gc.file.FileFinder;
import com.gc.file.FileIO;
import com.gc.file.FileSearchType;
import com.gc.model.search.Instrument;
import com.gc.model.selection.InstrumentSelection;
import com.gc.model.selection.InstrumentSelectionCategoryNames;

public class RequestPull
{
	public RequestPull(){}
	
	public void write(InstrumentSelection instrumentSelection)
	{	
		String fileName = FileFinder.getPath(instrumentSelection, FileSearchType.DATA);
		
		//run script
		
		//example data (List<Instrument>) that would be retrieved from python file
		Instrument instrument1 = new Instrument("test1guitar", "test1.com");
		Instrument instrument2 = new Instrument("test1guitar", "test1.com");
		
		List<Instrument> instrumentList = new ArrayList<>();
		instrumentList.add(instrument1);
		instrumentList.add(instrument2);
				
		//write to file
		FileIO file = new FileIO(fileName);
		try
		{
			file.writeFile(instrumentList);
		}
		catch (IOException e){e.printStackTrace();}			
	}
}
