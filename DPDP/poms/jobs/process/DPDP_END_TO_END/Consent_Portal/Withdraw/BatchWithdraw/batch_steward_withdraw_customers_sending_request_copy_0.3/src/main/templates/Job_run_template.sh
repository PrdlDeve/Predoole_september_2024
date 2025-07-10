#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 --add-opens=java.base/java.net=ALL-UNNAMED --add-opens=java.base/sun.net.www.protocol.https=ALL-UNNAMED -cp ${talend.job.sh.classpath} dpdp.batch_steward_withdraw_customers_sending_request_copy_0_3.Batch_Steward_Withdraw_Customers_Sending_Request_Copy --context=Default "$@"
