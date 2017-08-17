package persistence;

public class ThirdGradeListEntryProxi extends ThirdGradeProxi implements PersistentThirdGradeListEntryProxi {

  long entryId;

  public ThirdGradeListEntryProxi(long objectId, long entryId) {
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