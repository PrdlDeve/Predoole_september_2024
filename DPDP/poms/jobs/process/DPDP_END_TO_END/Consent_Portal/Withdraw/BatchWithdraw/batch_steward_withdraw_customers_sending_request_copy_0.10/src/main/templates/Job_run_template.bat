%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED -cp ${talend.job.bat.classpath} dpdp.batch_steward_withdraw_customers_sending_request_copy_0_10.Batch_Steward_Withdraw_Customers_Sending_Request_Copy %*
