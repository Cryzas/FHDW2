package persistence;

public class UnitSGroupSearchList extends DefaultSearchListRoot<UnitSGroup4Public> implements Iterable<UnitSGroup4Public> {

	public UnitSGroupSearchList(SearchListRoot<UnitSGroup4Public> list){
		super(list);
	}
	public UnitSGroupSearchList(){
		super();
	}
	
	public void add (UnitSGroup4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(UnitSGroupSearchList list) throws PersistenceException{
		java.util.Iterator<UnitSGroup4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<UnitSGroup4Public> iterator() {
		return this.getData().iterator();
	}
  	public UnitSGroupSearchList copy() throws PersistenceException {
  		UnitSGroupSearchList result = new UnitSGroupSearchList();
  		result.add(this);
  		return result;
  	}
}


