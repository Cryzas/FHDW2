package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class DraftFacade{

	private String schemaName;
	private Connection con;

	public DraftFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDraft newDraft(String subject,String text,long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DrftFacade.newDrft(?,?,?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setString(2, subject);
            callable.setString(3, text);
            callable.setLong(4, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Draft result = new Draft(subject,text,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentDraft)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentDraft newDelayedDraft(String subject,String text) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DrftFacade.newDelayedDrft(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Draft result = new Draft(subject,text,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentDraft)PersistentProxi.createProxi(id, 133);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Draft getDraft(long DraftId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DrftFacade.getDrft(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DraftId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentMail This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentMail)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentAccountWrapper sender = null;
            if (obj.getLong(6) != 0)
                sender = (PersistentAccountWrapper)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Draft result = new Draft(obj.getString(2) == null ? "" : obj.getString(2) /* In Oracle "" = null !!! */,
                                     obj.getString(3) == null ? "" : obj.getString(3) /* In Oracle "" = null !!! */,
                                     This,
                                     sender,
                                     DraftId);
            obj.close();
            callable.close();
            DraftICProxi inCache = (DraftICProxi)Cache.getTheCache().put(result);
            Draft objectInCache = (Draft)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void senderSet(long DraftId, AccountWrapper4Public senderVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".DrftFacade.sndrSet(?, ?, ?); end;");
            callable.setLong(1, DraftId);
            callable.setLong(2, senderVal.getId());
            callable.setLong(3, senderVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

