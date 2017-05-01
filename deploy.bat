@echo off & setlocal enabledelayedexpansion 
title ��������ű�
set PWD=%cd%
REM Դ�����Ŀ¼
REM set SRC_PATH=D:\Works\projects\qtz-parent
set SRC_PATH=%cd%
REM SVN���ػ���Ŀ¼
set SVN_BASE_PATH=D:/Works/svnrepo
REM SVNԶ�̵�ַ
REM set SVN_REMOTE_ADDR=svn://192.168.1.250/base/dev
echo.
set ENV=test
set /p ENV=��������Ҫ����Ļ���(test,pro)Ĭ��test:
if "dev" == "%ENV%" (
    goto :continue
)
if "test" == "%ENV%" (
    goto :continue
)
if "pro" == "%ENV%" (
    goto :continue
)

call :xecho c ��֪��ʲô����׼���˳�
goto :end

:continue
echo.
echo Դ����λ��:%SRC_PATH%
set SVN_BASE_PATH=%SVN_BASE_PATH%/%ENV%
echo SVN���ػ���Ŀ¼:%SVN_BASE_PATH%
REM echo SVNԶ�̵�ַ:%SVN_REMOTE_ADDR%
echo.
if not exist %SRC_PATH% (
    echo Դ����λ�ò����ڣ��˳�����
    goto :eof
)
echo Դ��Ŀ¼����������Ŀ
ls %SRC_PATH%
echo ����ʹ��%ENV%���ñ���Դ��
set target=
set /p target=����������Ҫ�������Ŀ(allΪ������Ŀ):
if "all" == "%target%" (
    call :buildAll
) else (
    call :buildProject %target%
)
ls %SRC_PATH%
set target=
set /p target=����������Ҫ���Ƶ�SVN����Ŀ¼����Ŀ(allΪ���д����.tar.gz����Ŀ):

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

REM call :xecho c ���������ɫ
REM call :xecho a ���������ɫ
REM call :xecho f ���������ɫ
:xecho
echo. >%2&findstr /a:%1 . %2*&del %2
goto :eof

:checkDir
if exist %SRC_PATH%\%1 (
    echo %SRC_PATH%\%1
    call :xecho a ����
) else (
    echo %SRC_PATH%\%1
    call :xecho c ������
)
goto :eof

:buildProject
    if "" == "%1" (
        call :xecho a ��������׶�
        goto :eof
    )
    echo ����%SRC_PATH%\%1\pom.xml
    if exist %SRC_PATH%\%1\pom.xml (
        cd %SRC_PATH%\%1
        mvn package -DskipTests -P %ENV%
        call :xecho a �ɹ�
        cd %PWD%
    ) else (
        call :xecho c ʧ��
    )
goto :eof

:copyProject
    if "" == "%1" (
        call :xecho a �������ƽ׶�
        goto :eof
    )
    if not exist %SVN_BASE_PATH% (
        call :xecho c �����ڱ���SVNĿ¼
        call :xecho a ��������%1
        goto :eof
    )
    if exist %SRC_PATH%\%1\target\ (
        cd %SRC_PATH%\%1\target\
        for %%i in (*.tar.gz) do (
            if exist "%%~i" (
                if exist %SVN_BASE_PATH%\%1 (
                    echo ɾ��%SVN_BASE_PATH%\%1
                    rm -rf %SVN_BASE_PATH%\%1
                )
                echo ���ڽ�ѹ %%~i �� %SVN_BASE_PATH%
                tar zxf %%~i -C "%SVN_BASE_PATH%"
            )
        )
    ) else (
        echo ����%1�ĸ���
    )
goto :eof

:buildAll
    echo ����%SRC_PATH%\pom.xml
    if exist %SRC_PATH%\pom.xml (
        cd %SRC_PATH%
        mvn package -DskipTests -P %ENV%
        call :xecho a �ɹ�
        cd %PWD%
    ) else (
        call :xecho c ʧ��
    )
goto :eof