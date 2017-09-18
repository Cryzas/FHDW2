package persistence;

import java.util.*;

public class subAdminServiceList  extends subAdminServiceSearchList{

	protected subAdminServiceList() {
		super();
	}
	public Iterator<subAdminService4Public> iterator(PersistentListProxi<subAdminService4Public> listProxi) {
		return new PersistentListIterator<subAdminService4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (subAdminService4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public subAdminServiceList copy() {
		subAdminServiceList result = new subAdminServiceList();
		result.data = (Vector<subAdminService4Public>)this.data.clone();
		return result;
	}


}


