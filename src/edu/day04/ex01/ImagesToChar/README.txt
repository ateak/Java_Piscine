# deleting the dir
rm -rf target

# creating a new dir
mkdir target

# compiling sourcecode to target directory with compiled .class files
javac -d target src/java/edu/school21/printer/*/*.java

# copy resources to destination directory
cp -R src/resources target/.

# create JAR archive
jar cfm ./target/images-to-chars-printer.jar ./src/manifest.txt -C target .

# set rights
chmod 777 ./target/images-to-chars-printer.jar

# Run program from archive with specific parameters:
# param 1: white color
# param 2: black color
java -jar ./target/images-to-chars-printer.jar . 0



