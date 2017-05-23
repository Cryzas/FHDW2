package persistence;

public class abstractAccSearchList extends DefaultSearchListRoot<abstractAcc4Public> implements Iterable<abstractAcc4Public> {

	public abstractAccSearchList(SearchListRoot<abstractAcc4Public> list){
		super(list);
	}
	public abstractAccSearchList(){
		super();
	}
	
	public void add (abstractAcc4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(abstractAccSearchList list) throws PersistenceException{
		java.util.Iterator<abstractAcc4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<abstractAcc4Public> iterator() {
		return this.getData().iterator();
	}
  	public abstractAccSearchList copy() throws PersistenceException {
  		abstractAccSearchList result = new abstractAccSearchList();
  		result.add(this);
  		return result;
  	}
}


