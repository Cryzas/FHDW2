package persistence;

public class Z_1_9ListEntryProxi extends Z_1_9Proxi implements PersistentZ_1_9ListEntryProxi {

  long entryId;

  public Z_1_9ListEntryProxi(long objectId, long entryId) {
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