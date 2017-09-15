package persistence;

public class T_2_7ListEntryProxi extends T_2_7Proxi implements PersistentT_2_7ListEntryProxi {

  long entryId;

  public T_2_7ListEntryProxi(long objectId, long entryId) {
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