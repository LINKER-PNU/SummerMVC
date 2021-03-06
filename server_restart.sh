#/bin/bash
cd ~/SummerMVC/linker
chmod +x ./gradlew
./gradlew build -x test
PROC=`ps -ef | grep "java -jar" | awk '{print $2}' |  head -n 1`
kill -9 $PROC
nohup java -jar -Duser.timezone=KST build/libs/linker-0.0.1-SNAPSHOT.jar &
tail -f ~/SummerMVC/linker/nohup.out
