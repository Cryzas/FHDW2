package persistence;

public class T_1_3ListEntryProxi extends T_1_3Proxi implements PersistentT_1_3ListEntryProxi {

  long entryId;

  public T_1_3ListEntryProxi(long objectId, long entryId) {
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