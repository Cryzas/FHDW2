package persistence;

public class ModuleAbstractSearchList extends DefaultSearchListRoot<ModuleAbstract4Public> implements Iterable<ModuleAbstract4Public> {

	public ModuleAbstractSearchList(SearchListRoot<ModuleAbstract4Public> list){
		super(list);
	}
	public ModuleAbstractSearchList(){
		super();
	}
	
	public void add (ModuleAbstract4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ModuleAbstractSearchList list) throws PersistenceException{
		java.util.Iterator<ModuleAbstract4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ModuleAbstract4Public> iterator() {
		return this.getData().iterator();
	}
  	public ModuleAbstractSearchList copy() throws PersistenceException {
  		ModuleAbstractSearchList result = new ModuleAbstractSearchList();
  		result.add(this);
  		return result;
  	}
}


