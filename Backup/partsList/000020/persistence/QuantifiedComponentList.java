package persistence;

import java.util.*;

public class QuantifiedComponentList {

	protected Vector<QuantifiedComponent4Public> data; //List of proxies
	protected QuantifiedComponentList() {
		this.data = new Vector<QuantifiedComponent4Public>();
	}
	public Iterator<QuantifiedComponent4Public> iterator(PersistentListProxi<QuantifiedComponent4Public> listProxi) {
		return new PersistentListIterator<QuantifiedComponent4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (QuantifiedComponent4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public QuantifiedComponentList copy() {
		QuantifiedComponentList result = new QuantifiedComponentList();
		result.data = (Vector<QuantifiedComponent4Public>)this.data.clone();
		return result;
	}


}


