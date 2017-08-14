package persistence;

public class AnswerAllCommandListEntryProxi extends AnswerAllCommandProxi implements PersistentAnswerAllCommandListEntryProxi {

  long entryId;

  public AnswerAllCommandListEntryProxi(long objectId, long entryId) {
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