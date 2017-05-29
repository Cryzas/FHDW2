package persistence;

public abstract class ClipBoardStateListEntryProxi extends ClipBoardStateProxi implements PersistentClipBoardStateListEntryProxi {

  long entryId;

  public ClipBoardStateListEntryProxi(long objectId, long entryId) {
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