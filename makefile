JC = javac
JFLAGS = -g

default:
	$(JC) $(JFLAGS) Driver.java

#The \ works as a line delimiter. It will concatenate the stringss on each line so the commands must be separated by semicolons
clean:
	rm *~; \
	rm *.class; \
	rm animal/*.class; \
	rm animal/*~; \
	rm animal/mammal/*.class \
	rm animal/mammal/*~; \
	rm animal/reptile/*.class \
	rm animal/reptile/*~; \
	rm animal/bird/*.class \
	rm animal/bird/*~; \
	rm animal/fish/*.class \
	rm animal/fish/*~; \
	rm linkedlist/*.class \
	rm linkedlist/*~;

