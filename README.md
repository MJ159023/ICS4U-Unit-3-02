# ICS4U - Java
Place your Java code in the `root` directory.

For example create a file called `HelloWorld.java`.

## To Compile and Run your Code
Run `javac` to compile your code and `java` to run it, in the terminal inside the `root` directory.
Run `g++ -o` to compile your code and your application to run it.

For example:

```shell
javac HelloWorld.java
java HelloWorld

g++ -o main.app main.cpp
./main.app
```

## To Lint your Code
Run the following command in the terminal inside the `root` directory to run the Java Linter:

```shell
./run_linter.sh

#c++
cpplint ./main.app
```

## To Design your Code
Go inside the `> 📁 design` folder:
- click on ```class_diagrams.drawio``` to draw your Class Diagrams
- to **export** the diagrams as a ```*.png``` image file:
  - go to "File, Export..., .png Exports the file to a png file, and click OK
  - then go to the `> 📁 design` folder and **right click** over the *.png file and select **Download...**

## To create Java Documentation of your Code
Run the following command in the terminal inside the `root` directory:
```shell
javadoc -d ./docs ./*.java
```
then click on the ```Go Live``` button at the bottom in the status bar 
or goto the `> 📁 docs` folder and right clicking on ***index.html*** and selecting ***Open with Live Server***.