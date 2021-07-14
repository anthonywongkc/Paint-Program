# Simple Console version of a Paint program

####Intro
The program should work as follows:
1. Create a new canvas
2. Start drawing on the canvas by issuing various commands
3. Quit

Command | Description
------------- | -------------
C w h  | Should create a new canvas of width w and height h.
L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2). Currently only horizontal or vertical lin Horizontal and vertical lines will be drawn using the 'x' character.
R x1 y1 x2 y2 | Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corn and vertical lines will be drawn using the 'x' character.
B x y c | Should fill the entire area connected to (x,y) with "colour" c. The behaviour of this is th "bucket fill" tool in paint programs.
Q | Should quit the program.
H | Should print usage of the program

####Instruction
Install Gradle
Go to Paint Program folder and run the following command to run the program.
```shell
gradle wrapper
# Windows
gradlew.bat build
# Linux or Mac
./gradlew build 
java -jar build/libs/Paint-Program-1.0-SNAPSHOT.jar
```

####Special Cases Handling
1. Users try to create perform other actions when canvas is not created. The program will return warning message to ask user to create canvas first.
2. (x1,y1) is larger than (x2,y2) when users want to draw horizontal line or vertical line. The program will reoder the points and draw the line.
3. Users perform "bucket fill" with color "x". The program will not perform any action.

####Assumption
1. The program supports listed commands only. If users input other commands, it will print usage page.
2. Users need to create new canvas if they need to clear the exisiting drawing
