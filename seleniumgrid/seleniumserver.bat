@ECHO OFF
set seleniumstandaloneversion=D:\behatdownloads\behat\selenium-server-standalone-2.41.0.jar


:start

ECHO 1. chrome
ECHO 2. firefox
ECHO 3. phantomjs
set /p choice=Type the number to start selenium server.

if '%choice%'=='' ECHO "%choice%" is not valid please try again
if '%choice%'=='1' goto chrome
if '%choice%'=='2' goto firefox
if '%choice%'=='3' goto phantomjs

goto start
:chrome

                java -jar %seleniumstandaloneversion% -port 4444 -Dwebdriver.chrome.driver="D:\behat downloads\behat\lib\chromedriver.exe"
goto end

rem :iexplore

rem        java -jar  selenium-server-standalone-2.41.0.jar -port 4444 -Dwebdriver.ie.driver="D:\behat\lib\IEDriverServer.exe"
rem goto end
:phantomjs
                  phantomjs --webdriver=8643
goto end

:firefox

                java -jar %seleniumstandaloneversion% -port 4444 -Dwebdriver.firefox.profile=behat
goto end

:end
pause
exit
