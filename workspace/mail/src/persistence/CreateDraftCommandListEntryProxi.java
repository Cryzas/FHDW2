package persistence;

public class CreateDraftCommandListEntryProxi extends CreateDraftCommandProxi implements PersistentCreateDraftCommandListEntryProxi {

  long entryId;

  public CreateDraftCommandListEntryProxi(long objectId, long entryId) {
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