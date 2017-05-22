package persistence;

public class AddTransferCommandListEntryProxi extends AddTransferCommandProxi implements PersistentAddTransferCommandListEntryProxi {

  long entryId;

  public AddTransferCommandListEntryProxi(long objectId, long entryId) {
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