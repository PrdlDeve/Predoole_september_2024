#!/bin/sh
cd `dirname $0`
ROOT_PATH=`pwd`
java -Dtalend.component.manager.m2.repository=$ROOT_PATH/../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp ${talend.job.sh.classpath} dpdp_renew.job1_tostewardship_0_2.Job1_ToStewardship --context=Default "$@"
