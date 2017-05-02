package persistence;

public class QuantifiedComponentSearchList extends DefaultSearchListRoot<QuantifiedComponent4Public> implements Iterable<QuantifiedComponent4Public> {

	public QuantifiedComponentSearchList(SearchListRoot<QuantifiedComponent4Public> list){
		super(list);
	}
	public QuantifiedComponentSearchList(){
		super();
	}
	
	public void add (QuantifiedComponent4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(QuantifiedComponentSearchList list) throws PersistenceException{
		java.util.Iterator<QuantifiedComponent4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<QuantifiedComponent4Public> iterator() {
		return this.getData().iterator();
	}
  	public QuantifiedComponentSearchList copy() throws PersistenceException {
  		QuantifiedComponentSearchList result = new QuantifiedComponentSearchList();
  		result.add(this);
  		return result;
  	}
}


