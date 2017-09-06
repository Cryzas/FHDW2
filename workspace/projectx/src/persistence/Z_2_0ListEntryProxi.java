package persistence;

public class Z_2_0ListEntryProxi extends Z_2_0Proxi implements PersistentZ_2_0ListEntryProxi {

  long entryId;

  public Z_2_0ListEntryProxi(long objectId, long entryId) {
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