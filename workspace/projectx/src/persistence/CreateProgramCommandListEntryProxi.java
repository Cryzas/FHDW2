package persistence;

public class CreateProgramCommandListEntryProxi extends CreateProgramCommandProxi implements PersistentCreateProgramCommandListEntryProxi {

  long entryId;

  public CreateProgramCommandListEntryProxi(long objectId, long entryId) {
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