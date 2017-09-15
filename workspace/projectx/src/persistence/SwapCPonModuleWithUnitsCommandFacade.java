package persistence;

import model.meta.*;

public class SwapCPonModuleWithUnitsCommandFacade{

	static private Long sequencer = new Long(0);

	static protected long getTheNextId(){
		long result = -1;
		synchronized (sequencer) { 
			result = sequencer.longValue() + 1;
			sequencer = new Long(result);
		}
		return result;
	}

	protected long getNextId(){
		return getTheNextId();
	}

	

	public SwapCPonModuleWithUnitsCommandFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentSwapCPonModuleWithUnitsCommand newSwapCPonModuleWithUnitsCommand(common.Fraction creditPoints,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentSwapCPonModuleWithUnitsCommand)PersistentProxi.createProxi(idCreateIfLessZero, 188);
        long id = ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.getNextId();
        SwapCPonModuleWithUnitsCommand result = new SwapCPonModuleWithUnitsCommand(null,null,null,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentSwapCPonModuleWithUnitsCommand)PersistentProxi.createProxi(id, 188);
    }
    
    public PersistentSwapCPonModuleWithUnitsCommand newDelayedSwapCPonModuleWithUnitsCommand(common.Fraction creditPoints) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theSwapCPonModuleWithUnitsCommandFacade.getNextId();
        SwapCPonModuleWithUnitsCommand result = new SwapCPonModuleWithUnitsCommand(null,null,null,creditPoints,null,null,null,id);
        Cache.getTheCache().put(result);
        return (PersistentSwapCPonModuleWithUnitsCommand)PersistentProxi.createProxi(id, 188);
    }
    
    public SwapCPonModuleWithUnitsCommand getSwapCPonModuleWithUnitsCommand(long SwapCPonModuleWithUnitsCommandId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 188)) return 188;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void moduleSet(long SwapCPonModuleWithUnitsCommandId, ModuleWithUnitsSGroup4Public moduleVal) throws PersistenceException {
        
    }
    public void fromUnitSet(long SwapCPonModuleWithUnitsCommandId, UnitSGroup4Public fromUnitVal) throws PersistenceException {
        
    }
    public void ToUnitSet(long SwapCPonModuleWithUnitsCommandId, UnitSGroup4Public ToUnitVal) throws PersistenceException {
        
    }
    public void creditPointsSet(long SwapCPonModuleWithUnitsCommandId, common.Fraction creditPointsVal) throws PersistenceException {
        
    }
    public void invokerSet(long SwapCPonModuleWithUnitsCommandId, Invoker invokerVal) throws PersistenceException {
        
    }
    public void commandReceiverSet(long SwapCPonModuleWithUnitsCommandId, StudyGroupManager4Public commandReceiverVal) throws PersistenceException {
        
    }
    public void myCommonDateSet(long SwapCPonModuleWithUnitsCommandId, CommonDate4Public myCommonDateVal) throws PersistenceException {
        
    }

}

