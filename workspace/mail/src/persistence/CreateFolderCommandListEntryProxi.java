package persistence;

public class CreateFolderCommandListEntryProxi extends CreateFolderCommandProxi implements PersistentCreateFolderCommandListEntryProxi {

  long entryId;

  public CreateFolderCommandListEntryProxi(long objectId, long entryId) {
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