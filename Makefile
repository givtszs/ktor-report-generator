# Variables
DOCKER_COMPOSE = docker compose
SERVICE = ktor-app

# Commands
.PHONY: start stop build logs restart

start:
	$(DOCKER_COMPOSE) up -d

stop:
	$(DOCKER_COMPOSE) stop

build:
	$(DOCKER_COMPOSE) build

logs:
	$(DOCKER_COMPOSE) logs -f $(SERVICE)

restart: stop start
