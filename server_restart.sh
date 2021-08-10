#/bin/bash
ps -ef | grep java
kill -9 
cd ~/SummerMVC/linker
chmod +x ./gradlew
./gradlew build -x test
java -jar build/libs/
