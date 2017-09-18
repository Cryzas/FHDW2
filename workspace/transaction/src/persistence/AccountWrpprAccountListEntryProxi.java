package persistence;

public class AccountWrpprAccountListEntryProxi extends AccountWrpprAccountProxi implements PersistentAccountWrpprAccountListEntryProxi {

  long entryId;

  public AccountWrpprAccountListEntryProxi(long objectId, long entryId) {
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