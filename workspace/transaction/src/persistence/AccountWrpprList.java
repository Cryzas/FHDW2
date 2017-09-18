package persistence;

import java.util.*;

public class AccountWrpprList {

	protected Vector<AccountWrppr4Public> data; //List of proxies
	protected AccountWrpprList() {
		this.data = new Vector<AccountWrppr4Public>();
	}
	public Iterator<AccountWrppr4Public> iterator(PersistentListProxi<AccountWrppr4Public> listProxi) {
		return new PersistentListIterator<AccountWrppr4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (AccountWrppr4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public AccountWrpprList copy() {
		AccountWrpprList result = new AccountWrpprList();
		result.data = (Vector<AccountWrppr4Public>)this.data.clone();
		return result;
	}


}


