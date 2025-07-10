
package dpdp.deploy_test_0_1;

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
 





@SuppressWarnings("unused")

/**
 * Job: Deploy_Test Purpose: <br>
 * Description:  <br>
 * @author Patil, Chirag
 * @version 8.0.1.20250521_1150-patch
 * @status 
 */
public class Deploy_Test implements TalendJob {
	static {System.setProperty("TalendJob.log", "Deploy_Test.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Deploy_Test.class);
	

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
			
		}
		
		//if the stored or passed value is "<TALEND_NULL>" string, it mean null
		public String getStringValue(String key) {
			String origin_value = this.getProperty(key);
			if(NULL_VALUE_EXPRESSION_IN_COMMAND_STRING_FOR_CHILD_JOB_ONLY.equals(origin_value)) {
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
	private final String jobName = "Deploy_Test";
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
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_PHWY4FZpEfClzKBwPKe_HA", "0.1");
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
			Deploy_Test.this.exception = e;
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Deploy_Test.this, new Object[] { e , currentComponent, globalMap});
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

			public void tFlowToIterate_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDBInput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTResponse_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tRESTRequest_1_Loop_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
							tRESTRequest_1_In_error(exception, errorComponent, globalMap);
						
						}
					
			public void tRESTRequest_1_In_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void talendJobLog_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					talendJobLog_onSubJobError(exception, errorComponent, globalMap);
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
	return "test";
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

	private final Deploy_Test job;


	public RestServiceProviderImpl4TalendJob() {
		this.job = new Deploy_Test();
	}

	public RestServiceProviderImpl4TalendJob(Deploy_Test job) {
		this.job = job;
	}

	private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap, Deploy_Test job) {
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
            String taskExecutionId = Deploy_Test.taskExecutionId;
            String jobExecutionId = Deploy_Test.jobExecutionId;

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

	@jakarta.ws.rs.Path("/")
	@jakarta.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
	public jakarta.ws.rs.core.Response output1(
		
		
			) {
                List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();  
                if(requiredParameterWithNullValueList.size() > 0){
                    return handleWrongRequest(messageContext, 400, "400 Bad Request \n" + requiredParameterWithNullValueList.toString() + " in tRESTRequest_1:output1 " + (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));         
                }
		java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		request_tRESTRequest_1.put("VERB", "GET");
		request_tRESTRequest_1.put("OPERATION", "output1");
		request_tRESTRequest_1.put("PATTERN", "/");
	

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

	private final Deploy_Test job;

	private org.apache.cxf.endpoint.Server server;

	private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

	public Thread4RestServiceProviderEndpoint(Deploy_Test job, String endpointUrl) {
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
			java.io.InputStream inContext = Deploy_Test.class.getClassLoader()
					.getResourceAsStream("dpdp/deploy_test_0_1/contexts/" + currentContext  + ".properties");
			if (inContext == null) {
				inContext = Deploy_Test.class.getClassLoader()
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





	




public static class outputStruct implements routines.system.IPersistableRow<outputStruct> {
    final static byte[] commonByteArrayLock_DPDP_Deploy_Test = new byte[0];
    static byte[] commonByteArray_DPDP_Deploy_Test = new byte[0];

	
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

				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
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
		sb.append("body="+String.valueOf(body));
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
        		
        	return sb.toString();
        }

    /**
     * Compare keys
     */
    public int compareTo(outputStruct other) {

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
    final static byte[] commonByteArrayLock_DPDP_Deploy_Test = new byte[0];
    static byte[] commonByteArray_DPDP_Deploy_Test = new byte[0];

	
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

				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		
			} catch(ClassNotFoundException eCNFE) {
				 throw new RuntimeException(eCNFE);
		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		
						this.body = (routines.system.Document) dis.readObject();
					
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
		sb.append("body="+String.valueOf(body));
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

public static class row1Struct implements routines.system.IPersistableRow<row1Struct> {
    final static byte[] commonByteArrayLock_DPDP_Deploy_Test = new byte[0];
    static byte[] commonByteArray_DPDP_Deploy_Test = new byte[0];

	
			    public Integer ID;

				public Integer getID () {
					return this.ID;
				}

				public Boolean IDIsNullable(){
				    return true;
				}
				public Boolean IDIsKey(){
				    return false;
				}
				public Integer IDLength(){
				    return 10;
				}
				public Integer IDPrecision(){
				    return 0;
				}
				public String IDDefault(){
				
					return null;
				
				}
				public String IDComment(){
				
				    return "";
				
				}
				public String IDPattern(){
				
					return "";
				
				}
				public String IDOriginalDbColumnName(){
				
					return "ID";
				
				}

				
			    public String Date;

				public String getDate () {
					return this.Date;
				}

				public Boolean DateIsNullable(){
				    return true;
				}
				public Boolean DateIsKey(){
				    return false;
				}
				public Integer DateLength(){
				    return 65535;
				}
				public Integer DatePrecision(){
				    return 0;
				}
				public String DateDefault(){
				
					return null;
				
				}
				public String DateComment(){
				
				    return "";
				
				}
				public String DatePattern(){
				
					return "";
				
				}
				public String DateOriginalDbColumnName(){
				
					return "Date";
				
				}

				
			    public String Region;

				public String getRegion () {
					return this.Region;
				}

				public Boolean RegionIsNullable(){
				    return true;
				}
				public Boolean RegionIsKey(){
				    return false;
				}
				public Integer RegionLength(){
				    return 65535;
				}
				public Integer RegionPrecision(){
				    return 0;
				}
				public String RegionDefault(){
				
					return null;
				
				}
				public String RegionComment(){
				
				    return "";
				
				}
				public String RegionPattern(){
				
					return "";
				
				}
				public String RegionOriginalDbColumnName(){
				
					return "Region";
				
				}

				
			    public String ProductCode;

				public String getProductCode () {
					return this.ProductCode;
				}

				public Boolean ProductCodeIsNullable(){
				    return true;
				}
				public Boolean ProductCodeIsKey(){
				    return false;
				}
				public Integer ProductCodeLength(){
				    return 65535;
				}
				public Integer ProductCodePrecision(){
				    return 0;
				}
				public String ProductCodeDefault(){
				
					return null;
				
				}
				public String ProductCodeComment(){
				
				    return "";
				
				}
				public String ProductCodePattern(){
				
					return "";
				
				}
				public String ProductCodeOriginalDbColumnName(){
				
					return "ProductCode";
				
				}

				
			    public String Customer_Name;

				public String getCustomer_Name () {
					return this.Customer_Name;
				}

				public Boolean Customer_NameIsNullable(){
				    return true;
				}
				public Boolean Customer_NameIsKey(){
				    return false;
				}
				public Integer Customer_NameLength(){
				    return 65535;
				}
				public Integer Customer_NamePrecision(){
				    return 0;
				}
				public String Customer_NameDefault(){
				
					return null;
				
				}
				public String Customer_NameComment(){
				
				    return "";
				
				}
				public String Customer_NamePattern(){
				
					return "";
				
				}
				public String Customer_NameOriginalDbColumnName(){
				
					return "Customer Name";
				
				}

				
			    public String Address;

				public String getAddress () {
					return this.Address;
				}

				public Boolean AddressIsNullable(){
				    return true;
				}
				public Boolean AddressIsKey(){
				    return false;
				}
				public Integer AddressLength(){
				    return 65535;
				}
				public Integer AddressPrecision(){
				    return 0;
				}
				public String AddressDefault(){
				
					return null;
				
				}
				public String AddressComment(){
				
				    return "";
				
				}
				public String AddressPattern(){
				
					return "";
				
				}
				public String AddressOriginalDbColumnName(){
				
					return "Address";
				
				}

				
			    public String Comment;

				public String getComment () {
					return this.Comment;
				}

				public Boolean CommentIsNullable(){
				    return true;
				}
				public Boolean CommentIsKey(){
				    return false;
				}
				public Integer CommentLength(){
				    return 65535;
				}
				public Integer CommentPrecision(){
				    return 0;
				}
				public String CommentDefault(){
				
					return null;
				
				}
				public String CommentComment(){
				
				    return "";
				
				}
				public String CommentPattern(){
				
					return "";
				
				}
				public String CommentOriginalDbColumnName(){
				
					return "Comment";
				
				}

				
			    public String City;

				public String getCity () {
					return this.City;
				}

				public Boolean CityIsNullable(){
				    return true;
				}
				public Boolean CityIsKey(){
				    return false;
				}
				public Integer CityLength(){
				    return 65535;
				}
				public Integer CityPrecision(){
				    return 0;
				}
				public String CityDefault(){
				
					return null;
				
				}
				public String CityComment(){
				
				    return "";
				
				}
				public String CityPattern(){
				
					return "";
				
				}
				public String CityOriginalDbColumnName(){
				
					return "City";
				
				}

				
			    public String Address1;

				public String getAddress1 () {
					return this.Address1;
				}

				public Boolean Address1IsNullable(){
				    return true;
				}
				public Boolean Address1IsKey(){
				    return false;
				}
				public Integer Address1Length(){
				    return 65535;
				}
				public Integer Address1Precision(){
				    return 0;
				}
				public String Address1Default(){
				
					return null;
				
				}
				public String Address1Comment(){
				
				    return "";
				
				}
				public String Address1Pattern(){
				
					return "";
				
				}
				public String Address1OriginalDbColumnName(){
				
					return "Address1";
				
				}

				
			    public String Address2;

				public String getAddress2 () {
					return this.Address2;
				}

				public Boolean Address2IsNullable(){
				    return true;
				}
				public Boolean Address2IsKey(){
				    return false;
				}
				public Integer Address2Length(){
				    return 65535;
				}
				public Integer Address2Precision(){
				    return 0;
				}
				public String Address2Default(){
				
					return null;
				
				}
				public String Address2Comment(){
				
				    return "";
				
				}
				public String Address2Pattern(){
				
					return "";
				
				}
				public String Address2OriginalDbColumnName(){
				
					return "Address2";
				
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
			if(length > commonByteArray_DPDP_Deploy_Test.length) {
				if(length < 1024 && commonByteArray_DPDP_Deploy_Test.length == 0) {
   					commonByteArray_DPDP_Deploy_Test = new byte[1024];
				} else {
   					commonByteArray_DPDP_Deploy_Test = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Deploy_Test, 0, length);
			strReturn = new String(commonByteArray_DPDP_Deploy_Test, 0, length, utf8Charset);
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
			if(length > commonByteArray_DPDP_Deploy_Test.length) {
				if(length < 1024 && commonByteArray_DPDP_Deploy_Test.length == 0) {
   					commonByteArray_DPDP_Deploy_Test = new byte[1024];
				} else {
   					commonByteArray_DPDP_Deploy_Test = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Deploy_Test, 0, length);
			strReturn = new String(commonByteArray_DPDP_Deploy_Test, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		
						this.ID = readInteger(dis);
					
					this.Date = readString(dis);
					
					this.Region = readString(dis);
					
					this.ProductCode = readString(dis);
					
					this.Customer_Name = readString(dis);
					
					this.Address = readString(dis);
					
					this.Comment = readString(dis);
					
					this.City = readString(dis);
					
					this.Address1 = readString(dis);
					
					this.Address2 = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		
						this.ID = readInteger(dis);
					
					this.Date = readString(dis);
					
					this.Region = readString(dis);
					
					this.ProductCode = readString(dis);
					
					this.Customer_Name = readString(dis);
					
					this.Address = readString(dis);
					
					this.Comment = readString(dis);
					
					this.City = readString(dis);
					
					this.Address1 = readString(dis);
					
					this.Address2 = readString(dis);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// Integer
				
						writeInteger(this.ID,dos);
					
					// String
				
						writeString(this.Date,dos);
					
					// String
				
						writeString(this.Region,dos);
					
					// String
				
						writeString(this.ProductCode,dos);
					
					// String
				
						writeString(this.Customer_Name,dos);
					
					// String
				
						writeString(this.Address,dos);
					
					// String
				
						writeString(this.Comment,dos);
					
					// String
				
						writeString(this.City,dos);
					
					// String
				
						writeString(this.Address1,dos);
					
					// String
				
						writeString(this.Address2,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// Integer
				
						writeInteger(this.ID,dos);
					
					// String
				
						writeString(this.Date,dos);
					
					// String
				
						writeString(this.Region,dos);
					
					// String
				
						writeString(this.ProductCode,dos);
					
					// String
				
						writeString(this.Customer_Name,dos);
					
					// String
				
						writeString(this.Address,dos);
					
					// String
				
						writeString(this.Comment,dos);
					
					// String
				
						writeString(this.City,dos);
					
					// String
				
						writeString(this.Address1,dos);
					
					// String
				
						writeString(this.Address2,dos);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("ID="+String.valueOf(ID));
		sb.append(",Date="+Date);
		sb.append(",Region="+Region);
		sb.append(",ProductCode="+ProductCode);
		sb.append(",Customer_Name="+Customer_Name);
		sb.append(",Address="+Address);
		sb.append(",Comment="+Comment);
		sb.append(",City="+City);
		sb.append(",Address1="+Address1);
		sb.append(",Address2="+Address2);
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				if(ID == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ID);
            			}
            		
        			sb.append("|");
        		
        				if(Date == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Date);
            			}
            		
        			sb.append("|");
        		
        				if(Region == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Region);
            			}
            		
        			sb.append("|");
        		
        				if(ProductCode == null){
        					sb.append("<null>");
        				}else{
            				sb.append(ProductCode);
            			}
            		
        			sb.append("|");
        		
        				if(Customer_Name == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Customer_Name);
            			}
            		
        			sb.append("|");
        		
        				if(Address == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Address);
            			}
            		
        			sb.append("|");
        		
        				if(Comment == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Comment);
            			}
            		
        			sb.append("|");
        		
        				if(City == null){
        					sb.append("<null>");
        				}else{
            				sb.append(City);
            			}
            		
        			sb.append("|");
        		
        				if(Address1 == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Address1);
            			}
            		
        			sb.append("|");
        		
        				if(Address2 == null){
        					sb.append("<null>");
        				}else{
            				sb.append(Address2);
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

public static class output1Struct implements routines.system.IPersistableRow<output1Struct> {
    final static byte[] commonByteArrayLock_DPDP_Deploy_Test = new byte[0];
    static byte[] commonByteArray_DPDP_Deploy_Test = new byte[0];

	



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

        	try {

        		int length = 0;
		

		

        }

		
			finally {}
		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Deploy_Test) {

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
    public int compareTo(output1Struct other) {

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

		mdc("tRESTRequest_1_Loop", "umvNO9_");

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



		output1Struct output1 = new output1Struct();
row1Struct row1 = new row1Struct();
outputStruct output = new outputStruct();



	
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
							runStat.log(iterateId,0,0,"output1");
						}
						


					output1 = null;
			

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
	 * [tFlowToIterate_1 begin ] start
	 */

				
			int NB_ITERATE_tDBInput_1 = 0; //for statistics
			

	
		
		sh("tFlowToIterate_1");
		
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"output1");
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
				talendJobLog.addCM("tFlowToIterate_1", "tFlowToIterate_1", "tFlowToIterate");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

int nb_line_tFlowToIterate_1 = 0;
int counter_tFlowToIterate_1 = 0;

 



		

/**
 * [tFlowToIterate_1 begin ] stop
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
						output1 = null;
		} else { // non-error (not wrong request)

			String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
			String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

			java.util.Map<String, Object> params_tRESTRequest_1 =
				(java.util.Map<String, Object>) requestMessage_tRESTRequest_1.get("PARAMS");
					if (matchedFlow_tRESTRequest_1.equals("output1")) {
						output1 = new output1Struct();
					} else { // non matched flow
						output1 = null;
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

// Start of branch "output1"
if(output1 != null) { 



	
	/**
	 * [tFlowToIterate_1 main ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"output1","tRESTRequest_1_In","tRESTRequest_1_In","tRESTRequestIn","tFlowToIterate_1","tFlowToIterate_1","tFlowToIterate"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("output1 - " + (output1==null? "": output1.toLogString()));
    			}
    		


    	
 
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
	
			
		
		
					if (output1 != null) {
		
		
	

 



	
	
				}
		

/**
 * [tFlowToIterate_1 process_data_begin ] stop
 */

	NB_ITERATE_tDBInput_1++;
	
	


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT begin ] start
	 */

	

	
		
		sh("tXMLMap_1_TXMLMAP_OUT");
		
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"row1");
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
				talendJobLog.addCM("tXMLMap_1_TXMLMAP_OUT", "tXMLMap_1_TXMLMAP_OUT", "tXMLMapOut");
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
outputStruct output_tmp = new outputStruct();
outputStruct output_save = null;
//the aggregate variable
outputStruct output_aggregate = null;
int count_output_tXMLMap_1_TXMLMAP_OUT = 0;
//init the resultset for aggregate
java.util.List<Object> allOutsForAggregate_tXMLMap_1 = new java.util.ArrayList<Object>();
globalMap.put("allOutsForAggregate_tXMLMap_1",allOutsForAggregate_tXMLMap_1);
// ###############################
		int nb_line_tXMLMap_1_TXMLMAP_OUT = 0; 
	
    XML_API_tXMLMap_1_TXMLMAP_OUT xml_api_tXMLMap_1_TXMLMAP_OUT = new XML_API_tXMLMap_1_TXMLMAP_OUT();

	//the map store the previous value of aggregate columns
	java.util.Map<String,Object> aggregateCacheMap_tXMLMap_1_TXMLMAP_OUT = new java.util.HashMap<String,Object>();

class GenerateDocument_output {

	java.util.Map<String,Object> valueMap = null;
	
	routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(1);
	
	org.dom4j.Document doc = null;
	
	org.dom4j.Element root4Group = null;
	
	org.dom4j.io.OutputFormat format = null;
	
	java.util.List<java.util.List<String>> groupbyList = null;
	java.util.List<org.dom4j.Element> groupElementList = null;
	int order = 0;
	
	boolean isFirst = true;
	
	boolean	needRoot = true;
	
	String currentValue = null;

		org.dom4j.Element subTreeLoopParent0 = null;
		public boolean  subTreeLoop0 = false;
	
    public GenerateDocument_output() {
//    	this.treeNodeAPI = treeNodeAPI;
    	
    	valueMap = new java.util.HashMap<String,Object>();
    	
    	groupbyList =  new java.util.ArrayList<java.util.List<String>>();
		groupElementList = new java.util.ArrayList<org.dom4j.Element>();
    	
    	doc = org.dom4j.DocumentHelper.createDocument();
    	format = org.dom4j.io.OutputFormat.createPrettyPrint();
    	format.setTrimText(false);
    }
    
    public org.dom4j.Document getDocument(){
    	return this.doc;
    }
    
	//We generate the TreeNode_API object only if there is a document in the main input table.
    void generateElements(boolean isInnerJoin, row1Struct row1, Var__tXMLMap_1_TXMLMAP_OUT__Struct Var
	) {
	
	
	/*if(this.treeNodeAPI==null) {
		this.treeNodeAPI = treeNodeAPI;
	}*/
	
	org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
if (needRoot) {
	needRoot=false;
		org.dom4j.Element root = null;
				root = org.dom4j.DocumentHelper.createElement("root");
				doc.add(root);
		subTreeRootParent = root;
		org.dom4j.Element root_0 = null;
				root_0 = root.addElement("ID");
		valueMap.put("root_0",row1.ID);
		if(valueMap.get("root_0")!=null) {
			routines.system.NestXMLTool.setText(root_0, FormatterUtils.fm(valueMap.get("root_0"),null));
		}
		org.dom4j.Element root_1 = null;
				root_1 = root.addElement("Date");
		valueMap.put("root_1",row1.Date);
		if(valueMap.get("root_1")!=null) {
			routines.system.NestXMLTool.setText(root_1, FormatterUtils.fm(valueMap.get("root_1"),null));
		}
		org.dom4j.Element root_2 = null;
				root_2 = root.addElement("Region");
		valueMap.put("root_2",row1.Region);
		if(valueMap.get("root_2")!=null) {
			routines.system.NestXMLTool.setText(root_2, FormatterUtils.fm(valueMap.get("root_2"),null));
		}
		org.dom4j.Element root_3 = null;
				root_3 = root.addElement("ProductCode");
		valueMap.put("root_3",row1.ProductCode);
		if(valueMap.get("root_3")!=null) {
			routines.system.NestXMLTool.setText(root_3, FormatterUtils.fm(valueMap.get("root_3"),null));
		}
		org.dom4j.Element root_4 = null;
				root_4 = root.addElement("Customer_Name");
		valueMap.put("root_4",row1.Customer_Name);
		if(valueMap.get("root_4")!=null) {
			routines.system.NestXMLTool.setText(root_4, FormatterUtils.fm(valueMap.get("root_4"),null));
		}
		org.dom4j.Element root_5 = null;
				root_5 = root.addElement("Address");
		valueMap.put("root_5",row1.Address);
		if(valueMap.get("root_5")!=null) {
			routines.system.NestXMLTool.setText(root_5, FormatterUtils.fm(valueMap.get("root_5"),null));
		}
		org.dom4j.Element root_6 = null;
				root_6 = root.addElement("Comment");
		valueMap.put("root_6",row1.Comment);
		if(valueMap.get("root_6")!=null) {
			routines.system.NestXMLTool.setText(root_6, FormatterUtils.fm(valueMap.get("root_6"),null));
		}
		org.dom4j.Element root_7 = null;
				root_7 = root.addElement("City");
		valueMap.put("root_7",row1.City);
		if(valueMap.get("root_7")!=null) {
			routines.system.NestXMLTool.setText(root_7, FormatterUtils.fm(valueMap.get("root_7"),null));
		}
		org.dom4j.Element root_8 = null;
				root_8 = root.addElement("Address1");
		valueMap.put("root_8",row1.Address1);
		if(valueMap.get("root_8")!=null) {
			routines.system.NestXMLTool.setText(root_8, FormatterUtils.fm(valueMap.get("root_8"),null));
		}
		org.dom4j.Element root_9 = null;
				root_9 = root.addElement("Address2");
		valueMap.put("root_9",row1.Address2);
		if(valueMap.get("root_9")!=null) {
			routines.system.NestXMLTool.setText(root_9, FormatterUtils.fm(valueMap.get("root_9"),null));
		}
		root4Group = subTreeRootParent;
	}else{
		subTreeRootParent=root4Group;
	}
	/* build group xml tree */
	boolean isNewElement = false;
		isNewElement = false;
		}
    }

	GenerateDocument_output gen_Doc_output_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_output();
	boolean docAlreadyInstanciate_output = false;

class GenerateDocument_tXMLMap_1_TXMLMAP_OUT {

	java.util.Map<String,Object> valueMap = null;
	
	routines.system.DocumentGenerateOrderHelper orderHelper = new routines.system.DocumentGenerateOrderHelper(1);
	
	org.dom4j.Document doc = null;
	
	org.dom4j.Element root4Group = null;
	
	org.dom4j.io.OutputFormat format = null;
	
	java.util.List<java.util.List<String>> groupbyList = null;
	java.util.List<org.dom4j.Element> groupElementList = null;
	int order = 0;
	
	boolean isFirst = true;
	
	boolean	needRoot = true;
	
	String currentValue = null;

		org.dom4j.Element subTreeLoopParent0 = null;
		public boolean  subTreeLoop0 = false;
	
    public GenerateDocument_tXMLMap_1_TXMLMAP_OUT() {
//    	this.treeNodeAPI = treeNodeAPI;
    	
    	valueMap = new java.util.HashMap<String,Object>();
    	
    	groupbyList =  new java.util.ArrayList<java.util.List<String>>();
		groupElementList = new java.util.ArrayList<org.dom4j.Element>();
    	
    	doc = org.dom4j.DocumentHelper.createDocument();
    	format = org.dom4j.io.OutputFormat.createPrettyPrint();
    	format.setTrimText(false);
    }
    
    public org.dom4j.Document getDocument(){
    	return this.doc;
    }
    
	//We generate the TreeNode_API object only if there is a document in the main input table.
    void generateElements(boolean isInnerJoin, row1Struct row1, Var__tXMLMap_1_TXMLMAP_OUT__Struct Var
	) {
	
	
	/*if(this.treeNodeAPI==null) {
		this.treeNodeAPI = treeNodeAPI;
	}*/
	
	org.dom4j.Element subTreeRootParent = null;
// build root xml tree 
if (needRoot) {
	needRoot=false;
		org.dom4j.Element root = null;
				root = org.dom4j.DocumentHelper.createElement("root");
				doc.add(root);
		subTreeRootParent = root;
		root4Group = subTreeRootParent;
	}else{
		subTreeRootParent=root4Group;
	}
	/* build group xml tree */
	boolean isNewElement = false;
		isNewElement = false;
		}
    }

	GenerateDocument_tXMLMap_1_TXMLMAP_OUT gen_Doc_tXMLMap_1_TXMLMAP_OUT_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_tXMLMap_1_TXMLMAP_OUT();
	boolean docAlreadyInstanciate_tXMLMap_1_TXMLMAP_OUT = false;

	            

 



		

/**
 * [tXMLMap_1_TXMLMAP_OUT begin ] stop
 */




	
	/**
	 * [tDBInput_1 begin ] start
	 */

	

	
		
		sh("tDBInput_1");
		
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"sampledatabig\"";
		
		int tos_count_tDBInput_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tDBInput_1{
                    public void limitLog4jByte() throws Exception{
                    StringBuilder log4jParamters_tDBInput_1 = new StringBuilder();
                    log4jParamters_tDBInput_1.append("Parameters:");
                            log4jParamters_tDBInput_1.append("DB_VERSION" + " = " + "MYSQL_8");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USE_EXISTING_CONNECTION" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("HOST" + " = " + "\"192.168.1.253\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PORT" + " = " + "\"3306\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("DBNAME" + " = " + "\"dummy_sunchita\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("USER" + " = " + "\"admin\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PASS" + " = " + String.valueOf("enc:routine.encryption.key.v1:2VzB4ZbaRbgYXmyIF7QM+MoocZp3f6qHHewnUxzYWxHc").substring(0, 4) + "...");     
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TABLE" + " = " + "\"sampledatabig\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERYSTORE" + " = " + "\"\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("QUERY" + " = " + "\"SELECT    `sampledatabig`.`ID`,    `sampledatabig`.`Date`,    `sampledatabig`.`Region`,    `sampledatabig`.`ProductCode`,    `sampledatabig`.`Customer Name`,    `sampledatabig`.`Address`,    `sampledatabig`.`Comment`,    `sampledatabig`.`City`,    `sampledatabig`.`Address1`,    `sampledatabig`.`Address2`  FROM `sampledatabig`\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("SPECIFY_DATASOURCE_ALIAS" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("PROPERTIES" + " = " + "\"noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1\"");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("ENABLE_STREAM" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_ALL_COLUMN" + " = " + "false");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("TRIM_COLUMN" + " = " + "[{TRIM="+("false")+", SCHEMA_COLUMN="+("ID")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Date")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Region")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("ProductCode")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Customer_Name")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Address")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Comment")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("City")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Address1")+"}, {TRIM="+("false")+", SCHEMA_COLUMN="+("Address2")+"}]");
                        log4jParamters_tDBInput_1.append(" | ");
                            log4jParamters_tDBInput_1.append("UNIFIED_COMPONENTS" + " = " + "tMysqlInput");
                        log4jParamters_tDBInput_1.append(" | ");
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + (log4jParamters_tDBInput_1) );
                    } 
                } 
            new BytesLimit65535_tDBInput_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tDBInput_1", "\"sampledatabig\"", "tMysqlInput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
	
	
		    java.util.Calendar calendar_tDBInput_1 = java.util.Calendar.getInstance();
		    calendar_tDBInput_1.set(0, 0, 0, 0, 0, 0);
		    java.util.Date year0_tDBInput_1 = calendar_tDBInput_1.getTime();
		    int nb_line_tDBInput_1 = 0;
		    java.sql.Connection conn_tDBInput_1 = null;
				String driverClass_tDBInput_1 = "com.mysql.cj.jdbc.Driver";
			    java.lang.Class jdbcclazz_tDBInput_1 = java.lang.Class.forName(driverClass_tDBInput_1);
				String dbUser_tDBInput_1 = "admin";
				
				 
	final String decryptedPassword_tDBInput_1 = routines.system.PasswordEncryptUtil.decryptPassword("enc:routine.encryption.key.v1:q8Q9s8TCVgvyqMZ/dJMojewLkhIR0mK1T/Xs2J5W2SMG");
				
				String dbPwd_tDBInput_1 = decryptedPassword_tDBInput_1;
				
        String properties_tDBInput_1 = "noDatetimeStringSync=true&enabledTLSProtocols=TLSv1.2,TLSv1.1,TLSv1";
        if (properties_tDBInput_1 == null || properties_tDBInput_1.trim().length() == 0) {
            properties_tDBInput_1 = "";
        }
        String url_tDBInput_1 = "jdbc:mysql://" + "192.168.1.253" + ":" + "3306" + "/" + "dummy_sunchita" + "?" + properties_tDBInput_1;
				
	    		log.debug("tDBInput_1 - Driver ClassName: "+driverClass_tDBInput_1+".");
			
	    		log.debug("tDBInput_1 - Connection attempt to '" + url_tDBInput_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' with the username '" + dbUser_tDBInput_1 + "'.");
			
				conn_tDBInput_1 = java.sql.DriverManager.getConnection(url_tDBInput_1,dbUser_tDBInput_1,dbPwd_tDBInput_1);
	    		log.debug("tDBInput_1 - Connection to '" + url_tDBInput_1.replaceAll("(?<=trustStorePassword=)[^;]*", "********") + "' has succeeded.");
			
		        
		    
			java.sql.Statement stmt_tDBInput_1 = conn_tDBInput_1.createStatement();

		    String dbquery_tDBInput_1 = "SELECT \n  `sampledatabig`.`ID`, \n  `sampledatabig`.`Date`, \n  `sampledatabig`.`Region`, \n  `sampledatabig`.`ProductCode"
+"`, \n  `sampledatabig`.`Customer Name`, \n  `sampledatabig`.`Address`, \n  `sampledatabig`.`Comment`, \n  `sampledatabig`.`C"
+"ity`, \n  `sampledatabig`.`Address1`, \n  `sampledatabig`.`Address2`\n FROM `sampledatabig`";
		    
	    		log.debug("tDBInput_1 - Executing the query: '" + dbquery_tDBInput_1 + "'.");
			

		    globalMap.put("tDBInput_1_QUERY",dbquery_tDBInput_1);

		    java.sql.ResultSet rs_tDBInput_1 = null;

		    try {
		    	rs_tDBInput_1 = stmt_tDBInput_1.executeQuery(dbquery_tDBInput_1);
		    	java.sql.ResultSetMetaData rsmd_tDBInput_1 = rs_tDBInput_1.getMetaData();
		    	int colQtyInRs_tDBInput_1 = rsmd_tDBInput_1.getColumnCount();

		    String tmpContent_tDBInput_1 = null;
		    
		    
		    	log.debug("tDBInput_1 - Retrieving records from the database.");
		    
		    while (rs_tDBInput_1.next()) {
		        nb_line_tDBInput_1++;
		        
							if(colQtyInRs_tDBInput_1 < 1) {
								row1.ID = null;
							} else {
		                          
            row1.ID = rs_tDBInput_1.getInt(1);
            if(rs_tDBInput_1.wasNull()){
                    row1.ID = null;
            }
		                    }
							if(colQtyInRs_tDBInput_1 < 2) {
								row1.Date = null;
							} else {
	                         		
        	row1.Date = routines.system.JDBCUtil.getString(rs_tDBInput_1, 2, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 3) {
								row1.Region = null;
							} else {
	                         		
        	row1.Region = routines.system.JDBCUtil.getString(rs_tDBInput_1, 3, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 4) {
								row1.ProductCode = null;
							} else {
	                         		
        	row1.ProductCode = routines.system.JDBCUtil.getString(rs_tDBInput_1, 4, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 5) {
								row1.Customer_Name = null;
							} else {
	                         		
        	row1.Customer_Name = routines.system.JDBCUtil.getString(rs_tDBInput_1, 5, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 6) {
								row1.Address = null;
							} else {
	                         		
        	row1.Address = routines.system.JDBCUtil.getString(rs_tDBInput_1, 6, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 7) {
								row1.Comment = null;
							} else {
	                         		
        	row1.Comment = routines.system.JDBCUtil.getString(rs_tDBInput_1, 7, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 8) {
								row1.City = null;
							} else {
	                         		
        	row1.City = routines.system.JDBCUtil.getString(rs_tDBInput_1, 8, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 9) {
								row1.Address1 = null;
							} else {
	                         		
        	row1.Address1 = routines.system.JDBCUtil.getString(rs_tDBInput_1, 9, false);
		                    }
							if(colQtyInRs_tDBInput_1 < 10) {
								row1.Address2 = null;
							} else {
	                         		
        	row1.Address2 = routines.system.JDBCUtil.getString(rs_tDBInput_1, 10, false);
		                    }
					
						log.debug("tDBInput_1 - Retrieving the record " + nb_line_tDBInput_1 + ".");
					

 



		

/**
 * [tDBInput_1 begin ] stop
 */

	
	/**
	 * [tDBInput_1 main ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"sampledatabig\"";
		

 


	tos_count_tDBInput_1++;

		

/**
 * [tDBInput_1 main ] stop
 */

	
	/**
	 * [tDBInput_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"sampledatabig\"";
		

 



		

/**
 * [tDBInput_1 process_data_begin ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT main ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"row1","tDBInput_1","\"sampledatabig\"","tMysqlInput","tXMLMap_1_TXMLMAP_OUT","tXMLMap_1_TXMLMAP_OUT","tXMLMapOut"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("row1 - " + (row1==null? "": row1.toLogString()));
    			}
    		

	boolean rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
	boolean rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;
	boolean mainRowRejected_tXMLMap_1_TXMLMAP_OUT = false;
	boolean isMatchDocRowtXMLMap_1_TXMLMAP_OUT = false;
	  
	
			
   
					output_tmp.body = null;
					
		
		


			
{ // start of Var scope

	// ###############################
	// # Vars tables

Var__tXMLMap_1_TXMLMAP_OUT__Struct Var = Var__tXMLMap_1_TXMLMAP_OUT;
		// ###############################
		// # Output tables

output = null;


// # Output table : 'output'
count_output_tXMLMap_1_TXMLMAP_OUT++;


if(!docAlreadyInstanciate_output) {
docAlreadyInstanciate_output = true;gen_Doc_output_tXMLMap_1_TXMLMAP_OUT = new GenerateDocument_output();
//init one new out struct for cache the result.
output_aggregate = new outputStruct();
output_aggregate.body = new routines.system.Document();
output_aggregate.body.setDocument(gen_Doc_output_tXMLMap_1_TXMLMAP_OUT.getDocument());

//construct the resultset
allOutsForAggregate_tXMLMap_1.add(output_aggregate);
}


gen_Doc_output_tXMLMap_1_TXMLMAP_OUT.generateElements(rejectedDocInnerJoin_tXMLMap_1_TXMLMAP_OUT,row1,Var);


log.debug("tXMLMap_1 - Outputting the record " + count_output_tXMLMap_1_TXMLMAP_OUT + " of the output table 'output'.");

// ###############################

} // end of Var scope

rejectedInnerJoin_tXMLMap_1_TXMLMAP_OUT = false;



 


	tos_count_tXMLMap_1_TXMLMAP_OUT++;

		

/**
 * [tXMLMap_1_TXMLMAP_OUT main ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
		
		
		
	

 



	
		

/**
 * [tXMLMap_1_TXMLMAP_OUT process_data_begin ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
		
		
		
	

 



	
		

/**
 * [tXMLMap_1_TXMLMAP_OUT process_data_end ] stop
 */




	
	/**
	 * [tDBInput_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"sampledatabig\"";
		

 



		

/**
 * [tDBInput_1 process_data_end ] stop
 */

	
	/**
	 * [tDBInput_1 end ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"sampledatabig\"";
		

	}
}finally{
	if (rs_tDBInput_1 != null) {
		rs_tDBInput_1.close();
	}
	if (stmt_tDBInput_1 != null) {
		stmt_tDBInput_1.close();
	}
		if(conn_tDBInput_1 != null && !conn_tDBInput_1.isClosed()) {
			
	    		log.debug("tDBInput_1 - Closing the connection to the database.");
			
			conn_tDBInput_1.close();
			
			if("com.mysql.cj.jdbc.Driver".equals((String)globalMap.get("driverClass_"))
			    && routines.system.BundleUtils.inOSGi()) {
			        Class.forName("com.mysql.cj.jdbc.AbandonedConnectionCleanupThread").
			            getMethod("checkedShutdown").invoke(null, (Object[]) null);
			}
			
	    		log.debug("tDBInput_1 - Connection to the database closed.");
			
		}
		
}
globalMap.put("tDBInput_1_NB_LINE",nb_line_tDBInput_1);
	    		log.debug("tDBInput_1 - Retrieved records count: "+nb_line_tDBInput_1 + " .");
			

 
                if(log.isDebugEnabled())
            log.debug("tDBInput_1 - "  + ("Done.") );

ok_Hash.put("tDBInput_1", true);
end_Hash.put("tDBInput_1", System.currentTimeMillis());




		

/**
 * [tDBInput_1 end ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
		
		
		
	
		log.debug("tXMLMap_1 - Written records count in the table 'output': " + count_output_tXMLMap_1_TXMLMAP_OUT + ".");



				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"row1",2,0,
				 			"tDBInput_1","\"sampledatabig\"","tMysqlInput","tXMLMap_1_TXMLMAP_OUT","tXMLMap_1_TXMLMAP_OUT","tXMLMapOut","output")) {
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
	 * [tRESTResponse_1 begin ] start
	 */

	

	
		
		sh("tRESTResponse_1");
		
	
	s(currentComponent="tRESTResponse_1");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"output");
					}
				
		int tos_count_tRESTResponse_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTResponse_1", "tRESTResponse_1", "tRESTResponse");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

 



		

/**
 * [tRESTResponse_1 begin ] stop
 */




	
	/**
	 * [tXMLMap_1_TXMLMAP_IN begin ] start
	 */

	

	
		
		sh("tXMLMap_1_TXMLMAP_IN");
		
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	
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
				talendJobLog.addCM("tXMLMap_1_TXMLMAP_IN", "tXMLMap_1_TXMLMAP_IN", "tXMLMapIn");
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
	
			
			
	

	output = null;
	if(row_out_tXMLMap_1_TXMLMAP_IN!=null && row_out_tXMLMap_1_TXMLMAP_IN instanceof outputStruct) {
		output = (outputStruct)row_out_tXMLMap_1_TXMLMAP_IN;
			routines.system.NestXMLTool.generateOk(output.body, false);		
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
	
			
			
	

 



		

/**
 * [tXMLMap_1_TXMLMAP_IN process_data_begin ] stop
 */

// Start of branch "output"
if(output != null) { 



	
	/**
	 * [tRESTResponse_1 main ] start
	 */

	

	
	
	s(currentComponent="tRESTResponse_1");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"output","tXMLMap_1_TXMLMAP_IN","tXMLMap_1_TXMLMAP_IN","tXMLMapIn","tRESTResponse_1","tRESTResponse_1","tRESTResponse"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("output - " + (output==null? "": output.toLogString()));
    			}
    		

	java.io.OutputStream outputStream_tRESTResponse_1 = (java.io.OutputStream) globalMap.get("restResponseStream");
	boolean responseAlreadySent_tRESTResponse_1 = globalMap.containsKey("restResponse");

	if (null == outputStream_tRESTResponse_1 && responseAlreadySent_tRESTResponse_1) {
		throw new RuntimeException("Rest response already sent.");
	} else if (!globalMap.containsKey("restRequest")) {
		throw new RuntimeException("Not received rest request yet.");
	} else {
		Integer restProviderStatusCode_tRESTResponse_1 = 200;

		Object restProviderResponse_tRESTResponse_1 = null;
		if (null != output.body) {
			restProviderResponse_tRESTResponse_1 = output.body.getDocument();
		}

		java.util.Map<String, String> restProviderResponseHeaders_tRESTResponse_1 = new java.util.TreeMap<String, String>(String.CASE_INSENSITIVE_ORDER);
		java.lang.StringBuilder restProviderResponseHeader_cookies_tRESTResponse_1 = new java.lang.StringBuilder();
		final String setCookieHeader = "Set-Cookie";

        if (restProviderResponseHeader_cookies_tRESTResponse_1.length() > 0) {
		    restProviderResponseHeaders_tRESTResponse_1.put(setCookieHeader, restProviderResponseHeader_cookies_tRESTResponse_1.toString());
		}

        java.util.Map<String, Object> restRequest_tRESTResponse_1 = (java.util.Map<String, Object>) globalMap.get("restRequest");
        org.apache.cxf.jaxrs.ext.MessageContext messageContext_tRESTResponse_1 = (org.apache.cxf.jaxrs.ext.MessageContext) restRequest_tRESTResponse_1.get("MESSAGE_CONTEXT");
        

		if (null == outputStream_tRESTResponse_1) {
			java.util.Map<String, Object> restResponse_tRESTResponse_1 = new java.util.HashMap<String, Object>();
			restResponse_tRESTResponse_1.put("BODY", restProviderResponse_tRESTResponse_1);
			restResponse_tRESTResponse_1.put("STATUS", restProviderStatusCode_tRESTResponse_1);
			restResponse_tRESTResponse_1.put("HEADERS", restProviderResponseHeaders_tRESTResponse_1);
			restResponse_tRESTResponse_1.put("drop.json.root.element", Boolean.valueOf(false));
			globalMap.put("restResponse", restResponse_tRESTResponse_1);
			
		} else {

			jakarta.ws.rs.core.MediaType responseMediaType_tRESTResponse_1 = null;
			if (!responseAlreadySent_tRESTResponse_1) {
				org.apache.cxf.message.Message currentMessage = null;
				if (org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage() != null) {
					currentMessage = org.apache.cxf.jaxrs.utils.JAXRSUtils.getCurrentMessage();
				} else {
					currentMessage = ((org.apache.cxf.message.Message)restRequest_tRESTResponse_1.get("CURRENT_MESSAGE"));
				}

				if (currentMessage != null && currentMessage.getExchange() != null) {
					currentMessage.getExchange().put(StreamingDOM4JProvider.SUPRESS_XML_DECLARATION, true);
				}

				messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.RESPONSE_CODE, restProviderStatusCode_tRESTResponse_1);
				jakarta.ws.rs.core.MultivaluedMap<String, String> headersMultivaluedMap_tRESTResponse_1 = new org.apache.cxf.jaxrs.impl.MetadataMap<String, String>();
				for (java.util.Map.Entry<String, String> multivaluedHeader : restProviderResponseHeaders_tRESTResponse_1.entrySet()) {
					headersMultivaluedMap_tRESTResponse_1.putSingle(multivaluedHeader.getKey(), multivaluedHeader.getValue());
				}
				messageContext_tRESTResponse_1.put(org.apache.cxf.message.Message.PROTOCOL_HEADERS, headersMultivaluedMap_tRESTResponse_1);

				String responseContentType_tRESTResponse_1 = null;
				
				if (currentMessage != null && currentMessage.getExchange() != null) {
					responseContentType_tRESTResponse_1 = (String) currentMessage.getExchange().get(org.apache.cxf.message.Message.CONTENT_TYPE);
				}
					
				if (null == responseContentType_tRESTResponse_1) {
					// this should not be needed, just in case. set it to the first value in the sorted list returned from HttpHeaders
					responseMediaType_tRESTResponse_1 = messageContext_tRESTResponse_1.getHttpHeaders().getAcceptableMediaTypes().get(0);
				} else {
					responseMediaType_tRESTResponse_1 = org.apache.cxf.jaxrs.utils.JAXRSUtils.toMediaType(responseContentType_tRESTResponse_1);
				}
				globalMap.put("restResponseMediaType", responseMediaType_tRESTResponse_1);

				String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1.getSubtype();
				if (responseMediaSubType_tRESTResponse_1.equals("xml") || responseMediaSubType_tRESTResponse_1.endsWith("+xml")) {
					outputStream_tRESTResponse_1.write("<wrapper>".getBytes());
					globalMap.put("restResponseWrappingClosure", "</wrapper>");
				}
				if (responseMediaSubType_tRESTResponse_1.equals("json") || responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
					outputStream_tRESTResponse_1.write("[".getBytes());
					globalMap.put("restResponseWrappingClosure", "]");
				}

				globalMap.put("restResponse", true);
			} else {
				responseMediaType_tRESTResponse_1 = (jakarta.ws.rs.core.MediaType) globalMap.get("restResponseMediaType");
			}

			if (null != restProviderResponse_tRESTResponse_1) {
				String responseMediaSubType_tRESTResponse_1 = responseMediaType_tRESTResponse_1.getSubtype();
				if (responseMediaSubType_tRESTResponse_1.equals("json") || responseMediaSubType_tRESTResponse_1.endsWith("+json")) {
					if (globalMap.containsKey("restResponseJsonStarted")) {
						outputStream_tRESTResponse_1.write(",".getBytes());
					} else {
						globalMap.put("restResponseJsonStarted", true);
					}
				}

				Class<? extends Object> responseBodyClass_tRESTResponse_1 = restProviderResponse_tRESTResponse_1.getClass();
				jakarta.ws.rs.ext.Providers messageBodyProviders_tRESTResponse_1 = messageContext_tRESTResponse_1.getProviders();
				jakarta.ws.rs.ext.MessageBodyWriter messageBodyWriter_tRESTResponse_1 = messageBodyProviders_tRESTResponse_1.getMessageBodyWriter(
						responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1, null, responseMediaType_tRESTResponse_1);

                if (messageBodyWriter_tRESTResponse_1 instanceof StreamingDOM4JProvider) {
                    ((StreamingDOM4JProvider)messageBodyWriter_tRESTResponse_1).setGlobalMap(globalMap);
                }

				messageBodyWriter_tRESTResponse_1.writeTo(restProviderResponse_tRESTResponse_1, responseBodyClass_tRESTResponse_1, responseBodyClass_tRESTResponse_1,
						new java.lang.annotation.Annotation[] {}, responseMediaType_tRESTResponse_1, null, outputStream_tRESTResponse_1);
			}
			// initial variant
			//outputStream_tRESTResponse_1.write(String.valueOf(restProviderResponse_tRESTResponse_1).getBytes());
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

	

	
	
	s(currentComponent="tRESTResponse_1");
	
			
		
		
		
	

 



	
		

/**
 * [tRESTResponse_1 process_data_begin ] stop
 */

	
	/**
	 * [tRESTResponse_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tRESTResponse_1");
	
			
		
		
		
	

 



	
		

/**
 * [tRESTResponse_1 process_data_end ] stop
 */


} // End of branch "output"




	
	/**
	 * [tXMLMap_1_TXMLMAP_IN process_data_end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	

 



		

/**
 * [tXMLMap_1_TXMLMAP_IN process_data_end ] stop
 */

	
	/**
	 * [tXMLMap_1_TXMLMAP_IN end ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	

}//TD512
 
                if(log.isDebugEnabled())
            log.debug("tXMLMap_1_TXMLMAP_IN - "  + ("Done.") );

ok_Hash.put("tXMLMap_1_TXMLMAP_IN", true);
end_Hash.put("tXMLMap_1_TXMLMAP_IN", System.currentTimeMillis());




		

/**
 * [tXMLMap_1_TXMLMAP_IN end ] stop
 */


	
	/**
	 * [tRESTResponse_1 end ] start
	 */

	

	
	
	s(currentComponent="tRESTResponse_1");
	
			
		
		
		
	

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"output",2,0,
				 			"tXMLMap_1_TXMLMAP_IN","tXMLMap_1_TXMLMAP_IN","tXMLMapIn","tRESTResponse_1","tRESTResponse_1","tRESTResponse","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tRESTResponse_1", true);
end_Hash.put("tRESTResponse_1", System.currentTimeMillis());




	
		

/**
 * [tRESTResponse_1 end ] stop
 */














	
	/**
	 * [tFlowToIterate_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
		
		
					if (output1 != null) {
		
		
	

 



	
	
				}
		

/**
 * [tFlowToIterate_1 process_data_end ] stop
 */


} // End of branch "output1"




	
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
	 * [tFlowToIterate_1 end ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
		
		
					if (output1 != null) {
		
		
	

globalMap.put("tFlowToIterate_1_NB_LINE",nb_line_tFlowToIterate_1);
				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"output1",2,0,
				 			"tRESTRequest_1_In","tRESTRequest_1_In","tRESTRequestIn","tFlowToIterate_1","tFlowToIterate_1","tFlowToIterate","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tFlowToIterate_1 - "  + ("Done.") );

ok_Hash.put("tFlowToIterate_1", true);
end_Hash.put("tFlowToIterate_1", System.currentTimeMillis());




	
	
				}
		

/**
 * [tFlowToIterate_1 end ] stop
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
					runStat.log(iterateId,2,0,"output1");
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
				
							//free memory for "tXMLMap_1_TXMLMAP_IN"
							globalMap.remove("tXMLMap_1");
						
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
	 * [tFlowToIterate_1 finally ] start
	 */

	

	
	
	s(currentComponent="tFlowToIterate_1");
	
			
			
	

 



		

/**
 * [tFlowToIterate_1 finally ] stop
 */


	
	/**
	 * [tDBInput_1 finally ] start
	 */

	

	
	
	s(currentComponent="tDBInput_1");
	
			
			
	
			cLabel="\"sampledatabig\"";
		

 



		

/**
 * [tDBInput_1 finally ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_OUT finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_OUT");
	
			
			
	

 



		

/**
 * [tXMLMap_1_TXMLMAP_OUT finally ] stop
 */


	
	/**
	 * [tXMLMap_1_TXMLMAP_IN finally ] start
	 */

	

	
	
		currentVirtualComponent = "tXMLMap_1";
	
	s(currentComponent="tXMLMap_1_TXMLMAP_IN");
	
			
			
	

 



		

/**
 * [tXMLMap_1_TXMLMAP_IN finally ] stop
 */


	
	/**
	 * [tRESTResponse_1 finally ] start
	 */

	

	
	
	s(currentComponent="tRESTResponse_1");
	
			
			
	

 



		

/**
 * [tRESTResponse_1 finally ] stop
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
    
    
    private final static java.util.Properties jobInfo = new java.util.Properties();
    private final static java.util.Map<String,String> mdcInfo = new java.util.HashMap<>();
    private final static java.util.concurrent.atomic.AtomicLong subJobPidCounter = new java.util.concurrent.atomic.AtomicLong();


    public static void main(String[] args){
        final Deploy_Test Deploy_TestClass = new Deploy_Test();

        int exitCode = Deploy_TestClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'Deploy_Test' - Done.");
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
			log.info("TalendJob: 'Deploy_Test' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_PHWY4FZpEfClzKBwPKe_HA");
                org.slf4j.MDC.put("_compiledAtTimestamp","2025-07-01T11:01:56.008635800Z");

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
            java.io.InputStream inContext = Deploy_Test.class.getClassLoader().getResourceAsStream("dpdp/deploy_test_0_1/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Deploy_Test.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {
        }

        //Resume: init the resumeUtil
        resumeEntryMethodName = ResumeUtil.getResumeEntryMethodName(resuming_checkpoint_path);
        resumeUtil = new ResumeUtil(resuming_logs_dir_path, isChildJob, rootPid);
        resumeUtil.initCommonInfo(pid, rootPid, fatherPid, projectName, jobName, contextStr, jobVersion);

		List<String> parametersToEncrypt = new java.util.ArrayList<String>();
        //Resume: jobStart
        resumeUtil.addLog("JOB_STARTED", "JOB:" + jobName, parent_part_launcher, Thread.currentThread().getId() + "", "","","","",resumeUtil.convertToJsonText(context,ContextProperties.class,parametersToEncrypt));

            org.slf4j.MDC.put("_context", contextStr);
            log.info("TalendJob: 'Deploy_Test' - Started.");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Deploy_Test");
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
        log.info("TalendJob: 'Deploy_Test' - Finished - status: " + status + " returnCode: " + returnCode );

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
 *     153305 characters generated by Talend Real-time Big Data Platform 
 *     on the 1 July 2025 at 4:31:56 pm IST
 ************************************************************************************************/