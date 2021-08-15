
 the api is at http://localhost:8181/myApi/run_api
 
 Three things need to be done:
*   correct maven dependencies
*   correct feature.xml : to install required feature to karaf
*   annotated the classes correctly


Need:
3. install base env
   feature:repo-add mvn:org.bitbucket.xadkile.sandwich/sandwich-base-env/LATEST/xml
   feature:install sandwich-base-env

1. install booking h2 datasource in karaf jpa example:

feature:repo-add mvn:org.apache.karaf.examples/karaf-jpa-example-features/LATEST/xml

feature:install karaf-jpa-example-datasource

feature:install karaf-jpa-example-provider-ds-eclipselink

2. create postgresql datasource:

jdbc:ds-create -dn "PostgreSQL JDBC Driver" -url jdbc:postgresql://localhost:5432/tacocloud -u abc -p Qwe123$$  tacoCloudPost

3. install firebase spring package

