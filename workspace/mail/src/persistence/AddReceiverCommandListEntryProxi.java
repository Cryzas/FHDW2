package persistence;

public class AddReceiverCommandListEntryProxi extends AddReceiverCommandProxi implements PersistentAddReceiverCommandListEntryProxi {

  long entryId;

  public AddReceiverCommandListEntryProxi(long objectId, long entryId) {
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