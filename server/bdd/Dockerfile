FROM mysql
COPY wait-for-mysql.sh /app/wait-for-it.sh
RUN chmod +x /app/wait-for-it.sh
ENV MYSQL_ROOT_PASSWORD = 'node'
ENV MYSQL_DATABASE = 'cycling_result_java'
ENV MYSQL_PASSWORD = 'node'
ENV MYSQL_ROOT_HOST = '%'
EXPOSE 3306 3307
#ENTRYPOINT ["/bin/sh","-c","/app/wait-for-it.sh db:3306 -t 30 -- /app/start.sh"]