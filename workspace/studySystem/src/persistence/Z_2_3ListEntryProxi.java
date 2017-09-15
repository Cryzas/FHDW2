package persistence;

public class Z_2_3ListEntryProxi extends Z_2_3Proxi implements PersistentZ_2_3ListEntryProxi {

  long entryId;

  public Z_2_3ListEntryProxi(long objectId, long entryId) {
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