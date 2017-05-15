package persistence;

public class AccountWrpprListEntryProxi extends AccountWrpprProxi implements PersistentAccountWrpprListEntryProxi {

  long entryId;

  public AccountWrpprListEntryProxi(long objectId, long entryId) {
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