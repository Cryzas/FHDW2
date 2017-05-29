package persistence;

public class ClipBoardListEntryProxi extends ClipBoardProxi implements PersistentClipBoardListEntryProxi {

  long entryId;

  public ClipBoardListEntryProxi(long objectId, long entryId) {
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