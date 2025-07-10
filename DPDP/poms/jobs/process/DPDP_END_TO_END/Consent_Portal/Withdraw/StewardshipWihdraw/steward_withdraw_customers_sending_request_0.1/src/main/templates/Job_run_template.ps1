$fileDir = Split-Path -Parent $MyInvocation.MyCommand.Path
cd $fileDir
java '-Dtalend.component.manager.m2.repository=%cd%/../lib' '-Xms256M' '-Xmx1024M' '-Dfile.encoding=UTF-8' '--add-opens=java.base/java.net=ALL-UNNAMED' '--add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED' -cp 'null' dpdp.steward_withdraw_customers_sending_request_0_1.Steward_Withdraw_Customers_Sending_Request $args
