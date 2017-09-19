package persistence;

import java.util.Hashtable;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ConnectionHandler {

	private static Hashtable<Thread,CommitConnectionHandler> connections = new Hashtable<Thread,CommitConnectionHandler>();

	private static ConnectionHandler theConnectionHandler;

	public static void disconnect() throws PersistenceException {
	}
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

	public static CommitConnectionHandler getNewConnection(Thread thread) throws PersistenceException {
		CommitConnectionHandler result = new CommitConnectionHandler();
		connections.put(thread, result);
		return result;
	}

	public static void releaseConnection() throws PersistenceException {
		connections.remove(Thread.currentThread());
	}

	protected static ConnectionHandler getDefaultConnectionHandler() throws PersistenceException{
		if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
		return theConnectionHandler;
	}
	
	public static ConnectionHandler getTheConnectionHandler() throws PersistenceException {
		ConnectionHandler result;
		CommitConnectionHandler commitHandler = connections.get(Thread.currentThread());
		if (commitHandler == null){
			if (theConnectionHandler == null) theConnectionHandler = new ConnectionHandler();
			result = theConnectionHandler;
		}else{
			result = commitHandler;
		}
		return result;
	}

	public static boolean isCommitConnectionHandler() {
		CommitConnectionHandler handler = connections.get(Thread.currentThread());
		return handler != null && handler.isInTransaction();
	}



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

	protected ConnectionHandler() throws PersistenceException {
	}
	public void connect(String databaseName, String currentSchemaName, String user, char[] pw, boolean autoCommit) throws PersistenceException {
            this.theServerFacade= new ServerFacade();
            this.theProgramSGroupFacade= new ProgramSGroupFacade();
            this.theModuleGroupSGroupFacade= new ModuleGroupSGroupFacade();
            this.theModuleAtomarSGroupFacade= new ModuleAtomarSGroupFacade();
            this.theGradesInSimpleFacade= new GradesInSimpleFacade();
            this.theModuleAtomarFacade= new ModuleAtomarFacade();
            this.theT_3_7Facade= new T_3_7Facade();
            this.theThirdGradeSystemFacade= new ThirdGradeSystemFacade();
            this.theCommandCoordinatorFacade= new CommandCoordinatorFacade();
            this.theStudyGroupFacade= new StudyGroupFacade();
            this.theAddStudentToGroupCommandFacade= new AddStudentToGroupCommandFacade();
            this.theGradesInThirdFacade= new GradesInThirdFacade();
            this.theZ_1_0Facade= new Z_1_0Facade();
            this.theZ_1_1Facade= new Z_1_1Facade();
            this.theAddModuleToProgCommandFacade= new AddModuleToProgCommandFacade();
            this.theZ_1_2Facade= new Z_1_2Facade();
            this.theNoProgramFacade= new NoProgramFacade();
            this.theZ_2_2Facade= new Z_2_2Facade();
            this.theZ_2_3Facade= new Z_2_3Facade();
            this.theZ_2_4Facade= new Z_2_4Facade();
            this.theZ_2_5Facade= new Z_2_5Facade();
            this.theZ_2_6Facade= new Z_2_6Facade();
            this.theZ_2_7Facade= new Z_2_7Facade();
            this.theZ_2_8Facade= new Z_2_8Facade();
            this.theZ_2_9Facade= new Z_2_9Facade();
            this.theCreateStudentCommandFacade= new CreateStudentCommandFacade();
            this.theStudentManagerFacade= new StudentManagerFacade();
            this.theStudentFacade= new StudentFacade();
            this.theCreateModuleCommandFacade= new CreateModuleCommandFacade();
            this.theT_2_3Facade= new T_2_3Facade();
            this.theStudyGroupServiceGroupManagerFacade= new StudyGroupServiceGroupManagerFacade();
            this.theT_2_0Facade= new T_2_0Facade();
            this.theT_2_7Facade= new T_2_7Facade();
            this.theUnitStudentFacade= new UnitStudentFacade();
            this.theBTrueFacade= new BTrueFacade();
            this.theAdminServiceServicesFacade= new AdminServiceServicesFacade();
            this.theCommonDateFacade= new CommonDateFacade();
            this.theModuleWithUnitsSGroupFacade= new ModuleWithUnitsSGroupFacade();
            this.theStudyGroupServiceFacade= new StudyGroupServiceFacade();
            this.theModuleAbstractFacade= new ModuleAbstractFacade();
            this.theChangeCPOnModuleCommandFacade= new ChangeCPOnModuleCommandFacade();
            this.theGradeChangeFacade= new GradeChangeFacade();
            this.theModuleAtomarStudentFacade= new ModuleAtomarStudentFacade();
            this.theModuleWithUnitsFacade= new ModuleWithUnitsFacade();
            this.theProgramStudentFacade= new ProgramStudentFacade();
            this.theZ_1_3Facade= new Z_1_3Facade();
            this.theZ_5_0Facade= new Z_5_0Facade();
            this.theZ_1_4Facade= new Z_1_4Facade();
            this.theZ_1_5Facade= new Z_1_5Facade();
            this.theModuleWithUnitsStudentFacade= new ModuleWithUnitsStudentFacade();
            this.theZ_1_6Facade= new Z_1_6Facade();
            this.theZ_1_7Facade= new Z_1_7Facade();
            this.theZ_1_8Facade= new Z_1_8Facade();
            this.theZ_1_9Facade= new Z_1_9Facade();
            this.theChangeGradeSystemCommandFacade= new ChangeGradeSystemCommandFacade();
            this.theModuleGroupStudentFacade= new ModuleGroupStudentFacade();
            this.theChangeCPOnUnitCommandFacade= new ChangeCPOnUnitCommandFacade();
            this.theSubjFacade= new SubjFacade();
            this.theChangeGradeCommandFacade= new ChangeGradeCommandFacade();
            this.theT_3_0Facade= new T_3_0Facade();
            this.theModuleAbstractStudentFacade= new ModuleAbstractStudentFacade();
            this.theT_3_3Facade= new T_3_3Facade();
            this.theCommandExecuterFacade= new CommandExecuterFacade();
            this.thePassedFacade= new PassedFacade();
            this.theStudentManageServiceFacade= new StudentManageServiceFacade();
            this.theCreateProgramCommandFacade= new CreateProgramCommandFacade();
            this.theAdminServiceFacade= new AdminServiceFacade();
            this.theErrorDisplayFacade= new ErrorDisplayFacade();
            this.theProgramModuleServiceProgramManagerFacade= new ProgramModuleServiceProgramManagerFacade();
            this.theStartStudyGroupCommandFacade= new StartStudyGroupCommandFacade();
            this.theModuleManagerFacade= new ModuleManagerFacade();
            this.theModuleGroupFacade= new ModuleGroupFacade();
            this.theUnitFacade= new UnitFacade();
            this.theGradeSystemFacade= new GradeSystemFacade();
            this.theAddModuleToGroupCommandFacade= new AddModuleToGroupCommandFacade();
            this.theProgramManagerFacade= new ProgramManagerFacade();
            this.theZ_3_0Facade= new Z_3_0Facade();
            this.theSimpleGradeSystemFacade= new SimpleGradeSystemFacade();
            this.theZ_4_0Facade= new Z_4_0Facade();
            this.theProgramFacade= new ProgramFacade();
            this.theUnitSGroupFacade= new UnitSGroupFacade();
            this.theStudentServiceFacade= new StudentServiceFacade();
            this.theBFalseFacade= new BFalseFacade();
            this.theGradeFacade= new GradeFacade();
            this.theMyBooleanFacade= new MyBooleanFacade();
            this.theT_4_0Facade= new T_4_0Facade();
            this.theStudyGroupManagerFacade= new StudyGroupManagerFacade();
            this.theUserManagerServiceFacade= new UserManagerServiceFacade();
            this.theGradesInSimpleOrThirdFacade= new GradesInSimpleOrThirdFacade();
            this.theProgramModuleServiceFacade= new ProgramModuleServiceFacade();
            this.theAddUnitCommandFacade= new AddUnitCommandFacade();
            this.theModuleAbstractSGroupFacade= new ModuleAbstractSGroupFacade();
            this.theEndStudyGroupCommandFacade= new EndStudyGroupCommandFacade();
            this.theSwapCPonModuleWithUnitsCommandFacade= new SwapCPonModuleWithUnitsCommandFacade();
            this.theProgramModuleServiceModuleManagerFacade= new ProgramModuleServiceModuleManagerFacade();
            this.theNoGradeFacade= new NoGradeFacade();
            this.theNotPassedFacade= new NotPassedFacade();
            this.thesubAdminServiceFacade= new subAdminServiceFacade();
            this.theZ_2_0Facade= new Z_2_0Facade();
            this.theZ_2_1Facade= new Z_2_1Facade();
            this.theZ_3_1Facade= new Z_3_1Facade();
            this.theZ_3_2Facade= new Z_3_2Facade();
            this.theZ_3_3Facade= new Z_3_3Facade();
            this.theZ_3_4Facade= new Z_3_4Facade();
            this.theZ_3_5Facade= new Z_3_5Facade();
            this.theZ_3_6Facade= new Z_3_6Facade();
            this.theZ_3_7Facade= new Z_3_7Facade();
            this.theZ_3_8Facade= new Z_3_8Facade();
            this.theZ_3_9Facade= new Z_3_9Facade();
            this.theServiceFacade= new ServiceFacade();
            this.theStudentManageServiceStudentManagerFacade= new StudentManageServiceStudentManagerFacade();
            this.theGradesInTenthFacade= new GradesInTenthFacade();
            this.theT_5_0Facade= new T_5_0Facade();
            this.theT_1_3Facade= new T_1_3Facade();
            this.theT_1_7Facade= new T_1_7Facade();
            this.theT_1_0Facade= new T_1_0Facade();
	}
	public static void initializeMapsForMappedFields() throws PersistenceException {
		
	}
	public void dltObjct(PersistentRoot object) throws PersistenceException{
		object.setDltd();
	}

}

