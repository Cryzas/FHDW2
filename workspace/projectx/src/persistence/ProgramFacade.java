package persistence;

import model.*;

public class ProgramFacade{

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

	

	public ProgramFacade() {
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentProgram newProgram(String name,long idCreateIfLessZero) throws PersistenceException {
        if(idCreateIfLessZero > 0) return (PersistentProgram)PersistentProxi.createProxi(idCreateIfLessZero, 143);
        long id = ConnectionHandler.getTheConnectionHandler().theProgramFacade.getNextId();
        Program result = new Program(name,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgram)PersistentProxi.createProxi(id, 143);
    }
    
    public PersistentProgram newDelayedProgram(String name) throws PersistenceException {
        long id = ConnectionHandler.getTheConnectionHandler().theProgramFacade.getNextId();
        Program result = new Program(name,null,id);
        Cache.getTheCache().put(result);
        return (PersistentProgram)PersistentProxi.createProxi(id, 143);
    }
    
    public Program getProgram(long ProgramId) throws PersistenceException{
        return null; //All data is in the cache!
    }
    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 143)) return 143;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public ProgramSearchList getProgramByName(String name) throws PersistenceException {
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
        ProgramSearchList result = new ProgramSearchList();
        java.util.Iterator<?> candidates;
        candidates = Cache.getTheCache().iterator(143);
        while (candidates.hasNext()){
            PersistentProgram current = (PersistentProgram)((PersistentRoot)candidates.next()).getTheObject();
            if (current != null && !current.isDltd() && !current.isDelayed$Persistence() && current.getName().matches(name))
                result.add((PersistentProgram)PersistentProxi.createProxi(current.getId(), current.getClassId()));
        }
        return result;
    }
    public long modulesAdd(long ProgramId, ModuleAbstract4Public modulesVal) throws PersistenceException {
        return 0;
    }
    public void modulesRem(long modulesId) throws PersistenceException {
        
    }
    public ModuleAbstractList modulesGet(long ProgramId) throws PersistenceException {
        return new ModuleAbstractList(); // remote access for initialization only!
    }
    public void nameSet(long ProgramId, String nameVal) throws PersistenceException {
        
    }
    public void ThisSet(long ProgramId, Program4Public ThisVal) throws PersistenceException {
        
    }

}

