package persistence;

import java.util.*;

public class UnitStudentList {

	protected Vector<UnitStudent4Public> data; //List of proxies
	protected UnitStudentList() {
		this.data = new Vector<UnitStudent4Public>();
	}
	public Iterator<UnitStudent4Public> iterator(PersistentListProxi<UnitStudent4Public> listProxi) {
		return new PersistentListIterator<UnitStudent4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (UnitStudent4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public UnitStudentList copy() {
		UnitStudentList result = new UnitStudentList();
		result.data = (Vector<UnitStudent4Public>)this.data.clone();
		return result;
	}


}


