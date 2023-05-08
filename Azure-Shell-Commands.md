#Azure shell commands to manage the AKS cluster and deplyments

# Get the K8S credential to the local config file so kubectl can talk to AKS cluster
az aks get-credentials --resource-group aks0409 --name aksdemo

# Delete AKS cluster and Azure RG
az group delete --resource-group aks0409

# K8s deployment
kubectl apply -f https://raw.githubusercontent.com/sabeeshvk/cloudkitchen/main/cloudkitchen-deployment.yml

kubectl get pods -o wide

# K8s load balancer / reverse proxy
kubectl apply -f https://raw.githubusercontent.com/sabeeshvk/cloudkitchen/main/aks-public-svc.yml

# Get service (load balancer) details including public IP
kubectl get services -o wide

# Check logs for all pods 
kubectl logs -f  --selector app=cloudkitchen

# Check log for a container
kubectl logs -f cloudkitchen-66c98fcd6f-rtw5z  


# Log into container
kubectl exec -it cloudkitchen-66c98fcd6f-rtw5z  -- /bin/sh


# Scale down pods
kubectl scale deployment cloudkitchen --replicas=0

#  Create pods with latest docker image
kubectl rollout restart deployment cloudkitchen
