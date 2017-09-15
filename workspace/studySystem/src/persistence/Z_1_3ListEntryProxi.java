package persistence;

public class Z_1_3ListEntryProxi extends Z_1_3Proxi implements PersistentZ_1_3ListEntryProxi {

  long entryId;

  public Z_1_3ListEntryProxi(long objectId, long entryId) {
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