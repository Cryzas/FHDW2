package persistence;

public class UnitSearchList extends DefaultSearchListRoot<Unit4Public> implements Iterable<Unit4Public> {

	public UnitSearchList(SearchListRoot<Unit4Public> list){
		super(list);
	}
	public UnitSearchList(){
		super();
	}
	
	public void add (Unit4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(UnitSearchList list) throws PersistenceException{
		java.util.Iterator<Unit4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Unit4Public> iterator() {
		return this.getData().iterator();
	}
  	public UnitSearchList copy() throws PersistenceException {
  		UnitSearchList result = new UnitSearchList();
  		result.add(this);
  		return result;
  	}
}


