package persistence;

public class FolderSearchList extends DefaultSearchListRoot<Folder4Public> implements Iterable<Folder4Public> {

	public FolderSearchList(SearchListRoot<Folder4Public> list){
		super(list);
	}
	public FolderSearchList(){
		super();
	}
	
	public void add (Folder4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(FolderSearchList list) throws PersistenceException{
		java.util.Iterator<Folder4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Folder4Public> iterator() {
		return this.getData().iterator();
	}
  	public FolderSearchList copy() throws PersistenceException {
  		FolderSearchList result = new FolderSearchList();
  		result.add(this);
  		return result;
  	}
}


