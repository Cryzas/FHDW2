package persistence;

public class UserManagerServiceListEntryProxi extends UserManagerServiceProxi implements PersistentUserManagerServiceListEntryProxi {

  long entryId;

  public UserManagerServiceListEntryProxi(long objectId, long entryId) {
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