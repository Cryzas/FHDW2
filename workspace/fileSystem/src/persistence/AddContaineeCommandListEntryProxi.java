package persistence;

public class AddContaineeCommandListEntryProxi extends AddContaineeCommandProxi implements PersistentAddContaineeCommandListEntryProxi {

  long entryId;

  public AddContaineeCommandListEntryProxi(long objectId, long entryId) {
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