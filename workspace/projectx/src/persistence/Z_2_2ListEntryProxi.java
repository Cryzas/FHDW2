package persistence;

public class Z_2_2ListEntryProxi extends Z_2_2Proxi implements PersistentZ_2_2ListEntryProxi {

  long entryId;

  public Z_2_2ListEntryProxi(long objectId, long entryId) {
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