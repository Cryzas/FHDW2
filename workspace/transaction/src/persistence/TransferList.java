package persistence;

import java.util.*;

public class TransferList {

	protected Vector<Transfer4Public> data; //List of proxies
	protected TransferList() {
		this.data = new Vector<Transfer4Public>();
	}
	public Iterator<Transfer4Public> iterator(PersistentListProxi<Transfer4Public> listProxi) {
		return new PersistentListIterator<Transfer4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Transfer4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public TransferList copy() {
		TransferList result = new TransferList();
		result.data = (Vector<Transfer4Public>)this.data.clone();
		return result;
	}


}


