package persistence;

public class CreateTransactionCommandListEntryProxi extends CreateTransactionCommandProxi implements PersistentCreateTransactionCommandListEntryProxi {

  long entryId;

  public CreateTransactionCommandListEntryProxi(long objectId, long entryId) {
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