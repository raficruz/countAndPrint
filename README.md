# Count And Change Application
Count and print whole integer numbers to the console, start from a informed number ***s***, and print all numbers going up to the also informed limit number ***l***.
However, when the number is divisible by a informed value ***d1***, do not print the number n, but print the word ***w1***.
You also can inform more than one divisor number. When the number is divisible by a second informed value ***d2***, do not print the number ***n2***, but print the word ***w2***.

## Example:
- ***s*** = 1
- ***l*** = 7
- ***d1*** = 2
- ***w1*** = "By_Two"
- ***d2*** = 3
- ***s2*** = "By_Three"

When Application runs with this parameters, this text will be printed in console:
***"1", "By_Two", "By_Three", "By_Two", "5", "By_Two By_Three", "7"***

Note that: 
- 2, 4 are divisible by two, so application replaces by ***w1*** value, "By_Two"
- 3 is divisible by itself, so  application replaces by ***w2*** value, "By_Three"
- 6 is divisible by 2 and 3, so  application replaces by ***w1*** and ***w2*** concatenated value, "By_Two By_Three"

## Installation

This API requires [Java 8+](https://www.oracle.com/br/java/technologies/javase/javase8-archive-downloads.html) and [Apache Maven](https://maven.apache.org/) to run.

Go to application directory.
Install the dependencies and build a fat Jar before running the application.

```sh
cd <application_directory>
mvn clean install
java -jar target/counting-1.0-jar-with-dependencies.jar 1 50 2 V 3 N
```

Application will count from ***1*** to ***50*** and replaces any value divisible by ***2*** for ***"V"***, any value divisible by ***3*** for ***"N"*** and any value divisible by 2 and 3 for ***"V N"***

## License

MIT

**Free Software, Yeah!**