package persistence;

public class FileListEntryProxi extends FileProxi implements PersistentFileListEntryProxi {

  long entryId;

  public FileListEntryProxi(long objectId, long entryId) {
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