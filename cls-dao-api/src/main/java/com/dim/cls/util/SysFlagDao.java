package com.dim.cls.util;

import java.util.List;
import java.util.Map;

import com.dim.cls.dao.abstracts.api.AbstractDao;
import com.dim.cls.model.util.SysFlag;

public interface SysFlagDao extends AbstractDao<SysFlag> {
	public List<Map<String,Object>> getSysFlags(SysFlag sysFlag);
	public void addSysFlags(List<Map<String,Object>> sysFlags);
	public void updateFlags(List<Map<String,Object>> sysFlags);	
}
