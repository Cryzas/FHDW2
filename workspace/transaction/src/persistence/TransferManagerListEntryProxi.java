package persistence;

public class TransferManagerListEntryProxi extends TransferManagerProxi implements PersistentTransferManagerListEntryProxi {

  long entryId;

  public TransferManagerListEntryProxi(long objectId, long entryId) {
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