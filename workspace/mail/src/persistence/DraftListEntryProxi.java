package persistence;

public class DraftListEntryProxi extends DraftProxi implements PersistentDraftListEntryProxi {

  long entryId;

  public DraftListEntryProxi(long objectId, long entryId) {
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