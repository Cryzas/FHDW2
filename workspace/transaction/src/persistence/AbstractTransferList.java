package persistence;

import java.util.*;

public class AbstractTransferList {

	protected Vector<AbstractTransfer4Public> data; //List of proxies
	protected AbstractTransferList() {
		this.data = new Vector<AbstractTransfer4Public>();
	}
	public Iterator<AbstractTransfer4Public> iterator(PersistentListProxi<AbstractTransfer4Public> listProxi) {
		return new PersistentListIterator<AbstractTransfer4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (AbstractTransfer4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public AbstractTransferList copy() {
		AbstractTransferList result = new AbstractTransferList();
		result.data = (Vector<AbstractTransfer4Public>)this.data.clone();
		return result;
	}


}


