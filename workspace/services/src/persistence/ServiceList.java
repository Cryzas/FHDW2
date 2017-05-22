package persistence;

import java.util.*;

public class ServiceList {

	protected Vector<Service4Public> data; //List of proxies
	protected ServiceList() {
		this.data = new Vector<Service4Public>();
	}
	public Iterator<Service4Public> iterator(PersistentListProxi<Service4Public> listProxi) {
		return new PersistentListIterator<Service4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Service4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public ServiceList copy() {
		ServiceList result = new ServiceList();
		result.data = (Vector<Service4Public>)this.data.clone();
		return result;
	}


}


