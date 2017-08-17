package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class ThirdGradeFacade{

	private String schemaName;
	private Connection con;

	public ThirdGradeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentThirdGrade getTheThirdGrade() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdGrdFacade.getTheThrdGrd; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentThirdGrade)PersistentProxi.createProxi(id, 208);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public ThirdGrade getThirdGrade(long ThirdGradeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".ThrdGrdFacade.getThrdGrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, ThirdGradeId);
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
            ThirdGrade result = new ThirdGrade(This,
                                               ThirdGradeId);
            obj.close();
            callable.close();
            ThirdGradeICProxi inCache = (ThirdGradeICProxi)Cache.getTheCache().put(result);
            ThirdGrade objectInCache = (ThirdGrade)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

