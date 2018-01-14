#Xmrig-java-GUI  


![Alt text](screen/Main.png "Main Window") ![Alt text](screen/Term.png "Terminal Window")  

This is just a simple java made gui project to run both xmrig CPU and GPU miners together without having to open too mang terminals. Just specify the locations of the compiled binaries, set wallet and mining address and specify the mining flags.

Build:  
Download latest jdk:  

sudo apt-get install python-software-properties  
sudo add-apt-repository ppa:webupd8team/java  
sudo apt-get update  
sudo apt-get install oracle-java9-installer  

Make:  

git clone https://github.com/ghostranger047/Xmrig-java-GUI  
cd 'Xmrig-java-GUI'  
make clean  
make  
make install  

Compiled jar file created in build/dist/  
Double click to run  
