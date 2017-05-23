package persistence;

public class FolderListEntryProxi extends FolderProxi implements PersistentFolderListEntryProxi {

  long entryId;

  public FolderListEntryProxi(long objectId, long entryId) {
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