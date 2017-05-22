package persistence;

public class RemoveTransferCommandListEntryProxi extends RemoveTransferCommandProxi implements PersistentRemoveTransferCommandListEntryProxi {

  long entryId;

  public RemoveTransferCommandListEntryProxi(long objectId, long entryId) {
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