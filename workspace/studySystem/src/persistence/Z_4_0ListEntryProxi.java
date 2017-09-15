package persistence;

public class Z_4_0ListEntryProxi extends Z_4_0Proxi implements PersistentZ_4_0ListEntryProxi {

  long entryId;

  public Z_4_0ListEntryProxi(long objectId, long entryId) {
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