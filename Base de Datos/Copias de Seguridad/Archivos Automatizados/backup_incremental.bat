@echo off
setlocal

REM Variables
set usuario=root
set password=root
set database=foodster
set ruta_backup=C:\Users\CA2-Enero\Documents\MyGit LEBC\Integradora-8C\Base de Datos\Copias de Seguridad\Incremental

REM Obtener la posición actual del registro binario
for /f "tokens=1,2 delims= " %%a in ('mysqlbinlog --base64-output=DECODE-ROWS --verbose mysql-bin.000001 ^| find "end_log_pos"') do (
    set /a pos=%%b
)

REM Obtener la fecha y hora actual
for /f "tokens=2 delims==" %%I in ('wmic os get localdatetime /value') do set "fecha_hora=%%I"
set "fecha=%fecha_hora:~0,4%-%fecha_hora:~4,2%-%fecha_hora:~6,2%"
set "hora=%fecha_hora:~8,2%-%fecha_hora:~10,2%-%fecha_hora:~12,2%"

REM Ejecutar mysqlbinlog y mysqldump para realizar la copia de seguridad incremental
mysqlbinlog --start-position=%pos% mysql-bin.000001 | mysqldump -u %usuario% -p%password% %database% > "%ruta_backup%\backup_incremental_%fecha%_%hora%.sql"

endlocal