package persistence;

public class EndStudyGroupCommandListEntryProxi extends EndStudyGroupCommandProxi implements PersistentEndStudyGroupCommandListEntryProxi {

  long entryId;

  public EndStudyGroupCommandListEntryProxi(long objectId, long entryId) {
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