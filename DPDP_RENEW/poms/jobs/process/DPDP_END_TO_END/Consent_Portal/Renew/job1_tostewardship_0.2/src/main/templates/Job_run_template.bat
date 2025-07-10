%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp ${talend.job.bat.classpath} dpdp_renew.job1_tostewardship_0_2.Job1_ToStewardship --context=Default %*
