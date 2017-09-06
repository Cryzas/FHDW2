package persistence;

public class Z_1_7ListEntryProxi extends Z_1_7Proxi implements PersistentZ_1_7ListEntryProxi {

  long entryId;

  public Z_1_7ListEntryProxi(long objectId, long entryId) {
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