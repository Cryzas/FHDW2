package persistence;

public class FileSystemListEntryProxi extends FileSystemProxi implements PersistentFileSystemListEntryProxi {

  long entryId;

  public FileSystemListEntryProxi(long objectId, long entryId) {
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