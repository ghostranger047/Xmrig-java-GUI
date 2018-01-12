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
	cd build/ && jar cvfm dist/Mining.jar Manifest.txt mining
	
