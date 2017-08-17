package persistence;

public class TenthGradeListEntryProxi extends TenthGradeProxi implements PersistentTenthGradeListEntryProxi {

  long entryId;

  public TenthGradeListEntryProxi(long objectId, long entryId) {
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