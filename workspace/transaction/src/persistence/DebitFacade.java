package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class DebitFacade{

	private String schemaName;
	private Connection con;

	public DebitFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    /* If idCreateIfLessZero is negative, a new id is generated. */
    public PersistentDebit newDebit(long idCreateIfLessZero) throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.newDbt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, idCreateIfLessZero);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Debit result = new Debit(null,null,null,id);
            if (idCreateIfLessZero < 0)Cache.getTheCache().put(result);
            return (PersistentDebit)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public PersistentDebit newDelayedDebit() throws PersistenceException {
        oracle.jdbc.OracleCallableStatement callable;
        try{
            callable = (oracle.jdbc.OracleCallableStatement)this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.newDelayedDbt(); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            Debit result = new Debit(null,null,null,id);
            Cache.getTheCache().put(result);
            return (PersistentDebit)PersistentProxi.createProxi(id, 116);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Debit getDebit(long DebitId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".DbtFacade.getDbt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, DebitId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentTransfer transfer = null;
            if (obj.getLong(2) != 0)
                transfer = (PersistentTransfer)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentEntry This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentEntry)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            Debit result = new Debit(transfer,
                                     subService,
                                     This,
                                     DebitId);
            obj.close();
            callable.close();
            DebitICProxi inCache = (DebitICProxi)Cache.getTheCache().put(result);
            Debit objectInCache = (Debit)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

