#!/bin/sh

sudo docker logs rs1_srv1 | grep appDomain
sudo docker logs rs1_srv2 | grep appDomain