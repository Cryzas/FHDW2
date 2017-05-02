package persistence;

public class AddPartCommandListEntryProxi extends AddPartCommandProxi implements PersistentAddPartCommandListEntryProxi {

  long entryId;

  public AddPartCommandListEntryProxi(long objectId, long entryId) {
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