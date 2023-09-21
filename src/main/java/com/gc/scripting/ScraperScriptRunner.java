package com.gc.scripting;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import com.gc.file.FileFinder;
import com.gc.file.FileSearchType;
import com.gc.model.selection.InstrumentSelection;

public class ScraperScriptRunner
{
	public static void execute(InstrumentSelection instrumentSelection) 
	{
		//get file path
		String fileName = FileFinder.getPath(instrumentSelection, FileSearchType.SCRAPER);

		//open scraper script
    	try (PythonInterpreter interp = new PythonInterpreter())
		{
    		String scriptInput = instrumentSelection.getInstrumentSelection().getDisplayName();

    		System.out.println("Checking file: " + fileName);
			System.out.println("Pulling new list for: " + scriptInput);

			
    		//send instrument selection value to script
			interp.set("instrumentCategory", new PyString(scriptInput));
			
			
			//run scraper script
			interp.execfile(fileName);				
		}
    	
	}
}
