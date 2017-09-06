package persistence;

import java.util.*;

public class UnitList {

	protected Vector<Unit4Public> data; //List of proxies
	protected UnitList() {
		this.data = new Vector<Unit4Public>();
	}
	public Iterator<Unit4Public> iterator(PersistentListProxi<Unit4Public> listProxi) {
		return new PersistentListIterator<Unit4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Unit4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public UnitList copy() {
		UnitList result = new UnitList();
		result.data = (Vector<Unit4Public>)this.data.clone();
		return result;
	}


}


