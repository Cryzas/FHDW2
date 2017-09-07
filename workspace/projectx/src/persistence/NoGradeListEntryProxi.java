package persistence;

public class NoGradeListEntryProxi extends NoGradeProxi implements PersistentNoGradeListEntryProxi {

  long entryId;

  public NoGradeListEntryProxi(long objectId, long entryId) {
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