package persistence;

public class StartStudyGroupCommandListEntryProxi extends StartStudyGroupCommandProxi implements PersistentStartStudyGroupCommandListEntryProxi {

  long entryId;

  public StartStudyGroupCommandListEntryProxi(long objectId, long entryId) {
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