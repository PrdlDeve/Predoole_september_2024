
package dpdp_renew.job1_tostewardship_0_1;

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

//the import part of tJavaRow_1
//import java.util.List;

@SuppressWarnings("unused")

/**
 * Job: Job1_ToStewardship Purpose: <br>
 * Description: <br>
 * 
 * @author Patil, Chirag
 * @version 8.0.1.20250521_1150-patch
 * @status
 */
public class Job1_ToStewardship implements TalendJob {
	static {
		System.setProperty("TalendJob.log", "Job1_ToStewardship.log");
	}

	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager
			.getLogger(Job1_ToStewardship.class);

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

			if (id != null) {

				this.setProperty("id", id.toString());

			}

			if (year != null) {

				this.setProperty("year", year.toString());

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

		public Integer id;

		public Integer getId() {
			return this.id;
		}

		public Integer year;

		public Integer getYear() {
			return this.year;
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
	private final String jobName = "Job1_ToStewardship";
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
			"_w59-wFJLEfCrKtHSlgxcqg", "0.1");
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
				Job1_ToStewardship.this.exception = e;
			}
			if (!(e instanceof TalendException)) {
				try {
					for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
						if (m.getName().compareTo(currentComponent + "_error") == 0) {
							m.invoke(Job1_ToStewardship.this, new Object[] { e, currentComponent, globalMap });
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

	public void tJavaRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap)
			throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBOutput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDataStewardshipTaskOutput_2_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tDBInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tFixedFlowInput_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tLogRow_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tXMLMap_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTResponse_1_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tRESTRequest_1_Loop_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		tRESTRequest_1_In_error(exception, errorComponent, globalMap);

	}

	public void tRESTRequest_1_In_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
	}

	public void talendJobLog_error(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		end_Hash.put(errorComponent, System.currentTimeMillis());

		status = "failure";

		talendJobLog_onSubJobError(exception, errorComponent, globalMap);
	}

	public void tDBInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tFixedFlowInput_1_onSubJobError(Exception exception, String errorComponent,
			final java.util.Map<String, Object> globalMap) throws TalendException {

		resumeUtil.addLog("SYSTEM_LOG", "NODE:" + errorComponent, "", Thread.currentThread().getId() + "", "FATAL", "",
				exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception), "");

	}

	public void tRESTRequest_1_Loop_onSubJobError(Exception exception, String errorComponent,
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
		return "http://localhost:8800/renew";
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

		private final Job1_ToStewardship job;

		public RestServiceProviderImpl4TalendJob() {
			this.job = new Job1_ToStewardship();
		}

		public RestServiceProviderImpl4TalendJob(Job1_ToStewardship job) {
			this.job = job;
		}

		private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap,
				Job1_ToStewardship job) {
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
				String taskExecutionId = Job1_ToStewardship.taskExecutionId;
				String jobExecutionId = Job1_ToStewardship.jobExecutionId;

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

				job.tRESTRequest_1_LoopProcess(globalMap);

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

						job.tRESTRequest_1_LoopProcess(globalMap);

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

		@jakarta.ws.rs.GET()

		@jakarta.ws.rs.Path("/customers/{id}/{year}")
		@jakarta.ws.rs.Produces({ "application/json" })
		public jakarta.ws.rs.core.Response post_log(

				@jakarta.ws.rs.PathParam("year") String year, @jakarta.ws.rs.PathParam("id") String id

		) {
			List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();
			if (requiredParameterWithNullValueList.size() > 0) {
				return handleWrongRequest(messageContext, 400,
						"400 Bad Request \n" + requiredParameterWithNullValueList.toString()
								+ " in tRESTRequest_1:post_log "
								+ (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));
			}
			java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			request_tRESTRequest_1.put("VERB", "GET");
			request_tRESTRequest_1.put("OPERATION", "post_log");
			request_tRESTRequest_1.put("PATTERN", "/customers/{id}/{year}");

			populateRequestInfo(request_tRESTRequest_1, messageContext);

			java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();

			parameters_tRESTRequest_1.put("PATH:year:id_String", year);

			parameters_tRESTRequest_1.put("PATH:id:id_String", id);

			request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);

			return processRequest(request_tRESTRequest_1);
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

		private final Job1_ToStewardship job;

		private org.apache.cxf.endpoint.Server server;

		private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

		public Thread4RestServiceProviderEndpoint(Job1_ToStewardship job, String endpointUrl) {
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
			java.io.InputStream inContext = Job1_ToStewardship.class.getClassLoader().getResourceAsStream(
					"dpdp_renew/job1_tostewardship_0_1/contexts/" + currentContext + ".properties");
			if (inContext == null) {
				inContext = Job1_ToStewardship.class.getClassLoader()
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

	public static class out2Struct implements routines.system.IPersistableRow<out2Struct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public int customer_id;

		public int getCustomer_id() {
			return this.customer_id;
		}

		public Boolean customer_idIsNullable() {
			return false;
		}

		public Boolean customer_idIsKey() {
			return false;
		}

		public Integer customer_idLength() {
			return 10;
		}

		public Integer customer_idPrecision() {
			return 0;
		}

		public String customer_idDefault() {

			return "";

		}

		public String customer_idComment() {

			return "";

		}

		public String customer_idPattern() {

			return "";

		}

		public String customer_idOriginalDbColumnName() {

			return "customer_id";

		}

		public String first_name;

		public String getFirst_name() {
			return this.first_name;
		}

		public Boolean first_nameIsNullable() {
			return true;
		}

		public Boolean first_nameIsKey() {
			return false;
		}

		public Integer first_nameLength() {
			return 107;
		}

		public Integer first_namePrecision() {
			return 0;
		}

		public String first_nameDefault() {

			return null;

		}

		public String first_nameComment() {

			return "";

		}

		public String first_namePattern() {

			return "";

		}

		public String first_nameOriginalDbColumnName() {

			return "first_name";

		}

		public String last_name;

		public String getLast_name() {
			return this.last_name;
		}

		public Boolean last_nameIsNullable() {
			return true;
		}

		public Boolean last_nameIsKey() {
			return false;
		}

		public Integer last_nameLength() {
			return 107;
		}

		public Integer last_namePrecision() {
			return 0;
		}

		public String last_nameDefault() {

			return null;

		}

		public String last_nameComment() {

			return "";

		}

		public String last_namePattern() {

			return "";

		}

		public String last_nameOriginalDbColumnName() {

			return "last_name";

		}

		public String Reason;

		public String getReason() {
			return this.Reason;
		}

		public Boolean ReasonIsNullable() {
			return true;
		}

		public Boolean ReasonIsKey() {
			return false;
		}

		public Integer ReasonLength() {
			return null;
		}

		public Integer ReasonPrecision() {
			return null;
		}

		public String ReasonDefault() {

			return null;

		}

		public String ReasonComment() {

			return "";

		}

		public String ReasonPattern() {

			return "";

		}

		public String ReasonOriginalDbColumnName() {

			return "Reason";

		}

		public String phone;

		public String getPhone() {
			return this.phone;
		}

		public Boolean phoneIsNullable() {
			return true;
		}

		public Boolean phoneIsKey() {
			return false;
		}

		public Integer phoneLength() {
			return 15;
		}

		public Integer phonePrecision() {
			return 0;
		}

		public String phoneDefault() {

			return null;

		}

		public String phoneComment() {

			return "";

		}

		public String phonePattern() {

			return "";

		}

		public String phoneOriginalDbColumnName() {

			return "phone";

		}

		public Integer year;

		public Integer getYear() {
			return this.year;
		}

		public Boolean yearIsNullable() {
			return true;
		}

		public Boolean yearIsKey() {
			return false;
		}

		public Integer yearLength() {
			return null;
		}

		public Integer yearPrecision() {
			return null;
		}

		public String yearDefault() {

			return null;

		}

		public String yearComment() {

			return "";

		}

		public String yearPattern() {

			return "";

		}

		public String yearOriginalDbColumnName() {

			return "year";

		}

		public java.util.Date log_time;

		public java.util.Date getLog_time() {
			return this.log_time;
		}

		public Boolean log_timeIsNullable() {
			return true;
		}

		public Boolean log_timeIsKey() {
			return false;
		}

		public Integer log_timeLength() {
			return null;
		}

		public Integer log_timePrecision() {
			return null;
		}

		public String log_timeDefault() {

			return null;

		}

		public String log_timeComment() {

			return "";

		}

		public String log_timePattern() {

			return "yyyy-MM-dd'T'HH:mm:ss.SSSSSS";

		}

		public String log_timeOriginalDbColumnName() {

			return "log_time";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.customer_id = dis.readInt();

					this.first_name = readString(dis);

					this.last_name = readString(dis);

					this.Reason = readString(dis);

					this.phone = readString(dis);

					this.year = readInteger(dis);

					this.log_time = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.customer_id = dis.readInt();

					this.first_name = readString(dis);

					this.last_name = readString(dis);

					this.Reason = readString(dis);

					this.phone = readString(dis);

					this.year = readInteger(dis);

					this.log_time = readDate(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.customer_id);

				// String

				writeString(this.first_name, dos);

				// String

				writeString(this.last_name, dos);

				// String

				writeString(this.Reason, dos);

				// String

				writeString(this.phone, dos);

				// Integer

				writeInteger(this.year, dos);

				// java.util.Date

				writeDate(this.log_time, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.customer_id);

				// String

				writeString(this.first_name, dos);

				// String

				writeString(this.last_name, dos);

				// String

				writeString(this.Reason, dos);

				// String

				writeString(this.phone, dos);

				// Integer

				writeInteger(this.year, dos);

				// java.util.Date

				writeDate(this.log_time, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("customer_id=" + String.valueOf(customer_id));
			sb.append(",first_name=" + first_name);
			sb.append(",last_name=" + last_name);
			sb.append(",Reason=" + Reason);
			sb.append(",phone=" + phone);
			sb.append(",year=" + String.valueOf(year));
			sb.append(",log_time=" + String.valueOf(log_time));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(customer_id);

			sb.append("|");

			if (first_name == null) {
				sb.append("<null>");
			} else {
				sb.append(first_name);
			}

			sb.append("|");

			if (last_name == null) {
				sb.append("<null>");
			} else {
				sb.append(last_name);
			}

			sb.append("|");

			if (Reason == null) {
				sb.append("<null>");
			} else {
				sb.append(Reason);
			}

			sb.append("|");

			if (phone == null) {
				sb.append("<null>");
			} else {
				sb.append(phone);
			}

			sb.append("|");

			if (year == null) {
				sb.append("<null>");
			} else {
				sb.append(year);
			}

			sb.append("|");

			if (log_time == null) {
				sb.append("<null>");
			} else {
				sb.append(log_time);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out2Struct other) {

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

	public static class out3Struct implements routines.system.IPersistableRow<out3Struct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public int Customer_Id;

		public int getCustomer_Id() {
			return this.Customer_Id;
		}

		public Boolean Customer_IdIsNullable() {
			return false;
		}

		public Boolean Customer_IdIsKey() {
			return false;
		}

		public Integer Customer_IdLength() {
			return null;
		}

		public Integer Customer_IdPrecision() {
			return null;
		}

		public String Customer_IdDefault() {

			return null;

		}

		public String Customer_IdComment() {

			return "integer";

		}

		public String Customer_IdPattern() {

			return "";

		}

		public String Customer_IdOriginalDbColumnName() {

			return "Customer_Id";

		}

		public String first_name;

		public String getFirst_name() {
			return this.first_name;
		}

		public Boolean first_nameIsNullable() {
			return false;
		}

		public Boolean first_nameIsKey() {
			return false;
		}

		public Integer first_nameLength() {
			return null;
		}

		public Integer first_namePrecision() {
			return null;
		}

		public String first_nameDefault() {

			return null;

		}

		public String first_nameComment() {

			return "text";

		}

		public String first_namePattern() {

			return "";

		}

		public String first_nameOriginalDbColumnName() {

			return "first_name";

		}

		public String last_name;

		public String getLast_name() {
			return this.last_name;
		}

		public Boolean last_nameIsNullable() {
			return false;
		}

		public Boolean last_nameIsKey() {
			return false;
		}

		public Integer last_nameLength() {
			return null;
		}

		public Integer last_namePrecision() {
			return null;
		}

		public String last_nameDefault() {

			return null;

		}

		public String last_nameComment() {

			return "text";

		}

		public String last_namePattern() {

			return "";

		}

		public String last_nameOriginalDbColumnName() {

			return "last_name";

		}

		public String email;

		public String getEmail() {
			return this.email;
		}

		public Boolean emailIsNullable() {
			return false;
		}

		public Boolean emailIsKey() {
			return false;
		}

		public Integer emailLength() {
			return null;
		}

		public Integer emailPrecision() {
			return null;
		}

		public String emailDefault() {

			return null;

		}

		public String emailComment() {

			return "text";

		}

		public String emailPattern() {

			return "";

		}

		public String emailOriginalDbColumnName() {

			return "email";

		}

		public String Phone;

		public String getPhone() {
			return this.Phone;
		}

		public Boolean PhoneIsNullable() {
			return false;
		}

		public Boolean PhoneIsKey() {
			return false;
		}

		public Integer PhoneLength() {
			return null;
		}

		public Integer PhonePrecision() {
			return null;
		}

		public String PhoneDefault() {

			return null;

		}

		public String PhoneComment() {

			return "text";

		}

		public String PhonePattern() {

			return "";

		}

		public String PhoneOriginalDbColumnName() {

			return "Phone";

		}

		public int Year;

		public int getYear() {
			return this.Year;
		}

		public Boolean YearIsNullable() {
			return false;
		}

		public Boolean YearIsKey() {
			return false;
		}

		public Integer YearLength() {
			return null;
		}

		public Integer YearPrecision() {
			return null;
		}

		public String YearDefault() {

			return null;

		}

		public String YearComment() {

			return "integer";

		}

		public String YearPattern() {

			return "";

		}

		public String YearOriginalDbColumnName() {

			return "Year";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.Customer_Id = dis.readInt();

					this.first_name = readString(dis);

					this.last_name = readString(dis);

					this.email = readString(dis);

					this.Phone = readString(dis);

					this.Year = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.Customer_Id = dis.readInt();

					this.first_name = readString(dis);

					this.last_name = readString(dis);

					this.email = readString(dis);

					this.Phone = readString(dis);

					this.Year = dis.readInt();

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// int

				dos.writeInt(this.Customer_Id);

				// String

				writeString(this.first_name, dos);

				// String

				writeString(this.last_name, dos);

				// String

				writeString(this.email, dos);

				// String

				writeString(this.Phone, dos);

				// int

				dos.writeInt(this.Year);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// int

				dos.writeInt(this.Customer_Id);

				// String

				writeString(this.first_name, dos);

				// String

				writeString(this.last_name, dos);

				// String

				writeString(this.email, dos);

				// String

				writeString(this.Phone, dos);

				// int

				dos.writeInt(this.Year);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Customer_Id=" + String.valueOf(Customer_Id));
			sb.append(",first_name=" + first_name);
			sb.append(",last_name=" + last_name);
			sb.append(",email=" + email);
			sb.append(",Phone=" + Phone);
			sb.append(",Year=" + String.valueOf(Year));
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			sb.append(Customer_Id);

			sb.append("|");

			if (first_name == null) {
				sb.append("<null>");
			} else {
				sb.append(first_name);
			}

			sb.append("|");

			if (last_name == null) {
				sb.append("<null>");
			} else {
				sb.append(last_name);
			}

			sb.append("|");

			if (email == null) {
				sb.append("<null>");
			} else {
				sb.append(email);
			}

			sb.append("|");

			if (Phone == null) {
				sb.append("<null>");
			} else {
				sb.append(Phone);
			}

			sb.append("|");

			sb.append(Year);

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(out3Struct other) {

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
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public String Source;

		public String getSource() {
			return this.Source;
		}

		public Boolean SourceIsNullable() {
			return true;
		}

		public Boolean SourceIsKey() {
			return false;
		}

		public Integer SourceLength() {
			return 20;
		}

		public Integer SourcePrecision() {
			return 0;
		}

		public String SourceDefault() {

			return null;

		}

		public String SourceComment() {

			return "";

		}

		public String SourcePattern() {

			return "";

		}

		public String SourceOriginalDbColumnName() {

			return "Source";

		}

		public String aadhaar_no;

		public String getAadhaar_no() {
			return this.aadhaar_no;
		}

		public Boolean aadhaar_noIsNullable() {
			return true;
		}

		public Boolean aadhaar_noIsKey() {
			return false;
		}

		public Integer aadhaar_noLength() {
			return 1073741823;
		}

		public Integer aadhaar_noPrecision() {
			return 0;
		}

		public String aadhaar_noDefault() {

			return null;

		}

		public String aadhaar_noComment() {

			return "";

		}

		public String aadhaar_noPattern() {

			return "";

		}

		public String aadhaar_noOriginalDbColumnName() {

			return "aadhaar_no";

		}

		public String consent_status;

		public String getConsent_status() {
			return this.consent_status;
		}

		public Boolean consent_statusIsNullable() {
			return true;
		}

		public Boolean consent_statusIsKey() {
			return false;
		}

		public Integer consent_statusLength() {
			return 1073741823;
		}

		public Integer consent_statusPrecision() {
			return 0;
		}

		public String consent_statusDefault() {

			return null;

		}

		public String consent_statusComment() {

			return "";

		}

		public String consent_statusPattern() {

			return "";

		}

		public String consent_statusOriginalDbColumnName() {

			return "consent_status";

		}

		public java.util.Date consent_time;

		public java.util.Date getConsent_time() {
			return this.consent_time;
		}

		public Boolean consent_timeIsNullable() {
			return true;
		}

		public Boolean consent_timeIsKey() {
			return false;
		}

		public Integer consent_timeLength() {
			return 50;
		}

		public Integer consent_timePrecision() {
			return 0;
		}

		public String consent_timeDefault() {

			return null;

		}

		public String consent_timeComment() {

			return "";

		}

		public String consent_timePattern() {

			return "yyyy-MM-dd HH:mm:ss.SSSSSS";

		}

		public String consent_timeOriginalDbColumnName() {

			return "consent_time";

		}

		public java.util.Date created_at;

		public java.util.Date getCreated_at() {
			return this.created_at;
		}

		public Boolean created_atIsNullable() {
			return true;
		}

		public Boolean created_atIsKey() {
			return false;
		}

		public Integer created_atLength() {
			return 50;
		}

		public Integer created_atPrecision() {
			return 0;
		}

		public String created_atDefault() {

			return null;

		}

		public String created_atComment() {

			return "";

		}

		public String created_atPattern() {

			return "yyyy-MM-dd HH:mm:ss.SSSSSS";

		}

		public String created_atOriginalDbColumnName() {

			return "created_at";

		}

		public int customer_id;

		public int getCustomer_id() {
			return this.customer_id;
		}

		public Boolean customer_idIsNullable() {
			return false;
		}

		public Boolean customer_idIsKey() {
			return false;
		}

		public Integer customer_idLength() {
			return 10;
		}

		public Integer customer_idPrecision() {
			return 0;
		}

		public String customer_idDefault() {

			return "";

		}

		public String customer_idComment() {

			return "";

		}

		public String customer_idPattern() {

			return "";

		}

		public String customer_idOriginalDbColumnName() {

			return "customer_id";

		}

		public java.util.Date dob;

		public java.util.Date getDob() {
			return this.dob;
		}

		public Boolean dobIsNullable() {
			return true;
		}

		public Boolean dobIsKey() {
			return false;
		}

		public Integer dobLength() {
			return 20;
		}

		public Integer dobPrecision() {
			return 0;
		}

		public String dobDefault() {

			return null;

		}

		public String dobComment() {

			return "";

		}

		public String dobPattern() {

			return "yyyy-MM-dd";

		}

		public String dobOriginalDbColumnName() {

			return "dob";

		}

		public String email;

		public String getEmail() {
			return this.email;
		}

		public Boolean emailIsNullable() {
			return true;
		}

		public Boolean emailIsKey() {
			return false;
		}

		public Integer emailLength() {
			return 1073741823;
		}

		public Integer emailPrecision() {
			return 0;
		}

		public String emailDefault() {

			return null;

		}

		public String emailComment() {

			return "";

		}

		public String emailPattern() {

			return "";

		}

		public String emailOriginalDbColumnName() {

			return "email";

		}

		public String first_name;

		public String getFirst_name() {
			return this.first_name;
		}

		public Boolean first_nameIsNullable() {
			return true;
		}

		public Boolean first_nameIsKey() {
			return false;
		}

		public Integer first_nameLength() {
			return 1073741823;
		}

		public Integer first_namePrecision() {
			return 0;
		}

		public String first_nameDefault() {

			return null;

		}

		public String first_nameComment() {

			return "";

		}

		public String first_namePattern() {

			return "";

		}

		public String first_nameOriginalDbColumnName() {

			return "first_name";

		}

		public String gender;

		public String getGender() {
			return this.gender;
		}

		public Boolean genderIsNullable() {
			return true;
		}

		public Boolean genderIsKey() {
			return false;
		}

		public Integer genderLength() {
			return 1073741823;
		}

		public Integer genderPrecision() {
			return 0;
		}

		public String genderDefault() {

			return null;

		}

		public String genderComment() {

			return "";

		}

		public String genderPattern() {

			return "";

		}

		public String genderOriginalDbColumnName() {

			return "gender";

		}

		public String last_name;

		public String getLast_name() {
			return this.last_name;
		}

		public Boolean last_nameIsNullable() {
			return true;
		}

		public Boolean last_nameIsKey() {
			return false;
		}

		public Integer last_nameLength() {
			return 1073741823;
		}

		public Integer last_namePrecision() {
			return 0;
		}

		public String last_nameDefault() {

			return null;

		}

		public String last_nameComment() {

			return "";

		}

		public String last_namePattern() {

			return "";

		}

		public String last_nameOriginalDbColumnName() {

			return "last_name";

		}

		public String pan_no;

		public String getPan_no() {
			return this.pan_no;
		}

		public Boolean pan_noIsNullable() {
			return true;
		}

		public Boolean pan_noIsKey() {
			return false;
		}

		public Integer pan_noLength() {
			return 1073741823;
		}

		public Integer pan_noPrecision() {
			return 0;
		}

		public String pan_noDefault() {

			return null;

		}

		public String pan_noComment() {

			return "";

		}

		public String pan_noPattern() {

			return "";

		}

		public String pan_noOriginalDbColumnName() {

			return "pan_no";

		}

		public String phone;

		public String getPhone() {
			return this.phone;
		}

		public Boolean phoneIsNullable() {
			return true;
		}

		public Boolean phoneIsKey() {
			return false;
		}

		public Integer phoneLength() {
			return 1073741823;
		}

		public Integer phonePrecision() {
			return 0;
		}

		public String phoneDefault() {

			return null;

		}

		public String phoneComment() {

			return "";

		}

		public String phonePattern() {

			return "";

		}

		public String phoneOriginalDbColumnName() {

			return "phone";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

		private java.util.Date readDate(ObjectInputStream dis) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = dis.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(dis.readLong());
			}
			return dateReturn;
		}

		private java.util.Date readDate(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException {
			java.util.Date dateReturn = null;
			int length = 0;
			length = unmarshaller.readByte();
			if (length == -1) {
				dateReturn = null;
			} else {
				dateReturn = new Date(unmarshaller.readLong());
			}
			return dateReturn;
		}

		private void writeDate(java.util.Date date1, ObjectOutputStream dos) throws IOException {
			if (date1 == null) {
				dos.writeByte(-1);
			} else {
				dos.writeByte(0);
				dos.writeLong(date1.getTime());
			}
		}

		private void writeDate(java.util.Date date1, org.jboss.marshalling.Marshaller marshaller) throws IOException {
			if (date1 == null) {
				marshaller.writeByte(-1);
			} else {
				marshaller.writeByte(0);
				marshaller.writeLong(date1.getTime());
			}
		}

		public void readData(ObjectInputStream dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.Source = readString(dis);

					this.aadhaar_no = readString(dis);

					this.consent_status = readString(dis);

					this.consent_time = readDate(dis);

					this.created_at = readDate(dis);

					this.customer_id = dis.readInt();

					this.dob = readDate(dis);

					this.email = readString(dis);

					this.first_name = readString(dis);

					this.gender = readString(dis);

					this.last_name = readString(dis);

					this.pan_no = readString(dis);

					this.phone = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.Source = readString(dis);

					this.aadhaar_no = readString(dis);

					this.consent_status = readString(dis);

					this.consent_time = readDate(dis);

					this.created_at = readDate(dis);

					this.customer_id = dis.readInt();

					this.dob = readDate(dis);

					this.email = readString(dis);

					this.first_name = readString(dis);

					this.gender = readString(dis);

					this.last_name = readString(dis);

					this.pan_no = readString(dis);

					this.phone = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.Source, dos);

				// String

				writeString(this.aadhaar_no, dos);

				// String

				writeString(this.consent_status, dos);

				// java.util.Date

				writeDate(this.consent_time, dos);

				// java.util.Date

				writeDate(this.created_at, dos);

				// int

				dos.writeInt(this.customer_id);

				// java.util.Date

				writeDate(this.dob, dos);

				// String

				writeString(this.email, dos);

				// String

				writeString(this.first_name, dos);

				// String

				writeString(this.gender, dos);

				// String

				writeString(this.last_name, dos);

				// String

				writeString(this.pan_no, dos);

				// String

				writeString(this.phone, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.Source, dos);

				// String

				writeString(this.aadhaar_no, dos);

				// String

				writeString(this.consent_status, dos);

				// java.util.Date

				writeDate(this.consent_time, dos);

				// java.util.Date

				writeDate(this.created_at, dos);

				// int

				dos.writeInt(this.customer_id);

				// java.util.Date

				writeDate(this.dob, dos);

				// String

				writeString(this.email, dos);

				// String

				writeString(this.first_name, dos);

				// String

				writeString(this.gender, dos);

				// String

				writeString(this.last_name, dos);

				// String

				writeString(this.pan_no, dos);

				// String

				writeString(this.phone, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("Source=" + Source);
			sb.append(",aadhaar_no=" + aadhaar_no);
			sb.append(",consent_status=" + consent_status);
			sb.append(",consent_time=" + String.valueOf(consent_time));
			sb.append(",created_at=" + String.valueOf(created_at));
			sb.append(",customer_id=" + String.valueOf(customer_id));
			sb.append(",dob=" + String.valueOf(dob));
			sb.append(",email=" + email);
			sb.append(",first_name=" + first_name);
			sb.append(",gender=" + gender);
			sb.append(",last_name=" + last_name);
			sb.append(",pan_no=" + pan_no);
			sb.append(",phone=" + phone);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (Source == null) {
				sb.append("<null>");
			} else {
				sb.append(Source);
			}

			sb.append("|");

			if (aadhaar_no == null) {
				sb.append("<null>");
			} else {
				sb.append(aadhaar_no);
			}

			sb.append("|");

			if (consent_status == null) {
				sb.append("<null>");
			} else {
				sb.append(consent_status);
			}

			sb.append("|");

			if (consent_time == null) {
				sb.append("<null>");
			} else {
				sb.append(consent_time);
			}

			sb.append("|");

			if (created_at == null) {
				sb.append("<null>");
			} else {
				sb.append(created_at);
			}

			sb.append("|");

			sb.append(customer_id);

			sb.append("|");

			if (dob == null) {
				sb.append("<null>");
			} else {
				sb.append(dob);
			}

			sb.append("|");

			if (email == null) {
				sb.append("<null>");
			} else {
				sb.append(email);
			}

			sb.append("|");

			if (first_name == null) {
				sb.append("<null>");
			} else {
				sb.append(first_name);
			}

			sb.append("|");

			if (gender == null) {
				sb.append("<null>");
			} else {
				sb.append(gender);
			}

			sb.append("|");

			if (last_name == null) {
				sb.append("<null>");
			} else {
				sb.append(last_name);
			}

			sb.append("|");

			if (pan_no == null) {
				sb.append("<null>");
			} else {
				sb.append(pan_no);
			}

			sb.append("|");

			if (phone == null) {
				sb.append("<null>");
			} else {
				sb.append(phone);
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

	public void tDBInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tDBInput_1", "MJjtcF_");

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
				out2Struct out2 = new out2Struct();
				out3Struct out3 = new out3Struct();

				/**
				 * [tDBOutput_1 begin ] start
				 */

				sh("tDBOutput_1");

				s(currentComponent = "tDBOutput_1");

				cLabel = "logs_postgres";

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out2");

				int tos_count_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBOutput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBOutput_1 = new StringBuilder();
							log4jParamters_tDBOutput_1.append("Parameters:");
							log4jParamters_tDBOutput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DB_VERSION" + " = " + "V9_X");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("HOST" + " = " + "\"98.70.31.45\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PORT" + " = " + "\"5432\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DBNAME" + " = " + "\"DPDP Portal\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SCHEMA_DB" + " = " + "\"Log\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USER" + " = " + "\"postgres\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:gwXGoGwUASZ44kTaWuly7EowB4HAaHTkbUHTVxj2ztLQubddBDSFdDk=")
									.substring(0, 4) + "...");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE" + " = " + "\"Customers_Renew_Log\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("TABLE_ACTION" + " = " + "CREATE_IF_NOT_EXISTS");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DATA_ACTION" + " = " + "INSERT");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_SPATIAL_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("DIE_ON_ERROR" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("PROPERTIES" + " = " + "\"\"");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("COMMIT_EVERY" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ADD_COLS" + " = " + "[]");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_FIELD_OPTIONS" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("ENABLE_DEBUG_MODE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("SUPPORT_NULL_WHERE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("CONVERT_COLUMN_TABLE_TO_LOWERCASE" + " = " + "false");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("USE_BATCH_SIZE" + " = " + "true");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("BATCH_SIZE" + " = " + "10000");
							log4jParamters_tDBOutput_1.append(" | ");
							log4jParamters_tDBOutput_1.append("UNIFIED_COMPONENTS" + " = " + "tPostgresqlOutput");
							log4jParamters_tDBOutput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + (log4jParamters_tDBOutput_1));
						}
					}
					new BytesLimit65535_tDBOutput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBOutput_1", "logs_postgres", "tPostgresqlOutput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				String dbschema_tDBOutput_1 = null;
				dbschema_tDBOutput_1 = "Log";

				String tableName_tDBOutput_1 = null;
				if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
					tableName_tDBOutput_1 = ("Customers_Renew_Log");
				} else {
					tableName_tDBOutput_1 = dbschema_tDBOutput_1 + "\".\"" + ("Customers_Renew_Log");
				}

				int nb_line_tDBOutput_1 = 0;
				int nb_line_update_tDBOutput_1 = 0;
				int nb_line_inserted_tDBOutput_1 = 0;
				int nb_line_deleted_tDBOutput_1 = 0;
				int nb_line_rejected_tDBOutput_1 = 0;

				int deletedCount_tDBOutput_1 = 0;
				int updatedCount_tDBOutput_1 = 0;
				int insertedCount_tDBOutput_1 = 0;
				int rowsToCommitCount_tDBOutput_1 = 0;
				int rejectedCount_tDBOutput_1 = 0;

				boolean whetherReject_tDBOutput_1 = false;

				java.sql.Connection conn_tDBOutput_1 = null;
				String dbUser_tDBOutput_1 = null;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Driver ClassName: ") + ("org.postgresql.Driver") + ("."));
				java.lang.Class.forName("org.postgresql.Driver");

				String url_tDBOutput_1 = "jdbc:postgresql://" + "98.70.31.45" + ":" + "5432" + "/" + "DPDP Portal";
				dbUser_tDBOutput_1 = "postgres";

				final String decryptedPassword_tDBOutput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:NqlBCPPe1vtc9u1lwxxx5zR76C9ZYGozXsAbmSJ5qKpcI2p5UytE6eI=");

				String dbPwd_tDBOutput_1 = decryptedPassword_tDBOutput_1;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection attempts to '") + (url_tDBOutput_1)
							+ ("' with the username '") + (dbUser_tDBOutput_1) + ("'."));
				conn_tDBOutput_1 = java.sql.DriverManager.getConnection(url_tDBOutput_1, dbUser_tDBOutput_1,
						dbPwd_tDBOutput_1);
				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to '") + (url_tDBOutput_1) + ("' has succeeded."));

				resourceMap.put("conn_tDBOutput_1", conn_tDBOutput_1);
				conn_tDBOutput_1.setAutoCommit(false);
				int commitEvery_tDBOutput_1 = 10000;
				int commitCounter_tDBOutput_1 = 0;
				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection is set auto commit to '")
							+ (conn_tDBOutput_1.getAutoCommit()) + ("'."));

				int batchSize_tDBOutput_1 = 10000;
				int batchSizeCounter_tDBOutput_1 = 0;

				int count_tDBOutput_1 = 0;
				java.sql.DatabaseMetaData dbMetaData_tDBOutput_1 = conn_tDBOutput_1.getMetaData();
				boolean whetherExist_tDBOutput_1 = false;
				try (java.sql.ResultSet rsTable_tDBOutput_1 = dbMetaData_tDBOutput_1.getTables(null, null, null,
						new String[] { "TABLE" })) {
					String defaultSchema_tDBOutput_1 = "public";
					if (dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0) {
						try (java.sql.Statement stmtSchema_tDBOutput_1 = conn_tDBOutput_1.createStatement();
								java.sql.ResultSet rsSchema_tDBOutput_1 = stmtSchema_tDBOutput_1
										.executeQuery("select current_schema() ")) {
							while (rsSchema_tDBOutput_1.next()) {
								defaultSchema_tDBOutput_1 = rsSchema_tDBOutput_1.getString("current_schema");
							}
						}
					}
					while (rsTable_tDBOutput_1.next()) {
						String table_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_NAME");
						String schema_tDBOutput_1 = rsTable_tDBOutput_1.getString("TABLE_SCHEM");
						if (table_tDBOutput_1.equals(("Customers_Renew_Log"))
								&& (schema_tDBOutput_1.equals(dbschema_tDBOutput_1)
										|| ((dbschema_tDBOutput_1 == null || dbschema_tDBOutput_1.trim().length() == 0)
												&& defaultSchema_tDBOutput_1.equals(schema_tDBOutput_1)))) {
							whetherExist_tDBOutput_1 = true;
							break;
						}
					}
				}
				if (!whetherExist_tDBOutput_1) {
					try (java.sql.Statement stmtCreate_tDBOutput_1 = conn_tDBOutput_1.createStatement()) {
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Creating") + (" table '")
									+ ("\"" + tableName_tDBOutput_1 + "\"") + ("'."));
						stmtCreate_tDBOutput_1.execute("CREATE TABLE \"" + tableName_tDBOutput_1
								+ "\"(\"customer_id\" INT4  not null ,\"first_name\" TEXT ,\"last_name\" TEXT ,\"Reason\" TEXT ,\"phone\" TEXT ,\"year\" INT4 ,\"log_time\" TIMESTAMP )");
						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Create") + (" table '")
									+ ("\"" + tableName_tDBOutput_1 + "\"") + ("' has succeeded."));
					}
				}
				java.lang.StringBuilder sb_tDBOutput_1 = new java.lang.StringBuilder();
				sb_tDBOutput_1.append("INSERT INTO \"").append(tableName_tDBOutput_1).append(
						"\" (\"customer_id\",\"first_name\",\"last_name\",\"Reason\",\"phone\",\"year\",\"log_time\") VALUES (?,?,?,?,?,?,?)");

				String insert_tDBOutput_1 = sb_tDBOutput_1.toString();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Executing '") + (insert_tDBOutput_1) + ("'."));

				java.sql.PreparedStatement pstmt_tDBOutput_1 = conn_tDBOutput_1.prepareStatement(insert_tDBOutput_1);
				resourceMap.put("pstmt_tDBOutput_1", pstmt_tDBOutput_1);

				/**
				 * [tDBOutput_1 begin ] stop
				 */

				/**
				 * [tDataStewardshipTaskOutput_2 begin ] start
				 */

				sh("tDataStewardshipTaskOutput_2");

				s(currentComponent = "tDataStewardshipTaskOutput_2");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "out3");

				int tos_count_tDataStewardshipTaskOutput_2 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tDataStewardshipTaskOutput_2", "tDataStewardshipTaskOutput_2",
							"tDataStewardshipTaskOutput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				boolean doesNodeBelongToRequest_tDataStewardshipTaskOutput_2 = 1 == 0;
				@SuppressWarnings("unchecked")
				java.util.Map<String, Object> restRequest_tDataStewardshipTaskOutput_2 = (java.util.Map<String, Object>) globalMap
						.get("restRequest");
				String currentTRestRequestOperation_tDataStewardshipTaskOutput_2 = (String) (restRequest_tDataStewardshipTaskOutput_2 != null
						? restRequest_tDataStewardshipTaskOutput_2.get("OPERATION")
						: null);
				if ("post_log".equals(currentTRestRequestOperation_tDataStewardshipTaskOutput_2)) {
					doesNodeBelongToRequest_tDataStewardshipTaskOutput_2 = true;
				}

				org.talend.components.api.component.ComponentDefinition def_tDataStewardshipTaskOutput_2 = new org.talend.components.datastewardship.tdatastewardshiptaskoutput.TDataStewardshipTaskOutputDefinition();

				org.talend.components.api.component.runtime.Writer writer_tDataStewardshipTaskOutput_2 = null;
				org.talend.components.api.component.runtime.Reader reader_tDataStewardshipTaskOutput_2 = null;

				org.talend.components.datastewardship.tdatastewardshiptaskoutput.TDataStewardshipTaskOutputProperties props_tDataStewardshipTaskOutput_2 = (org.talend.components.datastewardship.tdatastewardshiptaskoutput.TDataStewardshipTaskOutputProperties) def_tDataStewardshipTaskOutput_2
						.createRuntimeProperties();
				props_tDataStewardshipTaskOutput_2.setValue("batchSize", 50);

				props_tDataStewardshipTaskOutput_2.setValue("campaignName", "c8dd189b914a07989ca14f14bba9c40cb");

				props_tDataStewardshipTaskOutput_2.setValue("campaignLabel", "New Renew");

				props_tDataStewardshipTaskOutput_2.setValue("campaignType",
						org.talend.components.datastewardship.common.CampaignType.ARBITRATION);

				props_tDataStewardshipTaskOutput_2.setValue("laxSchema", false);

				props_tDataStewardshipTaskOutput_2.setValue("taskPriority", "NO_PRIORITY");

				props_tDataStewardshipTaskOutput_2.setValue("taskTags", "");

				props_tDataStewardshipTaskOutput_2.setValue("taskState", "New");

				props_tDataStewardshipTaskOutput_2.setValue("taskAssignee", "No Assignee");

				props_tDataStewardshipTaskOutput_2.setValue("arbitrationChoice", "NO_CHOICE");

				java.util.List<Object> tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName = new java.util.ArrayList<Object>();

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName.add("Customer_Id");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName.add("first_name");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName.add("last_name");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName.add("email");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName.add("Phone");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName.add("Year");

				((org.talend.daikon.properties.Properties) props_tDataStewardshipTaskOutput_2.taskCommentsTable)
						.setValue("fieldName", tDataStewardshipTaskOutput_2_taskCommentsTable_fieldName);

				java.util.List<Object> tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment = new java.util.ArrayList<Object>();

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment.add("");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment.add("");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment.add("");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment.add("");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment.add("");

				tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment.add("");

				((org.talend.daikon.properties.Properties) props_tDataStewardshipTaskOutput_2.taskCommentsTable)
						.setValue("fieldComment", tDataStewardshipTaskOutput_2_taskCommentsTable_fieldComment);

				java.util.List<Object> tDataStewardshipTaskOutput_2_httpConfig_keys = new java.util.ArrayList<Object>();

				((org.talend.daikon.properties.Properties) props_tDataStewardshipTaskOutput_2.httpConfig)
						.setValue("keys", tDataStewardshipTaskOutput_2_httpConfig_keys);

				java.util.List<Object> tDataStewardshipTaskOutput_2_httpConfig_values = new java.util.ArrayList<Object>();

				((org.talend.daikon.properties.Properties) props_tDataStewardshipTaskOutput_2.httpConfig)
						.setValue("values", tDataStewardshipTaskOutput_2_httpConfig_values);

				class SchemaSettingTool_tDataStewardshipTaskOutput_2_1_fisrt {

					String getSchemaValue() {

						StringBuilder s = new StringBuilder();

						a("{\"type\":\"record\",", s);

						a("\"name\":\"main\",\"fields\":[{", s);

						a("\"name\":\"Customer_Id\",\"type\":\"int\",\"di.table.comment\":\"integer\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Customer_Id\"},{",
								s);

						a("\"name\":\"first_name\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"first_name\"},{",
								s);

						a("\"name\":\"last_name\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"last_name\"},{",
								s);

						a("\"name\":\"email\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"email\"},{",
								s);

						a("\"name\":\"Phone\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Phone\"},{",
								s);

						a("\"name\":\"Year\",\"type\":\"int\",\"di.table.comment\":\"integer\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Year\"},{",
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

				SchemaSettingTool_tDataStewardshipTaskOutput_2_1_fisrt sst_tDataStewardshipTaskOutput_2_1_fisrt = new SchemaSettingTool_tDataStewardshipTaskOutput_2_1_fisrt();

				props_tDataStewardshipTaskOutput_2.schema.setValue("schema", new org.apache.avro.Schema.Parser()
						.setValidateDefaults(false).parse(sst_tDataStewardshipTaskOutput_2_1_fisrt.getSchemaValue()));

				props_tDataStewardshipTaskOutput_2.connection.setValue("url",
						"https://tds.ap.cloud.talend.com/data-stewardship");

				props_tDataStewardshipTaskOutput_2.connection.setValue("username", "pranita.p@predoole.com");

				props_tDataStewardshipTaskOutput_2.connection.setValue("password",
						routines.system.PasswordEncryptUtil.decryptPassword(
								"enc:routine.encryption.key.v1:cgGQ7h+LeaNjbF7eHbzLhhk3DMaQty4tnzZ+Dy4RBxdHi/NoGgn5kv3EHK1FBX2Lfl7vkBe1YDg88paQfnH8KpD8rvbGxMt6rGALl2nhr2X73dGGOuMXb1iXVag="));

				props_tDataStewardshipTaskOutput_2.connection.refConnection.setValue("referenceDefinitionName",
						"datastewardship");

				if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_tDataStewardshipTaskOutput_2.connection.refConnection.referenceType
						.getValue()) {
					final String referencedComponentInstanceId_tDataStewardshipTaskOutput_2 = props_tDataStewardshipTaskOutput_2.connection.refConnection.componentInstanceId
							.getStringValue();
					if (referencedComponentInstanceId_tDataStewardshipTaskOutput_2 != null) {
						org.talend.daikon.properties.Properties referencedComponentProperties_tDataStewardshipTaskOutput_2 = (org.talend.daikon.properties.Properties) globalMap
								.get(referencedComponentInstanceId_tDataStewardshipTaskOutput_2
										+ "_COMPONENT_RUNTIME_PROPERTIES");
						props_tDataStewardshipTaskOutput_2.connection.refConnection
								.setReference(referencedComponentProperties_tDataStewardshipTaskOutput_2);
					}
				}
				globalMap.put("tDataStewardshipTaskOutput_2_COMPONENT_RUNTIME_PROPERTIES",
						props_tDataStewardshipTaskOutput_2);
				globalMap.putIfAbsent("TALEND_PRODUCT_VERSION", "8.0");
				globalMap.put("TALEND_COMPONENTS_VERSION", "0.37.46");
				java.net.URL mappings_url_tDataStewardshipTaskOutput_2 = this.getClass().getResource("/xmlMappings");
				globalMap.put("tDataStewardshipTaskOutput_2_MAPPINGS_URL", mappings_url_tDataStewardshipTaskOutput_2);

				org.talend.components.api.container.RuntimeContainer container_tDataStewardshipTaskOutput_2 = new org.talend.components.api.container.RuntimeContainer() {
					public Object getComponentData(String componentId, String key) {
						return globalMap.get(componentId + "_" + key);
					}

					public void setComponentData(String componentId, String key, Object data) {
						globalMap.put(componentId + "_" + key, data);
					}

					public String getCurrentComponentId() {
						return "tDataStewardshipTaskOutput_2";
					}

					public Object getGlobalData(String key) {
						return globalMap.get(key);
					}
				};

				int nb_line_tDataStewardshipTaskOutput_2 = 0;

				org.talend.components.api.component.ConnectorTopology topology_tDataStewardshipTaskOutput_2 = null;
				topology_tDataStewardshipTaskOutput_2 = org.talend.components.api.component.ConnectorTopology.INCOMING;

				org.talend.daikon.runtime.RuntimeInfo runtime_info_tDataStewardshipTaskOutput_2 = def_tDataStewardshipTaskOutput_2
						.getRuntimeInfo(org.talend.components.api.component.runtime.ExecutionEngine.DI,
								props_tDataStewardshipTaskOutput_2, topology_tDataStewardshipTaskOutput_2);
				java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_tDataStewardshipTaskOutput_2 = def_tDataStewardshipTaskOutput_2
						.getSupportedConnectorTopologies();

				org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_tDataStewardshipTaskOutput_2 = (org.talend.components.api.component.runtime.RuntimableRuntime) (Class
						.forName(runtime_info_tDataStewardshipTaskOutput_2.getRuntimeClassName()).newInstance());
				org.talend.daikon.properties.ValidationResult initVr_tDataStewardshipTaskOutput_2 = componentRuntime_tDataStewardshipTaskOutput_2
						.initialize(container_tDataStewardshipTaskOutput_2, props_tDataStewardshipTaskOutput_2);

				if (initVr_tDataStewardshipTaskOutput_2
						.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR) {
					throw new RuntimeException(initVr_tDataStewardshipTaskOutput_2.getMessage());
				}

				if (componentRuntime_tDataStewardshipTaskOutput_2 instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {
					org.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_tDataStewardshipTaskOutput_2 = (org.talend.components.api.component.runtime.ComponentDriverInitialization) componentRuntime_tDataStewardshipTaskOutput_2;
					compDriverInitialization_tDataStewardshipTaskOutput_2
							.runAtDriver(container_tDataStewardshipTaskOutput_2);
				}

				org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_tDataStewardshipTaskOutput_2 = null;
				if (componentRuntime_tDataStewardshipTaskOutput_2 instanceof org.talend.components.api.component.runtime.SourceOrSink) {
					sourceOrSink_tDataStewardshipTaskOutput_2 = (org.talend.components.api.component.runtime.SourceOrSink) componentRuntime_tDataStewardshipTaskOutput_2;
					if (doesNodeBelongToRequest_tDataStewardshipTaskOutput_2) {
						org.talend.daikon.properties.ValidationResult vr_tDataStewardshipTaskOutput_2 = sourceOrSink_tDataStewardshipTaskOutput_2
								.validate(container_tDataStewardshipTaskOutput_2);
						if (vr_tDataStewardshipTaskOutput_2
								.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR) {
							throw new RuntimeException(vr_tDataStewardshipTaskOutput_2.getMessage());
						}
					}
				}

				org.talend.codegen.enforcer.IncomingSchemaEnforcer incomingEnforcer_tDataStewardshipTaskOutput_2 = null;
				if (sourceOrSink_tDataStewardshipTaskOutput_2 instanceof org.talend.components.api.component.runtime.Sink) {
					org.talend.components.api.component.runtime.Sink sink_tDataStewardshipTaskOutput_2 = (org.talend.components.api.component.runtime.Sink) sourceOrSink_tDataStewardshipTaskOutput_2;
					org.talend.components.api.component.runtime.WriteOperation writeOperation_tDataStewardshipTaskOutput_2 = sink_tDataStewardshipTaskOutput_2
							.createWriteOperation();
					if (doesNodeBelongToRequest_tDataStewardshipTaskOutput_2) {
						writeOperation_tDataStewardshipTaskOutput_2.initialize(container_tDataStewardshipTaskOutput_2);
					}
					writer_tDataStewardshipTaskOutput_2 = writeOperation_tDataStewardshipTaskOutput_2
							.createWriter(container_tDataStewardshipTaskOutput_2);
					if (doesNodeBelongToRequest_tDataStewardshipTaskOutput_2) {
						writer_tDataStewardshipTaskOutput_2.open("tDataStewardshipTaskOutput_2");
					}

					resourceMap.put("writer_tDataStewardshipTaskOutput_2", writer_tDataStewardshipTaskOutput_2);
				} // end of "sourceOrSink_tDataStewardshipTaskOutput_2 instanceof ...Sink"
				org.talend.components.api.component.Connector c_tDataStewardshipTaskOutput_2 = null;
				for (org.talend.components.api.component.Connector currentConnector : props_tDataStewardshipTaskOutput_2
						.getAvailableConnectors(null, false)) {
					if (currentConnector.getName().equals("MAIN")) {
						c_tDataStewardshipTaskOutput_2 = currentConnector;
						break;
					}
				}
				org.apache.avro.Schema designSchema_tDataStewardshipTaskOutput_2 = props_tDataStewardshipTaskOutput_2
						.getSchema(c_tDataStewardshipTaskOutput_2, false);
				incomingEnforcer_tDataStewardshipTaskOutput_2 = new org.talend.codegen.enforcer.IncomingSchemaEnforcer(
						designSchema_tDataStewardshipTaskOutput_2);

				java.lang.Iterable<?> outgoingMainRecordsList_tDataStewardshipTaskOutput_2 = new java.util.ArrayList<Object>();
				java.util.Iterator outgoingMainRecordsIt_tDataStewardshipTaskOutput_2 = null;

				/**
				 * [tDataStewardshipTaskOutput_2 begin ] stop
				 */

				/**
				 * [tMap_1 begin ] start
				 */

				sh("tMap_1");

				s(currentComponent = "tMap_1");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row1");

				int tos_count_tMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tMap_1 = new StringBuilder();
							log4jParamters_tMap_1.append("Parameters:");
							log4jParamters_tMap_1.append("LINK_STYLE" + " = " + "AUTO");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("TEMPORARY_DATA_DIRECTORY" + " = " + "");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("ROWS_BUFFER_SIZE" + " = " + "2000000");
							log4jParamters_tMap_1.append(" | ");
							log4jParamters_tMap_1.append("CHANGE_HASH_AND_EQUALS_FOR_BIGDECIMAL" + " = " + "true");
							log4jParamters_tMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tMap_1 - " + (log4jParamters_tMap_1));
						}
					}
					new BytesLimit65535_tMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

// ###############################
// # Lookup's keys initialization
				int count_row1_tMap_1 = 0;

// ###############################        

// ###############################
// # Vars initialization
				class Var__tMap_1__Struct {
				}
				Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_out2_tMap_1 = 0;

				out2Struct out2_tmp = new out2Struct();
				int count_out3_tMap_1 = 0;

				out3Struct out3_tmp = new out3Struct();
// ###############################

				/**
				 * [tMap_1 begin ] stop
				 */

				/**
				 * [tDBInput_1 begin ] start
				 */

				sh("tDBInput_1");

				s(currentComponent = "tDBInput_1");

				cLabel = "insurance_conn";

				int tos_count_tDBInput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tDBInput_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
							log4jParamters_tDBInput_1.append("Parameters:");
							log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("HOST" + " = " + "\"98.70.31.45\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DRIVER" + " = " + "MSSQL_PROP");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PORT" + " = " + "\"1433\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DB_SCHEMA" + " = " + "\"Silver\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"Insurance_ETE\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("USER" + " = " + "\"QDI4\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf(
									"enc:routine.encryption.key.v1:iTilnD+P7+uZUZ4fZSv4PNMOPxKiyAdR/gt4jcVwZPIyi4XB/Ort7jQ=")
									.substring(0, 4) + "...");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"Unique_Customers\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("QUERY" + " = "
									+ "\"select Silver.Unique_Customers.Source,Silver.Unique_Customers.aadhaar_no,Silver.Unique_Customers.consent_status,Silver.Unique_Customers.consent_time,Silver.Unique_Customers.created_at,Silver.Unique_Customers.customer_id,Silver.Unique_Customers.dob,Silver.Unique_Customers.email,Silver.Unique_Customers.first_name,Silver.Unique_Customers.gender,Silver.Unique_Customers.last_name,Silver.Unique_Customers.pan_no,Silver.Unique_Customers.phone  from Silver.Unique_Customers WHERE Silver.Unique_Customers.customer_id = '\" + context.id  + \"'\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "\"\"");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("ACTIVE_DIR_AUTH" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("ENABLE_ALWAYS_ENCRYPTED" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("Source") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("aadhaar_no") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("consent_status")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("consent_time") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("created_at") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("customer_id") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("dob") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("email") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("first_name")
									+ "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN=" + ("gender") + "}, {TRIM="
									+ ("false") + ", SCHEMA_COLUMN=" + ("last_name") + "}, {TRIM=" + ("false")
									+ ", SCHEMA_COLUMN=" + ("pan_no") + "}, {TRIM=" + ("false") + ", SCHEMA_COLUMN="
									+ ("phone") + "}]");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("SET_QUERY_TIMEOUT" + " = " + "false");
							log4jParamters_tDBInput_1.append(" | ");
							log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMSSqlInput");
							log4jParamters_tDBInput_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tDBInput_1 - " + (log4jParamters_tDBInput_1));
						}
					}
					new BytesLimit65535_tDBInput_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tDBInput_1", "insurance_conn", "tMSSqlInput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				org.talend.designer.components.util.mssql.MSSqlGenerateTimestampUtil mssqlGTU_tDBInput_1 = org.talend.designer.components.util.mssql.MSSqlUtilFactory
						.getMSSqlGenerateTimestampUtil();

				java.util.List<String> talendToDBList_tDBInput_1 = new java.util.ArrayList();
				String[] talendToDBArray_tDBInput_1 = new String[] { "FLOAT", "NUMERIC", "NUMERIC IDENTITY", "DECIMAL",
						"DECIMAL IDENTITY", "REAL" };
				java.util.Collections.addAll(talendToDBList_tDBInput_1, talendToDBArray_tDBInput_1);
				int nb_line_tDBInput_1 = 0;
				java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
				java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "QDI4";

				final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword(
						"enc:routine.encryption.key.v1:kyks90SKLnYUIbrNyKNRs6Votn6u1H1flT2G/HWYy3Sq+ic1rrRGoXc=");

				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;

				String port_tDBInput_1 = "1433";
				String dbname_tDBInput_1 = "Insurance_ETE";
				String url_tDBInput_1 = "jdbc:sqlserver://" + "98.70.31.45";
				if (!"".equals(port_tDBInput_1)) {
					url_tDBInput_1 += ":" + "1433";
				}
				if (!"".equals(dbname_tDBInput_1)) {
					url_tDBInput_1 += ";databaseName=" + "Insurance_ETE";
				}
				url_tDBInput_1 += ";appName=" + projectName + ";" + "";
				String dbschema_tDBInput_1 = "Silver";

				log.debug("tDBInput_1 - Driver ClassName: " + driverClass_tDBInput_1 + ".");

				log.debug("tDBInput_1 - Connection attempt to '"
						+ url_tDBInput_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********")
						+ "' with the username '" + dbUser_tDBInput_1 + "'.");

				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1, dbUser_tDBInput_1,
						dbPwd_tDBInput_1);
				log.debug("tDBInput_1 - Connection to '"
						+ url_tDBInput_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' has succeeded.");

				java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

				String dbquery_tDBInput_1 = "select Silver.Unique_Customers.Source,Silver.Unique_Customers.aadhaar_no,Silver.Unique_Customers.consent_status,Silver."
						+ "Unique_Customers.consent_time,Silver.Unique_Customers.created_at,Silver.Unique_Customers.customer_id,Silver.Unique_Custo"
						+ "mers.dob,Silver.Unique_Customers.email,Silver.Unique_Customers.first_name,Silver.Unique_Customers.gender,Silver.Unique_C"
						+ "ustomers.last_name,Silver.Unique_Customers.pan_no,Silver.Unique_Customers.phone \nfrom Silver.Unique_Customers WHERE Silv"
						+ "er.Unique_Customers.customer_id = '" + context.id + "'";

				log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");

				globalMap.put("tDBInput_1_QUERY", dbquery_tDBInput_1);

				java.sql.ResultSet rs_tDBInput_1 = null;

				try {
					rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
					java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
					int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

					String tmpContent_tDBInput_1 = null;

					log.debug("tDBInput_1 - Retrieving records from the database.");

					while (rs_tDBInput_1.next()) {
						nb_line_tDBInput_1++;

						if (colQtyInRs_tDBInput_1 < 1) {
							row1.Source = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(1);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(1).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.Source = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.Source = tmpContent_tDBInput_1;
								}
							} else {
								row1.Source = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 2) {
							row1.aadhaar_no = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(2);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(2).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.aadhaar_no = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.aadhaar_no = tmpContent_tDBInput_1;
								}
							} else {
								row1.aadhaar_no = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 3) {
							row1.consent_status = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(3);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(3).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.consent_status = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.consent_status = tmpContent_tDBInput_1;
								}
							} else {
								row1.consent_status = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 4) {
							row1.consent_time = null;
						} else {

							row1.consent_time = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 4);

						}
						if (colQtyInRs_tDBInput_1 < 5) {
							row1.created_at = null;
						} else {

							row1.created_at = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 5);

						}
						if (colQtyInRs_tDBInput_1 < 6) {
							row1.customer_id = 0;
						} else {

							row1.customer_id = rs_tDBInput_1.getInt(6);
							if (rs_tDBInput_1.wasNull()) {
								throw new RuntimeException("Null value in non-Nullable column");
							}
						}
						if (colQtyInRs_tDBInput_1 < 7) {
							row1.dob = null;
						} else {

							row1.dob = mssqlGTU_tDBInput_1.getDate(rsmd_tDBInput_1, rs_tDBInput_1, 7);

						}
						if (colQtyInRs_tDBInput_1 < 8) {
							row1.email = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(8);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(8).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.email = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.email = tmpContent_tDBInput_1;
								}
							} else {
								row1.email = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 9) {
							row1.first_name = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(9);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(9).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.first_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.first_name = tmpContent_tDBInput_1;
								}
							} else {
								row1.first_name = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 10) {
							row1.gender = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(10);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(10).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.gender = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.gender = tmpContent_tDBInput_1;
								}
							} else {
								row1.gender = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 11) {
							row1.last_name = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(11);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(11).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.last_name = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.last_name = tmpContent_tDBInput_1;
								}
							} else {
								row1.last_name = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 12) {
							row1.pan_no = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(12);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(12).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.pan_no = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.pan_no = tmpContent_tDBInput_1;
								}
							} else {
								row1.pan_no = null;
							}
						}
						if (colQtyInRs_tDBInput_1 < 13) {
							row1.phone = null;
						} else {

							tmpContent_tDBInput_1 = rs_tDBInput_1.getString(13);
							if (tmpContent_tDBInput_1 != null) {
								if (talendToDBList_tDBInput_1.contains(
										rsmd_tDBInput_1.getColumnTypeName(13).toUpperCase(java.util.Locale.ENGLISH))) {
									row1.phone = FormatterUtils.formatUnwithE(tmpContent_tDBInput_1);
								} else {
									row1.phone = tmpContent_tDBInput_1;
								}
							} else {
								row1.phone = null;
							}
						}

						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");

						/**
						 * [tDBInput_1 begin ] stop
						 */

						/**
						 * [tDBInput_1 main ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "insurance_conn";

						tos_count_tDBInput_1++;

						/**
						 * [tDBInput_1 main ] stop
						 */

						/**
						 * [tDBInput_1 process_data_begin ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "insurance_conn";

						/**
						 * [tDBInput_1 process_data_begin ] stop
						 */

						/**
						 * [tMap_1 main ] start
						 */

						s(currentComponent = "tMap_1");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "row1", "tDBInput_1", "insurance_conn", "tMSSqlInput", "tMap_1", "tMap_1", "tMap"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("row1 - " + (row1 == null ? "" : row1.toLogString()));
						}

						boolean hasCasePrimitiveKeyWithNull_tMap_1 = false;

						// ###############################
						// # Input tables (lookups)

						boolean rejectedInnerJoin_tMap_1 = false;
						boolean mainRowRejected_tMap_1 = false;
						// ###############################
						{ // start of Var scope

							// ###############################
							// # Vars tables

							Var__tMap_1__Struct Var = Var__tMap_1;// ###############################
							// ###############################
							// # Output tables

							out2 = null;
							out3 = null;

// # Output table : 'out2'
							count_out2_tMap_1++;

							out2_tmp.customer_id = row1.customer_id;
							out2_tmp.first_name = row1.first_name;
							out2_tmp.last_name = row1.last_name;
							out2_tmp.Reason = "Renew";
							out2_tmp.phone = row1.phone;
							out2_tmp.year = context.year;
							out2_tmp.log_time = TalendDate.getCurrentDate();
							out2 = out2_tmp;
							log.debug("tMap_1 - Outputting the record " + count_out2_tMap_1
									+ " of the output table 'out2'.");

// # Output table : 'out3'
							count_out3_tMap_1++;

							out3_tmp.Customer_Id = row1.customer_id;
							out3_tmp.first_name = row1.first_name;
							out3_tmp.last_name = row1.last_name;
							out3_tmp.email = row1.email;
							out3_tmp.Phone = row1.phone;
							out3_tmp.Year = context.year;
							out3 = out3_tmp;
							log.debug("tMap_1 - Outputting the record " + count_out3_tMap_1
									+ " of the output table 'out3'.");

// ###############################

						} // end of Var scope

						rejectedInnerJoin_tMap_1 = false;

						tos_count_tMap_1++;

						/**
						 * [tMap_1 main ] stop
						 */

						/**
						 * [tMap_1 process_data_begin ] start
						 */

						s(currentComponent = "tMap_1");

						/**
						 * [tMap_1 process_data_begin ] stop
						 */

// Start of branch "out2"
						if (out2 != null) {

							/**
							 * [tDBOutput_1 main ] start
							 */

							s(currentComponent = "tDBOutput_1");

							cLabel = "logs_postgres";

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out2", "tMap_1", "tMap_1", "tMap", "tDBOutput_1", "logs_postgres",
									"tPostgresqlOutput"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out2 - " + (out2 == null ? "" : out2.toLogString()));
							}

							whetherReject_tDBOutput_1 = false;
							pstmt_tDBOutput_1.setInt(1, out2.customer_id);

							if (out2.first_name == null) {
								pstmt_tDBOutput_1.setNull(2, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(2, out2.first_name);
							}

							if (out2.last_name == null) {
								pstmt_tDBOutput_1.setNull(3, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(3, out2.last_name);
							}

							if (out2.Reason == null) {
								pstmt_tDBOutput_1.setNull(4, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(4, out2.Reason);
							}

							if (out2.phone == null) {
								pstmt_tDBOutput_1.setNull(5, java.sql.Types.VARCHAR);
							} else {
								pstmt_tDBOutput_1.setString(5, out2.phone);
							}

							if (out2.year == null) {
								pstmt_tDBOutput_1.setNull(6, java.sql.Types.INTEGER);
							} else {
								pstmt_tDBOutput_1.setInt(6, out2.year);
							}

							if (out2.log_time != null) {
								pstmt_tDBOutput_1.setTimestamp(7, new java.sql.Timestamp(out2.log_time.getTime()));
							} else {
								pstmt_tDBOutput_1.setNull(7, java.sql.Types.TIMESTAMP);
							}

							pstmt_tDBOutput_1.addBatch();
							nb_line_tDBOutput_1++;

							if (log.isDebugEnabled())
								log.debug("tDBOutput_1 - " + ("Adding the record ") + (nb_line_tDBOutput_1)
										+ (" to the ") + ("INSERT") + (" batch."));
							batchSizeCounter_tDBOutput_1++;

							if ((batchSize_tDBOutput_1 > 0)
									&& (batchSize_tDBOutput_1 <= batchSizeCounter_tDBOutput_1)) {
								try {
									int countSum_tDBOutput_1 = 0;

									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
									for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}
									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
												+ (" batch execution has succeeded."));
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

									batchSizeCounter_tDBOutput_1 = 0;
								} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
									globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
									java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),
											sqle_tDBOutput_1 = null;
									String errormessage_tDBOutput_1;
									if (ne_tDBOutput_1 != null) {
										// build new exception to provide the original cause
										sqle_tDBOutput_1 = new java.sql.SQLException(
												e_tDBOutput_1.getMessage() + "\ncaused by: "
														+ ne_tDBOutput_1.getMessage(),
												ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(),
												ne_tDBOutput_1);
										errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
									} else {
										errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
									}

									int countSum_tDBOutput_1 = 0;
									for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
										countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
									}
									rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

									insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

									log.error("tDBOutput_1 - " + (errormessage_tDBOutput_1));
									System.err.println(errormessage_tDBOutput_1);

								}
							}

							commitCounter_tDBOutput_1++;
							if (commitEvery_tDBOutput_1 <= commitCounter_tDBOutput_1) {
								if ((batchSize_tDBOutput_1 > 0) && (batchSizeCounter_tDBOutput_1 > 0)) {
									try {
										int countSum_tDBOutput_1 = 0;

										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
										for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
										}
										if (log.isDebugEnabled())
											log.debug("tDBOutput_1 - " + ("The ") + ("INSERT")
													+ (" batch execution has succeeded."));
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

										batchSizeCounter_tDBOutput_1 = 0;
									} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
										globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
										java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(),
												sqle_tDBOutput_1 = null;
										String errormessage_tDBOutput_1;
										if (ne_tDBOutput_1 != null) {
											// build new exception to provide the original cause
											sqle_tDBOutput_1 = new java.sql.SQLException(
													e_tDBOutput_1.getMessage() + "\ncaused by: "
															+ ne_tDBOutput_1.getMessage(),
													ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(),
													ne_tDBOutput_1);
											errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
										} else {
											errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
										}

										int countSum_tDBOutput_1 = 0;
										for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
											countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0
													: countEach_tDBOutput_1);
										}
										rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

										insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

										log.error("tDBOutput_1 - " + (errormessage_tDBOutput_1));
										System.err.println(errormessage_tDBOutput_1);

									}
								}
								if (rowsToCommitCount_tDBOutput_1 != 0) {

									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
												+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
								}
								conn_tDBOutput_1.commit();
								if (rowsToCommitCount_tDBOutput_1 != 0) {

									if (log.isDebugEnabled())
										log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
									rowsToCommitCount_tDBOutput_1 = 0;
								}
								commitCounter_tDBOutput_1 = 0;
							}

							tos_count_tDBOutput_1++;

							/**
							 * [tDBOutput_1 main ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_begin ] start
							 */

							s(currentComponent = "tDBOutput_1");

							cLabel = "logs_postgres";

							/**
							 * [tDBOutput_1 process_data_begin ] stop
							 */

							/**
							 * [tDBOutput_1 process_data_end ] start
							 */

							s(currentComponent = "tDBOutput_1");

							cLabel = "logs_postgres";

							/**
							 * [tDBOutput_1 process_data_end ] stop
							 */

						} // End of branch "out2"

// Start of branch "out3"
						if (out3 != null) {

							/**
							 * [tDataStewardshipTaskOutput_2 main ] start
							 */

							s(currentComponent = "tDataStewardshipTaskOutput_2");

							if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

									, "out3", "tMap_1", "tMap_1", "tMap", "tDataStewardshipTaskOutput_2",
									"tDataStewardshipTaskOutput_2", "tDataStewardshipTaskOutput"

							)) {
								talendJobLogProcess(globalMap);
							}

							if (log.isTraceEnabled()) {
								log.trace("out3 - " + (out3 == null ? "" : out3.toLogString()));
							}

							boolean shouldCreateRuntimeSchemaForIncomingNode = false;
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getDesignSchema()
											.getField("Customer_Id") == null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.addIncomingNodeField("Customer_Id",
										((Object) out3.Customer_Id).getClass().getCanonicalName());
								shouldCreateRuntimeSchemaForIncomingNode = true;
							}
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getDesignSchema()
											.getField("first_name") == null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.addIncomingNodeField("first_name",
										((Object) out3.first_name).getClass().getCanonicalName());
								shouldCreateRuntimeSchemaForIncomingNode = true;
							}
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getDesignSchema()
											.getField("last_name") == null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.addIncomingNodeField("last_name",
										((Object) out3.last_name).getClass().getCanonicalName());
								shouldCreateRuntimeSchemaForIncomingNode = true;
							}
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getDesignSchema()
											.getField("email") == null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.addIncomingNodeField("email",
										((Object) out3.email).getClass().getCanonicalName());
								shouldCreateRuntimeSchemaForIncomingNode = true;
							}
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getDesignSchema()
											.getField("Phone") == null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.addIncomingNodeField("Phone",
										((Object) out3.Phone).getClass().getCanonicalName());
								shouldCreateRuntimeSchemaForIncomingNode = true;
							}
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getDesignSchema()
											.getField("Year") == null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.addIncomingNodeField("Year",
										((Object) out3.Year).getClass().getCanonicalName());
								shouldCreateRuntimeSchemaForIncomingNode = true;
							}
							if (shouldCreateRuntimeSchemaForIncomingNode
									&& incomingEnforcer_tDataStewardshipTaskOutput_2 != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.createRuntimeSchema();
							}
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.createNewRecord();
							}
							// skip the put action if the input column doesn't appear in component runtime
							// schema
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getRuntimeSchema()
											.getField("Customer_Id") != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.put("Customer_Id", out3.Customer_Id);
							}
							// skip the put action if the input column doesn't appear in component runtime
							// schema
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getRuntimeSchema()
											.getField("first_name") != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.put("first_name", out3.first_name);
							}
							// skip the put action if the input column doesn't appear in component runtime
							// schema
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getRuntimeSchema()
											.getField("last_name") != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.put("last_name", out3.last_name);
							}
							// skip the put action if the input column doesn't appear in component runtime
							// schema
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getRuntimeSchema()
											.getField("email") != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.put("email", out3.email);
							}
							// skip the put action if the input column doesn't appear in component runtime
							// schema
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getRuntimeSchema()
											.getField("Phone") != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.put("Phone", out3.Phone);
							}
							// skip the put action if the input column doesn't appear in component runtime
							// schema
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null
									&& incomingEnforcer_tDataStewardshipTaskOutput_2.getRuntimeSchema()
											.getField("Year") != null) {
								incomingEnforcer_tDataStewardshipTaskOutput_2.put("Year", out3.Year);
							}

							org.apache.avro.generic.IndexedRecord data_tDataStewardshipTaskOutput_2 = null;
							if (incomingEnforcer_tDataStewardshipTaskOutput_2 != null) {
								data_tDataStewardshipTaskOutput_2 = incomingEnforcer_tDataStewardshipTaskOutput_2
										.getCurrentRecord();
							}

							if (writer_tDataStewardshipTaskOutput_2 != null
									&& data_tDataStewardshipTaskOutput_2 != null) {
								writer_tDataStewardshipTaskOutput_2.write(data_tDataStewardshipTaskOutput_2);
							}

							nb_line_tDataStewardshipTaskOutput_2++;

							tos_count_tDataStewardshipTaskOutput_2++;

							/**
							 * [tDataStewardshipTaskOutput_2 main ] stop
							 */

							/**
							 * [tDataStewardshipTaskOutput_2 process_data_begin ] start
							 */

							s(currentComponent = "tDataStewardshipTaskOutput_2");

							/**
							 * [tDataStewardshipTaskOutput_2 process_data_begin ] stop
							 */

							/**
							 * [tDataStewardshipTaskOutput_2 process_data_end ] start
							 */

							s(currentComponent = "tDataStewardshipTaskOutput_2");

							/**
							 * [tDataStewardshipTaskOutput_2 process_data_end ] stop
							 */

						} // End of branch "out3"

						/**
						 * [tMap_1 process_data_end ] start
						 */

						s(currentComponent = "tMap_1");

						/**
						 * [tMap_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 process_data_end ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "insurance_conn";

						/**
						 * [tDBInput_1 process_data_end ] stop
						 */

						/**
						 * [tDBInput_1 end ] start
						 */

						s(currentComponent = "tDBInput_1");

						cLabel = "insurance_conn";

					}
				} finally {
					if (rs_tDBInput_1 != null) {
						rs_tDBInput_1.close();
					}
					if (stmt_tDBInput_1 != null) {
						stmt_tDBInput_1.close();
					}
					if (conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {

						log.debug("tDBInput_1 - Closing the connection to the database.");

						conn_tDBInput_1.close();

						if ("com.mysql.cj.jdbc.Driver".equals((String) globalMap.get("driverClass_"))
								&& routines.system.BundleUtils.inOSGi()) {
							Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread")
									.getMethod("checkedShutdown").invoke(null, (Object[]) null);
						}

						log.debug("tDBInput_1 - Connection to the database closed.");

					}
				}
				globalMap.put("tDBInput_1_NB_LINE", nb_line_tDBInput_1);
				log.debug("tDBInput_1 - Retrieved records count: " + nb_line_tDBInput_1 + " .");

				if (log.isDebugEnabled())
					log.debug("tDBInput_1 - " + ("Done."));

				ok_Hash.put("tDBInput_1", true);
				end_Hash.put("tDBInput_1", System.currentTimeMillis());

				/**
				 * [tDBInput_1 end ] stop
				 */

				/**
				 * [tMap_1 end ] start
				 */

				s(currentComponent = "tMap_1");

// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'out2': " + count_out2_tMap_1 + ".");
				log.debug("tMap_1 - Written records count in the table 'out3': " + count_out3_tMap_1 + ".");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row1", 2, 0,
						"tDBInput_1", "insurance_conn", "tMSSqlInput", "tMap_1", "tMap_1", "tMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tMap_1 - " + ("Done."));

				ok_Hash.put("tMap_1", true);
				end_Hash.put("tMap_1", System.currentTimeMillis());

				/**
				 * [tMap_1 end ] stop
				 */

				/**
				 * [tDBOutput_1 end ] start
				 */

				s(currentComponent = "tDBOutput_1");

				cLabel = "logs_postgres";

				try {
					int countSum_tDBOutput_1 = 0;
					if (pstmt_tDBOutput_1 != null && batchSizeCounter_tDBOutput_1 > 0) {

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("Executing the ") + ("INSERT") + (" batch."));
						for (int countEach_tDBOutput_1 : pstmt_tDBOutput_1.executeBatch()) {
							countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
						}
						rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

						if (log.isDebugEnabled())
							log.debug("tDBOutput_1 - " + ("The ") + ("INSERT") + (" batch execution has succeeded."));
					}

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

				} catch (java.sql.BatchUpdateException e_tDBOutput_1) {
					globalMap.put("tDBOutput_1_ERROR_MESSAGE", e_tDBOutput_1.getMessage());
					java.sql.SQLException ne_tDBOutput_1 = e_tDBOutput_1.getNextException(), sqle_tDBOutput_1 = null;
					String errormessage_tDBOutput_1;
					if (ne_tDBOutput_1 != null) {
						// build new exception to provide the original cause
						sqle_tDBOutput_1 = new java.sql.SQLException(
								e_tDBOutput_1.getMessage() + "\ncaused by: " + ne_tDBOutput_1.getMessage(),
								ne_tDBOutput_1.getSQLState(), ne_tDBOutput_1.getErrorCode(), ne_tDBOutput_1);
						errormessage_tDBOutput_1 = sqle_tDBOutput_1.getMessage();
					} else {
						errormessage_tDBOutput_1 = e_tDBOutput_1.getMessage();
					}

					int countSum_tDBOutput_1 = 0;
					for (int countEach_tDBOutput_1 : e_tDBOutput_1.getUpdateCounts()) {
						countSum_tDBOutput_1 += (countEach_tDBOutput_1 < 0 ? 0 : countEach_tDBOutput_1);
					}
					rowsToCommitCount_tDBOutput_1 += countSum_tDBOutput_1;

					insertedCount_tDBOutput_1 += countSum_tDBOutput_1;

					log.error("tDBOutput_1 - " + (errormessage_tDBOutput_1));
					System.err.println(errormessage_tDBOutput_1);

				}

				if (pstmt_tDBOutput_1 != null) {

					pstmt_tDBOutput_1.close();
					resourceMap.remove("pstmt_tDBOutput_1");
				}
				resourceMap.put("statementClosed_tDBOutput_1", true);
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection starting to commit ")
								+ (rowsToCommitCount_tDBOutput_1) + (" record(s)."));
				}
				conn_tDBOutput_1.commit();
				if (rowsToCommitCount_tDBOutput_1 != 0) {

					if (log.isDebugEnabled())
						log.debug("tDBOutput_1 - " + ("Connection commit has succeeded."));
					rowsToCommitCount_tDBOutput_1 = 0;
				}
				commitCounter_tDBOutput_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
				conn_tDBOutput_1.close();

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
				resourceMap.put("finish_tDBOutput_1", true);

				nb_line_deleted_tDBOutput_1 = nb_line_deleted_tDBOutput_1 + deletedCount_tDBOutput_1;
				nb_line_update_tDBOutput_1 = nb_line_update_tDBOutput_1 + updatedCount_tDBOutput_1;
				nb_line_inserted_tDBOutput_1 = nb_line_inserted_tDBOutput_1 + insertedCount_tDBOutput_1;
				nb_line_rejected_tDBOutput_1 = nb_line_rejected_tDBOutput_1 + rejectedCount_tDBOutput_1;

				globalMap.put("tDBOutput_1_NB_LINE", nb_line_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_UPDATED", nb_line_update_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_INSERTED", nb_line_inserted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_DELETED", nb_line_deleted_tDBOutput_1);
				globalMap.put("tDBOutput_1_NB_LINE_REJECTED", nb_line_rejected_tDBOutput_1);

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Has ") + ("inserted") + (" ") + (nb_line_inserted_tDBOutput_1)
							+ (" record(s)."));

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out2", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tDBOutput_1", "logs_postgres", "tPostgresqlOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tDBOutput_1 - " + ("Done."));

				ok_Hash.put("tDBOutput_1", true);
				end_Hash.put("tDBOutput_1", System.currentTimeMillis());

				/**
				 * [tDBOutput_1 end ] stop
				 */

				/**
				 * [tDataStewardshipTaskOutput_2 end ] start
				 */

				s(currentComponent = "tDataStewardshipTaskOutput_2");

// end of generic

				resourceMap.put("finish_tDataStewardshipTaskOutput_2", Boolean.TRUE);

				java.util.Map<String, Object> resultMap_tDataStewardshipTaskOutput_2 = null;
				if (writer_tDataStewardshipTaskOutput_2 != null) {
					org.talend.components.api.component.runtime.Result resultObject_tDataStewardshipTaskOutput_2 = (org.talend.components.api.component.runtime.Result) writer_tDataStewardshipTaskOutput_2
							.close();
					resultMap_tDataStewardshipTaskOutput_2 = writer_tDataStewardshipTaskOutput_2.getWriteOperation()
							.finalize(
									java.util.Arrays.<org.talend.components.api.component.runtime.Result>asList(
											resultObject_tDataStewardshipTaskOutput_2),
									container_tDataStewardshipTaskOutput_2);
				}
				if (resultMap_tDataStewardshipTaskOutput_2 != null) {
					for (java.util.Map.Entry<String, Object> entry_tDataStewardshipTaskOutput_2 : resultMap_tDataStewardshipTaskOutput_2
							.entrySet()) {
						switch (entry_tDataStewardshipTaskOutput_2.getKey()) {
						case org.talend.components.api.component.ComponentDefinition.RETURN_ERROR_MESSAGE:
							container_tDataStewardshipTaskOutput_2.setComponentData("tDataStewardshipTaskOutput_2",
									"ERROR_MESSAGE", entry_tDataStewardshipTaskOutput_2.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_TOTAL_RECORD_COUNT:
							container_tDataStewardshipTaskOutput_2.setComponentData("tDataStewardshipTaskOutput_2",
									"NB_LINE", entry_tDataStewardshipTaskOutput_2.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_SUCCESS_RECORD_COUNT:
							container_tDataStewardshipTaskOutput_2.setComponentData("tDataStewardshipTaskOutput_2",
									"NB_SUCCESS", entry_tDataStewardshipTaskOutput_2.getValue());
							break;
						case org.talend.components.api.component.ComponentDefinition.RETURN_REJECT_RECORD_COUNT:
							container_tDataStewardshipTaskOutput_2.setComponentData("tDataStewardshipTaskOutput_2",
									"NB_REJECT", entry_tDataStewardshipTaskOutput_2.getValue());
							break;
						default:
							StringBuilder studio_key_tDataStewardshipTaskOutput_2 = new StringBuilder();
							for (int i_tDataStewardshipTaskOutput_2 = 0; i_tDataStewardshipTaskOutput_2 < entry_tDataStewardshipTaskOutput_2
									.getKey().length(); i_tDataStewardshipTaskOutput_2++) {
								char ch_tDataStewardshipTaskOutput_2 = entry_tDataStewardshipTaskOutput_2.getKey()
										.charAt(i_tDataStewardshipTaskOutput_2);
								if (Character.isUpperCase(ch_tDataStewardshipTaskOutput_2)
										&& i_tDataStewardshipTaskOutput_2 > 0) {
									studio_key_tDataStewardshipTaskOutput_2.append('_');
								}
								studio_key_tDataStewardshipTaskOutput_2.append(ch_tDataStewardshipTaskOutput_2);
							}
							container_tDataStewardshipTaskOutput_2.setComponentData(
									"tDataStewardshipTaskOutput_2", studio_key_tDataStewardshipTaskOutput_2.toString()
											.toUpperCase(java.util.Locale.ENGLISH),
									entry_tDataStewardshipTaskOutput_2.getValue());
							break;
						}
					}
				}

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "out3", 2, 0, "tMap_1",
						"tMap_1", "tMap", "tDataStewardshipTaskOutput_2", "tDataStewardshipTaskOutput_2",
						"tDataStewardshipTaskOutput", "output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tDataStewardshipTaskOutput_2", true);
				end_Hash.put("tDataStewardshipTaskOutput_2", System.currentTimeMillis());

				/**
				 * [tDataStewardshipTaskOutput_2 end ] stop
				 */

			} // end the resume

			if (resumeEntryMethodName == null || globalResumeTicket) {
				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tDBInput_1:OnSubjobOk", "",
						Thread.currentThread().getId() + "", "", "", "", "", "");
			}

			if (execStat) {
				runStat.updateStatOnConnection("OnSubjobOk1", 0, "ok");
			}

			tFixedFlowInput_1Process(globalMap);

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
				 * [tDBInput_1 finally ] start
				 */

				s(currentComponent = "tDBInput_1");

				cLabel = "insurance_conn";

				/**
				 * [tDBInput_1 finally ] stop
				 */

				/**
				 * [tMap_1 finally ] start
				 */

				s(currentComponent = "tMap_1");

				/**
				 * [tMap_1 finally ] stop
				 */

				/**
				 * [tDBOutput_1 finally ] start
				 */

				s(currentComponent = "tDBOutput_1");

				cLabel = "logs_postgres";

				try {
					if (resourceMap.get("statementClosed_tDBOutput_1") == null) {
						java.sql.PreparedStatement pstmtToClose_tDBOutput_1 = null;
						if ((pstmtToClose_tDBOutput_1 = (java.sql.PreparedStatement) resourceMap
								.remove("pstmt_tDBOutput_1")) != null) {
							pstmtToClose_tDBOutput_1.close();
						}
					}
				} finally {
					if (resourceMap.get("finish_tDBOutput_1") == null) {
						java.sql.Connection ctn_tDBOutput_1 = null;
						if ((ctn_tDBOutput_1 = (java.sql.Connection) resourceMap.get("conn_tDBOutput_1")) != null) {
							try {
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Closing the connection to the database."));
								ctn_tDBOutput_1.close();
								if (log.isDebugEnabled())
									log.debug("tDBOutput_1 - " + ("Connection to the database has closed."));
							} catch (java.sql.SQLException sqlEx_tDBOutput_1) {
								String errorMessage_tDBOutput_1 = "failed to close the connection in tDBOutput_1 :"
										+ sqlEx_tDBOutput_1.getMessage();
								log.error("tDBOutput_1 - " + (errorMessage_tDBOutput_1));
								System.err.println(errorMessage_tDBOutput_1);
							}
						}
					}
				}

				/**
				 * [tDBOutput_1 finally ] stop
				 */

				/**
				 * [tDataStewardshipTaskOutput_2 finally ] start
				 */

				s(currentComponent = "tDataStewardshipTaskOutput_2");

// finally of generic

				if (resourceMap.get("finish_tDataStewardshipTaskOutput_2") == null) {
					if (resourceMap.get("writer_tDataStewardshipTaskOutput_2") != null) {
						try {
							((org.talend.components.api.component.runtime.Writer) resourceMap
									.get("writer_tDataStewardshipTaskOutput_2")).close();
						} catch (java.io.IOException e_tDataStewardshipTaskOutput_2) {
							String errorMessage_tDataStewardshipTaskOutput_2 = "failed to release the resource in tDataStewardshipTaskOutput_2 :"
									+ e_tDataStewardshipTaskOutput_2.getMessage();
							System.err.println(errorMessage_tDataStewardshipTaskOutput_2);
						}
					}
				}

				/**
				 * [tDataStewardshipTaskOutput_2 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tDBInput_1_SUBPROCESS_STATE", 1);
	}

	public static class responseStruct implements routines.system.IPersistableRow<responseStruct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public String body;

		public String getBody() {
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

			return null;

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

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.body = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.body, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("body=" + body);
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
		public int compareTo(responseStruct other) {

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

	public static class row3Struct implements routines.system.IPersistableRow<row3Struct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Boolean messageIsNullable() {
			return true;
		}

		public Boolean messageIsKey() {
			return false;
		}

		public Integer messageLength() {
			return null;
		}

		public Integer messagePrecision() {
			return null;
		}

		public String messageDefault() {

			return null;

		}

		public String messageComment() {

			return "";

		}

		public String messagePattern() {

			return "";

		}

		public String messageOriginalDbColumnName() {

			return "message";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("message=" + message);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
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

	public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public String message;

		public String getMessage() {
			return this.message;
		}

		public Boolean messageIsNullable() {
			return true;
		}

		public Boolean messageIsKey() {
			return false;
		}

		public Integer messageLength() {
			return null;
		}

		public Integer messagePrecision() {
			return null;
		}

		public String messageDefault() {

			return null;

		}

		public String messageComment() {

			return "";

		}

		public String messagePattern() {

			return "";

		}

		public String messageOriginalDbColumnName() {

			return "message";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.message = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.message, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("message=" + message);
			sb.append("]");

			return sb.toString();
		}

		public String toLogString() {
			StringBuilder sb = new StringBuilder();

			if (message == null) {
				sb.append("<null>");
			} else {
				sb.append(message);
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

	public void tFixedFlowInput_1Process(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tFixedFlowInput_1", "uO5B8E_");

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
				row2Struct row3 = row2;
				responseStruct response = new responseStruct();

				/**
				 * [tRESTResponse_1 begin ] start
				 */

				sh("tRESTResponse_1");

				s(currentComponent = "tRESTResponse_1");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "response");

				int tos_count_tRESTResponse_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTResponse_1", "tRESTResponse_1", "tRESTResponse");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				/**
				 * [tRESTResponse_1 begin ] stop
				 */

				/**
				 * [tXMLMap_1 begin ] start
				 */

				sh("tXMLMap_1");

				s(currentComponent = "tXMLMap_1");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row3");

				int tos_count_tXMLMap_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tXMLMap_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tXMLMap_1 = new StringBuilder();
							log4jParamters_tXMLMap_1.append("Parameters:");
							log4jParamters_tXMLMap_1.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
							log4jParamters_tXMLMap_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tXMLMap_1 - " + (log4jParamters_tXMLMap_1));
						}
					}
					new BytesLimit65535_tXMLMap_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tXMLMap_1", "tXMLMap_1", "tXMLMap");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

//===============================input xml init part===============================
				class XML_API_tXMLMap_1 {
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
				class Var__tXMLMap_1__Struct {
				}
				Var__tXMLMap_1__Struct Var__tXMLMap_1 = new Var__tXMLMap_1__Struct();
// ###############################
// # Outputs initialization
				responseStruct response_tmp = new responseStruct();
				responseStruct response_save = null;
				int count_response_tXMLMap_1 = 0;
// ###############################
				int nb_line_tXMLMap_1 = 0;

				XML_API_tXMLMap_1 xml_api_tXMLMap_1 = new XML_API_tXMLMap_1();

				/**
				 * [tXMLMap_1 begin ] stop
				 */

				/**
				 * [tLogRow_1 begin ] start
				 */

				sh("tLogRow_1");

				s(currentComponent = "tLogRow_1");

				runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "row2");

				int tos_count_tLogRow_1 = 0;

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Start to work."));
				if (log.isDebugEnabled()) {
					class BytesLimit65535_tLogRow_1 {
						public void limitLog4jByte() throws Exception {
							StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
							log4jParamters_tLogRow_1.append("Parameters:");
							log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("FIELDSEPARATOR" + " = " + "\"|\"");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_HEADER" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_UNIQUE_NAME" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_COLNAMES" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("USE_FIXED_LENGTH" + " = " + "false");
							log4jParamters_tLogRow_1.append(" | ");
							log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
							log4jParamters_tLogRow_1.append(" | ");
							if (log.isDebugEnabled())
								log.debug("tLogRow_1 - " + (log4jParamters_tLogRow_1));
						}
					}
					new BytesLimit65535_tLogRow_1().limitLog4jByte();
				}
				if (enableLogStash) {
					talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				///////////////////////

				final String OUTPUT_FIELD_SEPARATOR_tLogRow_1 = "|";
				java.io.PrintStream consoleOut_tLogRow_1 = null;

				StringBuilder strBuffer_tLogRow_1 = null;
				int nb_line_tLogRow_1 = 0;
///////////////////////    			

				/**
				 * [tLogRow_1 begin ] stop
				 */

				/**
				 * [tFixedFlowInput_1 begin ] start
				 */

				sh("tFixedFlowInput_1");

				s(currentComponent = "tFixedFlowInput_1");

				int tos_count_tFixedFlowInput_1 = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tFixedFlowInput_1", "tFixedFlowInput_1", "tFixedFlowInput");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				for (int i_tFixedFlowInput_1 = 0; i_tFixedFlowInput_1 < 1; i_tFixedFlowInput_1++) {

					row2.message = "Request for Customer " + context.id + " has been recorded to renew for"
							+ context.year + " years. ";

					/**
					 * [tFixedFlowInput_1 begin ] stop
					 */

					/**
					 * [tFixedFlowInput_1 main ] start
					 */

					s(currentComponent = "tFixedFlowInput_1");

					tos_count_tFixedFlowInput_1++;

					/**
					 * [tFixedFlowInput_1 main ] stop
					 */

					/**
					 * [tFixedFlowInput_1 process_data_begin ] start
					 */

					s(currentComponent = "tFixedFlowInput_1");

					/**
					 * [tFixedFlowInput_1 process_data_begin ] stop
					 */

					/**
					 * [tLogRow_1 main ] start
					 */

					s(currentComponent = "tLogRow_1");

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row2", "tFixedFlowInput_1", "tFixedFlowInput_1", "tFixedFlowInput", "tLogRow_1",
							"tLogRow_1", "tLogRow"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row2 - " + (row2 == null ? "" : row2.toLogString()));
					}

///////////////////////		

					strBuffer_tLogRow_1 = new StringBuilder();

					if (row2.message != null) { //

						strBuffer_tLogRow_1.append(String.valueOf(row2.message));

					} //

					if (globalMap.get("tLogRow_CONSOLE") != null) {
						consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
					} else {
						consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
						globalMap.put("tLogRow_CONSOLE", consoleOut_tLogRow_1);
					}
					log.info("tLogRow_1 - Content of row " + (nb_line_tLogRow_1 + 1) + ": "
							+ strBuffer_tLogRow_1.toString());
					consoleOut_tLogRow_1.println(strBuffer_tLogRow_1.toString());
					consoleOut_tLogRow_1.flush();
					nb_line_tLogRow_1++;
//////

//////                    

///////////////////////    			

					row3 = row2;

					tos_count_tLogRow_1++;

					/**
					 * [tLogRow_1 main ] stop
					 */

					/**
					 * [tLogRow_1 process_data_begin ] start
					 */

					s(currentComponent = "tLogRow_1");

					/**
					 * [tLogRow_1 process_data_begin ] stop
					 */

					/**
					 * [tXMLMap_1 main ] start
					 */

					s(currentComponent = "tXMLMap_1");

					if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

							, "row3", "tLogRow_1", "tLogRow_1", "tLogRow", "tXMLMap_1", "tXMLMap_1", "tXMLMap"

					)) {
						talendJobLogProcess(globalMap);
					}

					if (log.isTraceEnabled()) {
						log.trace("row3 - " + (row3 == null ? "" : row3.toLogString()));
					}

					boolean rejectedInnerJoin_tXMLMap_1 = false;
					boolean rejectedDocInnerJoin_tXMLMap_1 = false;
					boolean mainRowRejected_tXMLMap_1 = false;
					boolean isMatchDocRowtXMLMap_1 = false;

					{ // start of Var scope

						// ###############################
						// # Vars tables

						Var__tXMLMap_1__Struct Var = Var__tXMLMap_1;
						// ###############################
						// # Output tables

						response = null;

// # Output table : 'response'
						count_response_tXMLMap_1++;

						response_tmp.body = row3.message;
						response = response_tmp;
						log.debug("tXMLMap_1 - Outputting the record " + count_response_tXMLMap_1
								+ " of the output table 'response'.");

// ###############################

					} // end of Var scope

					rejectedInnerJoin_tXMLMap_1 = false;

					tos_count_tXMLMap_1++;

					/**
					 * [tXMLMap_1 main ] stop
					 */

					/**
					 * [tXMLMap_1 process_data_begin ] start
					 */

					s(currentComponent = "tXMLMap_1");

					/**
					 * [tXMLMap_1 process_data_begin ] stop
					 */

// Start of branch "response"
					if (response != null) {

						/**
						 * [tRESTResponse_1 main ] start
						 */

						s(currentComponent = "tRESTResponse_1");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "response", "tXMLMap_1", "tXMLMap_1", "tXMLMap", "tRESTResponse_1", "tRESTResponse_1",
								"tRESTResponse"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("response - " + (response == null ? "" : response.toLogString()));
						}

						java.io.OutputStream outputStream_tRESTResponse_1 = (java.io.OutputStream) globalMap
								.get("restResponseStream");
						boolean responseAlreadySent_tRESTResponse_1 = globalMap.containsKey("restResponse");

						if (null == outputStream_tRESTResponse_1 && responseAlreadySent_tRESTResponse_1) {
							throw new RuntimeException("Rest response already sent.");
						} else if (!globalMap.containsKey("restRequest")) {
							throw new RuntimeException("Not received rest request yet.");
						} else {
							Integer restProviderStatusCode_tRESTResponse_1 = 200;

							Object restProviderResponse_tRESTResponse_1 = null;
							restProviderResponse_tRESTResponse_1 = response.body;

							java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_1 = new java.util.TreeMap<String, String>(
									String.CASE_INSENSITIVE_ORDER);
							java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_1 = new java.lang.StringBuilder();
							final String setCookieHeader = "Set-Cookie";

							if (restProviderResponseHeader_cookies_tRESTResponse_1.length() > 0) {
								restProviderResponseHeaders_tRESTResponse_1.put(setCookieHeader,
										restProviderResponseHeader_cookies_tRESTResponse_1.toString());
							}

							java.util.Map<String, Object> restRequest_tRESTResponse_1 = (java.util.Map<String, Object>) globalMap
									.get("restRequest");
							org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_1 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_1
									.get("MESSAGE_CONTEXT");

							if (null == outputStream_tRESTResponse_1) {
								java.util.Map<String, Object> restResponse_tRESTResponse_1 = new java.util.HashMap<String, Object>();
								restResponse_tRESTResponse_1.put("BODY", restProviderResponse_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("STATUS", restProviderStatusCode_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("HEADERS",
										restProviderResponseHeaders_tRESTResponse_1);
								restResponse_tRESTResponse_1.put("drop.json.root.element", Boolean.valueOf(false));
								globalMap.put("restResponse", restResponse_tRESTResponse_1);

							} else {

								jakarta.ws.rs.core.MediaType responseMediaType_tRESTResponse_1 = null;
								if (!responseAlreadySent_tRESTResponse_1) {
									org.apache.cxf.message.Message currentMessage = null;
									if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
										currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
									} else {
										currentMessage = ((org.apache.cxf.message.Message) restRequest_tRESTResponse_1
												.get("CURRENT_MESSAGE"));
									}

									if (currentMessage != null && currentMessage.getExchange() != null) {
										currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION,
												true);
									}

									messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.RESPONSE_CODE,
											restProviderStatusCode_tRESTResponse_1);
									jakarta.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_1 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
									for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_1
											.entrySet()) {
										headersMultivaluedMap_tRESTResponse_1.putSingle(multivaluedHeader.getKey(),
												multivaluedHeader.getValue());
									}
									messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS,
											headersMultivaluedMap_tRESTResponse_1);

									String responseContentType_tRESTResponse_1 = null;

									if (currentMessage != null && currentMessage.getExchange() != null) {
										responseContentType_tRESTResponse_1 = (String) currentMessage.getExchange()
												.get(org.apache.cxf.message.Message.CONTENT_TYPE);
									}

									if (null == responseContentType_tRESTResponse_1) {
										// this should not be needed, just in case. set it to the first value in the
										// sorted list returned from HttpHeaders
										responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1
												.getHttpHeaders().getAcceptableMediaTypes().get(0);
									} else {
										responseMediaType_tRESTResponse_1 = org.apache.cxf.jaxrs.utils.JAXRSUtils
												.toMediaType(responseContentType_tRESTResponse_1);
									}
									globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_1);

									String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_1.equals("xml")
											|| responseMediaSubType_tRESTResponse_1.endsWith("+xml")) {
										outputStream_tRESTResponse_1.write("<wrapper>".getBytes());
										globalMap.put("restResponseWrappingClosure", "</wrapper>");
									}
									if (responseMediaSubType_tRESTResponse_1.equals("json")
											|| responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
										outputStream_tRESTResponse_1.write("[".getBytes());
										globalMap.put("restResponseWrappingClosure", "]");
									}

									globalMap.put("restResponse", true);
								} else {
									responseMediaType_tRESTResponse_1 = (jakarta.ws.rs.core.MediaType) globalMap
											.get("restResponseMediaType");
								}

								if (null != restProviderResponse_tRESTResponse_1) {
									String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1
											.getSubtype();
									if (responseMediaSubType_tRESTResponse_1.equals("json")
											|| responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
										if (globalMap.containsKey("restResponseJsonStarted")) {
											outputStream_tRESTResponse_1.write(",".getBytes());
										} else {
											globalMap.put("restResponseJsonStarted", true);
										}
									}

									Class<? extends Object> responseBodyClass_tRESTResponse_1 = restProviderResponse_tRESTResponse_1
											.getClass();
									jakarta.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_1 = messageContext_tRESTResponse_1
											.getProviders();
									jakarta.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_1 = messageBodyProviders_tRESTResponse_1
											.getMessageBodyWriter(responseBodyClass_tRESTResponse_1,
													responseBodyClass_tRESTResponse_1, null,
													responseMediaType_tRESTResponse_1);

									if (messageBodyWriter_tRESTResponse_1 instanceof StreamingDOM4JProvider) {
										((StreamingDOM4JProvider) messageBodyWriter_tRESTResponse_1)
												.setGlobalMap(globalMap);
									}

									messageBodyWriter_tRESTResponse_1.writeTo(restProviderResponse_tRESTResponse_1,
											responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1,
											new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_1,
											null, outputStream_tRESTResponse_1);
								}
								// initial variant
								// outputStream_tRESTResponse_1.write(String.valueOf(restProviderResponse_tRESTResponse_1).getBytes());
								outputStream_tRESTResponse_1.flush();
							}
						}

						tos_count_tRESTResponse_1++;

						/**
						 * [tRESTResponse_1 main ] stop
						 */

						/**
						 * [tRESTResponse_1 process_data_begin ] start
						 */

						s(currentComponent = "tRESTResponse_1");

						/**
						 * [tRESTResponse_1 process_data_begin ] stop
						 */

						/**
						 * [tRESTResponse_1 process_data_end ] start
						 */

						s(currentComponent = "tRESTResponse_1");

						/**
						 * [tRESTResponse_1 process_data_end ] stop
						 */

					} // End of branch "response"

					/**
					 * [tXMLMap_1 process_data_end ] start
					 */

					s(currentComponent = "tXMLMap_1");

					/**
					 * [tXMLMap_1 process_data_end ] stop
					 */

					/**
					 * [tLogRow_1 process_data_end ] start
					 */

					s(currentComponent = "tLogRow_1");

					/**
					 * [tLogRow_1 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_1 process_data_end ] start
					 */

					s(currentComponent = "tFixedFlowInput_1");

					/**
					 * [tFixedFlowInput_1 process_data_end ] stop
					 */

					/**
					 * [tFixedFlowInput_1 end ] start
					 */

					s(currentComponent = "tFixedFlowInput_1");

				}
				globalMap.put("tFixedFlowInput_1_NB_LINE", 1);

				ok_Hash.put("tFixedFlowInput_1", true);
				end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());

				/**
				 * [tFixedFlowInput_1 end ] stop
				 */

				/**
				 * [tLogRow_1 end ] start
				 */

				s(currentComponent = "tLogRow_1");

//////
//////
				globalMap.put("tLogRow_1_NB_LINE", nb_line_tLogRow_1);
				if (log.isInfoEnabled())
					log.info("tLogRow_1 - " + ("Printed row count: ") + (nb_line_tLogRow_1) + ("."));

///////////////////////    			

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row2", 2, 0,
						"tFixedFlowInput_1", "tFixedFlowInput_1", "tFixedFlowInput", "tLogRow_1", "tLogRow_1",
						"tLogRow", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tLogRow_1 - " + ("Done."));

				ok_Hash.put("tLogRow_1", true);
				end_Hash.put("tLogRow_1", System.currentTimeMillis());

				/**
				 * [tLogRow_1 end ] stop
				 */

				/**
				 * [tXMLMap_1 end ] start
				 */

				s(currentComponent = "tXMLMap_1");

				log.debug(
						"tXMLMap_1 - Written records count in the table 'response': " + count_response_tXMLMap_1 + ".");
				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "row3", 2, 0,
						"tLogRow_1", "tLogRow_1", "tLogRow", "tXMLMap_1", "tXMLMap_1", "tXMLMap", "output")) {
					talendJobLogProcess(globalMap);
				}

				if (log.isDebugEnabled())
					log.debug("tXMLMap_1 - " + ("Done."));

				ok_Hash.put("tXMLMap_1", true);
				end_Hash.put("tXMLMap_1", System.currentTimeMillis());

				/**
				 * [tXMLMap_1 end ] stop
				 */

				/**
				 * [tRESTResponse_1 end ] start
				 */

				s(currentComponent = "tRESTResponse_1");

				if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "response", 2, 0,
						"tXMLMap_1", "tXMLMap_1", "tXMLMap", "tRESTResponse_1", "tRESTResponse_1", "tRESTResponse",
						"output")) {
					talendJobLogProcess(globalMap);
				}

				ok_Hash.put("tRESTResponse_1", true);
				end_Hash.put("tRESTResponse_1", System.currentTimeMillis());

				/**
				 * [tRESTResponse_1 end ] stop
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
				 * [tFixedFlowInput_1 finally ] start
				 */

				s(currentComponent = "tFixedFlowInput_1");

				/**
				 * [tFixedFlowInput_1 finally ] stop
				 */

				/**
				 * [tLogRow_1 finally ] start
				 */

				s(currentComponent = "tLogRow_1");

				/**
				 * [tLogRow_1 finally ] stop
				 */

				/**
				 * [tXMLMap_1 finally ] start
				 */

				s(currentComponent = "tXMLMap_1");

				/**
				 * [tXMLMap_1 finally ] stop
				 */

				/**
				 * [tRESTResponse_1 finally ] start
				 */

				s(currentComponent = "tRESTResponse_1");

				/**
				 * [tRESTResponse_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}

	public static class post_logStruct implements routines.system.IPersistableRow<post_logStruct> {
		final static byte[] commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship = new byte[0];
		static byte[] commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[0];

		public String id;

		public String getId() {
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

		public String year;

		public String getYear() {
			return this.year;
		}

		public Boolean yearIsNullable() {
			return true;
		}

		public Boolean yearIsKey() {
			return false;
		}

		public Integer yearLength() {
			return null;
		}

		public Integer yearPrecision() {
			return null;
		}

		public String yearDefault() {

			return null;

		}

		public String yearComment() {

			return "";

		}

		public String yearPattern() {

			return "";

		}

		public String yearOriginalDbColumnName() {

			return "year";

		}

		private String readString(ObjectInputStream dis) throws IOException {
			String strReturn = null;
			int length = 0;
			length = dis.readInt();
			if (length == -1) {
				strReturn = null;
			} else {
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				dis.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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
				if (length > commonByteArray_DPDP_RENEW_Job1_ToStewardship.length) {
					if (length < 1024 && commonByteArray_DPDP_RENEW_Job1_ToStewardship.length == 0) {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[1024];
					} else {
						commonByteArray_DPDP_RENEW_Job1_ToStewardship = new byte[2 * length];
					}
				}
				unmarshaller.readFully(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length);
				strReturn = new String(commonByteArray_DPDP_RENEW_Job1_ToStewardship, 0, length, utf8Charset);
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

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.id = readString(dis);

					this.year = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void readData(org.jboss.marshalling.Unmarshaller dis) {

			synchronized (commonByteArrayLock_DPDP_RENEW_Job1_ToStewardship) {

				try {

					int length = 0;

					this.id = readString(dis);

					this.year = readString(dis);

				} catch (IOException e) {
					throw new RuntimeException(e);

				}

			}

		}

		public void writeData(ObjectOutputStream dos) {
			try {

				// String

				writeString(this.id, dos);

				// String

				writeString(this.year, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public void writeData(org.jboss.marshalling.Marshaller dos) {
			try {

				// String

				writeString(this.id, dos);

				// String

				writeString(this.year, dos);

			} catch (IOException e) {
				throw new RuntimeException(e);
			}

		}

		public String toString() {

			StringBuilder sb = new StringBuilder();
			sb.append(super.toString());
			sb.append("[");
			sb.append("id=" + id);
			sb.append(",year=" + year);
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

			if (year == null) {
				sb.append("<null>");
			} else {
				sb.append(year);
			}

			sb.append("|");

			return sb.toString();
		}

		/**
		 * Compare keys
		 */
		public int compareTo(post_logStruct other) {

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

	public void tRESTRequest_1_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 0);

		final boolean execStat = this.execStat;

		mdc("tRESTRequest_1_Loop", "2DSN3V_");

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

				post_logStruct post_log = new post_logStruct();

				/**
				 * [tRESTRequest_1_Loop begin ] start
				 */

				int NB_ITERATE_tRESTRequest_1_In = 0; // for statistics

				sh("tRESTRequest_1_Loop");

				currentVirtualComponent = "tRESTRequest_1";

				s(currentComponent = "tRESTRequest_1_Loop");

				int tos_count_tRESTRequest_1_Loop = 0;

				if (enableLogStash) {
					talendJobLog.addCM("tRESTRequest_1_Loop", "tRESTRequest_1_Loop", "tRESTRequestLoop");
					talendJobLogProcess(globalMap);
					s(currentComponent);
				}

				runStat.updateStatAndLog(execStat, enableLogStash, iterateId, 0, 0, "post_log");

				post_log = null;

				int nb_line_tRESTRequest_1 = 0;

				try {

					java.util.Map<String, Object> requestMessage_tRESTRequest_1 = (java.util.Map<String, Object>) globalMap
							.get("restRequest");

					restEndpoint = getRestEndpoint();

					if (null == requestMessage_tRESTRequest_1) {

						if (restTalendJobAlreadyStarted) {
							throw new RuntimeException("request is not provided");
						} else {
							if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
								String endpointUrl_tRESTRequest_1 = checkEndpointUrl(restEndpoint);
								// *** external thread for endpoint initialization
								thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this,
										endpointUrl_tRESTRequest_1);
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
								} catch (InterruptedException e_tRESTRequest_1) {
									// e_tRESTRequest_1.printStackTrace();
									// throw new TalendException(e_tRESTRequest_1, "wholeJob", globalMap);
								}
							}
						}
						return;
					}

					requestMessage_tRESTRequest_1.put("CURRENT_MESSAGE",
							org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

					Object ctx_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("MESSAGE_CONTEXT");
					if (ctx_tRESTRequest_1 != null
							&& ctx_tRESTRequest_1 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
						requestMessage_tRESTRequest_1.put("MESSAGE_CONTEXT",
								((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) ctx_tRESTRequest_1).get());
					}

					/**
					 * [tRESTRequest_1_Loop begin ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop main ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_Loop");

					resourceMap.put("inIterateVComp", true);

					tos_count_tRESTRequest_1_Loop++;

					/**
					 * [tRESTRequest_1_Loop main ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_Loop");

					/**
					 * [tRESTRequest_1_Loop process_data_begin ] stop
					 */

					NB_ITERATE_tRESTRequest_1_In++;

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 1, "exec" + NB_ITERATE_tRESTRequest_1_In);
						// Thread.sleep(1000);
					}

					/**
					 * [tJavaRow_1 begin ] start
					 */

					sh("tJavaRow_1");

					s(currentComponent = "tJavaRow_1");

					runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, 0, 0, "post_log");

					int tos_count_tJavaRow_1 = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tJavaRow_1", "tJavaRow_1", "tJavaRow");
						talendJobLogProcess(globalMap);
						s(currentComponent);
					}

					int nb_line_tJavaRow_1 = 0;

					/**
					 * [tJavaRow_1 begin ] stop
					 */

					/**
					 * [tRESTRequest_1_In begin ] start
					 */

					sh("tRESTRequest_1_In");

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_In");

					int tos_count_tRESTRequest_1_In = 0;

					if (enableLogStash) {
						talendJobLog.addCM("tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn");
						talendJobLogProcess(globalMap);
						s(currentComponent);
					}

					resourceMap.remove("inIterateVComp");

					/**
					 * [tRESTRequest_1_In begin ] stop
					 */

					/**
					 * [tRESTRequest_1_In main ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_In");

					if (requestMessage_tRESTRequest_1.containsKey("ERROR")) { // wrong request received
						post_log = null;
					} else { // non-error (not wrong request)

						String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
						String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

						java.util.Map<String, Object> params_tRESTRequest_1 = (java.util.Map<String, Object>) requestMessage_tRESTRequest_1
								.get("PARAMS");
						if (matchedFlow_tRESTRequest_1.equals("post_log")) {
							post_log = new post_logStruct();
							if (params_tRESTRequest_1.containsKey("PATH:id:id_String")) {

								post_log.id = (String) params_tRESTRequest_1.get("PATH:id:id_String");

							}
							if (params_tRESTRequest_1.containsKey("PATH:year:id_String")) {

								post_log.year = (String) params_tRESTRequest_1.get("PATH:year:id_String");

							}
						} else { // non matched flow
							post_log = null;
						}

					}

					globalMap.put("tRESTRequest_1_URI", (String) requestMessage_tRESTRequest_1.get("URI"));
					globalMap.put("tRESTRequest_1_URI_BASE", (String) requestMessage_tRESTRequest_1.get("URI_BASE"));
					globalMap.put("tRESTRequest_1_URI_ABSOLUTE",
							(String) requestMessage_tRESTRequest_1.get("URI_ABSOLUTE"));
					globalMap.put("tRESTRequest_1_URI_REQUEST",
							(String) requestMessage_tRESTRequest_1.get("URI_REQUEST"));
					globalMap.put("tRESTRequest_1_HTTP_METHOD", (String) requestMessage_tRESTRequest_1.get("VERB"));

					globalMap.put("tRESTRequest_1_ATTACHMENT_HEADERS",
							requestMessage_tRESTRequest_1.get("ATTACHMENT_HEADERS"));
					globalMap.put("tRESTRequest_1_ATTACHMENT_FILENAMES",
							requestMessage_tRESTRequest_1.get("ATTACHMENT_FILENAMES"));

					globalMap.put("tRESTRequest_1_PRINCIPAL_NAME",
							(String) requestMessage_tRESTRequest_1.get("PRINCIPAL_NAME"));
					globalMap.put("tRESTRequest_1_CORRELATION_ID",
							(String) requestMessage_tRESTRequest_1.get("CorrelationID"));

					tos_count_tRESTRequest_1_In++;

					/**
					 * [tRESTRequest_1_In main ] stop
					 */

					/**
					 * [tRESTRequest_1_In process_data_begin ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_In");

					/**
					 * [tRESTRequest_1_In process_data_begin ] stop
					 */

// Start of branch "post_log"
					if (post_log != null) {

						/**
						 * [tJavaRow_1 main ] start
						 */

						s(currentComponent = "tJavaRow_1");

						if (runStat.update(execStat, enableLogStash, iterateId, 1, 1

								, "post_log", "tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn", "tJavaRow_1",
								"tJavaRow_1", "tJavaRow"

						)) {
							talendJobLogProcess(globalMap);
						}

						if (log.isTraceEnabled()) {
							log.trace("post_log - " + (post_log == null ? "" : post_log.toLogString()));
						}

						// Code generated according to input schema and output schema
						context.id = Integer.parseInt(post_log.id);
						context.year = Integer.parseInt(post_log.year);
						nb_line_tJavaRow_1++;

						tos_count_tJavaRow_1++;

						/**
						 * [tJavaRow_1 main ] stop
						 */

						/**
						 * [tJavaRow_1 process_data_begin ] start
						 */

						s(currentComponent = "tJavaRow_1");

						if (post_log != null) {

						}

						/**
						 * [tJavaRow_1 process_data_begin ] stop
						 */

						/**
						 * [tJavaRow_1 process_data_end ] start
						 */

						s(currentComponent = "tJavaRow_1");

						if (post_log != null) {

						}

						/**
						 * [tJavaRow_1 process_data_end ] stop
						 */

					} // End of branch "post_log"

					/**
					 * [tRESTRequest_1_In process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_In");

					/**
					 * [tRESTRequest_1_In process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_1_In end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_In");

					resourceMap.put("inIterateVComp", true);

					ok_Hash.put("tRESTRequest_1_In", true);
					end_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());

					/**
					 * [tRESTRequest_1_In end ] stop
					 */

					/**
					 * [tJavaRow_1 end ] start
					 */

					s(currentComponent = "tJavaRow_1");

					if (post_log != null) {

						globalMap.put("tJavaRow_1_NB_LINE", nb_line_tJavaRow_1);
						if (runStat.updateStatAndLog(execStat, enableLogStash, resourceMap, iterateId, "post_log", 2, 0,
								"tRESTRequest_1_In", "tRESTRequest_1_In", "tRESTRequestIn", "tJavaRow_1", "tJavaRow_1",
								"tJavaRow", "output")) {
							talendJobLogProcess(globalMap);
						}

						ok_Hash.put("tJavaRow_1", true);
						end_Hash.put("tJavaRow_1", System.currentTimeMillis());

						if (execStat) {
							runStat.updateStatOnConnection("OnComponentOk1", 0, "ok");
						}
						tDBInput_1Process(globalMap);

					}

					/**
					 * [tJavaRow_1 end ] stop
					 */

					if (execStat) {
						runStat.updateStatOnConnection("Iterate", 2, "exec" + NB_ITERATE_tRESTRequest_1_In);
					}

					/**
					 * [tRESTRequest_1_Loop process_data_end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_Loop");

					/**
					 * [tRESTRequest_1_Loop process_data_end ] stop
					 */

					/**
					 * [tRESTRequest_1_Loop end ] start
					 */

					currentVirtualComponent = "tRESTRequest_1";

					s(currentComponent = "tRESTRequest_1_Loop");

					resourceMap.remove("inIterateVComp");

				} catch (Throwable e_tRESTRequest_1) {
					if (e_tRESTRequest_1 instanceof Exception) {
						new TalendException((Exception) e_tRESTRequest_1, currentComponent, globalMap)
								.printStackTrace();
					} else {
						new TalendException(new RuntimeException(e_tRESTRequest_1), currentComponent, globalMap)
								.printStackTrace();
					}
					if (!globalMap.containsKey("restResponse")) {
						java.util.Map<String, Object> restFault_tRESTRequest_1 = new java.util.HashMap<String, Object>();
						restFault_tRESTRequest_1.put("STATUS", 500);
						restFault_tRESTRequest_1.put("BODY", e_tRESTRequest_1.getMessage());
						globalMap.put("restResponse", restFault_tRESTRequest_1);
					}
					return;
				}
				nb_line_tRESTRequest_1++;
				globalMap.put("tRESTRequest_1_NB_LINE", nb_line_tRESTRequest_1);

				runStat.updateStatAndLog(execStat, enableLogStash, iterateId, 2, 0, "post_log");

				ok_Hash.put("tRESTRequest_1_Loop", true);
				end_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());

				/**
				 * [tRESTRequest_1_Loop end ] stop
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
				 * [tRESTRequest_1_Loop finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_1";

				s(currentComponent = "tRESTRequest_1_Loop");

				/**
				 * [tRESTRequest_1_Loop finally ] stop
				 */

				/**
				 * [tRESTRequest_1_In finally ] start
				 */

				currentVirtualComponent = "tRESTRequest_1";

				s(currentComponent = "tRESTRequest_1_In");

				/**
				 * [tRESTRequest_1_In finally ] stop
				 */

				/**
				 * [tJavaRow_1 finally ] start
				 */

				s(currentComponent = "tJavaRow_1");

				/**
				 * [tJavaRow_1 finally ] stop
				 */

			} catch (java.lang.Exception e) {
				// ignore
			} catch (java.lang.Error error) {
				// ignore
			}
			resourceMap = null;
		}

		globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 1);
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
		final Job1_ToStewardship Job1_ToStewardshipClass = new Job1_ToStewardship();

		int exitCode = Job1_ToStewardshipClass.runJobInTOS(args);
		if (exitCode == 0) {
			log.info("TalendJob: 'Job1_ToStewardship' - Done.");
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
		log.info("TalendJob: 'Job1_ToStewardship' - Start.");

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
		org.slf4j.MDC.put("_jobRepositoryId", "_w59-wFJLEfCrKtHSlgxcqg");
		org.slf4j.MDC.put("_compiledAtTimestamp", "2025-07-03T07:42:51.121734600Z");

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
			java.io.InputStream inContext = Job1_ToStewardship.class.getClassLoader()
					.getResourceAsStream("dpdp_renew/job1_tostewardship_0_1/contexts/" + contextStr + ".properties");
			if (inContext == null) {
				inContext = Job1_ToStewardship.class.getClassLoader()
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
					context.setContextType("id", "id_Integer");
					if (context.getStringValue("id") == null) {
						context.id = null;
					} else {
						try {
							context.id = routines.system.ParserUtils.parseTo_Integer(context.getProperty("id"));
						} catch (NumberFormatException e) {
							log.warn(String.format("Null value will be used for context parameter %s: %s", "id",
									e.getMessage()));
							context.id = null;
						}
					}
					context.setContextType("year", "id_Integer");
					if (context.getStringValue("year") == null) {
						context.year = null;
					} else {
						try {
							context.year = routines.system.ParserUtils.parseTo_Integer(context.getProperty("year"));
						} catch (NumberFormatException e) {
							log.warn(String.format("Null value will be used for context parameter %s: %s", "year",
									e.getMessage()));
							context.year = null;
						}
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
			if (parentContextMap.containsKey("id")) {
				context.id = (Integer) parentContextMap.get("id");
			}
			if (parentContextMap.containsKey("year")) {
				context.year = (Integer) parentContextMap.get("year");
			}
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
		log.info("TalendJob: 'Job1_ToStewardship' - Started.");
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
			tRESTRequest_1_LoopProcess(globalMap);
			if (!"failure".equals(status)) {
				status = "end";
			}
		} catch (TalendException e_tRESTRequest_1_Loop) {
			globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", -1);

			e_tRESTRequest_1_Loop.printStackTrace();

		}

		this.globalResumeTicket = true;// to run tPostJob

		end = System.currentTimeMillis();

		if (watch) {
			System.out.println((end - startTime) + " milliseconds");
		}

		endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
		if (false) {
			System.out.println(
					(endUsedMemory - startUsedMemory) + " bytes memory increase when running : Job1_ToStewardship");
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
		log.info("TalendJob: 'Job1_ToStewardship' - Finished - status: " + status + " returnCode: " + returnCode);

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
 * 270792 characters generated by Talend Real-time Big Data Platform on the 3
 * July 2025 at 1:12:51 pm IST
 ************************************************************************************************/