package persistence;

public class ChangeGradeOfUnitCommandListEntryProxi extends ChangeGradeOfUnitCommandProxi implements PersistentChangeGradeOfUnitCommandListEntryProxi {

  long entryId;

  public ChangeGradeOfUnitCommandListEntryProxi(long objectId, long entryId) {
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