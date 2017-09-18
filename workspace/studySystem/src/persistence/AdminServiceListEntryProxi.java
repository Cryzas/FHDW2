package persistence;

public class AdminServiceListEntryProxi extends AdminServiceProxi implements PersistentAdminServiceListEntryProxi {

  long entryId;

  public AdminServiceListEntryProxi(long objectId, long entryId) {
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