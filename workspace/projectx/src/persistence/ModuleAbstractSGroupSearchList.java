package persistence;

public class ModuleAbstractSGroupSearchList extends DefaultSearchListRoot<ModuleAbstractSGroup4Public> implements Iterable<ModuleAbstractSGroup4Public> {

	public ModuleAbstractSGroupSearchList(SearchListRoot<ModuleAbstractSGroup4Public> list){
		super(list);
	}
	public ModuleAbstractSGroupSearchList(){
		super();
	}
	
	public void add (ModuleAbstractSGroup4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(ModuleAbstractSGroupSearchList list) throws PersistenceException{
		java.util.Iterator<ModuleAbstractSGroup4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<ModuleAbstractSGroup4Public> iterator() {
		return this.getData().iterator();
	}
  	public ModuleAbstractSGroupSearchList copy() throws PersistenceException {
  		ModuleAbstractSGroupSearchList result = new ModuleAbstractSGroupSearchList();
  		result.add(this);
  		return result;
  	}
}


