package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ClipBoardFacade{

	private String schemaName;
	private Connection con;

	public ClipBoardFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentClipBoard newClipBoard(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ClpBrdFacade.newClpBrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ClipBoard result = new ClipBoard(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentClipBoard)PersistentProxi.createProxi(id, 130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentClipBoard newDelayedClipBoard() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".ClpBrdFacade.newDelayedClpBrd(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            ClipBoard result = new ClipBoard(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentClipBoard)PersistentProxi.createProxi(id, 130);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ClipBoard getClipBoard(long ClipBoardId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ClpBrdFacade.getClpBrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ClipBoardId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentClipBoardState state = null;
            if (obj.getLong(2) != 0)
                state = (PersistentClipBoardState)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentClipBoard This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentClipBoard)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            ClipBoard result = new ClipBoard(state,
                                             This,
                                             ClipBoardId);
            obj.close();
            callable.close();
            ClipBoardICProxi inCache = (ClipBoardICProxi)Cache.getTheCache().put(result);
            ClipBoard objectInCache = (ClipBoard)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ClpBrdFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void stateSet(long ClipBoardId, ClipBoardState4Public stateVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ClpBrdFacade.sttSet(?, ?, ?); end;");
            callable.setLong(1, ClipBoardId);
            callable.setLong(2, stateVal.getId());
            callable.setLong(3, stateVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long ClipBoardId, ClipBoard4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".ClpBrdFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, ClipBoardId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

