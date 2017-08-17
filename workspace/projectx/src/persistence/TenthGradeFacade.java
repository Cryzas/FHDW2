package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class TenthGradeFacade{

	private String schemaName;
	private Connection con;

	public TenthGradeFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentTenthGrade getTheTenthGrade() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TnthGrdFacade.getTheTnthGrd; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentTenthGrade)PersistentProxi.createProxi(id, 210);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public TenthGrade getTenthGrade(long TenthGradeId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".TnthGrdFacade.getTnthGrd(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, TenthGradeId);
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
            TenthGrade result = new TenthGrade(This,
                                               TenthGradeId);
            obj.close();
            callable.close();
            TenthGradeICProxi inCache = (TenthGradeICProxi)Cache.getTheCache().put(result);
            TenthGrade objectInCache = (TenthGrade)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

