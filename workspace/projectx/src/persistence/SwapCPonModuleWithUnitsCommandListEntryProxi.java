package persistence;

public class SwapCPonModuleWithUnitsCommandListEntryProxi extends SwapCPonModuleWithUnitsCommandProxi implements PersistentSwapCPonModuleWithUnitsCommandListEntryProxi {

  long entryId;

  public SwapCPonModuleWithUnitsCommandListEntryProxi(long objectId, long entryId) {
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