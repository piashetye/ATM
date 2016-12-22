#ATM program

This is a simple java ATM application with 4 options: Balance, Deposit, Withdrawal, Quit.

##Running the program

Compile and run the program using javac and java:
>javac src/BankAccount.java

>java BankAccount

Optionally you might need to setup CLASSPATH using -classpath or -cp to specify the location of user classes.
>e.g.  java -classpath /Users/pia/MyProjects/ATM/src BankAccount 

##Unit Tests

Some sample junit tests are added to ATMTests.java. TestRunner class is used to execute these tests.
The javac and java utilities can be used to run them:
>javac src/TestRunner.java

>java TestRunner

P.S.: junit and hamcrest.core jars should be added to classpath. If not, specify the same with -cp option.

>e.g.  java -cp /Users/pia/MyProjects/ATM/src:/Users/pia/.p2/pool/plugins/org.junit_4.12.0.v201504281640/junit.jar:/Users/pia/.p2/pool/plugins/org.hamcrest.core_1.3.0.v201303031735.jar TestRunner
