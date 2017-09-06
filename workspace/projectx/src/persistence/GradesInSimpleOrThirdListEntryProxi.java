package persistence;

public abstract class GradesInSimpleOrThirdListEntryProxi extends GradesInSimpleOrThirdProxi implements PersistentGradesInSimpleOrThirdListEntryProxi {

  long entryId;

  public GradesInSimpleOrThirdListEntryProxi(long objectId, long entryId) {
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