package persistence;

import java.util.*;

public class AccountWrapperList {

	protected Vector<AccountWrapper4Public> data; //List of proxies
	protected AccountWrapperList() {
		this.data = new Vector<AccountWrapper4Public>();
	}
	public Iterator<AccountWrapper4Public> iterator(PersistentListProxi<AccountWrapper4Public> listProxi) {
		return new PersistentListIterator<AccountWrapper4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (AccountWrapper4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public AccountWrapperList copy() {
		AccountWrapperList result = new AccountWrapperList();
		result.data = (Vector<AccountWrapper4Public>)this.data.clone();
		return result;
	}


}


