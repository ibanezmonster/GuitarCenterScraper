package com.gc.model.search;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;


public class Instrument implements Serializable
{
	private String model;
	private String link;
	
	private static final ObjectStreamField[] fieldsToSerialize =
		{
				new ObjectStreamField("model", String.class),
				new ObjectStreamField("link", String.class),
		};
	
	public Instrument() {}
	
	public Instrument(String model, String link) {
		this.model = model;
		this.link = link;
	}
	
	private void readObject(ObjectInputStream ois) throws Exception{
		ObjectInputStream.GetField fields = ois.readFields();
		model = (String) fields.get("model", model);
		link = (String) fields.get("link", link);
	}
	
	
	private void writeObject(ObjectOutputStream oos) throws Exception{
		ObjectOutputStream.PutField fields = oos.putFields();
		fields.put("model", model);
		fields.put("link", link);
		oos.writeFields();
	}		
	
	
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