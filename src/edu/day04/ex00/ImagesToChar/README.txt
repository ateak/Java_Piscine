# deleting the dir
rm -rf target

# creating a new dir
mkdir target

# set the destination dir for class files
javac src/java/edu/school21/printer/*/*.java -d ./target

# specify where to find user class files
java -classpath ./target edu/school21/printer/app/Program . 0 /Users/ateak/IdeaProjects/Java_Piscine/src/edu/day04/ex00/ImagesToChar/src/resources/image.bmp