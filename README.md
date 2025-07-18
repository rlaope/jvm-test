```sh
$ jenv shell 17 # 난 17 안써서 ㅎㅎ;;

$ java \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:HeapDumpPath=./ \
  -XX:OnOutOfMemoryError="kill -9 %p" \
  -Xmx1024m -Xms1024m \
  "-Xlog:gc*:file=./gc.log:time,uptime,level,tags" \
  -XX:+UseContainerSupport \
  -XX:+AlwaysPreTouch \
  -XX:+ExitOnOutOfMemoryError \
  -XX:+UnlockDiagnosticVMOptions \
  -XX:+PrintCodeCache \
  -XX:+PrintFlagsFinal \
  -jar jvm-test-0.0.1-SNAPSHOT.jar
 
$ jps -lv | grep java  # or jcmd

$ jcmd <pid> VM.native_memory summary

$ jstack <pid> > thread_dump.txt
```