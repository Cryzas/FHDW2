package persistence;

public class ThirdGradeSystemListEntryProxi extends ThirdGradeSystemProxi implements PersistentThirdGradeSystemListEntryProxi {

  long entryId;

  public ThirdGradeSystemListEntryProxi(long objectId, long entryId) {
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