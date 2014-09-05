#!/bin/bash

#https://sebastianvoss.com/docker-mongodb-sharded-cluster.html

#create docker images
sudo docker build \ -t dev24/mongodb mongod
sudo docker build \ -t dev24/mongos mongos

#create a replica set
sudo docker run -name rs1_srv1 -P -d dev24/mongodb --noprealloc --smallfiles --replSet rs1
sudo docker run -name rs1_srv2 -P -d dev24/mongodb --noprealloc --smallfiles --replSet rs1
sudo docker run -name rs1_srv3 -P -d dev24/mongodb --noprealloc --smallfiles --replSet rs1

#initialize the replica sets
sudo docker inspect rs1_srv1
sudo docker inspect rs1_srv2
sudo docker inspect rs1_srv3

mongo --port <port>

# MongoDB shell

rs.initiate()
rs.add("<IP_of_rs1_srv2>:27017")
rs.add("<IP_of_rs1_srv3>:27017")
rs.status()

# MongoDB shell

cfg = rs.conf()
cfg.members[0].host = "<IP_of_rs1_srv1>:27017"
rs.reconfig(cfg)
rs.status()

#create some config servers
sudo docker run -name cfg1 -P -d dev24/mongodb --noprealloc --smallfiles --configsvr --dbpath /data/mongodb --port 27017

#create mongod router
sudo docker run -name mongos1 -P -d dev24/mongos --configdb <IP_of_container_cfg1>:27017 --port 27017



