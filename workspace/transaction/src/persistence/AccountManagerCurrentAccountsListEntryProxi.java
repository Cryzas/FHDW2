package persistence;

public class AccountManagerCurrentAccountsListEntryProxi extends AccountManagerCurrentAccountsProxi implements PersistentAccountManagerCurrentAccountsListEntryProxi {

  long entryId;

  public AccountManagerCurrentAccountsListEntryProxi(long objectId, long entryId) {
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