package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ThirdGradeSystemFacade{

	private String schemaName;
	private Connection con;

	public ThirdGradeSystemFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentThirdGradeSystem getTheThirdGradeSystem() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdGrdSstmFacade.getTheThrdGrdSstm; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentThirdGradeSystem)PersistentProxi.createProxi(id, 212);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ThirdGradeSystem getThirdGradeSystem(long ThirdGradeSystemId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdGrdSstmFacade.getThrdGrdSstm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ThirdGradeSystemId);
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
            ThirdGradeSystem result = new ThirdGradeSystem(This,
                                                           ThirdGradeSystemId);
            obj.close();
            callable.close();
            ThirdGradeSystemICProxi inCache = (ThirdGradeSystemICProxi)Cache.getTheCache().put(result);
            ThirdGradeSystem objectInCache = (ThirdGradeSystem)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

