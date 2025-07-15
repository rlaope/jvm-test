```sh
$ jenv shell 17 # 난 17 안써서 ㅎㅎ;;

$ java \
  -Xms128M \
  -Xmx128M \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:NativeMemoryTracking=detail
  -XX:HeapDumpPath=./ \
  -XX:OnOutOfMemoryError="kill -9 %p" \
  -jar jvm-test-0.0.1-SNAPSHOT.jar
  
$ jps -lv | grep java  # or jcmd

$ jcmd <pid> VM.native_memory summary

$ jstack <pid> > thread_dump.txt
```