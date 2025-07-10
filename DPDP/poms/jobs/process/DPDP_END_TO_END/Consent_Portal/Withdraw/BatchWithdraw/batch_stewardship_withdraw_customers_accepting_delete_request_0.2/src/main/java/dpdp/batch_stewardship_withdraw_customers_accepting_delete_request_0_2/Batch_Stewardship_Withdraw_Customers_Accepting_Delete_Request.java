
package dpdp.batch_stewardship_withdraw_customers_accepting_delete_request_0_2;

import routines.Numeric;
import routines.DataOperation;
import routines.TalendDataGenerator;
import routines.TalendStringUtil;
import routines.TalendString;
import routines.MDM;
import routines.StringHandling;
import routines.Relational;
import routines.TalendDate;
import routines.Mathematical;
import routines.SQLike;
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

//the import part of tJava_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request Purpose:
 * <br>
 * Description: <br>
 * 
 * @author Patil, Chirag
 * @version 8.0.1.20250521_1150-patch
 * @status
 */
public class Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.class);

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

			if (tableName != null) {

				this.setProperty("tableName", tableName.toString());

			}

			if (databaseName != null) {

				this.setProperty("databaseName", databaseName.toString());

			}

			if (token != null) {

				this.setProperty("token", token.toString());

			}

			if (tableId != null) {

				this.setProperty("tableId", tableId.toString());

			}

			if (customerId != null) {

				this.setProperty("customerId", customerId.toString());

			}

			if (Stewardship_Password != null) {

				this.setProperty("Stewardship_Password", Stewardship_Password.toString());

			}

			if (Stewardship_URL != null) {

				this.setProperty("Stewardship_URL", Stewardship_URL.toString());

			}

			if (Stewardship_UserName != null) {

				this.setProperty("Stewardship_UserName", Stewardship_UserName.toString());

			}

		}

		// if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if (NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

		public String tableName;

		public String getTableName() {
			return this.tableName;
		}

		public String databaseName;

		public String getDatabaseName() {
			return this.databaseName;
		}

		public String token;

		public String getToken() {
			return this.token;
		}

		public String tableId;

		public String getTableId() {
			return this.tableId;
		}

		public Integer customerId;

		public Integer getCustomerId() {
			return this.customerId;
		}

		public java.lang.String Stewardship_Password;

		public java.lang.String getStewardship_Password() {
			return this.Stewardship_Password;
		}

		public String Stewardship_URL;

		public String getStewardship_URL() {
			return this.Stewardship_URL;
		}

		public String Stewardship_UserName;

		public String getStewardship_UserName() {
			return this.Stewardship_UserName;
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

	private final String jobVersion = "0.2";
	private final String jobName = "Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request";
	private final String projectName = "DPDP";
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
			"_IIjBwFApEfC4ZuKDeZl3GA", "0.2");
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
				Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.this.exception = e;
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.this,
									new Object[] { e, currentComponent, globalMap });
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

	public void tFlowToIterate_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_2_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_2_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTClient_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tContextLoad_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_4_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTClient_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tContextLoad_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tContextLoad_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_5_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_3_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBRow_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTRequest_2_Loop_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tRESTRequest_2_In_error(exception, errorComponent, globalMap);

	}

	public void tRESTRequest_2_In_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_2_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_4_TXMLMAP_OUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tXMLMap_4_TXMLMAP_IN_error(exception, errorComponent, globalMap);

	}

	public void tXMLMap_4_TXMLMAP_IN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_2_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_1_TXMLMAP_OUT_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tXMLMap_1_TXMLMAP_IN_error(exception, errorComponent, globalMap);

	}

	public void tXMLMap_1_TXMLMAP_IN_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_2_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTClient_3_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tDBRow_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTRequest_2_Loop_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void talendJobLog_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	private boolean runInTalendEsbRuntimeContainer = false;

	public void setRunInTalendEsbRuntimeContainer(boolean flag) {
		runInTalendEsbRuntimeContainer = flag;
	}

	protected String restEndpoint;

	public void setRestEndpoint(String restEndpoint) {
		this.restEndpoint = restEndpoint;
	}

	public String getRestEndpoint() {
		return "GDPR";
	}

	private boolean runInDaemonMode = true;

	public void setRunInDaemonMode(boolean flag) {
		runInDaemonMode = flag;
	}

	private boolean restTalendJobAlreadyStarted = false;

	/**
	 * REST provider implementation
	 */
	@jakarta.ws.rs.Path("/")

	public static class RestServiceProviderImpl4TalendJob {

		@jakarta.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;
		private final String setCookieHeader = "Set-Cookie";

		private final Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request job;

		public RestServiceProviderImpl4TalendJob() {
			this.job = new Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request();
		}

		public RestServiceProviderImpl4TalendJob(Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap,
				Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request job) {
			// pass job DataSources
			java.util.Map<String, routines.system.TalendDataSource> talendDataSources = (java.util.Map<String, routines.system.TalendDataSource>) job.globalMap
					.get(KEY_DB_DATASOURCES);
			if (null != talendDataSources) {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
				for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources
						.entrySet()) {
					restDataSources.put(talendDataSourceEntry.getKey(),
							new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));
				}
				requestGlobalMap.put(KEY_DB_DATASOURCES, restDataSources);
			}

			if (null != job.globalMap.get(KEY_DB_DATASOURCES_RAW)) {
				requestGlobalMap.put(KEY_DB_DATASOURCES_RAW, job.globalMap.get(KEY_DB_DATASOURCES_RAW));
			}

			// pass job shared connections
			requestGlobalMap.putAll(job.getSharedConnections4REST());

			// pass job concurrent map
			requestGlobalMap.put("concurrentHashMap", job.globalMap.get("concurrentHashMap"));

			requestGlobalMap.putAll(job.globalMap);
		}

		private void closePassedDataSourceConnections(java.util.Map<String, Object> requestGlobalMap) {
			// close connections in passed job DataSources
			try {
				java.util.Map<String, routines.system.TalendDataSource> restDataSources = (java.util.Map<String, routines.system.TalendDataSource>) requestGlobalMap
						.get(KEY_DB_DATASOURCES);
				if (null != restDataSources) {
					for (routines.system.TalendDataSource restDataSource : restDataSources.values()) {
						restDataSource.close();
					}
				}
			} catch (Throwable e) {
				e.printStackTrace(System.err);
			}
		}

		private jakarta.ws.rs.core.Response processRequest(java.util.Map<String, Object> request) {

			final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

			try {
				// add CBP code for OSGI Executions
				String taskExecutionId = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.taskExecutionId;
				String jobExecutionId = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.jobExecutionId;

				if (taskExecutionId != null && !taskExecutionId.isEmpty()) {
					try {
						org.talend.metrics.DataReadTracker.setExecutionId(taskExecutionId, jobExecutionId, true);
						org.talend.metrics.DataReadTracker.incrementEventCounter();
					} catch (Exception | NoClassDefFoundError e) {
						// ignore
					}
				}

				globalMap.put("restRequest", request);

				populateRequestWithJobContext(globalMap, job);

				job.tRESTRequest_2_LoopProcess(globalMap);

				java.util.Map<String, Object> response = (java.util.Map<String, Object>) globalMap.get("restResponse");

				Object responseBody = null;
				Integer status = null;
				java.util.Map<String, String> headers = null;
				if (null != response) {
					Object dropJsonRootProp = response.get("drop.json.root.element");
					Boolean dropJsonRoot = (null == dropJsonRootProp) ? false : (Boolean) dropJsonRootProp;
					messageContext.put("drop.json.root.element", dropJsonRoot.toString());

					responseBody = response.get("BODY");
					status = (Integer) response.get("STATUS");
					headers = (java.util.Map<String, String>) response.get("HEADERS");
				} else {
					responseBody = request.get("ERROR");
				}

				if (null == status) {
					status = (request.containsKey("STATUS")) ? (Integer) request.get("STATUS") : 404;
				}

				jakarta.ws.rs.core.Response.ResponseBuilder responseBuilder = jakarta.ws.rs.core.Response.status(status)
						.entity(responseBody);
				if (headers != null) {
					for (java.util.Map.Entry<String, String> header : headers.entrySet()) {
						if (header.getKey().equalsIgnoreCase(setCookieHeader)) {
							String cookies = header.getValue().trim();
							String cookiesList[] = cookies.split(";");

							for (String cookie : cookiesList) {
								String cookieTokens[] = cookie.trim().split("=");

								if (cookieTokens.length == 2) {

									String cookieName = cookieTokens[0].trim();
									String cookieValue = cookieTokens[1].trim();

									if (cookieName.length() > 0 && cookieValue.length() > 0) {
										jakarta.ws.rs.core.NewCookie newCookie = new jakarta.ws.rs.core.NewCookie(
												cookieName, cookieValue);
										responseBuilder.cookie(newCookie);
									}
								}
							}
						} else {
							responseBuilder.header(header.getKey(), header.getValue());
						}
					}
				}

				return responseBuilder.build();

			} catch (Throwable ex) {
				ex.printStackTrace();
				throw new jakarta.ws.rs.WebApplicationException(ex, 500);
			} finally {
				// close DB connections
				closePassedDataSourceConnections(globalMap);

				try {
					org.talend.metrics.DataReadTracker.reset();
				} catch (Exception | NoClassDefFoundError e) {
					// ignore
				}
			}
		}

		private jakarta.ws.rs.core.Response processStreamingResponseRequest(
				final java.util.Map<String, Object> request) {

			jakarta.ws.rs.core.StreamingOutput streamingOutput = new jakarta.ws.rs.core.StreamingOutput() {
				public void write(java.io.OutputStream output) {

					final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();

					try {
						globalMap.put("restResponseStream", output);

						globalMap.put("restRequest", request);

						populateRequestWithJobContext(globalMap, job);

						job.tRESTRequest_2_LoopProcess(globalMap);

						if (globalMap.containsKey("restResponseWrappingClosure")) {
							output.write(((String) globalMap.get("restResponseWrappingClosure")).getBytes());
						}
					} catch (Throwable ex) {
						ex.printStackTrace();
						throw new jakarta.ws.rs.WebApplicationException(ex, 500);
					} finally {
						// close DB connections
						closePassedDataSourceConnections(globalMap);
					}
				}
			};

			return jakarta.ws.rs.core.Response.ok().entity(streamingOutput).build();
		}

		@jakarta.ws.rs.DELETE()

		@jakarta.ws.rs.Path("/customer/{id}/{tableId}")
		@jakarta.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
		public jakarta.ws.rs.core.Response deleteCustomer(

				@jakarta.ws.rs.PathParam("id") Integer id, @jakarta.ws.rs.PathParam("tableId") String tableId

		) {
			List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();
			if (requiredParameterWithNullValueList.size() > 0) {
				return handleWrongRequest(messageContext, 400,
						"400 Bad Request \n" + requiredParameterWithNullValueList.toString()
								+ " in tRESTRequest_2:deleteCustomer "
								+ (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));
			}
			java.util.Map<String, Object> request_tRESTRequest_2 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_2.put("VERB", "DELETE");
			request_tRESTRequest_2.put("OPERATION", "deleteCustomer");
			request_tRESTRequest_2.put("PATTERN", "/customer/{id}/{tableId}");

			populateRequestInfo(request_tRESTRequest_2, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_2 = new java.util.HashMap<String, Object>();

			parameters_tRESTRequest_2.put("PATH:id:id_Integer", id);

			parameters_tRESTRequest_2.put("PATH:tableId:id_String", tableId);

			request_tRESTRequest_2.put("PARAMS", parameters_tRESTRequest_2);

			return processRequest(request_tRESTRequest_2);
		}

		public jakarta.ws.rs.core.Response handleWrongRequest(org.apache.cxf.jaxrs.ext.MessageContext context,
				int status, String error) {

			// System.out.println("wrong call [uri: " + context.getUriInfo().getPath() + " ;
			// method: " + context.getRequest().getMethod() + " ; status: " + status + " ;
			// error: " + error + "]");

			java.util.Map<String, Object> wrongRequest = new java.util.HashMap<String, Object>();

			wrongRequest.put("ERROR", error);
			wrongRequest.put("STATUS", status);
			wrongRequest.put("VERB", context.getRequest().getMethod());
			wrongRequest.put("URI", context.getUriInfo().getPath());
			wrongRequest.put("URI_BASE", context.getUriInfo().getBaseUri().toString());
			wrongRequest.put("URI_ABSOLUTE", context.getUriInfo().getAbsolutePath().toString());
			wrongRequest.put("URI_REQUEST", context.getUriInfo().getRequestUri().toString());

			return processRequest(wrongRequest);
		}

		private void populateRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context) {
			final jakarta.ws.rs.core.UriInfo ui = context.getUriInfo();

			request.put("URI", ui.getPath());
			request.put("URI_BASE", ui.getBaseUri().toString());
			request.put("URI_ABSOLUTE", ui.getAbsolutePath().toString());
			request.put("URI_REQUEST", ui.getRequestUri().toString());

			request.put("ALL_HEADER_PARAMS", context.getHttpHeaders().getRequestHeaders());
			request.put("ALL_QUERY_PARAMS", ui.getQueryParameters());

			jakarta.ws.rs.core.SecurityContext securityContext = context.getSecurityContext();
			if (null != securityContext && null != securityContext.getUserPrincipal()) {
				request.put("PRINCIPAL_NAME", securityContext.getUserPrincipal().getName());
			}

			request.put("CorrelationID", context.get("CorrelationID"));

			request.put("MESSAGE_CONTEXT", context);
		}

		private void populateMultipartRequestInfo(java.util.Map<String, Object> request,
				org.apache.cxf.jaxrs.ext.MessageContext context, java.util.Map<String, Boolean> partNames) {
			java.util.Map<String, String> attachmentFilenames = new java.util.HashMap<String, String>();

			java.util.Map<String, java.util.Map<String, java.util.List<String>>> attachmentHeaders = new java.util.HashMap<String, java.util.Map<String, java.util.List<String>>>();

			for (java.util.Map.Entry<String, Boolean> p : partNames.entrySet()) {
				String partName = p.getKey();
				Boolean optional = p.getValue();
				org.apache.cxf.jaxrs.ext.multipart.Attachment attachment = getFirstMatchingPart(context, partName,
						optional);
				if (null != attachment) {
					attachmentHeaders.put(partName, attachment.getHeaders());
					if (null != attachment.getContentDisposition()) {
						String filename = attachment.getContentDisposition().getParameter("filename");
						if (null != filename) {
							attachmentFilenames.put(partName, filename);
						}
					}
				}
			}

			request.put("ATTACHMENT_HEADERS", attachmentHeaders);
			request.put("ATTACHMENT_FILENAMES", attachmentFilenames);
		}

		private static org.apache.cxf.jaxrs.ext.multipart.Attachment getFirstMatchingPart(
				org.apache.cxf.jaxrs.ext.MessageContext context, String partName, Boolean optional) {
			List<org.apache.cxf.jaxrs.ext.multipart.Attachment> attachments = org.apache.cxf.jaxrs.utils.multipart.AttachmentUtils
					.getAttachments(context);
			for (org.apache.cxf.jaxrs.ext.multipart.Attachment attachment : attachments) {
				if (partName.equals(attachment.getContentId())) {
					return attachment;
				}
				org.apache.cxf.jaxrs.ext.multipart.ContentDisposition cd = attachment.getContentDisposition();
				if (null != cd && partName.equals(cd.getParameter("name"))) {
					return attachment;
				}
			}
			if (optional) {
				return null;
			}
			// unexpected
			throw new jakarta.ws.rs.InternalServerErrorException();
		}
	}

	@jakarta.ws.rs.ext.Provider
	@jakarta.ws.rs.container.PreMatching
	@jakarta.annotation.Priority(1)
	public class RequestCounterFilter implements jakarta.ws.rs.container.ContainerRequestFilter {

		@Override
		public void filter(jakarta.ws.rs.container.ContainerRequestContext requestContext) throws java.io.IOException {
			try {
				org.talend.metrics.DataReadTracker.incrementEventCounter();
			} catch (Exception | NoClassDefFoundError e) {
				// ignore
			}
		}
	}

	public static class ExceptionMapper4TalendJobRestService
			extends org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper {

		@jakarta.ws.rs.core.Context
		private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

		private RestServiceProviderImpl4TalendJob provider;

		public ExceptionMapper4TalendJobRestService(RestServiceProviderImpl4TalendJob provider) {
			this.provider = provider;
		}

		public jakarta.ws.rs.core.Response toResponse(jakarta.ws.rs.WebApplicationException ex) {
			String error = null;
			jakarta.ws.rs.core.Response response = ex.getResponse();
			if (null != response && null != response.getEntity()) {
				error = response.getEntity().toString();
			}
			response = super.toResponse(ex);
			if (null == error) {
				if (null != response && null != response.getEntity()) {
					error = response.getEntity().toString();
				} else {
					error = null == ex.getCause() ? ex.getMessage() : ex.getCause().getMessage();
				}
			}
			response = provider.handleWrongRequest(messageContext, response.getStatus(), error);

			java.util.List<jakarta.ws.rs.core.MediaType> accepts = messageContext.getHttpHeaders()
					.getAcceptableMediaTypes();
			jakarta.ws.rs.core.MediaType responseType = accepts.isEmpty() ? null : accepts.get(0);

			if (responseType == null
					|| !responseType.getSubtype().equals("xml") && !responseType.getSubtype().equals("json")) {
				responseType = jakarta.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
			}

			jakarta.ws.rs.core.Response r = jakarta.ws.rs.core.Response.status(response.getStatus())
					.entity(response.getEntity()).type(responseType).build();

			if (response.getHeaders() != null) {
				r.getHeaders().putAll(response.getHeaders());
			}

			return r;
		}
	}

	protected String checkEndpointUrl(String url) {

		final String defaultEndpointUrl = "http://127.0.0.1:8090/";

		String endpointUrl = url;
		if (null == endpointUrl || endpointUrl.trim().isEmpty()) {
			endpointUrl = defaultEndpointUrl;
		} else if (!endpointUrl.contains("://")) { // relative
			if (endpointUrl.startsWith("/")) {
				endpointUrl = endpointUrl.substring(1);
			}
			endpointUrl = defaultEndpointUrl + endpointUrl;
		}

		// test for busy
		java.net.URI endpointURI = java.net.URI.create(endpointUrl);
		String host = endpointURI.getHost();
		try {
			if (java.net.InetAddress.getByName(host).isLoopbackAddress()) {
				int port = endpointURI.getPort();
				java.net.ServerSocket ss = null;
				try {
					ss = new java.net.ServerSocket(port);
				} catch (IOException e) {
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} finally {
					if (ss != null) {
						try {
							ss.close();
						} catch (IOException e) {
							// ignore
						}
					}
				}
				try {
					// ok, let's doublecheck for silent listeners
					java.net.Socket cs = new java.net.Socket(host, port);
					// if succeed - somebody silently listening, fail!
					cs.close();
					// rethrow exception
					throw new IllegalArgumentException(
							"Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
				} catch (IOException e) {
					// ok, nobody listens, proceed
				}
			}
		} catch (java.net.UnknownHostException e) {
			// ignore
		}

		return endpointUrl;
	}

	private String evaluateURL(String url) {
		if (url != null && !url.trim().isEmpty() && url.contains("://")) {
			return url;
		}

		if (!url.startsWith("/")) {
			url = "/" + url;
		}

		String servletContextPath = System.getProperty("microservice.server.servlet.context-path");
		String protocol = System.getProperty("microservice.server.protocol");
		String host = System.getProperty("microservice.server.host");
		String port = System.getProperty("microservice.server.port");
		String address = String.format("%s://%s:%s", (null != protocol && !protocol.isEmpty()) ? protocol : "http",
				(null != host && !host.isEmpty()) ? host : "localhost",
				(null != port && !port.isEmpty()) ? port : "8090");

		if (null != servletContextPath && servletContextPath.endsWith("/") && null != url && url.startsWith("/")) {
			servletContextPath = servletContextPath.substring(0, servletContextPath.length() - 1);
		}

		return address + (null != servletContextPath ? servletContextPath : "") + (null != url ? url : "");
	}

	public static class StreamingDOM4JProvider extends org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider {

		public static final String SUPRESS_XML_DECLARATION = "supress.xml.declaration";

		private java.util.Map<String, Object> globalMap = null;

		public void setGlobalMap(java.util.Map<String, Object> globalMap) {
			this.globalMap = globalMap;
		}

		public void writeTo(org.dom4j.Document doc, Class<?> cls, java.lang.reflect.Type type,
				java.lang.annotation.Annotation[] anns, jakarta.ws.rs.core.MediaType mt,
				jakarta.ws.rs.core.MultivaluedMap<String, Object> headers, java.io.OutputStream os)
				throws java.io.IOException, jakarta.ws.rs.WebApplicationException {
			if (mt.getSubtype().contains("xml")) {
				org.dom4j.io.XMLWriter writer;
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = (org.apache.cxf.message.Message) ((java.util.Map<String, Object>) globalMap
							.get("restRequest")).get("CURRENT_MESSAGE");
				}

				if (currentMessage != null && currentMessage.getExchange() != null
						&& currentMessage.getExchange().containsKey(SUPRESS_XML_DECLARATION)) {
					org.dom4j.io.OutputFormat format = new org.dom4j.io.OutputFormat();
					format.setSuppressDeclaration(true);
					writer = new org.dom4j.io.XMLWriter(os, format);
				} else {
					writer = new org.dom4j.io.XMLWriter(os);
				}
				writer.write(doc);
				writer.flush();
			} else {
				super.writeTo(doc, cls, type, anns, mt, headers, os);
			}
		}
	}

	Thread4RestServiceProviderEndpoint thread4RestServiceProviderEndpoint = null;

	class Thread4RestServiceProviderEndpoint extends Thread {

		private final String endpointUrl;

		private final Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request job,
				String endpointUrl) {
			this.job = job;
			this.endpointUrl = endpointUrl;
			this.sf = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();
		}

		boolean inOSGi = routines.system.BundleUtils.inOSGi();

		public org.apache.cxf.endpoint.Server getServer() {
			return server;
		}

		public org.apache.cxf.jaxrs.JAXRSServerFactoryBean getJAXRSServerFactoryBean() {
			return sf;
		}

		public void run() {

			try {
				RestServiceProviderImpl4TalendJob provider = new RestServiceProviderImpl4TalendJob(job);

				if (sf.getProperties() == null) {
					sf.setProperties(new java.util.HashMap<String, Object>());
				}

				java.util.List<Object> providers = (java.util.List<Object>) sf.getProviders();
				providers.add(new RequestCounterFilter());
				providers.add(new ExceptionMapper4TalendJobRestService(provider));
				providers.add(new StreamingDOM4JProvider());

				org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
				jsonProvider.setIgnoreNamespaces(true);

				jsonProvider.setAttributesToElements(true);

				jsonProvider.setConvertTypesToStrings(false);

				providers.add(jsonProvider);

				sf.setProviders(providers);
				sf.setTransportId("http://cxf.apache.org/transports/http");
				sf.setResourceClasses(RestServiceProviderImpl4TalendJob.class);
				sf.setResourceProvider(RestServiceProviderImpl4TalendJob.class,
						new org.apache.cxf.jaxrs.lifecycle.SingletonResourceProvider(provider));

				sf.setAddress(endpointUrl);

				final java.util.List<org.apache.cxf.feature.Feature> features = sf.getFeatures() == null
						? new java.util.ArrayList<org.apache.cxf.feature.Feature>()
						: sf.getFeatures();

				sf.setFeatures(features);

				server = sf.create();

				// System.out.println("REST service [endpoint: " + endpointUrl + "] published");
			} catch (Throwable e) {
				e.printStackTrace();
			}
		}

		public void stopEndpoint() {
			if (null != server) {
				server.stop();
				server.destroy();
				// System.out.println("REST service [endpoint: " + endpointUrl + "]
				// unpublished");
			}
		}
	}

	public static class ContextBean {
		static String evaluate(String context, String contextExpression, String jobName)
				throws IOException, javax.script.ScriptException {
			String currentContext = context;
			String jobNameStripped = jobName.substring(jobName.lastIndexOf(".") + 1);

			boolean inOSGi = routines.system.BundleUtils.inOSGi();
			java.util.Dictionary<String, Object> jobProperties = null;
			if (inOSGi) {
				jobProperties = routines.system.BundleUtils.getJobProperties(jobNameStripped);

				if (jobProperties != null && null != jobProperties.get("context")) {
					currentContext = (String) jobProperties.get("context");
				}
			}

			boolean isExpression = contextExpression.contains("+") || contextExpression.contains("(");
			final String prefix = isExpression ? "\"" : "";
			java.util.Properties defaultProps = new java.util.Properties();
			java.io.InputStream inContext = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.class
					.getClassLoader().getResourceAsStream(
							"dpdp/batch_stewardship_withdraw_customers_accepting_delete_request_0_2/contexts/"
									+ currentContext + ".properties");
			if (inContext == null) {
				inContext = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + currentContext + ".properties");
			}
			try {
				defaultProps.load(inContext);
				if (jobProperties != null) {
					java.util.Enumeration<String> keys = jobProperties.keys();
					while (keys.hasMoreElements()) {
						String propKey = keys.nextElement();
						if (defaultProps.containsKey(propKey)) {
							defaultProps.put(propKey, (String) jobProperties.get(propKey));
						}
					}
				}
			} finally {
				inContext.close();
			}
			java.util.regex.Pattern pattern = java.util.regex.Pattern.compile("context.([\\w]+)");
			java.util.regex.Matcher matcher = pattern.matcher(contextExpression);

			while (matcher.find()) {
				contextExpression = contextExpression.replaceAll(matcher.group(0),
						prefix + defaultProps.getProperty(matcher.group(1)) + prefix);
			}
			if (contextExpression.startsWith("/services")) {
				contextExpression = contextExpression.replaceFirst("/services", "");
			}
			return isExpression ? evaluateContextExpression(contextExpression) : contextExpression;
		}

		public static String evaluateContextExpression(String expression) throws RuntimeException {
			delight.rhinosandox.RhinoSandbox sandbox = delight.rhinosandox.RhinoSandboxes.create();

			// Add some import for Java
			expression = expression.replaceAll("System.getProperty", "java.lang.System.getProperty");
			return sandbox.eval(null, expression).toString();
		}

		public static String getContext(String context, String contextName, String jobName) throws Exception {
			return contextName.contains("context.") ? evaluate(context, contextName, jobName) : contextName;
		}
	}

	public static class row5Struct implements routines.system.IPersistableRow<row5Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return 255;
		}

		public Integer keyPrecision() {
			return 0;
		}

		public String keyDefault() {

			return "";

		}

		public String keyComment() {

			return null;

		}

		public String keyPattern() {

			return null;

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return 255;
		}

		public Integer valuePrecision() {
			return 0;
		}

		public String valueDefault() {

			return "";

		}

		public String valueComment() {

			return null;

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row5Struct other) {

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

	public static class copyOfsetTokenStruct implements routines.system.IPersistableRow<copyOfsetTokenStruct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return 255;
		}

		public Integer keyPrecision() {
			return 0;
		}

		public String keyDefault() {

			return null;

		}

		public String keyComment() {

			return null;

		}

		public String keyPattern() {

			return null;

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return 255;
		}

		public Integer valuePrecision() {
			return 0;
		}

		public String valueDefault() {

			return null;

		}

		public String valueComment() {

			return null;

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfsetTokenStruct other) {

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

	public static class OnRowsEndStructtXMLMap_4 implements routines.system.IPersistableRow<OnRowsEndStructtXMLMap_4> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return 255;
		}

		public Integer keyPrecision() {
			return 0;
		}

		public String keyDefault() {

			return null;

		}

		public String keyComment() {

			return null;

		}

		public String keyPattern() {

			return null;

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return 255;
		}

		public Integer valuePrecision() {
			return 0;
		}

		public String valueDefault() {

			return null;

		}

		public String valueComment() {

			return null;

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OnRowsEndStructtXMLMap_4 other) {

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

	public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public Integer statusCode;

		public Integer getStatusCode() {
			return this.statusCode;
		}

		public Boolean statusCodeIsNullable() {
			return true;
		}

		public Boolean statusCodeIsKey() {
			return false;
		}

		public Integer statusCodeLength() {
			return 0;
		}

		public Integer statusCodePrecision() {
			return 0;
		}

		public String statusCodeDefault() {

			return "";

		}

		public String statusCodeComment() {

			return null;

		}

		public String statusCodePattern() {

			return null;

		}

		public String statusCodeOriginalDbColumnName() {

			return "statusCode";

		}

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public Boolean bodyIsNullable() {
			return true;
		}

		public Boolean bodyIsKey() {
			return false;
		}

		public Integer bodyLength() {
			return 0;
		}

		public Integer bodyPrecision() {
			return 0;
		}

		public String bodyDefault() {

			return "";

		}

		public String bodyComment() {

			return null;

		}

		public String bodyPattern() {

			return null;

		}

		public String bodyOriginalDbColumnName() {

			return "body";

		}

		public String string;

		public String getString() {
			return this.string;
		}

		public Boolean stringIsNullable() {
			return true;
		}

		public Boolean stringIsKey() {
			return false;
		}

		public Integer stringLength() {
			return 4048;
		}

		public Integer stringPrecision() {
			return 0;
		}

		public String stringDefault() {

			return null;

		}

		public String stringComment() {

			return null;

		}

		public String stringPattern() {

			return null;

		}

		public String stringOriginalDbColumnName() {

			return "string";

		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.clearInstanceCache();
				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("statusCode=" + String.valueOf(statusCode));
			sb.append(",body=" + String.valueOf(body));
			sb.append(",string=" + string);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (statusCode == null) {
				sb.append("<null>");
			} else {
				sb.append(statusCode);
			}

			sb.append("|");

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			if (string == null) {
				sb.append("<null>");
			} else {
				sb.append(string);
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

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public Boolean bodyIsNullable() {
			return true;
		}

		public Boolean bodyIsKey() {
			return false;
		}

		public Integer bodyLength() {
			return 0;
		}

		public Integer bodyPrecision() {
			return 0;
		}

		public String bodyDefault() {

			return "";

		}

		public String bodyComment() {

			return null;

		}

		public String bodyPattern() {

			return null;

		}

		public String bodyOriginalDbColumnName() {

			return "body";

		}

		public String string;

		public String getString() {
			return this.string;
		}

		public Boolean stringIsNullable() {
			return true;
		}

		public Boolean stringIsKey() {
			return false;
		}

		public Integer stringLength() {
			return 4048;
		}

		public Integer stringPrecision() {
			return 0;
		}

		public String stringDefault() {

			return null;

		}

		public String stringComment() {

			return null;

		}

		public String stringPattern() {

			return null;

		}

		public String stringOriginalDbColumnName() {

			return "string";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Document

				dos.clearInstanceCache();
				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append(",string=" + string);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			if (string == null) {
				sb.append("<null>");
			} else {
				sb.append(string);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row2Struct other) {

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

	public void tFixedFlowInput_2Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tFixedFlowInput_2", "UvC3r1_");

		String currentVirtualComponent = null;

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

				row2Struct row2 = new row2Struct();
				row1Struct row1 = new row1Struct();
				copyOfsetTokenStruct copyOfsetToken = new copyOfsetTokenStruct();
				copyOfsetTokenStruct row5 = copyOfsetToken;

				/**
				 * [tXMLMap_4_TXMLMAP_OUT begin ] start
				 */

				sh("tXMLMap_4_TXMLMAP_OUT");

				currentVirtualComponent = "tXMLMap_4";

				s(currentComponent = "tXMLMap_4_TXMLMAP_OUT");

				cLabel = "ParseAuthResponse_TXMLMAP_OUT";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tXMLMap_4_TXMLMAP_OUT = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_4_TXMLMAP_OUT - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_4_TXMLMAP_OUT {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_4_TXMLMAP_OUT = new StringBuilder();
							log4jParamters_tXMLMap_4_TXMLMAP_OUT.append("Parameters:");
							log4jParamters_tXMLMap_4_TXMLMAP_OUT.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_4_TXMLMAP_OUT.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_4_TXMLMAP_OUT - " + (log4jParamters_tXMLMap_4_TXMLMAP_OUT));
						}
					}
					new BytesLimit65535_tXMLMap_4_TXMLMAP_OUT().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tXMLMap_4_TXMLMAP_OUT", "ParseAuthResponse_TXMLMAP_OUT", "tXMLMapOut");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

//===============================input xml init part===============================
				class XML_API_tXMLMap_4_TXMLMAP_OUT {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}
				class Var__tXMLMap_4_TXMLMAP_OUT__Struct {
				}
				Var__tXMLMap_4_TXMLMAP_OUT__Struct Var__tXMLMap_4_TXMLMAP_OUT = new Var__tXMLMap_4_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
				copyOfsetTokenStruct copyOfsetToken_tmp = new copyOfsetTokenStruct();
				copyOfsetTokenStruct copyOfsetToken_save = null;
//the aggregate variable
				copyOfsetTokenStruct copyOfsetToken_aggregate = null;
				int count_copyOfsetToken_tXMLMap_4_TXMLMAP_OUT = 0;
//init the resultset for aggregate
				java.util.List<Object> allOutsForAggregate_tXMLMap_4 = new java.util.ArrayList<Object>();
				globalMap.put("allOutsForAggregate_tXMLMap_4", allOutsForAggregate_tXMLMap_4);
// ###############################
				class TreeNode_API_tXMLMap_4_TXMLMAP_OUT {
					java.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();

					void clear() {
						xpath_value_map.clear();
					}

					void put(String xpath, String value) {
						xpath_value_map.put(xpath, value);
					}

					String get_null(String xpath) {
						return null;
					}

					String get_String(String xpath) {
						return xpath_value_map.get(xpath);
					}
				}
				TreeNode_API_tXMLMap_4_TXMLMAP_OUT treeNodeAPI_tXMLMap_4_TXMLMAP_OUT = new TreeNode_API_tXMLMap_4_TXMLMAP_OUT();
				NameSpaceTool nsTool_tXMLMap_4_TXMLMAP_OUT = new NameSpaceTool();
				int nb_line_tXMLMap_4_TXMLMAP_OUT = 0;

				XML_API_tXMLMap_4_TXMLMAP_OUT xml_api_tXMLMap_4_TXMLMAP_OUT = new XML_API_tXMLMap_4_TXMLMAP_OUT();

				// the map store the previous value of aggregate columns
				java.util.Map<String, Object> aggregateCacheMap_tXMLMap_4_TXMLMAP_OUT = new java.util.HashMap<String, Object>();

				/**
				 * [tXMLMap_4_TXMLMAP_OUT begin ] stop
				 */

				/**
				 * [tRESTClient_4 begin ] start
				 */

				sh("tRESTClient_4");

				s(currentComponent = "tRESTClient_4");

				cLabel = "GetAuthToken";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tRESTClient_4 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTClient_4", "GetAuthToken", "tRESTClient");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tRESTClient_4 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_2 begin ] start
				 */

				sh("tFixedFlowInput_2");

				s(currentComponent = "tFixedFlowInput_2");

				cLabel = "DefineInput";

				int tos_count_tFixedFlowInput_2 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tFixedFlowInput_2", "DefineInput", "tFixedFlowInput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				for (int i_tFixedFlowInput_2 = 0; i_tFixedFlowInput_2 < 1; i_tFixedFlowInput_2++) {

					row2.body = null;

					row2.string = "{\"user\":\"Pranita\",\"password\":\"Predoole@2025\"}";

					/**
					 * [tFixedFlowInput_2 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_2 main ] start
					 */

					s(currentComponent = "tFixedFlowInput_2");

					cLabel = "DefineInput";

					tos_count_tFixedFlowInput_2++;

					/**
					 * [tFixedFlowInput_2 main ] stop
					 */

					/**
					 * [tFixedFlowInput_2 process_data_begin ] start
					 */

					s(currentComponent = "tFixedFlowInput_2");

					cLabel = "DefineInput";

					/**
					 * [tFixedFlowInput_2 process_data_begin ] stop
					 */

					/**
					 * [tRESTClient_4 main ] start
					 */

					s(currentComponent = "tRESTClient_4");

					cLabel = "GetAuthToken";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row2", "tFixedFlowInput_2", "DefineInput", "tFixedFlowInput", "tRESTClient_4",
							"GetAuthToken", "tRESTClient"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
					}

					row1 = null;

// expected response body
					jakarta.ws.rs.core.Response responseDoc_tRESTClient_4 = null;

					try {
						// request body
						org.dom4j.Document requestDoc_tRESTClient_4 = null;
						String requestString_tRESTClient_4 = null;
						if (null != row2.body) {
							requestDoc_tRESTClient_4 = row2.body.getDocument();
						}
						requestString_tRESTClient_4 = row2.string;

						Object requestBody_tRESTClient_4 = requestDoc_tRESTClient_4 != null ? requestDoc_tRESTClient_4
								: requestString_tRESTClient_4;

						// resposne class name
						Class<?> responseClass_tRESTClient_4 = org.dom4j.Document.class;

						// create web client instance
						org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_4 = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

						boolean inOSGi = routines.system.BundleUtils.inOSGi();

						final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_4 = new java.util.ArrayList<org.apache.cxf.feature.Feature>();

						String url = null;

						url = "http://192.168.1.253:11480/MM/rest/v1/auth/login";
						// {baseUri}tRESTClient
						factoryBean_tRESTClient_4.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
						factoryBean_tRESTClient_4.setAddress(url);

						boolean log_messages_tRESTClient_4 = Boolean.valueOf(false);
						if (log_messages_tRESTClient_4) {
							org.apache.cxf.ext.logging.LoggingFeature loggingFeature = new org.apache.cxf.ext.logging.LoggingFeature();
							loggingFeature.addSensitiveProtocolHeaderNames(new java.util.HashSet<>(
									java.util.Arrays.asList(org.apache.cxf.helpers.HttpHeaderHelper.AUTHORIZATION)));
							loggingFeature.addSensitiveElementNames(
									new java.util.HashSet<>(java.util.Arrays.asList("password")));
							features_tRESTClient_4.add(loggingFeature);
						}

						factoryBean_tRESTClient_4.setFeatures(features_tRESTClient_4);

						java.util.List<Object> providers_tRESTClient_4 = new java.util.ArrayList<Object>();
						providers_tRESTClient_4.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
							// workaround for https://jira.talendforge.org/browse/TESB-7276
							public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls,
									java.lang.reflect.Type type, java.lang.annotation.Annotation[] anns,
									jakarta.ws.rs.core.MediaType mt,
									jakarta.ws.rs.core.MultivaluedMap<String, String> headers, java.io.InputStream is)
									throws IOException, jakarta.ws.rs.WebApplicationException {
								String contentLength = headers.getFirst("Content-Length");
								if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)
										&& Integer.valueOf(contentLength) <= 0) {
									try {
										return org.dom4j.DocumentHelper.parseText("<root/>");
									} catch (org.dom4j.DocumentException e_tRESTClient_4) {
										e_tRESTClient_4.printStackTrace();
									}
									return null;
								}
								return super.readFrom(cls, type, anns, mt, headers, is);
							}
						});
						org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_4 = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
						jsonProvider_tRESTClient_4.setIgnoreNamespaces(true);
						jsonProvider_tRESTClient_4.setAttributesToElements(true);

						jsonProvider_tRESTClient_4.setSerializeAsArray(true);
						List<String> arrayKeys = new java.util.ArrayList<String>(
								java.util.Arrays.asList("".split(" ")));
						jsonProvider_tRESTClient_4.setArrayKeys(arrayKeys);

						jsonProvider_tRESTClient_4.setSupportUnwrapped(true);
						jsonProvider_tRESTClient_4.setWrapperName("root");

						jsonProvider_tRESTClient_4.setDropRootElement(false);
						jsonProvider_tRESTClient_4.setConvertTypesToStrings(false);
						providers_tRESTClient_4.add(jsonProvider_tRESTClient_4);
						factoryBean_tRESTClient_4.setProviders(providers_tRESTClient_4);
						factoryBean_tRESTClient_4.setTransportId("http://cxf.apache.org/transports/http");

						boolean use_auth_tRESTClient_4 = false;

						org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_4 = null;

						webClient_tRESTClient_4 = factoryBean_tRESTClient_4.createWebClient();
						// set request path
						webClient_tRESTClient_4.path("");

						// set connection properties
						org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_4 = org.apache.cxf.jaxrs.client.WebClient
								.getConfig(webClient_tRESTClient_4);
						org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
						org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_4 = null;

						conduit_tRESTClient_4 = clientConfig_tRESTClient_4.getHttpConduit();

						if (clientConfig_tRESTClient_4.getEndpoint() != null) {
							org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_4 = clientConfig_tRESTClient_4
									.getEndpoint().getEndpointInfo();
							if (endpointInfo_tRESTClient_4 != null) {
								endpointInfo_tRESTClient_4.setProperty("enable.webclient.operation.reporting", true);
							}
						}

						if (!inOSGi) {
							conduit_tRESTClient_4.getClient().setReceiveTimeout((long) (60 * 1000L));
							conduit_tRESTClient_4.getClient().setConnectionTimeout((long) (30 * 1000L));
						}

						// set Content-Type
						webClient_tRESTClient_4.type("application/json");

						// set Accept-Type
						webClient_tRESTClient_4.accept("application/json");

						// set optional query and header properties if any

						if (use_auth_tRESTClient_4 && "OAUTH2_BEARER".equals("BASIC")) {
							// set oAuth2 bearer token
							org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
							authSupplier.setAccessToken((String) "");
							conduit_tRESTClient_4.setAuthSupplier(authSupplier);
						}

						// if FORM request then capture query parameters into Form, otherwise set them
						// as queries

						webClient_tRESTClient_4.query("forceLogin", "true");

						try {
							// start send request

							responseDoc_tRESTClient_4 = webClient_tRESTClient_4.post(requestBody_tRESTClient_4);

							int webClientResponseStatus_tRESTClient_4 = webClient_tRESTClient_4.getResponse()
									.getStatus();
							if (webClientResponseStatus_tRESTClient_4 >= 300) {
								throw new jakarta.ws.rs.WebApplicationException(webClient_tRESTClient_4.getResponse());
							}

							if (row1 == null) {
								row1 = new row1Struct();
							}

							row1.statusCode = webClientResponseStatus_tRESTClient_4;
							row1.string = "";

							Object responseObj_tRESTClient_4 = null;
							if (responseDoc_tRESTClient_4 != null && responseDoc_tRESTClient_4.hasEntity()) {
								responseObj_tRESTClient_4 = responseDoc_tRESTClient_4
										.readEntity(responseClass_tRESTClient_4);

								if (responseObj_tRESTClient_4 != null) {
									if (responseClass_tRESTClient_4 == String.class
											&& responseObj_tRESTClient_4 instanceof String) {
										row1.string = (String) responseObj_tRESTClient_4;
									} else {
										routines.system.Document responseTalendDoc_tRESTClient_4 = null;
										if (null != responseObj_tRESTClient_4) {
											responseTalendDoc_tRESTClient_4 = new routines.system.Document();
											if (responseObj_tRESTClient_4 instanceof org.dom4j.Document) {
												responseTalendDoc_tRESTClient_4
														.setDocument((org.dom4j.Document) responseObj_tRESTClient_4);
											}
										}
										row1.body = responseTalendDoc_tRESTClient_4;
									}
								}
							}

							java.util.Map<String, jakarta.ws.rs.core.NewCookie> cookies_tRESTClient_4 = new java.util.HashMap<String, jakarta.ws.rs.core.NewCookie>();

							if (webClient_tRESTClient_4.getResponse() != null
									&& webClient_tRESTClient_4.getResponse().getCookies() != null) {
								cookies_tRESTClient_4.putAll(webClient_tRESTClient_4.getResponse().getCookies());
							}

							globalMap.put("tRESTClient_4_HEADERS", webClient_tRESTClient_4.getResponse().getHeaders());
							globalMap.put("tRESTClient_4_COOKIES", cookies_tRESTClient_4);

						} catch (jakarta.ws.rs.WebApplicationException ex_tRESTClient_4) {
							globalMap.put("tRESTClient_4_ERROR_MESSAGE", ex_tRESTClient_4.getMessage());

							throw ex_tRESTClient_4;

						}

					} catch (Exception e_tRESTClient_4) {
						globalMap.put("tRESTClient_4_ERROR_MESSAGE", e_tRESTClient_4.getMessage());

						throw new TalendException(e_tRESTClient_4, currentComponent, globalMap);

					}

					tos_count_tRESTClient_4++;

					/**
					 * [tRESTClient_4 main ] stop
					 */

					/**
					 * [tRESTClient_4 process_data_begin ] start
					 */

					s(currentComponent = "tRESTClient_4");

					cLabel = "GetAuthToken";

					/**
					 * [tRESTClient_4 process_data_begin ] stop
					 */

// Start of branch "row1"
					if (row1 != null) {

						/**
						 * [tXMLMap_4_TXMLMAP_OUT main ] start
						 */

						currentVirtualComponent = "tXMLMap_4";

						s(currentComponent = "tXMLMap_4_TXMLMAP_OUT");

						cLabel = "ParseAuthResponse_TXMLMAP_OUT";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tRESTClient_4", "GetAuthToken", "tRESTClient", "tXMLMap_4_TXMLMAP_OUT",
								"ParseAuthResponse_TXMLMAP_OUT", "tXMLMapOut"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						boolean rejectedInnerJoin_tXMLMap_4_TXMLMAP_OUT = false;
						boolean rejectedDocInnerJoin_tXMLMap_4_TXMLMAP_OUT = false;
						boolean mainRowRejected_tXMLMap_4_TXMLMAP_OUT = false;
						boolean isMatchDocRowtXMLMap_4_TXMLMAP_OUT = false;

						// init document to flat tool
						routines.system.DocumentToFlat docToFlat_tXMLMap_4_TXMLMAP_OUT = new routines.system.DocumentToFlat();
						docToFlat_tXMLMap_4_TXMLMAP_OUT.setOriginalLoop("/root/result");
						docToFlat_tXMLMap_4_TXMLMAP_OUT.setIsOptional(false);
						if (row1.body == null || row1.body.getDocument() == null) {
							throw new RuntimeException("row1.body can't be empty");
						}
						org.dom4j.Document doc_tXMLMap_4_TXMLMAP_OUT = row1.body.getDocument();
						docToFlat_tXMLMap_4_TXMLMAP_OUT.setDoc(doc_tXMLMap_4_TXMLMAP_OUT);
						docToFlat_tXMLMap_4_TXMLMAP_OUT.setDefineNS(false);
						docToFlat_tXMLMap_4_TXMLMAP_OUT.setNamespaceTool(nsTool_tXMLMap_4_TXMLMAP_OUT);

						// old version, find NS from doc
						nsTool_tXMLMap_4_TXMLMAP_OUT.countNSMap(doc_tXMLMap_4_TXMLMAP_OUT.getRootElement());
						java.util.HashMap<String, String> xmlNameSpaceMap_tXMLMap_4_TXMLMAP_OUT = nsTool_tXMLMap_4_TXMLMAP_OUT.xmlNameSpaceMap;

						docToFlat_tXMLMap_4_TXMLMAP_OUT.setXmlNameSpaceMap(xmlNameSpaceMap_tXMLMap_4_TXMLMAP_OUT);

						String[] absolutePathMappings_tXMLMap_4_TXMLMAP_OUT = new String[1];
						String[] relativePathMappings_tXMLMap_4_TXMLMAP_OUT = new String[1];

						absolutePathMappings_tXMLMap_4_TXMLMAP_OUT[0] = "row1.body:/root/result/token";
						relativePathMappings_tXMLMap_4_TXMLMAP_OUT[0] = "token";

						docToFlat_tXMLMap_4_TXMLMAP_OUT
								.setAbsolutePathMappings(absolutePathMappings_tXMLMap_4_TXMLMAP_OUT);
						docToFlat_tXMLMap_4_TXMLMAP_OUT
								.setCurrentRelativePathMappings(relativePathMappings_tXMLMap_4_TXMLMAP_OUT);
						// generate document to flat data
						docToFlat_tXMLMap_4_TXMLMAP_OUT.flat();
						// get flat data
						java.util.List<java.util.Map<String, String>> resultSet_tXMLMap_4_TXMLMAP_OUT = docToFlat_tXMLMap_4_TXMLMAP_OUT
								.getResultSet();

						for (java.util.Map<String, String> oneRow_tXMLMap_4_TXMLMAP_OUT : resultSet_tXMLMap_4_TXMLMAP_OUT) { // G_TXM_M_001
							nb_line_tXMLMap_4_TXMLMAP_OUT++;
							rejectedInnerJoin_tXMLMap_4_TXMLMAP_OUT = false;
							rejectedDocInnerJoin_tXMLMap_4_TXMLMAP_OUT = false;
							mainRowRejected_tXMLMap_4_TXMLMAP_OUT = false;
							isMatchDocRowtXMLMap_4_TXMLMAP_OUT = false;

							treeNodeAPI_tXMLMap_4_TXMLMAP_OUT.clear();
							for (java.util.Map.Entry<String, String> entry_tXMLMap_4_TXMLMAP_OUT : oneRow_tXMLMap_4_TXMLMAP_OUT
									.entrySet()) {
								treeNodeAPI_tXMLMap_4_TXMLMAP_OUT.put(entry_tXMLMap_4_TXMLMAP_OUT.getKey(),
										entry_tXMLMap_4_TXMLMAP_OUT.getValue());
							}

							{ // start of Var scope

								// ###############################
								// # Vars tables

								Var__tXMLMap_4_TXMLMAP_OUT__Struct Var = Var__tXMLMap_4_TXMLMAP_OUT;
								// ###############################
								// # Output tables

								copyOfsetToken = null;

// # Output table : 'copyOfsetToken'
								count_copyOfsetToken_tXMLMap_4_TXMLMAP_OUT++;

								copyOfsetToken_tmp = new copyOfsetTokenStruct();
								copyOfsetToken_tmp.key = "token";
								copyOfsetToken_tmp.value = treeNodeAPI_tXMLMap_4_TXMLMAP_OUT
										.get_String("row1.body:/root/result/token");
								allOutsForAggregate_tXMLMap_4.add(copyOfsetToken_tmp);

								log.debug("tXMLMap_4 - Outputting the record "
										+ count_copyOfsetToken_tXMLMap_4_TXMLMAP_OUT
										+ " of the output table 'copyOfsetToken'.");

// ###############################

							} // end of Var scope

							rejectedInnerJoin_tXMLMap_4_TXMLMAP_OUT = false;

						} // G_TXM_M_001 close

						tos_count_tXMLMap_4_TXMLMAP_OUT++;

						/**
						 * [tXMLMap_4_TXMLMAP_OUT main ] stop
						 */

						/**
						 * [tXMLMap_4_TXMLMAP_OUT process_data_begin ] start
						 */

						currentVirtualComponent = "tXMLMap_4";

						s(currentComponent = "tXMLMap_4_TXMLMAP_OUT");

						cLabel = "ParseAuthResponse_TXMLMAP_OUT";

						/**
						 * [tXMLMap_4_TXMLMAP_OUT process_data_begin ] stop
						 */

						/**
						 * [tXMLMap_4_TXMLMAP_OUT process_data_end ] start
						 */

						currentVirtualComponent = "tXMLMap_4";

						s(currentComponent = "tXMLMap_4_TXMLMAP_OUT");

						cLabel = "ParseAuthResponse_TXMLMAP_OUT";

						/**
						 * [tXMLMap_4_TXMLMAP_OUT process_data_end ] stop
						 */

					} // End of branch "row1"

					/**
					 * [tRESTClient_4 process_data_end ] start
					 */

					s(currentComponent = "tRESTClient_4");

					cLabel = "GetAuthToken";

					/**
					 * [tRESTClient_4 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_2 process_data_end ] start
					 */

					s(currentComponent = "tFixedFlowInput_2");

					cLabel = "DefineInput";

					/**
					 * [tFixedFlowInput_2 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_2 end ] start
					 */

					s(currentComponent = "tFixedFlowInput_2");

					cLabel = "DefineInput";

				}
				globalMap.put("tFixedFlowInput_2_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_2", true);
				end_Hash.put("tFixedFlowInput_2", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_2 end ] stop
				 */

				/**
				 * [tRESTClient_4 end ] start
				 */

				s(currentComponent = "tRESTClient_4");

				cLabel = "GetAuthToken";

				if (globalMap.get("tRESTClient_4_NB_LINE") == null) {
					globalMap.put("tRESTClient_4_NB_LINE", 1);
				}

// [tRESTCliend_end]
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tFixedFlowInput_2", "DefineInput", "tFixedFlowInput", "tRESTClient_4", "GetAuthToken",
						"tRESTClient", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tRESTClient_4", true);
				end_Hash.put("tRESTClient_4", System.currentTimeMillis());

				/**
				 * [tRESTClient_4 end ] stop
				 */

				/**
				 * [tXMLMap_4_TXMLMAP_OUT end ] start
				 */

				currentVirtualComponent = "tXMLMap_4";

				s(currentComponent = "tXMLMap_4_TXMLMAP_OUT");

				cLabel = "ParseAuthResponse_TXMLMAP_OUT";

				log.debug("tXMLMap_4 - Written records count in the table 'copyOfsetToken': "
						+ count_copyOfsetToken_tXMLMap_4_TXMLMAP_OUT + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tRESTClient_4", "GetAuthToken", "tRESTClient", "tXMLMap_4_TXMLMAP_OUT",
						"ParseAuthResponse_TXMLMAP_OUT", "tXMLMapOut", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tXMLMap_4_TXMLMAP_OUT - " + ("Done."));

				ok_Hash.put("tXMLMap_4_TXMLMAP_OUT", true);
				end_Hash.put("tXMLMap_4_TXMLMAP_OUT", System.currentTimeMillis());

				/**
				 * [tXMLMap_4_TXMLMAP_OUT end ] stop
				 */

				/**
				 * [tLogRow_4 begin ] start
				 */

				sh("tLogRow_4");

				s(currentComponent = "tLogRow_4");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row5");

				int tos_count_tLogRow_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_4 = new StringBuilder();
							log4jParamters_tLogRow_4.append("Parameters:");
							log4jParamters_tLogRow_4.append("BASIC_MODE" + " = " + "true");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("PRINT_UNIQUE_NAME" + " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("PRINT_COLNAMES" + " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("USE_FIXED_LENGTH" + " = " + "false");
							log4jParamters_tLogRow_4.append(" | ");
							log4jParamters_tLogRow_4.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_4 - " + (log4jParamters_tLogRow_4));
						}
					}
					new BytesLimit65535_tLogRow_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_4", "tLogRow_4", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_4 = "|";
				java.io.PrintStream consoleOut_tLogRow_4 = null;

				StringBuilder strBuffer_tLogRow_4 = null;
				int nb_line_tLogRow_4 = 0;
///////////////////////    			

				/**
				 * [tLogRow_4 begin ] stop
				 */

				/**
				 * [tContextLoad_4 begin ] start
				 */

				sh("tContextLoad_4");

				s(currentComponent = "tContextLoad_4");

				cLabel = "LoadContextToken";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "copyOfsetToken");

				int tos_count_tContextLoad_4 = 0;

				if (log.isDebugEnabled())
					log.debug("tContextLoad_4 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tContextLoad_4 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tContextLoad_4 = new StringBuilder();
							log4jParamters_tContextLoad_4.append("Parameters:");
							log4jParamters_tContextLoad_4.append("LOAD_NEW_VARIABLE" + " = " + "Warning");
							log4jParamters_tContextLoad_4.append(" | ");
							log4jParamters_tContextLoad_4.append("NOT_LOAD_OLD_VARIABLE" + " = " + "Warning");
							log4jParamters_tContextLoad_4.append(" | ");
							log4jParamters_tContextLoad_4.append("PRINT_OPERATIONS" + " = " + "false");
							log4jParamters_tContextLoad_4.append(" | ");
							log4jParamters_tContextLoad_4.append("DISABLE_ERROR" + " = " + "false");
							log4jParamters_tContextLoad_4.append(" | ");
							log4jParamters_tContextLoad_4.append("DISABLE_WARNINGS" + " = " + "true");
							log4jParamters_tContextLoad_4.append(" | ");
							log4jParamters_tContextLoad_4.append("DISABLE_INFO" + " = " + "true");
							log4jParamters_tContextLoad_4.append(" | ");
							log4jParamters_tContextLoad_4.append("DIEONERROR" + " = " + "false");
							log4jParamters_tContextLoad_4.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tContextLoad_4 - " + (log4jParamters_tContextLoad_4));
						}
					}
					new BytesLimit65535_tContextLoad_4().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tContextLoad_4", "LoadContextToken", "tContextLoad");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.List<String> assignList_tContextLoad_4 = new java.util.ArrayList<String>();
				java.util.List<String> newPropertyList_tContextLoad_4 = new java.util.ArrayList<String>();
				java.util.List<String> noAssignList_tContextLoad_4 = new java.util.ArrayList<String>();
				int nb_line_tContextLoad_4 = 0;

				/**
				 * [tContextLoad_4 begin ] stop
				 */

				/**
				 * [tXMLMap_4_TXMLMAP_IN begin ] start
				 */

				sh("tXMLMap_4_TXMLMAP_IN");

				currentVirtualComponent = "tXMLMap_4";

				s(currentComponent = "tXMLMap_4_TXMLMAP_IN");

				cLabel = "ParseAuthResponse_TXMLMAP_IN";

				int tos_count_tXMLMap_4_TXMLMAP_IN = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_4_TXMLMAP_IN - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_4_TXMLMAP_IN {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_4_TXMLMAP_IN = new StringBuilder();
							log4jParamters_tXMLMap_4_TXMLMAP_IN.append("Parameters:");
							log4jParamters_tXMLMap_4_TXMLMAP_IN.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_4_TXMLMAP_IN.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_4_TXMLMAP_IN - " + (log4jParamters_tXMLMap_4_TXMLMAP_IN));
						}
					}
					new BytesLimit65535_tXMLMap_4_TXMLMAP_IN().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tXMLMap_4_TXMLMAP_IN", "ParseAuthResponse_TXMLMAP_IN", "tXMLMapIn");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.List<Object> outs_tXMLMap_4 = (java.util.List<Object>) globalMap
						.get("allOutsForAggregate_tXMLMap_4");
				for (Object row_out_tXMLMap_4_TXMLMAP_IN : outs_tXMLMap_4) {// TD512

					/**
					 * [tXMLMap_4_TXMLMAP_IN begin ] stop
					 */

					/**
					 * [tXMLMap_4_TXMLMAP_IN main ] start
					 */

					currentVirtualComponent = "tXMLMap_4";

					s(currentComponent = "tXMLMap_4_TXMLMAP_IN");

					cLabel = "ParseAuthResponse_TXMLMAP_IN";

					copyOfsetToken = null;
					if (row_out_tXMLMap_4_TXMLMAP_IN != null
							&& row_out_tXMLMap_4_TXMLMAP_IN instanceof copyOfsetTokenStruct) {
						copyOfsetToken = (copyOfsetTokenStruct) row_out_tXMLMap_4_TXMLMAP_IN;
					}

					tos_count_tXMLMap_4_TXMLMAP_IN++;

					/**
					 * [tXMLMap_4_TXMLMAP_IN main ] stop
					 */

					/**
					 * [tXMLMap_4_TXMLMAP_IN process_data_begin ] start
					 */

					currentVirtualComponent = "tXMLMap_4";

					s(currentComponent = "tXMLMap_4_TXMLMAP_IN");

					cLabel = "ParseAuthResponse_TXMLMAP_IN";

					/**
					 * [tXMLMap_4_TXMLMAP_IN process_data_begin ] stop
					 */

// Start of branch "copyOfsetToken"
					if (copyOfsetToken != null) {

						/**
						 * [tContextLoad_4 main ] start
						 */

						s(currentComponent = "tContextLoad_4");

						cLabel = "LoadContextToken";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "copyOfsetToken", "tXMLMap_4_TXMLMAP_IN", "ParseAuthResponse_TXMLMAP_IN", "tXMLMapIn",
								"tContextLoad_4", "LoadContextToken", "tContextLoad"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace(
									"copyOfsetToken - " + (copyOfsetToken == null ? "" : copyOfsetToken.toLogString()));
						}

						//////////////////////////
						String tmp_key_tContextLoad_4 = null;
						String key_tContextLoad_4 = null;
						if (copyOfsetToken.key != null) {
							tmp_key_tContextLoad_4 = copyOfsetToken.key.trim();
							if ((tmp_key_tContextLoad_4.startsWith("#") || tmp_key_tContextLoad_4.startsWith("!"))) {
								tmp_key_tContextLoad_4 = null;
							} else {
								copyOfsetToken.key = tmp_key_tContextLoad_4;
							}
						}
						if (copyOfsetToken.key != null) {
							key_tContextLoad_4 = copyOfsetToken.key;
						}
						String value_tContextLoad_4 = null;
						if (copyOfsetToken.value != null) {
							value_tContextLoad_4 = copyOfsetToken.value;
						}

						String currentValue_tContextLoad_4 = value_tContextLoad_4;

						if ((key_tContextLoad_4 != null) && ("Stewardship_Password".equals(key_tContextLoad_4))
								&& (currentValue_tContextLoad_4 != null))
							currentValue_tContextLoad_4 = currentValue_tContextLoad_4.replaceAll(".", "*");

						if (tmp_key_tContextLoad_4 != null) {
							try {
								if (key_tContextLoad_4 != null && "tableName".equals(key_tContextLoad_4)) {
									context.tableName = value_tContextLoad_4;
								}

								if (key_tContextLoad_4 != null && "databaseName".equals(key_tContextLoad_4)) {
									context.databaseName = value_tContextLoad_4;
								}

								if (key_tContextLoad_4 != null && "token".equals(key_tContextLoad_4)) {
									context.token = value_tContextLoad_4;
								}

								if (key_tContextLoad_4 != null && "tableId".equals(key_tContextLoad_4)) {
									context.tableId = value_tContextLoad_4;
								}

								if (key_tContextLoad_4 != null && "customerId".equals(key_tContextLoad_4)) {

									context.customerId = Integer.parseInt(value_tContextLoad_4);

								}

								if (key_tContextLoad_4 != null && "Stewardship_Password".equals(key_tContextLoad_4)) {
									context.Stewardship_Password = value_tContextLoad_4;
								}

								if (key_tContextLoad_4 != null && "Stewardship_URL".equals(key_tContextLoad_4)) {
									context.Stewardship_URL = value_tContextLoad_4;
								}

								if (key_tContextLoad_4 != null && "Stewardship_UserName".equals(key_tContextLoad_4)) {
									context.Stewardship_UserName = value_tContextLoad_4;
								}

								if (context.getProperty(key_tContextLoad_4) != null) {
									assignList_tContextLoad_4.add(key_tContextLoad_4);
								} else {
									newPropertyList_tContextLoad_4.add(key_tContextLoad_4);
								}
								if (value_tContextLoad_4 == null) {
									context.setProperty(key_tContextLoad_4, "");
								} else {
									context.setProperty(key_tContextLoad_4, value_tContextLoad_4);
								}
							} catch (java.lang.Exception e) {
								globalMap.put("tContextLoad_4_ERROR_MESSAGE", e.getMessage());
								log.error("tContextLoad_4 - Setting a value for the key \"" + key_tContextLoad_4
										+ "\" has failed. Error message: " + e.getMessage());
								System.err.println("Setting a value for the key \"" + key_tContextLoad_4
										+ "\" has failed. Error message: " + e.getMessage());
							}
							nb_line_tContextLoad_4++;
						}
						//////////////////////////

						row5 = copyOfsetToken;

						tos_count_tContextLoad_4++;

						/**
						 * [tContextLoad_4 main ] stop
						 */

						/**
						 * [tContextLoad_4 process_data_begin ] start
						 */

						s(currentComponent = "tContextLoad_4");

						cLabel = "LoadContextToken";

						/**
						 * [tContextLoad_4 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_4 main ] start
						 */

						s(currentComponent = "tLogRow_4");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row5", "tContextLoad_4", "LoadContextToken", "tContextLoad", "tLogRow_4",
								"tLogRow_4", "tLogRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row5 - " + (row5 == null ? "" : row5.toLogString()));
						}

///////////////////////		

						strBuffer_tLogRow_4 = new StringBuilder();

						if (row5.key != null) { //

							strBuffer_tLogRow_4.append(String.valueOf(row5.key));

						} //

						strBuffer_tLogRow_4.append("|");

						if (row5.value != null) { //

							strBuffer_tLogRow_4.append(String.valueOf(row5.value));

						} //

						if (globalMap.get("tLogRow_CONSOLE") != null) {
							consoleOut_tLogRow_4 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
						} else {
							consoleOut_tLogRow_4 = new java.io.PrintStream(
									new java.io.BufferedOutputStream(System.out));
							globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_4);
						}
						log.info("tLogRow_4 - Content of row " + (nb_line_tLogRow_4 + 1) + ": "
								+ strBuffer_tLogRow_4.toString());
						consoleOut_tLogRow_4.println(strBuffer_tLogRow_4.toString());
						consoleOut_tLogRow_4.flush();
						nb_line_tLogRow_4++;
//////

//////                    

///////////////////////    			

						tos_count_tLogRow_4++;

						/**
						 * [tLogRow_4 main ] stop
						 */

						/**
						 * [tLogRow_4 process_data_begin ] start
						 */

						s(currentComponent = "tLogRow_4");

						/**
						 * [tLogRow_4 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_4 process_data_end ] start
						 */

						s(currentComponent = "tLogRow_4");

						/**
						 * [tLogRow_4 process_data_end ] stop
						 */

						/**
						 * [tContextLoad_4 process_data_end ] start
						 */

						s(currentComponent = "tContextLoad_4");

						cLabel = "LoadContextToken";

						/**
						 * [tContextLoad_4 process_data_end ] stop
						 */

					} // End of branch "copyOfsetToken"

					/**
					 * [tXMLMap_4_TXMLMAP_IN process_data_end ] start
					 */

					currentVirtualComponent = "tXMLMap_4";

					s(currentComponent = "tXMLMap_4_TXMLMAP_IN");

					cLabel = "ParseAuthResponse_TXMLMAP_IN";

					/**
					 * [tXMLMap_4_TXMLMAP_IN process_data_end ] stop
					 */

					/**
					 * [tXMLMap_4_TXMLMAP_IN end ] start
					 */

					currentVirtualComponent = "tXMLMap_4";

					s(currentComponent = "tXMLMap_4_TXMLMAP_IN");

					cLabel = "ParseAuthResponse_TXMLMAP_IN";

				} // TD512

				if (log.isDebugEnabled())
					log.debug("tXMLMap_4_TXMLMAP_IN - " + ("Done."));

				ok_Hash.put("tXMLMap_4_TXMLMAP_IN", true);
				end_Hash.put("tXMLMap_4_TXMLMAP_IN", System.currentTimeMillis());

				/**
				 * [tXMLMap_4_TXMLMAP_IN end ] stop
				 */

				/**
				 * [tContextLoad_4 end ] start
				 */

				s(currentComponent = "tContextLoad_4");

				cLabel = "LoadContextToken";

				java.util.Enumeration<?> enu_tContextLoad_4 = context.propertyNames();
				while (enu_tContextLoad_4.hasMoreElements()) {
					String key_tContextLoad_4 = (String) enu_tContextLoad_4.nextElement();
					if (!assignList_tContextLoad_4.contains(key_tContextLoad_4)
							&& !newPropertyList_tContextLoad_4.contains(key_tContextLoad_4)) {
						noAssignList_tContextLoad_4.add(key_tContextLoad_4);
					}
				}

				String newPropertyStr_tContextLoad_4 = newPropertyList_tContextLoad_4.toString();
				String newProperty_tContextLoad_4 = newPropertyStr_tContextLoad_4.substring(1,
						newPropertyStr_tContextLoad_4.length() - 1);

				String noAssignStr_tContextLoad_4 = noAssignList_tContextLoad_4.toString();
				String noAssign_tContextLoad_4 = noAssignStr_tContextLoad_4.substring(1,
						noAssignStr_tContextLoad_4.length() - 1);

				globalMap.put("tContextLoad_4_KEY_NOT_INCONTEXT", newProperty_tContextLoad_4);
				globalMap.put("tContextLoad_4_KEY_NOT_LOADED", noAssign_tContextLoad_4);

				globalMap.put("tContextLoad_4_NB_LINE", nb_line_tContextLoad_4);

				List<String> parametersToEncrypt_tContextLoad_4 = new java.util.ArrayList<String>();

				parametersToEncrypt_tContextLoad_4.add("Stewardship_Password");

				resumeUtil.addLog("NODE", "NODE:tContextLoad_4", "", Thread.currentThread().getId() + "", "", "", "",
						"", resumeUtil.convertToJsonText(context, ContextProperties.class,
								parametersToEncrypt_tContextLoad_4));
				log.info("tContextLoad_4 - Loaded contexts count: " + nb_line_tContextLoad_4 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "copyOfsetToken", 2, 0,
						"tXMLMap_4_TXMLMAP_IN", "ParseAuthResponse_TXMLMAP_IN", "tXMLMapIn", "tContextLoad_4",
						"LoadContextToken", "tContextLoad", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tContextLoad_4 - " + ("Done."));

				ok_Hash.put("tContextLoad_4", true);
				end_Hash.put("tContextLoad_4", System.currentTimeMillis());

				/**
				 * [tContextLoad_4 end ] stop
				 */

				/**
				 * [tLogRow_4 end ] start
				 */

				s(currentComponent = "tLogRow_4");

//////
//////
				globalMap.put("tLogRow_4_NB_LINE", nb_line_tLogRow_4);
				if (log.isInfoEnabled())
					log.info("tLogRow_4 - " + ("Printed row count: ") + (nb_line_tLogRow_4) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row5", 2, 0,
						"tContextLoad_4", "LoadContextToken", "tContextLoad", "tLogRow_4", "tLogRow_4", "tLogRow",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_4 - " + ("Done."));

				ok_Hash.put("tLogRow_4", true);
				end_Hash.put("tLogRow_4", System.currentTimeMillis());

				/**
				 * [tLogRow_4 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFixedFlowInput_2:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk3", 0, "ok");
			}

			tRESTClient_3Process(globalMap);

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tXMLMap_4_TXMLMAP_IN"
			globalMap.remove("tXMLMap_4");

			try {

				/**
				 * [tFixedFlowInput_2 finally ] start
				 */

				s(currentComponent = "tFixedFlowInput_2");

				cLabel = "DefineInput";

				/**
				 * [tFixedFlowInput_2 finally ] stop
				 */

				/**
				 * [tRESTClient_4 finally ] start
				 */

				s(currentComponent = "tRESTClient_4");

				cLabel = "GetAuthToken";

				/**
				 * [tRESTClient_4 finally ] stop
				 */

				/**
				 * [tXMLMap_4_TXMLMAP_OUT finally ] start
				 */

				currentVirtualComponent = "tXMLMap_4";

				s(currentComponent = "tXMLMap_4_TXMLMAP_OUT");

				cLabel = "ParseAuthResponse_TXMLMAP_OUT";

				/**
				 * [tXMLMap_4_TXMLMAP_OUT finally ] stop
				 */

				/**
				 * [tXMLMap_4_TXMLMAP_IN finally ] start
				 */

				currentVirtualComponent = "tXMLMap_4";

				s(currentComponent = "tXMLMap_4_TXMLMAP_IN");

				cLabel = "ParseAuthResponse_TXMLMAP_IN";

				/**
				 * [tXMLMap_4_TXMLMAP_IN finally ] stop
				 */

				/**
				 * [tContextLoad_4 finally ] start
				 */

				s(currentComponent = "tContextLoad_4");

				cLabel = "LoadContextToken";

				/**
				 * [tContextLoad_4 finally ] stop
				 */

				/**
				 * [tLogRow_4 finally ] start
				 */

				s(currentComponent = "tLogRow_4");

				/**
				 * [tLogRow_4 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_2_SUBPROCESS_STATE", 1);
	}

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return 255;
		}

		public Integer keyPrecision() {
			return 0;
		}

		public String keyDefault() {

			return "";

		}

		public String keyComment() {

			return null;

		}

		public String keyPattern() {

			return null;

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return 255;
		}

		public Integer valuePrecision() {
			return 0;
		}

		public String valueDefault() {

			return "";

		}

		public String valueComment() {

			return null;

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row3Struct other) {

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

	public static class row4Struct implements routines.system.IPersistableRow<row4Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return 255;
		}

		public Integer keyPrecision() {
			return 0;
		}

		public String keyDefault() {

			return null;

		}

		public String keyComment() {

			return null;

		}

		public String keyPattern() {

			return null;

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return 255;
		}

		public Integer valuePrecision() {
			return 0;
		}

		public String valueDefault() {

			return null;

		}

		public String valueComment() {

			return null;

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row4Struct other) {

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

	public static class databaseIdStruct implements routines.system.IPersistableRow<databaseIdStruct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return null;
		}

		public Integer keyPrecision() {
			return null;
		}

		public String keyDefault() {

			return null;

		}

		public String keyComment() {

			return "";

		}

		public String keyPattern() {

			return "";

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return null;
		}

		public Integer valuePrecision() {
			return null;
		}

		public String valueDefault() {

			return null;

		}

		public String valueComment() {

			return "";

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(databaseIdStruct other) {

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

	public static class setTableNameStruct implements routines.system.IPersistableRow<setTableNameStruct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return null;
		}

		public Integer keyPrecision() {
			return null;
		}

		public String keyDefault() {

			return null;

		}

		public String keyComment() {

			return "";

		}

		public String keyPattern() {

			return "";

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return null;
		}

		public Integer valuePrecision() {
			return null;
		}

		public String valueDefault() {

			return null;

		}

		public String valueComment() {

			return "";

		}

		public String valuePattern() {

			return "";

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(setTableNameStruct other) {

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

	public static class OnRowsEndStructtXMLMap_1 implements routines.system.IPersistableRow<OnRowsEndStructtXMLMap_1> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String key;

		public String getKey() {
			return this.key;
		}

		public Boolean keyIsNullable() {
			return true;
		}

		public Boolean keyIsKey() {
			return false;
		}

		public Integer keyLength() {
			return null;
		}

		public Integer keyPrecision() {
			return null;
		}

		public String keyDefault() {

			return null;

		}

		public String keyComment() {

			return "";

		}

		public String keyPattern() {

			return "";

		}

		public String keyOriginalDbColumnName() {

			return "key";

		}

		public String value;

		public String getValue() {
			return this.value;
		}

		public Boolean valueIsNullable() {
			return true;
		}

		public Boolean valueIsKey() {
			return false;
		}

		public Integer valueLength() {
			return null;
		}

		public Integer valuePrecision() {
			return null;
		}

		public String valueDefault() {

			return null;

		}

		public String valueComment() {

			return "";

		}

		public String valuePattern() {

			return null;

		}

		public String valueOriginalDbColumnName() {

			return "value";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.key = readString(dis);

					this.value = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.key, dos);

				// String

				writeString(this.value, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("key=" + key);
			sb.append(",value=" + value);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (key == null) {
				sb.append("<null>");
			} else {
				sb.append(key);
			}

			sb.append("|");

			if (value == null) {
				sb.append("<null>");
			} else {
				sb.append(value);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(OnRowsEndStructtXMLMap_1 other) {

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

	public static class sendTableStruct implements routines.system.IPersistableRow<sendTableStruct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public Integer statusCode;

		public Integer getStatusCode() {
			return this.statusCode;
		}

		public Boolean statusCodeIsNullable() {
			return true;
		}

		public Boolean statusCodeIsKey() {
			return false;
		}

		public Integer statusCodeLength() {
			return 0;
		}

		public Integer statusCodePrecision() {
			return 0;
		}

		public String statusCodeDefault() {

			return "";

		}

		public String statusCodeComment() {

			return null;

		}

		public String statusCodePattern() {

			return null;

		}

		public String statusCodeOriginalDbColumnName() {

			return "statusCode";

		}

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public Boolean bodyIsNullable() {
			return true;
		}

		public Boolean bodyIsKey() {
			return false;
		}

		public Integer bodyLength() {
			return 0;
		}

		public Integer bodyPrecision() {
			return 0;
		}

		public String bodyDefault() {

			return "";

		}

		public String bodyComment() {

			return null;

		}

		public String bodyPattern() {

			return null;

		}

		public String bodyOriginalDbColumnName() {

			return "body";

		}

		public String string;

		public String getString() {
			return this.string;
		}

		public Boolean stringIsNullable() {
			return true;
		}

		public Boolean stringIsKey() {
			return false;
		}

		public Integer stringLength() {
			return 4048;
		}

		public Integer stringPrecision() {
			return 0;
		}

		public String stringDefault() {

			return null;

		}

		public String stringComment() {

			return null;

		}

		public String stringPattern() {

			return null;

		}

		public String stringOriginalDbColumnName() {

			return "string";

		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.statusCode = readInteger(dis);

					this.body = (routines.system.Document) dis.readObject();

					this.string = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.statusCode, dos);

				// Document

				dos.clearInstanceCache();
				dos.writeObject(this.body);

				// String

				writeString(this.string, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("statusCode=" + String.valueOf(statusCode));
			sb.append(",body=" + String.valueOf(body));
			sb.append(",string=" + string);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (statusCode == null) {
				sb.append("<null>");
			} else {
				sb.append(statusCode);
			}

			sb.append("|");

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			if (string == null) {
				sb.append("<null>");
			} else {
				sb.append(string);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(sendTableStruct other) {

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

	public void tRESTClient_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTClient_3_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tRESTClient_3", "I5p8PU_");

		String currentVirtualComponent = null;

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

				sendTableStruct sendTable = new sendTableStruct();
				databaseIdStruct databaseId = new databaseIdStruct();
				databaseIdStruct row4 = databaseId;
				setTableNameStruct setTableName = new setTableNameStruct();
				setTableNameStruct row3 = setTableName;

				/**
				 * [tXMLMap_1_TXMLMAP_OUT begin ] start
				 */

				sh("tXMLMap_1_TXMLMAP_OUT");

				currentVirtualComponent = "tXMLMap_1";

				s(currentComponent = "tXMLMap_1_TXMLMAP_OUT");

				cLabel = "ParseTableResponse_TXMLMAP_OUT";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "sendTable");

				int tos_count_tXMLMap_1_TXMLMAP_OUT = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_OUT - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_1_TXMLMAP_OUT {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_OUT = new StringBuilder();
							log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("Parameters:");
							log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_1_TXMLMAP_OUT.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_1_TXMLMAP_OUT - " + (log4jParamters_tXMLMap_1_TXMLMAP_OUT));
						}
					}
					new BytesLimit65535_tXMLMap_1_TXMLMAP_OUT().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tXMLMap_1_TXMLMAP_OUT", "ParseTableResponse_TXMLMAP_OUT", "tXMLMapOut");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

//===============================input xml init part===============================
				class XML_API_tXMLMap_1_TXMLMAP_OUT {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}
				class Var__tXMLMap_1_TXMLMAP_OUT__Struct {
				}
				Var__tXMLMap_1_TXMLMAP_OUT__Struct Var__tXMLMap_1_TXMLMAP_OUT = new Var__tXMLMap_1_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
				databaseIdStruct databaseId_tmp = new databaseIdStruct();
				databaseIdStruct databaseId_save = null;
//the aggregate variable
				databaseIdStruct databaseId_aggregate = null;
				int count_databaseId_tXMLMap_1_TXMLMAP_OUT = 0;
				setTableNameStruct setTableName_tmp = new setTableNameStruct();
				setTableNameStruct setTableName_save = null;
//the aggregate variable
				setTableNameStruct setTableName_aggregate = null;
				int count_setTableName_tXMLMap_1_TXMLMAP_OUT = 0;
//init the resultset for aggregate
				java.util.List<Object> allOutsForAggregate_tXMLMap_1 = new java.util.ArrayList<Object>();
				globalMap.put("allOutsForAggregate_tXMLMap_1", allOutsForAggregate_tXMLMap_1);
// ###############################
				class TreeNode_API_tXMLMap_1_TXMLMAP_OUT {
					java.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();

					void clear() {
						xpath_value_map.clear();
					}

					void put(String xpath, String value) {
						xpath_value_map.put(xpath, value);
					}

					String get_null(String xpath) {
						return null;
					}

					String get_String(String xpath) {
						return xpath_value_map.get(xpath);
					}
				}
				TreeNode_API_tXMLMap_1_TXMLMAP_OUT treeNodeAPI_tXMLMap_1_TXMLMAP_OUT = new TreeNode_API_tXMLMap_1_TXMLMAP_OUT();
				NameSpaceTool nsTool_tXMLMap_1_TXMLMAP_OUT = new NameSpaceTool();
				int nb_line_tXMLMap_1_TXMLMAP_OUT = 0;

				XML_API_tXMLMap_1_TXMLMAP_OUT xml_api_tXMLMap_1_TXMLMAP_OUT = new XML_API_tXMLMap_1_TXMLMAP_OUT();

				// the map store the previous value of aggregate columns
				java.util.Map<String, Object> aggregateCacheMap_tXMLMap_1_TXMLMAP_OUT = new java.util.HashMap<String, Object>();

				/**
				 * [tXMLMap_1_TXMLMAP_OUT begin ] stop
				 */

				/**
				 * [tRESTClient_3 begin ] start
				 */

				sh("tRESTClient_3");

				s(currentComponent = "tRESTClient_3");

				cLabel = "GetTableName";

				int tos_count_tRESTClient_3 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTClient_3", "GetTableName", "tRESTClient");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tRESTClient_3 begin ] stop
				 */

				/**
				 * [tRESTClient_3 main ] start
				 */

				s(currentComponent = "tRESTClient_3");

				cLabel = "GetTableName";

				sendTable = null;

// expected response body
				Object responseDoc_tRESTClient_3 = null;

				try {
					// request body
					org.dom4j.Document requestDoc_tRESTClient_3 = null;
					String requestString_tRESTClient_3 = null;

					Object requestBody_tRESTClient_3 = requestDoc_tRESTClient_3 != null ? requestDoc_tRESTClient_3
							: requestString_tRESTClient_3;

					// resposne class name
					Class<?> responseClass_tRESTClient_3 = org.dom4j.Document.class;

					// create web client instance
					org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_3 = new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

					boolean inOSGi = routines.system.BundleUtils.inOSGi();

					final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_3 = new java.util.ArrayList<org.apache.cxf.feature.Feature>();

					String url = null;

					url = "http://192.168.1.253:11480/MM/rest/v1/entities/";
					// {baseUri}tRESTClient
					factoryBean_tRESTClient_3.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
					factoryBean_tRESTClient_3.setAddress(url);

					boolean log_messages_tRESTClient_3 = Boolean.valueOf(false);
					if (log_messages_tRESTClient_3) {
						org.apache.cxf.ext.logging.LoggingFeature loggingFeature = new org.apache.cxf.ext.logging.LoggingFeature();
						loggingFeature.addSensitiveProtocolHeaderNames(new java.util.HashSet<>(
								java.util.Arrays.asList(org.apache.cxf.helpers.HttpHeaderHelper.AUTHORIZATION)));
						loggingFeature
								.addSensitiveElementNames(new java.util.HashSet<>(java.util.Arrays.asList("password")));
						features_tRESTClient_3.add(loggingFeature);
					}

					factoryBean_tRESTClient_3.setFeatures(features_tRESTClient_3);

					java.util.List<Object> providers_tRESTClient_3 = new java.util.ArrayList<Object>();
					providers_tRESTClient_3.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
						// workaround for https://jira.talendforge.org/browse/TESB-7276
						public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls, java.lang.reflect.Type type,
								java.lang.annotation.Annotation[] anns, jakarta.ws.rs.core.MediaType mt,
								jakarta.ws.rs.core.MultivaluedMap<String, String> headers, java.io.InputStream is)
								throws IOException, jakarta.ws.rs.WebApplicationException {
							String contentLength = headers.getFirst("Content-Length");
							if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)
									&& Integer.valueOf(contentLength) <= 0) {
								try {
									return org.dom4j.DocumentHelper.parseText("<root/>");
								} catch (org.dom4j.DocumentException e_tRESTClient_3) {
									e_tRESTClient_3.printStackTrace();
								}
								return null;
							}
							return super.readFrom(cls, type, anns, mt, headers, is);
						}
					});
					org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_3 = new org.apache.cxf.jaxrs.provider.json.JSONProvider();
					jsonProvider_tRESTClient_3.setIgnoreNamespaces(true);
					jsonProvider_tRESTClient_3.setAttributesToElements(true);

					jsonProvider_tRESTClient_3.setSupportUnwrapped(true);
					jsonProvider_tRESTClient_3.setWrapperName("root");

					jsonProvider_tRESTClient_3.setDropRootElement(false);
					jsonProvider_tRESTClient_3.setConvertTypesToStrings(false);
					providers_tRESTClient_3.add(jsonProvider_tRESTClient_3);
					factoryBean_tRESTClient_3.setProviders(providers_tRESTClient_3);
					factoryBean_tRESTClient_3.setTransportId("http://cxf.apache.org/transports/http");

					boolean use_auth_tRESTClient_3 = false;

					org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_3 = null;

					webClient_tRESTClient_3 = factoryBean_tRESTClient_3.createWebClient();
					// set request path
					webClient_tRESTClient_3.path(context.tableId);

					// set connection properties
					org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_3 = org.apache.cxf.jaxrs.client.WebClient
							.getConfig(webClient_tRESTClient_3);
					org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
					org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_3 = null;

					conduit_tRESTClient_3 = clientConfig_tRESTClient_3.getHttpConduit();

					if (clientConfig_tRESTClient_3.getEndpoint() != null) {
						org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_3 = clientConfig_tRESTClient_3
								.getEndpoint().getEndpointInfo();
						if (endpointInfo_tRESTClient_3 != null) {
							endpointInfo_tRESTClient_3.setProperty("enable.webclient.operation.reporting", true);
						}
					}

					if (!inOSGi) {
						conduit_tRESTClient_3.getClient().setReceiveTimeout((long) (60 * 1000L));
						conduit_tRESTClient_3.getClient().setConnectionTimeout((long) (30 * 1000L));
					}

					// set Accept-Type
					webClient_tRESTClient_3.accept("application/json");

					// set optional query and header properties if any

					webClient_tRESTClient_3.header("api_key", context.token);

					if (use_auth_tRESTClient_3 && "OAUTH2_BEARER".equals("BASIC")) {
						// set oAuth2 bearer token
						org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
						authSupplier.setAccessToken((String) "");
						conduit_tRESTClient_3.setAuthSupplier(authSupplier);
					}

					// if FORM request then capture query parameters into Form, otherwise set them
					// as queries

					webClient_tRESTClient_3.query("select", "Name,Parent");

					try {
						// start send request

						responseDoc_tRESTClient_3 = webClient_tRESTClient_3.get();
						jakarta.ws.rs.core.Response responseObjBase_tRESTClient_3 = (jakarta.ws.rs.core.Response) responseDoc_tRESTClient_3;
						int status_tRESTClient_3 = responseObjBase_tRESTClient_3.getStatus();
						if (status_tRESTClient_3 != 304 && status_tRESTClient_3 >= 300
								&& responseClass_tRESTClient_3 != jakarta.ws.rs.core.Response.class) {
							throw org.apache.cxf.jaxrs.utils.ExceptionUtils.toWebApplicationException(
									(jakarta.ws.rs.core.Response) responseObjBase_tRESTClient_3);
						}
						if (status_tRESTClient_3 != 204 && responseObjBase_tRESTClient_3.getEntity() != null) {
							responseDoc_tRESTClient_3 = responseObjBase_tRESTClient_3
									.readEntity(responseClass_tRESTClient_3);
						}

						int webClientResponseStatus_tRESTClient_3 = webClient_tRESTClient_3.getResponse().getStatus();
						if (webClientResponseStatus_tRESTClient_3 >= 300) {
							throw new jakarta.ws.rs.WebApplicationException(webClient_tRESTClient_3.getResponse());
						}

						if (sendTable == null) {
							sendTable = new sendTableStruct();
						}

						sendTable.statusCode = webClientResponseStatus_tRESTClient_3;
						sendTable.string = "";

						{
							Object responseObj_tRESTClient_3 = responseDoc_tRESTClient_3;

							if (responseObj_tRESTClient_3 != null) {
								if (responseClass_tRESTClient_3 == String.class
										&& responseObj_tRESTClient_3 instanceof String) {
									sendTable.string = (String) responseObj_tRESTClient_3;
								} else {
									routines.system.Document responseTalendDoc_tRESTClient_3 = null;
									if (null != responseObj_tRESTClient_3) {
										responseTalendDoc_tRESTClient_3 = new routines.system.Document();
										if (responseObj_tRESTClient_3 instanceof org.dom4j.Document) {
											responseTalendDoc_tRESTClient_3
													.setDocument((org.dom4j.Document) responseObj_tRESTClient_3);
										}
									}
									sendTable.body = responseTalendDoc_tRESTClient_3;
								}
							}
						}

						java.util.Map<String, jakarta.ws.rs.core.NewCookie> cookies_tRESTClient_3 = new java.util.HashMap<String, jakarta.ws.rs.core.NewCookie>();

						if (webClient_tRESTClient_3.getResponse() != null
								&& webClient_tRESTClient_3.getResponse().getCookies() != null) {
							cookies_tRESTClient_3.putAll(webClient_tRESTClient_3.getResponse().getCookies());
						}

						globalMap.put("tRESTClient_3_HEADERS", webClient_tRESTClient_3.getResponse().getHeaders());
						globalMap.put("tRESTClient_3_COOKIES", cookies_tRESTClient_3);

					} catch (jakarta.ws.rs.WebApplicationException ex_tRESTClient_3) {
						globalMap.put("tRESTClient_3_ERROR_MESSAGE", ex_tRESTClient_3.getMessage());

						throw ex_tRESTClient_3;

					}

				} catch (Exception e_tRESTClient_3) {
					globalMap.put("tRESTClient_3_ERROR_MESSAGE", e_tRESTClient_3.getMessage());

					throw new TalendException(e_tRESTClient_3, currentComponent, globalMap);

				}

				tos_count_tRESTClient_3++;

				/**
				 * [tRESTClient_3 main ] stop
				 */

				/**
				 * [tRESTClient_3 process_data_begin ] start
				 */

				s(currentComponent = "tRESTClient_3");

				cLabel = "GetTableName";

				/**
				 * [tRESTClient_3 process_data_begin ] stop
				 */

// Start of branch "sendTable"
				if (sendTable != null) {

					/**
					 * [tXMLMap_1_TXMLMAP_OUT main ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_OUT");

					cLabel = "ParseTableResponse_TXMLMAP_OUT";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "sendTable", "tRESTClient_3", "GetTableName", "tRESTClient", "tXMLMap_1_TXMLMAP_OUT",
							"ParseTableResponse_TXMLMAP_OUT", "tXMLMapOut"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("sendTable - " + (sendTable == null ? "" : sendTable.toLogString()));
					}

					boolean rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
					boolean rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
					boolean mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
					boolean isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;

					// init document to flat tool
					routines.system.DocumentToFlat docToFlat_tXMLMap_1_TXMLMAP_OUT = new routines.system.DocumentToFlat();
					docToFlat_tXMLMap_1_TXMLMAP_OUT.setOriginalLoop("/root/result/attributes");
					docToFlat_tXMLMap_1_TXMLMAP_OUT.setIsOptional(false);
					if (sendTable.body == null || sendTable.body.getDocument() == null) {
						throw new RuntimeException("sendTable.body can't be empty");
					}
					org.dom4j.Document doc_tXMLMap_1_TXMLMAP_OUT = sendTable.body.getDocument();
					docToFlat_tXMLMap_1_TXMLMAP_OUT.setDoc(doc_tXMLMap_1_TXMLMAP_OUT);
					docToFlat_tXMLMap_1_TXMLMAP_OUT.setDefineNS(false);
					docToFlat_tXMLMap_1_TXMLMAP_OUT.setNamespaceTool(nsTool_tXMLMap_1_TXMLMAP_OUT);

					// old version, find NS from doc
					nsTool_tXMLMap_1_TXMLMAP_OUT.countNSMap(doc_tXMLMap_1_TXMLMAP_OUT.getRootElement());
					java.util.HashMap<String, String> xmlNameSpaceMap_tXMLMap_1_TXMLMAP_OUT = nsTool_tXMLMap_1_TXMLMAP_OUT.xmlNameSpaceMap;

					docToFlat_tXMLMap_1_TXMLMAP_OUT.setXmlNameSpaceMap(xmlNameSpaceMap_tXMLMap_1_TXMLMAP_OUT);

					String[] absolutePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[2];
					String[] relativePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[2];

					absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "sendTable.body:/root/result/attributes/value";
					relativePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "value";

					absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[1] = "sendTable.body:/root/result/attributes/attributeType/name";
					relativePathMappings_tXMLMap_1_TXMLMAP_OUT[1] = "attributeType/name";

					docToFlat_tXMLMap_1_TXMLMAP_OUT.setAbsolutePathMappings(absolutePathMappings_tXMLMap_1_TXMLMAP_OUT);
					docToFlat_tXMLMap_1_TXMLMAP_OUT
							.setCurrentRelativePathMappings(relativePathMappings_tXMLMap_1_TXMLMAP_OUT);
					// generate document to flat data
					docToFlat_tXMLMap_1_TXMLMAP_OUT.flat();
					// get flat data
					java.util.List<java.util.Map<String, String>> resultSet_tXMLMap_1_TXMLMAP_OUT = docToFlat_tXMLMap_1_TXMLMAP_OUT
							.getResultSet();

					for (java.util.Map<String, String> oneRow_tXMLMap_1_TXMLMAP_OUT : resultSet_tXMLMap_1_TXMLMAP_OUT) { // G_TXM_M_001
						nb_line_tXMLMap_1_TXMLMAP_OUT++;
						rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
						rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
						mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
						isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;

						treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.clear();
						for (java.util.Map.Entry<String, String> entry_tXMLMap_1_TXMLMAP_OUT : oneRow_tXMLMap_1_TXMLMAP_OUT
								.entrySet()) {
							treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.put(entry_tXMLMap_1_TXMLMAP_OUT.getKey(),
									entry_tXMLMap_1_TXMLMAP_OUT.getValue());
						}

						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tXMLMap_1_TXMLMAP_OUT__Struct Var = Var__tXMLMap_1_TXMLMAP_OUT;
							// ###############################
							// # Output tables

							databaseId = null;
							setTableName = null;

// # Output table : 'databaseId'
// # Filter conditions 
							if (

							"Parent".equals(treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
									.get_String("sendTable.body:/root/result/attributes/attributeType/name"))

							) {
								count_databaseId_tXMLMap_1_TXMLMAP_OUT++;

								databaseId_tmp = new databaseIdStruct();
								databaseId_tmp.key = "databaseName";
								databaseId_tmp.value = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
										.get_String("sendTable.body:/root/result/attributes/value");
								allOutsForAggregate_tXMLMap_1.add(databaseId_tmp);

								log.debug("tXMLMap_1 - Outputting the record " + count_databaseId_tXMLMap_1_TXMLMAP_OUT
										+ " of the output table 'databaseId'.");

							} // closing filter/reject

// # Output table : 'setTableName'
// # Filter conditions 
							if (

							"Name".equals(treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
									.get_String("sendTable.body:/root/result/attributes/attributeType/name"))

							) {
								count_setTableName_tXMLMap_1_TXMLMAP_OUT++;

								setTableName_tmp = new setTableNameStruct();
								setTableName_tmp.key = "tableName";
								setTableName_tmp.value = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT
										.get_String("sendTable.body:/root/result/attributes/value");
								allOutsForAggregate_tXMLMap_1.add(setTableName_tmp);

								log.debug(
										"tXMLMap_1 - Outputting the record " + count_setTableName_tXMLMap_1_TXMLMAP_OUT
												+ " of the output table 'setTableName'.");

							} // closing filter/reject
// ###############################

						} // end of Var scope

						rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;

					} // G_TXM_M_001 close

					tos_count_tXMLMap_1_TXMLMAP_OUT++;

					/**
					 * [tXMLMap_1_TXMLMAP_OUT main ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_OUT");

					cLabel = "ParseTableResponse_TXMLMAP_OUT";

					/**
					 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_OUT");

					cLabel = "ParseTableResponse_TXMLMAP_OUT";

					/**
					 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] stop
					 */

				} // End of branch "sendTable"

				/**
				 * [tRESTClient_3 process_data_end ] start
				 */

				s(currentComponent = "tRESTClient_3");

				cLabel = "GetTableName";

				/**
				 * [tRESTClient_3 process_data_end ] stop
				 */

				/**
				 * [tRESTClient_3 end ] start
				 */

				s(currentComponent = "tRESTClient_3");

				cLabel = "GetTableName";

				if (globalMap.get("tRESTClient_3_NB_LINE") == null) {
					globalMap.put("tRESTClient_3_NB_LINE", 1);
				}

// [tRESTCliend_end]

				ok_Hash.put("tRESTClient_3", true);
				end_Hash.put("tRESTClient_3", System.currentTimeMillis());

				/**
				 * [tRESTClient_3 end ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_OUT end ] start
				 */

				currentVirtualComponent = "tXMLMap_1";

				s(currentComponent = "tXMLMap_1_TXMLMAP_OUT");

				cLabel = "ParseTableResponse_TXMLMAP_OUT";

				log.debug("tXMLMap_1 - Written records count in the table 'databaseId': "
						+ count_databaseId_tXMLMap_1_TXMLMAP_OUT + ".");
				log.debug("tXMLMap_1 - Written records count in the table 'setTableName': "
						+ count_setTableName_tXMLMap_1_TXMLMAP_OUT + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "sendTable", 2, 0,
						"tRESTClient_3", "GetTableName", "tRESTClient", "tXMLMap_1_TXMLMAP_OUT",
						"ParseTableResponse_TXMLMAP_OUT", "tXMLMapOut", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_OUT - " + ("Done."));

				ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", true);
				end_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());

				/**
				 * [tXMLMap_1_TXMLMAP_OUT end ] stop
				 */

				/**
				 * [tLogRow_3 begin ] start
				 */

				sh("tLogRow_3");

				s(currentComponent = "tLogRow_3");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row4");

				int tos_count_tLogRow_3 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_3 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_3 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_3 = new StringBuilder();
							log4jParamters_tLogRow_3.append("Parameters:");
							log4jParamters_tLogRow_3.append("BASIC_MODE" + " = " + "true");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("PRINT_UNIQUE_NAME" + " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("PRINT_COLNAMES" + " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("USE_FIXED_LENGTH" + " = " + "false");
							log4jParamters_tLogRow_3.append(" | ");
							log4jParamters_tLogRow_3.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_3.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_3 - " + (log4jParamters_tLogRow_3));
						}
					}
					new BytesLimit65535_tLogRow_3().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_3", "tLogRow_3", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_3 = "|";
				java.io.PrintStream consoleOut_tLogRow_3 = null;

				StringBuilder strBuffer_tLogRow_3 = null;
				int nb_line_tLogRow_3 = 0;
///////////////////////    			

				/**
				 * [tLogRow_3 begin ] stop
				 */

				/**
				 * [tContextLoad_2 begin ] start
				 */

				sh("tContextLoad_2");

				s(currentComponent = "tContextLoad_2");

				cLabel = "LoadContextDatabaseName";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "databaseId");

				int tos_count_tContextLoad_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tContextLoad_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tContextLoad_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tContextLoad_2 = new StringBuilder();
							log4jParamters_tContextLoad_2.append("Parameters:");
							log4jParamters_tContextLoad_2.append("LOAD_NEW_VARIABLE" + " = " + "Warning");
							log4jParamters_tContextLoad_2.append(" | ");
							log4jParamters_tContextLoad_2.append("NOT_LOAD_OLD_VARIABLE" + " = " + "Warning");
							log4jParamters_tContextLoad_2.append(" | ");
							log4jParamters_tContextLoad_2.append("PRINT_OPERATIONS" + " = " + "false");
							log4jParamters_tContextLoad_2.append(" | ");
							log4jParamters_tContextLoad_2.append("DISABLE_ERROR" + " = " + "false");
							log4jParamters_tContextLoad_2.append(" | ");
							log4jParamters_tContextLoad_2.append("DISABLE_WARNINGS" + " = " + "true");
							log4jParamters_tContextLoad_2.append(" | ");
							log4jParamters_tContextLoad_2.append("DISABLE_INFO" + " = " + "true");
							log4jParamters_tContextLoad_2.append(" | ");
							log4jParamters_tContextLoad_2.append("DIEONERROR" + " = " + "false");
							log4jParamters_tContextLoad_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tContextLoad_2 - " + (log4jParamters_tContextLoad_2));
						}
					}
					new BytesLimit65535_tContextLoad_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tContextLoad_2", "LoadContextDatabaseName", "tContextLoad");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.List<String> assignList_tContextLoad_2 = new java.util.ArrayList<String>();
				java.util.List<String> newPropertyList_tContextLoad_2 = new java.util.ArrayList<String>();
				java.util.List<String> noAssignList_tContextLoad_2 = new java.util.ArrayList<String>();
				int nb_line_tContextLoad_2 = 0;

				/**
				 * [tContextLoad_2 begin ] stop
				 */

				/**
				 * [tLogRow_2 begin ] start
				 */

				sh("tLogRow_2");

				s(currentComponent = "tLogRow_2");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row3");

				int tos_count_tLogRow_2 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_2 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_2 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_2 = new StringBuilder();
							log4jParamters_tLogRow_2.append("Parameters:");
							log4jParamters_tLogRow_2.append("BASIC_MODE" + " = " + "true");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("PRINT_UNIQUE_NAME" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("PRINT_COLNAMES" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("USE_FIXED_LENGTH" + " = " + "false");
							log4jParamters_tLogRow_2.append(" | ");
							log4jParamters_tLogRow_2.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_2.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_2 - " + (log4jParamters_tLogRow_2));
						}
					}
					new BytesLimit65535_tLogRow_2().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_2", "tLogRow_2", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_2 = "|";
				java.io.PrintStream consoleOut_tLogRow_2 = null;

				StringBuilder strBuffer_tLogRow_2 = null;
				int nb_line_tLogRow_2 = 0;
///////////////////////    			

				/**
				 * [tLogRow_2 begin ] stop
				 */

				/**
				 * [tContextLoad_1 begin ] start
				 */

				sh("tContextLoad_1");

				s(currentComponent = "tContextLoad_1");

				cLabel = "LoadContextTableName";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "setTableName");

				int tos_count_tContextLoad_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tContextLoad_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tContextLoad_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tContextLoad_1 = new StringBuilder();
							log4jParamters_tContextLoad_1.append("Parameters:");
							log4jParamters_tContextLoad_1.append("LOAD_NEW_VARIABLE" + " = " + "Warning");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("NOT_LOAD_OLD_VARIABLE" + " = " + "Warning");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("PRINT_OPERATIONS" + " = " + "false");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("DISABLE_ERROR" + " = " + "false");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("DISABLE_WARNINGS" + " = " + "true");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("DISABLE_INFO" + " = " + "true");
							log4jParamters_tContextLoad_1.append(" | ");
							log4jParamters_tContextLoad_1.append("DIEONERROR" + " = " + "false");
							log4jParamters_tContextLoad_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tContextLoad_1 - " + (log4jParamters_tContextLoad_1));
						}
					}
					new BytesLimit65535_tContextLoad_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tContextLoad_1", "LoadContextTableName", "tContextLoad");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.List<String> assignList_tContextLoad_1 = new java.util.ArrayList<String>();
				java.util.List<String> newPropertyList_tContextLoad_1 = new java.util.ArrayList<String>();
				java.util.List<String> noAssignList_tContextLoad_1 = new java.util.ArrayList<String>();
				int nb_line_tContextLoad_1 = 0;

				/**
				 * [tContextLoad_1 begin ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_IN begin ] start
				 */

				sh("tXMLMap_1_TXMLMAP_IN");

				currentVirtualComponent = "tXMLMap_1";

				s(currentComponent = "tXMLMap_1_TXMLMAP_IN");

				cLabel = "ParseTableResponse_TXMLMAP_IN";

				int tos_count_tXMLMap_1_TXMLMAP_IN = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_IN - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_1_TXMLMAP_IN {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_IN = new StringBuilder();
							log4jParamters_tXMLMap_1_TXMLMAP_IN.append("Parameters:");
							log4jParamters_tXMLMap_1_TXMLMAP_IN.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_1_TXMLMAP_IN.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_1_TXMLMAP_IN - " + (log4jParamters_tXMLMap_1_TXMLMAP_IN));
						}
					}
					new BytesLimit65535_tXMLMap_1_TXMLMAP_IN().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tXMLMap_1_TXMLMAP_IN", "ParseTableResponse_TXMLMAP_IN", "tXMLMapIn");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.util.List<Object> outs_tXMLMap_1 = (java.util.List<Object>) globalMap
						.get("allOutsForAggregate_tXMLMap_1");
				for (Object row_out_tXMLMap_1_TXMLMAP_IN : outs_tXMLMap_1) {// TD512

					/**
					 * [tXMLMap_1_TXMLMAP_IN begin ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_IN main ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_IN");

					cLabel = "ParseTableResponse_TXMLMAP_IN";

					databaseId = null;
					if (row_out_tXMLMap_1_TXMLMAP_IN != null
							&& row_out_tXMLMap_1_TXMLMAP_IN instanceof databaseIdStruct) {
						databaseId = (databaseIdStruct) row_out_tXMLMap_1_TXMLMAP_IN;
					}
					setTableName = null;
					if (row_out_tXMLMap_1_TXMLMAP_IN != null
							&& row_out_tXMLMap_1_TXMLMAP_IN instanceof setTableNameStruct) {
						setTableName = (setTableNameStruct) row_out_tXMLMap_1_TXMLMAP_IN;
					}

					tos_count_tXMLMap_1_TXMLMAP_IN++;

					/**
					 * [tXMLMap_1_TXMLMAP_IN main ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_IN");

					cLabel = "ParseTableResponse_TXMLMAP_IN";

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] stop
					 */

// Start of branch "databaseId"
					if (databaseId != null) {

						/**
						 * [tContextLoad_2 main ] start
						 */

						s(currentComponent = "tContextLoad_2");

						cLabel = "LoadContextDatabaseName";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "databaseId", "tXMLMap_1_TXMLMAP_IN", "ParseTableResponse_TXMLMAP_IN", "tXMLMapIn",
								"tContextLoad_2", "LoadContextDatabaseName", "tContextLoad"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("databaseId - " + (databaseId == null ? "" : databaseId.toLogString()));
						}

						//////////////////////////
						String tmp_key_tContextLoad_2 = null;
						String key_tContextLoad_2 = null;
						if (databaseId.key != null) {
							tmp_key_tContextLoad_2 = databaseId.key.trim();
							if ((tmp_key_tContextLoad_2.startsWith("#") || tmp_key_tContextLoad_2.startsWith("!"))) {
								tmp_key_tContextLoad_2 = null;
							} else {
								databaseId.key = tmp_key_tContextLoad_2;
							}
						}
						if (databaseId.key != null) {
							key_tContextLoad_2 = databaseId.key;
						}
						String value_tContextLoad_2 = null;
						if (databaseId.value != null) {
							value_tContextLoad_2 = databaseId.value;
						}

						String currentValue_tContextLoad_2 = value_tContextLoad_2;

						if ((key_tContextLoad_2 != null) && ("Stewardship_Password".equals(key_tContextLoad_2))
								&& (currentValue_tContextLoad_2 != null))
							currentValue_tContextLoad_2 = currentValue_tContextLoad_2.replaceAll(".", "*");

						if (tmp_key_tContextLoad_2 != null) {
							try {
								if (key_tContextLoad_2 != null && "tableName".equals(key_tContextLoad_2)) {
									context.tableName = value_tContextLoad_2;
								}

								if (key_tContextLoad_2 != null && "databaseName".equals(key_tContextLoad_2)) {
									context.databaseName = value_tContextLoad_2;
								}

								if (key_tContextLoad_2 != null && "token".equals(key_tContextLoad_2)) {
									context.token = value_tContextLoad_2;
								}

								if (key_tContextLoad_2 != null && "tableId".equals(key_tContextLoad_2)) {
									context.tableId = value_tContextLoad_2;
								}

								if (key_tContextLoad_2 != null && "customerId".equals(key_tContextLoad_2)) {

									context.customerId = Integer.parseInt(value_tContextLoad_2);

								}

								if (key_tContextLoad_2 != null && "Stewardship_Password".equals(key_tContextLoad_2)) {
									context.Stewardship_Password = value_tContextLoad_2;
								}

								if (key_tContextLoad_2 != null && "Stewardship_URL".equals(key_tContextLoad_2)) {
									context.Stewardship_URL = value_tContextLoad_2;
								}

								if (key_tContextLoad_2 != null && "Stewardship_UserName".equals(key_tContextLoad_2)) {
									context.Stewardship_UserName = value_tContextLoad_2;
								}

								if (context.getProperty(key_tContextLoad_2) != null) {
									assignList_tContextLoad_2.add(key_tContextLoad_2);
								} else {
									newPropertyList_tContextLoad_2.add(key_tContextLoad_2);
								}
								if (value_tContextLoad_2 == null) {
									context.setProperty(key_tContextLoad_2, "");
								} else {
									context.setProperty(key_tContextLoad_2, value_tContextLoad_2);
								}
							} catch (java.lang.Exception e) {
								globalMap.put("tContextLoad_2_ERROR_MESSAGE", e.getMessage());
								log.error("tContextLoad_2 - Setting a value for the key \"" + key_tContextLoad_2
										+ "\" has failed. Error message: " + e.getMessage());
								System.err.println("Setting a value for the key \"" + key_tContextLoad_2
										+ "\" has failed. Error message: " + e.getMessage());
							}
							nb_line_tContextLoad_2++;
						}
						//////////////////////////

						row4 = databaseId;

						tos_count_tContextLoad_2++;

						/**
						 * [tContextLoad_2 main ] stop
						 */

						/**
						 * [tContextLoad_2 process_data_begin ] start
						 */

						s(currentComponent = "tContextLoad_2");

						cLabel = "LoadContextDatabaseName";

						/**
						 * [tContextLoad_2 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_3 main ] start
						 */

						s(currentComponent = "tLogRow_3");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row4", "tContextLoad_2", "LoadContextDatabaseName", "tContextLoad", "tLogRow_3",
								"tLogRow_3", "tLogRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row4 - " + (row4 == null ? "" : row4.toLogString()));
						}

///////////////////////		

						strBuffer_tLogRow_3 = new StringBuilder();

						if (row4.key != null) { //

							strBuffer_tLogRow_3.append(String.valueOf(row4.key));

						} //

						strBuffer_tLogRow_3.append("|");

						if (row4.value != null) { //

							strBuffer_tLogRow_3.append(String.valueOf(row4.value));

						} //

						if (globalMap.get("tLogRow_CONSOLE") != null) {
							consoleOut_tLogRow_3 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
						} else {
							consoleOut_tLogRow_3 = new java.io.PrintStream(
									new java.io.BufferedOutputStream(System.out));
							globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_3);
						}
						log.info("tLogRow_3 - Content of row " + (nb_line_tLogRow_3 + 1) + ": "
								+ strBuffer_tLogRow_3.toString());
						consoleOut_tLogRow_3.println(strBuffer_tLogRow_3.toString());
						consoleOut_tLogRow_3.flush();
						nb_line_tLogRow_3++;
//////

//////                    

///////////////////////    			

						tos_count_tLogRow_3++;

						/**
						 * [tLogRow_3 main ] stop
						 */

						/**
						 * [tLogRow_3 process_data_begin ] start
						 */

						s(currentComponent = "tLogRow_3");

						/**
						 * [tLogRow_3 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_3 process_data_end ] start
						 */

						s(currentComponent = "tLogRow_3");

						/**
						 * [tLogRow_3 process_data_end ] stop
						 */

						/**
						 * [tContextLoad_2 process_data_end ] start
						 */

						s(currentComponent = "tContextLoad_2");

						cLabel = "LoadContextDatabaseName";

						/**
						 * [tContextLoad_2 process_data_end ] stop
						 */

					} // End of branch "databaseId"

// Start of branch "setTableName"
					if (setTableName != null) {

						/**
						 * [tContextLoad_1 main ] start
						 */

						s(currentComponent = "tContextLoad_1");

						cLabel = "LoadContextTableName";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "setTableName", "tXMLMap_1_TXMLMAP_IN", "ParseTableResponse_TXMLMAP_IN", "tXMLMapIn",
								"tContextLoad_1", "LoadContextTableName", "tContextLoad"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("setTableName - " + (setTableName == null ? "" : setTableName.toLogString()));
						}

						//////////////////////////
						String tmp_key_tContextLoad_1 = null;
						String key_tContextLoad_1 = null;
						if (setTableName.key != null) {
							tmp_key_tContextLoad_1 = setTableName.key.trim();
							if ((tmp_key_tContextLoad_1.startsWith("#") || tmp_key_tContextLoad_1.startsWith("!"))) {
								tmp_key_tContextLoad_1 = null;
							} else {
								setTableName.key = tmp_key_tContextLoad_1;
							}
						}
						if (setTableName.key != null) {
							key_tContextLoad_1 = setTableName.key;
						}
						String value_tContextLoad_1 = null;
						if (setTableName.value != null) {
							value_tContextLoad_1 = setTableName.value;
						}

						String currentValue_tContextLoad_1 = value_tContextLoad_1;

						if ((key_tContextLoad_1 != null) && ("Stewardship_Password".equals(key_tContextLoad_1))
								&& (currentValue_tContextLoad_1 != null))
							currentValue_tContextLoad_1 = currentValue_tContextLoad_1.replaceAll(".", "*");

						if (tmp_key_tContextLoad_1 != null) {
							try {
								if (key_tContextLoad_1 != null && "tableName".equals(key_tContextLoad_1)) {
									context.tableName = value_tContextLoad_1;
								}

								if (key_tContextLoad_1 != null && "databaseName".equals(key_tContextLoad_1)) {
									context.databaseName = value_tContextLoad_1;
								}

								if (key_tContextLoad_1 != null && "token".equals(key_tContextLoad_1)) {
									context.token = value_tContextLoad_1;
								}

								if (key_tContextLoad_1 != null && "tableId".equals(key_tContextLoad_1)) {
									context.tableId = value_tContextLoad_1;
								}

								if (key_tContextLoad_1 != null && "customerId".equals(key_tContextLoad_1)) {

									context.customerId = Integer.parseInt(value_tContextLoad_1);

								}

								if (key_tContextLoad_1 != null && "Stewardship_Password".equals(key_tContextLoad_1)) {
									context.Stewardship_Password = value_tContextLoad_1;
								}

								if (key_tContextLoad_1 != null && "Stewardship_URL".equals(key_tContextLoad_1)) {
									context.Stewardship_URL = value_tContextLoad_1;
								}

								if (key_tContextLoad_1 != null && "Stewardship_UserName".equals(key_tContextLoad_1)) {
									context.Stewardship_UserName = value_tContextLoad_1;
								}

								if (context.getProperty(key_tContextLoad_1) != null) {
									assignList_tContextLoad_1.add(key_tContextLoad_1);
								} else {
									newPropertyList_tContextLoad_1.add(key_tContextLoad_1);
								}
								if (value_tContextLoad_1 == null) {
									context.setProperty(key_tContextLoad_1, "");
								} else {
									context.setProperty(key_tContextLoad_1, value_tContextLoad_1);
								}
							} catch (java.lang.Exception e) {
								globalMap.put("tContextLoad_1_ERROR_MESSAGE", e.getMessage());
								log.error("tContextLoad_1 - Setting a value for the key \"" + key_tContextLoad_1
										+ "\" has failed. Error message: " + e.getMessage());
								System.err.println("Setting a value for the key \"" + key_tContextLoad_1
										+ "\" has failed. Error message: " + e.getMessage());
							}
							nb_line_tContextLoad_1++;
						}
						//////////////////////////

						row3 = setTableName;

						tos_count_tContextLoad_1++;

						/**
						 * [tContextLoad_1 main ] stop
						 */

						/**
						 * [tContextLoad_1 process_data_begin ] start
						 */

						s(currentComponent = "tContextLoad_1");

						cLabel = "LoadContextTableName";

						/**
						 * [tContextLoad_1 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_2 main ] start
						 */

						s(currentComponent = "tLogRow_2");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row3", "tContextLoad_1", "LoadContextTableName", "tContextLoad", "tLogRow_2",
								"tLogRow_2", "tLogRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
						}

///////////////////////		

						strBuffer_tLogRow_2 = new StringBuilder();

						if (row3.key != null) { //

							strBuffer_tLogRow_2.append(String.valueOf(row3.key));

						} //

						strBuffer_tLogRow_2.append("|");

						if (row3.value != null) { //

							strBuffer_tLogRow_2.append(String.valueOf(row3.value));

						} //

						if (globalMap.get("tLogRow_CONSOLE") != null) {
							consoleOut_tLogRow_2 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
						} else {
							consoleOut_tLogRow_2 = new java.io.PrintStream(
									new java.io.BufferedOutputStream(System.out));
							globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_2);
						}
						log.info("tLogRow_2 - Content of row " + (nb_line_tLogRow_2 + 1) + ": "
								+ strBuffer_tLogRow_2.toString());
						consoleOut_tLogRow_2.println(strBuffer_tLogRow_2.toString());
						consoleOut_tLogRow_2.flush();
						nb_line_tLogRow_2++;
//////

//////                    

///////////////////////    			

						tos_count_tLogRow_2++;

						/**
						 * [tLogRow_2 main ] stop
						 */

						/**
						 * [tLogRow_2 process_data_begin ] start
						 */

						s(currentComponent = "tLogRow_2");

						/**
						 * [tLogRow_2 process_data_begin ] stop
						 */

						/**
						 * [tLogRow_2 process_data_end ] start
						 */

						s(currentComponent = "tLogRow_2");

						/**
						 * [tLogRow_2 process_data_end ] stop
						 */

						/**
						 * [tContextLoad_1 process_data_end ] start
						 */

						s(currentComponent = "tContextLoad_1");

						cLabel = "LoadContextTableName";

						/**
						 * [tContextLoad_1 process_data_end ] stop
						 */

					} // End of branch "setTableName"

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_end ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_IN");

					cLabel = "ParseTableResponse_TXMLMAP_IN";

					/**
					 * [tXMLMap_1_TXMLMAP_IN process_data_end ] stop
					 */

					/**
					 * [tXMLMap_1_TXMLMAP_IN end ] start
					 */

					currentVirtualComponent = "tXMLMap_1";

					s(currentComponent = "tXMLMap_1_TXMLMAP_IN");

					cLabel = "ParseTableResponse_TXMLMAP_IN";

				} // TD512

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1_TXMLMAP_IN - " + ("Done."));

				ok_Hash.put("tXMLMap_1_TXMLMAP_IN", true);
				end_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());

				/**
				 * [tXMLMap_1_TXMLMAP_IN end ] stop
				 */

				/**
				 * [tContextLoad_2 end ] start
				 */

				s(currentComponent = "tContextLoad_2");

				cLabel = "LoadContextDatabaseName";

				java.util.Enumeration<?> enu_tContextLoad_2 = context.propertyNames();
				while (enu_tContextLoad_2.hasMoreElements()) {
					String key_tContextLoad_2 = (String) enu_tContextLoad_2.nextElement();
					if (!assignList_tContextLoad_2.contains(key_tContextLoad_2)
							&& !newPropertyList_tContextLoad_2.contains(key_tContextLoad_2)) {
						noAssignList_tContextLoad_2.add(key_tContextLoad_2);
					}
				}

				String newPropertyStr_tContextLoad_2 = newPropertyList_tContextLoad_2.toString();
				String newProperty_tContextLoad_2 = newPropertyStr_tContextLoad_2.substring(1,
						newPropertyStr_tContextLoad_2.length() - 1);

				String noAssignStr_tContextLoad_2 = noAssignList_tContextLoad_2.toString();
				String noAssign_tContextLoad_2 = noAssignStr_tContextLoad_2.substring(1,
						noAssignStr_tContextLoad_2.length() - 1);

				globalMap.put("tContextLoad_2_KEY_NOT_INCONTEXT", newProperty_tContextLoad_2);
				globalMap.put("tContextLoad_2_KEY_NOT_LOADED", noAssign_tContextLoad_2);

				globalMap.put("tContextLoad_2_NB_LINE", nb_line_tContextLoad_2);

				List<String> parametersToEncrypt_tContextLoad_2 = new java.util.ArrayList<String>();

				parametersToEncrypt_tContextLoad_2.add("Stewardship_Password");

				resumeUtil.addLog("NODE", "NODE:tContextLoad_2", "", Thread.currentThread().getId() + "", "", "", "",
						"", resumeUtil.convertToJsonText(context, ContextProperties.class,
								parametersToEncrypt_tContextLoad_2));
				log.info("tContextLoad_2 - Loaded contexts count: " + nb_line_tContextLoad_2 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "databaseId", 2, 0,
						"tXMLMap_1_TXMLMAP_IN", "ParseTableResponse_TXMLMAP_IN", "tXMLMapIn", "tContextLoad_2",
						"LoadContextDatabaseName", "tContextLoad", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tContextLoad_2 - " + ("Done."));

				ok_Hash.put("tContextLoad_2", true);
				end_Hash.put("tContextLoad_2", System.currentTimeMillis());

				/**
				 * [tContextLoad_2 end ] stop
				 */

				/**
				 * [tLogRow_3 end ] start
				 */

				s(currentComponent = "tLogRow_3");

//////
//////
				globalMap.put("tLogRow_3_NB_LINE", nb_line_tLogRow_3);
				if (log.isInfoEnabled())
					log.info("tLogRow_3 - " + ("Printed row count: ") + (nb_line_tLogRow_3) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row4", 2, 0,
						"tContextLoad_2", "LoadContextDatabaseName", "tContextLoad", "tLogRow_3", "tLogRow_3",
						"tLogRow", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_3 - " + ("Done."));

				ok_Hash.put("tLogRow_3", true);
				end_Hash.put("tLogRow_3", System.currentTimeMillis());

				/**
				 * [tLogRow_3 end ] stop
				 */

				/**
				 * [tContextLoad_1 end ] start
				 */

				s(currentComponent = "tContextLoad_1");

				cLabel = "LoadContextTableName";

				java.util.Enumeration<?> enu_tContextLoad_1 = context.propertyNames();
				while (enu_tContextLoad_1.hasMoreElements()) {
					String key_tContextLoad_1 = (String) enu_tContextLoad_1.nextElement();
					if (!assignList_tContextLoad_1.contains(key_tContextLoad_1)
							&& !newPropertyList_tContextLoad_1.contains(key_tContextLoad_1)) {
						noAssignList_tContextLoad_1.add(key_tContextLoad_1);
					}
				}

				String newPropertyStr_tContextLoad_1 = newPropertyList_tContextLoad_1.toString();
				String newProperty_tContextLoad_1 = newPropertyStr_tContextLoad_1.substring(1,
						newPropertyStr_tContextLoad_1.length() - 1);

				String noAssignStr_tContextLoad_1 = noAssignList_tContextLoad_1.toString();
				String noAssign_tContextLoad_1 = noAssignStr_tContextLoad_1.substring(1,
						noAssignStr_tContextLoad_1.length() - 1);

				globalMap.put("tContextLoad_1_KEY_NOT_INCONTEXT", newProperty_tContextLoad_1);
				globalMap.put("tContextLoad_1_KEY_NOT_LOADED", noAssign_tContextLoad_1);

				globalMap.put("tContextLoad_1_NB_LINE", nb_line_tContextLoad_1);

				List<String> parametersToEncrypt_tContextLoad_1 = new java.util.ArrayList<String>();

				parametersToEncrypt_tContextLoad_1.add("Stewardship_Password");

				resumeUtil.addLog("NODE", "NODE:tContextLoad_1", "", Thread.currentThread().getId() + "", "", "", "",
						"", resumeUtil.convertToJsonText(context, ContextProperties.class,
								parametersToEncrypt_tContextLoad_1));
				log.info("tContextLoad_1 - Loaded contexts count: " + nb_line_tContextLoad_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "setTableName", 2, 0,
						"tXMLMap_1_TXMLMAP_IN", "ParseTableResponse_TXMLMAP_IN", "tXMLMapIn", "tContextLoad_1",
						"LoadContextTableName", "tContextLoad", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tContextLoad_1 - " + ("Done."));

				ok_Hash.put("tContextLoad_1", true);
				end_Hash.put("tContextLoad_1", System.currentTimeMillis());

				/**
				 * [tContextLoad_1 end ] stop
				 */

				/**
				 * [tLogRow_2 end ] start
				 */

				s(currentComponent = "tLogRow_2");

//////
//////
				globalMap.put("tLogRow_2_NB_LINE", nb_line_tLogRow_2);
				if (log.isInfoEnabled())
					log.info("tLogRow_2 - " + ("Printed row count: ") + (nb_line_tLogRow_2) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row3", 2, 0,
						"tContextLoad_1", "LoadContextTableName", "tContextLoad", "tLogRow_2", "tLogRow_2", "tLogRow",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_2 - " + ("Done."));

				ok_Hash.put("tLogRow_2", true);
				end_Hash.put("tLogRow_2", System.currentTimeMillis());

				/**
				 * [tLogRow_2 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tRESTClient_3:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk4", 0, "ok");
			}

			tDBRow_1Process(globalMap);

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			// free memory for "tXMLMap_1_TXMLMAP_IN"
			globalMap.remove("tXMLMap_1");

			try {

				/**
				 * [tRESTClient_3 finally ] start
				 */

				s(currentComponent = "tRESTClient_3");

				cLabel = "GetTableName";

				/**
				 * [tRESTClient_3 finally ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_OUT finally ] start
				 */

				currentVirtualComponent = "tXMLMap_1";

				s(currentComponent = "tXMLMap_1_TXMLMAP_OUT");

				cLabel = "ParseTableResponse_TXMLMAP_OUT";

				/**
				 * [tXMLMap_1_TXMLMAP_OUT finally ] stop
				 */

				/**
				 * [tXMLMap_1_TXMLMAP_IN finally ] start
				 */

				currentVirtualComponent = "tXMLMap_1";

				s(currentComponent = "tXMLMap_1_TXMLMAP_IN");

				cLabel = "ParseTableResponse_TXMLMAP_IN";

				/**
				 * [tXMLMap_1_TXMLMAP_IN finally ] stop
				 */

				/**
				 * [tContextLoad_2 finally ] start
				 */

				s(currentComponent = "tContextLoad_2");

				cLabel = "LoadContextDatabaseName";

				/**
				 * [tContextLoad_2 finally ] stop
				 */

				/**
				 * [tLogRow_3 finally ] start
				 */

				s(currentComponent = "tLogRow_3");

				/**
				 * [tLogRow_3 finally ] stop
				 */

				/**
				 * [tContextLoad_1 finally ] start
				 */

				s(currentComponent = "tContextLoad_1");

				cLabel = "LoadContextTableName";

				/**
				 * [tContextLoad_1 finally ] stop
				 */

				/**
				 * [tLogRow_2 finally ] start
				 */

				s(currentComponent = "tLogRow_2");

				/**
				 * [tLogRow_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTClient_3_SUBPROCESS_STATE", 1);
	}

	public static class row7Struct implements routines.system.IPersistableRow<row7Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public Boolean bodyIsNullable() {
			return true;
		}

		public Boolean bodyIsKey() {
			return false;
		}

		public Integer bodyLength() {
			return 0;
		}

		public Integer bodyPrecision() {
			return 0;
		}

		public String bodyDefault() {

			return "";

		}

		public String bodyComment() {

			return null;

		}

		public String bodyPattern() {

			return null;

		}

		public String bodyOriginalDbColumnName() {

			return "body";

		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Document

				dos.clearInstanceCache();
				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(row7Struct other) {

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

	public static class copyOfsendDeleteMessage1Struct
			implements routines.system.IPersistableRow<copyOfsendDeleteMessage1Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public routines.system.Document body;

		public routines.system.Document getBody() {
			return this.body;
		}

		public Boolean bodyIsNullable() {
			return true;
		}

		public Boolean bodyIsKey() {
			return false;
		}

		public Integer bodyLength() {
			return 0;
		}

		public Integer bodyPrecision() {
			return 0;
		}

		public String bodyDefault() {

			return "";

		}

		public String bodyComment() {

			return null;

		}

		public String bodyPattern() {

			return null;

		}

		public String bodyOriginalDbColumnName() {

			return "body";

		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.body = (routines.system.Document) dis.readObject();

				} catch (IOException e) {
					throw new RuntimeException(e);

				} catch (ClassNotFoundException eCNFE) {
					throw new RuntimeException(eCNFE);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Document

				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Document

				dos.clearInstanceCache();
				dos.writeObject(this.body);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + String.valueOf(body));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (body == null) {
				sb.append("<null>");
			} else {
				sb.append(body);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(copyOfsendDeleteMessage1Struct other) {

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

	public static class row6Struct implements routines.system.IPersistableRow<row6Struct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public String newColumn;

		public String getNewColumn() {
			return this.newColumn;
		}

		public Boolean newColumnIsNullable() {
			return true;
		}

		public Boolean newColumnIsKey() {
			return true;
		}

		public Integer newColumnLength() {
			return null;
		}

		public Integer newColumnPrecision() {
			return null;
		}

		public String newColumnDefault() {

			return null;

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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.newColumn = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

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
		public int compareTo(row6Struct other) {

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

	public void tDBRow_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBRow_1", "kvfWiW_");

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

				row6Struct row6 = new row6Struct();
				copyOfsendDeleteMessage1Struct copyOfsendDeleteMessage1 = new copyOfsendDeleteMessage1Struct();
				copyOfsendDeleteMessage1Struct row7 = copyOfsendDeleteMessage1;

				/**
				 * [tRESTResponse_3 begin ] start
				 */

				sh("tRESTResponse_3");

				s(currentComponent = "tRESTResponse_3");

				cLabel = "DeleteResponse";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row7");

				int tos_count_tRESTResponse_3 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTResponse_3", "DeleteResponse", "tRESTResponse");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tRESTResponse_3 begin ] stop
				 */

				/**
				 * [tLogRow_5 begin ] start
				 */

				sh("tLogRow_5");

				s(currentComponent = "tLogRow_5");

				cLabel = "LogDeleteAction";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0,
						"copyOfsendDeleteMessage1");

				int tos_count_tLogRow_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_5 = new StringBuilder();
							log4jParamters_tLogRow_5.append("Parameters:");
							log4jParamters_tLogRow_5.append("BASIC_MODE" + " = " + "false");
							log4jParamters_tLogRow_5.append(" | ");
							log4jParamters_tLogRow_5.append("TABLE_PRINT" + " = " + "true");
							log4jParamters_tLogRow_5.append(" | ");
							log4jParamters_tLogRow_5.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_5.append(" | ");
							log4jParamters_tLogRow_5.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_5 - " + (log4jParamters_tLogRow_5));
						}
					}
					new BytesLimit65535_tLogRow_5().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_5", "LogDeleteAction", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				class Util_tLogRow_5 {

					String[] des_top = { ".", ".", "-", "+" };

					String[] des_head = { "|=", "=|", "-", "+" };

					String[] des_bottom = { "'", "'", "-", "+" };

					String name = "";

					java.util.List<String[]> list = new java.util.ArrayList<String[]>();

					int[] colLengths = new int[1];

					public void addRow(String[] row) {

						for (int i = 0; i < 1; i++) {
							if (row[i] != null) {
								colLengths[i] = Math.max(colLengths[i], row[i].length());
							}
						}
						list.add(row);
					}

					public void setTableName(String name) {

						this.name = name;
					}

					public StringBuilder format() {

						StringBuilder sb = new StringBuilder();

						sb.append(print(des_top));

						int totals = 0;
						for (int i = 0; i < colLengths.length; i++) {
							totals = totals + colLengths[i];
						}

						// name
						sb.append("|");
						int k = 0;
						for (k = 0; k < (totals + 0 - name.length()) / 2; k++) {
							sb.append(' ');
						}
						sb.append(name);
						for (int i = 0; i < totals + 0 - name.length() - k; i++) {
							sb.append(' ');
						}
						sb.append("|\n");

						// head and rows
						sb.append(print(des_head));
						for (int i = 0; i < list.size(); i++) {

							String[] row = list.get(i);

							java.util.Formatter formatter = new java.util.Formatter(new StringBuilder());

							StringBuilder sbformat = new StringBuilder();
							sbformat.append("|%1$-");
							sbformat.append(colLengths[0]);
							sbformat.append("s");

							sbformat.append("|\n");

							formatter.format(sbformat.toString(), (Object[]) row);

							sb.append(formatter.toString());
							if (i == 0)
								sb.append(print(des_head)); // print the head
						}

						// end
						sb.append(print(des_bottom));
						return sb;
					}

					private StringBuilder print(String[] fillChars) {
						StringBuilder sb = new StringBuilder();
						// first column
						sb.append(fillChars[0]);

						// last column
						for (int i = 0; i < colLengths[0] - fillChars[0].length() - fillChars[1].length() + 2; i++) {
							sb.append(fillChars[2]);
						}
						sb.append(fillChars[1]);
						sb.append("\n");
						return sb;
					}

					public boolean isTableEmpty() {
						if (list.size() > 1)
							return false;
						return true;
					}
				}
				Util_tLogRow_5 util_tLogRow_5 = new Util_tLogRow_5();
				util_tLogRow_5.setTableName("LogDeleteAction");
				util_tLogRow_5.addRow(new String[] { "body", });
				StringBuilder strBuffer_tLogRow_5 = null;
				int nb_line_tLogRow_5 = 0;
///////////////////////    			

				/**
				 * [tLogRow_5 begin ] stop
				 */

				/**
				 * [tXMLMap_5 begin ] start
				 */

				sh("tXMLMap_5");

				s(currentComponent = "tXMLMap_5");

				cLabel = "SetDeleteMesssage";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row6");

				int tos_count_tXMLMap_5 = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_5 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_5 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_5 = new StringBuilder();
							log4jParamters_tXMLMap_5.append("Parameters:");
							log4jParamters_tXMLMap_5.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_5.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_5 - " + (log4jParamters_tXMLMap_5));
						}
					}
					new BytesLimit65535_tXMLMap_5().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tXMLMap_5", "SetDeleteMesssage", "tXMLMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

//===============================input xml init part===============================
				class XML_API_tXMLMap_5 {
					public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null && node instanceof org.dom4j.Element) {
							org.dom4j.Attribute attri = ((org.dom4j.Element) node).attribute("nil");
							if (attri != null && ("true").equals(attri.getText())) {
								return true;
							}
						}
						return false;
					}

					public boolean isMissing(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						return node == null ? true : false;
					}

					public boolean isEmpty(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
						if (node != null) {
							return node.getText().length() == 0;
						}
						return false;
					}
				}
				class Var__tXMLMap_5__Struct {
				}
				Var__tXMLMap_5__Struct Var__tXMLMap_5 = new Var__tXMLMap_5__Struct();
// ###############################
// # Outputs initialization
				copyOfsendDeleteMessage1Struct copyOfsendDeleteMessage1_tmp = new copyOfsendDeleteMessage1Struct();
				copyOfsendDeleteMessage1Struct copyOfsendDeleteMessage1_save = null;
				int count_copyOfsendDeleteMessage1_tXMLMap_5 = 0;
// ###############################
				int nb_line_tXMLMap_5 = 0;

				XML_API_tXMLMap_5 xml_api_tXMLMap_5 = new XML_API_tXMLMap_5();

				class GenerateDocument_copyOfsendDeleteMessage1 {

					java.util.Map<String, Object> valueMap = null;

					routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(
							1);

					org.dom4j.Document doc = null;

					org.dom4j.Element root4Group = null;

					org.dom4j.io.OutputFormat format = null;

					java.util.List<java.util.List<String>> groupbyList = null;
					java.util.List<org.dom4j.Element> groupElementList = null;
					int order = 0;

					boolean isFirst = true;

					boolean needRoot = true;

					String currentValue = null;

					public GenerateDocument_copyOfsendDeleteMessage1() {
//    	this.treeNodeAPI = treeNodeAPI;

						valueMap = new java.util.HashMap<String, Object>();

						groupbyList = new java.util.ArrayList<java.util.List<String>>();
						groupElementList = new java.util.ArrayList<org.dom4j.Element>();

						doc = org.dom4j.DocumentHelper.createDocument();
						format = org.dom4j.io.OutputFormat.createPrettyPrint();
						format.setTrimText(false);
					}

					public org.dom4j.Document getDocument() {
						generateOk();
						return this.doc;
					}

					// do some work after document has been generated
					private void generateOk() {
						routines.system.NestXMLTool.replaceDefaultNameSpace(this.doc.getRootElement(), null);
					}

					// We generate the TreeNode_API object only if there is a document in the main
					// input table.
					void generateElements(boolean isInnerJoin, row6Struct row6, Var__tXMLMap_5__Struct Var) {

						/*
						 * if(this.treeNodeAPI==null) { this.treeNodeAPI = treeNodeAPI; }
						 */

						org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
						if (needRoot) {
							needRoot = false;
							org.dom4j.Element root = null;
							root = org.dom4j.DocumentHelper.createElement("root");
							doc.add(root);
							subTreeRootParent = root;
							org.dom4j.Element root_0 = null;
							root_0 = root.addElement("message");
							valueMap.put("root_0", row6.newColumn + " has beed deleted from table: " + context.tableName
									+ " and database: " + context.databaseName);
							if (valueMap.get("root_0") != null) {
								routines.system.NestXMLTool.setText(root_0,
										FormatterUtils.fm(valueMap.get("root_0"), null));
							}
							root4Group = subTreeRootParent;
						} else {
							subTreeRootParent = root4Group;
						}
						/* build group xml tree */
						boolean isNewElement = false;
						isNewElement = false;
					}
				}

				/**
				 * [tXMLMap_5 begin ] stop
				 */

				/**
				 * [tDBRow_1 begin ] start
				 */

				sh("tDBRow_1");

				s(currentComponent = "tDBRow_1");

				int tos_count_tDBRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBRow_1 = new StringBuilder();
							log4jParamters_tDBRow_1.append("Parameters:");
							log4jParamters_tDBRow_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DRIVER" + " = " + "MSSQL_PROP");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("HOST" + " = " + "\"98.70.31.45\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PORT" + " = " + "\"1433\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DB_SCHEMA" + " = " + "context.databaseName");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DBNAME" + " = " + "\"Insurance_ETE\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("USER" + " = " + "\"QDI4\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:YQqs6YvWhmZqHfquxz7CIKZ3eM/Iz7PIVzumULiyNaUL9Xkebc/QVpY=")
									.substring(0, 4) + "...");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("IDENTITY_INSERT" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERYSTORE" + " = " + "");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("QUERY" + " = "
									+ "/*\"DELETE FROM \" + context.tableName + \" WHERE customer_id = '\" + context.customerId + \"'\"  */  \"DELETE FROM \" + context.databaseName + \".\" + context.tableName + \" WHERE customer_id = '\" + context.customerId + \"'\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PROPERTIES" + " = " + "\"\"");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("ACTIVE_DIR_AUTH" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("ENABLE_ALWAYS_ENCRYPTED" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("PROPAGATE_RECORD_SET" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("USE_PREPAREDSTATEMENT" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("SET_QUERY_TIMEOUT" + " = " + "false");
							log4jParamters_tDBRow_1.append(" | ");
							log4jParamters_tDBRow_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlRow");
							log4jParamters_tDBRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBRow_1 - " + (log4jParamters_tDBRow_1));
						}
					}
					new BytesLimit65535_tDBRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBRow_1", "tDBRow_1", "tMSSqlRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				java.sql.Connection conn_tDBRow_1 = null;
				String query_tDBRow_1 = "";
				boolean whetherReject_tDBRow_1 = false;
				int count_tDBRow_1 = 0;
				String driverClass_tDBRow_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBRow_1 = java.lang.Class.forName(driverClass_tDBRow_1);

				String port_tDBRow_1 = "1433";
				String dbname_tDBRow_1 = "Insurance_ETE";

				String url_tDBRow_1 = "jdbc:sqlserver://" + "98.70.31.45";

				if (!"".equals(port_tDBRow_1)) {
					url_tDBRow_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBRow_1)) {

					url_tDBRow_1 += ";databaseName=" + "Insurance_ETE";

				}
				url_tDBRow_1 += ";appName=" + projectName + ";" + "";

				log.debug("tDBRow_1 - Driver ClassName: " + driverClass_tDBRow_1 + ".");

				String dbUser_tDBRow_1 = "QDI4";

				final String decryptedPassword_tDBRow_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:qm02JSId6yOLX9T5+6Ya5xWVSROkRRrvBz953F2Z4fxbvDC4svpbVsk=");

				String dbPwd_tDBRow_1 = decryptedPassword_tDBRow_1;

				log.debug("tDBRow_1 - Connection attempt to '"
						+ url_tDBRow_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' with the username '"
						+ dbUser_tDBRow_1 + "'.");

				conn_tDBRow_1 = java.sql.DriverManager.getConnection(url_tDBRow_1, dbUser_tDBRow_1, dbPwd_tDBRow_1);

				log.debug("tDBRow_1 - Connection to '"
						+ url_tDBRow_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' has succeeded.");

				resourceMap.put("conn_tDBRow_1", conn_tDBRow_1);
				if (conn_tDBRow_1.getAutoCommit()) {

					log.debug("tDBRow_1 - Connection is set auto commit to 'false'.");

					conn_tDBRow_1.setAutoCommit(false);

				}
				int commitEvery_tDBRow_1 = 10000;
				int commitCounter_tDBRow_1 = 0;

				java.sql.Statement stmt_tDBRow_1 = conn_tDBRow_1.createStatement();
				resourceMap.put("stmt_tDBRow_1", stmt_tDBRow_1);

				/**
				 * [tDBRow_1 begin ] stop
				 */

				/**
				 * [tDBRow_1 main ] start
				 */

				s(currentComponent = "tDBRow_1");

				row6 = null;

				query_tDBRow_1 = /*
									 * "DELETE FROM " + context.tableName + " WHERE customer_id = '" +
									 * context.customerId + "'"
									 */
						"DELETE FROM " + context.databaseName + "." + context.tableName + " WHERE customer_id = '"
								+ context.customerId + "'";
				whetherReject_tDBRow_1 = false;
				log.debug("tDBRow_1 - Executing the query: '" + query_tDBRow_1 + "'.");

				globalMap.put("tDBRow_1_QUERY", query_tDBRow_1);
				boolean isResultSet_tDBRow_1 = false;
				try {
					isResultSet_tDBRow_1 = stmt_tDBRow_1.execute(query_tDBRow_1);
					log.debug("tDBRow_1 - Execute the query: '" + query_tDBRow_1 + "' has finished.");

					java.sql.Statement commonSt_tDBRow_1 = null;
					java.sql.ResultSet rsMulti_tDBRow_1 = null;
					int rsCount_tDBRow_1 = -1;
					commonSt_tDBRow_1 = stmt_tDBRow_1;
					rsMulti_tDBRow_1 = stmt_tDBRow_1.getResultSet();
					do {
						if (isResultSet_tDBRow_1) {
							if (rsMulti_tDBRow_1 != null) {
								while (rsMulti_tDBRow_1.next()) {
									count_tDBRow_1++;
								}
							}
						} else {
							rsCount_tDBRow_1 = commonSt_tDBRow_1.getUpdateCount();
							if (rsCount_tDBRow_1 > 0) {
								count_tDBRow_1 += commonSt_tDBRow_1.getUpdateCount();
							}
						}
						isResultSet_tDBRow_1 = commonSt_tDBRow_1.getMoreResults();
						if (isResultSet_tDBRow_1)
							rsMulti_tDBRow_1 = commonSt_tDBRow_1.getResultSet();
					} while (isResultSet_tDBRow_1 || rsCount_tDBRow_1 != -1);
				} catch (java.lang.Exception e) {
					whetherReject_tDBRow_1 = true;

					log.error("tDBRow_1 - " + e.getMessage());

					System.err.print(e.getMessage());
					globalMap.put("tDBRow_1_ERROR_MESSAGE", e.getMessage());

				}

				if (!whetherReject_tDBRow_1) {

					row6 = new row6Struct();

				}

				commitCounter_tDBRow_1++;
				if (commitEvery_tDBRow_1 <= commitCounter_tDBRow_1) {

					log.debug("tDBRow_1 - Connection starting to commit.");

					conn_tDBRow_1.commit();

					log.debug("tDBRow_1 - Connection commit has succeeded.");

					commitCounter_tDBRow_1 = 0;
				}

				tos_count_tDBRow_1++;

				/**
				 * [tDBRow_1 main ] stop
				 */

				/**
				 * [tDBRow_1 process_data_begin ] start
				 */

				s(currentComponent = "tDBRow_1");

				/**
				 * [tDBRow_1 process_data_begin ] stop
				 */

// Start of branch "row6"
				if (row6 != null) {

					/**
					 * [tXMLMap_5 main ] start
					 */

					s(currentComponent = "tXMLMap_5");

					cLabel = "SetDeleteMesssage";

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row6", "tDBRow_1", "tDBRow_1", "tMSSqlRow", "tXMLMap_5", "SetDeleteMesssage", "tXMLMap"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row6 - " + (row6 == null ? "" : row6.toLogString()));
					}

					boolean rejectedInnerJoin_tXMLMap_5 = false;
					boolean rejectedDocInnerJoin_tXMLMap_5 = false;
					boolean mainRowRejected_tXMLMap_5 = false;
					boolean isMatchDocRowtXMLMap_5 = false;

					GenerateDocument_copyOfsendDeleteMessage1 gen_Doc_copyOfsendDeleteMessage1_tXMLMap_5 = new GenerateDocument_copyOfsendDeleteMessage1();
					copyOfsendDeleteMessage1_tmp.body = null;

					{ // start of Var scope

						// ###############################
						// # Vars tables

						Var__tXMLMap_5__Struct Var = Var__tXMLMap_5;
						// ###############################
						// # Output tables

						copyOfsendDeleteMessage1 = null;

// # Output table : 'copyOfsendDeleteMessage1'
						count_copyOfsendDeleteMessage1_tXMLMap_5++;

						gen_Doc_copyOfsendDeleteMessage1_tXMLMap_5.generateElements(rejectedDocInnerJoin_tXMLMap_5,
								row6, Var);

						if (copyOfsendDeleteMessage1_tmp.body == null) {
							copyOfsendDeleteMessage1_tmp.body = new routines.system.Document();
							copyOfsendDeleteMessage1_tmp.body
									.setDocument(gen_Doc_copyOfsendDeleteMessage1_tXMLMap_5.getDocument());
						}

						copyOfsendDeleteMessage1 = copyOfsendDeleteMessage1_tmp;
						copyOfsendDeleteMessage1_save = copyOfsendDeleteMessage1_tmp;
						log.debug("tXMLMap_5 - Outputting the record " + count_copyOfsendDeleteMessage1_tXMLMap_5
								+ " of the output table 'copyOfsendDeleteMessage1'.");

// ###############################

					} // end of Var scope

					rejectedInnerJoin_tXMLMap_5 = false;

					tos_count_tXMLMap_5++;

					/**
					 * [tXMLMap_5 main ] stop
					 */

					/**
					 * [tXMLMap_5 process_data_begin ] start
					 */

					s(currentComponent = "tXMLMap_5");

					cLabel = "SetDeleteMesssage";

					/**
					 * [tXMLMap_5 process_data_begin ] stop
					 */

// Start of branch "copyOfsendDeleteMessage1"
					if (copyOfsendDeleteMessage1 != null) {

						/**
						 * [tLogRow_5 main ] start
						 */

						s(currentComponent = "tLogRow_5");

						cLabel = "LogDeleteAction";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "copyOfsendDeleteMessage1", "tXMLMap_5", "SetDeleteMesssage", "tXMLMap", "tLogRow_5",
								"LogDeleteAction", "tLogRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("copyOfsendDeleteMessage1 - "
									+ (copyOfsendDeleteMessage1 == null ? "" : copyOfsendDeleteMessage1.toLogString()));
						}

///////////////////////		

						String[] row_tLogRow_5 = new String[1];

						if (copyOfsendDeleteMessage1.body != null) { //
							row_tLogRow_5[0] = String.valueOf(copyOfsendDeleteMessage1.body);

						} //

						util_tLogRow_5.addRow(row_tLogRow_5);
						nb_line_tLogRow_5++;
						log.info("tLogRow_5 - Content of row " + nb_line_tLogRow_5 + ": "
								+ TalendString.unionString("|", row_tLogRow_5));
//////

//////                    

///////////////////////    			

						row7 = copyOfsendDeleteMessage1;

						tos_count_tLogRow_5++;

						/**
						 * [tLogRow_5 main ] stop
						 */

						/**
						 * [tLogRow_5 process_data_begin ] start
						 */

						s(currentComponent = "tLogRow_5");

						cLabel = "LogDeleteAction";

						/**
						 * [tLogRow_5 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_3 main ] start
						 */

						s(currentComponent = "tRESTResponse_3");

						cLabel = "DeleteResponse";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row7", "tLogRow_5", "LogDeleteAction", "tLogRow", "tRESTResponse_3",
								"DeleteResponse", "tRESTResponse"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row7 - " + (row7 == null ? "" : row7.toLogString()));
						}

						java.io.OutputStream outputStream_tRESTResponse_3 = (java.io.OutputStream) globalMap
								.get("restResponseStream");
						boolean responseAlreadySent_tRESTResponse_3 = globalMap.containsKey("restResponse");

						if (null == outputStream_tRESTResponse_3 && responseAlreadySent_tRESTResponse_3) {
							throw new RuntimeException("Rest response already sent.");
						} else if (!globalMap.containsKey("restRequest")) {
							throw new RuntimeException("Not received rest request yet.");
						} else {
							Integer restProviderStatusCode_tRESTResponse_3 = 200;

							Object restProviderResponse_tRESTResponse_3 = null;
							if (null != row7.body) {
								restProviderResponse_tRESTResponse_3 = row7.body.getDocument();
							}

							java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_3 = new java.util.TreeMap<String, String>(
									String.CASE_INSENSITIVE_ORDER);
							java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_3 = new java.lang.StringBuilder();
							final String setCookieHeader = "Set-Cookie";

							if (restProviderResponseHeader_cookies_tRESTResponse_3.length() > 0) {
								restProviderResponseHeaders_tRESTResponse_3.put(setCookieHeader,
										restProviderResponseHeader_cookies_tRESTResponse_3.toString());
							}

							java.util.Map<String, Object> restRequest_tRESTResponse_3 = (java.util.Map<String, Object>) globalMap
									.get("restRequest");
							org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_3 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_3
									.get("MESSAGE_CONTEXT");

							if (null == outputStream_tRESTResponse_3) {
								java.util.Map<String, Object> restResponse_tRESTResponse_3 = new java.util.HashMap<String, Object>();
								restResponse_tRESTResponse_3.put("BODY", restProviderResponse_tRESTResponse_3);
								restResponse_tRESTResponse_3.put("STATUS", restProviderStatusCode_tRESTResponse_3);
								restResponse_tRESTResponse_3.put("HEADERS",
										restProviderResponseHeaders_tRESTResponse_3);
								restResponse_tRESTResponse_3.put("drop.json.root.element", Boolean.valueOf(false));
								globalMap.put("restResponse", restResponse_tRESTResponse_3);

							} else {

								jakarta.ws.rs.core.MediaType responseMediaType_tRESTResponse_3 = null;
								if (!responseAlreadySent_tRESTResponse_3) {
									org.apache.cxf.message.Message currentMessage = null;
									if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
										currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
									} else {
										currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_3
												.get("CURRENT_MESSAGE"));
									}

									if (currentMessage != null && currentMessage.getExchange() != null) {
										currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
												true);
									}

									messageContext_tRESTResponse_3.put(org.apache.cxf.message.Message.RESPONSE_CODE,
											restProviderStatusCode_tRESTResponse_3);
									jakarta.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_3 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
									for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_3
											.entrySet()) {
										headersMultivaluedMap_tRESTResponse_3.putSingle(multivaluedHeader.getKey(),
												multivaluedHeader.getValue());
									}
									messageContext_tRESTResponse_3.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
											headersMultivaluedMap_tRESTResponse_3);

									String responseContentType_tRESTResponse_3 = null;

									if (currentMessage != null && currentMessage.getExchange() != null) {
										responseContentType_tRESTResponse_3 = (String) currentMessage.getExchange()
												.get(org.apache.cxf.message.Message.CONTENT_TYPE);
									}

									if (null == responseContentType_tRESTResponse_3) {
										// this should not be needed, just in case. set it to the first value in the
										// sorted list returned from HttpHeaders
										responseMediaType_tRESTResponse_3 = messageContext_tRESTResponse_3
												.getHttpHeaders().getAcceptableMediaTypes().get(0);
									} else {
										responseMediaType_tRESTResponse_3 = org.apache.cxf.jaxrs.utils.JAXRSUtils
												.toMediaType(responseContentType_tRESTResponse_3);
									}
									globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_3);

									String responseMediaSubType_tRESTResponse_3 = responseMediaType_tRESTResponse_3
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_3.equals("xml")
											|| responseMediaSubType_tRESTResponse_3.endsWith("+xml")) {
										outputStream_tRESTResponse_3.write("<wrapper>".getBytes());
										globalMap.put("restResponseWrappingClosure", "</wrapper>");
									}
									if (responseMediaSubType_tRESTResponse_3.equals("json")
											|| responseMediaSubType_tRESTResponse_3.endsWith("+json")) {
										outputStream_tRESTResponse_3.write("[".getBytes());
										globalMap.put("restResponseWrappingClosure", "]");
									}

									globalMap.put("restResponse", true);
								} else {
									responseMediaType_tRESTResponse_3 = (jakarta.ws.rs.core.MediaType) globalMap
											.get("restResponseMediaType");
								}

								if (null != restProviderResponse_tRESTResponse_3) {
									String responseMediaSubType_tRESTResponse_3 = responseMediaType_tRESTResponse_3
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_3.equals("json")
											|| responseMediaSubType_tRESTResponse_3.endsWith("+json")) {
										if (globalMap.containsKey("restResponseJsonStarted")) {
											outputStream_tRESTResponse_3.write(",".getBytes());
										} else {
											globalMap.put("restResponseJsonStarted", true);
										}
									}

									Class<? extends Object> responseBodyClass_tRESTResponse_3 = restProviderResponse_tRESTResponse_3
											.getClass();
									jakarta.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_3 = messageContext_tRESTResponse_3
											.getProviders();
									jakarta.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_3 = messageBodyProviders_tRESTResponse_3
											.getMessageBodyWriter(responseBodyClass_tRESTResponse_3,
													responseBodyClass_tRESTResponse_3, null,
													responseMediaType_tRESTResponse_3);

									if (messageBodyWriter_tRESTResponse_3 instanceof StreamingDOM4JProvider) {
										((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_3)
												.setGlobalMap(globalMap);
									}

									messageBodyWriter_tRESTResponse_3.writeTo(restProviderResponse_tRESTResponse_3,
											responseBodyClass_tRESTResponse_3, responseBodyClass_tRESTResponse_3,
											new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_3,
											null, outputStream_tRESTResponse_3);
								}
								// initial variant
								// outputStream_tRESTResponse_3.write(String.valueOf(restProviderResponse_tRESTResponse_3).getBytes());
								outputStream_tRESTResponse_3.flush();
							}
						}

						tos_count_tRESTResponse_3++;

						/**
						 * [tRESTResponse_3 main ] stop
						 */

						/**
						 * [tRESTResponse_3 process_data_begin ] start
						 */

						s(currentComponent = "tRESTResponse_3");

						cLabel = "DeleteResponse";

						/**
						 * [tRESTResponse_3 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_3 process_data_end ] start
						 */

						s(currentComponent = "tRESTResponse_3");

						cLabel = "DeleteResponse";

						/**
						 * [tRESTResponse_3 process_data_end ] stop
						 */

						/**
						 * [tLogRow_5 process_data_end ] start
						 */

						s(currentComponent = "tLogRow_5");

						cLabel = "LogDeleteAction";

						/**
						 * [tLogRow_5 process_data_end ] stop
						 */

					} // End of branch "copyOfsendDeleteMessage1"

					/**
					 * [tXMLMap_5 process_data_end ] start
					 */

					s(currentComponent = "tXMLMap_5");

					cLabel = "SetDeleteMesssage";

					/**
					 * [tXMLMap_5 process_data_end ] stop
					 */

				} // End of branch "row6"

				/**
				 * [tDBRow_1 process_data_end ] start
				 */

				s(currentComponent = "tDBRow_1");

				/**
				 * [tDBRow_1 process_data_end ] stop
				 */

				/**
				 * [tDBRow_1 end ] start
				 */

				s(currentComponent = "tDBRow_1");

				globalMap.put("tDBRow_1_NB_LINE", count_tDBRow_1);
				stmt_tDBRow_1.close();
				resourceMap.remove("stmt_tDBRow_1");
				resourceMap.put("statementClosed_tDBRow_1", true);
				if (commitEvery_tDBRow_1 > commitCounter_tDBRow_1) {

					log.debug("tDBRow_1 - Connection starting to commit.");

					conn_tDBRow_1.commit();

					log.debug("tDBRow_1 - Connection commit has succeeded.");

					commitCounter_tDBRow_1 = 0;

				}
				log.debug("tDBRow_1 - Closing the connection to the database.");

				conn_tDBRow_1.close();

				if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
						&& routines.system.BundleUtils.inOSGi()) {
					Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").getMethod("checkedShutdown")
							.invoke(null, (Object[]) null);
				}

				log.debug("tDBRow_1 - Connection to the database closed.");

				resourceMap.put("finish_tDBRow_1", true);

				if (log.isDebugEnabled())
					log.debug("tDBRow_1 - " + ("Done."));

				ok_Hash.put("tDBRow_1", true);
				end_Hash.put("tDBRow_1", System.currentTimeMillis());

				/**
				 * [tDBRow_1 end ] stop
				 */

				/**
				 * [tXMLMap_5 end ] start
				 */

				s(currentComponent = "tXMLMap_5");

				cLabel = "SetDeleteMesssage";

				log.debug("tXMLMap_5 - Written records count in the table 'copyOfsendDeleteMessage1': "
						+ count_copyOfsendDeleteMessage1_tXMLMap_5 + ".");
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row6", 2, 0, "tDBRow_1",
						"tDBRow_1", "tMSSqlRow", "tXMLMap_5", "SetDeleteMesssage", "tXMLMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tXMLMap_5 - " + ("Done."));

				ok_Hash.put("tXMLMap_5", true);
				end_Hash.put("tXMLMap_5", System.currentTimeMillis());

				/**
				 * [tXMLMap_5 end ] stop
				 */

				/**
				 * [tLogRow_5 end ] start
				 */

				s(currentComponent = "tLogRow_5");

				cLabel = "LogDeleteAction";

//////

				java.io.PrintStream consoleOut_tLogRow_5 = null;
				if (globalMap.get("tLogRow_CONSOLE") != null) {
					consoleOut_tLogRow_5 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
				} else {
					consoleOut_tLogRow_5 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
					globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_5);
				}

				consoleOut_tLogRow_5.println(util_tLogRow_5.format().toString());
				consoleOut_tLogRow_5.flush();
//////
				globalMap.put("tLogRow_5_NB_LINE", nb_line_tLogRow_5);
				if (log.isInfoEnabled())
					log.info("tLogRow_5 - " + ("Printed row count: ") + (nb_line_tLogRow_5) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId,
						"copyOfsendDeleteMessage1", 2, 0, "tXMLMap_5", "SetDeleteMesssage", "tXMLMap", "tLogRow_5",
						"LogDeleteAction", "tLogRow", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_5 - " + ("Done."));

				ok_Hash.put("tLogRow_5", true);
				end_Hash.put("tLogRow_5", System.currentTimeMillis());

				/**
				 * [tLogRow_5 end ] stop
				 */

				/**
				 * [tRESTResponse_3 end ] start
				 */

				s(currentComponent = "tRESTResponse_3");

				cLabel = "DeleteResponse";

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row7", 2, 0,
						"tLogRow_5", "LogDeleteAction", "tLogRow", "tRESTResponse_3", "DeleteResponse", "tRESTResponse",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tRESTResponse_3", true);
				end_Hash.put("tRESTResponse_3", System.currentTimeMillis());

				/**
				 * [tRESTResponse_3 end ] stop
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
				 * [tDBRow_1 finally ] start
				 */

				s(currentComponent = "tDBRow_1");

				try {
					if (resourceMap.get("statementClosed_tDBRow_1") == null) {
						java.sql.Statement stmtToClose_tDBRow_1 = null;
						if ((stmtToClose_tDBRow_1 = (java.sql.Statement) resourceMap.remove("stmt_tDBRow_1")) != null) {
							stmtToClose_tDBRow_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBRow_1") == null) {
						java.sql.Connection ctn_tDBRow_1 = null;
						if ((ctn_tDBRow_1 = (java.sql.Connection) resourceMap.get("conn_tDBRow_1")) != null) {
							try {
								log.debug("tDBRow_1 - Closing the connection to the database.");

								ctn_tDBRow_1.close();
								log.debug("tDBRow_1 - Connection to the database closed.");

							} catch (java.sql.SQLException sqlEx_tDBRow_1) {
								String errorMessage_tDBRow_1 = "failed to close the connection in tDBRow_1 :"
										+ sqlEx_tDBRow_1.getMessage();
								log.error("tDBRow_1 - " + sqlEx_tDBRow_1.getMessage());

								System.err.println(errorMessage_tDBRow_1);
							}
						}
					}
				}

				/**
				 * [tDBRow_1 finally ] stop
				 */

				/**
				 * [tXMLMap_5 finally ] start
				 */

				s(currentComponent = "tXMLMap_5");

				cLabel = "SetDeleteMesssage";

				/**
				 * [tXMLMap_5 finally ] stop
				 */

				/**
				 * [tLogRow_5 finally ] start
				 */

				s(currentComponent = "tLogRow_5");

				cLabel = "LogDeleteAction";

				/**
				 * [tLogRow_5 finally ] stop
				 */

				/**
				 * [tRESTResponse_3 finally ] start
				 */

				s(currentComponent = "tRESTResponse_3");

				cLabel = "DeleteResponse";

				/**
				 * [tRESTResponse_3 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBRow_1_SUBPROCESS_STATE", 1);
	}

	public static class deleteCustomerStruct implements routines.system.IPersistableRow<deleteCustomerStruct> {
		final static byte[] commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];
		static byte[] commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[0];

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		public Boolean idIsNullable() {
			return true;
		}

		public Boolean idIsKey() {
			return false;
		}

		public Integer idLength() {
			return null;
		}

		public Integer idPrecision() {
			return null;
		}

		public String idDefault() {

			return null;

		}

		public String idComment() {

			return "";

		}

		public String idPattern() {

			return "";

		}

		public String idOriginalDbColumnName() {

			return "id";

		}

		public String tableId;

		public String getTableId() {
			return this.tableId;
		}

		public Boolean tableIdIsNullable() {
			return true;
		}

		public Boolean tableIdIsKey() {
			return false;
		}

		public Integer tableIdLength() {
			return null;
		}

		public Integer tableIdPrecision() {
			return null;
		}

		public String tableIdDefault() {

			return null;

		}

		public String tableIdComment() {

			return "";

		}

		public String tableIdPattern() {

			return "";

		}

		public String tableIdOriginalDbColumnName() {

			return "tableId";

		}

		private Integer readInteger(ObjectInputStream dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException {
			Integer intReturn;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				intReturn = null;
			} else {
				intReturn = dis.readInt();
			}
			return intReturn;
		}

		private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException {
			if (intNum == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeInt(intNum);
			}
		}

		private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (intNum == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeInt(intNum);
			}
		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				dis.readFully(commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0,
						length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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
				if (length > commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length) {
					if (length < 1024
							&& commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.length == 0) {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[1024];
					} else {
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request = new byte[2
								* length];
					}
				}
				unmarshaller.readFully(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length);
				strReturn = new String(
						commonByteArray_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request, 0, length,
						utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.tableId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request) {

				try {

					int length = 0;

					this.id = readInteger(dis);

					this.tableId = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.tableId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// Integer

				writeInteger(this.id, dos);

				// String

				writeString(this.tableId, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + String.valueOf(id));
			sb.append(",tableId=" + tableId);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (id == null) {
				sb.append("<null>");
			} else {
				sb.append(id);
			}

			sb.append("|");

			if (tableId == null) {
				sb.append("<null>");
			} else {
				sb.append(tableId);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(deleteCustomerStruct other) {

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

	public void tRESTRequest_2_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTRequest_2_Loop_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tRESTRequest_2_Loop", "46FV5R_");

		String currentVirtualComponent = null;

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

				deleteCustomerStruct deleteCustomer = new deleteCustomerStruct();

				/**
				 * [tRESTRequest_2_Loop begin ] start
				 */

				int NB_ITERATE_tRESTRequest_2_In = 0; // for statistics

				sh("tRESTRequest_2_Loop");

				currentVirtualComponent = "tRESTRequest_2";

				s(currentComponent = "tRESTRequest_2_Loop");

				int tos_count_tRESTRequest_2_Loop = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTRequest_2_Loop", "DeleteCustomerFromTable_Loop", "tRESTRequestLoop");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				runStat.updateStatAndLog(execStat, enableLogStash, iterateId, 0, 0, "deleteCustomer");

				deleteCustomer = null;

				int nb_line_tRESTRequest_2 = 0;

				try {

					java.util.Map<String, Object> requestMessage_tRESTRequest_2 = (java.util.Map<String, Object>) globalMap
							.get("restRequest");

					restEndpoint = getRestEndpoint();

					if (null == requestMessage_tRESTRequest_2) {

						if (restTalendJobAlreadyStarted) {
							throw new RuntimeException("request is not provided");
						} else {
							if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
								String endpointUrl_tRESTRequest_2 = checkEndpointUrl(restEndpoint);
								// *** external thread for endpoint initialization
								thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this,
										endpointUrl_tRESTRequest_2);
								thread4RestServiceProviderEndpoint.start();
								// *** external thread for endpoint initialization
							}

							restTalendJobAlreadyStarted = true;

							if (runInDaemonMode) {
								Thread.currentThread();
								try {
									while (true) {
										Thread.sleep(60000);
									}
								} catch (InterruptedException e_tRESTRequest_2) {
									// e_tRESTRequest_2.printStackTrace();
									// throw new TalendException(e_tRESTRequest_2, "wholeJob", globalMap);
								}
							}
						}
						return;
					}

					requestMessage_tRESTRequest_2.put("CURRENT_MESSAGE",
							org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

					Object ctx_tRESTRequest_2 = requestMessage_tRESTRequest_2.get("MESSAGE_CONTEXT");
					if (ctx_tRESTRequest_2 != null
							&& ctx_tRESTRequest_2 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
						requestMessage_tRESTRequest_2.put("MESSAGE_CONTEXT",
								((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) ctx_tRESTRequest_2).get());
					}

					/**
					 * [tRESTRequest_2_Loop begin ] stop
					 */

					/**
					 * [tRESTRequest_2_Loop main ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_Loop");

					resourceMap.put("inIterateVComp", true);

					tos_count_tRESTRequest_2_Loop++;

					/**
					 * [tRESTRequest_2_Loop main ] stop
					 */

					/**
					 * [tRESTRequest_2_Loop process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_Loop");

					/**
					 * [tRESTRequest_2_Loop process_data_begin ] stop
					 */

					NB_ITERATE_tRESTRequest_2_In++;

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 1, "exec" + NB_ITERATE_tRESTRequest_2_In);
						// Thread.sleep(1000);
					}

					/**
					 * [tFlowToIterate_1 begin ] start
					 */

					int NB_ITERATE_tJava_1 = 0; // for statistics

					sh("tFlowToIterate_1");

					s(currentComponent = "tFlowToIterate_1");

					cLabel = "FlowToIterate";

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "deleteCustomer");

					int tos_count_tFlowToIterate_1 = 0;

					if (log.isDebugEnabled())
						log.debug("tFlowToIterate_1 - " + ("Start to work."));
					if (log.isDebugEnabled()) {
						class BytesLimit65535_tFlowToIterate_1 {
							public void limitLog4jByte() throws Exception {
								StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
								log4jParamters_tFlowToIterate_1.append("Parameters:");
								log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "true");
								log4jParamters_tFlowToIterate_1.append(" | ");
								if (log.isDebugEnabled())
									log.debug("tFlowToIterate_1 - " + (log4jParamters_tFlowToIterate_1));
							}
						}
						new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
					}
					if (enableLogStash) {
						talendJobLog.addCM("tFlowToIterate_1", "FlowToIterate", "tFlowToIterate");
						talendJobLogProcess(globalMap);
						s(currentComponent);
					}

					int nb_line_tFlowToIterate_1 = 0;
					int counter_tFlowToIterate_1 = 0;

					/**
					 * [tFlowToIterate_1 begin ] stop
					 */

					/**
					 * [tRESTRequest_2_In begin ] start
					 */

					sh("tRESTRequest_2_In");

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_In");

					int tos_count_tRESTRequest_2_In = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tRESTRequest_2_In", "DeleteCustomerFromTable_In", "tRESTRequestIn");
						talendJobLogProcess(globalMap);
						s(currentComponent);
					}

					resourceMap.remove("inIterateVComp");

					/**
					 * [tRESTRequest_2_In begin ] stop
					 */

					/**
					 * [tRESTRequest_2_In main ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_In");

					if (requestMessage_tRESTRequest_2.containsKey("ERROR")) { // wrong request received
						deleteCustomer = null;
					} else { // non-error (not wrong request)

						String matchedUriPattern_tRESTRequest_2 = (String) requestMessage_tRESTRequest_2.get("PATTERN");
						String matchedFlow_tRESTRequest_2 = (String) requestMessage_tRESTRequest_2.get("OPERATION");

						java.util.Map<String, Object> params_tRESTRequest_2 = (java.util.Map<String, Object>) requestMessage_tRESTRequest_2
								.get("PARAMS");
						if (matchedFlow_tRESTRequest_2.equals("deleteCustomer")) {
							deleteCustomer = new deleteCustomerStruct();
							if (params_tRESTRequest_2.containsKey("PATH:id:id_Integer")) {

								deleteCustomer.id = (Integer) params_tRESTRequest_2.get("PATH:id:id_Integer");

							}
							if (params_tRESTRequest_2.containsKey("PATH:tableId:id_String")) {

								deleteCustomer.tableId = (String) params_tRESTRequest_2.get("PATH:tableId:id_String");

							}
						} else { // non matched flow
							deleteCustomer = null;
						}

					}

					globalMap.put("tRESTRequest_2_URI", (String) requestMessage_tRESTRequest_2.get("URI"));
					globalMap.put("tRESTRequest_2_URI_BASE", (String) requestMessage_tRESTRequest_2.get("URI_BASE"));
					globalMap.put("tRESTRequest_2_URI_ABSOLUTE",
							(String) requestMessage_tRESTRequest_2.get("URI_ABSOLUTE"));
					globalMap.put("tRESTRequest_2_URI_REQUEST",
							(String) requestMessage_tRESTRequest_2.get("URI_REQUEST"));
					globalMap.put("tRESTRequest_2_HTTP_METHOD", (String) requestMessage_tRESTRequest_2.get("VERB"));

					globalMap.put("tRESTRequest_2_ATTACHMENT_HEADERS",
							requestMessage_tRESTRequest_2.get("ATTACHMENT_HEADERS"));
					globalMap.put("tRESTRequest_2_ATTACHMENT_FILENAMES",
							requestMessage_tRESTRequest_2.get("ATTACHMENT_FILENAMES"));

					globalMap.put("tRESTRequest_2_PRINCIPAL_NAME",
							(String) requestMessage_tRESTRequest_2.get("PRINCIPAL_NAME"));
					globalMap.put("tRESTRequest_2_CORRELATION_ID",
							(String) requestMessage_tRESTRequest_2.get("CorrelationID"));

					tos_count_tRESTRequest_2_In++;

					/**
					 * [tRESTRequest_2_In main ] stop
					 */

					/**
					 * [tRESTRequest_2_In process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_In");

					/**
					 * [tRESTRequest_2_In process_data_begin ] stop
					 */

// Start of branch "deleteCustomer"
					if (deleteCustomer != null) {

						/**
						 * [tFlowToIterate_1 main ] start
						 */

						s(currentComponent = "tFlowToIterate_1");

						cLabel = "FlowToIterate";

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "deleteCustomer", "tRESTRequest_2_In", "DeleteCustomerFromTable_In", "tRESTRequestIn",
								"tFlowToIterate_1", "FlowToIterate", "tFlowToIterate"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace(
									"deleteCustomer - " + (deleteCustomer == null ? "" : deleteCustomer.toLogString()));
						}

						if (log.isTraceEnabled())
							log.trace("tFlowToIterate_1 - " + ("Set global var, key=deleteCustomer.id, value=")
									+ (deleteCustomer.id) + ("."));
						globalMap.put("deleteCustomer.id", deleteCustomer.id);

						if (log.isTraceEnabled())
							log.trace("tFlowToIterate_1 - " + ("Set global var, key=deleteCustomer.tableId, value=")
									+ (deleteCustomer.tableId) + ("."));
						globalMap.put("deleteCustomer.tableId", deleteCustomer.tableId);

						nb_line_tFlowToIterate_1++;
						counter_tFlowToIterate_1++;
						if (log.isDebugEnabled())
							log.debug("tFlowToIterate_1 - " + ("Current iteration is: ") + (counter_tFlowToIterate_1)
									+ ("."));
						globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);

						tos_count_tFlowToIterate_1++;

						/**
						 * [tFlowToIterate_1 main ] stop
						 */

						/**
						 * [tFlowToIterate_1 process_data_begin ] start
						 */

						s(currentComponent = "tFlowToIterate_1");

						if (deleteCustomer != null) {

							cLabel = "FlowToIterate";

						}

						/**
						 * [tFlowToIterate_1 process_data_begin ] stop
						 */

						NB_ITERATE_tJava_1++;

						if (execStat) {
							runStat.updateStatOnConnection("row1", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("row7", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("OnComponentOk1", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("OnRowsEnd", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("databaseId", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("OnRowsEnd", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("row5", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("copyOfsetToken", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("sendTable", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("OnSubjobOk4", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("row2", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("row3", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("row4", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("copyOfsendDeleteMessage1", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("OnSubjobOk3", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("setTableName", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("row6", 3, 0);
						}

						if (execStat) {
							runStat.updateStatOnConnection("iterate1", 1, "exec" + NB_ITERATE_tJava_1);
							// Thread.sleep(1000);
						}

						/**
						 * [tJava_1 begin ] start
						 */

						sh("tJava_1");

						s(currentComponent = "tJava_1");

						cLabel = "SaveParametersAsContexts";

						int tos_count_tJava_1 = 0;

						if (enableLogStash) {
							talendJobLog.addCM("tJava_1", "SaveParametersAsContexts", "tJava");
							talendJobLogProcess(globalMap);
							s(currentComponent);
						}

						context.tableId = ((String) globalMap.get("deleteCustomer.tableId"));
						context.customerId = ((Integer) globalMap.get("deleteCustomer.id"));
						System.out.println(context.customerId);
						System.out.println(context.tableId);

						/**
						 * [tJava_1 begin ] stop
						 */

						/**
						 * [tJava_1 main ] start
						 */

						s(currentComponent = "tJava_1");

						cLabel = "SaveParametersAsContexts";

						tos_count_tJava_1++;

						/**
						 * [tJava_1 main ] stop
						 */

						/**
						 * [tJava_1 process_data_begin ] start
						 */

						s(currentComponent = "tJava_1");

						cLabel = "SaveParametersAsContexts";

						/**
						 * [tJava_1 process_data_begin ] stop
						 */

						/**
						 * [tJava_1 process_data_end ] start
						 */

						s(currentComponent = "tJava_1");

						cLabel = "SaveParametersAsContexts";

						/**
						 * [tJava_1 process_data_end ] stop
						 */

						/**
						 * [tJava_1 end ] start
						 */

						s(currentComponent = "tJava_1");

						cLabel = "SaveParametersAsContexts";

						ok_Hash.put("tJava_1", true);
						end_Hash.put("tJava_1", System.currentTimeMillis());

						if (execStat) {
							runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
						}
						tFixedFlowInput_2Process(globalMap);

						/**
						 * [tJava_1 end ] stop
						 */

						if (execStat) {
							runStat.updateStatOnConnection("iterate1", 2, "exec" + NB_ITERATE_tJava_1);
						}

						/**
						 * [tFlowToIterate_1 process_data_end ] start
						 */

						s(currentComponent = "tFlowToIterate_1");

						if (deleteCustomer != null) {

							cLabel = "FlowToIterate";

						}

						/**
						 * [tFlowToIterate_1 process_data_end ] stop
						 */

					} // End of branch "deleteCustomer"

					/**
					 * [tRESTRequest_2_In process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_In");

					/**
					 * [tRESTRequest_2_In process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_2_In end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_In");

					resourceMap.put("inIterateVComp", true);

					ok_Hash.put("tRESTRequest_2_In", true);
					end_Hash.put("tRESTRequest_2_In", System.currentTimeMillis());

					/**
					 * [tRESTRequest_2_In end ] stop
					 */

					/**
					 * [tFlowToIterate_1 end ] start
					 */

					s(currentComponent = "tFlowToIterate_1");

					if (deleteCustomer != null) {

						cLabel = "FlowToIterate";

						globalMap.put("tFlowToIterate_1_NB_LINE", nb_line_tFlowToIterate_1);
						if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "deleteCustomer",
								2, 0, "tRESTRequest_2_In", "DeleteCustomerFromTable_In", "tRESTRequestIn",
								"tFlowToIterate_1", "FlowToIterate", "tFlowToIterate", "output")) {
							talendJobLogProcess(globalMap);
						}

						if (log.isDebugEnabled())
							log.debug("tFlowToIterate_1 - " + ("Done."));

						ok_Hash.put("tFlowToIterate_1", true);
						end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());

					}

					/**
					 * [tFlowToIterate_1 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 2, "exec" + NB_ITERATE_tRESTRequest_2_In);
					}

					/**
					 * [tRESTRequest_2_Loop process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_Loop");

					/**
					 * [tRESTRequest_2_Loop process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_2_Loop end ] start
					 */

					currentVirtualComponent = "tRESTRequest_2";

					s(currentComponent = "tRESTRequest_2_Loop");

					resourceMap.remove("inIterateVComp");

				} catch (Throwable e_tRESTRequest_2) {
					if (e_tRESTRequest_2 instanceof Exception) {
						new TalendException((Exception) e_tRESTRequest_2, currentComponent, globalMap)
								.printStackTrace();
					} else {
						new TalendException(new RuntimeException(e_tRESTRequest_2), currentComponent, globalMap)
								.printStackTrace();
					}
					if (!globalMap.containsKey("restResponse")) {
						java.util.Map<String, Object> restFault_tRESTRequest_2 = new java.util.HashMap<String, Object>();
						restFault_tRESTRequest_2.put("STATUS", 500);
						restFault_tRESTRequest_2.put("BODY", e_tRESTRequest_2.getMessage());
						globalMap.put("restResponse", restFault_tRESTRequest_2);
					}
					return;
				}
				nb_line_tRESTRequest_2++;
				globalMap.put("tRESTRequest_2_NB_LINE", nb_line_tRESTRequest_2);

				runStat.updateStatAndLog(execStat, enableLogStash, iterateId, 2, 0, "deleteCustomer");

				ok_Hash.put("tRESTRequest_2_Loop", true);
				end_Hash.put("tRESTRequest_2_Loop", System.currentTimeMillis());

				/**
				 * [tRESTRequest_2_Loop end ] stop
				 */

			} // end the resume

		} catch (java.lang.Exception e) {

			if (!(e instanceof TalendException)) {
				log.fatal(currentComponent + " " + e.getMessage(), e);
			}

			TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);

			te.setVirtualComponentName(currentVirtualComponent);

			throw te;
		} catch (java.lang.Error error) {

			runStat.stopThreadStat();

			throw error;
		} finally {

			try {

				/**
				 * [tRESTRequest_2_Loop finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_2";

				s(currentComponent = "tRESTRequest_2_Loop");

				/**
				 * [tRESTRequest_2_Loop finally ] stop
				 */

				/**
				 * [tRESTRequest_2_In finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_2";

				s(currentComponent = "tRESTRequest_2_In");

				/**
				 * [tRESTRequest_2_In finally ] stop
				 */

				/**
				 * [tFlowToIterate_1 finally ] start
				 */

				s(currentComponent = "tFlowToIterate_1");

				cLabel = "FlowToIterate";

				/**
				 * [tFlowToIterate_1 finally ] stop
				 */

				/**
				 * [tJava_1 finally ] start
				 */

				s(currentComponent = "tJava_1");

				cLabel = "SaveParametersAsContexts";

				/**
				 * [tJava_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTRequest_2_Loop_SUBPROCESS_STATE", 1);
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

	private final static java.util.Properties jobInfo = new java.util.Properties();
	private final static java.util.Map<String, String> mdcInfo = new java.util.HashMap<>();
	private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();

	public static void main(String[] args) {
		final Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request Batch_Stewardship_Withdraw_Customers_Accepting_Delete_RequestClass = new Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request();

		int exitCode = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_RequestClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request' - Done.");
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
		log.info("TalendJob: 'Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_IIjBwFApEfC4ZuKDeZl3GA");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2025-06-26T09:34:09.945140600Z");

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
			java.io.InputStream inContext = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.class
					.getClassLoader().getResourceAsStream(
							"dpdp/batch_stewardship_withdraw_customers_accepting_delete_request_0_2/contexts/"
									+ contextStr + ".properties");
			if (inContext == null) {
				inContext = Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request.class.getClassLoader()
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
					context.setContextType("tableName", "id_String");
					if (context.getStringValue("tableName") == null) {
						context.tableName = null;
					} else {
						context.tableName = (String) context.getProperty("tableName");
					}
					context.setContextType("databaseName", "id_String");
					if (context.getStringValue("databaseName") == null) {
						context.databaseName = null;
					} else {
						context.databaseName = (String) context.getProperty("databaseName");
					}
					context.setContextType("token", "id_String");
					if (context.getStringValue("token") == null) {
						context.token = null;
					} else {
						context.token = (String) context.getProperty("token");
					}
					context.setContextType("tableId", "id_String");
					if (context.getStringValue("tableId") == null) {
						context.tableId = null;
					} else {
						context.tableId = (String) context.getProperty("tableId");
					}
					context.setContextType("customerId", "id_Integer");
					if (context.getStringValue("customerId") == null) {
						context.customerId = null;
					} else {
						try {
							context.customerId = routines.system.ParserUtils
									.parseTo_Integer(context.getProperty("customerId"));
						} catch (NumberFormatException e) {
							log.warn(String.format("Null value will be used for context parameter %s: %s", "customerId",
									e.getMessage()));
							context.customerId = null;
						}
					}
					context.setContextType("Stewardship_Password", "id_Password");
					if (context.getStringValue("Stewardship_Password") == null) {
						context.Stewardship_Password = null;
					} else {
						String pwd_Stewardship_Password_value = context.getProperty("Stewardship_Password");
						context.Stewardship_Password = null;
						if (pwd_Stewardship_Password_value != null) {
							if (context_param.containsKey("Stewardship_Password")) {// no need to decrypt if it come
																					// from program argument or parent
																					// job runtime
								context.Stewardship_Password = pwd_Stewardship_Password_value;
							} else if (!pwd_Stewardship_Password_value.isEmpty()) {
								try {
									context.Stewardship_Password = routines.system.PasswordEncryptUtil
											.decryptPassword(pwd_Stewardship_Password_value);
									context.put("Stewardship_Password", context.Stewardship_Password);
								} catch (java.lang.RuntimeException e) {
									// do nothing
								}
							}
						}
					}
					context.setContextType("Stewardship_URL", "id_String");
					if (context.getStringValue("Stewardship_URL") == null) {
						context.Stewardship_URL = null;
					} else {
						context.Stewardship_URL = (String) context.getProperty("Stewardship_URL");
					}
					context.setContextType("Stewardship_UserName", "id_String");
					if (context.getStringValue("Stewardship_UserName") == null) {
						context.Stewardship_UserName = null;
					} else {
						context.Stewardship_UserName = (String) context.getProperty("Stewardship_UserName");
					}
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
			if (parentContextMap.containsKey("tableName")) {
				context.tableName = (String) parentContextMap.get("tableName");
			}
			if (parentContextMap.containsKey("databaseName")) {
				context.databaseName = (String) parentContextMap.get("databaseName");
			}
			if (parentContextMap.containsKey("token")) {
				context.token = (String) parentContextMap.get("token");
			}
			if (parentContextMap.containsKey("tableId")) {
				context.tableId = (String) parentContextMap.get("tableId");
			}
			if (parentContextMap.containsKey("customerId")) {
				context.customerId = (Integer) parentContextMap.get("customerId");
			}
			if (parentContextMap.containsKey("Stewardship_Password")) {
				context.Stewardship_Password = (java.lang.String) parentContextMap.get("Stewardship_Password");
			}
			if (parentContextMap.containsKey("Stewardship_URL")) {
				context.Stewardship_URL = (String) parentContextMap.get("Stewardship_URL");
			}
			if (parentContextMap.containsKey("Stewardship_UserName")) {
				context.Stewardship_UserName = (String) parentContextMap.get("Stewardship_UserName");
			}
		}

		// Resume: init the resumeUtil
		resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
		resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
		resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
		parametersToEncrypt.add("Stewardship_Password");
		// Resume: jobStart
		resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "",
				"", "", "", "", resumeUtil.convertToJsonText(context, ContextProperties.class, parametersToEncrypt));

		org.slf4j.MDC.put("_context", contextStr);
		log.info("TalendJob: 'Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request' - Started.");
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
			tRESTRequest_2_LoopProcess(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRESTRequest_2_Loop) {
			globalMap.put("tRESTRequest_2_Loop_SUBPROCESS_STATE", -1);

			e_tRESTRequest_2_Loop.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println((endUsedMemory - startUsedMemory)
					+ " bytes memory increase when running : Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request");
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
		log.info("TalendJob: 'Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request' - Finished - status: "
				+ status + " returnCode: " + returnCode);

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
 * 369885 characters generated by Talend Real-time Big Data Platform on the 26
 * June 2025 at 3:04:09 pm IST
 ************************************************************************************************/