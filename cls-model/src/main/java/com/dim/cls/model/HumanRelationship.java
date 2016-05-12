package com.dim.cls.model;

import javax.persistence.Embeddable;

import com.dim.cls.model.abstracts.AbstractPerson;
import com.dim.cls.util.RelationshipType;

@Embeddable
public class HumanRelationship {

	private AbstractPerson person ;
	private RelationshipType relType;

}
