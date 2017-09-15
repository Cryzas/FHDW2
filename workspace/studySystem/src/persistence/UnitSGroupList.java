package persistence;

import java.util.*;

public class UnitSGroupList  extends UnitSGroupSearchList{

	protected UnitSGroupList() {
		super();
	}
	public Iterator<UnitSGroup4Public> iterator(PersistentListProxi<UnitSGroup4Public> listProxi) {
		return new PersistentListIterator<UnitSGroup4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (UnitSGroup4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public UnitSGroupList copy() {
		UnitSGroupList result = new UnitSGroupList();
		result.data = (Vector<UnitSGroup4Public>)this.data.clone();
		return result;
	}


}


