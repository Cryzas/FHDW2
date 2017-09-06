package persistence;

public class Z_3_1ListEntryProxi extends Z_3_1Proxi implements PersistentZ_3_1ListEntryProxi {

  long entryId;

  public Z_3_1ListEntryProxi(long objectId, long entryId) {
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