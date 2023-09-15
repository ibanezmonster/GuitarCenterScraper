package com.gc.model.search;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class InstrumentOutput
{
	public String model;
	public String link;	
	
	public String getModel(){return model; }
	
	public String getLink(){ return link; }
	
	public void setModel(String model)
	{
		this.model = model;
	}
	
	public void setLink(String link)
	{
		this.link = link;
	}
}

