package persistence;

public class DirectoryListEntryProxi extends DirectoryProxi implements PersistentDirectoryListEntryProxi {

  long entryId;

  public DirectoryListEntryProxi(long objectId, long entryId) {
    super(objectId);
    this.entryId = entryId;
  }
	
  public long getListEntryId() {
    return this.entryId;
  }
  public void setListEntryId(long id){
	this.entryId = id;  
  }

}