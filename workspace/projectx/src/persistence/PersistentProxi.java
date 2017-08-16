package persistence;

import java.util.HashMap;

import common.ProxiInformation;
import common.RPCConstantsAndServices;

abstract class ProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId);
}
abstract class ListProxiFactory {
	  abstract AbstractPersistentRoot create(long objectId, long entryId);
}

public abstract class PersistentProxi extends PersistentRoot implements PersistentProxiInterface {

  private static ProxiFactory [] proxiFactories;
  private static ListProxiFactory [] listProxiFactories;
	
  private static ListProxiFactory [] getTheListProxiFactories(){
	if (listProxiFactories == null){
		listProxiFactories = new ListProxiFactory[75];
        listProxiFactories[54] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateProgramCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[42] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[55] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeCPOnModuleCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[43] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[52] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleAtomarListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[56] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ChangeCPOnUnitCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[44] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[65] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleGroupListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[46] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new UnitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[58] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateModuleCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[53] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ModuleWithUnitsListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[68] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddModuleToGroupCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[67] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddModuleToProgCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[47] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ProgramManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[60] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AddUnitCommandListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [75];
        proxiFactories[54] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateProgramCommandProxi(objectId);
            }
        };
        proxiFactories[42] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramProxi(objectId);
            }
        };
        proxiFactories[55] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeCPOnModuleCommandProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[43] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[52] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleAtomarProxi(objectId);
            }
        };
        proxiFactories[56] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ChangeCPOnUnitCommandProxi(objectId);
            }
        };
        proxiFactories[44] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleManagerProxi(objectId);
            }
        };
        proxiFactories[65] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleGroupProxi(objectId);
            }
        };
        proxiFactories[46] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new UnitProxi(objectId);
            }
        };
        proxiFactories[58] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateModuleCommandProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[53] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ModuleWithUnitsProxi(objectId);
            }
        };
        proxiFactories[68] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddModuleToGroupCommandProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[67] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddModuleToProgCommandProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandExecuterProxi(objectId);
            }
        };
        proxiFactories[47] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ProgramManagerProxi(objectId);
            }
        };
        proxiFactories[60] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AddUnitCommandProxi(objectId);
            }
        };
	}
	return proxiFactories;
  }

  public static PersistentProxiInterface createProxi(ProxiInformation proxi) throws PersistenceException{
	  if (proxi.isDecorator()){
		  Decoratees resultDecoratee = (Decoratees) createProxi(proxi.getDecorateeObjectId(), proxi.getDecorateeClassId());
		  PersistentProxiInterface resultDecorator = (PersistentProxiInterface) resultDecoratee.createDecorator();
		  resultDecorator.setId(proxi.getObjectId());
		  return resultDecorator;
	  } else {
		  return createProxi(proxi.getObjectId(), proxi.getClassId());
	  }
  }

  public static PersistentProxiInterface createProxi(long objectId, long classId) throws PersistenceException {
    int index = (int) classId;
    if (classId == RPCConstantsAndServices.NullClassID) return null; 
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ProxiFactory factory = getTheProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentProxiInterface result =  (PersistentProxiInterface)factory.create(objectId);
    result.getTheObject();
    return result;
  }
  public static PersistentListEntryProxi createListEntryProxi(long objectId, long classId, long entryId) throws PersistenceException {
    int index = (int) classId;
	if (index < 0) index = index * -1;
    index = index - 101;
    if (index > getTheListProxiFactories().length) throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    ListProxiFactory factory = getTheListProxiFactories()[index];
    if (factory == null)  throw new PersistenceException("Unknown class :" + Long.toString(classId),0);
    PersistentListEntryProxi result =  (PersistentListEntryProxi)factory.create(objectId,entryId);
    result.getTheObject();
    return result;
  }

	private PersistentInCacheProxi object;

	protected PersistentProxi(long id) {
		super(id);
		this.object = null;
	}

	protected PersistentProxi(PersistentInCacheProxi object) {
		//TODO (GOJA) Still needed for Decorator???
		super(object.getId());
		this.object = object;
		this.object.incrementUserCount();
	}
	public boolean isDelayed$Persistence() throws PersistenceException {
		return this.getTheObject().isDelayed$Persistence();
	}

	public void setDelayed$Persistence(boolean b) throws PersistenceException {
		this.getTheObject().setDelayed$Persistence(b);
	}
	public void store() throws PersistenceException{
		this.getTheObject().store();
	}
	public void setId(long id) {
		super.setId(id);
		try {
			this.getTheObject().setId(id);
		} catch (PersistenceException e) {
			throw new PersistenceError(e);
		}
	}

	public void setObject(PersistentRoot object) {
		if (this.object == null)
			this.object = (PersistentInCacheProxi)object;
	}

	public HashMap<String,Object> toHashtable(int depth, int essentialLevel, boolean forGUI) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(depth, essentialLevel, forGUI);
	}
	public HashMap<String, Object> toHashtable(HashMap<String, Object> allResults, int depth, int essentialLevel, boolean forGUI, boolean leaf, boolean inDerived) throws PersistenceException {
		PersistentRoot iCRroxi = this.getTheObject();
		if (iCRroxi == null) return null;
		return iCRroxi.toHashtable(allResults, depth, essentialLevel, forGUI, leaf, inDerived);
	}

	public PersistentRoot getTheObject() throws PersistenceException {
		if (this.object == null) {
			this.object = Cache.getTheCache().get(this);
			this.object.incrementUserCount();
		}
		return this.object;
	}
	public boolean hasEssentialFields() throws PersistenceException{
		return this.getTheObject().hasEssentialFields();
	}
	public int getIconInfo() throws PersistenceException {
		return this.getTheObject().getIconInfo();
	}
	public int getLeafInfo() throws PersistenceException {
		return this.getTheObject().getLeafInfo();
	}
	
	public String toString() {
		try {
			return this.getTheObject().toString();
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}
	}
	public String toString(boolean inner)throws PersistenceException{
		try {
			return this.getTheObject().toString(inner);
		} catch (PersistenceException pe) {
			throw new PersistenceError(pe);
		}		
	}
	public void delete$Me() throws PersistenceException {
		this.getTheObject().delete$Me();
	}
	public Anything getThis() throws PersistenceException {
		return this.getTheObject().getThis();
	}
	
	
    	
	
	public void finalize(){
		if (this.object != null)this.object.decrementUserCount();
	}
}
