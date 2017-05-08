package persistence;

import java.util.*;

public class EntryList {

	protected Vector<Entry4Public> data; //List of proxies
	protected EntryList() {
		this.data = new Vector<Entry4Public>();
	}
	public Iterator<Entry4Public> iterator(PersistentListProxi<Entry4Public> listProxi) {
		return new PersistentListIterator<Entry4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Entry4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public EntryList copy() {
		EntryList result = new EntryList();
		result.data = (Vector<Entry4Public>)this.data.clone();
		return result;
	}


}


