package persistence;

public abstract class AccountHandleListEntryProxi extends AccountHandleProxi implements PersistentAccountHandleListEntryProxi {

  long entryId;

  public AccountHandleListEntryProxi(long objectId, long entryId) {
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