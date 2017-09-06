package persistence;

public class T_3_0ListEntryProxi extends T_3_0Proxi implements PersistentT_3_0ListEntryProxi {

  long entryId;

  public T_3_0ListEntryProxi(long objectId, long entryId) {
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