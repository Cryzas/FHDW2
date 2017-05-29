package persistence;

public class ContaineeSearchList extends DefaultSearchListRoot<Containee4Public> implements Iterable<Containee4Public> {

	public ContaineeSearchList(SearchListRoot<Containee4Public> list){
		super(list);
	}
	public ContaineeSearchList(){
		super();
	}
	
	public void add (Containee4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ContaineeSearchList list) throws PersistenceException{
		java.util.Iterator<Containee4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Containee4Public> iterator() {
		return this.getData().iterator();
	}
  	public ContaineeSearchList copy() throws PersistenceException {
  		ContaineeSearchList result = new ContaineeSearchList();
  		result.add(this);
  		return result;
  	}
}


