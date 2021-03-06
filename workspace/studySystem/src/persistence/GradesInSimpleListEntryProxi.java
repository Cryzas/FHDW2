package persistence;

public abstract class GradesInSimpleListEntryProxi extends GradesInSimpleProxi implements PersistentGradesInSimpleListEntryProxi {

  long entryId;

  public GradesInSimpleListEntryProxi(long objectId, long entryId) {
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