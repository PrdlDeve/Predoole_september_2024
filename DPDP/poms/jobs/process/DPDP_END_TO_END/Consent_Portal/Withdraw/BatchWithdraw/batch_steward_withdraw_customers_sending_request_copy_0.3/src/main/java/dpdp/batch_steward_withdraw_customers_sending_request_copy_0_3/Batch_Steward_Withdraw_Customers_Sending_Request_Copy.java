
package dpdp.batch_steward_withdraw_customers_sending_request_copy_0_3;

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

//the import part of tJava_2
//import java.util.List;


@SuppressWarnings("unused")

/**
 * Job: Batch_Steward_Withdraw_Customers_Sending_Request_Copy Purpose: <br>
 * Description:  <br>
 * @author Patil, Chirag
 * @version 8.0.1.20250521_1150-patch
 * @status 
 */
public class Batch_Steward_Withdraw_Customers_Sending_Request_Copy implements TalendJob {
	static {System.setProperty("TalendJob.log", "Batch_Steward_Withdraw_Customers_Sending_Request_Copy.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Batch_Steward_Withdraw_Customers_Sending_Request_Copy.class);
	

static {
         String javaUtilLoggingConfigFile = System.getProperty("java.util.logging.config.file");
         if (javaUtilLoggingConfigFile == null) {
             setupDefaultJavaUtilLogging();
         }
}

/**
* This class replaces the default {@code System.err} stream used by Java Util Logging (JUL).
* You can use your own configuration through the
* {@code java.util.logging.config.file} system property, enabling you to specify an external
* logging configuration file for tailored logging setup.
*/
public static class StandardConsoleHandler extends java.util.logging.StreamHandler {
     public StandardConsoleHandler() {
         // Set System.out as default log output stream
         super(System.out, new java.util.logging.SimpleFormatter());
     }

     /**
      * Publish a {@code LogRecord}.
      * The logging request was made initially to a {@code Logger} object,
      * which initialized the {@code LogRecord} and forwarded it here.
      *
      * @param  record  description of the log event. A null record is
      *                 silently ignored and is not published
      */
      @Override
      public void publish(java.util.logging.LogRecord record) {
            super.publish(record);
            flush();
      }

      /**
      * Override {@code StreamHandler.close} to do a flush but not
      * to close the output stream.  That is, we do <b>not</b>
      * close {@code System.out}.
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

	//contains type for every context property
	public class PropertiesWithType extends java.util.Properties {
		private static final long serialVersionUID = 1L;
		private java.util.Map<String,String> propertyTypes = new java.util.HashMap<>();
		
		public PropertiesWithType(java.util.Properties properties){
			super(properties);
		}
		public PropertiesWithType(){
			super();
		}
		
		public void setContextType(String key, String type) {
			propertyTypes.put(key,type);
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

		public ContextProperties(java.util.Properties properties){
			super(properties);
		}
		public ContextProperties(){
			super();
		}

		public void synchronizeContext(){
			
			if(token != null){
				
					this.setProperty("token", token.toString());
				
			}
			
			if(customerId != null){
				
					this.setProperty("customerId", customerId.toString());
				
			}
			
			if(Stewardship_Password != null){
				
					this.setProperty("Stewardship_Password", Stewardship_Password.toString());
				
			}
			
			if(Stewardship_URL != null){
				
					this.setProperty("Stewardship_URL", Stewardship_URL.toString());
				
			}
			
			if(Stewardship_UserName != null){
				
					this.setProperty("Stewardship_UserName", Stewardship_UserName.toString());
				
			}
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
				return null;
			}
			return origin_value;
		}

public String token;
public String getToken(){
	return this.token;
}
public Integer customerId;
public Integer getCustomerId(){
	return this.customerId;
}
public java.lang.String Stewardship_Password;
public java.lang.String getStewardship_Password(){
	return this.Stewardship_Password;
}
public String Stewardship_URL;
public String getStewardship_URL(){
	return this.Stewardship_URL;
}
public String Stewardship_UserName;
public String getStewardship_UserName(){
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

	private final String jobVersion = "0.3";
	private final String jobName = "Batch_Steward_Withdraw_Customers_Sending_Request_Copy";
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

	
	private String cLabel =  null;
	
		private final java.util.Map<String, Object> globalMap = new java.util.HashMap<String, Object>();
        private final static java.util.Map<String, Object> junitGlobalMap = new java.util.HashMap<String, Object>();
	
		private final java.util.Map<String, Long> start_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Long> end_Hash = new java.util.HashMap<String, Long>();
		private final java.util.Map<String, Boolean> ok_Hash = new java.util.HashMap<String, Boolean>();
		public  final java.util.List<String[]> globalBuffer = new java.util.ArrayList<String[]>();
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_ICn_8FApEfC4ZuKDeZl3GA", "0.3");
private org.talend.job.audit.JobAuditLogger auditLogger_talendJobLog = null;

private RunStat runStat = new RunStat(talendJobLog, System.getProperty("audit.interval"));

	// OSGi DataSource
	private final static String KEY_DB_DATASOURCES = "KEY_DB_DATASOURCES";
	
	private final static String KEY_DB_DATASOURCES_RAW = "KEY_DB_DATASOURCES_RAW";

	public void setDataSources(java.util.Map<String, javax.sql.DataSource> dataSources) {
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		for (java.util.Map.Entry<String, javax.sql.DataSource> dataSourceEntry : dataSources.entrySet()) {
			talendDataSources.put(dataSourceEntry.getKey(), new routines.system.TalendDataSource(dataSourceEntry.getValue()));
		}
		globalMap.put(KEY_DB_DATASOURCES, talendDataSources);
		globalMap.put(KEY_DB_DATASOURCES_RAW, new java.util.HashMap<String, javax.sql.DataSource>(dataSources));
	}
	
	public void setDataSourceReferences(List serviceReferences) throws Exception{
		
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
		java.util.Map<String, javax.sql.DataSource> dataSources = new java.util.HashMap<String, javax.sql.DataSource>();
		
		for (java.util.Map.Entry<String, javax.sql.DataSource> entry : BundleUtils.getServices(serviceReferences,  javax.sql.DataSource.class).entrySet()) {
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
	private String cLabel =  null;
	
	private String virtualComponentName = null;
	
	public void setVirtualComponentName (String virtualComponentName){
		this.virtualComponentName = virtualComponentName;
	}

	private TalendException(Exception e, String errorComponent, final java.util.Map<String, Object> globalMap) {
		this.currentComponent= errorComponent;
		this.globalMap = globalMap;
		this.e = e;
	}
	
	private TalendException(Exception e, String errorComponent, String errorComponentLabel, final java.util.Map<String, Object> globalMap) {
		this(e, errorComponent, globalMap);
		this.cLabel = errorComponentLabel;
	}

	public Exception getException() {
		return this.e;
	}

	public String getCurrentComponent() {
		return this.currentComponent;
	}

	
    public String getExceptionCauseMessage(Exception e){
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
			if(virtualComponentName!=null && currentComponent.indexOf(virtualComponentName+"_")==0){
				globalMap.put(virtualComponentName+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			}
			globalMap.put(currentComponent+"_ERROR_MESSAGE",getExceptionCauseMessage(e));
			System.err.println("Exception in component " + currentComponent + " (" + jobName + ")");
		}
		if (!(e instanceof TDieException)) {
			if(e instanceof TalendException){
				e.printStackTrace();
			} else {
				e.printStackTrace();
				e.printStackTrace(errorMessagePS);
			}
		}
		if (!(e instanceof TalendException)) {
			Batch_Steward_Withdraw_Customers_Sending_Request_Copy.this.exception = e;
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Batch_Steward_Withdraw_Customers_Sending_Request_Copy.this, new Object[] { e , currentComponent, globalMap});
					break;
				}
			}

			if(!(e instanceof TDieException)){
		if(enableLogStash) {
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

			public void tFixedFlowInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTClient_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tLogRow_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFlowToIterate_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTClient_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTClient_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_3_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTClient_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tContextLoad_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFlowToIterate_4_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDataStewardshipTaskInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFlowToIterate_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tJava_2_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tXMLMap_1_TXMLMAP_OUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tXMLMap_1_TXMLMAP_IN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tXMLMap_1_TXMLMAP_IN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_1_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tXMLMap_2_TXMLMAP_OUT_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tXMLMap_2_TXMLMAP_IN_error(exception, errorComponent, globalMap);
						
						}
					
			public void tXMLMap_2_TXMLMAP_IN_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tFixedFlowInput_3_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTRequest_1_Loop_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tRESTRequest_1_In_error(exception, errorComponent, globalMap);
						
						}
					
			public void tRESTRequest_1_In_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tFixedFlowInput_1_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRESTClient_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tFixedFlowInput_3_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void tRESTRequest_1_Loop_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}
			public void talendJobLog_onSubJobError(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {

resumeUtil.addLog("SYSTEM_LOG", "NODE:"+ errorComponent, "", Thread.currentThread().getId()+ "", "FATAL", "", exception.getMessage(), ResumeUtil.getExceptionStackTrace(exception),"");

			}



private boolean runInTalendEsbRuntimeContainer = false;

public void setRunInTalendEsbRuntimeContainer(boolean flag) {
	runInTalendEsbRuntimeContainer = flag;
}

protected String restEndpoint;

public void setRestEndpoint(String restEndpoint){
	this.restEndpoint = restEndpoint;
}

public String getRestEndpoint() {
	return "http://192.168.1.163:8050/steward";
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

	private final Batch_Steward_Withdraw_Customers_Sending_Request_Copy job;


	public RestServiceProviderImpl4TalendJob() {
		this.job = new Batch_Steward_Withdraw_Customers_Sending_Request_Copy();
	}

	public RestServiceProviderImpl4TalendJob(Batch_Steward_Withdraw_Customers_Sending_Request_Copy job) {
		this.job = job;
	}

	private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap, Batch_Steward_Withdraw_Customers_Sending_Request_Copy job) {
		// pass job DataSources
		java.util.Map<String, routines.system.TalendDataSource> talendDataSources =
			(java.util.Map<String, routines.system.TalendDataSource>) job.globalMap.get(KEY_DB_DATASOURCES);
		if (null != talendDataSources) {
			java.util.Map<String, routines.system.TalendDataSource> restDataSources = new java.util.HashMap<String, routines.system.TalendDataSource>();
			for (java.util.Map.Entry<String, routines.system.TalendDataSource> talendDataSourceEntry : talendDataSources.entrySet()) {
				restDataSources.put(talendDataSourceEntry.getKey(), new routines.system.TalendDataSource(talendDataSourceEntry.getValue().getRawDataSource()));
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
			java.util.Map<String, routines.system.TalendDataSource> restDataSources =
				(java.util.Map<String, routines.system.TalendDataSource>) requestGlobalMap.get(KEY_DB_DATASOURCES);
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
            String taskExecutionId = Batch_Steward_Withdraw_Customers_Sending_Request_Copy.taskExecutionId;
            String jobExecutionId = Batch_Steward_Withdraw_Customers_Sending_Request_Copy.jobExecutionId;

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

			jakarta.ws.rs.core.Response.ResponseBuilder responseBuilder = jakarta.ws.rs.core.Response.status(status).entity(responseBody);
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
									jakarta.ws.rs.core.NewCookie newCookie = new jakarta.ws.rs.core.NewCookie(cookieName, cookieValue);
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

	private jakarta.ws.rs.core.Response processStreamingResponseRequest(final java.util.Map<String, Object> request) {

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

	@jakarta.ws.rs.Path("/run")
	@jakarta.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
	public jakarta.ws.rs.core.Response GetSteward(
		
		
			) {
                List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();  
                if(requiredParameterWithNullValueList.size() > 0){
                    return handleWrongRequest(messageContext, 400, "400 Bad Request \n" + requiredParameterWithNullValueList.toString() + " in tRESTRequest_1:GetSteward " + (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));         
                }
		java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		request_tRESTRequest_1.put("VERB", "GET");
		request_tRESTRequest_1.put("OPERATION", "GetSteward");
		request_tRESTRequest_1.put("PATTERN", "/run");
	

		populateRequestInfo(request_tRESTRequest_1, messageContext);

		java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		
		request_tRESTRequest_1.put("PARAMS", parameters_tRESTRequest_1);


		return processRequest(request_tRESTRequest_1);
	}
	public jakarta.ws.rs.core.Response handleWrongRequest(
			org.apache.cxf.jaxrs.ext.MessageContext context, int status, String error) {

		// System.out.println("wrong call [uri: " + context.getUriInfo().getPath() + " ; method: " + context.getRequest().getMethod() + " ; status: " + status + " ; error: " + error + "]");

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

	private void populateRequestInfo(java.util.Map<String, Object> request, org.apache.cxf.jaxrs.ext.MessageContext context) {
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

	private void populateMultipartRequestInfo(java.util.Map<String, Object> request, org.apache.cxf.jaxrs.ext.MessageContext context,
			java.util.Map<String, Boolean> partNames) {
		java.util.Map<String, String> attachmentFilenames = new java.util.HashMap<String, String>();

		java.util.Map<String, java.util.Map<String, java.util.List<String>>> attachmentHeaders =
			new java.util.HashMap<String, java.util.Map<String, java.util.List<String>>>();

		for (java.util.Map.Entry<String,Boolean> p : partNames.entrySet()) {
			String partName = p.getKey();
			Boolean optional = p.getValue();
			org.apache.cxf.jaxrs.ext.multipart.Attachment attachment = getFirstMatchingPart(context, partName, optional);
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
		List<org.apache.cxf.jaxrs.ext.multipart.Attachment> attachments =
			org.apache.cxf.jaxrs.utils.multipart.AttachmentUtils.getAttachments(context);
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

public static class ExceptionMapper4TalendJobRestService extends org.apache.cxf.jaxrs.impl.WebApplicationExceptionMapper {

	@jakarta.ws.rs.core.Context private org.apache.cxf.jaxrs.ext.MessageContext messageContext;

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

		java.util.List<jakarta.ws.rs.core.MediaType> accepts = messageContext.getHttpHeaders().getAcceptableMediaTypes();
		jakarta.ws.rs.core.MediaType responseType = accepts.isEmpty() ? null : accepts.get(0);

		if (responseType == null || !responseType.getSubtype().equals("xml") && !responseType.getSubtype().equals("json")) {
			responseType = jakarta.ws.rs.core.MediaType.APPLICATION_XML_TYPE;
		}

		jakarta.ws.rs.core.Response r = jakarta.ws.rs.core.Response.status(response.getStatus()).entity(response.getEntity()).type(responseType).build();

		if(response.getHeaders()!=null){
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
				throw new IllegalArgumentException("Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
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
				throw new IllegalArgumentException("Cannot start provider with uri: " + endpointUrl + ". Port " + port + " already in use.");
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
	String address = 
			String.format("%s://%s:%s",
						(null != protocol && !protocol.isEmpty()) ? protocol : "http",
								(null != host && !host.isEmpty()) ? host : "localhost", 
										(null != port && !port.isEmpty()) ? port : "8090");
			
	if(null != servletContextPath && servletContextPath.endsWith("/")
			&& null != url && url.startsWith("/")) {
	    servletContextPath = servletContextPath.substring(0, servletContextPath.length() - 1);
	}

	return address 
			+ (null != servletContextPath ? servletContextPath : "")
			+ (null != url ? url : "");
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
				currentMessage = (org.apache.cxf.message.Message)((java.util.Map<String, Object>)globalMap.get("restRequest")).get("CURRENT_MESSAGE");
			}

			if (currentMessage != null && currentMessage.getExchange() != null && currentMessage.getExchange().containsKey(SUPRESS_XML_DECLARATION)) {
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

	private final Batch_Steward_Withdraw_Customers_Sending_Request_Copy job;

	private org.apache.cxf.endpoint.Server server;

	private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

	public Thread4RestServiceProviderEndpoint(Batch_Steward_Withdraw_Customers_Sending_Request_Copy job, String endpointUrl) {
		this.job = job;
		this.endpointUrl = endpointUrl;
		this.sf = new org.apache.cxf.jaxrs.JAXRSServerFactoryBean();
	}

	boolean inOSGi = routines.system.BundleUtils.inOSGi();

	public org.apache.cxf.endpoint.Server getServer(){
		return server;
	}

	public org.apache.cxf.jaxrs.JAXRSServerFactoryBean getJAXRSServerFactoryBean(){
		return sf;
	}

	public void run() {

		try {
			RestServiceProviderImpl4TalendJob provider = new RestServiceProviderImpl4TalendJob(job);

			if(sf.getProperties() == null){
				sf.setProperties(new java.util.HashMap<String, Object>());
			}

			java.util.List<Object> providers = (java.util.List<Object>)sf.getProviders();
			providers.add(new RequestCounterFilter());
			providers.add(new ExceptionMapper4TalendJobRestService(provider));
			providers.add(new StreamingDOM4JProvider());
			
			
			org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider =
					new org.apache.cxf.jaxrs.provider.json.JSONProvider();
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
			

			final java.util.List<org.apache.cxf.feature.Feature> features = sf.getFeatures() == null?
					new java.util.ArrayList<org.apache.cxf.feature.Feature>() : sf.getFeatures();

			

			

			

			

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
			// System.out.println("REST service [endpoint: " + endpointUrl + "] unpublished");
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
			java.io.InputStream inContext = Batch_Steward_Withdraw_Customers_Sending_Request_Copy.class.getClassLoader()
					.getResourceAsStream("dpdp/batch_steward_withdraw_customers_sending_request_copy_0_3/contexts/" + currentContext  + ".properties");
			if (inContext == null) {
				inContext = Batch_Steward_Withdraw_Customers_Sending_Request_Copy.class.getClassLoader()
						.getResourceAsStream("config/contexts/" + currentContext  + ".properties");
			}
			try {
			    defaultProps.load(inContext);
				if(jobProperties != null){
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
				contextExpression = contextExpression.replaceFirst("/services","");
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





	




public static class row2Struct implements routines.system.IPersistableRow<row2Struct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public String tableId;

				public String getTableId () {
					return this.tableId;
				}

				public Boolean tableIdIsNullable(){
				    return true;
				}
				public Boolean tableIdIsKey(){
				    return false;
				}
				public Integer tableIdLength(){
				    return null;
				}
				public Integer tableIdPrecision(){
				    return null;
				}
				public String tableIdDefault(){
				
					return null;
				
				}
				public String tableIdComment(){
				
				    return "";
				
				}
				public String tableIdPattern(){
				
				    return null;
				
				}
				public String tableIdOriginalDbColumnName(){
				
					return "tableId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
					this.tableId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
					this.tableId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tableId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tableId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tableId="+tableId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tableId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tableId);
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

public static class TableListStruct implements routines.system.IPersistableRow<TableListStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public String tableId;

				public String getTableId () {
					return this.tableId;
				}

				public Boolean tableIdIsNullable(){
				    return true;
				}
				public Boolean tableIdIsKey(){
				    return false;
				}
				public Integer tableIdLength(){
				    return null;
				}
				public Integer tableIdPrecision(){
				    return null;
				}
				public String tableIdDefault(){
				
					return null;
				
				}
				public String tableIdComment(){
				
				    return "";
				
				}
				public String tableIdPattern(){
				
				    return null;
				
				}
				public String tableIdOriginalDbColumnName(){
				
					return "tableId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
					this.tableId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
					this.tableId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tableId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tableId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tableId="+tableId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tableId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tableId);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(TableListStruct other) {

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
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public String tableId;

				public String getTableId () {
					return this.tableId;
				}

				public Boolean tableIdIsNullable(){
				    return true;
				}
				public Boolean tableIdIsKey(){
				    return false;
				}
				public Integer tableIdLength(){
				    return null;
				}
				public Integer tableIdPrecision(){
				    return null;
				}
				public String tableIdDefault(){
				
					return null;
				
				}
				public String tableIdComment(){
				
				    return "";
				
				}
				public String tableIdPattern(){
				
				    return null;
				
				}
				public String tableIdOriginalDbColumnName(){
				
					return "tableId";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
					this.tableId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
					this.tableId = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// String
				
						writeString(this.tableId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.tableId,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("tableId="+tableId);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(tableId == null){
        					sb.append("<null>");
        				}else{
            				sb.append(tableId);
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

public static class sendPIIStruct implements routines.system.IPersistableRow<sendPIIStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public Integer statusCode;

				public Integer getStatusCode () {
					return this.statusCode;
				}

				public Boolean statusCodeIsNullable(){
				    return true;
				}
				public Boolean statusCodeIsKey(){
				    return false;
				}
				public Integer statusCodeLength(){
				    return 0;
				}
				public Integer statusCodePrecision(){
				    return 0;
				}
				public String statusCodeDefault(){
				
					return "";
				
				}
				public String statusCodeComment(){
				
				    return null;
				
				}
				public String statusCodePattern(){
				
				    return null;
				
				}
				public String statusCodeOriginalDbColumnName(){
				
					return "statusCode";
				
				}

				
			    public routines.system.Document body;

				public routines.system.Document getBody () {
					return this.body;
				}

				public Boolean bodyIsNullable(){
				    return true;
				}
				public Boolean bodyIsKey(){
				    return false;
				}
				public Integer bodyLength(){
				    return 0;
				}
				public Integer bodyPrecision(){
				    return 0;
				}
				public String bodyDefault(){
				
					return "";
				
				}
				public String bodyComment(){
				
				    return null;
				
				}
				public String bodyPattern(){
				
				    return null;
				
				}
				public String bodyOriginalDbColumnName(){
				
					return "body";
				
				}

				
			    public String string;

				public String getString () {
					return this.string;
				}

				public Boolean stringIsNullable(){
				    return true;
				}
				public Boolean stringIsKey(){
				    return false;
				}
				public Integer stringLength(){
				    return 4048;
				}
				public Integer stringPrecision(){
				    return 0;
				}
				public String stringDefault(){
				
					return null;
				
				}
				public String stringComment(){
				
				    return null;
				
				}
				public String stringPattern(){
				
				    return null;
				
				}
				public String stringOriginalDbColumnName(){
				
					return "string";
				
				}

				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
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
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
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

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.statusCode = readInteger(dis);
					
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.statusCode = readInteger(dis);
					
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.statusCode,dos);
					
					// Document
				
       			    	dos.writeObject(this.body);
					
					// String
				
						writeString(this.string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.statusCode,dos);
					
					// Document
				
						dos.clearInstanceCache();
						dos.writeObject(this.body);
					
					// String
				
						writeString(this.string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("statusCode="+String.valueOf(statusCode));
		sb.append(",body="+String.valueOf(body));
		sb.append(",string="+string);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(statusCode == null){
        					sb.append("<null>");
        				}else{
            				sb.append(statusCode);
            			}
            		
        			sb.append("|");
        		
        				if(body == null){
        					sb.append("<null>");
        				}else{
            				sb.append(body);
            			}
            		
        			sb.append("|");
        		
        				if(string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(string);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(sendPIIStruct other) {

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

public static class sendQueryStruct implements routines.system.IPersistableRow<sendQueryStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public routines.system.Document body;

				public routines.system.Document getBody () {
					return this.body;
				}

				public Boolean bodyIsNullable(){
				    return true;
				}
				public Boolean bodyIsKey(){
				    return false;
				}
				public Integer bodyLength(){
				    return 0;
				}
				public Integer bodyPrecision(){
				    return 0;
				}
				public String bodyDefault(){
				
					return "";
				
				}
				public String bodyComment(){
				
				    return null;
				
				}
				public String bodyPattern(){
				
				    return null;
				
				}
				public String bodyOriginalDbColumnName(){
				
					return "body";
				
				}

				
			    public String string;

				public String getString () {
					return this.string;
				}

				public Boolean stringIsNullable(){
				    return true;
				}
				public Boolean stringIsKey(){
				    return false;
				}
				public Integer stringLength(){
				    return 4048;
				}
				public Integer stringPrecision(){
				    return 0;
				}
				public String stringDefault(){
				
					return null;
				
				}
				public String stringComment(){
				
				    return null;
				
				}
				public String stringPattern(){
				
				    return null;
				
				}
				public String stringOriginalDbColumnName(){
				
					return "string";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Document
				
       			    	dos.writeObject(this.body);
					
					// String
				
						writeString(this.string,dos);
					
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
				
						writeString(this.string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("body="+String.valueOf(body));
		sb.append(",string="+string);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(body == null){
        					sb.append("<null>");
        				}else{
            				sb.append(body);
            			}
            		
        			sb.append("|");
        		
        				if(string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(string);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(sendQueryStruct other) {

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

		mdc("tFixedFlowInput_1", "Gjy9ki_");

		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		sendQueryStruct sendQuery = new sendQueryStruct();
sendPIIStruct sendPII = new sendPIIStruct();
TableListStruct TableList = new TableListStruct();
TableListStruct row2 = TableList;





	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT begin ] start
	 */

	

	
		
		sh("tXMLMap_1_TXMLMAP_OUT");
		
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_OUT";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"sendPII");
					}
				
		int tos_count_tXMLMap_1_TXMLMAP_OUT = 0;
		
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_OUT - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tXMLMap_1_TXMLMAP_OUT{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_OUT = new StringBuilder();
                    log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("Parameters:");
                            log4jParamters_tXMLMap_1_TXMLMAP_OUT.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
                        log4jParamters_tXMLMap_1_TXMLMAP_OUT.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_OUT - "  + (log4jParamters_tXMLMap_1_TXMLMAP_OUT) );
                    } 
                } 
            new BytesLimit65535_tXMLMap_1_TXMLMAP_OUT().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tXMLMap_1_TXMLMAP_OUT", "ParsePIIResponse_TXMLMAP_OUT", "tXMLMapOut");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	
	
//===============================input xml init part===============================
class XML_API_tXMLMap_1_TXMLMAP_OUT{
	public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        if (node != null && node instanceof org.dom4j.Element) {
        	org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute("nil");
        	if(attri != null && ("true").equals(attri.getText())){
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
TableListStruct TableList_tmp = new TableListStruct();
TableListStruct TableList_save = null;
//the aggregate variable
TableListStruct TableList_aggregate = null;
int count_TableList_tXMLMap_1_TXMLMAP_OUT = 0;
//init the resultset for aggregate
java.util.List<Object> allOutsForAggregate_tXMLMap_1 = new java.util.ArrayList<Object>();
globalMap.put("allOutsForAggregate_tXMLMap_1",allOutsForAggregate_tXMLMap_1);
// ###############################
class TreeNode_API_tXMLMap_1_TXMLMAP_OUT {
	java.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();
	
	void clear(){
		xpath_value_map.clear();
	}
	
	void put(String xpath, String value){
		xpath_value_map.put(xpath, value);
	}
	String get_null(String xpath) {
		return null;
	}
	String get_String(String xpath){
		return xpath_value_map.get(xpath);
	}
}
			TreeNode_API_tXMLMap_1_TXMLMAP_OUT treeNodeAPI_tXMLMap_1_TXMLMAP_OUT = new TreeNode_API_tXMLMap_1_TXMLMAP_OUT();
			NameSpaceTool nsTool_tXMLMap_1_TXMLMAP_OUT = new NameSpaceTool();
		int nb_line_tXMLMap_1_TXMLMAP_OUT = 0; 
	
    XML_API_tXMLMap_1_TXMLMAP_OUT xml_api_tXMLMap_1_TXMLMAP_OUT = new XML_API_tXMLMap_1_TXMLMAP_OUT();

	//the map store the previous value of aggregate columns
	java.util.Map<String,Object> aggregateCacheMap_tXMLMap_1_TXMLMAP_OUT = new java.util.HashMap<String,Object>();

	            

 



		

/**
 * [tXMLMap_1_TXMLMAP_OUT begin ] stop
 */




	
	/**
	 * [tRESTClient_1 begin ] start
	 */

	

	
		
		sh("tRESTClient_1");
		
	
	s(currentComponent="tRESTClient_1");
	
			
			
	
			cLabel="ExtractPIIList";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"sendQuery");
					}
				
		int tos_count_tRESTClient_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTClient_1", "ExtractPIIList", "tRESTClient");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

 



		

/**
 * [tRESTClient_1 begin ] stop
 */




	
	/**
	 * [tFixedFlowInput_1 begin ] start
	 */

	

	
		
		sh("tFixedFlowInput_1");
		
	
	s(currentComponent="tFixedFlowInput_1");
	
			
			
	
			cLabel="DefinePIIQuery";
		
		int tos_count_tFixedFlowInput_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tFixedFlowInput_1", "DefinePIIQuery", "tFixedFlowInput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	    for (int i_tFixedFlowInput_1 = 0 ; i_tFixedFlowInput_1 < 1 ; i_tFixedFlowInput_1++) {
	                	            	
    	            		sendQuery.body = null;        	            	
    	            	        	            	
    	            		sendQuery.string = "{\"select\": \"\\\"Object Stable Id\\\", \\\"Object Id\\\"\", \"from\": \"/Template/DPDP_Testing/DPDP_Test/2025-06-03 09:44:59\", \"where\": \"category = 'Database.Tables' AND Collections = 'Customers_tables'\", \"orderby\": \"Relevance\", \"pageSize\": 50, \"pageNumber\": 1}";
    	            	

 



		

/**
 * [tFixedFlowInput_1 begin ] stop
 */

	
	/**
	 * [tFixedFlowInput_1 main ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_1");
	
			
			
	
			cLabel="DefinePIIQuery";
		

 


	tos_count_tFixedFlowInput_1++;

		

/**
 * [tFixedFlowInput_1 main ] stop
 */

	
	/**
	 * [tFixedFlowInput_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_1");
	
			
			
	
			cLabel="DefinePIIQuery";
		

 



		

/**
 * [tFixedFlowInput_1 process_data_begin ] stop
 */


	
	/**
	 * [tRESTClient_1 main ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_1");
	
			
			
	
			cLabel="ExtractPIIList";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"sendQuery","tFixedFlowInput_1","DefinePIIQuery","tFixedFlowInput","tRESTClient_1","ExtractPIIList","tRESTClient"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("sendQuery - " + (sendQuery==null? "": sendQuery.toLogString()));
    			}
    		
	sendPII = null;

// expected response body
jakarta.ws.rs.core.Response responseDoc_tRESTClient_1 = null;

try {
	// request body
	org.dom4j.Document requestDoc_tRESTClient_1 = null;
	String requestString_tRESTClient_1 = null;
			if (null != sendQuery.body) {
				requestDoc_tRESTClient_1 = sendQuery.body.getDocument();
			}
			requestString_tRESTClient_1 = sendQuery.string;

	Object requestBody_tRESTClient_1 = requestDoc_tRESTClient_1 != null ? requestDoc_tRESTClient_1 : requestString_tRESTClient_1;

	

    //resposne class name
	Class<?> responseClass_tRESTClient_1
		= org.dom4j.Document.class;

	// create web client instance
	org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_1 =
			new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

	boolean inOSGi = routines.system.BundleUtils.inOSGi();

	final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_1 =
			new java.util.ArrayList<org.apache.cxf.feature.Feature>();

	String url = null;
	
		url = "http://192.168.1.253:11480/MM/rest/v1/entities/executeMQLQuery?context=-1_6645";
		// {baseUri}tRESTClient
		factoryBean_tRESTClient_1.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
		factoryBean_tRESTClient_1.setAddress(url);
	

	

    boolean log_messages_tRESTClient_1 = Boolean.valueOf(false);
	if (log_messages_tRESTClient_1) {
		org.apache.cxf.ext.logging.LoggingFeature loggingFeature = new  org.apache.cxf.ext.logging.LoggingFeature();
		loggingFeature.addSensitiveProtocolHeaderNames(new java.util.HashSet<>(java.util.Arrays.asList(org.apache.cxf.helpers.HttpHeaderHelper.AUTHORIZATION)));
		loggingFeature.addSensitiveElementNames(new java.util.HashSet<>(java.util.Arrays.asList("password")));
		features_tRESTClient_1.add(loggingFeature);
	}

	

	factoryBean_tRESTClient_1.setFeatures(features_tRESTClient_1);


	java.util.List<Object> providers_tRESTClient_1 = new java.util.ArrayList<Object>();
	providers_tRESTClient_1.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
		// workaround for https://jira.talendforge.org/browse/TESB-7276
		public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls,
											java.lang.reflect.Type type,
											java.lang.annotation.Annotation[] anns,
											jakarta.ws.rs.core.MediaType mt,
											jakarta.ws.rs.core.MultivaluedMap<String, String> headers,
											java.io.InputStream is)
				throws IOException, jakarta.ws.rs.WebApplicationException {
			String contentLength = headers.getFirst("Content-Length");
			if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)
					&& Integer.valueOf(contentLength) <= 0) {
				try {
					return org.dom4j.DocumentHelper.parseText("<root/>");
				} catch (org.dom4j.DocumentException e_tRESTClient_1) {
					e_tRESTClient_1.printStackTrace();
				}
				return null;
			}
			return super.readFrom(cls, type, anns, mt, headers, is);
		}
	});
	org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_1 =
			new org.apache.cxf.jaxrs.provider.json.JSONProvider();
		jsonProvider_tRESTClient_1.setIgnoreNamespaces(true);
		jsonProvider_tRESTClient_1.setAttributesToElements(true);
	
		jsonProvider_tRESTClient_1.setSerializeAsArray(true);
		List<String> arrayKeys = new java.util.ArrayList<String>(java.util.Arrays.asList("".split(" ")));
		jsonProvider_tRESTClient_1.setArrayKeys(arrayKeys);
	
	
	
		jsonProvider_tRESTClient_1.setSupportUnwrapped(true);
		jsonProvider_tRESTClient_1.setWrapperName("root");
	
	
		jsonProvider_tRESTClient_1.setDropRootElement(false);
		jsonProvider_tRESTClient_1.setConvertTypesToStrings(false);
	providers_tRESTClient_1.add(jsonProvider_tRESTClient_1);
	factoryBean_tRESTClient_1.setProviders(providers_tRESTClient_1);
	factoryBean_tRESTClient_1.setTransportId("http://cxf.apache.org/transports/http");

	boolean use_auth_tRESTClient_1 = false;

	

	org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_1 = null;
	
		webClient_tRESTClient_1 = factoryBean_tRESTClient_1.createWebClient();
		// set request path
		webClient_tRESTClient_1.path("");
	

	// set connection properties
	org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_1 = org.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_tRESTClient_1);
	org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
	org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_1 = null;

	
		conduit_tRESTClient_1 = clientConfig_tRESTClient_1.getHttpConduit();
	
	
    if (clientConfig_tRESTClient_1.getEndpoint() != null) {
		org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_1 = clientConfig_tRESTClient_1.getEndpoint().getEndpointInfo();
		if(endpointInfo_tRESTClient_1 != null) {
			endpointInfo_tRESTClient_1.setProperty("enable.webclient.operation.reporting", true);
		}
    }

	

	

	if (!inOSGi) {
		conduit_tRESTClient_1.getClient().setReceiveTimeout((long)(60 * 1000L));
		conduit_tRESTClient_1.getClient().setConnectionTimeout((long)(30 * 1000L));
	}
	
	
	
		

	

	
		// set Content-Type
		webClient_tRESTClient_1.type("application/json");
	

	
		// set Accept-Type
		webClient_tRESTClient_1.accept("application/json");
	

	
		// set optional query and header properties if any
	
		webClient_tRESTClient_1.header("api_key", context.token);
	
	if (use_auth_tRESTClient_1 && "OAUTH2_BEARER".equals("OAUTH2_BEARER")) {
		// set oAuth2 bearer token
		org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
		authSupplier.setAccessToken((String) context.token);
		conduit_tRESTClient_1.setAuthSupplier(authSupplier);
	}

	

	// if FORM request then capture query parameters into Form, otherwise set them as queries
	
		
		
	


	try {
		// start send request
		
			
				responseDoc_tRESTClient_1 = webClient_tRESTClient_1.post(requestBody_tRESTClient_1);
			
		


		int webClientResponseStatus_tRESTClient_1 = webClient_tRESTClient_1.getResponse().getStatus();
		if (webClientResponseStatus_tRESTClient_1 >= 300) {
			throw new jakarta.ws.rs.WebApplicationException(webClient_tRESTClient_1.getResponse());
		}

		
			if (sendPII == null) {
				sendPII = new sendPIIStruct();
			}

			sendPII.statusCode = webClientResponseStatus_tRESTClient_1;
			sendPII.string = "";
			
				
				Object responseObj_tRESTClient_1 = null;
				if(responseDoc_tRESTClient_1 != null && responseDoc_tRESTClient_1.hasEntity()){
					responseObj_tRESTClient_1 = responseDoc_tRESTClient_1.readEntity(responseClass_tRESTClient_1);
				
				if(responseObj_tRESTClient_1 != null){
					if (responseClass_tRESTClient_1 == String.class && responseObj_tRESTClient_1 instanceof String) {
							sendPII.string = (String) responseObj_tRESTClient_1;
					} else {
						routines.system.Document responseTalendDoc_tRESTClient_1 = null;
						if (null != responseObj_tRESTClient_1) {
							responseTalendDoc_tRESTClient_1 = new routines.system.Document();
							if (responseObj_tRESTClient_1 instanceof org.dom4j.Document) {
								responseTalendDoc_tRESTClient_1.setDocument((org.dom4j.Document) responseObj_tRESTClient_1);
							}
						}
						sendPII.body = responseTalendDoc_tRESTClient_1;
					}
				}
			}
			

			java.util.Map<String, jakarta.ws.rs.core.NewCookie> cookies_tRESTClient_1 = new java.util.HashMap<String, jakarta.ws.rs.core.NewCookie>();

			if (webClient_tRESTClient_1.getResponse() != null && webClient_tRESTClient_1.getResponse().getCookies() != null ) { 
				cookies_tRESTClient_1.putAll(webClient_tRESTClient_1.getResponse().getCookies());
			}

			


			globalMap.put("tRESTClient_1_HEADERS", webClient_tRESTClient_1.getResponse().getHeaders());
			globalMap.put("tRESTClient_1_COOKIES", cookies_tRESTClient_1);
			
		

	} catch (jakarta.ws.rs.WebApplicationException ex_tRESTClient_1) {
	    globalMap.put("tRESTClient_1_ERROR_MESSAGE",ex_tRESTClient_1.getMessage());
		
			throw ex_tRESTClient_1;
		
	}

} catch(Exception e_tRESTClient_1) {
    globalMap.put("tRESTClient_1_ERROR_MESSAGE",e_tRESTClient_1.getMessage());
	
		throw new TalendException(e_tRESTClient_1, currentComponent, globalMap);
	
}


 


	tos_count_tRESTClient_1++;

		

/**
 * [tRESTClient_1 main ] stop
 */

	
	/**
	 * [tRESTClient_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_1");
	
			
			
	
			cLabel="ExtractPIIList";
		

 



		

/**
 * [tRESTClient_1 process_data_begin ] stop
 */

// Start of branch "sendPII"
if(sendPII != null) { 



	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_OUT";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"sendPII","tRESTClient_1","ExtractPIIList","tRESTClient","tXMLMap_1_TXMLMAP_OUT","ParsePIIResponse_TXMLMAP_OUT","tXMLMapOut"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("sendPII - " + (sendPII==null? "": sendPII.toLogString()));
    			}
    		

	boolean rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
	boolean rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
	boolean mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
	boolean isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;
	  
	
			

		
		
				//init document to flat tool
				routines.system.DocumentToFlat docToFlat_tXMLMap_1_TXMLMAP_OUT = new routines.system.DocumentToFlat();
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setOriginalLoop("/root/result");
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setIsOptional(false);
				if(sendPII.body == null || sendPII.body.getDocument() == null) {
					throw new RuntimeException("sendPII.body can't be empty");
				}
				org.dom4j.Document doc_tXMLMap_1_TXMLMAP_OUT = sendPII.body.getDocument();
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setDoc(doc_tXMLMap_1_TXMLMAP_OUT);
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setDefineNS(false);
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setNamespaceTool(nsTool_tXMLMap_1_TXMLMAP_OUT);
				
					//old version, find NS from doc
					nsTool_tXMLMap_1_TXMLMAP_OUT.countNSMap(doc_tXMLMap_1_TXMLMAP_OUT.getRootElement());
					java.util.HashMap<String,String> xmlNameSpaceMap_tXMLMap_1_TXMLMAP_OUT = nsTool_tXMLMap_1_TXMLMAP_OUT.xmlNameSpaceMap;
				
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setXmlNameSpaceMap(xmlNameSpaceMap_tXMLMap_1_TXMLMAP_OUT);
				
				String[] absolutePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[1];
				String[] relativePathMappings_tXMLMap_1_TXMLMAP_OUT = new String[1];
				
				absolutePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "sendPII.body:/root/result/attributes/value";
				relativePathMappings_tXMLMap_1_TXMLMAP_OUT[0] = "attributes/value";
				
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setAbsolutePathMappings(absolutePathMappings_tXMLMap_1_TXMLMAP_OUT);
				docToFlat_tXMLMap_1_TXMLMAP_OUT.setCurrentRelativePathMappings(relativePathMappings_tXMLMap_1_TXMLMAP_OUT);
				//generate document to flat data
				docToFlat_tXMLMap_1_TXMLMAP_OUT.flat();
				//get flat data
				java.util.List<java.util.Map<String, String>> resultSet_tXMLMap_1_TXMLMAP_OUT = docToFlat_tXMLMap_1_TXMLMAP_OUT.getResultSet();
				
				for (java.util.Map<String,String> oneRow_tXMLMap_1_TXMLMAP_OUT: resultSet_tXMLMap_1_TXMLMAP_OUT) { // G_TXM_M_001
					nb_line_tXMLMap_1_TXMLMAP_OUT++;
			    	rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
			    	rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
					mainRowRejected_tXMLMap_1_TXMLMAP_OUT=false;
				    isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;
					
			    	treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.clear();
			    	for(java.util.Map.Entry<String, String> entry_tXMLMap_1_TXMLMAP_OUT : oneRow_tXMLMap_1_TXMLMAP_OUT.entrySet()) {
						treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.put(entry_tXMLMap_1_TXMLMAP_OUT.getKey(),entry_tXMLMap_1_TXMLMAP_OUT.getValue());
					}
					


			
{ // start of Var scope

	// ###############################
	// # Vars tables

Var__tXMLMap_1_TXMLMAP_OUT__Struct Var = Var__tXMLMap_1_TXMLMAP_OUT;
		// ###############################
		// # Output tables

TableList = null;


// # Output table : 'TableList'
count_TableList_tXMLMap_1_TXMLMAP_OUT++;


TableList_tmp = new TableListStruct();
TableList_tmp.tableId = treeNodeAPI_tXMLMap_1_TXMLMAP_OUT.get_String("sendPII.body:/root/result/attributes/value");allOutsForAggregate_tXMLMap_1.add(TableList_tmp);

log.debug("tXMLMap_1 - Outputting the record " + count_TableList_tXMLMap_1_TXMLMAP_OUT + " of the output table 'TableList'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;


		}//G_TXM_M_001 close
	

 


	tos_count_tXMLMap_1_TXMLMAP_OUT++;

		

/**
 * [tXMLMap_1_TXMLMAP_OUT main ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_OUT";
		

 



		

/**
 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_OUT";
		

 



		

/**
 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] stop
 */


} // End of branch "sendPII"




	
	/**
	 * [tRESTClient_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_1");
	
			
			
	
			cLabel="ExtractPIIList";
		

 



		

/**
 * [tRESTClient_1 process_data_end ] stop
 */




	
	/**
	 * [tFixedFlowInput_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_1");
	
			
			
	
			cLabel="DefinePIIQuery";
		

 



		

/**
 * [tFixedFlowInput_1 process_data_end ] stop
 */

	
	/**
	 * [tFixedFlowInput_1 end ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_1");
	
			
			
	
			cLabel="DefinePIIQuery";
		

        }
        globalMap.put("tFixedFlowInput_1_NB_LINE", 1);        

 

ok_Hash.put("tFixedFlowInput_1", true);
end_Hash.put("tFixedFlowInput_1", System.currentTimeMillis());




		

/**
 * [tFixedFlowInput_1 end ] stop
 */


	
	/**
	 * [tRESTClient_1 end ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_1");
	
			
			
	
			cLabel="ExtractPIIList";
		


if (globalMap.get("tRESTClient_1_NB_LINE") == null) {
	globalMap.put("tRESTClient_1_NB_LINE", 1);
}

// [tRESTCliend_end]
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"sendQuery",2,0,
				 			"tFixedFlowInput_1","DefinePIIQuery","tFixedFlowInput","tRESTClient_1","ExtractPIIList","tRESTClient","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tRESTClient_1", true);
end_Hash.put("tRESTClient_1", System.currentTimeMillis());




		

/**
 * [tRESTClient_1 end ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_OUT";
		
		log.debug("tXMLMap_1 - Written records count in the table 'TableList': " + count_TableList_tXMLMap_1_TXMLMAP_OUT + ".");



				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"sendPII",2,0,
				 			"tRESTClient_1","ExtractPIIList","tRESTClient","tXMLMap_1_TXMLMAP_OUT","ParsePIIResponse_TXMLMAP_OUT","tXMLMapOut","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_OUT - "  + ("Done.") );

ok_Hash.put("tXMLMap_1_TXMLMAP_OUT", true);
end_Hash.put("tXMLMap_1_TXMLMAP_OUT", System.currentTimeMillis());




		

/**
 * [tXMLMap_1_TXMLMAP_OUT end ] stop
 */




	
	/**
	 * [tFlowToIterate_1 begin ] start
	 */

				
			int NB_ITERATE_tJava_1 = 0; //for statistics
			

	
		
		sh("tFlowToIterate_1");
		
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
			cLabel="FlowToIterate";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"row2");
					}
				
		int tos_count_tFlowToIterate_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFlowToIterate_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFlowToIterate_1 = new StringBuilder();
                    log4jParamters_tFlowToIterate_1.append("Parameters:");
                            log4jParamters_tFlowToIterate_1.append("DEFAULT_MAP" + " = " + "true");
                        log4jParamters_tFlowToIterate_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + (log4jParamters_tFlowToIterate_1) );
                    } 
                } 
            new BytesLimit65535_tFlowToIterate_1().limitLog4jByte();
            }
			if(enableLogStash) {
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
	 * [tLogRow_1 begin ] start
	 */

	

	
		
		sh("tLogRow_1");
		
	
	s(currentComponent="tLogRow_1");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"TableList");
					}
				
		int tos_count_tLogRow_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tLogRow_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tLogRow_1 = new StringBuilder();
                    log4jParamters_tLogRow_1.append("Parameters:");
                            log4jParamters_tLogRow_1.append("BASIC_MODE" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("TABLE_PRINT" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("VERTICAL" + " = " + "false");
                        log4jParamters_tLogRow_1.append(" | ");
                            log4jParamters_tLogRow_1.append("PRINT_CONTENT_WITH_LOG4J" + " = " + "true");
                        log4jParamters_tLogRow_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + (log4jParamters_tLogRow_1) );
                    } 
                } 
            new BytesLimit65535_tLogRow_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tLogRow_1", "tLogRow_1", "tLogRow");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	///////////////////////
	
         class Util_tLogRow_1 {

        String[] des_top = { ".", ".", "-", "+" };

        String[] des_head = { "|=", "=|", "-", "+" };

        String[] des_bottom = { "'", "'", "-", "+" };

        String name="";

        java.util.List<String[]> list = new java.util.ArrayList<String[]>();

        int[] colLengths = new int[1];

        public void addRow(String[] row) {

            for (int i = 0; i < 1; i++) {
                if (row[i]!=null) {
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
       
                        formatter.format(sbformat.toString(), (Object[])row);	
                                
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
                //first column
                sb.append(fillChars[0]);	                

                  
                    //last column
                    for (int i = 0; i < colLengths[0] - fillChars[0].length() - fillChars[1].length()+2; i++) {
                        sb.append(fillChars[2]);
                    }         
                sb.append(fillChars[1]);
                sb.append("\n");               
                return sb;
            }
            
            public boolean isTableEmpty(){
            	if (list.size() > 1)
            		return false;
            	return true;
            }
        }
        Util_tLogRow_1 util_tLogRow_1 = new Util_tLogRow_1();
        util_tLogRow_1.setTableName("tLogRow_1");
        util_tLogRow_1.addRow(new String[]{"tableId",});        
 		StringBuilder strBuffer_tLogRow_1 = null;
		int nb_line_tLogRow_1 = 0;
///////////////////////    			



 



		

/**
 * [tLogRow_1 begin ] stop
 */




	
	/**
	 * [tXMLMap_1_TXMLMAP_IN begin ] start
	 */

	

	
		
		sh("tXMLMap_1_TXMLMAP_IN");
		
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_IN";
		
		int tos_count_tXMLMap_1_TXMLMAP_IN = 0;
		
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tXMLMap_1_TXMLMAP_IN{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tXMLMap_1_TXMLMAP_IN = new StringBuilder();
                    log4jParamters_tXMLMap_1_TXMLMAP_IN.append("Parameters:");
                            log4jParamters_tXMLMap_1_TXMLMAP_IN.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
                        log4jParamters_tXMLMap_1_TXMLMAP_IN.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + (log4jParamters_tXMLMap_1_TXMLMAP_IN) );
                    } 
                } 
            new BytesLimit65535_tXMLMap_1_TXMLMAP_IN().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tXMLMap_1_TXMLMAP_IN", "ParsePIIResponse_TXMLMAP_IN", "tXMLMapIn");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
java.util.List<Object> outs_tXMLMap_1 = (java.util.List<Object>)globalMap.get("allOutsForAggregate_tXMLMap_1");
for(Object  row_out_tXMLMap_1_TXMLMAP_IN : outs_tXMLMap_1) {//TD512
 



		

/**
 * [tXMLMap_1_TXMLMAP_IN begin ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_IN main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_IN";
		

	TableList = null;
	if(row_out_tXMLMap_1_TXMLMAP_IN!=null && row_out_tXMLMap_1_TXMLMAP_IN instanceof TableListStruct) {
		TableList = (TableListStruct)row_out_tXMLMap_1_TXMLMAP_IN;		
	}
 


	tos_count_tXMLMap_1_TXMLMAP_IN++;

		

/**
 * [tXMLMap_1_TXMLMAP_IN main ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_IN";
		

 



		

/**
 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] stop
 */

// Start of branch "TableList"
if(TableList != null) { 



	
	/**
	 * [tLogRow_1 main ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"TableList","tXMLMap_1_TXMLMAP_IN","ParsePIIResponse_TXMLMAP_IN","tXMLMapIn","tLogRow_1","tLogRow_1","tLogRow"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("TableList - " + (TableList==null? "": TableList.toLogString()));
    			}
    		
///////////////////////		
						

				
				String[] row_tLogRow_1 = new String[1];
   				
	    		if(TableList.tableId != null) { //              
                 row_tLogRow_1[0]=    						    
				                String.valueOf(TableList.tableId)			
					          ;	
							
	    		} //			
    			 

				util_tLogRow_1.addRow(row_tLogRow_1);	
				nb_line_tLogRow_1++;
                	log.info("tLogRow_1 - Content of row "+nb_line_tLogRow_1+": " + TalendString.unionString("|",row_tLogRow_1));
//////

//////                    
                    
///////////////////////    			

 
     row2 = TableList;


	tos_count_tLogRow_1++;

		

/**
 * [tLogRow_1 main ] stop
 */

	
	/**
	 * [tLogRow_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	

 



		

/**
 * [tLogRow_1 process_data_begin ] stop
 */


	
	/**
	 * [tFlowToIterate_1 main ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
			cLabel="FlowToIterate";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"row2","tLogRow_1","tLogRow_1","tLogRow","tFlowToIterate_1","FlowToIterate","tFlowToIterate"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row2 - " + (row2==null? "": row2.toLogString()));
    			}
    		


    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_1 - "  + ("Set global var, key=row2.tableId, value=")  + (row2.tableId)  + (".") );            
            globalMap.put("row2.tableId", row2.tableId);
    	
 
	   nb_line_tFlowToIterate_1++;  
       counter_tFlowToIterate_1++;
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Current iteration is: ")  + (counter_tFlowToIterate_1)  + (".") );
       globalMap.put("tFlowToIterate_1_CURRENT_ITERATION", counter_tFlowToIterate_1);
 


	tos_count_tFlowToIterate_1++;

		

/**
 * [tFlowToIterate_1 main ] stop
 */

	
	/**
	 * [tFlowToIterate_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
			cLabel="FlowToIterate";
		

 



		

/**
 * [tFlowToIterate_1 process_data_begin ] stop
 */

	NB_ITERATE_tJava_1++;
	
	

	
	/**
	 * [tJava_1 begin ] start
	 */

	

	
		
		sh("tJava_1");
		
	
	s(currentComponent="tJava_1");
	
			
			
	
			cLabel="JavaFiller";
		
		int tos_count_tJava_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tJava_1", "JavaFiller", "tJava");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			



 



		

/**
 * [tJava_1 begin ] stop
 */

	
	/**
	 * [tJava_1 main ] start
	 */

	

	
	
	s(currentComponent="tJava_1");
	
			
			
	
			cLabel="JavaFiller";
		

 


	tos_count_tJava_1++;

		

/**
 * [tJava_1 main ] stop
 */

	
	/**
	 * [tJava_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tJava_1");
	
			
			
	
			cLabel="JavaFiller";
		

 



		

/**
 * [tJava_1 process_data_begin ] stop
 */

	
	/**
	 * [tJava_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tJava_1");
	
			
			
	
			cLabel="JavaFiller";
		

 



		

/**
 * [tJava_1 process_data_end ] stop
 */

	
	/**
	 * [tJava_1 end ] start
	 */

	

	
	
	s(currentComponent="tJava_1");
	
			
			
	
			cLabel="JavaFiller";
		

 

ok_Hash.put("tJava_1", true);
end_Hash.put("tJava_1", System.currentTimeMillis());

				tRESTClient_3Process(globalMap);



		

/**
 * [tJava_1 end ] stop
 */





	
	/**
	 * [tFlowToIterate_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
			cLabel="FlowToIterate";
		

 



		

/**
 * [tFlowToIterate_1 process_data_end ] stop
 */




	
	/**
	 * [tLogRow_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	

 



		

/**
 * [tLogRow_1 process_data_end ] stop
 */


} // End of branch "TableList"




	
	/**
	 * [tXMLMap_1_TXMLMAP_IN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_IN";
		

 



		

/**
 * [tXMLMap_1_TXMLMAP_IN process_data_end ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_IN end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_IN";
		

}//TD512
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + ("Done.") );

ok_Hash.put("tXMLMap_1_TXMLMAP_IN", true);
end_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());




		

/**
 * [tXMLMap_1_TXMLMAP_IN end ] stop
 */


	
	/**
	 * [tLogRow_1 end ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	


//////

                    
                    java.io.PrintStream consoleOut_tLogRow_1 = null;
                    if (globalMap.get("tLogRow_CONSOLE")!=null)
                    {
                    	consoleOut_tLogRow_1 = (java.io.PrintStream) globalMap.get("tLogRow_CONSOLE");
                    }
                    else
                    {
                    	consoleOut_tLogRow_1 = new java.io.PrintStream(new java.io.BufferedOutputStream(System.out));
                    	globalMap.put("tLogRow_CONSOLE",consoleOut_tLogRow_1);
                    }
                    
                    consoleOut_tLogRow_1.println(util_tLogRow_1.format().toString());
                    consoleOut_tLogRow_1.flush();
//////
globalMap.put("tLogRow_1_NB_LINE",nb_line_tLogRow_1);
                if(log.isInfoEnabled())
            log.info("tLogRow_1 - "  + ("Printed row count: ")  + (nb_line_tLogRow_1)  + (".") );

///////////////////////    			

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"TableList",2,0,
				 			"tXMLMap_1_TXMLMAP_IN","ParsePIIResponse_TXMLMAP_IN","tXMLMapIn","tLogRow_1","tLogRow_1","tLogRow","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tLogRow_1 - "  + ("Done.") );

ok_Hash.put("tLogRow_1", true);
end_Hash.put("tLogRow_1", System.currentTimeMillis());




		

/**
 * [tLogRow_1 end ] stop
 */


	
	/**
	 * [tFlowToIterate_1 end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
			cLabel="FlowToIterate";
		

globalMap.put("tFlowToIterate_1_NB_LINE",nb_line_tFlowToIterate_1);
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row2",2,0,
				 			"tLogRow_1","tLogRow_1","tLogRow","tFlowToIterate_1","FlowToIterate","tFlowToIterate","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_1", true);
end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());




		

/**
 * [tFlowToIterate_1 end ] stop
 */
















				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
							//free memory for "tXMLMap_1_TXMLMAP_IN"
							globalMap.remove("tXMLMap_1");
						
				try{
					
	
	/**
	 * [tFixedFlowInput_1 finally ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_1");
	
			
			
	
			cLabel="DefinePIIQuery";
		

 



		

/**
 * [tFixedFlowInput_1 finally ] stop
 */


	
	/**
	 * [tRESTClient_1 finally ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_1");
	
			
			
	
			cLabel="ExtractPIIList";
		

 



		

/**
 * [tRESTClient_1 finally ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_OUT";
		

 



		

/**
 * [tXMLMap_1_TXMLMAP_OUT finally ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_IN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
			cLabel="ParsePIIResponse_TXMLMAP_IN";
		

 



		

/**
 * [tXMLMap_1_TXMLMAP_IN finally ] stop
 */


	
	/**
	 * [tLogRow_1 finally ] start
	 */

	

	
	
	s(currentComponent="tLogRow_1");
	
			
			
	

 



		

/**
 * [tLogRow_1 finally ] stop
 */


	
	/**
	 * [tFlowToIterate_1 finally ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
			cLabel="FlowToIterate";
		

 



		

/**
 * [tFlowToIterate_1 finally ] stop
 */


	
	/**
	 * [tJava_1 finally ] start
	 */

	

	
	
	s(currentComponent="tJava_1");
	
			
			
	
			cLabel="JavaFiller";
		

 



		

/**
 * [tJava_1 finally ] stop
 */



















				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_1_SUBPROCESS_STATE", 1);
	}
	


public void tRESTClient_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRESTClient_3_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tRESTClient_3", "lA53hY_");

	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [tRESTClient_3 begin ] start
	 */

	

	
		
		sh("tRESTClient_3");
		
	
	s(currentComponent="tRESTClient_3");
	
			
			
	
			cLabel="DeleteCustomerFromTable";
		
		int tos_count_tRESTClient_3 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTClient_3", "DeleteCustomerFromTable", "tRESTClient");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

 



		

/**
 * [tRESTClient_3 begin ] stop
 */

	
	/**
	 * [tRESTClient_3 main ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_3");
	
			
			
	
			cLabel="DeleteCustomerFromTable";
		


// expected response body
jakarta.ws.rs.core.Response responseDoc_tRESTClient_3 = null;

try {
	// request body
	org.dom4j.Document requestDoc_tRESTClient_3 = null;
	String requestString_tRESTClient_3 = null;

	Object requestBody_tRESTClient_3 = requestDoc_tRESTClient_3 != null ? requestDoc_tRESTClient_3 : requestString_tRESTClient_3;

	

    //resposne class name
	Class<?> responseClass_tRESTClient_3
		= org.dom4j.Document.class;

	// create web client instance
	org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_3 =
			new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

	boolean inOSGi = routines.system.BundleUtils.inOSGi();

	final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_3 =
			new java.util.ArrayList<org.apache.cxf.feature.Feature>();

	String url = null;
	
		url = "http://192.168.1.163:8060/GDPR/customer/";
		// {baseUri}tRESTClient
		factoryBean_tRESTClient_3.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
		factoryBean_tRESTClient_3.setAddress(url);
	

	

    boolean log_messages_tRESTClient_3 = Boolean.valueOf(false);
	if (log_messages_tRESTClient_3) {
		org.apache.cxf.ext.logging.LoggingFeature loggingFeature = new  org.apache.cxf.ext.logging.LoggingFeature();
		loggingFeature.addSensitiveProtocolHeaderNames(new java.util.HashSet<>(java.util.Arrays.asList(org.apache.cxf.helpers.HttpHeaderHelper.AUTHORIZATION)));
		loggingFeature.addSensitiveElementNames(new java.util.HashSet<>(java.util.Arrays.asList("password")));
		features_tRESTClient_3.add(loggingFeature);
	}

	

	factoryBean_tRESTClient_3.setFeatures(features_tRESTClient_3);


	java.util.List<Object> providers_tRESTClient_3 = new java.util.ArrayList<Object>();
	providers_tRESTClient_3.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
		// workaround for https://jira.talendforge.org/browse/TESB-7276
		public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls,
											java.lang.reflect.Type type,
											java.lang.annotation.Annotation[] anns,
											jakarta.ws.rs.core.MediaType mt,
											jakarta.ws.rs.core.MultivaluedMap<String, String> headers,
											java.io.InputStream is)
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
	org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_3 =
			new org.apache.cxf.jaxrs.provider.json.JSONProvider();
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
		webClient_tRESTClient_3.path(context.customerId + "/" +((String)globalMap.get("row2.tableId")));
	

	// set connection properties
	org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_3 = org.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_tRESTClient_3);
	org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
	org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_3 = null;

	
		conduit_tRESTClient_3 = clientConfig_tRESTClient_3.getHttpConduit();
	
	
    if (clientConfig_tRESTClient_3.getEndpoint() != null) {
		org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_3 = clientConfig_tRESTClient_3.getEndpoint().getEndpointInfo();
		if(endpointInfo_tRESTClient_3 != null) {
			endpointInfo_tRESTClient_3.setProperty("enable.webclient.operation.reporting", true);
		}
    }

	

	

	if (!inOSGi) {
		conduit_tRESTClient_3.getClient().setReceiveTimeout((long)(60 * 1000L));
		conduit_tRESTClient_3.getClient().setConnectionTimeout((long)(30 * 1000L));
	}
	
	
	
		

	

	

	
		// set Accept-Type
		webClient_tRESTClient_3.accept("application/xml");
	

	
		// set optional query and header properties if any
	
	if (use_auth_tRESTClient_3 && "OAUTH2_BEARER".equals("BASIC")) {
		// set oAuth2 bearer token
		org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
		authSupplier.setAccessToken((String) "");
		conduit_tRESTClient_3.setAuthSupplier(authSupplier);
	}

	

	// if FORM request then capture query parameters into Form, otherwise set them as queries
	
		
		
	


	try {
		// start send request
		
		    responseDoc_tRESTClient_3 = webClient_tRESTClient_3.invoke("DELETE", requestBody_tRESTClient_3);
		


		int webClientResponseStatus_tRESTClient_3 = webClient_tRESTClient_3.getResponse().getStatus();
		if (webClientResponseStatus_tRESTClient_3 >= 300) {
			throw new jakarta.ws.rs.WebApplicationException(webClient_tRESTClient_3.getResponse());
		}

		

	} catch (jakarta.ws.rs.WebApplicationException ex_tRESTClient_3) {
	    globalMap.put("tRESTClient_3_ERROR_MESSAGE",ex_tRESTClient_3.getMessage());
		
			throw ex_tRESTClient_3;
		
	}

} catch(Exception e_tRESTClient_3) {
    globalMap.put("tRESTClient_3_ERROR_MESSAGE",e_tRESTClient_3.getMessage());
	
		throw new TalendException(e_tRESTClient_3, currentComponent, globalMap);
	
}


 


	tos_count_tRESTClient_3++;

		

/**
 * [tRESTClient_3 main ] stop
 */

	
	/**
	 * [tRESTClient_3 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_3");
	
			
			
	
			cLabel="DeleteCustomerFromTable";
		

 



		

/**
 * [tRESTClient_3 process_data_begin ] stop
 */

	
	/**
	 * [tRESTClient_3 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_3");
	
			
			
	
			cLabel="DeleteCustomerFromTable";
		

 



		

/**
 * [tRESTClient_3 process_data_end ] stop
 */

	
	/**
	 * [tRESTClient_3 end ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_3");
	
			
			
	
			cLabel="DeleteCustomerFromTable";
		


if (globalMap.get("tRESTClient_3_NB_LINE") == null) {
	globalMap.put("tRESTClient_3_NB_LINE", 1);
}

// [tRESTCliend_end]
 

ok_Hash.put("tRESTClient_3", true);
end_Hash.put("tRESTClient_3", System.currentTimeMillis());




		

/**
 * [tRESTClient_3 end ] stop
 */

				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRESTClient_3 finally ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_3");
	
			
			
	
			cLabel="DeleteCustomerFromTable";
		

 



		

/**
 * [tRESTClient_3 finally ] stop
 */

				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tRESTClient_3_SUBPROCESS_STATE", 1);
	}
	


public static class setTokenStruct implements routines.system.IPersistableRow<setTokenStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public String key;

				public String getKey () {
					return this.key;
				}

				public Boolean keyIsNullable(){
				    return true;
				}
				public Boolean keyIsKey(){
				    return false;
				}
				public Integer keyLength(){
				    return 255;
				}
				public Integer keyPrecision(){
				    return 0;
				}
				public String keyDefault(){
				
					return null;
				
				}
				public String keyComment(){
				
				    return null;
				
				}
				public String keyPattern(){
				
				    return null;
				
				}
				public String keyOriginalDbColumnName(){
				
					return "key";
				
				}

				
			    public String value;

				public String getValue () {
					return this.value;
				}

				public Boolean valueIsNullable(){
				    return true;
				}
				public Boolean valueIsKey(){
				    return false;
				}
				public Integer valueLength(){
				    return 255;
				}
				public Integer valuePrecision(){
				    return 0;
				}
				public String valueDefault(){
				
					return null;
				
				}
				public String valueComment(){
				
				    return null;
				
				}
				public String valuePattern(){
				
				    return null;
				
				}
				public String valueOriginalDbColumnName(){
				
					return "value";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

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

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

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
				
						writeString(this.key,dos);
					
					// String
				
						writeString(this.value,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.key,dos);
					
					// String
				
						writeString(this.value,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("key="+key);
		sb.append(",value="+value);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(key == null){
        					sb.append("<null>");
        				}else{
            				sb.append(key);
            			}
            		
        			sb.append("|");
        		
        				if(value == null){
        					sb.append("<null>");
        				}else{
            				sb.append(value);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(setTokenStruct other) {

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

public static class OnRowsEndStructtXMLMap_2 implements routines.system.IPersistableRow<OnRowsEndStructtXMLMap_2> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public String key;

				public String getKey () {
					return this.key;
				}

				public Boolean keyIsNullable(){
				    return true;
				}
				public Boolean keyIsKey(){
				    return false;
				}
				public Integer keyLength(){
				    return 255;
				}
				public Integer keyPrecision(){
				    return 0;
				}
				public String keyDefault(){
				
					return null;
				
				}
				public String keyComment(){
				
				    return null;
				
				}
				public String keyPattern(){
				
				    return null;
				
				}
				public String keyOriginalDbColumnName(){
				
					return "key";
				
				}

				
			    public String value;

				public String getValue () {
					return this.value;
				}

				public Boolean valueIsNullable(){
				    return true;
				}
				public Boolean valueIsKey(){
				    return false;
				}
				public Integer valueLength(){
				    return 255;
				}
				public Integer valuePrecision(){
				    return 0;
				}
				public String valueDefault(){
				
					return null;
				
				}
				public String valueComment(){
				
				    return null;
				
				}
				public String valuePattern(){
				
				    return null;
				
				}
				public String valueOriginalDbColumnName(){
				
					return "value";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

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

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

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
				
						writeString(this.key,dos);
					
					// String
				
						writeString(this.value,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// String
				
						writeString(this.key,dos);
					
					// String
				
						writeString(this.value,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("key="+key);
		sb.append(",value="+value);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(key == null){
        					sb.append("<null>");
        				}else{
            				sb.append(key);
            			}
            		
        			sb.append("|");
        		
        				if(value == null){
        					sb.append("<null>");
        				}else{
            				sb.append(value);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(OnRowsEndStructtXMLMap_2 other) {

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

public static class sendAuthStruct implements routines.system.IPersistableRow<sendAuthStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public Integer statusCode;

				public Integer getStatusCode () {
					return this.statusCode;
				}

				public Boolean statusCodeIsNullable(){
				    return true;
				}
				public Boolean statusCodeIsKey(){
				    return false;
				}
				public Integer statusCodeLength(){
				    return 0;
				}
				public Integer statusCodePrecision(){
				    return 0;
				}
				public String statusCodeDefault(){
				
					return "";
				
				}
				public String statusCodeComment(){
				
				    return null;
				
				}
				public String statusCodePattern(){
				
				    return null;
				
				}
				public String statusCodeOriginalDbColumnName(){
				
					return "statusCode";
				
				}

				
			    public routines.system.Document body;

				public routines.system.Document getBody () {
					return this.body;
				}

				public Boolean bodyIsNullable(){
				    return true;
				}
				public Boolean bodyIsKey(){
				    return false;
				}
				public Integer bodyLength(){
				    return 0;
				}
				public Integer bodyPrecision(){
				    return 0;
				}
				public String bodyDefault(){
				
					return "";
				
				}
				public String bodyComment(){
				
				    return null;
				
				}
				public String bodyPattern(){
				
				    return null;
				
				}
				public String bodyOriginalDbColumnName(){
				
					return "body";
				
				}

				
			    public String string;

				public String getString () {
					return this.string;
				}

				public Boolean stringIsNullable(){
				    return true;
				}
				public Boolean stringIsKey(){
				    return false;
				}
				public Integer stringLength(){
				    return 4048;
				}
				public Integer stringPrecision(){
				    return 0;
				}
				public String stringDefault(){
				
					return null;
				
				}
				public String stringComment(){
				
				    return null;
				
				}
				public String stringPattern(){
				
				    return null;
				
				}
				public String stringOriginalDbColumnName(){
				
					return "string";
				
				}

				


	private Integer readInteger(ObjectInputStream dis) throws IOException{
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
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
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

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.statusCode = readInteger(dis);
					
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.statusCode = readInteger(dis);
					
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.statusCode,dos);
					
					// Document
				
       			    	dos.writeObject(this.body);
					
					// String
				
						writeString(this.string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.statusCode,dos);
					
					// Document
				
						dos.clearInstanceCache();
						dos.writeObject(this.body);
					
					// String
				
						writeString(this.string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("statusCode="+String.valueOf(statusCode));
		sb.append(",body="+String.valueOf(body));
		sb.append(",string="+string);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(statusCode == null){
        					sb.append("<null>");
        				}else{
            				sb.append(statusCode);
            			}
            		
        			sb.append("|");
        		
        				if(body == null){
        					sb.append("<null>");
        				}else{
            				sb.append(body);
            			}
            		
        			sb.append("|");
        		
        				if(string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(string);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(sendAuthStruct other) {

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

public static class inputStringStruct implements routines.system.IPersistableRow<inputStringStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public routines.system.Document body;

				public routines.system.Document getBody () {
					return this.body;
				}

				public Boolean bodyIsNullable(){
				    return true;
				}
				public Boolean bodyIsKey(){
				    return false;
				}
				public Integer bodyLength(){
				    return 0;
				}
				public Integer bodyPrecision(){
				    return 0;
				}
				public String bodyDefault(){
				
					return "";
				
				}
				public String bodyComment(){
				
				    return null;
				
				}
				public String bodyPattern(){
				
				    return null;
				
				}
				public String bodyOriginalDbColumnName(){
				
					return "body";
				
				}

				
			    public String string;

				public String getString () {
					return this.string;
				}

				public Boolean stringIsNullable(){
				    return true;
				}
				public Boolean stringIsKey(){
				    return false;
				}
				public Integer stringLength(){
				    return 4048;
				}
				public Integer stringPrecision(){
				    return 0;
				}
				public String stringDefault(){
				
					return null;
				
				}
				public String stringComment(){
				
				    return null;
				
				}
				public String stringPattern(){
				
				    return null;
				
				}
				public String stringOriginalDbColumnName(){
				
					return "string";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
					this.string = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Document
				
       			    	dos.writeObject(this.body);
					
					// String
				
						writeString(this.string,dos);
					
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
				
						writeString(this.string,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("body="+String.valueOf(body));
		sb.append(",string="+string);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(body == null){
        					sb.append("<null>");
        				}else{
            				sb.append(body);
            			}
            		
        			sb.append("|");
        		
        				if(string == null){
        					sb.append("<null>");
        				}else{
            				sb.append(string);
            			}
            		
        			sb.append("|");
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(inputStringStruct other) {

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

public void tFixedFlowInput_3Process(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tFixedFlowInput_3", "kLmzFX_");

		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		inputStringStruct inputString = new inputStringStruct();
sendAuthStruct sendAuth = new sendAuthStruct();
setTokenStruct setToken = new setTokenStruct();





	
	/**
	 * [tXMLMap_2_TXMLMAP_OUT begin ] start
	 */

	

	
		
		sh("tXMLMap_2_TXMLMAP_OUT");
		
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_OUT";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"sendAuth");
					}
				
		int tos_count_tXMLMap_2_TXMLMAP_OUT = 0;
		
                if(log.isDebugEnabled())
            log.debug("tXMLMap_2_TXMLMAP_OUT - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tXMLMap_2_TXMLMAP_OUT{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tXMLMap_2_TXMLMAP_OUT = new StringBuilder();
                    log4jParamters_tXMLMap_2_TXMLMAP_OUT.append("Parameters:");
                            log4jParamters_tXMLMap_2_TXMLMAP_OUT.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
                        log4jParamters_tXMLMap_2_TXMLMAP_OUT.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tXMLMap_2_TXMLMAP_OUT - "  + (log4jParamters_tXMLMap_2_TXMLMAP_OUT) );
                    } 
                } 
            new BytesLimit65535_tXMLMap_2_TXMLMAP_OUT().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tXMLMap_2_TXMLMAP_OUT", "ParseAuthResponse_TXMLMAP_OUT", "tXMLMapOut");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	
	
//===============================input xml init part===============================
class XML_API_tXMLMap_2_TXMLMAP_OUT{
	public boolean isDefNull(org.dom4j.Node node) throws javax.xml.transform.TransformerException {
        if (node != null && node instanceof org.dom4j.Element) {
        	org.dom4j.Attribute attri = ((org.dom4j.Element)node).attribute("nil");
        	if(attri != null && ("true").equals(attri.getText())){
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
	class Var__tXMLMap_2_TXMLMAP_OUT__Struct {
	}
	Var__tXMLMap_2_TXMLMAP_OUT__Struct Var__tXMLMap_2_TXMLMAP_OUT = new Var__tXMLMap_2_TXMLMAP_OUT__Struct();
// ###############################
// # Outputs initialization
setTokenStruct setToken_tmp = new setTokenStruct();
setTokenStruct setToken_save = null;
//the aggregate variable
setTokenStruct setToken_aggregate = null;
int count_setToken_tXMLMap_2_TXMLMAP_OUT = 0;
//init the resultset for aggregate
java.util.List<Object> allOutsForAggregate_tXMLMap_2 = new java.util.ArrayList<Object>();
globalMap.put("allOutsForAggregate_tXMLMap_2",allOutsForAggregate_tXMLMap_2);
// ###############################
class TreeNode_API_tXMLMap_2_TXMLMAP_OUT {
	java.util.Map<String, String> xpath_value_map = new java.util.HashMap<String, String>();
	
	void clear(){
		xpath_value_map.clear();
	}
	
	void put(String xpath, String value){
		xpath_value_map.put(xpath, value);
	}
	String get_null(String xpath) {
		return null;
	}
	String get_String(String xpath){
		return xpath_value_map.get(xpath);
	}
}
			TreeNode_API_tXMLMap_2_TXMLMAP_OUT treeNodeAPI_tXMLMap_2_TXMLMAP_OUT = new TreeNode_API_tXMLMap_2_TXMLMAP_OUT();
			NameSpaceTool nsTool_tXMLMap_2_TXMLMAP_OUT = new NameSpaceTool();
		int nb_line_tXMLMap_2_TXMLMAP_OUT = 0; 
	
    XML_API_tXMLMap_2_TXMLMAP_OUT xml_api_tXMLMap_2_TXMLMAP_OUT = new XML_API_tXMLMap_2_TXMLMAP_OUT();

	//the map store the previous value of aggregate columns
	java.util.Map<String,Object> aggregateCacheMap_tXMLMap_2_TXMLMAP_OUT = new java.util.HashMap<String,Object>();

	            

 



		

/**
 * [tXMLMap_2_TXMLMAP_OUT begin ] stop
 */




	
	/**
	 * [tRESTClient_2 begin ] start
	 */

	

	
		
		sh("tRESTClient_2");
		
	
	s(currentComponent="tRESTClient_2");
	
			
			
	
			cLabel="GetAuthToken";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"inputString");
					}
				
		int tos_count_tRESTClient_2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTClient_2", "GetAuthToken", "tRESTClient");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

 



		

/**
 * [tRESTClient_2 begin ] stop
 */




	
	/**
	 * [tFixedFlowInput_3 begin ] start
	 */

	

	
		
		sh("tFixedFlowInput_3");
		
	
	s(currentComponent="tFixedFlowInput_3");
	
			
			
	
			cLabel="DefineInput";
		
		int tos_count_tFixedFlowInput_3 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tFixedFlowInput_3", "DefineInput", "tFixedFlowInput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

	    for (int i_tFixedFlowInput_3 = 0 ; i_tFixedFlowInput_3 < 1 ; i_tFixedFlowInput_3++) {
	                	            	
    	            		inputString.body = null;        	            	
    	            	        	            	
    	            		inputString.string = "{\"user\":\"Pranita\",\"password\":\"Predoole@2025\"}";
    	            	

 



		

/**
 * [tFixedFlowInput_3 begin ] stop
 */

	
	/**
	 * [tFixedFlowInput_3 main ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_3");
	
			
			
	
			cLabel="DefineInput";
		

 


	tos_count_tFixedFlowInput_3++;

		

/**
 * [tFixedFlowInput_3 main ] stop
 */

	
	/**
	 * [tFixedFlowInput_3 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_3");
	
			
			
	
			cLabel="DefineInput";
		

 



		

/**
 * [tFixedFlowInput_3 process_data_begin ] stop
 */


	
	/**
	 * [tRESTClient_2 main ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_2");
	
			
			
	
			cLabel="GetAuthToken";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"inputString","tFixedFlowInput_3","DefineInput","tFixedFlowInput","tRESTClient_2","GetAuthToken","tRESTClient"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("inputString - " + (inputString==null? "": inputString.toLogString()));
    			}
    		
	sendAuth = null;

// expected response body
jakarta.ws.rs.core.Response responseDoc_tRESTClient_2 = null;

try {
	// request body
	org.dom4j.Document requestDoc_tRESTClient_2 = null;
	String requestString_tRESTClient_2 = null;
			if (null != inputString.body) {
				requestDoc_tRESTClient_2 = inputString.body.getDocument();
			}
			requestString_tRESTClient_2 = inputString.string;

	Object requestBody_tRESTClient_2 = requestDoc_tRESTClient_2 != null ? requestDoc_tRESTClient_2 : requestString_tRESTClient_2;

	

    //resposne class name
	Class<?> responseClass_tRESTClient_2
		= org.dom4j.Document.class;

	// create web client instance
	org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean factoryBean_tRESTClient_2 =
			new org.apache.cxf.jaxrs.client.JAXRSClientFactoryBean();

	boolean inOSGi = routines.system.BundleUtils.inOSGi();

	final java.util.List<org.apache.cxf.feature.Feature> features_tRESTClient_2 =
			new java.util.ArrayList<org.apache.cxf.feature.Feature>();

	String url = null;
	
		url = "http://192.168.1.253:11480/MM/rest/v1/auth/login";
		// {baseUri}tRESTClient
		factoryBean_tRESTClient_2.setServiceName(new javax.xml.namespace.QName(url, "tRESTClient"));
		factoryBean_tRESTClient_2.setAddress(url);
	

	

    boolean log_messages_tRESTClient_2 = Boolean.valueOf(false);
	if (log_messages_tRESTClient_2) {
		org.apache.cxf.ext.logging.LoggingFeature loggingFeature = new  org.apache.cxf.ext.logging.LoggingFeature();
		loggingFeature.addSensitiveProtocolHeaderNames(new java.util.HashSet<>(java.util.Arrays.asList(org.apache.cxf.helpers.HttpHeaderHelper.AUTHORIZATION)));
		loggingFeature.addSensitiveElementNames(new java.util.HashSet<>(java.util.Arrays.asList("password")));
		features_tRESTClient_2.add(loggingFeature);
	}

	

	factoryBean_tRESTClient_2.setFeatures(features_tRESTClient_2);


	java.util.List<Object> providers_tRESTClient_2 = new java.util.ArrayList<Object>();
	providers_tRESTClient_2.add(new org.apache.cxf.jaxrs.provider.dom4j.DOM4JProvider() {
		// workaround for https://jira.talendforge.org/browse/TESB-7276
		public org.dom4j.Document readFrom(Class<org.dom4j.Document> cls,
											java.lang.reflect.Type type,
											java.lang.annotation.Annotation[] anns,
											jakarta.ws.rs.core.MediaType mt,
											jakarta.ws.rs.core.MultivaluedMap<String, String> headers,
											java.io.InputStream is)
				throws IOException, jakarta.ws.rs.WebApplicationException {
			String contentLength = headers.getFirst("Content-Length");
			if (!org.apache.cxf.common.util.StringUtils.isEmpty(contentLength)
					&& Integer.valueOf(contentLength) <= 0) {
				try {
					return org.dom4j.DocumentHelper.parseText("<root/>");
				} catch (org.dom4j.DocumentException e_tRESTClient_2) {
					e_tRESTClient_2.printStackTrace();
				}
				return null;
			}
			return super.readFrom(cls, type, anns, mt, headers, is);
		}
	});
	org.apache.cxf.jaxrs.provider.json.JSONProvider jsonProvider_tRESTClient_2 =
			new org.apache.cxf.jaxrs.provider.json.JSONProvider();
		jsonProvider_tRESTClient_2.setIgnoreNamespaces(true);
		jsonProvider_tRESTClient_2.setAttributesToElements(true);
	
		jsonProvider_tRESTClient_2.setSerializeAsArray(true);
		List<String> arrayKeys = new java.util.ArrayList<String>(java.util.Arrays.asList("".split(" ")));
		jsonProvider_tRESTClient_2.setArrayKeys(arrayKeys);
	
	
	
		jsonProvider_tRESTClient_2.setSupportUnwrapped(true);
		jsonProvider_tRESTClient_2.setWrapperName("root");
	
	
		jsonProvider_tRESTClient_2.setDropRootElement(false);
		jsonProvider_tRESTClient_2.setConvertTypesToStrings(false);
	providers_tRESTClient_2.add(jsonProvider_tRESTClient_2);
	factoryBean_tRESTClient_2.setProviders(providers_tRESTClient_2);
	factoryBean_tRESTClient_2.setTransportId("http://cxf.apache.org/transports/http");

	boolean use_auth_tRESTClient_2 = false;

	

	org.apache.cxf.jaxrs.client.WebClient webClient_tRESTClient_2 = null;
	
		webClient_tRESTClient_2 = factoryBean_tRESTClient_2.createWebClient();
		// set request path
		webClient_tRESTClient_2.path("");
	

	// set connection properties
	org.apache.cxf.jaxrs.client.ClientConfiguration clientConfig_tRESTClient_2 = org.apache.cxf.jaxrs.client.WebClient.getConfig(webClient_tRESTClient_2);
	org.apache.cxf.transport.http.auth.HttpAuthSupplier httpAuthSupplerHttpConduit = null;
	org.apache.cxf.transport.http.HTTPConduit conduit_tRESTClient_2 = null;

	
		conduit_tRESTClient_2 = clientConfig_tRESTClient_2.getHttpConduit();
	
	
    if (clientConfig_tRESTClient_2.getEndpoint() != null) {
		org.apache.cxf.service.model.EndpointInfo endpointInfo_tRESTClient_2 = clientConfig_tRESTClient_2.getEndpoint().getEndpointInfo();
		if(endpointInfo_tRESTClient_2 != null) {
			endpointInfo_tRESTClient_2.setProperty("enable.webclient.operation.reporting", true);
		}
    }

	

	

	if (!inOSGi) {
		conduit_tRESTClient_2.getClient().setReceiveTimeout((long)(60 * 1000L));
		conduit_tRESTClient_2.getClient().setConnectionTimeout((long)(30 * 1000L));
	}
	
	
	
		

	

	
		// set Content-Type
		webClient_tRESTClient_2.type("application/json");
	

	
		// set Accept-Type
		webClient_tRESTClient_2.accept("application/json");
	

	
		// set optional query and header properties if any
	
	if (use_auth_tRESTClient_2 && "OAUTH2_BEARER".equals("BASIC")) {
		// set oAuth2 bearer token
		org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier authSupplier = new org.apache.cxf.rs.security.oauth2.client.BearerAuthSupplier();
		authSupplier.setAccessToken((String) "");
		conduit_tRESTClient_2.setAuthSupplier(authSupplier);
	}

	

	// if FORM request then capture query parameters into Form, otherwise set them as queries
	
		
		
			webClient_tRESTClient_2.query("forceLogin" ,"true");
		
	


	try {
		// start send request
		
			
				responseDoc_tRESTClient_2 = webClient_tRESTClient_2.post(requestBody_tRESTClient_2);
			
		


		int webClientResponseStatus_tRESTClient_2 = webClient_tRESTClient_2.getResponse().getStatus();
		if (webClientResponseStatus_tRESTClient_2 >= 300) {
			throw new jakarta.ws.rs.WebApplicationException(webClient_tRESTClient_2.getResponse());
		}

		
			if (sendAuth == null) {
				sendAuth = new sendAuthStruct();
			}

			sendAuth.statusCode = webClientResponseStatus_tRESTClient_2;
			sendAuth.string = "";
			
				
				Object responseObj_tRESTClient_2 = null;
				if(responseDoc_tRESTClient_2 != null && responseDoc_tRESTClient_2.hasEntity()){
					responseObj_tRESTClient_2 = responseDoc_tRESTClient_2.readEntity(responseClass_tRESTClient_2);
				
				if(responseObj_tRESTClient_2 != null){
					if (responseClass_tRESTClient_2 == String.class && responseObj_tRESTClient_2 instanceof String) {
							sendAuth.string = (String) responseObj_tRESTClient_2;
					} else {
						routines.system.Document responseTalendDoc_tRESTClient_2 = null;
						if (null != responseObj_tRESTClient_2) {
							responseTalendDoc_tRESTClient_2 = new routines.system.Document();
							if (responseObj_tRESTClient_2 instanceof org.dom4j.Document) {
								responseTalendDoc_tRESTClient_2.setDocument((org.dom4j.Document) responseObj_tRESTClient_2);
							}
						}
						sendAuth.body = responseTalendDoc_tRESTClient_2;
					}
				}
			}
			

			java.util.Map<String, jakarta.ws.rs.core.NewCookie> cookies_tRESTClient_2 = new java.util.HashMap<String, jakarta.ws.rs.core.NewCookie>();

			if (webClient_tRESTClient_2.getResponse() != null && webClient_tRESTClient_2.getResponse().getCookies() != null ) { 
				cookies_tRESTClient_2.putAll(webClient_tRESTClient_2.getResponse().getCookies());
			}

			


			globalMap.put("tRESTClient_2_HEADERS", webClient_tRESTClient_2.getResponse().getHeaders());
			globalMap.put("tRESTClient_2_COOKIES", cookies_tRESTClient_2);
			
		

	} catch (jakarta.ws.rs.WebApplicationException ex_tRESTClient_2) {
	    globalMap.put("tRESTClient_2_ERROR_MESSAGE",ex_tRESTClient_2.getMessage());
		
			throw ex_tRESTClient_2;
		
	}

} catch(Exception e_tRESTClient_2) {
    globalMap.put("tRESTClient_2_ERROR_MESSAGE",e_tRESTClient_2.getMessage());
	
		throw new TalendException(e_tRESTClient_2, currentComponent, globalMap);
	
}


 


	tos_count_tRESTClient_2++;

		

/**
 * [tRESTClient_2 main ] stop
 */

	
	/**
	 * [tRESTClient_2 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_2");
	
			
			
	
			cLabel="GetAuthToken";
		

 



		

/**
 * [tRESTClient_2 process_data_begin ] stop
 */

// Start of branch "sendAuth"
if(sendAuth != null) { 



	
	/**
	 * [tXMLMap_2_TXMLMAP_OUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_OUT";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"sendAuth","tRESTClient_2","GetAuthToken","tRESTClient","tXMLMap_2_TXMLMAP_OUT","ParseAuthResponse_TXMLMAP_OUT","tXMLMapOut"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("sendAuth - " + (sendAuth==null? "": sendAuth.toLogString()));
    			}
    		

	boolean rejectedInnerJoin_tXMLMap_2_TXMLMAP_OUT = false;
	boolean rejectedDocInnerJoin_tXMLMap_2_TXMLMAP_OUT = false;
	boolean mainRowRejected_tXMLMap_2_TXMLMAP_OUT = false;
	boolean isMatchDocRowtXMLMap_2_TXMLMAP_OUT = false;
	  
	
			

		
		
				//init document to flat tool
				routines.system.DocumentToFlat docToFlat_tXMLMap_2_TXMLMAP_OUT = new routines.system.DocumentToFlat();
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setOriginalLoop("/root/result");
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setIsOptional(false);
				if(sendAuth.body == null || sendAuth.body.getDocument() == null) {
					throw new RuntimeException("sendAuth.body can't be empty");
				}
				org.dom4j.Document doc_tXMLMap_2_TXMLMAP_OUT = sendAuth.body.getDocument();
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setDoc(doc_tXMLMap_2_TXMLMAP_OUT);
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setDefineNS(false);
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setNamespaceTool(nsTool_tXMLMap_2_TXMLMAP_OUT);
				
					//old version, find NS from doc
					nsTool_tXMLMap_2_TXMLMAP_OUT.countNSMap(doc_tXMLMap_2_TXMLMAP_OUT.getRootElement());
					java.util.HashMap<String,String> xmlNameSpaceMap_tXMLMap_2_TXMLMAP_OUT = nsTool_tXMLMap_2_TXMLMAP_OUT.xmlNameSpaceMap;
				
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setXmlNameSpaceMap(xmlNameSpaceMap_tXMLMap_2_TXMLMAP_OUT);
				
				String[] absolutePathMappings_tXMLMap_2_TXMLMAP_OUT = new String[1];
				String[] relativePathMappings_tXMLMap_2_TXMLMAP_OUT = new String[1];
				
				absolutePathMappings_tXMLMap_2_TXMLMAP_OUT[0] = "sendAuth.body:/root/result/token";
				relativePathMappings_tXMLMap_2_TXMLMAP_OUT[0] = "token";
				
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setAbsolutePathMappings(absolutePathMappings_tXMLMap_2_TXMLMAP_OUT);
				docToFlat_tXMLMap_2_TXMLMAP_OUT.setCurrentRelativePathMappings(relativePathMappings_tXMLMap_2_TXMLMAP_OUT);
				//generate document to flat data
				docToFlat_tXMLMap_2_TXMLMAP_OUT.flat();
				//get flat data
				java.util.List<java.util.Map<String, String>> resultSet_tXMLMap_2_TXMLMAP_OUT = docToFlat_tXMLMap_2_TXMLMAP_OUT.getResultSet();
				
				for (java.util.Map<String,String> oneRow_tXMLMap_2_TXMLMAP_OUT: resultSet_tXMLMap_2_TXMLMAP_OUT) { // G_TXM_M_001
					nb_line_tXMLMap_2_TXMLMAP_OUT++;
			    	rejectedInnerJoin_tXMLMap_2_TXMLMAP_OUT = false;
			    	rejectedDocInnerJoin_tXMLMap_2_TXMLMAP_OUT = false;
					mainRowRejected_tXMLMap_2_TXMLMAP_OUT=false;
				    isMatchDocRowtXMLMap_2_TXMLMAP_OUT = false;
					
			    	treeNodeAPI_tXMLMap_2_TXMLMAP_OUT.clear();
			    	for(java.util.Map.Entry<String, String> entry_tXMLMap_2_TXMLMAP_OUT : oneRow_tXMLMap_2_TXMLMAP_OUT.entrySet()) {
						treeNodeAPI_tXMLMap_2_TXMLMAP_OUT.put(entry_tXMLMap_2_TXMLMAP_OUT.getKey(),entry_tXMLMap_2_TXMLMAP_OUT.getValue());
					}
					


			
{ // start of Var scope

	// ###############################
	// # Vars tables

Var__tXMLMap_2_TXMLMAP_OUT__Struct Var = Var__tXMLMap_2_TXMLMAP_OUT;
		// ###############################
		// # Output tables

setToken = null;


// # Output table : 'setToken'
count_setToken_tXMLMap_2_TXMLMAP_OUT++;


setToken_tmp = new setTokenStruct();
setToken_tmp.key = "token";
setToken_tmp.value = treeNodeAPI_tXMLMap_2_TXMLMAP_OUT.get_String("sendAuth.body:/root/result/token");allOutsForAggregate_tXMLMap_2.add(setToken_tmp);

log.debug("tXMLMap_2 - Outputting the record " + count_setToken_tXMLMap_2_TXMLMAP_OUT + " of the output table 'setToken'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tXMLMap_2_TXMLMAP_OUT = false;


		}//G_TXM_M_001 close
	

 


	tos_count_tXMLMap_2_TXMLMAP_OUT++;

		

/**
 * [tXMLMap_2_TXMLMAP_OUT main ] stop
 */

	
	/**
	 * [tXMLMap_2_TXMLMAP_OUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_OUT";
		

 



		

/**
 * [tXMLMap_2_TXMLMAP_OUT process_data_begin ] stop
 */

	
	/**
	 * [tXMLMap_2_TXMLMAP_OUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_OUT";
		

 



		

/**
 * [tXMLMap_2_TXMLMAP_OUT process_data_end ] stop
 */


} // End of branch "sendAuth"




	
	/**
	 * [tRESTClient_2 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_2");
	
			
			
	
			cLabel="GetAuthToken";
		

 



		

/**
 * [tRESTClient_2 process_data_end ] stop
 */




	
	/**
	 * [tFixedFlowInput_3 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_3");
	
			
			
	
			cLabel="DefineInput";
		

 



		

/**
 * [tFixedFlowInput_3 process_data_end ] stop
 */

	
	/**
	 * [tFixedFlowInput_3 end ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_3");
	
			
			
	
			cLabel="DefineInput";
		

        }
        globalMap.put("tFixedFlowInput_3_NB_LINE", 1);        

 

ok_Hash.put("tFixedFlowInput_3", true);
end_Hash.put("tFixedFlowInput_3", System.currentTimeMillis());




		

/**
 * [tFixedFlowInput_3 end ] stop
 */


	
	/**
	 * [tRESTClient_2 end ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_2");
	
			
			
	
			cLabel="GetAuthToken";
		


if (globalMap.get("tRESTClient_2_NB_LINE") == null) {
	globalMap.put("tRESTClient_2_NB_LINE", 1);
}

// [tRESTCliend_end]
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"inputString",2,0,
				 			"tFixedFlowInput_3","DefineInput","tFixedFlowInput","tRESTClient_2","GetAuthToken","tRESTClient","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tRESTClient_2", true);
end_Hash.put("tRESTClient_2", System.currentTimeMillis());




		

/**
 * [tRESTClient_2 end ] stop
 */


	
	/**
	 * [tXMLMap_2_TXMLMAP_OUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_OUT";
		
		log.debug("tXMLMap_2 - Written records count in the table 'setToken': " + count_setToken_tXMLMap_2_TXMLMAP_OUT + ".");



				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"sendAuth",2,0,
				 			"tRESTClient_2","GetAuthToken","tRESTClient","tXMLMap_2_TXMLMAP_OUT","ParseAuthResponse_TXMLMAP_OUT","tXMLMapOut","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_2_TXMLMAP_OUT - "  + ("Done.") );

ok_Hash.put("tXMLMap_2_TXMLMAP_OUT", true);
end_Hash.put("tXMLMap_2_TXMLMAP_OUT", System.currentTimeMillis());




		

/**
 * [tXMLMap_2_TXMLMAP_OUT end ] stop
 */



	
	/**
	 * [tContextLoad_1 begin ] start
	 */

	

	
		
		sh("tContextLoad_1");
		
	
	s(currentComponent="tContextLoad_1");
	
			
			
	
			cLabel="LoadContextToken";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"setToken");
					}
				
		int tos_count_tContextLoad_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tContextLoad_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tContextLoad_1{
                    public void limitLog4jByte() throws Exception{
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
                if(log.isDebugEnabled())
            log.debug("tContextLoad_1 - "  + (log4jParamters_tContextLoad_1) );
                    } 
                } 
            new BytesLimit65535_tContextLoad_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tContextLoad_1", "LoadContextToken", "tContextLoad");
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
	 * [tXMLMap_2_TXMLMAP_IN begin ] start
	 */

	

	
		
		sh("tXMLMap_2_TXMLMAP_IN");
		
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_IN");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_IN";
		
		int tos_count_tXMLMap_2_TXMLMAP_IN = 0;
		
                if(log.isDebugEnabled())
            log.debug("tXMLMap_2_TXMLMAP_IN - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tXMLMap_2_TXMLMAP_IN{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tXMLMap_2_TXMLMAP_IN = new StringBuilder();
                    log4jParamters_tXMLMap_2_TXMLMAP_IN.append("Parameters:");
                            log4jParamters_tXMLMap_2_TXMLMAP_IN.append("KEEP_ORDER_FOR_DOCUMENT" + " = " + "false");
                        log4jParamters_tXMLMap_2_TXMLMAP_IN.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tXMLMap_2_TXMLMAP_IN - "  + (log4jParamters_tXMLMap_2_TXMLMAP_IN) );
                    } 
                } 
            new BytesLimit65535_tXMLMap_2_TXMLMAP_IN().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tXMLMap_2_TXMLMAP_IN", "ParseAuthResponse_TXMLMAP_IN", "tXMLMapIn");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
java.util.List<Object> outs_tXMLMap_2 = (java.util.List<Object>)globalMap.get("allOutsForAggregate_tXMLMap_2");
for(Object  row_out_tXMLMap_2_TXMLMAP_IN : outs_tXMLMap_2) {//TD512
 



		

/**
 * [tXMLMap_2_TXMLMAP_IN begin ] stop
 */

	
	/**
	 * [tXMLMap_2_TXMLMAP_IN main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_IN");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_IN";
		

	setToken = null;
	if(row_out_tXMLMap_2_TXMLMAP_IN!=null && row_out_tXMLMap_2_TXMLMAP_IN instanceof setTokenStruct) {
		setToken = (setTokenStruct)row_out_tXMLMap_2_TXMLMAP_IN;		
	}
 


	tos_count_tXMLMap_2_TXMLMAP_IN++;

		

/**
 * [tXMLMap_2_TXMLMAP_IN main ] stop
 */

	
	/**
	 * [tXMLMap_2_TXMLMAP_IN process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_IN");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_IN";
		

 



		

/**
 * [tXMLMap_2_TXMLMAP_IN process_data_begin ] stop
 */

// Start of branch "setToken"
if(setToken != null) { 



	
	/**
	 * [tContextLoad_1 main ] start
	 */

	

	
	
	s(currentComponent="tContextLoad_1");
	
			
			
	
			cLabel="LoadContextToken";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"setToken","tXMLMap_2_TXMLMAP_IN","ParseAuthResponse_TXMLMAP_IN","tXMLMapIn","tContextLoad_1","LoadContextToken","tContextLoad"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("setToken - " + (setToken==null? "": setToken.toLogString()));
    			}
    		
        //////////////////////////
        String tmp_key_tContextLoad_1 = null;
                    String key_tContextLoad_1 = null;
                      if (setToken.key != null){
                          tmp_key_tContextLoad_1 = setToken.key.trim();
                        if ((tmp_key_tContextLoad_1.startsWith("#") || tmp_key_tContextLoad_1.startsWith("!") )){
                          tmp_key_tContextLoad_1 = null;
                        } else {
                          setToken.key = tmp_key_tContextLoad_1;
                        }
                      }
                        if(setToken.key != null) {
                    key_tContextLoad_1 =
                        setToken.key;
                        }
                    String value_tContextLoad_1 = null;
                        if(setToken.value != null) {
                    value_tContextLoad_1 =
                        setToken.value;
                        }
				
				String currentValue_tContextLoad_1 = value_tContextLoad_1;
										
						if ((key_tContextLoad_1 != null) && ("Stewardship_Password".equals(key_tContextLoad_1)) && (currentValue_tContextLoad_1 != null)) 
							currentValue_tContextLoad_1 = currentValue_tContextLoad_1.replaceAll(".", "*");

  if (tmp_key_tContextLoad_1 != null){
  try{
        if(key_tContextLoad_1!=null && "token".equals(key_tContextLoad_1))
        {
           context.token=value_tContextLoad_1;
        }

        if(key_tContextLoad_1!=null && "customerId".equals(key_tContextLoad_1))
        {

                context.customerId=Integer.parseInt(value_tContextLoad_1);

        }

        if(key_tContextLoad_1!=null && "Stewardship_Password".equals(key_tContextLoad_1))
        {
           context.Stewardship_Password=value_tContextLoad_1;
        }

        if(key_tContextLoad_1!=null && "Stewardship_URL".equals(key_tContextLoad_1))
        {
           context.Stewardship_URL=value_tContextLoad_1;
        }

        if(key_tContextLoad_1!=null && "Stewardship_UserName".equals(key_tContextLoad_1))
        {
           context.Stewardship_UserName=value_tContextLoad_1;
        }


        if (context.getProperty(key_tContextLoad_1)!=null)
        {
            assignList_tContextLoad_1.add(key_tContextLoad_1);
        }else  {
            newPropertyList_tContextLoad_1.add(key_tContextLoad_1);
        }
        if(value_tContextLoad_1 == null){
            context.setProperty(key_tContextLoad_1, "");
        }else{
            context.setProperty(key_tContextLoad_1,value_tContextLoad_1);
        }
    }catch(java.lang.Exception e){
globalMap.put("tContextLoad_1_ERROR_MESSAGE",e.getMessage());
            log.error("tContextLoad_1 - Setting a value for the key \"" + key_tContextLoad_1 + "\" has failed. Error message: " + e.getMessage());
        System.err.println("Setting a value for the key \"" + key_tContextLoad_1 + "\" has failed. Error message: " + e.getMessage());
    }
        nb_line_tContextLoad_1++;
    }
        //////////////////////////

 


	tos_count_tContextLoad_1++;

		

/**
 * [tContextLoad_1 main ] stop
 */

	
	/**
	 * [tContextLoad_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tContextLoad_1");
	
			
			
	
			cLabel="LoadContextToken";
		

 



		

/**
 * [tContextLoad_1 process_data_begin ] stop
 */

	
	/**
	 * [tContextLoad_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tContextLoad_1");
	
			
			
	
			cLabel="LoadContextToken";
		

 



		

/**
 * [tContextLoad_1 process_data_end ] stop
 */


} // End of branch "setToken"




	
	/**
	 * [tXMLMap_2_TXMLMAP_IN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_IN");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_IN";
		

 



		

/**
 * [tXMLMap_2_TXMLMAP_IN process_data_end ] stop
 */

	
	/**
	 * [tXMLMap_2_TXMLMAP_IN end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_IN");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_IN";
		

}//TD512
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_2_TXMLMAP_IN - "  + ("Done.") );

ok_Hash.put("tXMLMap_2_TXMLMAP_IN", true);
end_Hash.put("tXMLMap_2_TXMLMAP_IN", System.currentTimeMillis());




		

/**
 * [tXMLMap_2_TXMLMAP_IN end ] stop
 */


	
	/**
	 * [tContextLoad_1 end ] start
	 */

	

	
	
	s(currentComponent="tContextLoad_1");
	
			
			
	
			cLabel="LoadContextToken";
		
	
	java.util.Enumeration<?> enu_tContextLoad_1 = context.propertyNames();
    while(enu_tContextLoad_1.hasMoreElements())
    {           
    	String key_tContextLoad_1 = (String)enu_tContextLoad_1.nextElement();
        if(!assignList_tContextLoad_1.contains(key_tContextLoad_1) && !newPropertyList_tContextLoad_1.contains(key_tContextLoad_1))
        {
            noAssignList_tContextLoad_1.add(key_tContextLoad_1);
        }          
    } 

    String newPropertyStr_tContextLoad_1 = newPropertyList_tContextLoad_1.toString();
    String newProperty_tContextLoad_1 = newPropertyStr_tContextLoad_1.substring(1, newPropertyStr_tContextLoad_1.length() - 1);
    
    String noAssignStr_tContextLoad_1 = noAssignList_tContextLoad_1.toString();
    String noAssign_tContextLoad_1 = noAssignStr_tContextLoad_1.substring(1, noAssignStr_tContextLoad_1.length() - 1);
    
    globalMap.put("tContextLoad_1_KEY_NOT_INCONTEXT", newProperty_tContextLoad_1);
    globalMap.put("tContextLoad_1_KEY_NOT_LOADED", noAssign_tContextLoad_1);

    globalMap.put("tContextLoad_1_NB_LINE",nb_line_tContextLoad_1);

	List<String> parametersToEncrypt_tContextLoad_1 = new java.util.ArrayList<String>();
	
		parametersToEncrypt_tContextLoad_1.add("Stewardship_Password");
		
	
	resumeUtil.addLog("NODE", "NODE:tContextLoad_1", "", Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt_tContextLoad_1));    
    	log.info("tContextLoad_1 - Loaded contexts count: " + nb_line_tContextLoad_1 + ".");
    
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"setToken",2,0,
				 			"tXMLMap_2_TXMLMAP_IN","ParseAuthResponse_TXMLMAP_IN","tXMLMapIn","tContextLoad_1","LoadContextToken","tContextLoad","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tContextLoad_1 - "  + ("Done.") );

ok_Hash.put("tContextLoad_1", true);
end_Hash.put("tContextLoad_1", System.currentTimeMillis());




		

/**
 * [tContextLoad_1 end ] stop
 */













				}//end the resume

				
				    			if(resumeEntryMethodName == null || globalResumeTicket){
				    				resumeUtil.addLog("CHECKPOINT", "CONNECTION:SUBJOB_OK:tFixedFlowInput_3:OnSubjobOk", "", Thread.currentThread().getId() + "", "", "", "", "", "");
								}	    				    			
					    	
							tFixedFlowInput_1Process(globalMap); 
						



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
							//free memory for "tXMLMap_2_TXMLMAP_IN"
							globalMap.remove("tXMLMap_2");
						
				try{
					
	
	/**
	 * [tFixedFlowInput_3 finally ] start
	 */

	

	
	
	s(currentComponent="tFixedFlowInput_3");
	
			
			
	
			cLabel="DefineInput";
		

 



		

/**
 * [tFixedFlowInput_3 finally ] stop
 */


	
	/**
	 * [tRESTClient_2 finally ] start
	 */

	

	
	
	s(currentComponent="tRESTClient_2");
	
			
			
	
			cLabel="GetAuthToken";
		

 



		

/**
 * [tRESTClient_2 finally ] stop
 */


	
	/**
	 * [tXMLMap_2_TXMLMAP_OUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_OUT");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_OUT";
		

 



		

/**
 * [tXMLMap_2_TXMLMAP_OUT finally ] stop
 */


	
	/**
	 * [tXMLMap_2_TXMLMAP_IN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_2";
	
	s(currentComponent="tXMLMap_2_TXMLMAP_IN");
	
			
			
	
			cLabel="ParseAuthResponse_TXMLMAP_IN";
		

 



		

/**
 * [tXMLMap_2_TXMLMAP_IN finally ] stop
 */


	
	/**
	 * [tContextLoad_1 finally ] start
	 */

	

	
	
	s(currentComponent="tContextLoad_1");
	
			
			
	
			cLabel="LoadContextToken";
		

 



		

/**
 * [tContextLoad_1 finally ] stop
 */













				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
				}
				resourceMap = null;
			}
		

		globalMap.put("tFixedFlowInput_3_SUBPROCESS_STATE", 1);
	}
	


public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	
			    public int Customer_Id;

				public int getCustomer_Id () {
					return this.Customer_Id;
				}

				public Boolean Customer_IdIsNullable(){
				    return false;
				}
				public Boolean Customer_IdIsKey(){
				    return false;
				}
				public Integer Customer_IdLength(){
				    return null;
				}
				public Integer Customer_IdPrecision(){
				    return null;
				}
				public String Customer_IdDefault(){
				
					return null;
				
				}
				public String Customer_IdComment(){
				
				    return "integer";
				
				}
				public String Customer_IdPattern(){
				
					return "";
				
				}
				public String Customer_IdOriginalDbColumnName(){
				
					return "Customer_Id";
				
				}

				
			    public String Reason;

				public String getReason () {
					return this.Reason;
				}

				public Boolean ReasonIsNullable(){
				    return false;
				}
				public Boolean ReasonIsKey(){
				    return false;
				}
				public Integer ReasonLength(){
				    return null;
				}
				public Integer ReasonPrecision(){
				    return null;
				}
				public String ReasonDefault(){
				
					return null;
				
				}
				public String ReasonComment(){
				
				    return "text";
				
				}
				public String ReasonPattern(){
				
					return "";
				
				}
				public String ReasonOriginalDbColumnName(){
				
					return "Reason";
				
				}

				
			    public String TDS_ID;

				public String getTDS_ID () {
					return this.TDS_ID;
				}

				public Boolean TDS_IDIsNullable(){
				    return false;
				}
				public Boolean TDS_IDIsKey(){
				    return false;
				}
				public Integer TDS_IDLength(){
				    return null;
				}
				public Integer TDS_IDPrecision(){
				    return null;
				}
				public String TDS_IDDefault(){
				
					return null;
				
				}
				public String TDS_IDComment(){
				
				    return "";
				
				}
				public String TDS_IDPattern(){
				
					return "";
				
				}
				public String TDS_IDOriginalDbColumnName(){
				
					return "TDS_ID";
				
				}

				
			    public String TDS_STATE;

				public String getTDS_STATE () {
					return this.TDS_STATE;
				}

				public Boolean TDS_STATEIsNullable(){
				    return false;
				}
				public Boolean TDS_STATEIsKey(){
				    return false;
				}
				public Integer TDS_STATELength(){
				    return null;
				}
				public Integer TDS_STATEPrecision(){
				    return null;
				}
				public String TDS_STATEDefault(){
				
					return null;
				
				}
				public String TDS_STATEComment(){
				
				    return "";
				
				}
				public String TDS_STATEPattern(){
				
					return "";
				
				}
				public String TDS_STATEOriginalDbColumnName(){
				
					return "TDS_STATE";
				
				}

				
			    public String TDS_ASSIGNEE;

				public String getTDS_ASSIGNEE () {
					return this.TDS_ASSIGNEE;
				}

				public Boolean TDS_ASSIGNEEIsNullable(){
				    return true;
				}
				public Boolean TDS_ASSIGNEEIsKey(){
				    return false;
				}
				public Integer TDS_ASSIGNEELength(){
				    return null;
				}
				public Integer TDS_ASSIGNEEPrecision(){
				    return null;
				}
				public String TDS_ASSIGNEEDefault(){
				
					return null;
				
				}
				public String TDS_ASSIGNEEComment(){
				
				    return "";
				
				}
				public String TDS_ASSIGNEEPattern(){
				
					return "";
				
				}
				public String TDS_ASSIGNEEOriginalDbColumnName(){
				
					return "TDS_ASSIGNEE";
				
				}

				
			    public long TDS_CREATION;

				public long getTDS_CREATION () {
					return this.TDS_CREATION;
				}

				public Boolean TDS_CREATIONIsNullable(){
				    return false;
				}
				public Boolean TDS_CREATIONIsKey(){
				    return false;
				}
				public Integer TDS_CREATIONLength(){
				    return null;
				}
				public Integer TDS_CREATIONPrecision(){
				    return null;
				}
				public String TDS_CREATIONDefault(){
				
					return null;
				
				}
				public String TDS_CREATIONComment(){
				
				    return "";
				
				}
				public String TDS_CREATIONPattern(){
				
					return "";
				
				}
				public String TDS_CREATIONOriginalDbColumnName(){
				
					return "TDS_CREATION";
				
				}

				
			    public long TDS_LAST_UPDATE;

				public long getTDS_LAST_UPDATE () {
					return this.TDS_LAST_UPDATE;
				}

				public Boolean TDS_LAST_UPDATEIsNullable(){
				    return false;
				}
				public Boolean TDS_LAST_UPDATEIsKey(){
				    return false;
				}
				public Integer TDS_LAST_UPDATELength(){
				    return null;
				}
				public Integer TDS_LAST_UPDATEPrecision(){
				    return null;
				}
				public String TDS_LAST_UPDATEDefault(){
				
					return null;
				
				}
				public String TDS_LAST_UPDATEComment(){
				
				    return "";
				
				}
				public String TDS_LAST_UPDATEPattern(){
				
					return "";
				
				}
				public String TDS_LAST_UPDATEOriginalDbColumnName(){
				
					return "TDS_LAST_UPDATE";
				
				}

				
			    public String TDS_LAST_UPDATED_BY;

				public String getTDS_LAST_UPDATED_BY () {
					return this.TDS_LAST_UPDATED_BY;
				}

				public Boolean TDS_LAST_UPDATED_BYIsNullable(){
				    return true;
				}
				public Boolean TDS_LAST_UPDATED_BYIsKey(){
				    return false;
				}
				public Integer TDS_LAST_UPDATED_BYLength(){
				    return null;
				}
				public Integer TDS_LAST_UPDATED_BYPrecision(){
				    return null;
				}
				public String TDS_LAST_UPDATED_BYDefault(){
				
					return null;
				
				}
				public String TDS_LAST_UPDATED_BYComment(){
				
				    return "";
				
				}
				public String TDS_LAST_UPDATED_BYPattern(){
				
					return "";
				
				}
				public String TDS_LAST_UPDATED_BYOriginalDbColumnName(){
				
					return "TDS_LAST_UPDATED_BY";
				
				}

				
			    public Integer TDS_PRIORITY;

				public Integer getTDS_PRIORITY () {
					return this.TDS_PRIORITY;
				}

				public Boolean TDS_PRIORITYIsNullable(){
				    return true;
				}
				public Boolean TDS_PRIORITYIsKey(){
				    return false;
				}
				public Integer TDS_PRIORITYLength(){
				    return null;
				}
				public Integer TDS_PRIORITYPrecision(){
				    return null;
				}
				public String TDS_PRIORITYDefault(){
				
					return null;
				
				}
				public String TDS_PRIORITYComment(){
				
				    return "";
				
				}
				public String TDS_PRIORITYPattern(){
				
					return "";
				
				}
				public String TDS_PRIORITYOriginalDbColumnName(){
				
					return "TDS_PRIORITY";
				
				}

				
			    public String TDS_TAGS;

				public String getTDS_TAGS () {
					return this.TDS_TAGS;
				}

				public Boolean TDS_TAGSIsNullable(){
				    return true;
				}
				public Boolean TDS_TAGSIsKey(){
				    return false;
				}
				public Integer TDS_TAGSLength(){
				    return null;
				}
				public Integer TDS_TAGSPrecision(){
				    return null;
				}
				public String TDS_TAGSDefault(){
				
					return null;
				
				}
				public String TDS_TAGSComment(){
				
				    return "";
				
				}
				public String TDS_TAGSPattern(){
				
					return "";
				
				}
				public String TDS_TAGSOriginalDbColumnName(){
				
					return "TDS_TAGS";
				
				}

				
			    public String TDS_ARBITRATION;

				public String getTDS_ARBITRATION () {
					return this.TDS_ARBITRATION;
				}

				public Boolean TDS_ARBITRATIONIsNullable(){
				    return true;
				}
				public Boolean TDS_ARBITRATIONIsKey(){
				    return false;
				}
				public Integer TDS_ARBITRATIONLength(){
				    return null;
				}
				public Integer TDS_ARBITRATIONPrecision(){
				    return null;
				}
				public String TDS_ARBITRATIONDefault(){
				
					return null;
				
				}
				public String TDS_ARBITRATIONComment(){
				
				    return "";
				
				}
				public String TDS_ARBITRATIONPattern(){
				
					return "";
				
				}
				public String TDS_ARBITRATIONOriginalDbColumnName(){
				
					return "TDS_ARBITRATION";
				
				}

				
			    public String TDS_ARBITRATION_LABEL;

				public String getTDS_ARBITRATION_LABEL () {
					return this.TDS_ARBITRATION_LABEL;
				}

				public Boolean TDS_ARBITRATION_LABELIsNullable(){
				    return true;
				}
				public Boolean TDS_ARBITRATION_LABELIsKey(){
				    return false;
				}
				public Integer TDS_ARBITRATION_LABELLength(){
				    return null;
				}
				public Integer TDS_ARBITRATION_LABELPrecision(){
				    return null;
				}
				public String TDS_ARBITRATION_LABELDefault(){
				
					return null;
				
				}
				public String TDS_ARBITRATION_LABELComment(){
				
				    return "";
				
				}
				public String TDS_ARBITRATION_LABELPattern(){
				
					return "";
				
				}
				public String TDS_ARBITRATION_LABELOriginalDbColumnName(){
				
					return "TDS_ARBITRATION_LABEL";
				
				}

				
			    public Long TDS_DUE_DATE;

				public Long getTDS_DUE_DATE () {
					return this.TDS_DUE_DATE;
				}

				public Boolean TDS_DUE_DATEIsNullable(){
				    return true;
				}
				public Boolean TDS_DUE_DATEIsKey(){
				    return false;
				}
				public Integer TDS_DUE_DATELength(){
				    return null;
				}
				public Integer TDS_DUE_DATEPrecision(){
				    return null;
				}
				public String TDS_DUE_DATEDefault(){
				
					return null;
				
				}
				public String TDS_DUE_DATEComment(){
				
				    return "";
				
				}
				public String TDS_DUE_DATEPattern(){
				
					return "";
				
				}
				public String TDS_DUE_DATEOriginalDbColumnName(){
				
					return "TDS_DUE_DATE";
				
				}

				
			    public String TDS_EXTERNAL_ID;

				public String getTDS_EXTERNAL_ID () {
					return this.TDS_EXTERNAL_ID;
				}

				public Boolean TDS_EXTERNAL_IDIsNullable(){
				    return true;
				}
				public Boolean TDS_EXTERNAL_IDIsKey(){
				    return false;
				}
				public Integer TDS_EXTERNAL_IDLength(){
				    return null;
				}
				public Integer TDS_EXTERNAL_IDPrecision(){
				    return null;
				}
				public String TDS_EXTERNAL_IDDefault(){
				
					return null;
				
				}
				public String TDS_EXTERNAL_IDComment(){
				
				    return "";
				
				}
				public String TDS_EXTERNAL_IDPattern(){
				
					return "";
				
				}
				public String TDS_EXTERNAL_IDOriginalDbColumnName(){
				
					return "TDS_EXTERNAL_ID";
				
				}

				



	private String readString(ObjectInputStream dis) throws IOException{
		String strReturn = null;
		int length = 0;
        length = dis.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}
	
	private String readString(org.jboss.marshalling.Unmarshaller unmarshaller) throws IOException{
		String strReturn = null;
		int length = 0;
        length = unmarshaller.readInt();
		if (length == -1) {
			strReturn = null;
		} else {
			if(length > commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy, 0, length, utf8Charset);
		}
		return strReturn;
	}

    private void writeString(String str, ObjectOutputStream dos) throws IOException{
		if(str == null) {
            dos.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
	    	dos.writeInt(byteArray.length);
			dos.write(byteArray);
    	}
    }
    
    private void writeString(String str, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(str == null) {
			marshaller.writeInt(-1);
		} else {
            byte[] byteArray = str.getBytes(utf8Charset);
            marshaller.writeInt(byteArray.length);
            marshaller.write(byteArray);
    	}
    }
	private Integer readInteger(ObjectInputStream dis) throws IOException{
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
	
	private Integer readInteger(org.jboss.marshalling.Unmarshaller dis) throws IOException{
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

	private void writeInteger(Integer intNum, ObjectOutputStream dos) throws IOException{
		if(intNum == null) {
            dos.writeByte(-1);
		} else {
			dos.writeByte(0);
	    	dos.writeInt(intNum);
    	}
	}
	
	private void writeInteger(Integer intNum, org.jboss.marshalling.Marshaller marshaller) throws IOException{
		if(intNum == null) {
			marshaller.writeByte(-1);
		} else {
			marshaller.writeByte(0);
			marshaller.writeInt(intNum);
    	}
	}

    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
			        this.Customer_Id = dis.readInt();
					
					this.Reason = readString(dis);
					
					this.TDS_ID = readString(dis);
					
					this.TDS_STATE = readString(dis);
					
					this.TDS_ASSIGNEE = readString(dis);
					
			        this.TDS_CREATION = dis.readLong();
					
			        this.TDS_LAST_UPDATE = dis.readLong();
					
					this.TDS_LAST_UPDATED_BY = readString(dis);
					
						this.TDS_PRIORITY = readInteger(dis);
					
					this.TDS_TAGS = readString(dis);
					
					this.TDS_ARBITRATION = readString(dis);
					
					this.TDS_ARBITRATION_LABEL = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TDS_DUE_DATE = null;
           				} else {
           			    	this.TDS_DUE_DATE = dis.readLong();
           				}
					
					this.TDS_EXTERNAL_ID = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		
			        this.Customer_Id = dis.readInt();
					
					this.Reason = readString(dis);
					
					this.TDS_ID = readString(dis);
					
					this.TDS_STATE = readString(dis);
					
					this.TDS_ASSIGNEE = readString(dis);
					
			        this.TDS_CREATION = dis.readLong();
					
			        this.TDS_LAST_UPDATE = dis.readLong();
					
					this.TDS_LAST_UPDATED_BY = readString(dis);
					
						this.TDS_PRIORITY = readInteger(dis);
					
					this.TDS_TAGS = readString(dis);
					
					this.TDS_ARBITRATION = readString(dis);
					
					this.TDS_ARBITRATION_LABEL = readString(dis);
					
			            length = dis.readByte();
           				if (length == -1) {
           	    			this.TDS_DUE_DATE = null;
           				} else {
           			    	this.TDS_DUE_DATE = dis.readLong();
           				}
					
					this.TDS_EXTERNAL_ID = readString(dis);
					
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
				
						writeString(this.Reason,dos);
					
					// String
				
						writeString(this.TDS_ID,dos);
					
					// String
				
						writeString(this.TDS_STATE,dos);
					
					// String
				
						writeString(this.TDS_ASSIGNEE,dos);
					
					// long
				
		            	dos.writeLong(this.TDS_CREATION);
					
					// long
				
		            	dos.writeLong(this.TDS_LAST_UPDATE);
					
					// String
				
						writeString(this.TDS_LAST_UPDATED_BY,dos);
					
					// Integer
				
						writeInteger(this.TDS_PRIORITY,dos);
					
					// String
				
						writeString(this.TDS_TAGS,dos);
					
					// String
				
						writeString(this.TDS_ARBITRATION,dos);
					
					// String
				
						writeString(this.TDS_ARBITRATION_LABEL,dos);
					
					// Long
				
						if(this.TDS_DUE_DATE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.TDS_DUE_DATE);
		            	}
					
					// String
				
						writeString(this.TDS_EXTERNAL_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.Customer_Id);
					
					// String
				
						writeString(this.Reason,dos);
					
					// String
				
						writeString(this.TDS_ID,dos);
					
					// String
				
						writeString(this.TDS_STATE,dos);
					
					// String
				
						writeString(this.TDS_ASSIGNEE,dos);
					
					// long
				
		            	dos.writeLong(this.TDS_CREATION);
					
					// long
				
		            	dos.writeLong(this.TDS_LAST_UPDATE);
					
					// String
				
						writeString(this.TDS_LAST_UPDATED_BY,dos);
					
					// Integer
				
						writeInteger(this.TDS_PRIORITY,dos);
					
					// String
				
						writeString(this.TDS_TAGS,dos);
					
					// String
				
						writeString(this.TDS_ARBITRATION,dos);
					
					// String
				
						writeString(this.TDS_ARBITRATION_LABEL,dos);
					
					// Long
				
						if(this.TDS_DUE_DATE == null) {
			                dos.writeByte(-1);
						} else {
               				dos.writeByte(0);
           			    	dos.writeLong(this.TDS_DUE_DATE);
		            	}
					
					// String
				
						writeString(this.TDS_EXTERNAL_ID,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("Customer_Id="+String.valueOf(Customer_Id));
		sb.append(",Reason="+Reason);
		sb.append(",TDS_ID="+TDS_ID);
		sb.append(",TDS_STATE="+TDS_STATE);
		sb.append(",TDS_ASSIGNEE="+TDS_ASSIGNEE);
		sb.append(",TDS_CREATION="+String.valueOf(TDS_CREATION));
		sb.append(",TDS_LAST_UPDATE="+String.valueOf(TDS_LAST_UPDATE));
		sb.append(",TDS_LAST_UPDATED_BY="+TDS_LAST_UPDATED_BY);
		sb.append(",TDS_PRIORITY="+String.valueOf(TDS_PRIORITY));
		sb.append(",TDS_TAGS="+TDS_TAGS);
		sb.append(",TDS_ARBITRATION="+TDS_ARBITRATION);
		sb.append(",TDS_ARBITRATION_LABEL="+TDS_ARBITRATION_LABEL);
		sb.append(",TDS_DUE_DATE="+String.valueOf(TDS_DUE_DATE));
		sb.append(",TDS_EXTERNAL_ID="+TDS_EXTERNAL_ID);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(Customer_Id);
        			
        			sb.append("|");
        		
        				if(Reason == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Reason);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_ID == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_ID);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_STATE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_STATE);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_ASSIGNEE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_ASSIGNEE);
            			}
            		
        			sb.append("|");
        		
        				sb.append(TDS_CREATION);
        			
        			sb.append("|");
        		
        				sb.append(TDS_LAST_UPDATE);
        			
        			sb.append("|");
        		
        				if(TDS_LAST_UPDATED_BY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_LAST_UPDATED_BY);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_PRIORITY == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_PRIORITY);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_TAGS == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_TAGS);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_ARBITRATION == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_ARBITRATION);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_ARBITRATION_LABEL == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_ARBITRATION_LABEL);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_DUE_DATE == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_DUE_DATE);
            			}
            		
        			sb.append("|");
        		
        				if(TDS_EXTERNAL_ID == null){
        					sb.append("<null>");
        				}else{
            				sb.append(TDS_EXTERNAL_ID);
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

public static class GetStewardStruct implements routines.system.IPersistableRow<GetStewardStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy = new byte[0];

	



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_Steward_Withdraw_Customers_Sending_Request_Copy) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
        }

			finally {}
		

    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
        }

			finally {}
		

    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(GetStewardStruct other) {

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

		mdc("tRESTRequest_1_Loop", "8u6Cw3_");

		String currentVirtualComponent = null;
	
		String iterateId = "";
	
	
	String currentComponent = "";
	s("none");
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;



		GetStewardStruct GetSteward = new GetStewardStruct();
row1Struct row1 = new row1Struct();



	
	/**
	 * [tRESTRequest_1_Loop begin ] start
	 */

				
			int NB_ITERATE_tRESTRequest_1_In = 0; //for statistics
			

	
		
		sh("tRESTRequest_1_Loop");
		
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	
		int tos_count_tRESTRequest_1_Loop = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTRequest_1_Loop", "tRESTRequest_1_Loop", "tRESTRequestLoop");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
						
						
						if(enableLogStash){
							runStat.log(iterateId,0,0,"GetSteward");
						}
						


					GetSteward = null;
			

	int nb_line_tRESTRequest_1 = 0;

	try {

		java.util.Map<String, Object> requestMessage_tRESTRequest_1 =
				(java.util.Map<String, Object>) globalMap.get("restRequest");

		restEndpoint = getRestEndpoint();

		if (null == requestMessage_tRESTRequest_1) {

			if (restTalendJobAlreadyStarted) {
				throw new RuntimeException("request is not provided");
			} else {
				if (!runInTalendEsbRuntimeContainer && null == thread4RestServiceProviderEndpoint) {
					String endpointUrl_tRESTRequest_1 = checkEndpointUrl(restEndpoint);
					// *** external thread for endpoint initialization
					thread4RestServiceProviderEndpoint = new Thread4RestServiceProviderEndpoint(this, endpointUrl_tRESTRequest_1);
					thread4RestServiceProviderEndpoint.start();
					// *** external thread for endpoint initialization
				}

				restTalendJobAlreadyStarted = true;

				if(runInDaemonMode){
					Thread.currentThread();
					try {
						while(true) {
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

        requestMessage_tRESTRequest_1.put("CURRENT_MESSAGE", org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage());

        Object ctx_tRESTRequest_1 = requestMessage_tRESTRequest_1.get("MESSAGE_CONTEXT");
        if (ctx_tRESTRequest_1 != null && ctx_tRESTRequest_1 instanceof org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext) {
            requestMessage_tRESTRequest_1.put("MESSAGE_CONTEXT", ((org.apache.cxf.jaxrs.impl.tl.ThreadLocalMessageContext)ctx_tRESTRequest_1).get());
        }

 



		

/**
 * [tRESTRequest_1_Loop begin ] stop
 */

	
	/**
	 * [tRESTRequest_1_Loop main ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	
				resourceMap.put("inIterateVComp", true);
			

 


	tos_count_tRESTRequest_1_Loop++;

		

/**
 * [tRESTRequest_1_Loop main ] stop
 */

	
	/**
	 * [tRESTRequest_1_Loop process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	

 



		

/**
 * [tRESTRequest_1_Loop process_data_begin ] stop
 */

	NB_ITERATE_tRESTRequest_1_In++;
	
	


	
	/**
	 * [tFlowToIterate_4 begin ] start
	 */

				
			int NB_ITERATE_tDataStewardshipTaskInput_1 = 0; //for statistics
			

	
		
		sh("tFlowToIterate_4");
		
	
	s(currentComponent="tFlowToIterate_4");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"GetSteward");
					}
				
		int tos_count_tFlowToIterate_4 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_4 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFlowToIterate_4{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFlowToIterate_4 = new StringBuilder();
                    log4jParamters_tFlowToIterate_4.append("Parameters:");
                            log4jParamters_tFlowToIterate_4.append("DEFAULT_MAP" + " = " + "true");
                        log4jParamters_tFlowToIterate_4.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_4 - "  + (log4jParamters_tFlowToIterate_4) );
                    } 
                } 
            new BytesLimit65535_tFlowToIterate_4().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tFlowToIterate_4", "tFlowToIterate_2", "tFlowToIterate");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

int nb_line_tFlowToIterate_4 = 0;
int counter_tFlowToIterate_4 = 0;

 



		

/**
 * [tFlowToIterate_4 begin ] stop
 */




	
	/**
	 * [tRESTRequest_1_In begin ] start
	 */

	

	
		
		sh("tRESTRequest_1_In");
		
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	
		int tos_count_tRESTRequest_1_In = 0;
		
			if(enableLogStash) {
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
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	

		if (requestMessage_tRESTRequest_1.containsKey("ERROR")) { // wrong request received
						GetSteward = null;
		} else { // non-error (not wrong request)

			String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
			String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

			java.util.Map<String, Object> params_tRESTRequest_1 =
				(java.util.Map<String, Object>) requestMessage_tRESTRequest_1.get("PARAMS");
					if (matchedFlow_tRESTRequest_1.equals("GetSteward")) {
						GetSteward = new GetStewardStruct();
					} else { // non matched flow
						GetSteward = null;
					}
				
		}

		globalMap.put("tRESTRequest_1_URI", (String) requestMessage_tRESTRequest_1.get("URI"));
		globalMap.put("tRESTRequest_1_URI_BASE", (String) requestMessage_tRESTRequest_1.get("URI_BASE"));
		globalMap.put("tRESTRequest_1_URI_ABSOLUTE", (String) requestMessage_tRESTRequest_1.get("URI_ABSOLUTE"));
		globalMap.put("tRESTRequest_1_URI_REQUEST", (String) requestMessage_tRESTRequest_1.get("URI_REQUEST"));
		globalMap.put("tRESTRequest_1_HTTP_METHOD", (String) requestMessage_tRESTRequest_1.get("VERB"));

		globalMap.put("tRESTRequest_1_ATTACHMENT_HEADERS", requestMessage_tRESTRequest_1.get("ATTACHMENT_HEADERS"));
		globalMap.put("tRESTRequest_1_ATTACHMENT_FILENAMES", requestMessage_tRESTRequest_1.get("ATTACHMENT_FILENAMES"));

		globalMap.put("tRESTRequest_1_PRINCIPAL_NAME", (String) requestMessage_tRESTRequest_1.get("PRINCIPAL_NAME"));
		globalMap.put("tRESTRequest_1_CORRELATION_ID", (String) requestMessage_tRESTRequest_1.get("CorrelationID"));

 


	tos_count_tRESTRequest_1_In++;

		

/**
 * [tRESTRequest_1_In main ] stop
 */

	
	/**
	 * [tRESTRequest_1_In process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	

 



		

/**
 * [tRESTRequest_1_In process_data_begin ] stop
 */

// Start of branch "GetSteward"
if(GetSteward != null) { 



	
	/**
	 * [tFlowToIterate_4 main ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_4");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"GetSteward","tRESTRequest_1_In","tRESTRequest_1_In","tRESTRequestIn","tFlowToIterate_4","tFlowToIterate_2","tFlowToIterate"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("GetSteward - " + (GetSteward==null? "": GetSteward.toLogString()));
    			}
    		


    	
 
	   nb_line_tFlowToIterate_4++;  
       counter_tFlowToIterate_4++;
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_4 - "  + ("Current iteration is: ")  + (counter_tFlowToIterate_4)  + (".") );
       globalMap.put("tFlowToIterate_4_CURRENT_ITERATION", counter_tFlowToIterate_4);
 


	tos_count_tFlowToIterate_4++;

		

/**
 * [tFlowToIterate_4 main ] stop
 */

	
	/**
	 * [tFlowToIterate_4 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_4");
	
			
		
		
					if (GetSteward != null) {
		
		
	

 



	
	
				}
		

/**
 * [tFlowToIterate_4 process_data_begin ] stop
 */

	NB_ITERATE_tDataStewardshipTaskInput_1++;
	
	


	
	/**
	 * [tFlowToIterate_2 begin ] start
	 */

				
			int NB_ITERATE_tJava_2 = 0; //for statistics
			

	
		
		sh("tFlowToIterate_2");
		
	
	s(currentComponent="tFlowToIterate_2");
	
			
			
	
			cLabel="FlowToIterate_Delete";
		
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"row1");
					}
				
		int tos_count_tFlowToIterate_2 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_2 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tFlowToIterate_2{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tFlowToIterate_2 = new StringBuilder();
                    log4jParamters_tFlowToIterate_2.append("Parameters:");
                            log4jParamters_tFlowToIterate_2.append("DEFAULT_MAP" + " = " + "true");
                        log4jParamters_tFlowToIterate_2.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_2 - "  + (log4jParamters_tFlowToIterate_2) );
                    } 
                } 
            new BytesLimit65535_tFlowToIterate_2().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tFlowToIterate_2", "FlowToIterate_Delete", "tFlowToIterate");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

int nb_line_tFlowToIterate_2 = 0;
int counter_tFlowToIterate_2 = 0;

 



		

/**
 * [tFlowToIterate_2 begin ] stop
 */




	
	/**
	 * [tDataStewardshipTaskInput_1 begin ] start
	 */

	

	
		
		sh("tDataStewardshipTaskInput_1");
		
	
	s(currentComponent="tDataStewardshipTaskInput_1");
	
			
			
	
		int tos_count_tDataStewardshipTaskInput_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tDataStewardshipTaskInput_1", "tDataStewardshipTaskInput_1", "tDataStewardshipTaskInput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

boolean doesNodeBelongToRequest_tDataStewardshipTaskInput_1 = 1 == 0;
@SuppressWarnings("unchecked")
java.util.Map<String, Object> restRequest_tDataStewardshipTaskInput_1 = (java.util.Map<String, Object>)globalMap.get("restRequest");
String currentTRestRequestOperation_tDataStewardshipTaskInput_1 = (String)(restRequest_tDataStewardshipTaskInput_1 != null ? restRequest_tDataStewardshipTaskInput_1.get("OPERATION") : null);
        if("GetSteward".equals(currentTRestRequestOperation_tDataStewardshipTaskInput_1)) {
            doesNodeBelongToRequest_tDataStewardshipTaskInput_1 = true;
        }
	

org.talend.components.api.component.ComponentDefinition def_tDataStewardshipTaskInput_1 =
        new org.talend.components.datastewardship.tdatastewardshiptaskinput.TDataStewardshipTaskInputDefinition();

org.talend.components.api.component.runtime.Writer writer_tDataStewardshipTaskInput_1 = null;
org.talend.components.api.component.runtime.Reader reader_tDataStewardshipTaskInput_1 = null;


org.talend.components.datastewardship.tdatastewardshiptaskinput.TDataStewardshipTaskInputProperties props_tDataStewardshipTaskInput_1 =
        (org.talend.components.datastewardship.tdatastewardshiptaskinput.TDataStewardshipTaskInputProperties) def_tDataStewardshipTaskInput_1.createRuntimeProperties();
 		                    props_tDataStewardshipTaskInput_1.setValue("batchSize",
 		                    50);
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("consumeTasks",
 		                    false);
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("paginationWithID",
 		                    false);
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("retryOnTimeout",
 		                    2);
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("searchQuery",
 		                    "");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("campaignName",
 		                    "c9d5dbce7d87cede9e0224bb3a48ca1d7");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("campaignLabel",
 		                    "Withdraw");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("campaignType",
 		                        org.talend.components.datastewardship.common.CampaignType.ARBITRATION);
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("laxSchema",
 		                    false);
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("taskPriority",
 		                    "ANY_PRIORITY");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("taskTags",
 		                    "");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("taskState",
 		                    "Resolved");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("taskAssignee",
 		                    "No Assignee");
 		                    
 		                    props_tDataStewardshipTaskInput_1.setValue("arbitrationChoice",
 		                    "ANY_CHOICE");
 		                    
 		                    java.util.List<Object> tDataStewardshipTaskInput_1_httpConfig_keys = new java.util.ArrayList<Object>();
 		                    
 		                    ((org.talend.daikon.properties.Properties)props_tDataStewardshipTaskInput_1.httpConfig).setValue("keys",tDataStewardshipTaskInput_1_httpConfig_keys);
 		                    
 		                    java.util.List<Object> tDataStewardshipTaskInput_1_httpConfig_values = new java.util.ArrayList<Object>();
 		                    
 		                    ((org.talend.daikon.properties.Properties)props_tDataStewardshipTaskInput_1.httpConfig).setValue("values",tDataStewardshipTaskInput_1_httpConfig_values);
 		                    
 		                    class SchemaSettingTool_tDataStewardshipTaskInput_1_1_fisrt {
 		                    		
 		                    		String getSchemaValue() {
 		                    				
 		                    						StringBuilder s = new StringBuilder();
                    						
     		                    						a("{\"type\":\"record\",",s);
     		                    						
     		                    						a("\"name\":\"main\",\"fields\":[{",s);
     		                    						
     		                    						a("\"name\":\"Customer_Id\",\"type\":\"int\",\"di.table.comment\":\"integer\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Customer_Id\"},{",s);
     		                    						
     		                    						a("\"name\":\"Reason\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Reason\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_ID\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_ID\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_STATE\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_STATE\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_ASSIGNEE\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_ASSIGNEE\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_CREATION\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_CREATION\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_LAST_UPDATE\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"TDS_LAST_UPDATE\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_LAST_UPDATED_BY\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_LAST_UPDATED_BY\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_PRIORITY\",\"type\":\"int\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_PRIORITY\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_TAGS\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_TAGS\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_ARBITRATION\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_ARBITRATION\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_ARBITRATION_LABEL\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_ARBITRATION_LABEL\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_DUE_DATE\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_DUE_DATE\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_EXTERNAL_ID\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_EXTERNAL_ID\"}]}",s);
     		                    						
     		                    				return s.toString();
     		                    		
 		                    		}
 		                    		
 		                    		void a(String part, StringBuilder strB) {
 		                    				strB.append(part);
 		                    		}
 		                    		
 		                    }
 		                    
 		                    SchemaSettingTool_tDataStewardshipTaskInput_1_1_fisrt sst_tDataStewardshipTaskInput_1_1_fisrt = new SchemaSettingTool_tDataStewardshipTaskInput_1_1_fisrt();
 		                    
 		                    props_tDataStewardshipTaskInput_1.schema.setValue("schema",
 		                        new org.apache.avro.Schema.Parser().setValidateDefaults(false).parse(sst_tDataStewardshipTaskInput_1_1_fisrt.getSchemaValue()));
 		                    
 		                    props_tDataStewardshipTaskInput_1.connection.setValue("url",
 		                    context.Stewardship_URL);
 		                    
 		                    props_tDataStewardshipTaskInput_1.connection.setValue("username",
 		                    context.Stewardship_UserName);
 		                    
 		                    props_tDataStewardshipTaskInput_1.connection.setValue("password",
 		                    context.Stewardship_Password);
 		                    
 		                    props_tDataStewardshipTaskInput_1.connection.refConnection.setValue("referenceDefinitionName",
 		                    "datastewardship");
 		                    
    if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_tDataStewardshipTaskInput_1.connection.refConnection.referenceType.getValue()) {
        final String referencedComponentInstanceId_tDataStewardshipTaskInput_1 = props_tDataStewardshipTaskInput_1.connection.refConnection.componentInstanceId.getStringValue();
        if (referencedComponentInstanceId_tDataStewardshipTaskInput_1 != null) {
            org.talend.daikon.properties.Properties referencedComponentProperties_tDataStewardshipTaskInput_1 = (org.talend.daikon.properties.Properties) globalMap.get(
                referencedComponentInstanceId_tDataStewardshipTaskInput_1 + "_COMPONENT_RUNTIME_PROPERTIES");
            props_tDataStewardshipTaskInput_1.connection.refConnection.setReference(referencedComponentProperties_tDataStewardshipTaskInput_1);
        }
    }
globalMap.put("tDataStewardshipTaskInput_1_COMPONENT_RUNTIME_PROPERTIES", props_tDataStewardshipTaskInput_1);
globalMap.putIfAbsent("TALEND_PRODUCT_VERSION", "8.0");
globalMap.put("TALEND_COMPONENTS_VERSION", "0.37.46");
java.net.URL mappings_url_tDataStewardshipTaskInput_1= this.getClass().getResource("/xmlMappings");
globalMap.put("tDataStewardshipTaskInput_1_MAPPINGS_URL", mappings_url_tDataStewardshipTaskInput_1);

org.talend.components.api.container.RuntimeContainer container_tDataStewardshipTaskInput_1 = new org.talend.components.api.container.RuntimeContainer() {
    public Object getComponentData(String componentId, String key) {
        return globalMap.get(componentId + "_" + key);
    }

    public void setComponentData(String componentId, String key, Object data) {
        globalMap.put(componentId + "_" + key, data);
    }

    public String getCurrentComponentId() {
        return "tDataStewardshipTaskInput_1";
    }

    public Object getGlobalData(String key) {
    	return globalMap.get(key);
    }
};

int nb_line_tDataStewardshipTaskInput_1 = 0;

org.talend.components.api.component.ConnectorTopology topology_tDataStewardshipTaskInput_1 = null;
topology_tDataStewardshipTaskInput_1 = org.talend.components.api.component.ConnectorTopology.OUTGOING;

org.talend.daikon.runtime.RuntimeInfo runtime_info_tDataStewardshipTaskInput_1 = def_tDataStewardshipTaskInput_1.getRuntimeInfo(
    org.talend.components.api.component.runtime.ExecutionEngine.DI, props_tDataStewardshipTaskInput_1, topology_tDataStewardshipTaskInput_1);
java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_tDataStewardshipTaskInput_1 = def_tDataStewardshipTaskInput_1.getSupportedConnectorTopologies();

org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_tDataStewardshipTaskInput_1 = (org.talend.components.api.component.runtime.RuntimableRuntime)(Class.forName(runtime_info_tDataStewardshipTaskInput_1.getRuntimeClassName()).newInstance());
org.talend.daikon.properties.ValidationResult initVr_tDataStewardshipTaskInput_1 = componentRuntime_tDataStewardshipTaskInput_1.initialize(container_tDataStewardshipTaskInput_1, props_tDataStewardshipTaskInput_1);

if (initVr_tDataStewardshipTaskInput_1.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {
    throw new RuntimeException(initVr_tDataStewardshipTaskInput_1.getMessage());
}

if(componentRuntime_tDataStewardshipTaskInput_1 instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {
	org.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_tDataStewardshipTaskInput_1 = (org.talend.components.api.component.runtime.ComponentDriverInitialization)componentRuntime_tDataStewardshipTaskInput_1;
	compDriverInitialization_tDataStewardshipTaskInput_1.runAtDriver(container_tDataStewardshipTaskInput_1);
}

org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_tDataStewardshipTaskInput_1 = null;
if(componentRuntime_tDataStewardshipTaskInput_1 instanceof org.talend.components.api.component.runtime.SourceOrSink) {
	sourceOrSink_tDataStewardshipTaskInput_1 = (org.talend.components.api.component.runtime.SourceOrSink)componentRuntime_tDataStewardshipTaskInput_1;
	if (doesNodeBelongToRequest_tDataStewardshipTaskInput_1) {
        org.talend.daikon.properties.ValidationResult vr_tDataStewardshipTaskInput_1 = sourceOrSink_tDataStewardshipTaskInput_1.validate(container_tDataStewardshipTaskInput_1);
        if (vr_tDataStewardshipTaskInput_1.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {
            throw new RuntimeException(vr_tDataStewardshipTaskInput_1.getMessage());
        }
	}
}

    if (sourceOrSink_tDataStewardshipTaskInput_1 instanceof org.talend.components.api.component.runtime.Source) {
        org.talend.components.api.component.runtime.Source source_tDataStewardshipTaskInput_1 =
                (org.talend.components.api.component.runtime.Source)sourceOrSink_tDataStewardshipTaskInput_1;
        reader_tDataStewardshipTaskInput_1 = source_tDataStewardshipTaskInput_1.createReader(container_tDataStewardshipTaskInput_1);
	    reader_tDataStewardshipTaskInput_1 = new org.talend.codegen.flowvariables.runtime.FlowVariablesReader(reader_tDataStewardshipTaskInput_1, container_tDataStewardshipTaskInput_1);

            boolean multi_output_is_allowed_tDataStewardshipTaskInput_1 = false;
            org.talend.components.api.component.Connector c_tDataStewardshipTaskInput_1 = null;
            for (org.talend.components.api.component.Connector currentConnector : props_tDataStewardshipTaskInput_1.getAvailableConnectors(null, true)) {
                if (currentConnector.getName().equals("MAIN")) {
                    c_tDataStewardshipTaskInput_1 = currentConnector;
                }

                if (currentConnector.getName().equals("REJECT")) {//it's better to move the code to javajet
                    multi_output_is_allowed_tDataStewardshipTaskInput_1 = true;
                }
            }
            org.apache.avro.Schema schema_tDataStewardshipTaskInput_1 = props_tDataStewardshipTaskInput_1.getSchema(c_tDataStewardshipTaskInput_1, true);

        org.talend.codegen.enforcer.OutgoingSchemaEnforcer outgoingEnforcer_tDataStewardshipTaskInput_1 = org.talend.codegen.enforcer.EnforcerCreator.createOutgoingEnforcer(schema_tDataStewardshipTaskInput_1, false);

        // Create a reusable factory that converts the output of the reader to an IndexedRecord.
        org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord> factory_tDataStewardshipTaskInput_1 = null;

        // Iterate through the incoming data.
        boolean available_tDataStewardshipTaskInput_1 = reader_tDataStewardshipTaskInput_1.start();

        resourceMap.put("reader_tDataStewardshipTaskInput_1", reader_tDataStewardshipTaskInput_1);

        for (; available_tDataStewardshipTaskInput_1; available_tDataStewardshipTaskInput_1 = reader_tDataStewardshipTaskInput_1.advance()) {
			nb_line_tDataStewardshipTaskInput_1++;

			
			if (multi_output_is_allowed_tDataStewardshipTaskInput_1) {
				
					row1 = null;
				

				
			}
			

			try {
				Object data_tDataStewardshipTaskInput_1 = reader_tDataStewardshipTaskInput_1.getCurrent();
				

					if(multi_output_is_allowed_tDataStewardshipTaskInput_1) {
						row1 = new row1Struct();
					}

					
        // Construct the factory once when the first data arrives.
        if (factory_tDataStewardshipTaskInput_1 == null) {
            factory_tDataStewardshipTaskInput_1 = (org.talend.daikon.avro.converter.IndexedRecordConverter<Object, ? extends org.apache.avro.generic.IndexedRecord>)
                    new org.talend.daikon.avro.AvroRegistry()
                            .createIndexedRecordConverter(data_tDataStewardshipTaskInput_1.getClass());
        }

        // Enforce the outgoing schema on the input.
        outgoingEnforcer_tDataStewardshipTaskInput_1.setWrapped(factory_tDataStewardshipTaskInput_1.convertToAvro(data_tDataStewardshipTaskInput_1));
                Object columnValue_0_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(0);
                    if (columnValue_0_tDataStewardshipTaskInput_1 == null) {
                        row1.Customer_Id = 0;
                    } else {
                            row1.Customer_Id = (int) (columnValue_0_tDataStewardshipTaskInput_1);
                    }
                Object columnValue_1_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(1);
                        row1.Reason = (String) (columnValue_1_tDataStewardshipTaskInput_1);
                Object columnValue_2_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(2);
                        row1.TDS_ID = (String) (columnValue_2_tDataStewardshipTaskInput_1);
                Object columnValue_3_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(3);
                        row1.TDS_STATE = (String) (columnValue_3_tDataStewardshipTaskInput_1);
                Object columnValue_4_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(4);
                        row1.TDS_ASSIGNEE = (String) (columnValue_4_tDataStewardshipTaskInput_1);
                Object columnValue_5_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(5);
                    if (columnValue_5_tDataStewardshipTaskInput_1 == null) {
                        row1.TDS_CREATION = 0;
                    } else {
                            row1.TDS_CREATION = (long) (columnValue_5_tDataStewardshipTaskInput_1);
                    }
                Object columnValue_6_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(6);
                    if (columnValue_6_tDataStewardshipTaskInput_1 == null) {
                        row1.TDS_LAST_UPDATE = 0;
                    } else {
                            row1.TDS_LAST_UPDATE = (long) (columnValue_6_tDataStewardshipTaskInput_1);
                    }
                Object columnValue_7_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(7);
                        row1.TDS_LAST_UPDATED_BY = (String) (columnValue_7_tDataStewardshipTaskInput_1);
                Object columnValue_8_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(8);
                        row1.TDS_PRIORITY = (Integer) (columnValue_8_tDataStewardshipTaskInput_1);
                Object columnValue_9_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(9);
                        row1.TDS_TAGS = (String) (columnValue_9_tDataStewardshipTaskInput_1);
                Object columnValue_10_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(10);
                        row1.TDS_ARBITRATION = (String) (columnValue_10_tDataStewardshipTaskInput_1);
                Object columnValue_11_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(11);
                        row1.TDS_ARBITRATION_LABEL = (String) (columnValue_11_tDataStewardshipTaskInput_1);
                Object columnValue_12_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(12);
                        row1.TDS_DUE_DATE = (Long) (columnValue_12_tDataStewardshipTaskInput_1);
                Object columnValue_13_tDataStewardshipTaskInput_1 = outgoingEnforcer_tDataStewardshipTaskInput_1.get(13);
                        row1.TDS_EXTERNAL_ID = (String) (columnValue_13_tDataStewardshipTaskInput_1);
			} catch (org.talend.components.api.exception.DataRejectException e_tDataStewardshipTaskInput_1) {
				java.util.Map<String,Object> info_tDataStewardshipTaskInput_1 = e_tDataStewardshipTaskInput_1.getRejectInfo();
				
					//TODO use a method instead of getting method by the special key "error/errorMessage"
					Object errorMessage_tDataStewardshipTaskInput_1 = null;
					if(info_tDataStewardshipTaskInput_1.containsKey("error")){
						errorMessage_tDataStewardshipTaskInput_1 = info_tDataStewardshipTaskInput_1.get("error");
					}else if(info_tDataStewardshipTaskInput_1.containsKey("errorMessage")){
						errorMessage_tDataStewardshipTaskInput_1 = info_tDataStewardshipTaskInput_1.get("errorMessage");
					}else{
						errorMessage_tDataStewardshipTaskInput_1 = "Rejected but error message missing";
					}
					errorMessage_tDataStewardshipTaskInput_1 = "Row "+ nb_line_tDataStewardshipTaskInput_1 + ": "+errorMessage_tDataStewardshipTaskInput_1;
					System.err.println(errorMessage_tDataStewardshipTaskInput_1);
				
					// If the record is reject, the main line record should put NULL
					row1 = null;
				
			} // end of catch

                java.lang.Iterable<?> outgoingMainRecordsList_tDataStewardshipTaskInput_1 = new java.util.ArrayList<Object>();
                java.util.Iterator outgoingMainRecordsIt_tDataStewardshipTaskInput_1 = null;


 



		

/**
 * [tDataStewardshipTaskInput_1 begin ] stop
 */

	
	/**
	 * [tDataStewardshipTaskInput_1 main ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskInput_1");
	
			
			
	


 


	tos_count_tDataStewardshipTaskInput_1++;

		

/**
 * [tDataStewardshipTaskInput_1 main ] stop
 */

	
	/**
	 * [tDataStewardshipTaskInput_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskInput_1");
	
			
			
	


 



		

/**
 * [tDataStewardshipTaskInput_1 process_data_begin ] stop
 */


	
	/**
	 * [tFlowToIterate_2 main ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_2");
	
			
			
	
			cLabel="FlowToIterate_Delete";
		
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"row1","tDataStewardshipTaskInput_1","tDataStewardshipTaskInput_1","tDataStewardshipTaskInput","tFlowToIterate_2","FlowToIterate_Delete","tFlowToIterate"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		


    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.Customer_Id, value=")  + (row1.Customer_Id)  + (".") );            
            globalMap.put("row1.Customer_Id", row1.Customer_Id);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.Reason, value=")  + (row1.Reason)  + (".") );            
            globalMap.put("row1.Reason", row1.Reason);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_ID, value=")  + (row1.TDS_ID)  + (".") );            
            globalMap.put("row1.TDS_ID", row1.TDS_ID);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_STATE, value=")  + (row1.TDS_STATE)  + (".") );            
            globalMap.put("row1.TDS_STATE", row1.TDS_STATE);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_ASSIGNEE, value=")  + (row1.TDS_ASSIGNEE)  + (".") );            
            globalMap.put("row1.TDS_ASSIGNEE", row1.TDS_ASSIGNEE);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_CREATION, value=")  + (row1.TDS_CREATION)  + (".") );            
            globalMap.put("row1.TDS_CREATION", row1.TDS_CREATION);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_LAST_UPDATE, value=")  + (row1.TDS_LAST_UPDATE)  + (".") );            
            globalMap.put("row1.TDS_LAST_UPDATE", row1.TDS_LAST_UPDATE);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_LAST_UPDATED_BY, value=")  + (row1.TDS_LAST_UPDATED_BY)  + (".") );            
            globalMap.put("row1.TDS_LAST_UPDATED_BY", row1.TDS_LAST_UPDATED_BY);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_PRIORITY, value=")  + (row1.TDS_PRIORITY)  + (".") );            
            globalMap.put("row1.TDS_PRIORITY", row1.TDS_PRIORITY);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_TAGS, value=")  + (row1.TDS_TAGS)  + (".") );            
            globalMap.put("row1.TDS_TAGS", row1.TDS_TAGS);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_ARBITRATION, value=")  + (row1.TDS_ARBITRATION)  + (".") );            
            globalMap.put("row1.TDS_ARBITRATION", row1.TDS_ARBITRATION);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_ARBITRATION_LABEL, value=")  + (row1.TDS_ARBITRATION_LABEL)  + (".") );            
            globalMap.put("row1.TDS_ARBITRATION_LABEL", row1.TDS_ARBITRATION_LABEL);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_DUE_DATE, value=")  + (row1.TDS_DUE_DATE)  + (".") );            
            globalMap.put("row1.TDS_DUE_DATE", row1.TDS_DUE_DATE);
    	
                if(log.isTraceEnabled())
            log.trace("tFlowToIterate_2 - "  + ("Set global var, key=row1.TDS_EXTERNAL_ID, value=")  + (row1.TDS_EXTERNAL_ID)  + (".") );            
            globalMap.put("row1.TDS_EXTERNAL_ID", row1.TDS_EXTERNAL_ID);
    	
 
	   nb_line_tFlowToIterate_2++;  
       counter_tFlowToIterate_2++;
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_2 - "  + ("Current iteration is: ")  + (counter_tFlowToIterate_2)  + (".") );
       globalMap.put("tFlowToIterate_2_CURRENT_ITERATION", counter_tFlowToIterate_2);
 


	tos_count_tFlowToIterate_2++;

		

/**
 * [tFlowToIterate_2 main ] stop
 */

	
	/**
	 * [tFlowToIterate_2 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_2");
	
			
		
		
		
	
			cLabel="FlowToIterate_Delete";
		

 



	
		

/**
 * [tFlowToIterate_2 process_data_begin ] stop
 */

	NB_ITERATE_tJava_2++;
	
	

	
	/**
	 * [tJava_2 begin ] start
	 */

	

	
		
		sh("tJava_2");
		
	
	s(currentComponent="tJava_2");
	
			
			
	
			cLabel="SetContextCustomerId";
		
		int tos_count_tJava_2 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tJava_2", "SetContextCustomerId", "tJava");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			


context.customerId =((Integer)globalMap.get("row1.Customer_Id"));
System.out.println(context.customerId);
 



		

/**
 * [tJava_2 begin ] stop
 */

	
	/**
	 * [tJava_2 main ] start
	 */

	

	
	
	s(currentComponent="tJava_2");
	
			
			
	
			cLabel="SetContextCustomerId";
		

 


	tos_count_tJava_2++;

		

/**
 * [tJava_2 main ] stop
 */

	
	/**
	 * [tJava_2 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tJava_2");
	
			
			
	
			cLabel="SetContextCustomerId";
		

 



		

/**
 * [tJava_2 process_data_begin ] stop
 */

	
	/**
	 * [tJava_2 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tJava_2");
	
			
			
	
			cLabel="SetContextCustomerId";
		

 



		

/**
 * [tJava_2 process_data_end ] stop
 */

	
	/**
	 * [tJava_2 end ] start
	 */

	

	
	
	s(currentComponent="tJava_2");
	
			
			
	
			cLabel="SetContextCustomerId";
		

 

ok_Hash.put("tJava_2", true);
end_Hash.put("tJava_2", System.currentTimeMillis());

				tFixedFlowInput_3Process(globalMap);



		

/**
 * [tJava_2 end ] stop
 */





	
	/**
	 * [tFlowToIterate_2 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_2");
	
			
		
		
		
	
			cLabel="FlowToIterate_Delete";
		

 



	
		

/**
 * [tFlowToIterate_2 process_data_end ] stop
 */




	
	/**
	 * [tDataStewardshipTaskInput_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskInput_1");
	
			
			
	


 



		

/**
 * [tDataStewardshipTaskInput_1 process_data_end ] stop
 */

	
	/**
	 * [tDataStewardshipTaskInput_1 end ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskInput_1");
	
			
			
	
// end of generic


resourceMap.put("finish_tDataStewardshipTaskInput_1", Boolean.TRUE);

    } // while  
    } // end of "if (sourceOrSink_tDataStewardshipTaskInput_1 instanceof ...Source)"
    java.util.Map<String, Object> resultMap_tDataStewardshipTaskInput_1 = null;
    if (reader_tDataStewardshipTaskInput_1 != null) {
        reader_tDataStewardshipTaskInput_1.close();
        resultMap_tDataStewardshipTaskInput_1 = reader_tDataStewardshipTaskInput_1.getReturnValues();
    }
if(resultMap_tDataStewardshipTaskInput_1!=null) {
	for(java.util.Map.Entry<String,Object> entry_tDataStewardshipTaskInput_1 : resultMap_tDataStewardshipTaskInput_1.entrySet()) {
		switch(entry_tDataStewardshipTaskInput_1.getKey()) {
		case org.talend.components.api.component.ComponentDefinition.RETURN_ERROR_MESSAGE :
			container_tDataStewardshipTaskInput_1.setComponentData("tDataStewardshipTaskInput_1", "ERROR_MESSAGE", entry_tDataStewardshipTaskInput_1.getValue());
			break;
		case org.talend.components.api.component.ComponentDefinition.RETURN_TOTAL_RECORD_COUNT :
			container_tDataStewardshipTaskInput_1.setComponentData("tDataStewardshipTaskInput_1", "NB_LINE", entry_tDataStewardshipTaskInput_1.getValue());
			break;
		case org.talend.components.api.component.ComponentDefinition.RETURN_SUCCESS_RECORD_COUNT :
			container_tDataStewardshipTaskInput_1.setComponentData("tDataStewardshipTaskInput_1", "NB_SUCCESS", entry_tDataStewardshipTaskInput_1.getValue());
			break;
		case org.talend.components.api.component.ComponentDefinition.RETURN_REJECT_RECORD_COUNT :
			container_tDataStewardshipTaskInput_1.setComponentData("tDataStewardshipTaskInput_1", "NB_REJECT", entry_tDataStewardshipTaskInput_1.getValue());
			break;
		default :
            StringBuilder studio_key_tDataStewardshipTaskInput_1 = new StringBuilder();
            for (int i_tDataStewardshipTaskInput_1 = 0; i_tDataStewardshipTaskInput_1 < entry_tDataStewardshipTaskInput_1.getKey().length(); i_tDataStewardshipTaskInput_1++) {
                char ch_tDataStewardshipTaskInput_1 = entry_tDataStewardshipTaskInput_1.getKey().charAt(i_tDataStewardshipTaskInput_1);
                if(Character.isUpperCase(ch_tDataStewardshipTaskInput_1) && i_tDataStewardshipTaskInput_1> 0) {
                	studio_key_tDataStewardshipTaskInput_1.append('_');
                }
                studio_key_tDataStewardshipTaskInput_1.append(ch_tDataStewardshipTaskInput_1);
            }
			container_tDataStewardshipTaskInput_1.setComponentData("tDataStewardshipTaskInput_1", studio_key_tDataStewardshipTaskInput_1.toString().toUpperCase(java.util.Locale.ENGLISH), entry_tDataStewardshipTaskInput_1.getValue());
			break;
		}
	}
}

 

ok_Hash.put("tDataStewardshipTaskInput_1", true);
end_Hash.put("tDataStewardshipTaskInput_1", System.currentTimeMillis());




		

/**
 * [tDataStewardshipTaskInput_1 end ] stop
 */


	
	/**
	 * [tFlowToIterate_2 end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_2");
	
			
		
		
		
	
			cLabel="FlowToIterate_Delete";
		

globalMap.put("tFlowToIterate_2_NB_LINE",nb_line_tFlowToIterate_2);
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row1",2,0,
				 			"tDataStewardshipTaskInput_1","tDataStewardshipTaskInput_1","tDataStewardshipTaskInput","tFlowToIterate_2","FlowToIterate_Delete","tFlowToIterate","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_2 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_2", true);
end_Hash.put("tFlowToIterate_2", System.currentTimeMillis());




	
		

/**
 * [tFlowToIterate_2 end ] stop
 */








	
	/**
	 * [tFlowToIterate_4 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_4");
	
			
		
		
					if (GetSteward != null) {
		
		
	

 



	
	
				}
		

/**
 * [tFlowToIterate_4 process_data_end ] stop
 */


} // End of branch "GetSteward"




	
	/**
	 * [tRESTRequest_1_In process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	

 



		

/**
 * [tRESTRequest_1_In process_data_end ] stop
 */

	
	/**
	 * [tRESTRequest_1_In end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	
						resourceMap.put("inIterateVComp", true);
					

 

ok_Hash.put("tRESTRequest_1_In", true);
end_Hash.put("tRESTRequest_1_In", System.currentTimeMillis());




		

/**
 * [tRESTRequest_1_In end ] stop
 */


	
	/**
	 * [tFlowToIterate_4 end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_4");
	
			
		
		
					if (GetSteward != null) {
		
		
	

globalMap.put("tFlowToIterate_4_NB_LINE",nb_line_tFlowToIterate_4);
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"GetSteward",2,0,
				 			"tRESTRequest_1_In","tRESTRequest_1_In","tRESTRequestIn","tFlowToIterate_4","tFlowToIterate_2","tFlowToIterate","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_4 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_4", true);
end_Hash.put("tFlowToIterate_4", System.currentTimeMillis());




	
	
				}
		

/**
 * [tFlowToIterate_4 end ] stop
 */








	
	/**
	 * [tRESTRequest_1_Loop process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	

 



		

/**
 * [tRESTRequest_1_Loop process_data_end ] stop
 */

	
	/**
	 * [tRESTRequest_1_Loop end ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	
				resourceMap.remove("inIterateVComp");
			
	} catch (Throwable e_tRESTRequest_1) {
        if (e_tRESTRequest_1 instanceof Exception) {
			new TalendException((Exception) e_tRESTRequest_1, currentComponent, globalMap).printStackTrace();
        } else {
			new TalendException(new RuntimeException (e_tRESTRequest_1), currentComponent, globalMap).printStackTrace();
       	}
		if(!globalMap.containsKey("restResponse")){
			java.util.Map<String, Object> restFault_tRESTRequest_1 = new java.util.HashMap<String, Object>();
			restFault_tRESTRequest_1.put("STATUS", 500);
			restFault_tRESTRequest_1.put("BODY", e_tRESTRequest_1.getMessage());
			globalMap.put("restResponse", restFault_tRESTRequest_1);
		}
		return;
	}
	nb_line_tRESTRequest_1++;
	globalMap.put("tRESTRequest_1_NB_LINE", nb_line_tRESTRequest_1);

				
				
				if(enableLogStash){
					runStat.log(iterateId,2,0,"GetSteward");
				}
				
 

ok_Hash.put("tRESTRequest_1_Loop", true);
end_Hash.put("tRESTRequest_1_Loop", System.currentTimeMillis());




		

/**
 * [tRESTRequest_1_Loop end ] stop
 */

				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
					te.setVirtualComponentName(currentVirtualComponent);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [tRESTRequest_1_Loop finally ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	

 



		

/**
 * [tRESTRequest_1_Loop finally ] stop
 */


	
	/**
	 * [tRESTRequest_1_In finally ] start
	 */

	

	
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	

 



		

/**
 * [tRESTRequest_1_In finally ] stop
 */


	
	/**
	 * [tFlowToIterate_4 finally ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_4");
	
			
			
	

 



		

/**
 * [tFlowToIterate_4 finally ] stop
 */


	
	/**
	 * [tDataStewardshipTaskInput_1 finally ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskInput_1");
	
			
			
	
// finally of generic


if(resourceMap.get("finish_tDataStewardshipTaskInput_1")==null){
    if(resourceMap.get("reader_tDataStewardshipTaskInput_1")!=null){
		try {
			((org.talend.components.api.component.runtime.Reader)resourceMap.get("reader_tDataStewardshipTaskInput_1")).close();
		} catch (java.io.IOException e_tDataStewardshipTaskInput_1) {
			String errorMessage_tDataStewardshipTaskInput_1 = "failed to release the resource in tDataStewardshipTaskInput_1 :" + e_tDataStewardshipTaskInput_1.getMessage();
			System.err.println(errorMessage_tDataStewardshipTaskInput_1);
		}
	}
}
 



		

/**
 * [tDataStewardshipTaskInput_1 finally ] stop
 */


	
	/**
	 * [tFlowToIterate_2 finally ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_2");
	
			
			
	
			cLabel="FlowToIterate_Delete";
		

 



		

/**
 * [tFlowToIterate_2 finally ] stop
 */


	
	/**
	 * [tJava_2 finally ] start
	 */

	

	
	
	s(currentComponent="tJava_2");
	
			
			
	
			cLabel="SetContextCustomerId";
		

 



		

/**
 * [tJava_2 finally ] stop
 */
















				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
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
	String cLabel =  null;
	java.util.Map<String, Object> resourceMap = new java.util.HashMap<String, Object>();

	try {
			// TDI-39566 avoid throwing an useless Exception
			boolean resumeIt = true;
			if (globalResumeTicket == false && resumeEntryMethodName != null) {
				String currentMethodName = new java.lang.Exception().getStackTrace()[0].getMethodName();
				resumeIt = resumeEntryMethodName.equals(currentMethodName);
			}
			if (resumeIt || globalResumeTicket) { //start the resume
				globalResumeTicket = true;





	
	/**
	 * [talendJobLog begin ] start
	 */

	

	
		
		sh("talendJobLog");
		
	
	s(currentComponent="talendJobLog");
	
			
			
	
		int tos_count_talendJobLog = 0;
		

	for (JobStructureCatcherUtils.JobStructureCatcherMessage jcm : talendJobLog.getMessages()) {
		org.talend.job.audit.JobContextBuilder builder_talendJobLog = org.talend.job.audit.JobContextBuilder.create().jobName(jcm.job_name).jobId(jcm.job_id).jobVersion(jcm.job_version)
			.custom("process_id", jcm.pid).custom("thread_id", jcm.tid).custom("pid", pid).custom("father_pid", fatherPid).custom("root_pid", rootPid);
		org.talend.logging.audit.Context log_context_talendJobLog = null;
		
		
		if(jcm.log_type == JobStructureCatcherUtils.LogType.PERFORMANCE){
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.sourceId(jcm.sourceId).sourceLabel(jcm.sourceLabel).sourceConnectorType(jcm.sourceComponentName)
				.targetId(jcm.targetId).targetLabel(jcm.targetLabel).targetConnectorType(jcm.targetComponentName)
				.connectionName(jcm.current_connector).rows(jcm.row_count).duration(duration).build();
			auditLogger_talendJobLog.flowExecution(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBSTART) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment).build();
			auditLogger_talendJobLog.jobstart(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBEND) {
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
		
			log_context_talendJobLog = builder_talendJobLog
				.timestamp(jcm.moment).duration(duration).status(jcm.status).build();
			auditLogger_talendJobLog.jobstop(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.RUNCOMPONENT) {
			log_context_talendJobLog = builder_talendJobLog.timestamp(jcm.moment)
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label).build();
			auditLogger_talendJobLog.runcomponent(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWINPUT) {//log current component input line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowInput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.FLOWOUTPUT) {//log current component output/reject line
			long timeMS = jcm.end_time - jcm.start_time;
			String duration = String.valueOf(timeMS);
			
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_name).connectorId(jcm.component_id).connectorLabel(jcm.component_label)
				.connectionName(jcm.current_connector).connectionType(jcm.current_connector_type)
				.rows(jcm.total_row_number).duration(duration).build();
			auditLogger_talendJobLog.flowOutput(log_context_talendJobLog);
		} else if(jcm.log_type == JobStructureCatcherUtils.LogType.JOBERROR) {
			java.lang.Exception e_talendJobLog = jcm.exception;
			if(e_talendJobLog!=null) {
				try(java.io.StringWriter sw_talendJobLog = new java.io.StringWriter();java.io.PrintWriter pw_talendJobLog = new java.io.PrintWriter(sw_talendJobLog)) {
					e_talendJobLog.printStackTrace(pw_talendJobLog);
					builder_talendJobLog.custom("stacktrace", sw_talendJobLog.getBuffer().substring(0,java.lang.Math.min(sw_talendJobLog.getBuffer().length(), 512)));
				}
			}

			if(jcm.extra_info!=null) {
				builder_talendJobLog.connectorId(jcm.component_id).custom("extra_info", jcm.extra_info);
			}
				
			log_context_talendJobLog = builder_talendJobLog
				.connectorType(jcm.component_id.substring(0, jcm.component_id.lastIndexOf('_')))
				.connectorId(jcm.component_id)
				.connectorLabel(jcm.component_label == null ? jcm.component_id : jcm.component_label).build();

			auditLogger_talendJobLog.exception(log_context_talendJobLog);
		}
		
		
		
	}

 



		

/**
 * [talendJobLog begin ] stop
 */

	
	/**
	 * [talendJobLog main ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 


	tos_count_talendJobLog++;

		

/**
 * [talendJobLog main ] stop
 */

	
	/**
	 * [talendJobLog process_data_begin ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog process_data_begin ] stop
 */

	
	/**
	 * [talendJobLog process_data_end ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog process_data_end ] stop
 */

	
	/**
	 * [talendJobLog end ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 

ok_Hash.put("talendJobLog", true);
end_Hash.put("talendJobLog", System.currentTimeMillis());




		

/**
 * [talendJobLog end ] stop
 */

				}//end the resume

				



	
			}catch(java.lang.Exception e){	
				
				    if(!(e instanceof TalendException)){
					   log.fatal(currentComponent + " " + e.getMessage(),e);
					}
				
				TalendException te = new TalendException(e, currentComponent, cLabel, globalMap);
				
				throw te;
			}catch(java.lang.Error error){	
				
				throw error;
			}finally{
				
				try{
					
	
	/**
	 * [talendJobLog finally ] start
	 */

	

	
	
	s(currentComponent="talendJobLog");
	
			
			
	

 



		

/**
 * [talendJobLog finally ] stop
 */

				}catch(java.lang.Exception e){	
					//ignore
				}catch(java.lang.Error error){
					//ignore
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
            java.util.Map<String,String> threadRunResultMap = new java.util.HashMap<String, String>();
            threadRunResultMap.put("errorCode", null);
            threadRunResultMap.put("status", "");
            return threadRunResultMap;
        };
    };


    protected PropertiesWithType context_param = new PropertiesWithType();
    public java.util.Map<String, Object> parentContextMap = new java.util.HashMap<String, Object>();

    public String status= "";
    
    private final org.talend.components.common.runtime.SharedConnectionsPool connectionPool = new org.talend.components.common.runtime.SharedConnectionsPool() {
        public java.sql.Connection getDBConnection(String dbDriver, String url, String userName, String password, String dbConnectionName)
            throws ClassNotFoundException, java.sql.SQLException {
            return SharedDBConnection.getDBConnection(dbDriver, url, userName, password, dbConnectionName);
        }

        public java.sql.Connection getDBConnection(String dbDriver, String url, String dbConnectionName)
            throws ClassNotFoundException, java.sql.SQLException {
            return SharedDBConnection.getDBConnection(dbDriver, url, dbConnectionName);
        }
        
        public java.sql.Connection getDBConnection(String dbConnectionName, java.util.function.Supplier<java.sql.Connection> provider)
            throws ClassNotFoundException, java.sql.SQLException {
            return SharedDBConnection.getDBConnection(dbConnectionName, provider);
        }
    };
    
    private static final String GLOBAL_CONNECTION_POOL_KEY = "GLOBAL_CONNECTION_POOL";
    
    {
    	globalMap.put(GLOBAL_CONNECTION_POOL_KEY, connectionPool);
    }
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final Batch_Steward_Withdraw_Customers_Sending_Request_Copy Batch_Steward_Withdraw_Customers_Sending_Request_CopyClass = new Batch_Steward_Withdraw_Customers_Sending_Request_Copy();

        int exitCode = Batch_Steward_Withdraw_Customers_Sending_Request_CopyClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'Batch_Steward_Withdraw_Customers_Sending_Request_Copy' - Done.");
	        }

        System.exit(exitCode);
    }
	

	
	
	private void getjobInfo() {
		final String TEMPLATE_PATH = "src/main/templates/jobInfo_template.properties";
		final String BUILD_PATH = "../jobInfo.properties";
		final String path = this.getClass().getResource("").getPath();
		if(path.lastIndexOf("target") > 0) {
			final java.io.File templateFile = new java.io.File(
					path.substring(0, path.lastIndexOf("target")).concat(TEMPLATE_PATH));
			if (templateFile.exists()) {
				readJobInfo(templateFile);
				return;
			}
		}
			readJobInfo(new java.io.File(BUILD_PATH));
	}

    private void readJobInfo(java.io.File jobInfoFile){
	
        if(jobInfoFile.exists()) {
            try (java.io.InputStream is = new java.io.FileInputStream(jobInfoFile)) {
            	jobInfo.load(is);
            } catch (IOException e) {
            	 
                log.debug("Read jobInfo.properties file fail: " + e.getMessage());
                
            }
        }
		log.info(String.format("Project name: %s\tJob name: %s\tGIT Commit ID: %s\tTalend Version: %s",
				projectName,jobName,jobInfo.getProperty("gitCommitId"), "8.0.1.20250521_1150-patch"));
		
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

	        if(!"".equals(log4jLevel)){
	        	
				
				
				if("trace".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.TRACE);
				}else if("debug".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.DEBUG);
				}else if("info".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.INFO);
				}else if("warn".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.WARN);
				}else if("error".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.ERROR);
				}else if("fatal".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.FATAL);
				}else if ("off".equalsIgnoreCase(log4jLevel)){
					org.apache.logging.log4j.core.config.Configurator.setLevel(log.getName(), org.apache.logging.log4j.Level.OFF);
				}
				org.apache.logging.log4j.core.config.Configurator.setLevel(org.apache.logging.log4j.LogManager.getRootLogger().getName(), log.getLevel());
				
			}

	        getjobInfo();
			log.info("TalendJob: 'Batch_Steward_Withdraw_Customers_Sending_Request_Copy' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_ICn_8FApEfC4ZuKDeZl3GA");
                org.slf4j.MDC.put("_compiledAtTimestamp","2025-06-26T09:47:22.043426Z");

                java.lang.management.RuntimeMXBean mx = java.lang.management.ManagementFactory.getRuntimeMXBean();
                String[] mxNameTable = mx.getName().split("@"); //$NON-NLS-1$
                if (mxNameTable.length == 2) {
                    org.slf4j.MDC.put("_systemPid", mxNameTable[0]);
                } else {
                    org.slf4j.MDC.put("_systemPid", String.valueOf(java.lang.Thread.currentThread().getId()));
                }

		
		
			if(enableLogStash) {
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

				System.getProperties().stringPropertyNames().stream()
					.filter(it -> it.startsWith("audit.logger."))
					.forEach(key -> properties_talendJobLog.setProperty(key.substring("audit.logger.".length()), System.getProperty(key)));

				
				
				
				org.apache.logging.log4j.core.config.Configurator.setLevel(properties_talendJobLog.getProperty("root.logger"), org.apache.logging.log4j.Level.DEBUG);
				
				auditLogger_talendJobLog = org.talend.job.audit.JobEventAuditLoggerFactory.createJobAuditLogger(properties_talendJobLog);
			}
		

        if(clientHost == null) {
            clientHost = defaultClientHost;
        }

        if(pid == null || "0".equals(pid)) {
            pid = TalendString.getAsciiRandomString(6);
        }

            org.slf4j.MDC.put("_pid", pid);

        if (rootPid==null) {
            rootPid = pid;
        }

            org.slf4j.MDC.put("_rootPid", rootPid);

        if (fatherPid==null) {
            fatherPid = pid;
        }else{
            isChildJob = true;
        }
            org.slf4j.MDC.put("_fatherPid", fatherPid);


        try {
            java.util.Dictionary<String, Object> jobProperties = null;
            if (inOSGi) {
                jobProperties = routines.system.BundleUtils.getJobProperties(jobName);
    
                if (jobProperties != null && jobProperties.get("context") != null) {
                    contextStr = (String)jobProperties.get("context");
                }

                if (jobProperties != null && jobProperties.get("taskExecutionId") != null) {
                    taskExecutionId = (String)jobProperties.get("taskExecutionId");
                }

                // extract ids from parent route
                if(null == taskExecutionId || taskExecutionId.isEmpty()){
                    for(String arg : args) {
                        if(arg.startsWith("--context_param")
                                && (arg.contains("taskExecutionId") || arg.contains("jobExecutionId"))){

                            String keyValue = arg.replace("--context_param", "");
                            String[] parts = keyValue.split("=");
                            String[] cleanParts = java.util.Arrays.stream(parts)
                                    .filter(s -> !s.isEmpty())
                                    .toArray(String[]::new);
                            if (cleanParts.length == 2) {
                                String key = cleanParts[0];
                                String value = cleanParts[1];
                                if ("taskExecutionId".equals(key.trim()) && null != value) {
                                    taskExecutionId = value.trim();
                                }else if ("jobExecutionId".equals(key.trim()) && null != value) {
                                    jobExecutionId = value.trim();
                                }
                            }
                        }
                    }
                }
            }

            // first load default key-value pairs from application.properties
            if(isStandaloneMS) {
                context.putAll(this.getDefaultProperties());
            }
            //call job/subjob with an existing context, like: --context=production. if without this parameter, there will use the default context instead.
            java.io.InputStream inContext = Batch_Steward_Withdraw_Customers_Sending_Request_Copy.class.getClassLoader().getResourceAsStream("dpdp/batch_steward_withdraw_customers_sending_request_copy_0_3/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Batch_Steward_Withdraw_Customers_Sending_Request_Copy.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
            }
            if (inContext != null) {
                try {
                    //defaultProps is in order to keep the original context value
                    if(context != null && context.isEmpty()) {
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
                    if(isStandaloneMS) {
                        // override context key-value pairs if provided using --context=contextName
                        defaultProps.load(inContext);
                        context.putAll(defaultProps);
                    }
                } finally {
                    inContext.close();
                }
            } else if (!isDefaultContext) {
                //print info and job continue to run, for case: context_param is not empty.
                System.err.println("Could not find the context " + contextStr);
            }
            // override key-value pairs if provided via --config.location=file1.file2 OR --config.additional-location=file1,file2
            if(isStandaloneMS) {
                context.putAll(this.getAdditionalProperties());
            }
            
            // override key-value pairs if provide via command line like --key1=value1,--key2=value2
            if(!context_param.isEmpty()) {
                context.putAll(context_param);
				//set types for params from parentJobs
				for (Object key: context_param.keySet()){
					String context_key = key.toString();
					String context_type = context_param.getContextType(context_key);
					context.setContextType(context_key, context_type);

				}
            }
            class ContextProcessing {
                private void processContext_0() {
                        context.setContextType("token", "id_String");
                        if(context.getStringValue("token") == null) {
                            context.token = null;
                        } else {
                            context.token=(String) context.getProperty("token");
                        }
                        context.setContextType("customerId", "id_Integer");
                        if(context.getStringValue("customerId") == null) {
                            context.customerId = null;
                        } else {
                            try{
                                context.customerId=routines.system.ParserUtils.parseTo_Integer (context.getProperty("customerId"));
                            } catch(NumberFormatException e){
                                log.warn(String.format("Null value will be used for context parameter %s: %s", "customerId", e.getMessage()));
                                context.customerId=null;
                            }
                        }
                        context.setContextType("Stewardship_Password", "id_Password");
                        if(context.getStringValue("Stewardship_Password") == null) {
                            context.Stewardship_Password = null;
                        } else {
                            String pwd_Stewardship_Password_value = context.getProperty("Stewardship_Password");
                            context.Stewardship_Password = null;
                            if(pwd_Stewardship_Password_value!=null) {
                                if(context_param.containsKey("Stewardship_Password")) {//no need to decrypt if it come from program argument or parent job runtime
                                    context.Stewardship_Password = pwd_Stewardship_Password_value;
                                } else if (!pwd_Stewardship_Password_value.isEmpty()) {
                                    try {
                                        context.Stewardship_Password = routines.system.PasswordEncryptUtil.decryptPassword(pwd_Stewardship_Password_value);
                                        context.put("Stewardship_Password",context.Stewardship_Password);
                                    } catch (java.lang.RuntimeException e) {
                                        //do nothing
                                    }
                                }
                            }
                        }
                        context.setContextType("Stewardship_URL", "id_String");
                        if(context.getStringValue("Stewardship_URL") == null) {
                            context.Stewardship_URL = null;
                        } else {
                            context.Stewardship_URL=(String) context.getProperty("Stewardship_URL");
                        }
                        context.setContextType("Stewardship_UserName", "id_String");
                        if(context.getStringValue("Stewardship_UserName") == null) {
                            context.Stewardship_UserName = null;
                        } else {
                            context.Stewardship_UserName=(String) context.getProperty("Stewardship_UserName");
                        }
                } 
                public void processAllContext() {
                        processContext_0();
                }
            }

            new ContextProcessing().processAllContext();
        } catch (java.io.IOException ie) {
            System.err.println("Could not load context "+contextStr);
            ie.printStackTrace();
        }

        // get context value from parent directly
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("token")) {
                context.token = (String) parentContextMap.get("token");
            }if (parentContextMap.containsKey("customerId")) {
                context.customerId = (Integer) parentContextMap.get("customerId");
            }if (parentContextMap.containsKey("Stewardship_Password")) {
                context.Stewardship_Password = (java.lang.String) parentContextMap.get("Stewardship_Password");
            }if (parentContextMap.containsKey("Stewardship_URL")) {
                context.Stewardship_URL = (String) parentContextMap.get("Stewardship_URL");
            }if (parentContextMap.containsKey("Stewardship_UserName")) {
                context.Stewardship_UserName = (String) parentContextMap.get("Stewardship_UserName");
            }
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
			parametersToEncrypt.add("Stewardship_Password");
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'Batch_Steward_Withdraw_Customers_Sending_Request_Copy' - Started.");
            java.util.Optional.ofNullable(org.slf4j.MDC.getCopyOfContextMap()).ifPresent(mdcInfo::putAll);




	
	    java.util.concurrent.ConcurrentHashMap<Object, Object> concurrentHashMap = new java.util.concurrent.ConcurrentHashMap<Object, Object>();
	    globalMap.put("concurrentHashMap", concurrentHashMap);
	

    long startUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
    long endUsedMemory = 0;
    long end = 0;

    startTime = System.currentTimeMillis();


this.globalResumeTicket = true;//to run tPreJob




		if(enableLogStash) {
	        talendJobLog.addJobStartMessage();
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }

this.globalResumeTicket = false;//to run others jobs

try {
errorCode = null;tRESTRequest_1_LoopProcess(globalMap);
if(!"failure".equals(status)) { status = "end"; }
}catch (TalendException e_tRESTRequest_1_Loop) {
globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", -1);

e_tRESTRequest_1_Loop.printStackTrace();

}

this.globalResumeTicket = true;//to run tPostJob




        end = System.currentTimeMillis();

        if (watch) {
            System.out.println((end-startTime)+" milliseconds");
        }

        endUsedMemory = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        if (false) {
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Batch_Steward_Withdraw_Customers_Sending_Request_Copy");
        }
		if(enableLogStash) {
	        talendJobLog.addJobEndMessage(startTime, end, status);
	        try {
	            talendJobLogProcess(globalMap);
	        } catch (java.lang.Exception e) {
	            e.printStackTrace();
	        }
        }



    

    int returnCode = 0;


    if(errorCode == null) {
         returnCode = status != null && status.equals("failure") ? 1 : 0;
    } else {
         returnCode = errorCode.intValue();
    }
    resumeUtil.addLog("JOB_ENDED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","" + returnCode,"","","");
    resumeUtil.flush();


        org.slf4j.MDC.remove("_subJobName");
        org.slf4j.MDC.remove("_subJobPid");
        org.slf4j.MDC.remove("_systemPid");
        log.info("TalendJob: 'Batch_Steward_Withdraw_Customers_Sending_Request_Copy' - Finished - status: " + status + " returnCode: " + returnCode );

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
                if (fatherPid==null) {
                    context_param.setContextType(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.setContextType(keyValue.substring(0, index), keyValue.substring(index + 1) );
                }

            }

		} else if (arg.startsWith("--context_param")) {
            String keyValue = arg.substring(16);
            int index = -1;
            if (keyValue != null && (index = keyValue.indexOf('=')) > -1) {
                if (fatherPid==null) {
                    context_param.put(keyValue.substring(0, index), replaceEscapeChars(keyValue.substring(index + 1)));
                } else { // the subjob won't escape the especial chars
                    context_param.put(keyValue.substring(0, index), keyValue.substring(index + 1) );
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
                    if ( (index = line.indexOf('=')) > -1) {
							if (line.startsWith("--context_param")) {
								if ("id_Password".equals(context_param.getContextType(line.substring(16, index)))) {
									context_param.put(line.substring(16, index), routines.system.PasswordEncryptUtil.decryptPassword(
											line.substring(index + 1)));
								} else {
									context_param.put(line.substring(16, index), line.substring(index + 1));
								}
							}else {//--context_type
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
		} else if (arg.startsWith("--audit.enabled") && arg.contains("=")) {//for trunjob call
		    final int equal = arg.indexOf('=');
			final String key = arg.substring("--".length(), equal);
			System.setProperty(key, arg.substring(equal + 1));
		}
    }
    
    private static final String NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY = "<TALEND_NULL>";

    private final String[][] escapeChars = {
        {"\\\\","\\"},{"\\n","\n"},{"\\'","\'"},{"\\r","\r"},
        {"\\f","\f"},{"\\b","\b"},{"\\t","\t"}
        };
    private String replaceEscapeChars (String keyValue) {

		if (keyValue == null || ("").equals(keyValue.trim())) {
			return keyValue;
		}

		StringBuilder result = new StringBuilder();
		int currIndex = 0;
		while (currIndex < keyValue.length()) {
			int index = -1;
			// judege if the left string includes escape chars
			for (String[] strArray : escapeChars) {
				index = keyValue.indexOf(strArray[0],currIndex);
				if (index>=0) {

					result.append(keyValue.substring(currIndex, index + strArray[0].length()).replace(strArray[0], strArray[1]));
					currIndex = index + strArray[0].length();
					break;
				}
			}
			// if the left string doesn't include escape chars, append the left into the result
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
 *     328092 characters generated by Talend Real-time Big Data Platform 
 *     on the 26 June 2025 at 3:17:22 pm IST
 ************************************************************************************************/