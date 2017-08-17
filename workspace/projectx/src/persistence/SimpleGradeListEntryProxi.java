package persistence;

public class SimpleGradeListEntryProxi extends SimpleGradeProxi implements PersistentSimpleGradeListEntryProxi {

  long entryId;

  public SimpleGradeListEntryProxi(long objectId, long entryId) {
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