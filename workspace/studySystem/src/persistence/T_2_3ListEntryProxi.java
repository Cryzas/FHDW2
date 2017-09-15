package persistence;

public class T_2_3ListEntryProxi extends T_2_3Proxi implements PersistentT_2_3ListEntryProxi {

  long entryId;

  public T_2_3ListEntryProxi(long objectId, long entryId) {
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