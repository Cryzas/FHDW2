package persistence;

public class UnitStudentListEntryProxi extends UnitStudentProxi implements PersistentUnitStudentListEntryProxi {

  long entryId;

  public UnitStudentListEntryProxi(long objectId, long entryId) {
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