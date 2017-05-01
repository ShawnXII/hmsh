@echo off & setlocal enabledelayedexpansion
chcp 65001
rem 启动主类
set MAINCLASS=com.hmsh.admin.start.AdminBootstrap
title running mainclass -^> %MAINCLASS%
set JAVA_OPTS=-Dfile.encoding=utf-8 -Xms512m -Xmx512m -XX:NewSize=192m -XX:MaxNewSize=384m
java 2>nul
if %ERRORLEVEL%==9009 goto nojava
set CLASSPATH=classes
cd /d %~dp0\..\lib
for %%i in (*.jar) do set CLASSPATH=!CLASSPATH!;lib\%%i
cd /d %~dp0\..
echo Starting %MAINCLASS% ...OK
java %JAVA_OPTS% %MAINCLASS%
pause
goto :eof
:nojava
echo I require java but it's not installed.Aborting.
pause
goto :eof