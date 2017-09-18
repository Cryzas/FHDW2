package persistence;

public abstract class subAdminServiceListEntryProxi extends subAdminServiceProxi implements PersistentsubAdminServiceListEntryProxi {

  long entryId;

  public subAdminServiceListEntryProxi(long objectId, long entryId) {
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