package persistence;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.CallableStatement;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Vector;

public class ConnectionHandler {

	private static final String AutoCommitName = "AUTO COMMIT (DEFAULT)";
	
	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();
	
	private static ConnectionHandler theConnectionHandler;

	public static String openFile(File file) throws IOException {
		int size = (int) file.length();
		int chars_read = 0;
		FileReader in = new FileReader(file);
		char[] data = new char[size];
		while (in.ready()) {
			chars_read += in.read(data, chars_read, size - chars_read);
		}
		in.close();
		String raw = new String(data, 0, chars_read);
		return raw;
	}

	public static Vector<ConnectionHandler> getConnections(){
		Vector<ConnectionHandler> result = new Vector<ConnectionHandler>();
		Iterator<CommitConnectionHandler> committers = connections.values().iterator();
		while (committers.hasNext())result.add(committers.next());
		result.add(theConnectionHandler);
		return result;
	}
	public static void reinitialise() {
		connections = new Hashtable<Thread,CommitConnectionHandler>();
		theConnectionHandler = null;
	}
	
	public static void disconnect() throws PersistenceException{
		Iterator<CommitConnectionHandler> connectionIterator = connections.values().iterator();
		try {
			while (connectionIterator.hasNext()){
				ConnectionHandler current = (ConnectionHandler)connectionIterator.next();
				if(!current.con.isClosed())current.con.close();
			}
			if (theConnectionHandler != null && theConnectionHandler.con != null && !theConnectionHandler.con.isClosed()){
				theConnectionHandler.con.close();
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler(thread.getName());
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		try {
			CommitConnectionHandler connection = connections.get(Thread.currentThread());
			if (connection != null && !connection.con.isClosed()){
				connection.con.close();
				connections.remove(Thread.currentThread());
			}
		}catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}

	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler(AutoCommitName);
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}
	
	public static String asString (char[] pw) {
		String result = "";
		for (int i = 0; i < pw.length; i++) {
			result = result + pw[i];
		}
		return result;
	}

	public static final String DatabaseProtocol = "jdbc:oracle:thin:@";

	private String schemaName;
	protected Connection con;
	private String name;

    public PassedFacade thePassedFacade;
    public CreateProgramCommandFacade theCreateProgramCommandFacade;
    public ServerFacade theServerFacade;
    public ProgramSGroupFacade theProgramSGroupFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ModuleGroupSGroupFacade theModuleGroupSGroupFacade;
    public ModuleAtomarSGroupFacade theModuleAtomarSGroupFacade;
    public GradesInSimpleFacade theGradesInSimpleFacade;
    public ModuleAtomarFacade theModuleAtomarFacade;
    public StartStudyGroupCommandFacade theStartStudyGroupCommandFacade;
    public ModuleManagerFacade theModuleManagerFacade;
    public ModuleGroupFacade theModuleGroupFacade;
    public UnitFacade theUnitFacade;
    public ThirdGradeSystemFacade theThirdGradeSystemFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public StudyGroupFacade theStudyGroupFacade;
    public GradeSystemFacade theGradeSystemFacade;
    public AddStudentToGroupCommandFacade theAddStudentToGroupCommandFacade;
    public GradesInThirdFacade theGradesInThirdFacade;
    public AddModuleToGroupCommandFacade theAddModuleToGroupCommandFacade;
    public NoGradeThirdFacade theNoGradeThirdFacade;
    public AddModuleToProgCommandFacade theAddModuleToProgCommandFacade;
    public ProgramManagerFacade theProgramManagerFacade;
    public SimpleGradeSystemFacade theSimpleGradeSystemFacade;
    public NoGradeSimpleFacade theNoGradeSimpleFacade;
    public ProgramFacade theProgramFacade;
    public UnitSGroupFacade theUnitSGroupFacade;
    public CreateStudentCommandFacade theCreateStudentCommandFacade;
    public StudentManagerFacade theStudentManagerFacade;
    public StudentFacade theStudentFacade;
    public CreateModuleCommandFacade theCreateModuleCommandFacade;
    public T_2_3Facade theT_2_3Facade;
    public StudyGroupManagerFacade theStudyGroupManagerFacade;
    public T_2_0Facade theT_2_0Facade;
    public UnitStudentFacade theUnitStudentFacade;
    public CommonDateFacade theCommonDateFacade;
    public ModuleWithUnitsSGroupFacade theModuleWithUnitsSGroupFacade;
    public AddUnitCommandFacade theAddUnitCommandFacade;
    public ModuleAbstractFacade theModuleAbstractFacade;
    public ModuleAbstractSGroupFacade theModuleAbstractSGroupFacade;
    public ChangeCPOnModuleCommandFacade theChangeCPOnModuleCommandFacade;
    public SwapCPonModuleWithUnitsCommandFacade theSwapCPonModuleWithUnitsCommandFacade;
    public ModuleAtomarStudentFacade theModuleAtomarStudentFacade;
    public ModuleWithUnitsFacade theModuleWithUnitsFacade;
    public ProgramStudentFacade theProgramStudentFacade;
    public NotPassedFacade theNotPassedFacade;
    public ModuleWithUnitsStudentFacade theModuleWithUnitsStudentFacade;
    public ChangeGradeSystemCommandFacade theChangeGradeSystemCommandFacade;
    public ModuleGroupStudentFacade theModuleGroupStudentFacade;
    public ChangeCPOnUnitCommandFacade theChangeCPOnUnitCommandFacade;
    public T_1_3Facade theT_1_3Facade;
    public ModuleAbstractStudentFacade theModuleAbstractStudentFacade;
    public T_1_7Facade theT_1_7Facade;
    public T_1_0Facade theT_1_0Facade;
    public CommandExecuterFacade theCommandExecuterFacade;

	protected ConnectionHandler(String name) throws PersistenceException {
		this.name = name;
		try {
			DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public String getName(){
		return this.name;
	}
	
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
		try {
			this.schemaName = currentSchemaName;
			oracle.jdbc.driver.OracleConnection oracleConnection = (oracle.jdbc.driver.OracleConnection) DriverManager.getConnection(DatabaseProtocol + databaseName, user, asString(pw));
//			oracleConnection.setStatementCacheSize(1000);
//			oracleConnection.setImplicitCachingEnabled(true);
			this.con = new Connection(oracleConnection);
			this.con.setAutoCommit(autoCommit);
			CallableStatement callable = this.con.prepareCall("Begin " + this.schemaName + ".ClassFacade.initialize; end;");
			callable.execute();
			callable.close();
            this.thePassedFacade= new PassedFacade(this.schemaName, this.con);
            this.theCreateProgramCommandFacade= new CreateProgramCommandFacade(this.schemaName, this.con);
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theProgramSGroupFacade= new ProgramSGroupFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theModuleGroupSGroupFacade= new ModuleGroupSGroupFacade(this.schemaName, this.con);
            this.theModuleAtomarSGroupFacade= new ModuleAtomarSGroupFacade(this.schemaName, this.con);
            this.theGradesInSimpleFacade= new GradesInSimpleFacade(this.schemaName, this.con);
            this.theModuleAtomarFacade= new ModuleAtomarFacade(this.schemaName, this.con);
            this.theStartStudyGroupCommandFacade= new StartStudyGroupCommandFacade(this.schemaName, this.con);
            this.theModuleManagerFacade= new ModuleManagerFacade(this.schemaName, this.con);
            this.theModuleGroupFacade= new ModuleGroupFacade(this.schemaName, this.con);
            this.theUnitFacade= new UnitFacade(this.schemaName, this.con);
            this.theThirdGradeSystemFacade= new ThirdGradeSystemFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theStudyGroupFacade= new StudyGroupFacade(this.schemaName, this.con);
            this.theGradeSystemFacade= new GradeSystemFacade(this.schemaName, this.con);
            this.theAddStudentToGroupCommandFacade= new AddStudentToGroupCommandFacade(this.schemaName, this.con);
            this.theGradesInThirdFacade= new GradesInThirdFacade(this.schemaName, this.con);
            this.theAddModuleToGroupCommandFacade= new AddModuleToGroupCommandFacade(this.schemaName, this.con);
            this.theNoGradeThirdFacade= new NoGradeThirdFacade(this.schemaName, this.con);
            this.theAddModuleToProgCommandFacade= new AddModuleToProgCommandFacade(this.schemaName, this.con);
            this.theProgramManagerFacade= new ProgramManagerFacade(this.schemaName, this.con);
            this.theSimpleGradeSystemFacade= new SimpleGradeSystemFacade(this.schemaName, this.con);
            this.theNoGradeSimpleFacade= new NoGradeSimpleFacade(this.schemaName, this.con);
            this.theProgramFacade= new ProgramFacade(this.schemaName, this.con);
            this.theUnitSGroupFacade= new UnitSGroupFacade(this.schemaName, this.con);
            this.theCreateStudentCommandFacade= new CreateStudentCommandFacade(this.schemaName, this.con);
            this.theStudentManagerFacade= new StudentManagerFacade(this.schemaName, this.con);
            this.theStudentFacade= new StudentFacade(this.schemaName, this.con);
            this.theCreateModuleCommandFacade= new CreateModuleCommandFacade(this.schemaName, this.con);
            this.theT_2_3Facade= new T_2_3Facade(this.schemaName, this.con);
            this.theStudyGroupManagerFacade= new StudyGroupManagerFacade(this.schemaName, this.con);
            this.theT_2_0Facade= new T_2_0Facade(this.schemaName, this.con);
            this.theUnitStudentFacade= new UnitStudentFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theModuleWithUnitsSGroupFacade= new ModuleWithUnitsSGroupFacade(this.schemaName, this.con);
            this.theAddUnitCommandFacade= new AddUnitCommandFacade(this.schemaName, this.con);
            this.theModuleAbstractFacade= new ModuleAbstractFacade(this.schemaName, this.con);
            this.theModuleAbstractSGroupFacade= new ModuleAbstractSGroupFacade(this.schemaName, this.con);
            this.theChangeCPOnModuleCommandFacade= new ChangeCPOnModuleCommandFacade(this.schemaName, this.con);
            this.theSwapCPonModuleWithUnitsCommandFacade= new SwapCPonModuleWithUnitsCommandFacade(this.schemaName, this.con);
            this.theModuleAtomarStudentFacade= new ModuleAtomarStudentFacade(this.schemaName, this.con);
            this.theModuleWithUnitsFacade= new ModuleWithUnitsFacade(this.schemaName, this.con);
            this.theProgramStudentFacade= new ProgramStudentFacade(this.schemaName, this.con);
            this.theNotPassedFacade= new NotPassedFacade(this.schemaName, this.con);
            this.theModuleWithUnitsStudentFacade= new ModuleWithUnitsStudentFacade(this.schemaName, this.con);
            this.theChangeGradeSystemCommandFacade= new ChangeGradeSystemCommandFacade(this.schemaName, this.con);
            this.theModuleGroupStudentFacade= new ModuleGroupStudentFacade(this.schemaName, this.con);
            this.theChangeCPOnUnitCommandFacade= new ChangeCPOnUnitCommandFacade(this.schemaName, this.con);
            this.theT_1_3Facade= new T_1_3Facade(this.schemaName, this.con);
            this.theModuleAbstractStudentFacade= new ModuleAbstractStudentFacade(this.schemaName, this.con);
            this.theT_1_7Facade= new T_1_7Facade(this.schemaName, this.con);
            this.theT_1_0Facade= new T_1_0Facade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
		} catch (SQLException sqlExc) {
			throw new PersistenceException(sqlExc.getMessage(), sqlExc.getErrorCode());
		}
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		Connection con = this.getConnection();
		CallableStatement callable;
		try {
			callable = con.prepareCall("Begin " + this.schemaName + ".ClassFacade.deleteObject(?,?); end;");
            callable.setLong(1, object.getId());
            callable.setLong(2, object.getClassId());
			callable.execute();
			callable.close();
		} catch (SQLException se) {
	           throw new PersistenceException(se.getMessage(), se.getErrorCode());
	    }
	}

	
	public Connection getConnection(){
		return this.con;
	}
	
}
