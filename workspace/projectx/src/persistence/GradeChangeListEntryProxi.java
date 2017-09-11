package persistence;

public class GradeChangeListEntryProxi extends GradeChangeProxi implements PersistentGradeChangeListEntryProxi {

  long entryId;

  public GradeChangeListEntryProxi(long objectId, long entryId) {
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