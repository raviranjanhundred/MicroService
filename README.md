# MicroService

Run Following Command for running the above service images:

docker-compose up


For kuberenetes
Run following command 
kubectl apply -f deployment.yaml



Currency-Exchange Service Endpoint : {protocol}://{ip}:{port}/currency-exchanges/from/{from}/to/{to}

http://127.0.0.1:8000/currency-exchange/from/USD/to/INR


Currency-Conversion Service Endpoint : {protocol}://{ip}:{port}/currency-converter-feign/from/{from}/to/{to}/quantity/{quantity}


http://127.0.0.1:8100/currency-converter-feign/from/USD/to/INR/quantity/10
