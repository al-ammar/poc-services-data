

docker-compose up -d


docker exec broker \
kafka-topics --bootstrap-server broker:9092 \
             --create \
             --topic quickstart

# list images
docker ps --format 'table {{.ID}}\t{{.Names}}\t{{.Image}}\t{{.Status}}'


docker logs kafka



## List Brokers
docker exec -ti kafka /usr/bin/broker-list.sh
## List Topics
docker exec -ti kafka /opt/kafka/bin/kafka-topics.sh --list --zookeeper zookeeper:2181
## Create a Topic
docker exec -ti kafka /opt/kafka/bin/kafka-topics.sh --create --zookeeper zookeeper:2181 --replication-factor 1 --partitions 1 --topic test2
## List Topics
docker exec -ti kafka /opt/kafka/bin/kafka-topics.sh --list --zookeeper zookeeper:2181




####### keycloak 

docker run -p 8080:8080 -e KEYCLOAK_USER=<USERNAME> -e KEYCLOAK_PASSWORD=<PASSWORD> quay.io/keycloak/keycloak:11.0.2 


docker run --name keycloak_test -p 8080:8080 \
        -e KEYCLOAK_ADMIN=admin -e KEYCLOAK_ADMIN_PASSWORD=admin \
        quay.io/keycloak/keycloak:latest \
        start-dev



docker run -itd -e POSTGRES_USER=alaa -e POSTGRES_PASSWORD=alaa \
 -p 5432:5432 -v /data:C:\Users\PRO --name postgresql postgres

docker run -itd -e POSTGRES_USER=alaa -e POSTGRES_PASSWORD=alaa -p 5432:5432 --name postgresql postgres

docker run --name pgadmin -p 5051:5051 -e "PGADMIN_DEFAULT_EMAIL=ammar.alaaeddine@gmail.com"  -e "PGADMIN_DEFAULT_PASSWORD=alaa" -d dpage/pgadmin4
 --- /var/lib/pgadmin/storage/ammar.alaaeddine_gmail.com

||| retirve ip adress
docker inspect -f '{{range .NetworkSettings.Networks}}{{.IPAddress}}{{end}}'  container_id




rm -rf node_modules
npm uninstall --save-dev angular-cli
npm install --save-dev @angular/cli@latest
npm install

npm install --save keycloak-angular@latest keycloak-js@latest
npm install --save keycloak-angular@11.0.0 keycloak-js@17.0.1

npm install --save keycloak-angular@10.0.2 keycloak-js@18.0.1



npm install @reactivex/rxjs
ng add ng-zorro-antd

ng set defaults.styleExt scss



ng update @angular/cli --from=1.7.4 --migrate-only


ng new poc --style=scss
ng set defaults.styleExt scss


ng generate module modules/general/about --routing  --module=app
ng generate module app-routing --flat --module=app
ng generate module [module-name] --routing


npm i lodash --save
npm i --save-dev @types/lodash


npm i --save-dev @types/node
npm i -g typescript@next



