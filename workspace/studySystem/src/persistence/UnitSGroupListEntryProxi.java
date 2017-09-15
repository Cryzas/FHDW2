package persistence;

public class UnitSGroupListEntryProxi extends UnitSGroupProxi implements PersistentUnitSGroupListEntryProxi {

  long entryId;

  public UnitSGroupListEntryProxi(long objectId, long entryId) {
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