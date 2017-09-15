package persistence;

public class T_4_0ListEntryProxi extends T_4_0Proxi implements PersistentT_4_0ListEntryProxi {

  long entryId;

  public T_4_0ListEntryProxi(long objectId, long entryId) {
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