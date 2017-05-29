package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class EmptyCBStateFacade{

	private String schemaName;
	private Connection con;

	public EmptyCBStateFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentEmptyCBState getTheEmptyCBState() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EmptCBSttFacade.getTheEmptCBStt; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentEmptyCBState)PersistentProxi.createProxi(id, 129);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public EmptyCBState getEmptyCBState(long EmptyCBStateId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EmptCBSttFacade.getEmptCBStt(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, EmptyCBStateId);
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
            EmptyCBState result = new EmptyCBState(This,
                                                   EmptyCBStateId);
            obj.close();
            callable.close();
            EmptyCBStateICProxi inCache = (EmptyCBStateICProxi)Cache.getTheCache().put(result);
            EmptyCBState objectInCache = (EmptyCBState)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

