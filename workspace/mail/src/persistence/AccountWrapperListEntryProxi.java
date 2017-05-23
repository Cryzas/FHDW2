package persistence;

public class AccountWrapperListEntryProxi extends AccountWrapperProxi implements PersistentAccountWrapperListEntryProxi {

  long entryId;

  public AccountWrapperListEntryProxi(long objectId, long entryId) {
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