package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_1_5Facade{

	private String schemaName;
	private Connection con;

	public Z_1_5Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_1_5 getTheZ_1_5() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_1_5Facade.getTheZ_1_5; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_1_5)PersistentProxi.createProxi(id, 249);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_1_5 getZ_1_5(long Z_1_5Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_1_5Facade.getZ_1_5(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_1_5Id);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentGradesInTenth This = null;
            if (obj.getLong(2) != 0)
                This = (PersistentGradesInTenth)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            Z_1_5 result = new Z_1_5(This,
                                     Z_1_5Id);
            obj.close();
            callable.close();
            Z_1_5ICProxi inCache = (Z_1_5ICProxi)Cache.getTheCache().put(result);
            Z_1_5 objectInCache = (Z_1_5)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

