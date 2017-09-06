package persistence;

public class Z_1_0ListEntryProxi extends Z_1_0Proxi implements PersistentZ_1_0ListEntryProxi {

  long entryId;

  public Z_1_0ListEntryProxi(long objectId, long entryId) {
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