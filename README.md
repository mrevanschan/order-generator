# order-generator


To run microservice in stand-alone mode, run the following in project root(exposed calls):
```
$ mvn spring-boot:run
```


Push image to docker hub for image pull for istio service mesh setup(No calls exposed)
run the following code from root:
```
$ mvn clean package
$ docker -t order-generator:latest .
$ docker tag order-generator:lastest evanschan/order-generator
$ docker push evanschan/order-generator
```


note that I used my own Docker Hub repository for the istio service mesh image pull.
