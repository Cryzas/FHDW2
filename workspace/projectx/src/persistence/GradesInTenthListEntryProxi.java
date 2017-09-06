package persistence;

public abstract class GradesInTenthListEntryProxi extends GradesInTenthProxi implements PersistentGradesInTenthListEntryProxi {

  long entryId;

  public GradesInTenthListEntryProxi(long objectId, long entryId) {
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