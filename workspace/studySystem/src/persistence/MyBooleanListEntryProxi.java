package persistence;

public abstract class MyBooleanListEntryProxi extends MyBooleanProxi implements PersistentMyBooleanListEntryProxi {

  long entryId;

  public MyBooleanListEntryProxi(long objectId, long entryId) {
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