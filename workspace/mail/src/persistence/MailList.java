package persistence;

import java.util.*;

public class MailList {

	protected Vector<Mail4Public> data; //List of proxies
	protected MailList() {
		this.data = new Vector<Mail4Public>();
	}
	public Iterator<Mail4Public> iterator(PersistentListProxi<Mail4Public> listProxi) {
		return new PersistentListIterator<Mail4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Mail4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public MailList copy() {
		MailList result = new MailList();
		result.data = (Vector<Mail4Public>)this.data.clone();
		return result;
	}


}


