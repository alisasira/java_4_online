#!/bin/sh

echo 'run Alisa Sira reverse text'
javac -sourcepath ./java -d build/classes -cp ./lib/commons-lang3-3.12.0.jar java/hw/unit1/level2/SecondPrint.java java/hw/unit1/level2/NewYear.java
cp -r lib/*.jar build/jar
jar cvfm build/jar/new-year-print.jar resources/MANIFEST.MF -C build/classes .

echo ''
echo '----------'
echo 'jar contains:'
jar -tf build/jar/new-year-print.jar
echo '----------'
java -jar build/jar/new-year-print.jar