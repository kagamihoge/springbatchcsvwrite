select
  EMPLOYEE_ID 
  , sysdate
  , systimestamp
from
  EMPLOYEES
where
  EMPLOYEE_ID > ?

