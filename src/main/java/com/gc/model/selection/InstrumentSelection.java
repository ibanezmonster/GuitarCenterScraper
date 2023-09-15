package com.gc.model.selection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.ModelAttribute;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class InstrumentSelection
{			
	private InstrumentSelectionCategoryNames instrumentSelection;
	
	public InstrumentSelection(){}
	
	public InstrumentSelectionCategoryNames getInstrumentSelection()
	{
		return instrumentSelection;
	}

	public void setInstrumentSelection(InstrumentSelectionCategoryNames instrumentSelection)
	{
		this.instrumentSelection = instrumentSelection;
	}
	
		
	@ModelAttribute("instrumentSelectionCategoryList")
	public static List<String> getListEntries()
	{
		List<InstrumentSelectionCategoryNames> iList = Arrays.asList(InstrumentSelectionCategoryNames.values());				
		List<String> instrumentList = new ArrayList<>();
		
		for(int i = 0; i <= iList.size() - 1; i++)
		{
			instrumentList.add(iList.get(i).getDisplayName());			
		}				
						
		return instrumentList;
	}

}
