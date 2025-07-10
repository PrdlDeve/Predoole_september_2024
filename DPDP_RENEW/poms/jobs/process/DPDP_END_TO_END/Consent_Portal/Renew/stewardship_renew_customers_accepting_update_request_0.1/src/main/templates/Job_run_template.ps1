$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' '--add-opens=java.base/java.net=ALL-UNNAMED' '--add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED' -cp 'null' dpdp_renew.stewardship_renew_customers_accepting_update_request_0_1.Stewardship_Renew_Customers_Accepting_Update_Request --context=Default $args
