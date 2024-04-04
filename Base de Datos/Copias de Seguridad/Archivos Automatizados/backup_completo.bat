@echo off
setlocal

REM Variables
set usuario=root
set password=root
set ruta_backup=C:\Users\CA2-Enero\Documents\MyGit LEBC\Integradora-8C\Base de Datos\Copias de Seguridad\Completa

REM Obtener la fecha y hora actual
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value') do set "fecha_hora=%%I"
set "fecha=%fecha_hora:~0,4%-%fecha_hora:~4,2%-%fecha_hora:~6,2%"
set "hora=%fecha_hora:~8,2%-%fecha_hora:~10,2%-%fecha_hora:~12,2%"

REM Ejecutar mysqldump para realizar la copia de seguridad completa
mysqldump -u %usuario% -p%password% foodster > "%ruta_backup%\backup_completo_%fecha%_%hora%.sql"

endlocal