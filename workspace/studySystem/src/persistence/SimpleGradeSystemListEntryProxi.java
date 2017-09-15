package persistence;

public class SimpleGradeSystemListEntryProxi extends SimpleGradeSystemProxi implements PersistentSimpleGradeSystemListEntryProxi {

  long entryId;

  public SimpleGradeSystemListEntryProxi(long objectId, long entryId) {
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