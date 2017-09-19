package persistence;



public class GradeFacade{

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

	

	public GradeFacade() {
	}

    public long getClass(long objectId) throws PersistenceException{
        if(Cache.getTheCache().contains(objectId, 214)) return 214;
        if(Cache.getTheCache().contains(objectId, 219)) return 219;
        if(Cache.getTheCache().contains(objectId, 225)) return 225;
        if(Cache.getTheCache().contains(objectId, 222)) return 222;
        if(Cache.getTheCache().contains(objectId, 239)) return 239;
        if(Cache.getTheCache().contains(objectId, 223)) return 223;
        if(Cache.getTheCache().contains(objectId, 240)) return 240;
        if(Cache.getTheCache().contains(objectId, 273)) return 273;
        if(Cache.getTheCache().contains(objectId, 261)) return 261;
        if(Cache.getTheCache().contains(objectId, 220)) return 220;
        if(Cache.getTheCache().contains(objectId, 262)) return 262;
        if(Cache.getTheCache().contains(objectId, 224)) return 224;
        if(Cache.getTheCache().contains(objectId, 263)) return 263;
        if(Cache.getTheCache().contains(objectId, 221)) return 221;
        if(Cache.getTheCache().contains(objectId, 226)) return 226;
        if(Cache.getTheCache().contains(objectId, 227)) return 227;
        if(Cache.getTheCache().contains(objectId, 228)) return 228;
        if(Cache.getTheCache().contains(objectId, 229)) return 229;
        if(Cache.getTheCache().contains(objectId, 230)) return 230;
        if(Cache.getTheCache().contains(objectId, 231)) return 231;
        if(Cache.getTheCache().contains(objectId, 232)) return 232;
        if(Cache.getTheCache().contains(objectId, 233)) return 233;
        if(Cache.getTheCache().contains(objectId, 234)) return 234;
        if(Cache.getTheCache().contains(objectId, 235)) return 235;
        if(Cache.getTheCache().contains(objectId, 236)) return 236;
        if(Cache.getTheCache().contains(objectId, 237)) return 237;
        if(Cache.getTheCache().contains(objectId, 238)) return 238;
        if(Cache.getTheCache().contains(objectId, 241)) return 241;
        if(Cache.getTheCache().contains(objectId, 242)) return 242;
        if(Cache.getTheCache().contains(objectId, 243)) return 243;
        if(Cache.getTheCache().contains(objectId, 244)) return 244;
        if(Cache.getTheCache().contains(objectId, 245)) return 245;
        if(Cache.getTheCache().contains(objectId, 246)) return 246;
        if(Cache.getTheCache().contains(objectId, 247)) return 247;
        if(Cache.getTheCache().contains(objectId, 248)) return 248;
        if(Cache.getTheCache().contains(objectId, 249)) return 249;
        if(Cache.getTheCache().contains(objectId, 250)) return 250;
        if(Cache.getTheCache().contains(objectId, 251)) return 251;
        if(Cache.getTheCache().contains(objectId, 252)) return 252;
        if(Cache.getTheCache().contains(objectId, 253)) return 253;
        if(Cache.getTheCache().contains(objectId, 254)) return 254;
        if(Cache.getTheCache().contains(objectId, 255)) return 255;
        if(Cache.getTheCache().contains(objectId, 256)) return 256;
        if(Cache.getTheCache().contains(objectId, 257)) return 257;
        if(Cache.getTheCache().contains(objectId, 258)) return 258;
        if(Cache.getTheCache().contains(objectId, 259)) return 259;
        
        throw new PersistenceException("No such object: " + new Long(objectId).toString(), 0);
        
    }
    public void subServiceSet(long GradeId, SubjInterface subServiceVal) throws PersistenceException {
        
    }
    public void ThisSet(long GradeId, Grade4Public ThisVal) throws PersistenceException {
        
    }

}

