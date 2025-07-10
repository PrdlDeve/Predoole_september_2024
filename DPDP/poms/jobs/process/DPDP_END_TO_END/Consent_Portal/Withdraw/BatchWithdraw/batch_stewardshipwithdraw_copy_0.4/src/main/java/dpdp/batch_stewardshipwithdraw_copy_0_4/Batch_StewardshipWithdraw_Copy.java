
package dpdp.batch_stewardshipwithdraw_copy_0_4;

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
 * Job: Batch_StewardshipWithdraw_Copy Purpose: <br>
 * Description:  <br>
 * @author Patil, Chirag
 * @version 8.0.1.20250521_1150-patch
 * @status 
 */
public class Batch_StewardshipWithdraw_Copy implements TalendJob {
	static {System.setProperty("TalendJob.log", "Batch_StewardshipWithdraw_Copy.log");}

	

	
	private static org.apache.logging.log4j.Logger log = org.apache.logging.log4j.LogManager.getLogger(Batch_StewardshipWithdraw_Copy.class);
	

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

	private final String jobVersion = "0.4";
	private final String jobName = "Batch_StewardshipWithdraw_Copy";
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
	

private final JobStructureCatcherUtils talendJobLog = new JobStructureCatcherUtils(jobName, "_IRW_gFApEfC4ZuKDeZl3GA", "0.4");
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
			Batch_StewardshipWithdraw_Copy.this.exception = e;
		}
		if (!(e instanceof TalendException)) {
		try {
			for (java.lang.reflect.Method m : this.getClass().getEnclosingClass().getMethods()) {
				if (m.getName().compareTo(currentComponent + "_error") == 0) {
					m.invoke(Batch_StewardshipWithdraw_Copy.this, new Object[] { e , currentComponent, globalMap});
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

			public void tMap_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
				end_Hash.put(errorComponent, System.currentTimeMillis());
				
				status = "failure";
				
					tRESTRequest_1_Loop_onSubJobError(exception, errorComponent, globalMap);
			}
			
			public void tDataStewardshipTaskOutput_1_error(Exception exception, String errorComponent, final java.util.Map<String, Object> globalMap) throws TalendException {
				
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
	return "192.168.1.163:8040/services/request";
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

	private final Batch_StewardshipWithdraw_Copy job;


	public RestServiceProviderImpl4TalendJob() {
		this.job = new Batch_StewardshipWithdraw_Copy();
	}

	public RestServiceProviderImpl4TalendJob(Batch_StewardshipWithdraw_Copy job) {
		this.job = job;
	}

	private void populateRequestWithJobContext(java.util.Map<String, Object> requestGlobalMap, Batch_StewardshipWithdraw_Copy job) {
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
            String taskExecutionId = Batch_StewardshipWithdraw_Copy.taskExecutionId;
            String jobExecutionId = Batch_StewardshipWithdraw_Copy.jobExecutionId;

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

	@jakarta.ws.rs.DELETE()

	@jakarta.ws.rs.Path("/customer/{id}")
	@jakarta.ws.rs.Produces({ "application/xml", "text/xml", "application/json" })
	public jakarta.ws.rs.core.Response deleteCustomer(
		
				@jakarta.ws.rs.PathParam("id") Integer id
		
		
			) {
                List<String> requiredParameterWithNullValueList = new java.util.ArrayList<String>();
                    if(null == id){
                        requiredParameterWithNullValueList.add("id");
                    }  
                if(requiredParameterWithNullValueList.size() > 0){
                    return handleWrongRequest(messageContext, 400, "400 Bad Request \n" + requiredParameterWithNullValueList.toString() + " in tRESTRequest_1:deleteCustomer " + (requiredParameterWithNullValueList.size() == 1 ? "is required!" : "are required!"));         
                }
		java.util.Map<String, Object> request_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		request_tRESTRequest_1.put("VERB", "DELETE");
		request_tRESTRequest_1.put("OPERATION", "deleteCustomer");
		request_tRESTRequest_1.put("PATTERN", "/customer/{id}");
	

		populateRequestInfo(request_tRESTRequest_1, messageContext);

		java.util.Map<String, Object> parameters_tRESTRequest_1 = new java.util.HashMap<String, Object>();
		
			parameters_tRESTRequest_1.put("PATH:id:id_Integer", id);
		
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

	private final Batch_StewardshipWithdraw_Copy job;

	private org.apache.cxf.endpoint.Server server;

	private org.apache.cxf.jaxrs.JAXRSServerFactoryBean sf;

	public Thread4RestServiceProviderEndpoint(Batch_StewardshipWithdraw_Copy job, String endpointUrl) {
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
			java.io.InputStream inContext = Batch_StewardshipWithdraw_Copy.class.getClassLoader()
					.getResourceAsStream("dpdp/batch_stewardshipwithdraw_copy_0_4/contexts/" + currentContext  + ".properties");
			if (inContext == null) {
				inContext = Batch_StewardshipWithdraw_Copy.class.getClassLoader()
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





	




public static class withdrawStruct implements routines.system.IPersistableRow<withdrawStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_StewardshipWithdraw_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy = new byte[0];

	
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
			if(length > commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy = new byte[2 * length];
   				}
			}
			dis.readFully(commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy, 0, length, utf8Charset);
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
			if(length > commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy.length) {
				if(length < 1024 && commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy.length == 0) {
   					commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy = new byte[1024];
				} else {
   					commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy = new byte[2 * length];
   				}
			}
			unmarshaller.readFully(commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy, 0, length);
			strReturn = new String(commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy, 0, length, utf8Charset);
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

		synchronized(commonByteArrayLock_DPDP_Batch_StewardshipWithdraw_Copy) {

        	try {

        		int length = 0;
		
			        this.Customer_Id = dis.readInt();
					
					this.Reason = readString(dis);
					
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

		synchronized(commonByteArrayLock_DPDP_Batch_StewardshipWithdraw_Copy) {

        	try {

        		int length = 0;
		
			        this.Customer_Id = dis.readInt();
					
					this.Reason = readString(dis);
					
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
    public int compareTo(withdrawStruct other) {

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

public static class deleteCustomerStruct implements routines.system.IPersistableRow<deleteCustomerStruct> {
    final static byte[] commonByteArrayLock_DPDP_Batch_StewardshipWithdraw_Copy = new byte[0];
    static byte[] commonByteArray_DPDP_Batch_StewardshipWithdraw_Copy = new byte[0];

	
			    public int id;

				public int getId () {
					return this.id;
				}

				public Boolean idIsNullable(){
				    return false;
				}
				public Boolean idIsKey(){
				    return true;
				}
				public Integer idLength(){
				    return 11;
				}
				public Integer idPrecision(){
				    return 0;
				}
				public String idDefault(){
				
					return null;
				
				}
				public String idComment(){
				
				    return "";
				
				}
				public String idPattern(){
				
					return "";
				
				}
				public String idOriginalDbColumnName(){
				
					return "id";
				
				}

				



    public void readData(ObjectInputStream dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_StewardshipWithdraw_Copy) {

        	try {

        		int length = 0;
		
			        this.id = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }
    
    public void readData(org.jboss.marshalling.Unmarshaller dis) {

		synchronized(commonByteArrayLock_DPDP_Batch_StewardshipWithdraw_Copy) {

        	try {

        		int length = 0;
		
			        this.id = dis.readInt();
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);

		

        }

		

      }


    }

    public void writeData(ObjectOutputStream dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }
    
    public void writeData(org.jboss.marshalling.Marshaller dos) {
        try {

		
					// int
				
		            	dos.writeInt(this.id);
					
        	} catch (IOException e) {
	            throw new RuntimeException(e);
        }


    }


    public String toString() {

		StringBuilder sb = new StringBuilder();
		sb.append(super.toString());
		sb.append("[");
		sb.append("id="+String.valueOf(id));
	    sb.append("]");

	    return sb.toString();
    }
        public String toLogString(){
        	StringBuilder sb = new StringBuilder();
        	
        				sb.append(id);
        			
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

public void tRESTRequest_1_LoopProcess(final java.util.Map<String, Object> globalMap) throws TalendException {
	globalMap.put("tRESTRequest_1_Loop_SUBPROCESS_STATE", 0);

	final boolean execStat = this.execStat;

		mdc("tRESTRequest_1_Loop", "fnE9M0_");

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



		deleteCustomerStruct deleteCustomer = new deleteCustomerStruct();
withdrawStruct withdraw = new withdrawStruct();



	
	/**
	 * [tRESTRequest_1_Loop begin ] start
	 */

				
			int NB_ITERATE_tRESTRequest_1_In = 0; //for statistics
			

	
		
		sh("tRESTRequest_1_Loop");
		
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_Loop");
	
			
			
	
		int tos_count_tRESTRequest_1_Loop = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTRequest_1_Loop", "CustomerRequest_Loop", "tRESTRequestLoop");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			
						
						
						if(enableLogStash){
							runStat.log(iterateId,0,0,"deleteCustomer","withdraw");
						}
						


					deleteCustomer = null;
			

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
	 * [tDataStewardshipTaskOutput_1 begin ] start
	 */

	

	
		
		sh("tDataStewardshipTaskOutput_1");
		
	
	s(currentComponent="tDataStewardshipTaskOutput_1");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"withdraw");
					}
				
		int tos_count_tDataStewardshipTaskOutput_1 = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tDataStewardshipTaskOutput_1", "tDataStewardshipTaskOutput_1", "tDataStewardshipTaskOutput");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			

boolean doesNodeBelongToRequest_tDataStewardshipTaskOutput_1 = 1 == 0;
@SuppressWarnings("unchecked")
java.util.Map<String, Object> restRequest_tDataStewardshipTaskOutput_1 = (java.util.Map<String, Object>)globalMap.get("restRequest");
String currentTRestRequestOperation_tDataStewardshipTaskOutput_1 = (String)(restRequest_tDataStewardshipTaskOutput_1 != null ? restRequest_tDataStewardshipTaskOutput_1.get("OPERATION") : null);
        if("deleteCustomer".equals(currentTRestRequestOperation_tDataStewardshipTaskOutput_1)) {
            doesNodeBelongToRequest_tDataStewardshipTaskOutput_1 = true;
        }
	

org.talend.components.api.component.ComponentDefinition def_tDataStewardshipTaskOutput_1 =
        new org.talend.components.datastewardship.tdatastewardshiptaskoutput.TDataStewardshipTaskOutputDefinition();

org.talend.components.api.component.runtime.Writer writer_tDataStewardshipTaskOutput_1 = null;
org.talend.components.api.component.runtime.Reader reader_tDataStewardshipTaskOutput_1 = null;


org.talend.components.datastewardship.tdatastewardshiptaskoutput.TDataStewardshipTaskOutputProperties props_tDataStewardshipTaskOutput_1 =
        (org.talend.components.datastewardship.tdatastewardshiptaskoutput.TDataStewardshipTaskOutputProperties) def_tDataStewardshipTaskOutput_1.createRuntimeProperties();
 		                    props_tDataStewardshipTaskOutput_1.setValue("batchSize",
 		                    50);
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("campaignName",
 		                    "c9d5dbce7d87cede9e0224bb3a48ca1d7");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("campaignLabel",
 		                    "Withdraw");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("campaignType",
 		                        org.talend.components.datastewardship.common.CampaignType.ARBITRATION);
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("laxSchema",
 		                    false);
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("taskPriority",
 		                    "NO_PRIORITY");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("taskTags",
 		                    "");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("taskState",
 		                    "New");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("taskAssignee",
 		                    "Custom");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("arbitrationChoice",
 		                    "1");
 		                    
 		                    props_tDataStewardshipTaskOutput_1.setValue("customAssignee",
 		                    "");
 		                    
 		                    java.util.List<Object> tDataStewardshipTaskOutput_1_taskCommentsTable_fieldName = new java.util.ArrayList<Object>();
 		                    
 		                            tDataStewardshipTaskOutput_1_taskCommentsTable_fieldName.add("Customer_Id");
 		                            
 		                            tDataStewardshipTaskOutput_1_taskCommentsTable_fieldName.add("Reason");
 		                            
 		                    ((org.talend.daikon.properties.Properties)props_tDataStewardshipTaskOutput_1.taskCommentsTable).setValue("fieldName",tDataStewardshipTaskOutput_1_taskCommentsTable_fieldName);
 		                    
 		                    java.util.List<Object> tDataStewardshipTaskOutput_1_taskCommentsTable_fieldComment = new java.util.ArrayList<Object>();
 		                    
 		                            tDataStewardshipTaskOutput_1_taskCommentsTable_fieldComment.add("");
 		                            
 		                            tDataStewardshipTaskOutput_1_taskCommentsTable_fieldComment.add("");
 		                            
 		                    ((org.talend.daikon.properties.Properties)props_tDataStewardshipTaskOutput_1.taskCommentsTable).setValue("fieldComment",tDataStewardshipTaskOutput_1_taskCommentsTable_fieldComment);
 		                    
 		                    java.util.List<Object> tDataStewardshipTaskOutput_1_httpConfig_keys = new java.util.ArrayList<Object>();
 		                    
 		                    ((org.talend.daikon.properties.Properties)props_tDataStewardshipTaskOutput_1.httpConfig).setValue("keys",tDataStewardshipTaskOutput_1_httpConfig_keys);
 		                    
 		                    java.util.List<Object> tDataStewardshipTaskOutput_1_httpConfig_values = new java.util.ArrayList<Object>();
 		                    
 		                    ((org.talend.daikon.properties.Properties)props_tDataStewardshipTaskOutput_1.httpConfig).setValue("values",tDataStewardshipTaskOutput_1_httpConfig_values);
 		                    
 		                    class SchemaSettingTool_tDataStewardshipTaskOutput_1_1_fisrt {
 		                    		
 		                    		String getSchemaValue() {
 		                    				
 		                    						StringBuilder s = new StringBuilder();
                    						
     		                    						a("{\"type\":\"record\",",s);
     		                    						
     		                    						a("\"name\":\"main\",\"fields\":[{",s);
     		                    						
     		                    						a("\"name\":\"Customer_Id\",\"type\":\"int\",\"di.table.comment\":\"integer\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Customer_Id\"},{",s);
     		                    						
     		                    						a("\"name\":\"Reason\",\"type\":\"string\",\"di.table.comment\":\"text\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"talend.field.dbColumnName\":\"Reason\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_DUE_DATE\",\"type\":\"long\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_DUE_DATE\"},{",s);
     		                    						
     		                    						a("\"name\":\"TDS_EXTERNAL_ID\",\"type\":\"string\",\"talend.isLocked\":\"true\",\"talend.field.generated\":\"true\",\"di.column.isNullable\":\"true\",\"talend.field.dbColumnName\":\"TDS_EXTERNAL_ID\"}]}",s);
     		                    						
     		                    				return s.toString();
     		                    		
 		                    		}
 		                    		
 		                    		void a(String part, StringBuilder strB) {
 		                    				strB.append(part);
 		                    		}
 		                    		
 		                    }
 		                    
 		                    SchemaSettingTool_tDataStewardshipTaskOutput_1_1_fisrt sst_tDataStewardshipTaskOutput_1_1_fisrt = new SchemaSettingTool_tDataStewardshipTaskOutput_1_1_fisrt();
 		                    
 		                    props_tDataStewardshipTaskOutput_1.schema.setValue("schema",
 		                        new org.apache.avro.Schema.Parser().setValidateDefaults(false).parse(sst_tDataStewardshipTaskOutput_1_1_fisrt.getSchemaValue()));
 		                    
 		                    props_tDataStewardshipTaskOutput_1.connection.setValue("url",
 		                    context.Stewardship_URL);
 		                    
 		                    props_tDataStewardshipTaskOutput_1.connection.setValue("username",
 		                    context.Stewardship_UserName);
 		                    
 		                    props_tDataStewardshipTaskOutput_1.connection.setValue("password",
 		                    context.Stewardship_Password);
 		                    
 		                    props_tDataStewardshipTaskOutput_1.connection.refConnection.setValue("referenceDefinitionName",
 		                    "datastewardship");
 		                    
    if (org.talend.components.api.properties.ComponentReferenceProperties.ReferenceType.COMPONENT_INSTANCE == props_tDataStewardshipTaskOutput_1.connection.refConnection.referenceType.getValue()) {
        final String referencedComponentInstanceId_tDataStewardshipTaskOutput_1 = props_tDataStewardshipTaskOutput_1.connection.refConnection.componentInstanceId.getStringValue();
        if (referencedComponentInstanceId_tDataStewardshipTaskOutput_1 != null) {
            org.talend.daikon.properties.Properties referencedComponentProperties_tDataStewardshipTaskOutput_1 = (org.talend.daikon.properties.Properties) globalMap.get(
                referencedComponentInstanceId_tDataStewardshipTaskOutput_1 + "_COMPONENT_RUNTIME_PROPERTIES");
            props_tDataStewardshipTaskOutput_1.connection.refConnection.setReference(referencedComponentProperties_tDataStewardshipTaskOutput_1);
        }
    }
globalMap.put("tDataStewardshipTaskOutput_1_COMPONENT_RUNTIME_PROPERTIES", props_tDataStewardshipTaskOutput_1);
globalMap.putIfAbsent("TALEND_PRODUCT_VERSION", "8.0");
globalMap.put("TALEND_COMPONENTS_VERSION", "0.37.46");
java.net.URL mappings_url_tDataStewardshipTaskOutput_1= this.getClass().getResource("/xmlMappings");
globalMap.put("tDataStewardshipTaskOutput_1_MAPPINGS_URL", mappings_url_tDataStewardshipTaskOutput_1);

org.talend.components.api.container.RuntimeContainer container_tDataStewardshipTaskOutput_1 = new org.talend.components.api.container.RuntimeContainer() {
    public Object getComponentData(String componentId, String key) {
        return globalMap.get(componentId + "_" + key);
    }

    public void setComponentData(String componentId, String key, Object data) {
        globalMap.put(componentId + "_" + key, data);
    }

    public String getCurrentComponentId() {
        return "tDataStewardshipTaskOutput_1";
    }

    public Object getGlobalData(String key) {
    	return globalMap.get(key);
    }
};

int nb_line_tDataStewardshipTaskOutput_1 = 0;

org.talend.components.api.component.ConnectorTopology topology_tDataStewardshipTaskOutput_1 = null;
topology_tDataStewardshipTaskOutput_1 = org.talend.components.api.component.ConnectorTopology.INCOMING;

org.talend.daikon.runtime.RuntimeInfo runtime_info_tDataStewardshipTaskOutput_1 = def_tDataStewardshipTaskOutput_1.getRuntimeInfo(
    org.talend.components.api.component.runtime.ExecutionEngine.DI, props_tDataStewardshipTaskOutput_1, topology_tDataStewardshipTaskOutput_1);
java.util.Set<org.talend.components.api.component.ConnectorTopology> supported_connector_topologies_tDataStewardshipTaskOutput_1 = def_tDataStewardshipTaskOutput_1.getSupportedConnectorTopologies();

org.talend.components.api.component.runtime.RuntimableRuntime componentRuntime_tDataStewardshipTaskOutput_1 = (org.talend.components.api.component.runtime.RuntimableRuntime)(Class.forName(runtime_info_tDataStewardshipTaskOutput_1.getRuntimeClassName()).newInstance());
org.talend.daikon.properties.ValidationResult initVr_tDataStewardshipTaskOutput_1 = componentRuntime_tDataStewardshipTaskOutput_1.initialize(container_tDataStewardshipTaskOutput_1, props_tDataStewardshipTaskOutput_1);

if (initVr_tDataStewardshipTaskOutput_1.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {
    throw new RuntimeException(initVr_tDataStewardshipTaskOutput_1.getMessage());
}

if(componentRuntime_tDataStewardshipTaskOutput_1 instanceof org.talend.components.api.component.runtime.ComponentDriverInitialization) {
	org.talend.components.api.component.runtime.ComponentDriverInitialization compDriverInitialization_tDataStewardshipTaskOutput_1 = (org.talend.components.api.component.runtime.ComponentDriverInitialization)componentRuntime_tDataStewardshipTaskOutput_1;
	compDriverInitialization_tDataStewardshipTaskOutput_1.runAtDriver(container_tDataStewardshipTaskOutput_1);
}

org.talend.components.api.component.runtime.SourceOrSink sourceOrSink_tDataStewardshipTaskOutput_1 = null;
if(componentRuntime_tDataStewardshipTaskOutput_1 instanceof org.talend.components.api.component.runtime.SourceOrSink) {
	sourceOrSink_tDataStewardshipTaskOutput_1 = (org.talend.components.api.component.runtime.SourceOrSink)componentRuntime_tDataStewardshipTaskOutput_1;
	if (doesNodeBelongToRequest_tDataStewardshipTaskOutput_1) {
        org.talend.daikon.properties.ValidationResult vr_tDataStewardshipTaskOutput_1 = sourceOrSink_tDataStewardshipTaskOutput_1.validate(container_tDataStewardshipTaskOutput_1);
        if (vr_tDataStewardshipTaskOutput_1.getStatus() == org.talend.daikon.properties.ValidationResult.Result.ERROR ) {
            throw new RuntimeException(vr_tDataStewardshipTaskOutput_1.getMessage());
        }
	}
}

    org.talend.codegen.enforcer.IncomingSchemaEnforcer incomingEnforcer_tDataStewardshipTaskOutput_1 = null;
    if (sourceOrSink_tDataStewardshipTaskOutput_1 instanceof org.talend.components.api.component.runtime.Sink) {
    	org.talend.components.api.component.runtime.Sink sink_tDataStewardshipTaskOutput_1 =
            	(org.talend.components.api.component.runtime.Sink)sourceOrSink_tDataStewardshipTaskOutput_1;
        org.talend.components.api.component.runtime.WriteOperation writeOperation_tDataStewardshipTaskOutput_1 = sink_tDataStewardshipTaskOutput_1.createWriteOperation();
        if (doesNodeBelongToRequest_tDataStewardshipTaskOutput_1) {
            writeOperation_tDataStewardshipTaskOutput_1.initialize(container_tDataStewardshipTaskOutput_1);
        }
        writer_tDataStewardshipTaskOutput_1 = writeOperation_tDataStewardshipTaskOutput_1.createWriter(container_tDataStewardshipTaskOutput_1);
        if (doesNodeBelongToRequest_tDataStewardshipTaskOutput_1) {
            writer_tDataStewardshipTaskOutput_1.open("tDataStewardshipTaskOutput_1");
        }

        resourceMap.put("writer_tDataStewardshipTaskOutput_1", writer_tDataStewardshipTaskOutput_1);
    } // end of "sourceOrSink_tDataStewardshipTaskOutput_1 instanceof ...Sink"
    org.talend.components.api.component.Connector c_tDataStewardshipTaskOutput_1 = null;
    for (org.talend.components.api.component.Connector currentConnector : props_tDataStewardshipTaskOutput_1.getAvailableConnectors(null, false)) {
        if (currentConnector.getName().equals("MAIN")) {
            c_tDataStewardshipTaskOutput_1 = currentConnector;
            break;
        }
    }
    org.apache.avro.Schema designSchema_tDataStewardshipTaskOutput_1 = props_tDataStewardshipTaskOutput_1.getSchema(c_tDataStewardshipTaskOutput_1, false);
    incomingEnforcer_tDataStewardshipTaskOutput_1 = new org.talend.codegen.enforcer.IncomingSchemaEnforcer(designSchema_tDataStewardshipTaskOutput_1);

                java.lang.Iterable<?> outgoingMainRecordsList_tDataStewardshipTaskOutput_1 = new java.util.ArrayList<Object>();
                java.util.Iterator outgoingMainRecordsIt_tDataStewardshipTaskOutput_1 = null;


 



		

/**
 * [tDataStewardshipTaskOutput_1 begin ] stop
 */




	
	/**
	 * [tMap_1 begin ] start
	 */

	

	
		
		sh("tMap_1");
		
	
	s(currentComponent="tMap_1");
	
			
			
	
					if(enableLogStash) {
						runStat.log(resourceMap,iterateId,0,0,"deleteCustomer");
					}
				
		int tos_count_tMap_1 = 0;
		
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Start to work.") );
            if (log.isDebugEnabled()) {
                class BytesLimit65535_tMap_1{
                    public void limitLog4jByte() throws Exception{
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
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + (log4jParamters_tMap_1) );
                    } 
                } 
            new BytesLimit65535_tMap_1().limitLog4jByte();
            }
			if(enableLogStash) {
				talendJobLog.addCM("tMap_1", "tMap_1", "tMap");
				talendJobLogProcess(globalMap);
				s(currentComponent);
			}
			




// ###############################
// # Lookup's keys initialization
		int count_deleteCustomer_tMap_1 = 0;
		
// ###############################        

// ###############################
// # Vars initialization
class  Var__tMap_1__Struct  {
}
Var__tMap_1__Struct Var__tMap_1 = new Var__tMap_1__Struct();
// ###############################

// ###############################
// # Outputs initialization
				int count_withdraw_tMap_1 = 0;
				
withdrawStruct withdraw_tmp = new withdrawStruct();
// ###############################

        
        



        









 



		

/**
 * [tMap_1 begin ] stop
 */




	
	/**
	 * [tRESTRequest_1_In begin ] start
	 */

	

	
		
		sh("tRESTRequest_1_In");
		
	
		currentVirtualComponent = "tRESTRequest_1";
	
	s(currentComponent="tRESTRequest_1_In");
	
			
			
	
		int tos_count_tRESTRequest_1_In = 0;
		
			if(enableLogStash) {
				talendJobLog.addCM("tRESTRequest_1_In", "CustomerRequest_In", "tRESTRequestIn");
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
						deleteCustomer = null;
		} else { // non-error (not wrong request)

			String matchedUriPattern_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("PATTERN");
			String matchedFlow_tRESTRequest_1 = (String) requestMessage_tRESTRequest_1.get("OPERATION");

			java.util.Map<String, Object> params_tRESTRequest_1 =
				(java.util.Map<String, Object>) requestMessage_tRESTRequest_1.get("PARAMS");
					if (matchedFlow_tRESTRequest_1.equals("deleteCustomer")) {
						deleteCustomer = new deleteCustomerStruct();
								if (params_tRESTRequest_1.containsKey("PATH:id:id_Integer")) {
									
										
										deleteCustomer.id = (Integer) params_tRESTRequest_1.get("PATH:id:id_Integer");
									
								}
					} else { // non matched flow
						deleteCustomer = null;
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

// Start of branch "deleteCustomer"
if(deleteCustomer != null) { 



	
	/**
	 * [tMap_1 main ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"deleteCustomer","tRESTRequest_1_In","CustomerRequest_In","tRESTRequestIn","tMap_1","tMap_1","tMap"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("deleteCustomer - " + (deleteCustomer==null? "": deleteCustomer.toLogString()));
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

withdraw = null;


// # Output table : 'withdraw'
count_withdraw_tMap_1++;

withdraw_tmp.Customer_Id = deleteCustomer.id ;
withdraw_tmp.Reason = "Withdraw";
withdraw_tmp.TDS_DUE_DATE = null;
withdraw_tmp.TDS_EXTERNAL_ID = null;
withdraw = withdraw_tmp;
log.debug("tMap_1 - Outputting the record " + count_withdraw_tMap_1 + " of the output table 'withdraw'.");

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

	

	
	
	s(currentComponent="tMap_1");
	
			
		
		
					if (deleteCustomer != null) {
		
		
	

 



	
	
				}
		

/**
 * [tMap_1 process_data_begin ] stop
 */

// Start of branch "withdraw"
if(withdraw != null) { 



	
	/**
	 * [tDataStewardshipTaskOutput_1 main ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskOutput_1");
	
			
			
	
					if(enableLogStash) {
						if(runStat.updateLog(iterateId,1,1
						
							,"withdraw","tMap_1","tMap_1","tMap","tDataStewardshipTaskOutput_1","tDataStewardshipTaskOutput_1","tDataStewardshipTaskOutput"
						
						)) {
							talendJobLogProcess(globalMap);
						}
					}
					
    			if(log.isTraceEnabled()){
    				log.trace("withdraw - " + (withdraw==null? "": withdraw.toLogString()));
    			}
    		

            boolean shouldCreateRuntimeSchemaForIncomingNode = false;
                    if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getDesignSchema().getField("Customer_Id") == null){
                        incomingEnforcer_tDataStewardshipTaskOutput_1.addIncomingNodeField("Customer_Id", ((Object) withdraw.Customer_Id).getClass().getCanonicalName());
                        shouldCreateRuntimeSchemaForIncomingNode = true;
                    }
                    if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getDesignSchema().getField("Reason") == null){
                        incomingEnforcer_tDataStewardshipTaskOutput_1.addIncomingNodeField("Reason", ((Object) withdraw.Reason).getClass().getCanonicalName());
                        shouldCreateRuntimeSchemaForIncomingNode = true;
                    }
                    if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getDesignSchema().getField("TDS_DUE_DATE") == null){
                        incomingEnforcer_tDataStewardshipTaskOutput_1.addIncomingNodeField("TDS_DUE_DATE", ((Object) withdraw.TDS_DUE_DATE).getClass().getCanonicalName());
                        shouldCreateRuntimeSchemaForIncomingNode = true;
                    }
                    if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getDesignSchema().getField("TDS_EXTERNAL_ID") == null){
                        incomingEnforcer_tDataStewardshipTaskOutput_1.addIncomingNodeField("TDS_EXTERNAL_ID", ((Object) withdraw.TDS_EXTERNAL_ID).getClass().getCanonicalName());
                        shouldCreateRuntimeSchemaForIncomingNode = true;
                    }
            if (shouldCreateRuntimeSchemaForIncomingNode && incomingEnforcer_tDataStewardshipTaskOutput_1 != null){
                incomingEnforcer_tDataStewardshipTaskOutput_1.createRuntimeSchema();
            }
        if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null) {
            incomingEnforcer_tDataStewardshipTaskOutput_1.createNewRecord();
        }
                //skip the put action if the input column doesn't appear in component runtime schema
                if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getRuntimeSchema().getField("Customer_Id") != null){
                    incomingEnforcer_tDataStewardshipTaskOutput_1.put("Customer_Id", withdraw.Customer_Id);
                }
                //skip the put action if the input column doesn't appear in component runtime schema
                if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getRuntimeSchema().getField("Reason") != null){
                    incomingEnforcer_tDataStewardshipTaskOutput_1.put("Reason", withdraw.Reason);
                }
                //skip the put action if the input column doesn't appear in component runtime schema
                if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getRuntimeSchema().getField("TDS_DUE_DATE") != null){
                    incomingEnforcer_tDataStewardshipTaskOutput_1.put("TDS_DUE_DATE", withdraw.TDS_DUE_DATE);
                }
                //skip the put action if the input column doesn't appear in component runtime schema
                if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null && incomingEnforcer_tDataStewardshipTaskOutput_1.getRuntimeSchema().getField("TDS_EXTERNAL_ID") != null){
                    incomingEnforcer_tDataStewardshipTaskOutput_1.put("TDS_EXTERNAL_ID", withdraw.TDS_EXTERNAL_ID);
                }
 		                    props_tDataStewardshipTaskOutput_1.setValue("customAssignee",
 		                    "");
 		                    
        
        org.apache.avro.generic.IndexedRecord data_tDataStewardshipTaskOutput_1 = null;
        if (incomingEnforcer_tDataStewardshipTaskOutput_1 != null) {
            data_tDataStewardshipTaskOutput_1 = incomingEnforcer_tDataStewardshipTaskOutput_1.getCurrentRecord();
        }
        
        if (writer_tDataStewardshipTaskOutput_1 != null && data_tDataStewardshipTaskOutput_1 != null) {
        	writer_tDataStewardshipTaskOutput_1.write(data_tDataStewardshipTaskOutput_1);
        }
        
        nb_line_tDataStewardshipTaskOutput_1++;

 


	tos_count_tDataStewardshipTaskOutput_1++;

		

/**
 * [tDataStewardshipTaskOutput_1 main ] stop
 */

	
	/**
	 * [tDataStewardshipTaskOutput_1 process_data_begin ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskOutput_1");
	
			
		
		
		
	


 



	
		

/**
 * [tDataStewardshipTaskOutput_1 process_data_begin ] stop
 */

	
	/**
	 * [tDataStewardshipTaskOutput_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskOutput_1");
	
			
		
		
		
	


 



	
		

/**
 * [tDataStewardshipTaskOutput_1 process_data_end ] stop
 */


} // End of branch "withdraw"




	
	/**
	 * [tMap_1 process_data_end ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
		
		
					if (deleteCustomer != null) {
		
		
	

 



	
	
				}
		

/**
 * [tMap_1 process_data_end ] stop
 */


} // End of branch "deleteCustomer"




	
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
	 * [tMap_1 end ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
		
		
					if (deleteCustomer != null) {
		
		
	


// ###############################
// # Lookup hashes releasing
// ###############################      
				log.debug("tMap_1 - Written records count in the table 'withdraw': " + count_withdraw_tMap_1 + ".");





				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"deleteCustomer",2,0,
				 			"tRESTRequest_1_In","CustomerRequest_In","tRESTRequestIn","tMap_1","tMap_1","tMap","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 
                if(log.isDebugEnabled())
            log.debug("tMap_1 - "  + ("Done.") );

ok_Hash.put("tMap_1", true);
end_Hash.put("tMap_1", System.currentTimeMillis());




	
	
				}
		

/**
 * [tMap_1 end ] stop
 */


	
	/**
	 * [tDataStewardshipTaskOutput_1 end ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskOutput_1");
	
			
		
		
		
	
// end of generic


resourceMap.put("finish_tDataStewardshipTaskOutput_1", Boolean.TRUE);

    java.util.Map<String, Object> resultMap_tDataStewardshipTaskOutput_1 = null;
    if (writer_tDataStewardshipTaskOutput_1 != null) {
        org.talend.components.api.component.runtime.Result resultObject_tDataStewardshipTaskOutput_1 = (org.talend.components.api.component.runtime.Result)writer_tDataStewardshipTaskOutput_1.close();
        resultMap_tDataStewardshipTaskOutput_1 = writer_tDataStewardshipTaskOutput_1.getWriteOperation().finalize(java.util.Arrays.<org.talend.components.api.component.runtime.Result>asList(resultObject_tDataStewardshipTaskOutput_1), container_tDataStewardshipTaskOutput_1);
    }
if(resultMap_tDataStewardshipTaskOutput_1!=null) {
	for(java.util.Map.Entry<String,Object> entry_tDataStewardshipTaskOutput_1 : resultMap_tDataStewardshipTaskOutput_1.entrySet()) {
		switch(entry_tDataStewardshipTaskOutput_1.getKey()) {
		case org.talend.components.api.component.ComponentDefinition.RETURN_ERROR_MESSAGE :
			container_tDataStewardshipTaskOutput_1.setComponentData("tDataStewardshipTaskOutput_1", "ERROR_MESSAGE", entry_tDataStewardshipTaskOutput_1.getValue());
			break;
		case org.talend.components.api.component.ComponentDefinition.RETURN_TOTAL_RECORD_COUNT :
			container_tDataStewardshipTaskOutput_1.setComponentData("tDataStewardshipTaskOutput_1", "NB_LINE", entry_tDataStewardshipTaskOutput_1.getValue());
			break;
		case org.talend.components.api.component.ComponentDefinition.RETURN_SUCCESS_RECORD_COUNT :
			container_tDataStewardshipTaskOutput_1.setComponentData("tDataStewardshipTaskOutput_1", "NB_SUCCESS", entry_tDataStewardshipTaskOutput_1.getValue());
			break;
		case org.talend.components.api.component.ComponentDefinition.RETURN_REJECT_RECORD_COUNT :
			container_tDataStewardshipTaskOutput_1.setComponentData("tDataStewardshipTaskOutput_1", "NB_REJECT", entry_tDataStewardshipTaskOutput_1.getValue());
			break;
		default :
            StringBuilder studio_key_tDataStewardshipTaskOutput_1 = new StringBuilder();
            for (int i_tDataStewardshipTaskOutput_1 = 0; i_tDataStewardshipTaskOutput_1 < entry_tDataStewardshipTaskOutput_1.getKey().length(); i_tDataStewardshipTaskOutput_1++) {
                char ch_tDataStewardshipTaskOutput_1 = entry_tDataStewardshipTaskOutput_1.getKey().charAt(i_tDataStewardshipTaskOutput_1);
                if(Character.isUpperCase(ch_tDataStewardshipTaskOutput_1) && i_tDataStewardshipTaskOutput_1> 0) {
                	studio_key_tDataStewardshipTaskOutput_1.append('_');
                }
                studio_key_tDataStewardshipTaskOutput_1.append(ch_tDataStewardshipTaskOutput_1);
            }
			container_tDataStewardshipTaskOutput_1.setComponentData("tDataStewardshipTaskOutput_1", studio_key_tDataStewardshipTaskOutput_1.toString().toUpperCase(java.util.Locale.ENGLISH), entry_tDataStewardshipTaskOutput_1.getValue());
			break;
		}
	}
}

				if(enableLogStash) {
				
				 		if(runStat.log(resourceMap,iterateId,"withdraw",2,0,
				 			"tMap_1","tMap_1","tMap","tDataStewardshipTaskOutput_1","tDataStewardshipTaskOutput_1","tDataStewardshipTaskOutput","output")) {
							talendJobLogProcess(globalMap);
						}
					
			  	}
			  	
 

ok_Hash.put("tDataStewardshipTaskOutput_1", true);
end_Hash.put("tDataStewardshipTaskOutput_1", System.currentTimeMillis());




	
		

/**
 * [tDataStewardshipTaskOutput_1 end ] stop
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
					runStat.log(iterateId,2,0,"deleteCustomer","withdraw");
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
	 * [tMap_1 finally ] start
	 */

	

	
	
	s(currentComponent="tMap_1");
	
			
			
	

 



		

/**
 * [tMap_1 finally ] stop
 */


	
	/**
	 * [tDataStewardshipTaskOutput_1 finally ] start
	 */

	

	
	
	s(currentComponent="tDataStewardshipTaskOutput_1");
	
			
			
	
// finally of generic


if(resourceMap.get("finish_tDataStewardshipTaskOutput_1")==null){
    if(resourceMap.get("writer_tDataStewardshipTaskOutput_1")!=null){
		try {
			((org.talend.components.api.component.runtime.Writer)resourceMap.get("writer_tDataStewardshipTaskOutput_1")).close();
		} catch (java.io.IOException e_tDataStewardshipTaskOutput_1) {
			String errorMessage_tDataStewardshipTaskOutput_1 = "failed to release the resource in tDataStewardshipTaskOutput_1 :" + e_tDataStewardshipTaskOutput_1.getMessage();
			System.err.println(errorMessage_tDataStewardshipTaskOutput_1);
		}
	}
}
 



		

/**
 * [tDataStewardshipTaskOutput_1 finally ] stop
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
        final Batch_StewardshipWithdraw_Copy Batch_StewardshipWithdraw_CopyClass = new Batch_StewardshipWithdraw_Copy();

        int exitCode = Batch_StewardshipWithdraw_CopyClass.runJobInTOS(args);
	        if(exitCode==0){
		        log.info("TalendJob: 'Batch_StewardshipWithdraw_Copy' - Done.");
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
			log.info("TalendJob: 'Batch_StewardshipWithdraw_Copy' - Start.");
		

                java.util.Set<Object> jobInfoKeys = jobInfo.keySet();
                for(Object jobInfoKey: jobInfoKeys) {
                    org.slf4j.MDC.put("_" + jobInfoKey.toString(), jobInfo.get(jobInfoKey).toString());
                }
                org.slf4j.MDC.put("_pid", pid);
                org.slf4j.MDC.put("_rootPid", rootPid);
                org.slf4j.MDC.put("_fatherPid", fatherPid);
                org.slf4j.MDC.put("_projectName", projectName);
                org.slf4j.MDC.put("_startTimestamp",java.time.ZonedDateTime.now(java.time.ZoneOffset.UTC ).format( java.time.format.DateTimeFormatter.ISO_INSTANT ));
                org.slf4j.MDC.put("_jobRepositoryId","_IRW_gFApEfC4ZuKDeZl3GA");
                org.slf4j.MDC.put("_compiledAtTimestamp","2025-07-02T09:09:51.433666600Z");

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
            java.io.InputStream inContext = Batch_StewardshipWithdraw_Copy.class.getClassLoader().getResourceAsStream("dpdp/batch_stewardshipwithdraw_copy_0_4/contexts/" + contextStr + ".properties");
            if (inContext == null) {
                inContext = Batch_StewardshipWithdraw_Copy.class.getClassLoader().getResourceAsStream("config/contexts/" + contextStr + ".properties");
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
        if (parentContextMap != null && !parentContextMap.isEmpty()) {if (parentContextMap.containsKey("Stewardship_Password")) {
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
            log.info("TalendJob: 'Batch_StewardshipWithdraw_Copy' - Started.");
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
            System.out.println((endUsedMemory - startUsedMemory) + " bytes memory increase when running : Batch_StewardshipWithdraw_Copy");
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
        log.info("TalendJob: 'Batch_StewardshipWithdraw_Copy' - Finished - status: " + status + " returnCode: " + returnCode );

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
 *     133668 characters generated by Talend Real-time Big Data Platform 
 *     on the 2 July 2025 at 2:39:51 pm IST
 ************************************************************************************************/