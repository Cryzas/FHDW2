package persistence;

public class Z_2_4ListEntryProxi extends Z_2_4Proxi implements PersistentZ_2_4ListEntryProxi {

  long entryId;

  public Z_2_4ListEntryProxi(long objectId, long entryId) {
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