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
		listProxiFactories = new ListProxiFactory[42];
        listProxiFactories[14] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[1] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[39] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NoAccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[2] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ErrorDisplayListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[33] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AccountWrpprAccountListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[17] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AccountWrpprListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[0] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandCoordinatorListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[19] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreditListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[36] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BookedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[25] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateTransferCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[22] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CreateAccountCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[34] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AccountManagerCurrentAccountsListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[13] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TransferManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[40] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new WrapperRecycleListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[15] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new DebitListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[35] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new ServerAccountsListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[37] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new NotBookedListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[29] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new SubjListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[28] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new BookCommandListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[20] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new TransferListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[21] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new AccountManagerListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[3] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommonDateListEntryProxi(objectId, entryId);
            }
        };
        listProxiFactories[4] = new ListProxiFactory(){
            AbstractPersistentRoot create(long objectId, long entryId){
                return new CommandExecuterListEntryProxi(objectId, entryId);
            }
        };
	}
	return listProxiFactories;
  }
  private static ProxiFactory [] getTheProxiFactories(){
	if (proxiFactories == null){
		proxiFactories = new ProxiFactory [42];
        proxiFactories[14] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AccountProxi(objectId);
            }
        };
        proxiFactories[1] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerProxi(objectId);
            }
        };
        proxiFactories[39] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NoAccountProxi(objectId);
            }
        };
        proxiFactories[2] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ErrorDisplayProxi(objectId);
            }
        };
        proxiFactories[33] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AccountWrpprAccountProxi(objectId);
            }
        };
        proxiFactories[17] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AccountWrpprProxi(objectId);
            }
        };
        proxiFactories[0] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandCoordinatorProxi(objectId);
            }
        };
        proxiFactories[19] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreditProxi(objectId);
            }
        };
        proxiFactories[36] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BookedProxi(objectId);
            }
        };
        proxiFactories[25] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateTransferCommandProxi(objectId);
            }
        };
        proxiFactories[22] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CreateAccountCommandProxi(objectId);
            }
        };
        proxiFactories[34] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AccountManagerCurrentAccountsProxi(objectId);
            }
        };
        proxiFactories[13] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TransferManagerProxi(objectId);
            }
        };
        proxiFactories[40] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new WrapperRecycleProxi(objectId);
            }
        };
        proxiFactories[15] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new DebitProxi(objectId);
            }
        };
        proxiFactories[35] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new ServerAccountsProxi(objectId);
            }
        };
        proxiFactories[37] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new NotBookedProxi(objectId);
            }
        };
        proxiFactories[29] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new SubjProxi(objectId);
            }
        };
        proxiFactories[28] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new BookCommandProxi(objectId);
            }
        };
        proxiFactories[20] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new TransferProxi(objectId);
            }
        };
        proxiFactories[21] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new AccountManagerProxi(objectId);
            }
        };
        proxiFactories[3] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommonDateProxi(objectId);
            }
        };
        proxiFactories[4] = new ProxiFactory(){
            AbstractPersistentRoot create(long objectId){
                return new CommandExecuterProxi(objectId);
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
	
	
    protected void setDltd() throws PersistenceException{
        this.getTheObject().setDltd();
    }
    public boolean isDltd() throws PersistenceException {
        return this.getTheObject().isDltd();
    }
	
	
//	public void finalize(){
//		if (this.object != null)this.object.decrementUserCount();
//	}
}
