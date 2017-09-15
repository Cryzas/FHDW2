package persistence;

public abstract class GradeSystemListEntryProxi extends GradeSystemProxi implements PersistentGradeSystemListEntryProxi {

  long entryId;

  public GradeSystemListEntryProxi(long objectId, long entryId) {
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