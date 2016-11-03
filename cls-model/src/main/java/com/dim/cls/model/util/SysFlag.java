package com.dim.cls.model.util;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.springframework.format.annotation.DateTimeFormat;

import com.dim.cls.model.abstracts.AbstractDomainEntry;

@Entity
@Table(name = "SYS_FLAG",
		uniqueConstraints = @UniqueConstraint(columnNames = { "FLAG_NAME", "VALUE_NAME" })
)

public class SysFlag extends AbstractDomainEntry{

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ID_FLAG")
	private Long idFlag;

	@Column(name = "FLAG_NAME")
	private String flagName;
	
	@Column(name = "DT_EFFECTIVE_FROM", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyyMMddHH24MISS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtEffectiveFrom;
	
	@Column(name = "DT_EFFECTIVE_TO", columnDefinition = "DATE")
	@DateTimeFormat(pattern = "yyyyMMddHH24MISS")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dtEffectiveTo;

	@Column(name = "VALUE_NAME")
	private String valueName;
		
	@Column(name = "VALUE1")
	private String value1;
	
	@Column(name = "VALUE2")
	private String value2;
	
	@Column(name = "VALUE3")
	private String value3;
	
	@Column(name = "VALUE4")
	private String value4;
	
	@Column(name = "VALUE5")
	private String value5;

	public Long getIdFlag() {
		return idFlag;
	}

	public void setIdFlag(Long idFlag) {
		this.idFlag = idFlag;
	}

	public String getFlagName() {
		return flagName;
	}

	public void setFlagName(String flagName) {
		this.flagName = flagName;
	}

	public Date getDtEffectiveFrom() {
		return dtEffectiveFrom;
	}

	public void setDtEffectiveFrom(Date dtEffectiveFrom) {
		this.dtEffectiveFrom = dtEffectiveFrom;
	}

	public Date getDtEffectiveTo() {
		return dtEffectiveTo;
	}

	public void setDtEffectiveTo(Date dtEffectiveTo) {
		this.dtEffectiveTo = dtEffectiveTo;
	}

	public String getValueName() {
		return valueName;
	}

	public void setValueName(String valueName) {
		this.valueName = valueName;
	}

	public String getValue1() {
		return value1;
	}

	public void setValue1(String value1) {
		this.value1 = value1;
	}

	public String getValue2() {
		return value2;
	}

	public void setValue2(String value2) {
		this.value2 = value2;
	}

	public String getValue3() {
		return value3;
	}

	public void setValue3(String value3) {
		this.value3 = value3;
	}

	public String getValue4() {
		return value4;
	}

	public void setValue4(String value4) {
		this.value4 = value4;
	}

	public String getValue5() {
		return value5;
	}

	public void setValue5(String value5) {
		this.value5 = value5;
	}
		
}
