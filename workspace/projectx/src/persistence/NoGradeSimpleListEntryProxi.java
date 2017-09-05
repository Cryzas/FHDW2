package persistence;

public class NoGradeSimpleListEntryProxi extends NoGradeSimpleProxi implements PersistentNoGradeSimpleListEntryProxi {

  long entryId;

  public NoGradeSimpleListEntryProxi(long objectId, long entryId) {
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