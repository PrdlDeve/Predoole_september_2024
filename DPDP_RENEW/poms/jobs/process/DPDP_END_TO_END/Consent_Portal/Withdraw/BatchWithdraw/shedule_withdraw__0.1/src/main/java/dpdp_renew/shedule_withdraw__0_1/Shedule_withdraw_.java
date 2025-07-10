
package dpdp_renew.shedule_withdraw__0_1;

import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.DataQuality;
import routines.Relational;
import routines.Mathematical;
import routines.DataQualityDependencies;
import routines.SQLike;
import routines.Numeric;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.DQTechnical;
import routines.TalendDate;
import routines.DataMasking;
import routines.DqStringHandling;
import routines.system.*;
import routines.system.api.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.math.BigDecimal;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
import java.util.Comparator;

@SuppressWarnings("unused")

/**
 * Job: Shedule_withdraw_ Purpose: <br>
 * Description: <br>
 * 
 * @author Patil, Chirag
 * @version 8.0.1.20250521_1150-patch
 * @status
 */
public class Shedule_withdraw_ implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Shedule_withdraw_.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(Shedule_withdraw_.class);

	static {
		String javaUtilLoggingConfigFile = System.getProperty("java.util.logging.config.file");
		if (javaUtilLoggingConfigFile == null) {
			setupDefaultJavaUtilLogging();
		}
	}

	/**
	 * This class replaces the default {@code System.err} stream used by Java Util
	 * Logging (JUL). You can use your own configuration through the
	 * {@code java.util.logging.config.file} system property, enabling you to
	 * specify an external logging configuration file for tailored logging setup.
	 */
	public static class StandardConsoleHandler extends java.util.logging.StreamHandler {
		public StandardConsoleHandler() {
			// Set System.out as default log output stream
			super(System.out, new java.util.logging.SimpleFormatter());
		}

		/**
		 * Publish a {@code LogRecord}. The logging request was made initially to a
		 * {@code Logger} object, which initialized the {@code LogRecord} and forwarded
		 * it here.
		 *
		 * @param record description of the log event. A null record is silently ignored
		 *               and is not published
		 */
		@Override
		public void publish(java.util.logging.LogRecord record) {
			super.publish(record);
			flush();
		}

		/**
		 * Override {@code StreamHandler.close} to do a flush but not to close the
		 * output stream. That is, we do <b>not</b> close {@code System.out}.
		 */
		@Override
		public void close() {
			flush();
		}
	}

	protected static void setupDefaultJavaUtilLogging() {
		java.util.logging.LogManager logManager = java.util.logging.LogManager.getLogManager();

		// Get the root logger
		java.util.logging.Logger rootLogger = logManager.getLogger("");

		// Remove existing handlers to set standard console handler only
		java.util.logging.Handler[] handlers = rootLogger.getHandlers();
		for (java.util.logging.Handler handler : handlers) {
			rootLogger.removeHandler(handler);
		}

		rootLogger.addHandler(new StandardConsoleHandler());
		rootLogger.setLevel(java.util.logging.Level.INFO);
	}

	protected static boolean isCBPClientPresent() {
		boolean isCBPClientPresent = false;
		try {
			Class.forName("org.talend.metrics.CBPClient");
			isCBPClientPresent = true;
		} catch (java.lang.ClassNotFoundException e) {
		}
		return isCBPClientPresent;
	}

	protected static void logIgnoredError(String message, Throwable cause) {
		log.error(message, cause);

	}

	public final Object obj = new Object();

	// for transmiting parameters purpose
	private Object valueObject = null;

	public Object getValueObject() {
		return this.valueObject;
	}

	public void setValueObject(Object valueObject) {
		this.valueObject = valueObject;
	}

	private final static String defaultCharset = java.nio.charset.Charset.defaultCharset().name();

	private final static String utf8Charset = "UTF-8";

	public static String taskExecutionId = null;

	public static String jobExecutionId = java.util.UUID.randomUUID().toString();;

	private final static boolean isCBPClientPresent = isCBPClientPresent();

	// contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String, String> propertyTypes = new java.util.HashMap<>();

		public PropertiesWithType(java.util.Properties properties) {
			super(properties);
		}

		public PropertiesWithType() {
			super();
		}

		public void setContextType(String key, String type) {
			propertyTypes.put(key, type);
		}

		public String getContextType(String key) {
			return propertyTypes.get(key);
		}
	}

	// create and load default properties
	private java.util.Properties defaultProps = new java.util.Properties();

	// create application properties with default
	public class ContextProperties extends PropertiesWithType {

		private static final long serialVersionUID = 1L;

		public ContextProperties(java.util.Properties properties) {
			super(properties);
		}

		public ContextProperties() {
			super();
		}

		public void synchronizeContext() {

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

	}

	protected ContextProperties context = new ContextProperties(); // will be instanciated by MS.

	public ContextProperties getContext() {
		return this.context;
	}

	protected java.util.Map<String, String> defaultProperties = new java.util.HashMap<String, String>();
	protected java.util.Map<String, String> additionalProperties = new java.util.HashMap<String, String>();

	public java.util.Map<String, String> getDefaultProperties() {
		return this.defaultProperties;
	}

	public java.util.Map<String, String> getAdditionalProperties() {
		return this.additionalProperties;
	}

	private final String jobVersion = "0.1";
	private final String jobName = "Shedule_withdraw_";
	private final String projectName = "DPDP_RENEW";
	public Integer errorCode = null;
	private String currentComponent = "";
	public static boolean isStandaloneMS = Boolean.valueOf("false");

	private void s(final String component) {
		try {
			org.talend.metrics.DataReadTracker.setCurrentComponent(jobName, component);
		} catch (Exception | NoClassDefFoundError e) {
			// ignore
		}
	}

	private void mdc(final String subJobName, final String subJobPidPrefix) {
		mdcInfo.forEach(org.slf4j.MDC::put);
		org.slf4j.MDC.put("_subJobName", subJobName);
		org.slf4j.MDC.put("_subJobPid", subJobPidPrefix + subJobPidCounter.getAndIncrement());
	}

	private void sh(final String componentId) {
		ok_Hash.put(componentId, false);
		start_Hash.put(componentId, System.currentTimeMillis());
	}

	{
		s("none");
	}

	private String cLabel = null;

	private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
	private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();

	private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
	private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
	public final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();

	private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName,
			"_1Wz1EFf_EfC5dpgX8ITjCQ", "0.1");
	private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

	private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";

	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(),
					new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	public void setDataSourceReferences(List serviceReferences) throws Exception {

		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();

		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils
				.getServices(serviceReferences, javax.sql.DataSource.class).entrySet()) {
			dataSources.put(entry.getKey(), entry.getValue());
			talendDataSources.put(entry.getKey(), new routines.system.TalendDataSource(entry.getValue()));
		}

		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}

	private final java.io.ByteArrayOutputStream baos = new java.io.ByteArrayOutputStream();
	private final java.io.PrintStream errorMessagePS = new java.io.PrintStream(new java.io.BufferedOutputStream(baos));

	public String getExceptionStackTrace() {
		if ("failure".equals(this.getStatus())) {
			errorMessagePS.flush();
			return baos.toString();
		}
		return null;
	}

	private Exception exception;

	public Exception getException() {
		if ("failure".equals(this.getStatus())) {
			return this.exception;
		}
		return null;
	}

	private class TalendException extends Exception {

		private static final long serialVersionUID = 1L;

		private java.util.Map<String, Object> globalMap = null;
		private Exception e = null;

		private String currentComponent = null;
		private String cLabel = null;

		private String virtualComponentName = null;

		public void setVirtualComponentName(String virtualComponentName) {
			this.virtualComponentName = virtualComponentName;
		}

		private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
			this.currentComponent = errorComponent;
			this.globalMap = globalMap;
			this.e = e;
		}

		private TalendException(Exception e, String errorComponent, String errorComponentLabel,
				final java.util.Map<String, Object> globalMap) {
			this(e, errorComponent, globalMap);
			this.cLabel = errorComponentLabel;
		}

		public Exception getException() {
			return this.e;
		}

		public String getCurrentComponent() {
			return this.currentComponent;
		}

		public String getExceptionCauseMessage(Exception e) {
			Throwable cause = e;
			String message = null;
			int i = 10;
			while (null != cause && 0 < i--) {
				message = cause.getMessage();
				if (null == message) {
					cause = cause.getCause();
				} else {
					break;
				}
			}
			if (null == message) {
				message = e.getClass().getName();
			}
			return message;
		}

		@Override
		public void printStackTrace() {
			if (!(e instanceof TalendException || e instanceof TDieException)) {
				if (virtualComponentName != null && currentComponent.indexOf(virtualComponentName + "_") == 0) {
					globalMap.put(virtualComponentName + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				}
				globalMap.put(currentComponent + "_ERROR_MESSAGE", getExceptionCauseMessage(e));
				System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
			}
			if (!(e instanceof TDieException)) {
				if (e instanceof TalendException) {
					e.printStackTrace();
				} else {
					e.printStackTrace();
					e.printStackTrace(errorMessagePS);
				}
			}
			if (!(e instanceof TalendException)) {
				Shedule_withdraw_.this.exception = e;
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Shedule_withdraw_.this, new Object[] { e, currentComponent, globalMap });
							break;
						}
					}

					if (!(e instanceof TDieException)) {
						if (enableLogStash) {
							talendJobLog.addJobExceptionMessage(currentComponent, cLabel, null, e);
							talendJobLogProcess(globalMap);
						}
					}
				} catch (Exception e) {
					this.e.printStackTrace();
				}
			}
		}
	}

	public void tRowGenerator_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDataStewardshipTaskDelete_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRowGenerator_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRowGenerator_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Shedule_withdraw_ = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Shedule_withdraw_ = new byte[0];

		public String newColumn;

		public String getNewColumn() {
			return this.newColumn;
		}

		public Boolean newColumnIsNullable() {
			return true;
		}

		public Boolean newColumnIsKey() {
			return false;
		}

		public Integer newColumnLength() {
			return null;
		}

		public Integer newColumnPrecision() {
			return null;
		}

		public String newColumnDefault() {

			return "";

		}

		public String newColumnComment() {

			return "";

		}

		public String newColumnPattern() {

			return "";

		}

		public String newColumnOriginalDbColumnName() {

			return "newColumn";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Shedule_withdraw_.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Shedule_withdraw_.length == 0) {
						commonByteArray_DPDP_RENEW_Shedule_withdraw_ = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Shedule_withdraw_ = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Shedule_withdraw_, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Shedule_withdraw_, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			String strReturn = null;
			int length = 0;
			length = unmarshaller.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Shedule_withdraw_.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Shedule_withdraw_.length == 0) {
						commonByteArray_DPDP_RENEW_Shedule_withdraw_ = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Shedule_withdraw_ = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Shedule_withdraw_, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Shedule_withdraw_, 0, length, utf8Charset);
			}
			return strReturn;
		}

		private void writeString(String str, ObjectOutputStream dos) throws IOException {
			if (str == null) {
				dos.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				dos.writeInt(byteArray.length);
				dos.write(byteArray);
			}
		}

		private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (str == null) {
				marshaller.writeInt(-1);
			} else {
				byte[] byteArray = str.getBytes(utf8Charset);
				marshaller.writeInt(byteArray.length);
				marshaller.write(byteArray);
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Shedule_withdraw_) {

				try {

					int length = 0;

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Shedule_withdraw_) {

				try {

					int length = 0;

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.newColumn, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.newColumn, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("newColumn=" + newColumn);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (newColumn == null) {
				sb.append("<null>");
			} else {
				sb.append(newColumn);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row1Struct other) {

			int returnValue = -1;

			return returnValue;
		}

		private int checkNullsAndCompare(Object object1, Object object2) {
			int returnValue = 0;
			if (object1 instanceof Comparable && object2 instanceof Comparable) {
				returnValue = ((Comparable) object1).compareTo(object2);
			} else if (object1 != null && object2 != null) {
				returnValue = compareStrings(object1.toString(), object2.toString());
			} else if (object1 == null && object2 != null) {
				returnValue = 1;
			} else if (object1 != null && object2 == null) {
				returnValue = -1;
			} else {
				returnValue = 0;
			}

			return returnValue;
		}

		private int compareStrings(String string1, String string2) {
			return string1.compareTo(string2);
		}

	}

	public void tRowGenerator_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tRowGenerator_1", "qV6qkP_");

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				row1Struct row1 = new row1Struct();

				/**
				 * [tDataStewardshipTaskDelete_5 begin ] start
				 */

				sh("tDataStewardshipTaskDelete_5");

				s(currentComponent = "tDataStewardshipTaskDelete_5");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tDataStewardshipTaskDelete_5 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tDataStewardshipTaskDelete_5", "tDataStewardshipTaskDelete_5",
							"tDataStewardshipTaskDelete");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				boolean doesNodeBelongToRequest_tDataStewardshipTaskDelete_5 = 0 == 0;
				@SuppressWarnings("unchecked")
				java.util.Map<String, Object> restRequest_tDataStewardshipTaskDelete_5 = (java.util.Map<String, Object>) globalMap
						.get("restRequest");
				String currentTRestRequestOperation_tDataStewardshipTaskDelete_5 = (String) (restRequest_tDataStewardshipTaskDelete_5 != null
						? restRequest_tDataStewardshipTaskDelete_5.get("OPERATION")
						: null);

				org.talend.components.api.component.ComponentDefinition def_tDataStewardshipTaskDelete_5 = new org.talend.components.datastewardship.tdatastewardshiptaskdelete.TDataStewardshipTaskDeleteDefinition();

				org.talend.components.api.component.runtime.Writer writer_tDataStewardshipTaskDelete_5 = null;
				org.talend.components.api.component.runtime.Reader reader_tDataStewardshipTaskDelete_5 = null;

				org.talend.components.datastewardship.tdatastewardshiptaskdelete.TDataStewardshipTaskDeleteProperties props_tDataStewardshipTaskDelete_5 = (org.talend.components.datastewardship.tdatastewardshiptaskdelete.TDataStewardshipTaskDeleteProperties) def_tDataStewardshipTaskDelete_5
						.createRuntimeProperties();
				props_tDataStewardshipTaskDelete_5.setValue("deleteById", false);

				props_tDataStewardshipTaskDelete_5.setValue("searchQuery", "");

				props_tDataStewardshipTaskDelete_5.setValue("campaignName", "c9d5dbce7d87cede9e0224bb3a48ca1d7");

				props_tDataStewardshipTaskDelete_5.setValue("campaignLabel", "Withdraw");

				props_tDataStewardshipTaskDelete_5.setValue("campaignType",
						org.talend.components.datastewardship.common.CampaignType.ARBITRATION);

				props_tDataStewardshipTaskDelete_5.setValue("laxSchema", false);

				props_tDataStewardshipTaskDelete_5.setValue("taskPriority", "ANY_PRIORITY");

				props_tDataStewardshipTaskDelete_5.setValue("taskTags", "");

				props_tDataStewardshipTaskDelete_5.setValue("taskState", "Resolved");

				props_tDataStewardshipTaskDelete_5.setValue("taskAssignee", "Any Assignee");

				props_tDataStewardshipTaskDelete_5.setValue("arbitrationChoice", "ANY_CHOICE");

				class SchemaSettingTool_tDataStewardshipTaskDelete_5_1_fisrt {

					String getSchemaValue() {

						StringBuilder s = new StringBuilder();

						a("{\"type\":\"record\",", s);

						a("\"name\":\"tRowGenerator_1\",\"fields\":[{", s);

						a("\"name\":\"newColumn\",\"type\":[\"string\",\"null\"],\"default\":\"\",\"di.table.comment\":\"\",\"di.prop.FUNCTION_INFO\":\"{\\\"NAME\\\":\\\"getAsciiRandomString\\\",\\\"PARAMETERS\\\":[{\\\"PARAMETER_NAME\\\":\\\"length\\\",\\\"PARAMETER_VALUE\\\":\\\"6 \\\"}],\\\"PARAMETER_CLASS_NAME\\\":\\\"TalendString\\\"}\",\"talend.field.dbType\":\"\",\"talend.field.default\":\"\",\"talend.field.dbColumnName\":\"newColumn\",\"di.column.talendType\":\"id_String\",\"di.column.isNullable\":\"true\",\"talend.field.pattern\":\"\",\"di.column.relationshipType\":\"\",\"di.table.label\":\"newColumn\",\"di.column.relatedEntity\":\"\"}],\"di.table.name\":\"tRowGenerator_1\",\"di.table.label\":\"tRowGenerator_1\"}",
								s);

						return s.toString();

					}

					void a(String part, StringBuilder strB) {
						strB.append(part);
					}

				}

				SchemaSettingTool_tDataStewardshipTaskDelete_5_1_fisrt sst_tDataStewardshipTaskDelete_5_1_fisrt = new SchemaSettingTool_tDataStewardshipTaskDelete_5_1_fisrt();

				props_tDataStewardshipTaskDelete_5.inputSchema.setValue("schema", new org.apache.avro.Schema.Parser()
						.setValidateDefaults(false).parse(sst_tDataStewardshipTaskDelete_5_1_fisrt.getSchemaValue()));

				java.util.List<Object> tDataStewardshipTaskDelete_5_httpConfig_keys = new java.util.ArrayList<Object>();

				((org.talend.daikon.properties.Properties) props_tDataStewardshipTaskDelete_5.httpConfig)
						.setValue("keys", tDataStewardshipTaskDelete_5_httpConfig_keys);

				java.util.List<Object> tDataStewardshipTaskDelete_5_httpConfig_values = new java.util.ArrayList<Object>();

				((org.talend.daikon.properties.Properties) props_tDataStewardshipTaskDelete_5.httpConfig)
						.setValue("values", tDataStewardshipTaskDelete_5_httpConfig_values);

				class SchemaSettingTool_tDataStewardshipTaskDelete_5_2_fisrt {

					String getSchemaValue() {

						StringBuilder s = new StringBuilder();

						a("{\"type\":\"record\",", s);

						a("\"name\":\"main\",\"fields\":[{", s);

						a("\"name\":\"Customer_Id\",\"type\":\"int\",\"di.table.comment\":\"integer\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Customer_Id\"},{",
								s);

						a("\"name\":\"Reason\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Reason\"},{",
								s);

						a("\"name\":\"TDS_ID\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_ID\"},{",
								s);

						a("\"name\":\"TDS_STATE\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_STATE\"},{",
								s);

						a("\"name\":\"TDS_ASSIGNEE\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_ASSIGNEE\"},{",
								s);

						a("\"name\":\"TDS_CREATION\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_CREATION\"},{",
								s);

						a("\"name\":\"TDS_LAST_UPDATE\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_LAST_UPDATE\"},{",
								s);

						a("\"name\":\"TDS_LAST_UPDATED_BY\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_LAST_UPDATED_BY\"},{",
								s);

						a("\"name\":\"TDS_PRIORITY\",\"type\":\"int\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_PRIORITY\"},{",
								s);

						a("\"name\":\"TDS_TAGS\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_TAGS\"},{",
								s);

						a("\"name\":\"TDS_ARBITRATION\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_ARBITRATION\"},{",
								s);

						a("\"name\":\"TDS_ARBITRATION_LABEL\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_ARBITRATION_LABEL\"},{",
								s);

						a("\"name\":\"TDS_DUE_DATE\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_DUE_DATE\"},{",
								s);

						a("\"name\":\"TDS_EXTERNAL_ID\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_EXTERNAL_ID\"}]}",
								s);

						return s.toString();

					}

					void a(String part, StringBuilder strB) {
						strB.append(part);
					}

				}

				SchemaSettingTool_tDataStewardshipTaskDelete_5_2_fisrt sst_tDataStewardshipTaskDelete_5_2_fisrt = new SchemaSettingTool_tDataStewardshipTaskDelete_5_2_fisrt();

				props_tDataStewardshipTaskDelete_5.schema.setValue("schema", new org.apache.avro.Schema.Parser()
						.setValidateDefaults(false).parse(sst_tDataStewardshipTaskDelete_5_2_fisrt.getSchemaValue()));

				props_tDataStewardshipTaskDelete_5.connection.setValue("url",
						"https://tds.ap.cloud.talend.com/data-stewardship");

				props_tDataStewardshipTaskDelete_5.connection.setValue("username", "pranita.p@predoole.com");

				props_tDataStewardshipTaskDelete_5.connection.setValue("password",
						routines.system.PasswordEncryptUtil.decryptPassword(
								"enc:routine.encryption.key.v1:1G9wMrEMRbI9W9/ZioxPGMjYQNH3Sy5EgvCnXVt7m5yosg+KoZjxiQ3VOll6G+8k4AxVXb94gYAt3fncS74ijFftBtgRMN5ho8wX/nh4WG8VU7HpHlVEabSk58A="));

				props_tDataStewardshipTaskDelete_5.connection.refConnection.setValue("referenceDefinitionName",
						"datastewardship");

				if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_tDataStewardshipTaskDelete_5.connection.refConnection.referenceType
						.getValue()) {
					final String referencedComponentInstanceId_tDataStewardshipTaskDelete_5 = props_tDataStewardshipTaskDelete_5.connection.refConnection.componentInstanceId
							.getStringValue();
					if (referencedComponentInstanceId_tDataStewardshipTaskDelete_5 != null) {
						org.talend.daikon.properties.Properties referencedComponentProperties_tDataStewardshipTaskDelete_5 = (org.talend.daikon.properties.Properties) globalMap
								.get(referencedComponentInstanceId_tDataStewardshipTaskDelete_5
										+ "_COMPONENT_RUNTIME_PROPERTIES");
						props_tDataStewardshipTaskDelete_5.connection.refConnection
								.setReference(referencedComponentProperties_tDataStewardshipTaskDelete_5);
					}
				}
				globalMap.put("tDataStewardshipTaskDelete_5_COMPONENT_RUNTIME_PROPERTIES",
						props_tDataStewardshipTaskDelete_5);
				globalMap.putIfAbsent("TALEND_PRODUCT_VERSION", "8.0");
				globalMap.put("TALEND_COMPONENTS_VERSION", "0.37.46");
				java.net.URL mappings_url_tDataStewardshipTaskDelete_5 = this.getClass().getResource("/xmlMappings");
				globalMap.put("tDataStewardshipTaskDelete_5_MAPPINGS_URL", mappings_url_tDataStewardshipTaskDelete_5);

				org.talend.components.api.container.RuntimeContainer container_tDataStewardshipTaskDelete_5 = new org.talend.components.api.container.RuntimeContainer() {
					public Object getComponentData(String componentId, String key) {
						return globalMap.get(componentId + "_" + key);
					}

					public void setComponentData(String componentId, String key, Object data) {
						globalMap.put(componentId + "_" + key, data);
					}

					public String getCurrentComponentId() {
						return "tDataStewardshipTaskDelete_5";
					}

					public Object getGlobalData(String key) {
						return globalMap.get(key);
					}
				};

				int nb_line_tDataStewardshipTaskDelete_5 = 0;

				org.talend.components.api.component.ConnectorTopology topology_tDataStewardshipTaskDelete_5 = null;
				topology_tDataStewardshipTaskDelete_5 = org.talend.components.api.component.ConnectorTopology.INCOMING;

				org.talend.daikon.runtime.RuntimeInfo runtime_info_tDataStewardshipTaskDelete_5 = def_tDataStewardshipTaskDelete_5
						.getRuntimeInfo(org.talend.components.api.component.runtime.ExecutionEngine.DI,
								props_tDataStewardshipTaskDelete_5, topology_tDataStewardshipTaskDelete_5);
				java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_tDataStewardshipTaskDelete_5 = def_tDataStewardshipTaskDelete_5
						.getSupportedConnectorTopologies();

				org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_tDataStewardshipTaskDelete_5 = (org.talend.components.api.component.runtime.RuntimableRuntime) (Class
						.forName(runtime_info_tDataStewardshipTaskDelete_5.getRuntimeClassName()).newInstance());
				org.talend.daikon.properties.ValidationResult initVr_tDataStewardshipTaskDelete_5 = componentRuntime_tDataStewardshipTaskDelete_5
						.initialize(container_tDataStewardshipTaskDelete_5, props_tDataStewardshipTaskDelete_5);

				if (initVr_tDataStewardshipTaskDelete_5
						.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR) {
					throw new RuntimeException(initVr_tDataStewardshipTaskDelete_5.getMessage());
				}

				if (componentRuntime_tDataStewardshipTaskDelete_5 instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {
					org.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_tDataStewardshipTaskDelete_5 = (org.talend.components.api.component.runtime.ComponentDriverInitialization) componentRuntime_tDataStewardshipTaskDelete_5;
					compDriverInitialization_tDataStewardshipTaskDelete_5
							.runAtDriver(container_tDataStewardshipTaskDelete_5);
				}

				org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_tDataStewardshipTaskDelete_5 = null;
				if (componentRuntime_tDataStewardshipTaskDelete_5 instanceof org.talend.components.api.component.runtime.SourceOrSink) {
					sourceOrSink_tDataStewardshipTaskDelete_5 = (org.talend.components.api.component.runtime.SourceOrSink) componentRuntime_tDataStewardshipTaskDelete_5;
					if (doesNodeBelongToRequest_tDataStewardshipTaskDelete_5) {
						org.talend.daikon.properties.ValidationResult vr_tDataStewardshipTaskDelete_5 = sourceOrSink_tDataStewardshipTaskDelete_5
								.validate(container_tDataStewardshipTaskDelete_5);
						if (vr_tDataStewardshipTaskDelete_5
								.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR) {
							throw new RuntimeException(vr_tDataStewardshipTaskDelete_5.getMessage());
						}
					}
				}

				org.talend.codegen.enforcer.IncomingSchemaEnforcer incomingEnforcer_tDataStewardshipTaskDelete_5 = null;
				if (sourceOrSink_tDataStewardshipTaskDelete_5 instanceof org.talend.components.api.component.runtime.Sink) {
					org.talend.components.api.component.runtime.Sink sink_tDataStewardshipTaskDelete_5 = (org.talend.components.api.component.runtime.Sink) sourceOrSink_tDataStewardshipTaskDelete_5;
					org.talend.components.api.component.runtime.WriteOperation writeOperation_tDataStewardshipTaskDelete_5 = sink_tDataStewardshipTaskDelete_5
							.createWriteOperation();
					if (doesNodeBelongToRequest_tDataStewardshipTaskDelete_5) {
						writeOperation_tDataStewardshipTaskDelete_5.initialize(container_tDataStewardshipTaskDelete_5);
					}
					writer_tDataStewardshipTaskDelete_5 = writeOperation_tDataStewardshipTaskDelete_5
							.createWriter(container_tDataStewardshipTaskDelete_5);
					if (doesNodeBelongToRequest_tDataStewardshipTaskDelete_5) {
						writer_tDataStewardshipTaskDelete_5.open("tDataStewardshipTaskDelete_5");
					}

					resourceMap.put("writer_tDataStewardshipTaskDelete_5", writer_tDataStewardshipTaskDelete_5);
				} // end of "sourceOrSink_tDataStewardshipTaskDelete_5 instanceof ...Sink"
				org.talend.components.api.component.Connector c_tDataStewardshipTaskDelete_5 = null;
				for (org.talend.components.api.component.Connector currentConnector : props_tDataStewardshipTaskDelete_5
						.getAvailableConnectors(null, false)) {
					if (currentConnector.getName().equals("MAIN")) {
						c_tDataStewardshipTaskDelete_5 = currentConnector;
						break;
					}
				}
				org.apache.avro.Schema designSchema_tDataStewardshipTaskDelete_5 = props_tDataStewardshipTaskDelete_5
						.getSchema(c_tDataStewardshipTaskDelete_5, false);
				incomingEnforcer_tDataStewardshipTaskDelete_5 = new org.talend.codegen.enforcer.IncomingSchemaEnforcer(
						designSchema_tDataStewardshipTaskDelete_5);

				java.lang.Iterable<?> outgoingMainRecordsList_tDataStewardshipTaskDelete_5 = new java.util.ArrayList<Object>();
				java.util.Iterator outgoingMainRecordsIt_tDataStewardshipTaskDelete_5 = null;

				/**
				 * [tDataStewardshipTaskDelete_5 begin ] stop
				 */

				/**
				 * [tRowGenerator_1 begin ] start
				 */

				sh("tRowGenerator_1");

				s(currentComponent = "tRowGenerator_1");

				int tos_count_tRowGenerator_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tRowGenerator_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tRowGenerator_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tRowGenerator_1 = new StringBuilder();
							log4jParamters_tRowGenerator_1.append("Parameters:");
							if (log.isDebugEnabled())
								log.debug("tRowGenerator_1 - " + (log4jParamters_tRowGenerator_1));
						}
					}
					new BytesLimit65535_tRowGenerator_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tRowGenerator_1", "tRowGenerator_1", "tRowGenerator");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				int nb_line_tRowGenerator_1 = 0;
				int nb_max_row_tRowGenerator_1 = 100;

				class tRowGenerator_1Randomizer {
					public String getRandomnewColumn() {

						return TalendString.getAsciiRandomString(6);

					}
				}
				tRowGenerator_1Randomizer randtRowGenerator_1 = new tRowGenerator_1Randomizer();

				log.info("tRowGenerator_1 - Generating records.");
				for (int itRowGenerator_1 = 0; itRowGenerator_1 < nb_max_row_tRowGenerator_1; itRowGenerator_1++) {
					row1.newColumn = randtRowGenerator_1.getRandomnewColumn();
					nb_line_tRowGenerator_1++;

					log.debug("tRowGenerator_1 - Retrieving the record " + nb_line_tRowGenerator_1 + ".");

					/**
					 * [tRowGenerator_1 begin ] stop
					 */

					/**
					 * [tRowGenerator_1 main ] start
					 */

					s(currentComponent = "tRowGenerator_1");

					tos_count_tRowGenerator_1++;

					/**
					 * [tRowGenerator_1 main ] stop
					 */

					/**
					 * [tRowGenerator_1 process_data_begin ] start
					 */

					s(currentComponent = "tRowGenerator_1");

					/**
					 * [tRowGenerator_1 process_data_begin ] stop
					 */

					/**
					 * [tDataStewardshipTaskDelete_5 main ] start
					 */

					s(currentComponent = "tDataStewardshipTaskDelete_5");

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row1", "tRowGenerator_1", "tRowGenerator_1", "tRowGenerator",
							"tDataStewardshipTaskDelete_5", "tDataStewardshipTaskDelete_5", "tDataStewardshipTaskDelete"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
					}

					boolean shouldCreateRuntimeSchemaForIncomingNode = false;
					if (incomingEnforcer_tDataStewardshipTaskDelete_5 != null
							&& incomingEnforcer_tDataStewardshipTaskDelete_5.getDesignSchema()
									.getField("newColumn") == null) {
						incomingEnforcer_tDataStewardshipTaskDelete_5.addIncomingNodeField("newColumn",
								((Object) row1.newColumn).getClass().getCanonicalName());
						shouldCreateRuntimeSchemaForIncomingNode = true;
					}
					if (shouldCreateRuntimeSchemaForIncomingNode
							&& incomingEnforcer_tDataStewardshipTaskDelete_5 != null) {
						incomingEnforcer_tDataStewardshipTaskDelete_5.createRuntimeSchema();
					}
					if (incomingEnforcer_tDataStewardshipTaskDelete_5 != null) {
						incomingEnforcer_tDataStewardshipTaskDelete_5.createNewRecord();
					}
					// skip the put action if the input column doesn't appear in component runtime
					// schema
					if (incomingEnforcer_tDataStewardshipTaskDelete_5 != null
							&& incomingEnforcer_tDataStewardshipTaskDelete_5.getRuntimeSchema()
									.getField("newColumn") != null) {
						incomingEnforcer_tDataStewardshipTaskDelete_5.put("newColumn", row1.newColumn);
					}

					org.apache.avro.generic.IndexedRecord data_tDataStewardshipTaskDelete_5 = null;
					if (incomingEnforcer_tDataStewardshipTaskDelete_5 != null) {
						data_tDataStewardshipTaskDelete_5 = incomingEnforcer_tDataStewardshipTaskDelete_5
								.getCurrentRecord();
					}

					if (writer_tDataStewardshipTaskDelete_5 != null && data_tDataStewardshipTaskDelete_5 != null) {
						writer_tDataStewardshipTaskDelete_5.write(data_tDataStewardshipTaskDelete_5);
					}

					nb_line_tDataStewardshipTaskDelete_5++;

					tos_count_tDataStewardshipTaskDelete_5++;

					/**
					 * [tDataStewardshipTaskDelete_5 main ] stop
					 */

					/**
					 * [tDataStewardshipTaskDelete_5 process_data_begin ] start
					 */

					s(currentComponent = "tDataStewardshipTaskDelete_5");

					/**
					 * [tDataStewardshipTaskDelete_5 process_data_begin ] stop
					 */

					/**
					 * [tDataStewardshipTaskDelete_5 process_data_end ] start
					 */

					s(currentComponent = "tDataStewardshipTaskDelete_5");

					/**
					 * [tDataStewardshipTaskDelete_5 process_data_end ] stop
					 */

					/**
					 * [tRowGenerator_1 process_data_end ] start
					 */

					s(currentComponent = "tRowGenerator_1");

					/**
					 * [tRowGenerator_1 process_data_end ] stop
					 */

					/**
					 * [tRowGenerator_1 end ] start
					 */

					s(currentComponent = "tRowGenerator_1");

				}
				globalMap.put("tRowGenerator_1_NB_LINE", nb_line_tRowGenerator_1);
				log.info("tRowGenerator_1 - Generated records count:" + nb_line_tRowGenerator_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tRowGenerator_1 - " + ("Done."));

				ok_Hash.put("tRowGenerator_1", true);
				end_Hash.put("tRowGenerator_1", System.currentTimeMillis());

				/**
				 * [tRowGenerator_1 end ] stop
				 */

				/**
				 * [tDataStewardshipTaskDelete_5 end ] start
				 */

				s(currentComponent = "tDataStewardshipTaskDelete_5");

// end of generic

				resourceMap.put("finish_tDataStewardshipTaskDelete_5", Boolean.TRUE);

				java.util.Map<String, Object> resultMap_tDataStewardshipTaskDelete_5 = null;
				if (writer_tDataStewardshipTaskDelete_5 != null) {
					org.talend.components.api.component.runtime.Result resultObject_tDataStewardshipTaskDelete_5 = (org.talend.components.api.component.runtime.Result) writer_tDataStewardshipTaskDelete_5
							.close();
					resultMap_tDataStewardshipTaskDelete_5 = writer_tDataStewardshipTaskDelete_5.getWriteOperation()
							.finalize(
									java.util.Arrays.<org.talend.components.api.component.runtime.Result>asList(
											resultObject_tDataStewardshipTaskDelete_5),
									container_tDataStewardshipTaskDelete_5);
				}
				if (resultMap_tDataStewardshipTaskDelete_5 != null) {
					for (java.util.Map.Entry<String, Object> entry_tDataStewardshipTaskDelete_5 : resultMap_tDataStewardshipTaskDelete_5
							.entrySet()) {
						switch (entry_tDataStewardshipTaskDelete_5.getKey()) {
						case org.talend.components.api.component.ComponentDefinition.RETURN_ERROR_MESSAGE:
							container_tDataStewardshipTaskDelete_5.setComponentData("tDataStewardshipTaskDelete_5",
									"ERROR_MESSAGE", entry_tDataStewardshipTaskDelete_5.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_TOTAL_RECORD_COUNT:
							container_tDataStewardshipTaskDelete_5.setComponentData("tDataStewardshipTaskDelete_5",
									"NB_LINE", entry_tDataStewardshipTaskDelete_5.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_SUCCESS_RECORD_COUNT:
							container_tDataStewardshipTaskDelete_5.setComponentData("tDataStewardshipTaskDelete_5",
									"NB_SUCCESS", entry_tDataStewardshipTaskDelete_5.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_REJECT_RECORD_COUNT:
							container_tDataStewardshipTaskDelete_5.setComponentData("tDataStewardshipTaskDelete_5",
									"NB_REJECT", entry_tDataStewardshipTaskDelete_5.getValue());
							break;
						default:
							StringBuilder studio_key_tDataStewardshipTaskDelete_5 = new StringBuilder();
							for (int i_tDataStewardshipTaskDelete_5 = 0; i_tDataStewardshipTaskDelete_5 < entry_tDataStewardshipTaskDelete_5
									.getKey().length(); i_tDataStewardshipTaskDelete_5++) {
								char ch_tDataStewardshipTaskDelete_5 = entry_tDataStewardshipTaskDelete_5.getKey()
										.charAt(i_tDataStewardshipTaskDelete_5);
								if (Character.isUpperCase(ch_tDataStewardshipTaskDelete_5)
										&& i_tDataStewardshipTaskDelete_5 > 0) {
									studio_key_tDataStewardshipTaskDelete_5.append('_');
								}
								studio_key_tDataStewardshipTaskDelete_5.append(ch_tDataStewardshipTaskDelete_5);
							}
							container_tDataStewardshipTaskDelete_5.setComponentData(
									"tDataStewardshipTaskDelete_5", studio_key_tDataStewardshipTaskDelete_5.toString()
											.toUpperCase(java.util.Locale.ENGLISH),
									entry_tDataStewardshipTaskDelete_5.getValue());
							break;
						}
					}
				}

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tRowGenerator_1", "tRowGenerator_1", "tRowGenerator", "tDataStewardshipTaskDelete_5",
						"tDataStewardshipTaskDelete_5", "tDataStewardshipTaskDelete", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tDataStewardshipTaskDelete_5", true);
				end_Hash.put("tDataStewardshipTaskDelete_5", System.currentTimeMillis());

				/**
				 * [tDataStewardshipTaskDelete_5 end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRowGenerator_1 finally ] start
				 */

				s(currentComponent = "tRowGenerator_1");

				/**
				 * [tRowGenerator_1 finally ] stop
				 */

				/**
				 * [tDataStewardshipTaskDelete_5 finally ] start
				 */

				s(currentComponent = "tDataStewardshipTaskDelete_5");

// finally of generic

				if (resourceMap.get("finish_tDataStewardshipTaskDelete_5") == null) {
					if (resourceMap.get("writer_tDataStewardshipTaskDelete_5") != null) {
						try {
							((org.talend.components.api.component.runtime.Writer) resourceMap
									.get("writer_tDataStewardshipTaskDelete_5")).close();
						} catch (java.io.IOException e_tDataStewardshipTaskDelete_5) {
							String errorMessage_tDataStewardshipTaskDelete_5 = "failed to release the resource in tDataStewardshipTaskDelete_5 :"
									+ e_tDataStewardshipTaskDelete_5.getMessage();
							System.err.println(errorMessage_tDataStewardshipTaskDelete_5);
						}
					}
				}

				/**
				 * [tDataStewardshipTaskDelete_5 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", 1);
	}

	public void talendJobLogProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("talendJobLog_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		String iterateId = "";

		String currentComponent = "";
		s("none");
		String cLabel = null;
		java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

		try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { // start the resume
				globalResumeTicket = true;

				/**
				 * [talendJobLog begin ] start
				 */

				sh("talendJobLog");

				s(currentComponent = "talendJobLog");

				int tos_count_talendJobLog = 0;

				for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
					org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder
							.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
							.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid)
							.custom("father_pid", fatherPid).custom("root_pid", rootPid);
					org.talend.logging.audit.Context log_context_talendJobLog = null;

					if (jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.sourceId(jcm.sourceId)
								.sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
								.targetId(jcm.targetId).targetLabel(jcm.targetLabel)
								.targetConnectorType(jcm.targetComponentName).connectionName(jcm.current_connector)
								.rows(jcm.row_count).duration(duration).build();
						auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
						auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).duration(duration)
								.status(jcm.status).build();
						auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
						log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
								.connectorType(jcm.component_name).connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label).build();
						auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {// log current component
																							// input line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {// log current component
																								// output/reject line
						long timeMS = jcm.end_time - jcm.start_time;
						String duration = String.valueOf(timeMS);

						log_context_talendJobLog = builder_talendJobLog.connectorType(jcm.component_name)
								.connectorId(jcm.component_id).connectorLabel(jcm.component_label)
								.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
								.rows(jcm.total_row_number).duration(duration).build();
						auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
					} else if (jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
						java.lang.Exception e_talendJobLog = jcm.exception;
						if (e_talendJobLog != null) {
							try (java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();
									java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
								e_talendJobLog.printStackTrace(pw_talendJobLog);
								builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,
										java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
							}
						}

						if (jcm.extra_info != null) {
							builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
						}

						log_context_talendJobLog = builder_talendJobLog
								.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
								.connectorId(jcm.component_id)
								.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label)
								.build();

						auditLogger_talendJobLog.exception(log_context_talendJobLog);
					}

				}

				/**
				 * [talendJobLog begin ] stop
				 */

				/**
				 * [talendJobLog main ] start
				 */

				s(currentComponent = "talendJobLog");

				tos_count_talendJobLog++;

				/**
				 * [talendJobLog main ] stop
				 */

				/**
				 * [talendJobLog process_data_begin ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog process_data_begin ] stop
				 */

				/**
				 * [talendJobLog process_data_end ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog process_data_end ] stop
				 */

				/**
				 * [talendJobLog end ] start
				 */

				s(currentComponent = "talendJobLog");

				ok_Hash.put("talendJobLog", true);
				end_Hash.put("talendJobLog", System.currentTimeMillis());

				/**
				 * [talendJobLog end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [talendJobLog finally ] start
				 */

				s(currentComponent = "talendJobLog");

				/**
				 * [talendJobLog finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("talendJobLog_SUBPROCESS_STATE", 1);
	}

	public String resuming_logs_dir_path = null;
	public String resuming_checkpoint_path = null;
	public String parent_part_launcher = null;
	private String resumeEntryMethodName = null;
	private boolean globalResumeTicket = false;

	public boolean watch = false;
	// portStats is null, it means don't execute the statistics
	public Integer portStats = null;
	public int portTraces = 4334;
	public String clientHost;
	public String defaultClientHost = "localhost";
	public String contextStr = "Default";
	public boolean isDefaultContext = true;
	public String pid = "0";
	public String rootPid = null;
	public String fatherPid = null;
	public String fatherNode = null;
	public long startTime = 0;
	public boolean isChildJob = false;
	public String log4jLevel = "";

	private boolean enableLogStash;
	private boolean enableLineage;

	private boolean execStat = true;

	private ThreadLocal<java.util.Map<String, String>> threadLocal = new ThreadLocal<java.util.Map<String, String>>() {
		protected java.util.Map<String, String> initialValue() {
			java.util.Map<String, String> threadRunResultMap = new java.util.HashMap<String, String>();
			threadRunResultMap.put("errorCode", null);
			threadRunResultMap.put("status", "");
			return threadRunResultMap;
		};
	};

	protected PropertiesWithType context_param = new PropertiesWithType();
	public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

	public String status = "";

	private final org.talend.components.common.runtime.SharedConnectionsPool connectionPool = new org.talend.components.common.runtime.SharedConnectionsPool() {
		public java.sql.Connection getDBConnection(String dbDriver, String url, String userName, String password,
				String dbConnectionName) throws ClassNotFoundException, java.sql.SQLException {
			return SharedDBConnection.getDBConnection(dbDriver, url, userName, password, dbConnectionName);
		}

		public java.sql.Connection getDBConnection(String dbDriver, String url, String dbConnectionName)
				throws ClassNotFoundException, java.sql.SQLException {
			return SharedDBConnection.getDBConnection(dbDriver, url, dbConnectionName);
		}

		public java.sql.Connection getDBConnection(String dbConnectionName,
				java.util.function.Supplier<java.sql.Connection> provider)
				throws ClassNotFoundException, java.sql.SQLException {
			return SharedDBConnection.getDBConnection(dbConnectionName, provider);
		}
	};

	private static final String GLOBAL_CONNECTION_POOL_KEY = "GLOBAL_CONNECTION_POOL";

	{
		globalMap.put(GLOBAL_CONNECTION_POOL_KEY, connectionPool);
	}

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final Shedule_withdraw_ Shedule_withdraw_Class = new Shedule_withdraw_();

		int exitCode = Shedule_withdraw_Class.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Shedule_withdraw_' - Done.");
		}

		System.exit(exitCode);
	}

	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if (path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
		readJobInfo(new java.io.File(BUILD_PATH));
	}

	private void readJobInfo(java.io.File jobInfoFile) {

		if (jobInfoFile.exists()) {
			try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
				jobInfo.load(is);
			} catch (IOException e) {

				log.debug("Read jobInfo.properties file fail: " + e.getMessage());

			}
		}
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s", projectName,
				jobName, jobInfo.getProperty("gitCommitId"), "8.0.1.20250521_1150-patch"));

	}

	public String[][] runJob(String[] args) {

		int exitCode = runJobInTOS(args);
		String[][] bufferValue = new String[][] { { Integer.toString(exitCode) } };

		return bufferValue;
	}

	public boolean hastBufferOutputComponent() {
		boolean hastBufferOutput = false;

		return hastBufferOutput;
	}

	public int runJobInTOS(String[] args) {
		// reset status
		status = "";

		String lastStr = "";
		for (String arg : args) {
			if (arg.equalsIgnoreCase("--context_param")) {
				lastStr = arg;
			} else if (lastStr.equals("")) {
				evalParam(arg);
			} else {
				evalParam(lastStr + " " + arg);
				lastStr = "";
			}
		}

		final boolean enableCBP = false;
		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		if (!inOSGi && isCBPClientPresent) {
			if (org.talend.metrics.CBPClient.getInstanceForCurrentVM() == null) {
				try {
					org.talend.metrics.CBPClient.startListenIfNotStarted(enableCBP, true);
				} catch (java.lang.Exception e) {
					errorCode = 1;
					status = "failure";
					e.printStackTrace();
					return 1;
				}
			}
		}

		enableLogStash = "true".equalsIgnoreCase(System.getProperty("audit.enabled"));

		if (!"".equals(log4jLevel)) {

			if ("trace".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.TRACE);
			} else if ("debug".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.DEBUG);
			} else if ("info".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.INFO);
			} else if ("warn".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.WARN);
			} else if ("error".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.ERROR);
			} else if ("fatal".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.FATAL);
			} else if ("off".equalsIgnoreCase(log4jLevel)) {
				org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(),
						org.apache.logging.log4j.Level.OFF);
			}
			org.apache.logging.log4j.core.config.Configurator
					.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());

		}

		getjobInfo();
		log.info("TalendJob: 'Shedule_withdraw_' - Start.");

		java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
		for (Object jobInfoKey : jobInfoKeys) {
			org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
		}
		org.slf4j.MDC.put("_pid", pid);
		org.slf4j.MDC.put("_rootPid", rootPid);
		org.slf4j.MDC.put("_fatherPid", fatherPid);
		org.slf4j.MDC.put("_projectName", projectName);
		org.slf4j.MDC.put("_startTimestamp", java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC)
				.format(java.time.format.DateTimeFormatter.ISO_INSTANT));
		org.slf4j.MDC.put("_jobRepositoryId", "_1Wz1EFf_EfC5dpgX8ITjCQ");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2025-07-04T04:51:54.065433500Z");

		java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
		String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
		if (mxNameTable.length == 2) {
			org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
		} else {
			org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
		}

		if (enableLogStash) {
			java.util.Properties properties_talendJobLog = new java.util.Properties();
			properties_talendJobLog.setProperty("root.logger", "audit");
			properties_talendJobLog.setProperty("encoding", "UTF-8");
			properties_talendJobLog.setProperty("application.name", "Talend Studio");
			properties_talendJobLog.setProperty("service.name", "Talend Studio Job");
			properties_talendJobLog.setProperty("instance.name", "Talend Studio Job Instance");
			properties_talendJobLog.setProperty("propagate.appender.exceptions", "none");
			properties_talendJobLog.setProperty("log.appender", "file");
			properties_talendJobLog.setProperty("appender.file.path", "audit.json");
			properties_talendJobLog.setProperty("appender.file.maxsize", "52428800");
			properties_talendJobLog.setProperty("appender.file.maxbackup", "20");
			properties_talendJobLog.setProperty("host", "false");

			System.getProperties().stringPropertyNames().stream().filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()),
							System.getProperty(key)));

			org.apache.logging.log4j.core.config.Configurator
					.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);

			auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory
					.createJobAuditLogger(properties_talendJobLog);
		}

		if (clientHost == null) {
			clientHost = defaultClientHost;
		}

		if (pid == null || "0".equals(pid)) {
			pid = TalendString.getAsciiRandomString(6);
		}

		org.slf4j.MDC.put("_pid", pid);

		if (rootPid == null) {
			rootPid = pid;
		}

		org.slf4j.MDC.put("_rootPid", rootPid);

		if (fatherPid == null) {
			fatherPid = pid;
		} else {
			isChildJob = true;
		}
		org.slf4j.MDC.put("_fatherPid", fatherPid);

		if (portStats != null) {
			// portStats = -1; //for testing
			if (portStats < 0 || portStats > 65535) {
				// issue:10869, the portStats is invalid, so this client socket can't open
				System.err.println("The statistics socket port " + portStats + " is invalid.");
				execStat = false;
			}
		} else {
			execStat = false;
		}

		try {
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobName);

				if (jobProperties != null && jobProperties.get("context") != null) {
					contextStr = (String) jobProperties.get("context");
				}

				if (jobProperties != null && jobProperties.get("taskExecutionId") != null) {
					taskExecutionId = (String) jobProperties.get("taskExecutionId");
				}

				// extract ids from parent route
				if (null == taskExecutionId || taskExecutionId.isEmpty()) {
					for (String arg : args) {
						if (arg.startsWith("--context_param")
								&& (arg.contains("taskExecutionId") || arg.contains("jobExecutionId"))) {

							String keyValue = arg.replace("--context_param", "");
							String[] parts = keyValue.split("=");
							String[] cleanParts = java.util.Arrays.stream(parts).filter(s -> !s.isEmpty())
									.toArray(String[]::new);
							if (cleanParts.length == 2) {
								String key = cleanParts[0];
								String value = cleanParts[1];
								if ("taskExecutionId".equals(key.trim()) && null != value) {
									taskExecutionId = value.trim();
								} else if ("jobExecutionId".equals(key.trim()) && null != value) {
									jobExecutionId = value.trim();
								}
							}
						}
					}
				}
			}

			// first load default key-value pairs from application.properties
			if (isStandaloneMS) {
				context.putAll(this.getDefaultProperties());
			}
			// call job/subjob with an existing context, like: --context=production. if
			// without this parameter, there will use the default context instead.
			java.io.InputStream inContext = Shedule_withdraw_.class.getClassLoader()
					.getResourceAsStream("dpdp_renew/shedule_withdraw__0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Shedule_withdraw_.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + contextStr + ".properties");
			}
			if (inContext != null) {
				try {
					// defaultProps is in order to keep the original context value
					if (context != null && context.isEmpty()) {
						defaultProps.load(inContext);
						if (inOSGi && jobProperties != null) {
							java.util.Enumeration<String> keys = jobProperties.keys();
							while (keys.hasMoreElements()) {
								String propKey = keys.nextElement();
								if (defaultProps.containsKey(propKey)) {
									defaultProps.put(propKey, (String) jobProperties.get(propKey));
								}
							}
						}
						context = new ContextProperties(defaultProps);
					}
					if (isStandaloneMS) {
						// override context key-value pairs if provided using --context=contextName
						defaultProps.load(inContext);
						context.putAll(defaultProps);
					}
				} finally {
					inContext.close();
				}
			} else if (!isDefaultContext) {
				// print info and job continue to run, for case: context_param is not empty.
				System.err.println("Could not find the context " + contextStr);
			}
			// override key-value pairs if provided via --config.location=file1.file2 OR
			// --config.additional-location=file1,file2
			if (isStandaloneMS) {
				context.putAll(this.getAdditionalProperties());
			}

			// override key-value pairs if provide via command line like
			// --key1=value1,--key2=value2
			if (!context_param.isEmpty()) {
				context.putAll(context_param);
				// set types for params from parentJobs
				for (Object key : context_param.keySet()) {
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
			}
			class ContextProcessing {
				private void processContext_0() {
				}

				public void processAllContext() {
					processContext_0();
				}
			}

			new ContextProcessing().processAllContext();
		} catch (java.io.IOException ie) {
			System.err.println("Could not load context " + contextStr);
			ie.printStackTrace();
		}

		// get context value from parent directly
		if (parentContextMap != null && !parentContextMap.isEmpty()) {
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'Shedule_withdraw_' - Started.");
		java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);

		if (execStat) {
			try {
				runStat.openSocket(!isChildJob);
				runStat.setAllPID(rootPid, fatherPid, pid, jobName);
				runStat.startThreadStat(clientHost, portStats);
				runStat.updateStatOnJob(RunStat.JOBSTART, fatherNode);
			} catch (java.io.IOException ioException) {
				ioException.printStackTrace();
			}
		}

		java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
		globalMap.put("concurrentHashMap", concurrentHashMap);

		long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		long endUsedMemory = 0;
		long end = 0;

		startTime = System.currentTimeMillis();

		this.globalResumeTicket = true;// to run tPreJob

		if (enableLogStash) {
			talendJobLog.addJobStartMessage();
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		this.globalResumeTicket = false;// to run others jobs

		try {
			errorCode = null;
			tRowGenerator_1Process(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRowGenerator_1) {
			globalMap.put("tRowGenerator_1_SUBPROCESS_STATE", -1);

			e_tRowGenerator_1.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Shedule_withdraw_");
		}
		if (enableLogStash) {
			talendJobLog.addJobEndMessage(startTime, end, status);
			try {
				talendJobLogProcess(globalMap);
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}

		if (execStat) {
			runStat.updateStatOnJob(RunStat.JOBEND, fatherNode);
			runStat.stopThreadStat();
		}
		if (!inOSGi && isCBPClientPresent) {
			if (org.talend.metrics.CBPClient.getInstanceForCurrentVM() != null) {
				s("none");
				org.talend.metrics.CBPClient.getInstanceForCurrentVM().sendData();
			}
		}

		int returnCode = 0;

		if (errorCode == null) {
			returnCode = status != null && status.equals("failure") ? 1 : 0;
		} else {
			returnCode = errorCode.intValue();
		}
		resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "",
				"" + returnCode, "", "", "");
		resumeUtil.flush();

		org.slf4j.MDC.remove("_subJobName");
		org.slf4j.MDC.remove("_subJobPid");
		org.slf4j.MDC.remove("_systemPid");
		log.info("TalendJob: 'Shedule_withdraw_' - Finished - status: " + status + " returnCode: " + returnCode);

		return returnCode;

	}

	// only for OSGi env
	public void destroy() {
		// add CBP code for OSGI Executions
		if (null != taskExecutionId && !taskExecutionId.isEmpty()) {
			try {
				org.talend.metrics.DataReadTracker.setExecutionId(taskExecutionId, jobExecutionId, false);
				org.talend.metrics.DataReadTracker.sealCounter();
				org.talend.metrics.DataReadTracker.reset();
			} catch (Exception | NoClassDefFoundError e) {
				// ignore
			}
		}

	}

	private java.util.Map<String, Object> getSharedConnections4REST() {
		java.util.Map<String, Object> connections = new java.util.HashMap<String, Object>();

		return connections;
	}

	private void evalParam(String arg) {
		if (arg.startsWith("--resuming_logs_dir_path")) {
			resuming_logs_dir_path = arg.substring(25);
		} else if (arg.startsWith("--resuming_checkpoint_path")) {
			resuming_checkpoint_path = arg.substring(27);
		} else if (arg.startsWith("--parent_part_launcher")) {
			parent_part_launcher = arg.substring(23);
		} else if (arg.startsWith("--watch")) {
			watch = true;
		} else if (arg.startsWith("--stat_port=")) {
			String portStatsStr = arg.substring(12);
			if (portStatsStr != null && !portStatsStr.equals("null")) {
				portStats = Integer.parseInt(portStatsStr);
			}
		} else if (arg.startsWith("--trace_port=")) {
			portTraces = Integer.parseInt(arg.substring(13));
		} else if (arg.startsWith("--client_host=")) {
			clientHost = arg.substring(14);
		} else if (arg.startsWith("--context=")) {
			contextStr = arg.substring(10);
			isDefaultContext = false;
		} else if (arg.startsWith("--father_pid=")) {
			fatherPid = arg.substring(13);
		} else if (arg.startsWith("--root_pid=")) {
			rootPid = arg.substring(11);
		} else if (arg.startsWith("--father_node=")) {
			fatherNode = arg.substring(14);
		} else if (arg.startsWith("--pid=")) {
			pid = arg.substring(6);
		} else if (arg.startsWith("--context_type")) {
			String keyValue = arg.substring(15);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.setContextType(keyValue.substring(0, index),
							replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1));
				}

			}

		} else if (arg.startsWith("--context_param")) {
			String keyValue = arg.substring(16);
			int index = -1;
			if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
				if (fatherPid == null) {
					context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
				} else { // the subjob won't escape the especial chars
					context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1));
				}
			}
		} else if (arg.startsWith("--context_file")) {
			String keyValue = arg.substring(15);
			String filePath = new String(java.util.Base64.getDecoder().decode(keyValue));
			java.nio.file.Path contextFile = java.nio.file.Paths.get(filePath);
			try (java.io.BufferedReader reader = java.nio.file.Files.newBufferedReader(contextFile)) {
				String line;
				while ((line = reader.readLine()) != null) {
					int index = -1;
					if ((index = line.indexOf('=')) > -1) {
						if (line.startsWith("--context_param")) {
							if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
								context_param.put(line.substring(16, index),
										routines.system.PasswordEncryptUtil.decryptPassword(line.substring(index + 1)));
							} else {
								context_param.put(line.substring(16, index), line.substring(index + 1));
							}
						} else {// --context_type
							context_param.setContextType(line.substring(15, index), line.substring(index + 1));
						}
					}
				}
			} catch (java.io.IOException e) {
				System.err.println("Could not load the context file: " + filePath);
				e.printStackTrace();
			}
		} else if (arg.startsWith("--log4jLevel=")) {
			log4jLevel = arg.substring(13);
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {// for trunjob call
			final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
	}

	private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

	private final String[][] escapeChars = { { "\\\\", "\\" }, { "\\n", "\n" }, { "\\'", "\'" }, { "\\r", "\r" },
			{ "\\f", "\f" }, { "\\b", "\b" }, { "\\t", "\t" } };

	private String replaceEscapeChars(String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0], currIndex);
				if (index >= 0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0],
							strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the
			// result
			if (index < 0) {
				result.append(keyValue.substring(currIndex));
				currIndex = currIndex + keyValue.length();
			}
		}

		return result.toString();
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public String getStatus() {
		return status;
	}

	ResumeUtil resumeUtil = null;
}
/************************************************************************************************
 * 87289 characters generated by Talend Real-time Big Data Platform on the 4
 * July 2025 at 10:21:54 am IST
 ************************************************************************************************/