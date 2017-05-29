package persistence;

public class DeleteCommandListEntryProxi extends DeleteCommandProxi implements PersistentDeleteCommandListEntryProxi {

  long entryId;

  public DeleteCommandListEntryProxi(long objectId, long entryId) {
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