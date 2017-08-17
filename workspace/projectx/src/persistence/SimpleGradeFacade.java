package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class SimpleGradeFacade{

	private String schemaName;
	private Connection con;

	public SimpleGradeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentSimpleGrade getTheSimpleGrade() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SmplGrdFacade.getTheSmplGrd; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentSimpleGrade)PersistentProxi.createProxi(id, 209);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public SimpleGrade getSimpleGrade(long SimpleGradeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".SmplGrdFacade.getSmplGrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, SimpleGradeId);
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
            SimpleGrade result = new SimpleGrade(This,
                                                 SimpleGradeId);
            obj.close();
            callable.close();
            SimpleGradeICProxi inCache = (SimpleGradeICProxi)Cache.getTheCache().put(result);
            SimpleGrade objectInCache = (SimpleGrade)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

