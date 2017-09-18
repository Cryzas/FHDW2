package persistence;

public class ServerAccountsListEntryProxi extends ServerAccountsProxi implements PersistentServerAccountsListEntryProxi {

  long entryId;

  public ServerAccountsListEntryProxi(long objectId, long entryId) {
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