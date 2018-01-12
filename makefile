JC = javac



.SUFFIXES: .java .class
.java.class:
	$(JC) -d build/ $*.java
	

CLASSES = \
        mining/Display.java \
        mining/Mining.java \
        mining/Sh.java \
        mining/TriggerCPU.java \
        mining/TriggerGPU.java



default: classes


classes: $(CLASSES:.java=.class)


clean:
	$(RM)r build/*
	
install:
	
	rm -rf build/dist
	mkdir build/dist/
	echo "main-class: mining.Mining" > build/Manifest.txt
	jar cvfm build/dist/Mining.jar build/Manifest.txt build/mining
	mv build/dist/Mining.jar build/dist/Mining.zip
	unzip build/dist/Mining.zip -d build/dist/
	mv build/dist/build/mining build/dist/
	rm -rf build/dist/build/
	rm build/dist/Mining.zip
	cd build/dist && zip -rv Mining.zip mining META-INF
	mv build/dist/Mining.zip build/dist/Mining.jar
	cd build/dist/ && rm -rf mining META-INF
