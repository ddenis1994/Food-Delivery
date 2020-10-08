FROM mysql
ENV MYSQL_ROOT_PASSWORD=1
ENV MYSQL_DATABASE db_example
EXPOSE 3306:3306
COPY ./CreateTables.sql /docker-entrypoint-initdb.d/

