package persistence;

public class ModuleWithUnitsSearchList extends DefaultSearchListRoot<ModuleWithUnits4Public> implements Iterable<ModuleWithUnits4Public> {

	public ModuleWithUnitsSearchList(SearchListRoot<ModuleWithUnits4Public> list){
		super(list);
	}
	public ModuleWithUnitsSearchList(){
		super();
	}
	
	public void add (ModuleWithUnits4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ModuleWithUnitsSearchList list) throws PersistenceException{
		java.util.Iterator<ModuleWithUnits4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ModuleWithUnits4Public> iterator() {
		return this.getData().iterator();
	}
  	public ModuleWithUnitsSearchList copy() throws PersistenceException {
  		ModuleWithUnitsSearchList result = new ModuleWithUnitsSearchList();
  		result.add(this);
  		return result;
  	}
}


