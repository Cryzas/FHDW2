package persistence;

public class MailSearchList extends DefaultSearchListRoot<Mail4Public> implements Iterable<Mail4Public> {

	public MailSearchList(SearchListRoot<Mail4Public> list){
		super(list);
	}
	public MailSearchList(){
		super();
	}
	
	public void add (Mail4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(MailSearchList list) throws PersistenceException{
		java.util.Iterator<Mail4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Mail4Public> iterator() {
		return this.getData().iterator();
	}
  	public MailSearchList copy() throws PersistenceException {
  		MailSearchList result = new MailSearchList();
  		result.add(this);
  		return result;
  	}
}


