package com.dim.cls.rs.resource;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class TestModel {
	
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	

}
