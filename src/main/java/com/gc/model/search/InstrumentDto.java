package com.gc.model.search;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

public class InstrumentDto
{
	List<Instrument> list;
	
	public InstrumentDto()
	{
		list = new ArrayList<>();
	}
	
	public void addInstrumentToList(Instrument instrument)
	{
		this.list.add(instrument);
	}
	
	public List<Instrument> getList()
	{
		Instrument i1 = new Instrument("Schecter 8 string", "guitarcenter1.com");
		Instrument i2 = new Instrument("Schecter 9 string", "guitarcenter2.com");
		Instrument i3 = new Instrument("Schecter 10 string", "guitarcenter3.com");
		
		list = new ArrayList<>();
		list.add(i1);
		list.add(i2);
		list.add(i3);
		
		return list; 
	}
	
	public void setList(List<Instrument> list)
	{ this.list = list; }
	
	
	
	
}
