package persistence;

public class T_3_3ListEntryProxi extends T_3_3Proxi implements PersistentT_3_3ListEntryProxi {

  long entryId;

  public T_3_3ListEntryProxi(long objectId, long entryId) {
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