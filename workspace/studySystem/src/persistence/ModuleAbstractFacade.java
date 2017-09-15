package persistence;



public class ModuleAbstractFacade{

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

	

	public ModuleAbstractFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 153)) return 153;
        if(Cache.getTheCache().contains(objectId, 166)) return 166;
        if(Cache.getTheCache().contains(objectId, 154)) return 154;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ModuleAbstractSearchList getModuleAbstractByName(String name) throws PersistenceException {
        name = name.replaceAll("\\\\", "\\\\\\\\");
        name = name.replaceAll("\\?", "\\\\?");
        name = name.replaceAll("\\+", "\\\\+");
        name = name.replaceAll("\\*", "\\\\*");
        name = name.replaceAll("\\[", "\\\\[");
        name = name.replaceAll("\\]", "\\\\]");
        name = name.replaceAll("\\{", "\\\\{");
        name = name.replaceAll("\\}", "\\\\}");
        name = name.replaceAll("\\&", "\\\\&");
        name = name.replaceAll("\\-", "\\\\-");
        name = name.replaceAll("@@", "@-");
        name = name.replaceAll("%", "%-");
        name = name.replaceAll("_", "_-");
        name = name.replaceAll("@_-", "_");
        name = name.replaceAll("@%-", "%");
        name = name.replaceAll("@-", "@");
        name = name.replaceAll("%-", ".*");
        name = name.replaceAll("_-", ".");
        ModuleAbstractSearchList result = new ModuleAbstractSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(153);
        while (candidates.hasNext()){
            PersistentModuleAbstract current = (PersistentModuleAbstract)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentModuleAbstract)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(166);
        while (candidates.hasNext()){
            PersistentModuleAbstract current = (PersistentModuleAbstract)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentModuleAbstract)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        candidates = Cache.getTheCache().iterator(154);
        while (candidates.hasNext()){
            PersistentModuleAbstract current = (PersistentModuleAbstract)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentModuleAbstract)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public void nameSet(long ModuleAbstractId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long ModuleAbstractId, ModuleAbstract4Public ThisVal) throws PersistenceException {
        
    }

}

