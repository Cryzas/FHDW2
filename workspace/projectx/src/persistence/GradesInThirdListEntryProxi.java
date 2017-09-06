package persistence;

public abstract class GradesInThirdListEntryProxi extends GradesInThirdProxi implements PersistentGradesInThirdListEntryProxi {

  long entryId;

  public GradesInThirdListEntryProxi(long objectId, long entryId) {
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