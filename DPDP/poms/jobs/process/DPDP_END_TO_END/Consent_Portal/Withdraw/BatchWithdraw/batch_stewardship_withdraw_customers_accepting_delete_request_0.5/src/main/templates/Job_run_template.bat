%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED -cp ${talend.job.bat.classpath} dpdp.batch_stewardship_withdraw_customers_accepting_delete_request_0_5.Batch_Stewardship_Withdraw_Customers_Accepting_Delete_Request %*
