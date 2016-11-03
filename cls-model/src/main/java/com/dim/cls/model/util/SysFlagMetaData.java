package com.dim.cls.model.util;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.dim.cls.model.abstracts.AbstractDomainEntry;

@Entity
@Table(name = "SYS_FLAG_METADATA")
public class SysFlagMetaData extends AbstractDomainEntry {
	
	@Column(name = "FLAG_NAME", unique=true )
	private String flagName;

	@Column(name = "VALUE_NAME")
	private String descValueName;
		
	@Column(name = "DESC_VALUE1")
	private String descValue1;
	
	@Column(name = "DESC_VALUE2")
	private String descValue2;
	
	@Column(name = "DESC_VALUE3")
	private String descValue3;
	
	@Column(name = "DESC_VALUE4")
	private String descValue4;
	
	@Column(name = "DESC_VALUE5")
	private String descValue5;

}
