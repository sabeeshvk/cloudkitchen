#Dockerr build Command
docker build -t cloudkitchen/v1 . 

# Command to run docker image
docker run --env JASYPT_ENCRYPTOR_PASSWORD  -p 8080:8080 cloudkitchen/v1

# Refer  https://www.baeldung.com/ops/docker-container-environment-variables