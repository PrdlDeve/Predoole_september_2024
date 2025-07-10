%~d0
cd %~dp0
java -Dtalend.component.manager.m2.repository=../lib -Xms256M -Xmx1024M -Dfile.encoding=UTF-8 -cp ${talend.job.bat.classpath} dpdp.batch_stewardshipwithdraw_copy_0_1.Batch_StewardshipWithdraw_Copy %*
