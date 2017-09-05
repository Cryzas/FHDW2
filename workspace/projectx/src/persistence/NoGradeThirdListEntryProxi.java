package persistence;

public class NoGradeThirdListEntryProxi extends NoGradeThirdProxi implements PersistentNoGradeThirdListEntryProxi {

  long entryId;

  public NoGradeThirdListEntryProxi(long objectId, long entryId) {
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