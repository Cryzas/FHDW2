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

    public ServerFacade theServerFacade;
    public ProgramSGroupFacade theProgramSGroupFacade;
    public ModuleGroupSGroupFacade theModuleGroupSGroupFacade;
    public ModuleAtomarSGroupFacade theModuleAtomarSGroupFacade;
    public GradesInSimpleFacade theGradesInSimpleFacade;
    public ModuleAtomarFacade theModuleAtomarFacade;
    public T_3_7Facade theT_3_7Facade;
    public ThirdGradeSystemFacade theThirdGradeSystemFacade;
    public CommandCoordinatorFacade theCommandCoordinatorFacade;
    public StudyGroupFacade theStudyGroupFacade;
    public AddStudentToGroupCommandFacade theAddStudentToGroupCommandFacade;
    public GradesInThirdFacade theGradesInThirdFacade;
    public Z_1_0Facade theZ_1_0Facade;
    public Z_1_1Facade theZ_1_1Facade;
    public AddModuleToProgCommandFacade theAddModuleToProgCommandFacade;
    public Z_1_2Facade theZ_1_2Facade;
    public NoProgramFacade theNoProgramFacade;
    public Z_2_2Facade theZ_2_2Facade;
    public Z_2_3Facade theZ_2_3Facade;
    public Z_2_4Facade theZ_2_4Facade;
    public Z_2_5Facade theZ_2_5Facade;
    public Z_2_6Facade theZ_2_6Facade;
    public Z_2_7Facade theZ_2_7Facade;
    public Z_2_8Facade theZ_2_8Facade;
    public Z_2_9Facade theZ_2_9Facade;
    public CreateStudentCommandFacade theCreateStudentCommandFacade;
    public StudentManagerFacade theStudentManagerFacade;
    public StudentFacade theStudentFacade;
    public CreateModuleCommandFacade theCreateModuleCommandFacade;
    public T_2_3Facade theT_2_3Facade;
    public StudyGroupServiceGroupManagerFacade theStudyGroupServiceGroupManagerFacade;
    public T_2_0Facade theT_2_0Facade;
    public T_2_7Facade theT_2_7Facade;
    public UnitStudentFacade theUnitStudentFacade;
    public BTrueFacade theBTrueFacade;
    public AdminServiceServicesFacade theAdminServiceServicesFacade;
    public CommonDateFacade theCommonDateFacade;
    public ModuleWithUnitsSGroupFacade theModuleWithUnitsSGroupFacade;
    public StudyGroupServiceFacade theStudyGroupServiceFacade;
    public ModuleAbstractFacade theModuleAbstractFacade;
    public ChangeCPOnModuleCommandFacade theChangeCPOnModuleCommandFacade;
    public GradeChangeFacade theGradeChangeFacade;
    public ModuleAtomarStudentFacade theModuleAtomarStudentFacade;
    public ModuleWithUnitsFacade theModuleWithUnitsFacade;
    public ProgramStudentFacade theProgramStudentFacade;
    public Z_1_3Facade theZ_1_3Facade;
    public Z_5_0Facade theZ_5_0Facade;
    public Z_1_4Facade theZ_1_4Facade;
    public Z_1_5Facade theZ_1_5Facade;
    public ModuleWithUnitsStudentFacade theModuleWithUnitsStudentFacade;
    public Z_1_6Facade theZ_1_6Facade;
    public Z_1_7Facade theZ_1_7Facade;
    public Z_1_8Facade theZ_1_8Facade;
    public Z_1_9Facade theZ_1_9Facade;
    public ChangeGradeSystemCommandFacade theChangeGradeSystemCommandFacade;
    public ModuleGroupStudentFacade theModuleGroupStudentFacade;
    public ChangeCPOnUnitCommandFacade theChangeCPOnUnitCommandFacade;
    public SubjFacade theSubjFacade;
    public ChangeGradeCommandFacade theChangeGradeCommandFacade;
    public T_3_0Facade theT_3_0Facade;
    public ModuleAbstractStudentFacade theModuleAbstractStudentFacade;
    public T_3_3Facade theT_3_3Facade;
    public CommandExecuterFacade theCommandExecuterFacade;
    public PassedFacade thePassedFacade;
    public StudentManageServiceFacade theStudentManageServiceFacade;
    public CreateProgramCommandFacade theCreateProgramCommandFacade;
    public AdminServiceFacade theAdminServiceFacade;
    public ErrorDisplayFacade theErrorDisplayFacade;
    public ProgramModuleServiceProgramManagerFacade theProgramModuleServiceProgramManagerFacade;
    public StartStudyGroupCommandFacade theStartStudyGroupCommandFacade;
    public ModuleManagerFacade theModuleManagerFacade;
    public ModuleGroupFacade theModuleGroupFacade;
    public UnitFacade theUnitFacade;
    public GradeSystemFacade theGradeSystemFacade;
    public AddModuleToGroupCommandFacade theAddModuleToGroupCommandFacade;
    public ProgramManagerFacade theProgramManagerFacade;
    public Z_3_0Facade theZ_3_0Facade;
    public SimpleGradeSystemFacade theSimpleGradeSystemFacade;
    public Z_4_0Facade theZ_4_0Facade;
    public ProgramFacade theProgramFacade;
    public UnitSGroupFacade theUnitSGroupFacade;
    public StudentServiceFacade theStudentServiceFacade;
    public BFalseFacade theBFalseFacade;
    public GradeFacade theGradeFacade;
    public MyBooleanFacade theMyBooleanFacade;
    public T_4_0Facade theT_4_0Facade;
    public StudyGroupManagerFacade theStudyGroupManagerFacade;
    public UserManagerServiceFacade theUserManagerServiceFacade;
    public GradesInSimpleOrThirdFacade theGradesInSimpleOrThirdFacade;
    public ProgramModuleServiceFacade theProgramModuleServiceFacade;
    public AddUnitCommandFacade theAddUnitCommandFacade;
    public ModuleAbstractSGroupFacade theModuleAbstractSGroupFacade;
    public EndStudyGroupCommandFacade theEndStudyGroupCommandFacade;
    public SwapCPonModuleWithUnitsCommandFacade theSwapCPonModuleWithUnitsCommandFacade;
    public ProgramModuleServiceModuleManagerFacade theProgramModuleServiceModuleManagerFacade;
    public NoGradeFacade theNoGradeFacade;
    public NotPassedFacade theNotPassedFacade;
    public subAdminServiceFacade thesubAdminServiceFacade;
    public Z_2_0Facade theZ_2_0Facade;
    public Z_2_1Facade theZ_2_1Facade;
    public Z_3_1Facade theZ_3_1Facade;
    public Z_3_2Facade theZ_3_2Facade;
    public Z_3_3Facade theZ_3_3Facade;
    public Z_3_4Facade theZ_3_4Facade;
    public Z_3_5Facade theZ_3_5Facade;
    public Z_3_6Facade theZ_3_6Facade;
    public Z_3_7Facade theZ_3_7Facade;
    public Z_3_8Facade theZ_3_8Facade;
    public Z_3_9Facade theZ_3_9Facade;
    public ServiceFacade theServiceFacade;
    public StudentManageServiceStudentManagerFacade theStudentManageServiceStudentManagerFacade;
    public GradesInTenthFacade theGradesInTenthFacade;
    public T_5_0Facade theT_5_0Facade;
    public T_1_3Facade theT_1_3Facade;
    public T_1_7Facade theT_1_7Facade;
    public T_1_0Facade theT_1_0Facade;

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
            this.theServerFacade= new ServerFacade(this.schemaName, this.con);
            this.theProgramSGroupFacade= new ProgramSGroupFacade(this.schemaName, this.con);
            this.theModuleGroupSGroupFacade= new ModuleGroupSGroupFacade(this.schemaName, this.con);
            this.theModuleAtomarSGroupFacade= new ModuleAtomarSGroupFacade(this.schemaName, this.con);
            this.theGradesInSimpleFacade= new GradesInSimpleFacade(this.schemaName, this.con);
            this.theModuleAtomarFacade= new ModuleAtomarFacade(this.schemaName, this.con);
            this.theT_3_7Facade= new T_3_7Facade(this.schemaName, this.con);
            this.theThirdGradeSystemFacade= new ThirdGradeSystemFacade(this.schemaName, this.con);
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade(this.schemaName, this.con);
            this.theStudyGroupFacade= new StudyGroupFacade(this.schemaName, this.con);
            this.theAddStudentToGroupCommandFacade= new AddStudentToGroupCommandFacade(this.schemaName, this.con);
            this.theGradesInThirdFacade= new GradesInThirdFacade(this.schemaName, this.con);
            this.theZ_1_0Facade= new Z_1_0Facade(this.schemaName, this.con);
            this.theZ_1_1Facade= new Z_1_1Facade(this.schemaName, this.con);
            this.theAddModuleToProgCommandFacade= new AddModuleToProgCommandFacade(this.schemaName, this.con);
            this.theZ_1_2Facade= new Z_1_2Facade(this.schemaName, this.con);
            this.theNoProgramFacade= new NoProgramFacade(this.schemaName, this.con);
            this.theZ_2_2Facade= new Z_2_2Facade(this.schemaName, this.con);
            this.theZ_2_3Facade= new Z_2_3Facade(this.schemaName, this.con);
            this.theZ_2_4Facade= new Z_2_4Facade(this.schemaName, this.con);
            this.theZ_2_5Facade= new Z_2_5Facade(this.schemaName, this.con);
            this.theZ_2_6Facade= new Z_2_6Facade(this.schemaName, this.con);
            this.theZ_2_7Facade= new Z_2_7Facade(this.schemaName, this.con);
            this.theZ_2_8Facade= new Z_2_8Facade(this.schemaName, this.con);
            this.theZ_2_9Facade= new Z_2_9Facade(this.schemaName, this.con);
            this.theCreateStudentCommandFacade= new CreateStudentCommandFacade(this.schemaName, this.con);
            this.theStudentManagerFacade= new StudentManagerFacade(this.schemaName, this.con);
            this.theStudentFacade= new StudentFacade(this.schemaName, this.con);
            this.theCreateModuleCommandFacade= new CreateModuleCommandFacade(this.schemaName, this.con);
            this.theT_2_3Facade= new T_2_3Facade(this.schemaName, this.con);
            this.theStudyGroupServiceGroupManagerFacade= new StudyGroupServiceGroupManagerFacade(this.schemaName, this.con);
            this.theT_2_0Facade= new T_2_0Facade(this.schemaName, this.con);
            this.theT_2_7Facade= new T_2_7Facade(this.schemaName, this.con);
            this.theUnitStudentFacade= new UnitStudentFacade(this.schemaName, this.con);
            this.theBTrueFacade= new BTrueFacade(this.schemaName, this.con);
            this.theAdminServiceServicesFacade= new AdminServiceServicesFacade(this.schemaName, this.con);
            this.theCommonDateFacade= new CommonDateFacade(this.schemaName, this.con);
            this.theModuleWithUnitsSGroupFacade= new ModuleWithUnitsSGroupFacade(this.schemaName, this.con);
            this.theStudyGroupServiceFacade= new StudyGroupServiceFacade(this.schemaName, this.con);
            this.theModuleAbstractFacade= new ModuleAbstractFacade(this.schemaName, this.con);
            this.theChangeCPOnModuleCommandFacade= new ChangeCPOnModuleCommandFacade(this.schemaName, this.con);
            this.theGradeChangeFacade= new GradeChangeFacade(this.schemaName, this.con);
            this.theModuleAtomarStudentFacade= new ModuleAtomarStudentFacade(this.schemaName, this.con);
            this.theModuleWithUnitsFacade= new ModuleWithUnitsFacade(this.schemaName, this.con);
            this.theProgramStudentFacade= new ProgramStudentFacade(this.schemaName, this.con);
            this.theZ_1_3Facade= new Z_1_3Facade(this.schemaName, this.con);
            this.theZ_5_0Facade= new Z_5_0Facade(this.schemaName, this.con);
            this.theZ_1_4Facade= new Z_1_4Facade(this.schemaName, this.con);
            this.theZ_1_5Facade= new Z_1_5Facade(this.schemaName, this.con);
            this.theModuleWithUnitsStudentFacade= new ModuleWithUnitsStudentFacade(this.schemaName, this.con);
            this.theZ_1_6Facade= new Z_1_6Facade(this.schemaName, this.con);
            this.theZ_1_7Facade= new Z_1_7Facade(this.schemaName, this.con);
            this.theZ_1_8Facade= new Z_1_8Facade(this.schemaName, this.con);
            this.theZ_1_9Facade= new Z_1_9Facade(this.schemaName, this.con);
            this.theChangeGradeSystemCommandFacade= new ChangeGradeSystemCommandFacade(this.schemaName, this.con);
            this.theModuleGroupStudentFacade= new ModuleGroupStudentFacade(this.schemaName, this.con);
            this.theChangeCPOnUnitCommandFacade= new ChangeCPOnUnitCommandFacade(this.schemaName, this.con);
            this.theSubjFacade= new SubjFacade(this.schemaName, this.con);
            this.theChangeGradeCommandFacade= new ChangeGradeCommandFacade(this.schemaName, this.con);
            this.theT_3_0Facade= new T_3_0Facade(this.schemaName, this.con);
            this.theModuleAbstractStudentFacade= new ModuleAbstractStudentFacade(this.schemaName, this.con);
            this.theT_3_3Facade= new T_3_3Facade(this.schemaName, this.con);
            this.theCommandExecuterFacade= new CommandExecuterFacade(this.schemaName, this.con);
            this.thePassedFacade= new PassedFacade(this.schemaName, this.con);
            this.theStudentManageServiceFacade= new StudentManageServiceFacade(this.schemaName, this.con);
            this.theCreateProgramCommandFacade= new CreateProgramCommandFacade(this.schemaName, this.con);
            this.theAdminServiceFacade= new AdminServiceFacade(this.schemaName, this.con);
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theProgramModuleServiceProgramManagerFacade= new ProgramModuleServiceProgramManagerFacade(this.schemaName, this.con);
            this.theStartStudyGroupCommandFacade= new StartStudyGroupCommandFacade(this.schemaName, this.con);
            this.theModuleManagerFacade= new ModuleManagerFacade(this.schemaName, this.con);
            this.theModuleGroupFacade= new ModuleGroupFacade(this.schemaName, this.con);
            this.theUnitFacade= new UnitFacade(this.schemaName, this.con);
            this.theGradeSystemFacade= new GradeSystemFacade(this.schemaName, this.con);
            this.theAddModuleToGroupCommandFacade= new AddModuleToGroupCommandFacade(this.schemaName, this.con);
            this.theProgramManagerFacade= new ProgramManagerFacade(this.schemaName, this.con);
            this.theZ_3_0Facade= new Z_3_0Facade(this.schemaName, this.con);
            this.theSimpleGradeSystemFacade= new SimpleGradeSystemFacade(this.schemaName, this.con);
            this.theZ_4_0Facade= new Z_4_0Facade(this.schemaName, this.con);
            this.theProgramFacade= new ProgramFacade(this.schemaName, this.con);
            this.theUnitSGroupFacade= new UnitSGroupFacade(this.schemaName, this.con);
            this.theStudentServiceFacade= new StudentServiceFacade(this.schemaName, this.con);
            this.theBFalseFacade= new BFalseFacade(this.schemaName, this.con);
            this.theGradeFacade= new GradeFacade(this.schemaName, this.con);
            this.theMyBooleanFacade= new MyBooleanFacade(this.schemaName, this.con);
            this.theT_4_0Facade= new T_4_0Facade(this.schemaName, this.con);
            this.theStudyGroupManagerFacade= new StudyGroupManagerFacade(this.schemaName, this.con);
            this.theUserManagerServiceFacade= new UserManagerServiceFacade(this.schemaName, this.con);
            this.theGradesInSimpleOrThirdFacade= new GradesInSimpleOrThirdFacade(this.schemaName, this.con);
            this.theProgramModuleServiceFacade= new ProgramModuleServiceFacade(this.schemaName, this.con);
            this.theAddUnitCommandFacade= new AddUnitCommandFacade(this.schemaName, this.con);
            this.theModuleAbstractSGroupFacade= new ModuleAbstractSGroupFacade(this.schemaName, this.con);
            this.theEndStudyGroupCommandFacade= new EndStudyGroupCommandFacade(this.schemaName, this.con);
            this.theSwapCPonModuleWithUnitsCommandFacade= new SwapCPonModuleWithUnitsCommandFacade(this.schemaName, this.con);
            this.theProgramModuleServiceModuleManagerFacade= new ProgramModuleServiceModuleManagerFacade(this.schemaName, this.con);
            this.theNoGradeFacade= new NoGradeFacade(this.schemaName, this.con);
            this.theNotPassedFacade= new NotPassedFacade(this.schemaName, this.con);
            this.thesubAdminServiceFacade= new subAdminServiceFacade(this.schemaName, this.con);
            this.theZ_2_0Facade= new Z_2_0Facade(this.schemaName, this.con);
            this.theZ_2_1Facade= new Z_2_1Facade(this.schemaName, this.con);
            this.theZ_3_1Facade= new Z_3_1Facade(this.schemaName, this.con);
            this.theZ_3_2Facade= new Z_3_2Facade(this.schemaName, this.con);
            this.theZ_3_3Facade= new Z_3_3Facade(this.schemaName, this.con);
            this.theZ_3_4Facade= new Z_3_4Facade(this.schemaName, this.con);
            this.theZ_3_5Facade= new Z_3_5Facade(this.schemaName, this.con);
            this.theZ_3_6Facade= new Z_3_6Facade(this.schemaName, this.con);
            this.theZ_3_7Facade= new Z_3_7Facade(this.schemaName, this.con);
            this.theZ_3_8Facade= new Z_3_8Facade(this.schemaName, this.con);
            this.theZ_3_9Facade= new Z_3_9Facade(this.schemaName, this.con);
            this.theServiceFacade= new ServiceFacade(this.schemaName, this.con);
            this.theStudentManageServiceStudentManagerFacade= new StudentManageServiceStudentManagerFacade(this.schemaName, this.con);
            this.theGradesInTenthFacade= new GradesInTenthFacade(this.schemaName, this.con);
            this.theT_5_0Facade= new T_5_0Facade(this.schemaName, this.con);
            this.theT_1_3Facade= new T_1_3Facade(this.schemaName, this.con);
            this.theT_1_7Facade= new T_1_7Facade(this.schemaName, this.con);
            this.theT_1_0Facade= new T_1_0Facade(this.schemaName, this.con);
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
