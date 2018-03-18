package org.module.hr.model.dto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
*
* @author formulateko@admin.com
*/
public class MaritalStatusType implements Serializable{
	
	private static final long serialVersionUID = -4808788227180776721L;
	
	final public static List<MaritalStatusType> ALLTYPES;
	final private static Map<Character, MaritalStatusType> STDID_MAP;
	final public static MaritalStatusType EMPTY_RELATIONSHIPTYP = new MaritalStatusType('O',"");
	
	final private Character stpId;
	final private String stpTypname;
	
	static{
		List<MaritalStatusType> result = new ArrayList<MaritalStatusType>();
		
		result.add(new MaritalStatusType('S', "Singel"));
		result.add(new MaritalStatusType('M', "Maried"));
		result.add(new MaritalStatusType('O', "Other"));
		
		ALLTYPES = Collections.unmodifiableList(result);
		STDID_MAP = new HashMap<Character, MaritalStatusType>(result.size());
		
		for (MaritalStatusType maritalStatusType : result) {
			STDID_MAP.put(maritalStatusType.getStpId(), maritalStatusType);
		}
	}
	
	public static MaritalStatusType getTypById(Character typId) {
		return STDID_MAP.get(typId);
	}
	
	public MaritalStatusType(Character stpId, String stpTypname) {
		this.stpId = stpId;
		this.stpTypname = stpTypname;
	}

	public Character getStpId() {
		return stpId;
	}

	public String getStpTypname() {
		return stpTypname;
	}
	
	static public List<MaritalStatusType> getAllTypes() {
		return ALLTYPES;
	}

	
	public boolean equals(MaritalStatusType maritalStatusType) {
		return getStpId() == maritalStatusType.getStpId();
	}
}
