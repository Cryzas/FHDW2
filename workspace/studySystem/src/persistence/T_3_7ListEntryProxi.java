package persistence;

public class T_3_7ListEntryProxi extends T_3_7Proxi implements PersistentT_3_7ListEntryProxi {

  long entryId;

  public T_3_7ListEntryProxi(long objectId, long entryId) {
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