package persistence;

public class Z_1_6ListEntryProxi extends Z_1_6Proxi implements PersistentZ_1_6ListEntryProxi {

  long entryId;

  public Z_1_6ListEntryProxi(long objectId, long entryId) {
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