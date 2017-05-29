package persistence;

public class DirectorySearchList extends DefaultSearchListRoot<Directory4Public> implements Iterable<Directory4Public> {

	public DirectorySearchList(SearchListRoot<Directory4Public> list){
		super(list);
	}
	public DirectorySearchList(){
		super();
	}
	
	public void add (Directory4Public entry) {
		this.getData().add(entry);
	}
	
	public void add(DirectorySearchList list) throws PersistenceException{
		java.util.Iterator<Directory4Public> entries = list.iterator();
		while (entries.hasNext()){
			this.add(entries.next());
		}
	}
	public java.util.Iterator<Directory4Public> iterator() {
		return this.getData().iterator();
	}
  	public DirectorySearchList copy() throws PersistenceException {
  		DirectorySearchList result = new DirectorySearchList();
  		result.add(this);
  		return result;
  	}
}


