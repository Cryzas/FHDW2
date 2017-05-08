package persistence;

public class CreateTransferCommandListEntryProxi extends CreateTransferCommandProxi implements PersistentCreateTransferCommandListEntryProxi {

  long entryId;

  public CreateTransferCommandListEntryProxi(long objectId, long entryId) {
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