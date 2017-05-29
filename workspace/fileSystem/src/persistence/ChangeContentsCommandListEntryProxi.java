package persistence;

public class ChangeContentsCommandListEntryProxi extends ChangeContentsCommandProxi implements PersistentChangeContentsCommandListEntryProxi {

  long entryId;

  public ChangeContentsCommandListEntryProxi(long objectId, long entryId) {
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