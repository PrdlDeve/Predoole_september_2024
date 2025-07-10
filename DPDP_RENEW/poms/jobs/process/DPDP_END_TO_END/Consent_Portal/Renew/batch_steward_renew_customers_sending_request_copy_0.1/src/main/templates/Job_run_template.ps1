$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' '--add-opens=java.base/java.net=ALL-UNNAMED' '--add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED' -cp 'null' dpdp_renew.batch_steward_renew_customers_sending_request_copy_0_1.Batch_Steward_Renew_Customers_Sending_Request_Copy --context=Default $args
