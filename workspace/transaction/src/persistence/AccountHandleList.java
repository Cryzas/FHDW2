package persistence;

import java.util.*;

public class AccountHandleList  extends AccountHandleSearchList{

	protected AccountHandleList() {
		super();
	}
	public Iterator<AccountHandle4Public> iterator(PersistentListProxi<AccountHandle4Public> listProxi) {
		return new PersistentListIterator<AccountHandle4Public>(listProxi, this.data);
	}
	public long getLength(){
		return this.data.size();
	}
	public void add (AccountHandle4Public entry) {
		this.data.add(entry);
	}
	@SuppressWarnings("unchecked")
	public AccountHandleList copy() {
		AccountHandleList result = new AccountHandleList();
		result.data = (Vector<AccountHandle4Public>)this.data.clone();
		return result;
	}


}


