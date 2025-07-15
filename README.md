```sh
java \
  -Xms128M \
  -Xmx128M \
  -XX:+HeapDumpOnOutOfMemoryError \
  -XX:HeapDumpPath=./ \
  -XX:OnOutOfMemoryError="kill -9 %p" \
  -jar jvm-test-0.0.1-SNAPSHOT.jar
```