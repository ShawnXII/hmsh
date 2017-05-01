@echo off & setlocal enabledelayedexpansion 
title 环境部署脚本
set PWD=%cd%
REM 源码基础目录
REM set SRC_PATH=D:\Works\projects\qtz-parent
set SRC_PATH=%cd%
REM SVN本地基础目录
set SVN_BASE_PATH=D:/Works/svnrepo
REM SVN远程地址
REM set SVN_REMOTE_ADDR=svn://192.168.1.250/base/dev
echo.
set ENV=test
set /p ENV=请输入你要处理的环境(test,pro)默认test:
if "dev" == "%ENV%" (
    goto :continue
)
if "test" == "%ENV%" (
    goto :continue
)
if "pro" == "%ENV%" (
    goto :continue
)

call :xecho c 不知道什么环境准备退出
goto :end

:continue
echo.
echo 源代码位置:%SRC_PATH%
set SVN_BASE_PATH=%SVN_BASE_PATH%/%ENV%
echo SVN本地基础目录:%SVN_BASE_PATH%
REM echo SVN远程地址:%SVN_REMOTE_ADDR%
echo.
if not exist %SRC_PATH% (
    echo 源代码位置不存在，退出任务
    goto :eof
)
echo 源码目录下有以下项目
ls %SRC_PATH%
echo 正在使用%ENV%配置编译源码
set target=
set /p target=请输入你需要编译的项目(all为所有项目):
if "all" == "%target%" (
    call :buildAll
) else (
    call :buildProject %target%
)
ls %SRC_PATH%
set target=
set /p target=请输入你需要复制到SVN本地目录的项目(all为所有打包成.tar.gz的项目):

if "all" == "%target%" (
    REM call :copyProject all
    for /f "delims=" %%a in ('dir /ad /b') do (
        call :copyProject %%a
    )
) else (
    call :copyProject %target%
)
echo.

goto :end

:end
pause
goto :eof

REM call :xecho c 该行输出红色
REM call :xecho a 该行输出绿色
REM call :xecho f 该行输出白色
:xecho
echo. >%2&findstr /a:%1 . %2*&del %2
goto :eof

:checkDir
if exist %SRC_PATH%\%1 (
    echo %SRC_PATH%\%1
    call :xecho a 可用
) else (
    echo %SRC_PATH%\%1
    call :xecho c 不可用
)
goto :eof

:buildProject
    if "" == "%1" (
        call :xecho a 跳过编译阶段
        goto :eof
    )
    echo 编译%SRC_PATH%\%1\pom.xml
    if exist %SRC_PATH%\%1\pom.xml (
        cd %SRC_PATH%\%1
        mvn package -DskipTests -P %ENV%
        call :xecho a 成功
        cd %PWD%
    ) else (
        call :xecho c 失败
    )
goto :eof

:copyProject
    if "" == "%1" (
        call :xecho a 跳过复制阶段
        goto :eof
    )
    if not exist %SVN_BASE_PATH% (
        call :xecho c 不存在本地SVN目录
        call :xecho a 跳过复制%1
        goto :eof
    )
    if exist %SRC_PATH%\%1\target\ (
        cd %SRC_PATH%\%1\target\
        for %%i in (*.tar.gz) do (
            if exist "%%~i" (
                if exist %SVN_BASE_PATH%\%1 (
                    echo 删除%SVN_BASE_PATH%\%1
                    rm -rf %SVN_BASE_PATH%\%1
                )
                echo 正在解压 %%~i 到 %SVN_BASE_PATH%
                tar zxf %%~i -C "%SVN_BASE_PATH%"
            )
        )
    ) else (
        echo 跳过%1的复制
    )
goto :eof

:buildAll
    echo 编译%SRC_PATH%\pom.xml
    if exist %SRC_PATH%\pom.xml (
        cd %SRC_PATH%
        mvn package -DskipTests -P %ENV%
        call :xecho a 成功
        cd %PWD%
    ) else (
        call :xecho c 失败
    )
goto :eof