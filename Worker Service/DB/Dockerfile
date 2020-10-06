FROM mysql
ENV MYSQL_ROOT_PASSWORD=1
ENV MYSQL_DATABASE db_example
COPY ./CreateTables.sql /docker-entrypoint-initdb.d/
EXPOSE 3306
