# HOW TO RUN ?
Just compile the code first "javac -d ./bin src/main.java" and then you can build the jar to run it "jar cfm faultLocalizer.jar Manifest.txt -C bin/ ."

# HOW IT WORKS ?
It first load the given script then pass it to a code tester that will find bugs and calculate the total number of either executed or not executed statements with and without fail
then it will be returned and those values will be passed into the tarantula method that will use the mathematical formula to calculate metric and print the results.

# faultLocalizer
implementation of tarantula metric based code for fault localization

# MADE BY
Mohamed-Nazim BELABED
Shifat Sahariar