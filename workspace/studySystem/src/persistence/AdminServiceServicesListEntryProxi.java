package persistence;

public class AdminServiceServicesListEntryProxi extends AdminServiceServicesProxi implements PersistentAdminServiceServicesListEntryProxi {

  long entryId;

  public AdminServiceServicesListEntryProxi(long objectId, long entryId) {
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