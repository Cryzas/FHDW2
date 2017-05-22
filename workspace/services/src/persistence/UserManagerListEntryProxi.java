package persistence;

public class UserManagerListEntryProxi extends UserManagerProxi implements PersistentUserManagerListEntryProxi {

  long entryId;

  public UserManagerListEntryProxi(long objectId, long entryId) {
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