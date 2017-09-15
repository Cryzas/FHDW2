package persistence;

public class Z_3_0ListEntryProxi extends Z_3_0Proxi implements PersistentZ_3_0ListEntryProxi {

  long entryId;

  public Z_3_0ListEntryProxi(long objectId, long entryId) {
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