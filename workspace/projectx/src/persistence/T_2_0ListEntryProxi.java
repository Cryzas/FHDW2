package persistence;

public class T_2_0ListEntryProxi extends T_2_0Proxi implements PersistentT_2_0ListEntryProxi {

  long entryId;

  public T_2_0ListEntryProxi(long objectId, long entryId) {
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