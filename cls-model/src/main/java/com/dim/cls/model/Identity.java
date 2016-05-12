package com.dim.cls.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.dim.cls.util.IdType;

@Embeddable
public class Identity {


	@Enumerated(EnumType.ORDINAL)
	@Column(name = "ID_TYPE")
	private IdType idType;
	
	
	@Column(name = "ID_VALUE")
	private String idValue;
	
	@Column(name = "trest")
	private String tesrt;
	
	
	public IdType getIdType() {
		return idType;
	}
	public void setIdType(IdType idType) {
		this.idType = idType;
	}
	public String getIdValue() {
		return idValue;
	}
	public void setIdValue(String idValue) {
		this.idValue = idValue;
	}
	@Override
	public String toString() {
		return "Identity [idType=" + idType + ", idValue=" + idValue + "]";
	}
	
}
