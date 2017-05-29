package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class FilledCBStateFacade{

	private String schemaName;
	private Connection con;

	public FilledCBStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentFilledCBState newFilledCBState(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FlldCBSttFacade.newFlldCBStt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FilledCBState result = new FilledCBState(null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentFilledCBState)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentFilledCBState newDelayedFilledCBState() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".FlldCBSttFacade.newDelayedFlldCBStt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            FilledCBState result = new FilledCBState(null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentFilledCBState)PersistentProxi.createProxi(id, 128);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public FilledCBState getFilledCBState(long FilledCBStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".FlldCBSttFacade.getFlldCBStt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, FilledCBStateId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentClipBoardState This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentClipBoardState)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentContainee contents = null;
            if (obj.getLong(4) != 0)
                contents = (PersistentContainee)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            FilledCBState result = new FilledCBState(This,
                                                     contents,
                                                     FilledCBStateId);
            obj.close();
            callable.close();
            FilledCBStateICProxi inCache = (FilledCBStateICProxi)Cache.getTheCache().put(result);
            FilledCBState objectInCache = (FilledCBState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void contentsSet(long FilledCBStateId, Containee4Public contentsVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".FlldCBSttFacade.cntntsSet(?, ?, ?); end;");
            callable.setLong(1, FilledCBStateId);
            callable.setLong(2, contentsVal.getId());
            callable.setLong(3, contentsVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

