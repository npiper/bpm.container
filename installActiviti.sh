#!/bin/bash

export localIP=$(ifconfig | grep "inet " | grep -v "127\." | awk '{print $2}')

echo $localIP

repo_dir="activiti-cloud-examples"
env_file="$repo_dir/docker-compose/.env"
desired_value="DOCKER_IP=$localIP"


# Clone the Activiti/activiti-cloud-examples (check if exists)

if [ ! -d "$repo_dir" ]; then
  git clone https://github.com/Activiti/activiti-cloud-examples
fi

# Check if the .env file contains the desired value for the Local IP address
if grep -qF "DOCKER_IP=" "$env_file"; then
  # Value is already set, so update it
  sed -i '' "s|DOCKER_IP=.*|${desired_value}|" "$env_file"
  echo "Updated $env_file with $desired_value"
else
  # Value not found, so add it
  echo "$desired_value" >> "$env_file"
  echo "Added $desired_value to $env_file"
fi

cd ./activiti-cloud-examples/docker-compose
mkdir -p rabbitmq-data


sed -i '' 's/- rabbitmq-data$/- rabbitmq-data:\/var\/lib\/rabbitmq/' "./docker-compose.yml"


make modeler && make application

# modeler/password is keycloak password`
