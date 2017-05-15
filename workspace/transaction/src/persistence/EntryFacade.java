package persistence;



import java.sql.*;
//import oracle.jdbc.*;

public class EntryFacade{

	private String schemaName;
	private Connection con;

	public EntryFacade(String schemaName, Connection con) {
		this.schemaName = schemaName;
		this.con = con;
	}

    public long getClass(long objectId) throws PersistenceException{
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin ? := " + this.schemaName + ".EntrFacade.getClass(?); end;");
            callable.registerOutParameter(1, oracle.jdbc.OracleTypes.NUMBER);
            callable.setLong(2, objectId);
            callable.execute();
            long result = callable.getLong(1);
            callable.close();
            return result;
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void transferSet(long EntryId, Transfer4Public transferVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EntrFacade.trnsfrSet(?, ?, ?); end;");
            callable.setLong(1, EntryId);
            callable.setLong(2, transferVal.getId());
            callable.setLong(3, transferVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void subServiceSet(long EntryId, SubjInterface subServiceVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EntrFacade.sbSrvcSet(?, ?, ?); end;");
            callable.setLong(1, EntryId);
            callable.setLong(2, subServiceVal.getId());
            callable.setLong(3, subServiceVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }
    public void ThisSet(long EntryId, Entry4Public ThisVal) throws PersistenceException {
        try{
            CallableStatement callable;
            callable = this.con.prepareCall("Begin " + this.schemaName + ".EntrFacade.ThisSet(?, ?, ?); end;");
            callable.setLong(1, EntryId);
            callable.setLong(2, ThisVal.getId());
            callable.setLong(3, ThisVal.getClassId());
            callable.execute();
            callable.close();
        }catch(SQLException se) {
            throw new PersistenceException(se.getMessage(), se.getErrorCode());
        }
    }

}

