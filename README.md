![image](https://github.com/ma3xim/isands_test_task/assets/29982333/3d255c1e-5079-41f8-96c1-cc392ae4cbc3)


Инструкция для запуска:
1. Склонировать репозиторий на локальное устройство.
2. Настроить подключение к БД Postgres. По умолчанию название БД isands_test_task. Настройки находятся в src/main/resources/application.properties. В той же папке data.sql и schema.sql для генерации БД.
3. Запустить через среду разработки или через консоль командой mvn spring-boot:run в корне проекта.
4. Перейти по адресу http://localhost:8080/swagger-ui/index.html#


Если есть проблемы с кодировкой, то придется в ручную запустить schema.sql и data.sql (и убрать drop table оттуда)
