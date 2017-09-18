package persistence;

import model.*;

import java.sql.*;
//import oracle.jdbc.*;

public class NoProgramFacade{

	private String schemaName;
	private Connection con;

	public NoProgramFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public PersistentNoProgram getTheNoProgram() throws PersistenceException {
        CallableStatement callable;
        try{
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NPrgrmFacade.getTheNPrgrm; end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.execute();
            long id = callable.getLong(1);
            callable.close();
            return (PersistentNoProgram)PersistentProxi.createProxi(id, 285);
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    
    public NoProgram getNoProgram(long NoProgramId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".NPrgrmFacade.getNPrgrm(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.CURSOR);
            callable.setLong(2, NoProgramId);
            callable.execute();
            ResultSet obj = ((oracle.jdbc.OracleCallableStatement)callable).getCursor(1);
            if (!obj.next()) {
                obj.close();
                callable.close();
                return null;
            }
            PersistentProgramSGroup programCopy = null;
            if (obj.getLong(2) != 0)
                programCopy = (PersistentProgramSGroup)PersistentProxi.createProxi(obj.getLong(2), obj.getLong(3));
            SubjInterface subService = null;
            if (obj.getLong(4) != 0)
                subService = (SubjInterface)PersistentProxi.createProxi(obj.getLong(4), obj.getLong(5));
            PersistentProgramStudent This = null;
            if (obj.getLong(6) != 0)
                This = (PersistentProgramStudent)PersistentProxi.createProxi(obj.getLong(6), obj.getLong(7));
            NoProgram result = new NoProgram(programCopy,
                                             subService,
                                             This,
                                             NoProgramId);
            obj.close();
            callable.close();
            NoProgramICProxi inCache = (NoProgramICProxi)Cache.getTheCache().put(result);
            NoProgram objectInCache = (NoProgram)inCache.getTheObject();
            if (objectInCache == result)result.initializeOnInstantiation();
            return objectInCache;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

