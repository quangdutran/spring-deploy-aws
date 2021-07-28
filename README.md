This is a simple Spring app using RDS MySQL. Credentials in `application.properties` using environment properties created by Elasticbeanstalk when attaching RDS in the environment.
</br>

RDS envrionment properties should be exported `export $(cat /opt/elasticbeanstalk/deployment/env | xargs)` otherwise, `System.getenv("RDS_HOSTNAME)` for instance, returns null.

</br>

![Flow of this project](spring.png?raw=true)

