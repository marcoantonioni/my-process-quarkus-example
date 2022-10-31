# Esempio applicazione PAM/DM Quarkus


## Creazione immagine docker

```
#=================================
# Quarkus immagine docker
#=================================

quarkus extension add 'container-image-docker'
quarkus extension remove 'container-image-docker'

# application.properties
quarkus.container-image.registry=quay.io
quarkus.container-image.username=marco_antonioni

quarkus build -Dquarkus.container-image.build=true

podman images

podman run -i --rm -p 8080:8080 quay.io/marco/my-process-quarkus-example:1.0.0-SNAPSHOT

URL=http://localhost:8080
curl -w"\n" -sX POST ${URL}/MyRequest -H 'content-type: application/json' -H 'accept: application/json' -d '{"requestData": {"key":"1", "useRules": true, "showResult": true}}' | jq .
curl -w"\n" -sX GET ${URL}/MyRequest -H 'accept: application/json' | jq .

podman login ${QUAY_URL} -u ${QUAY_USER} -p ${QUAY_PWD}

podman tag quay.io/marco/my-process-quarkus-example:1.0.0-SNAPSHOT quay.io/marco_antonioni/my-process-quarkus-example:latest
podman push quay.io/marco_antonioni/my-process-quarkus-example:latest

# CR per Openshift

apiVersion: apps/v1
kind: Deployment
metadata:
  name: my-process-quarkus-example
  namespace: my-quarkus
spec:
  selector:
    matchLabels:
      app: my-process-quarkus-example
  replicas: 1
  template:
    metadata:
      labels:
        app: my-process-quarkus-example
    spec:
      containers:
        - name: my-process-quarkus-example
          image: >-
            quay.io/marco_antonioni/my-process-quarkus-example
          ports:
            - containerPort: 8080
---
apiVersion: v1
kind: Service
metadata:
  name: my-process-quarkus-example
  namespace: my-quarkus
spec:
  selector:
    app: my-process-quarkus-example
  ports:
    - protocol: TCP
      port: 8080
      targetPort: 8080
---
kind: Route
apiVersion: route.openshift.io/v1
metadata:
  name: my-process-quarkus-example
  namespace: my-quarkus
spec:
  to:
    kind: Service
    name: my-process-quarkus-example
  port:
    targetPort: 8080

# test
URL=http://my-process-quarkus-example-my-quarkus.itzroks-120000c7nk-x2x6nw-6ccd7f378ae819553d37d5f2ee142bd6-0000.eu-gb.containers.appdomain.cloud
curl -w"\n" -sX POST ${URL}/MyRequest -H 'content-type: application/json' -H 'accept: application/json' -d '{"requestData": {"key":"1", "useRules": true, "showResult": true}}' | jq .
curl -w"\n" -sX GET ${URL}/MyRequest -H 'accept: application/json' | jq .


# reimposta estensione OpenShift
quarkus extension add 'openshift'
quarkus extension remove 'openshift'
```