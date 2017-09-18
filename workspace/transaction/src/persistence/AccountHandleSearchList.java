package persistence;

public class AccountHandleSearchList extends DefaultSearchListRoot<AccountHandle4Public> implements Iterable<AccountHandle4Public> {

	public AccountHandleSearchList(SearchListRoot<AccountHandle4Public> list){
		super(list);
	}
	public AccountHandleSearchList(){
		super();
	}
	
	public void add (AccountHandle4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(AccountHandleSearchList list) throws PersistenceException{
		java.util.Iterator<AccountHandle4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<AccountHandle4Public> iterator() {
		return this.getData().iterator();
	}
  	public AccountHandleSearchList copy() throws PersistenceException {
  		AccountHandleSearchList result = new AccountHandleSearchList();
  		result.add(this);
  		return result;
  	}
}


