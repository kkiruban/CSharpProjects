set "param1=%1"
setlocal EnableDelayedExpansion
if "!param1!"=="" ( set UserRole='CSMAdmin' ) else (set UserRole='%param1%')
set _my_datetime=%date%_%time%
set _my_datetime=%_my_datetime: =_%
set _my_datetime=%_my_datetime::=%
set _my_datetime=%_my_datetime:/=_%
set _my_datetime=%_my_datetime:.=_%
set _filename=Result\cpq-cucumber-report.html
cd /d %~dp0
cucumber features --tags @cpq-contract,@CPQ-Quote-1 --expand --format pretty  --format html --out %_filename% UserRole='SalesManager'
