package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class SimpleGradeSystemFacade{

	private String schemaName;
	private Connection con;

	public SimpleGradeSystemFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentSimpleGradeSystem getTheSimpleGradeSystem() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SmplGrdSstmFacade.getTheSmplGrdSstm; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentSimpleGradeSystem)PersistentProxi.createProxi(id, 213);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SimpleGradeSystem getSimpleGradeSystem(long SimpleGradeSystemId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SmplGrdSstmFacade.getSmplGrdSstm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, SimpleGradeSystemId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGradeSystem This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentGradeSystem)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SimpleGradeSystem result = new SimpleGradeSystem(This,
                                                             SimpleGradeSystemId);
            obj.close();
            callable.close();
            SimpleGradeSystemICProxi inCache = (SimpleGradeSystemICProxi)Cache.getTheCache().put(result);
            SimpleGradeSystem objectInCache = (SimpleGradeSystem)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

