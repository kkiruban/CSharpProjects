set "param1=%1"
setlocal EnableDelayedExpansion
if "!param1!"=="" ( set UserRole='CSMAdmin' ) else (set UserRole='%param1%')
set _my_datetime=%date%_%time%
set _my_datetime=%_my_datetime: =_%
set _my_datetime=%_my_datetime::=%
set _my_datetime=%_my_datetime:/=_%
set _my_datetime=%_my_datetime:.=_%
set _filename=Result\cpq-cucumber-json-report.json
cd /d %~dp0
cucumber features  --dry-run -c  --format pretty --format junit --out Result\ --format json --out Result\cpq.json  --format html --out Result\cpq-html-report.html UserRole='SalesManager'
