@echo off
echo NUL>_.class&&del /s /f /q *.class
cls
javac com/krzem/rsa/Main.java&&java com/krzem/rsa/Main
start /min cmd /c "echo NUL>_.class&&del /s /f /q *.class"