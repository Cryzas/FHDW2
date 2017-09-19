package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class BFalseFacade{

	private String schemaName;
	private Connection con;

	public BFalseFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentBFalse getTheBFalse() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BFlsFacade.getTheBFls; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentBFalse)PersistentProxi.createProxi(id, 282);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public BFalse getBFalse(long BFalseId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".BFlsFacade.getBFls(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, BFalseId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            SubjInterface subService = null;
            if (obj.getLong(2) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            PersistentMyBoolean This = null;
            if (obj.getLong(4) != 0)
                This = (PersistentMyBoolean)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            BFalse result = new BFalse(subService,
                                       This,
                                       BFalseId);
            obj.close();
            callable.close();
            BFalseICProxi inCache = (BFalseICProxi)Cache.getTheCache().put(result);
            BFalse objectInCache = (BFalse)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

