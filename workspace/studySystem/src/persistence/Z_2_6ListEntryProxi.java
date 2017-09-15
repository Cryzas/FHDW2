package persistence;

public class Z_2_6ListEntryProxi extends Z_2_6Proxi implements PersistentZ_2_6ListEntryProxi {

  long entryId;

  public Z_2_6ListEntryProxi(long objectId, long entryId) {
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