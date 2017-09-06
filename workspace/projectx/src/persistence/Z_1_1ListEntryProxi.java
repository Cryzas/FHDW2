package persistence;

public class Z_1_1ListEntryProxi extends Z_1_1Proxi implements PersistentZ_1_1ListEntryProxi {

  long entryId;

  public Z_1_1ListEntryProxi(long objectId, long entryId) {
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