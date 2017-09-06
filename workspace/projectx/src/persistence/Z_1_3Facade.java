package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class Z_1_3Facade{

	private String schemaName;
	private Connection con;

	public Z_1_3Facade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentZ_1_3 getTheZ_1_3() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_1_3Facade.getTheZ_1_3; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentZ_1_3)PersistentProxi.createProxi(id, 244);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public Z_1_3 getZ_1_3(long Z_1_3Id) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".Z_1_3Facade.getZ_1_3(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, Z_1_3Id);
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
            Z_1_3 result = new Z_1_3(This,
                                     Z_1_3Id);
            obj.close();
            callable.close();
            Z_1_3ICProxi inCache = (Z_1_3ICProxi)Cache.getTheCache().put(result);
            Z_1_3 objectInCache = (Z_1_3)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

