package persistence;

import java.util.*;

public class AccountList  extends AccountSearchList{

	protected AccountList() {
		super();
	}
	public Iterator<Account4Public> iterator(PersistentListProxi<Account4Public> listProxi) {
		return new PersistentListIterator<Account4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (Account4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public AccountList copy() {
		AccountList result = new AccountList();
		result.data = (Vector<Account4Public>)this.data.clone();
		return result;
	}


}


