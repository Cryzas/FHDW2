package viewClient;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;

import com.sun.org.apache.xerces.internal.parsers.*;

public class ClientNames {
	
	private static final String ClientNamesPath = new File(System.getProperty("user.dir")).getPath() + File.separator + "modelNames.xml";
	
	private static ClientNames theClientNames = null;

	public static ClientNames getTheClientNames(){
		if (theClientNames == null) {
			theClientNames = new ClientNames();
		}
		return theClientNames;
	}

	private static final CharSequence XMLae = "&#228;";
	private static final CharSequence XMLue = "&#252;";
	private static final CharSequence XMLoe = "&#246;";
	private static final CharSequence XMLAE = "&#196;";
	private static final CharSequence XMLUE = "&#220;";
	private static final CharSequence XMLOE = "&#214;";
	private static final CharSequence XMLSZ = "&#223;";

	public static String toXMLValue(String value){
		String result = value.replace("ä", XMLae);
		result = result.replace("ü", XMLue);
		result = result.replace("ö", XMLoe);
		result = result.replace("Ä", XMLAE);
		result = result.replace("Ü", XMLUE);
		result = result.replace("Ö", XMLOE);
		result = result.replace("ß", XMLSZ);
		return result;
	}
	public static String fromXMLValue(String value) {
		String result = value.replace(XMLae, "ä");
		result = result.replace(XMLue, "ü");
		result = result.replace(XMLoe, "ö");
		result = result.replace(XMLAE, "Ä");
		result = result.replace(XMLUE, "Ü");
		result = result.replace(XMLOE, "Ö");
		result = result.replace(XMLSZ, "ß");
		return result;
	}
	

	private static final String LongNameAttributeName = "longName";
//	private static final String ShortNameAttributeName = "shortName";
	private static final String ViewNameAttributeName = "viewName";
//	private static final String ServerAttributeName = "server";
	private static final String QualifiedOperationNameAttributeName = "operationName";


	private static final int ClassesPosition = 0;
		private static final int AttributesInClassPosition = 0;
		private static final int OperationsInClassPosition = 1;
	private static final int InterfacesPosition = 1;
		private static final int OperationsInInterfacePosition = 0;

	private static final String NoSuchTypeNameMessage = "Unknown type: ";
	private static final String NoSuchViewNameMessage = "Unknown view name for type: ";
	private static final String NoSuchAttributeNameMessage = "Unknown attribute: ";
	private static final String NoSuchOperationNameMessage = "Unknown operation: ";
	private static final String NoSuchParameterNameMessage = "Unknown parameter: ";

	
	private static final String InSeparator = " in ";

	public static final String AmbigousViewNameMessage = "Ambigous view name: ";
	public static final String AndInfix = " and ";
	public static final String ForInfix = " for ";


	private String LoadFailureIndicator = null;

	private String modelName;
	
	private Map<String, NamesInType> namesInTypes;
	private Map<String, String> namesForViewNames;
	
	class NamesInType {
		String typeViewName;
		Map<String,String> attributeNames;
		Map<String,NamesInOperation> operationNames;
		public NamesInType(String typeViewName, Map<String, String> attributeNames, Map<String, NamesInOperation> operationNames) {
			this.typeViewName = typeViewName;
			this.attributeNames = attributeNames;
			this.operationNames = operationNames;
		}
		public NamesInType(String typeViewName, Map<String, NamesInOperation> operationNames) {
			this.typeViewName =typeViewName;
			this.attributeNames = new HashMap<String, String>();
			this.operationNames = operationNames;
		}
		public String getAttributeName(String attributeName) throws NoSuchAttributeName {
			String result = this.attributeNames.get(attributeName);
			if (result == null) throw new NoSuchAttributeName();
			return result;
		}
		public NamesInOperation getOperationName(String qualifiedOperationName) throws NoSuchOperationName {
			NamesInOperation result = this.operationNames.get(qualifiedOperationName);
			if (result == null) throw new NoSuchOperationName();
			return result;
		}
	}
	class NamesInOperation {
		String operationViewName;
		Map<String,String> parameterNames;
		public NamesInOperation(String operationViewName, Map<String, String> parameterNames) {
			this.operationViewName = operationViewName;
			this.parameterNames =parameterNames;
		}
		public String getParameterName(String parameterName) throws NoSuchParameterName {
			String result = this.parameterNames.get(parameterName);
			if (result == null) throw new NoSuchParameterName();
			return result;
		}
	}
	@SuppressWarnings("serial")
	class NoSuchTypeName extends Exception {}
	@SuppressWarnings("serial")
	class NoSuchAttributeName extends Exception {}
	@SuppressWarnings("serial")
	class NoSuchOperationName extends Exception {}
	@SuppressWarnings("serial")
	class NoSuchParameterName extends Exception {}
	
	@SuppressWarnings("serial")
	class AmbigousViewNameException extends Exception {
		public AmbigousViewNameException(String viewName, String longName1, String longName2) {
			super(AmbigousViewNameMessage + viewName + ForInfix + longName1 + AndInfix + longName2);
		}
	}
	
	private ClientNames(){
		this.load();
	}
	public void load() {
		DOMParser parser = new DOMParser();
		try {
			parser.parse(ClientNamesPath);
			Document configurationDocument = parser.getDocument();
			Element root = configurationDocument.getDocumentElement();
			this.modelName = fromXMLValue(root.getAttribute(ViewNameAttributeName));
			Node classes = root.getChildNodes().item(ClassesPosition);
			this.loadClasses(classes);
			Node interfaces = root.getChildNodes().item(InterfacesPosition);
			this.loadInterfaces(interfaces);
		} catch (Exception e) {
			this.LoadFailureIndicator = e.getMessage();
		}

	}
	private void loadInterfaces(Node interfaces) throws AmbigousViewNameException {
		for (int interfaceIndex = 0; interfaceIndex < interfaces.getChildNodes().getLength(); interfaceIndex++) {
			this.loadInterface((Element) interfaces.getChildNodes().item(interfaceIndex));
		}
	}
	private void loadInterface(Element interfce) throws AmbigousViewNameException {
		final String viewName = fromXMLValue(interfce.getAttribute(ViewNameAttributeName));
		final String longName = fromXMLValue(interfce.getAttribute(LongNameAttributeName));
		Map<String,NamesInOperation> operationNames = this.loadOperationNames((Element) interfce.getChildNodes().item(OperationsInInterfacePosition));
		NamesInType namesInType = new NamesInType(fromXMLValue(viewName),operationNames);
		this.putNamesInType(longName, namesInType);
		this.putLongNameForView(viewName,longName);
	}
	private void putLongNameForView(String viewName, String longName) throws AmbigousViewNameException {
		if (this.namesForViewNames == null) this.namesForViewNames = new HashMap<String, String>();
		String oldEntry = namesForViewNames.put(viewName, longName);
		if (oldEntry != null) throw new AmbigousViewNameException(viewName, oldEntry, longName);
	}
	private void loadClasses(Node classes) throws AmbigousViewNameException {
		for (int classIndex = 0; classIndex < classes.getChildNodes().getLength(); classIndex++) {
			this.loadClass((Element) classes.getChildNodes().item(classIndex));
		}
	}
	private void loadClass(Element clss) throws AmbigousViewNameException {
		final String viewName = fromXMLValue(clss.getAttribute(ViewNameAttributeName));
		final String longName = fromXMLValue(clss.getAttribute(LongNameAttributeName));
		Map<String,String> attributeNames = this.loadAttributeNames((Element) clss.getChildNodes().item(AttributesInClassPosition));
		Map<String,NamesInOperation> operationNames = this.loadOperationNames((Element) clss.getChildNodes().item(OperationsInClassPosition));
		NamesInType namesInType = new NamesInType(viewName,attributeNames,operationNames);
		this.putNamesInType(longName, namesInType);
		this.putLongNameForView(viewName,longName);
	}
	private Map<String, NamesInOperation> loadOperationNames(Element operations) {
		Map<String, NamesInOperation> result = new HashMap<String, ClientNames.NamesInOperation>();
		for (int i = 0; i < operations.getChildNodes().getLength(); i++) {
			this.loadOperationNames(result,(Element) operations.getChildNodes().item(i));
		}
		return result;
	}
	private void loadOperationNames(Map<String, NamesInOperation> result, Element operation) {
		String viewName = fromXMLValue(operation.getAttribute(ViewNameAttributeName));
		Map<String,String> parameterNames = this.loadParameterNames(operation);
		NamesInOperation namesInOperation = new NamesInOperation(viewName,parameterNames);
		result.put(fromXMLValue(operation.getAttribute(QualifiedOperationNameAttributeName)), namesInOperation);
	}
	private Map<String, String> loadParameterNames(Element operation) {
		Map<String,String> result = new HashMap<String, String>();
		for (int i = 0; i < operation.getChildNodes().getLength(); i++) {
			Element currentParameter = (Element) operation.getChildNodes().item(i);
			result.put(fromXMLValue(currentParameter.getAttribute(LongNameAttributeName)), 
					   fromXMLValue(currentParameter.getAttribute(ViewNameAttributeName)));
		}
		return result;
	}
	private Map<String,String> loadAttributeNames(Element attributes) {
		Map<String,String> result = new HashMap<String, String>();
		for (int i = 0; i < attributes.getChildNodes().getLength(); i++) {
			result.put(fromXMLValue(((Element)attributes.getChildNodes().item(i)).getAttribute(LongNameAttributeName)), 
					   fromXMLValue(((Element)attributes.getChildNodes().item(i)).getAttribute(ViewNameAttributeName)));
		}
		return result;
	}
	private void putNamesInType(String longName, NamesInType typeNames) {
		if (this.namesInTypes == null) {
			namesInTypes = new HashMap<String, NamesInType>();
		}
		this.namesInTypes.put(longName, typeNames);
	}
	public String getModelName() {
		if (LoadFailureIndicator != null) return LoadFailureIndicator;
		return this.modelName;
	}
	public String getTypeName(String typeName) {
		if (LoadFailureIndicator != null) return LoadFailureIndicator;
		try {
			NamesInType type = this.getNamesInType(typeName);
			return type.typeViewName;
		} catch (NoSuchTypeName e) {
			return NoSuchTypeNameMessage + typeName;
		}
	}
	private NamesInType getNamesInType(String typeName) throws NoSuchTypeName {
		NamesInType result = this.namesInTypes.get(typeName);
		if (result == null) throw new NoSuchTypeName();
		return result;
	}
	public String getAttributeName(String typeName, String attributeName) {
		if (LoadFailureIndicator != null) return LoadFailureIndicator;
		try {
			NamesInType type = this.getNamesInType(typeName);
			String result = type.getAttributeName(attributeName);
			return result;
		} catch (NoSuchTypeName e) {
			return NoSuchTypeNameMessage + typeName;
		} catch (NoSuchAttributeName e) {
			return NoSuchAttributeNameMessage + attributeName + InSeparator + typeName;
		}
	}
	public String getOperationName(String typeName, String qualifiedOperationName) {
		if (LoadFailureIndicator != null) return LoadFailureIndicator;
		try {
			NamesInType type = this.getNamesInType(typeName);
			NamesInOperation result = type.getOperationName(qualifiedOperationName);
			return result.operationViewName;
		} catch (NoSuchTypeName e) {
			return NoSuchTypeNameMessage + typeName;
		} catch (NoSuchOperationName e) {
			return NoSuchOperationNameMessage + qualifiedOperationName + InSeparator + typeName;
		}
	}
	public String getParameterName(String typeName, String qualifiedOperationName, String parameterName) {
		if (LoadFailureIndicator != null) return LoadFailureIndicator;
		try {
			NamesInType type = this.getNamesInType(typeName);
			NamesInOperation operation = type.getOperationName(qualifiedOperationName);
			return operation.getParameterName(parameterName);
		} catch (NoSuchTypeName e) {
			return NoSuchTypeNameMessage + typeName;
		} catch (NoSuchOperationName e) {
			return NoSuchOperationNameMessage + qualifiedOperationName + InSeparator + typeName;
		} catch (NoSuchParameterName e) {
			return NoSuchParameterNameMessage + parameterName + InSeparator + qualifiedOperationName + InSeparator + typeName;
		}
	}
	public String getLongName(String viewName) {
		if (LoadFailureIndicator != null) return LoadFailureIndicator;
		String result = this.namesForViewNames.get(viewName);
		if (result == null) return NoSuchViewNameMessage + viewName;
		return result;
	}
}
