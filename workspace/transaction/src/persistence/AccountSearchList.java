package persistence;

public class AccountSearchList extends DefaultSearchListRoot<Account4Public> implements Iterable<Account4Public> {

	public AccountSearchList(SearchListRoot<Account4Public> list){
		super(list);
	}
	public AccountSearchList(){
		super();
	}
	
	public void add (Account4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(AccountSearchList list) throws PersistenceException{
		java.util.Iterator<Account4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Account4Public> iterator() {
		return this.getData().iterator();
	}
  	public AccountSearchList copy() throws PersistenceException {
  		AccountSearchList result = new AccountSearchList();
  		result.add(this);
  		return result;
  	}
}


